@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.danp_team01_exam01.composables

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.danp_team01_exam01.model.Report
import com.example.danp_team01_exam01.ui.theme.PrimaryColor
import com.example.danp_team01_exam01.ui.theme.SecondaryColor
import com.example.danp_team01_exam01.viewModel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterReportForm(
    viewModel: MainViewModel = hiltViewModel(),
    showDialog: Boolean, onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    userId: String?) {

    var title by remember { mutableStateOf("") }
    var district by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ){ uri: Uri? -> imageUri = uri }

    if (showDialog) {
        Dialog(
            onDismissRequest = { onDismiss() },
//            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Card(
//              elevation = 1.dp,
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .padding(8.dp)
                    .border(1.dp, color = SecondaryColor, shape = RoundedCornerShape(15.dp))
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Register Report", fontSize = 22.sp, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(16.dp))

                    Column {
                        Row {
                            Button(onClick = {
                                galleryLauncher.launch("image/*")
                            }) {
                                Text(text = "Pick image")
                            }

                            var text = ""
                            if (imageUri != null) {
                                text = "Great!"
                            }

                            Spacer(modifier = Modifier.width(20.dp))

                            Text(text = text)
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            label = { Text(text = "Title: ") },
                            maxLines = 1,
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = { title = it },
                            singleLine = true,
                            value = title
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            label = { Text(text = "District: ") },
                            maxLines = 1,
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = { district = it },
                            singleLine = true,
                            value = district
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // TODO: Change to TextArea
                        OutlinedTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            label = { Text(text = "Description: ") },
                            maxLines = 1,
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = { description = it },
                            singleLine = true,
                            value = description
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                contentColor = SecondaryColor,
                                containerColor = PrimaryColor
                            ),
                            elevation = ButtonDefaults.buttonElevation(5.dp),
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                viewModel.insertReport(Report( title = title, imageUrl = imageUri.toString(), description = description, place = district, reportUserEmail = userId!!))
                                onConfirm()
                            }
                        ) {
                            Text(text = "Register", color = SecondaryColor, fontSize = 16.sp)
                        }
                    }

                }
            }
        }
    }
}







