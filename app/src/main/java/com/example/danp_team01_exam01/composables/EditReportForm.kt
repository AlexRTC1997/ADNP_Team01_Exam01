@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.danp_team01_exam01.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.danp_team01_exam01.ui.theme.PrimaryColor
import com.example.danp_team01_exam01.ui.theme.SecondaryColor

@Composable
fun EditRegisterForm(showDialog: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var photo by remember { mutableStateOf("") }
    var district by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    if (showDialog) {
        Dialog(
            onDismissRequest = { onDismiss() },
//            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Card(
//                elevation = 5.dp,
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
                    Text(text = "Edit Report", fontSize = 22.sp, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(16.dp))

                    Column {
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

                        // TODO: Change Input to Image Input ?
                        OutlinedTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            label = { Text(text = "Photo: ") },
                            maxLines = 1,
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = { photo = it },
                            singleLine = true,
                            value = photo
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
                            onClick = { onConfirm() }
                        ) {
                            Text(text = "Register", color = SecondaryColor, fontSize = 16.sp)
                        }
                    }

                }
            }
        }
    }
}