@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.danp_team01_exam01.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danp_team01_exam01.classes.Destination
import com.example.danp_team01_exam01.model.Report
import com.example.danp_team01_exam01.ui.theme.PrimaryColor
import com.example.danp_team01_exam01.ui.theme.SecondaryColor
import com.example.danp_team01_exam01.viewModel.MainViewModel
import java.lang.Integer.parseInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditReportForm(
    viewModel: MainViewModel,
    navController: NavHostController,
    reportId: String?) {

    viewModel.getReport(parseInt(reportId!!))
    val reportSelected = viewModel.foundReport.observeAsState().value!!

    var title by remember { mutableStateOf("${reportSelected.title}") }
    var img by remember { mutableStateOf("${reportSelected.imageUrl}") }
    var district by remember { mutableStateOf("${reportSelected.place}") }
    var description by remember { mutableStateOf("${reportSelected.description}") }

    BackgroundCircle()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(24.dp, 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = "Back Home",
                tint = SecondaryColor,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { navController.navigate(Destination.Home.route) }
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                fontSize = 24.sp,
                color = SecondaryColor,
                text = "Welcome ${reportSelected.reportUserEmail}",
                modifier = Modifier.weight(1f)
            )

            Icon(
                Icons.Default.ExitToApp,
                contentDescription = "Logout",
                tint = SecondaryColor,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.navigate(Destination.Login.route) }
            )
        }

        // TODO: Fill with Report data
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .fillMaxSize()
                .background(SecondaryColor)
                .padding(8.dp, 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Edit Report",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor,
                )

                Spacer(modifier = Modifier.height(16.dp))

                Column {
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        label = { Text(text = "Title: ${reportSelected.title}") },
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
                        onValueChange = { img = it },
                        singleLine = true,
                        value = img
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        label = { Text(text = "District: ${reportSelected.place}")},
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
                        label = { Text(text = "Description: ${reportSelected.description}") },
                        maxLines = 1,
                        modifier = Modifier.fillMaxWidth(),
                        onValueChange = { description = it },
                        singleLine = true,
                        value = description
                    )

                    Spacer(modifier = Modifier.height(48.dp))

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            contentColor = SecondaryColor,
                            containerColor = PrimaryColor
                        ),
                        elevation = ButtonDefaults.buttonElevation(5.dp),
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            viewModel.updateReport(Report(
                                id = reportSelected.id,
                                title = title,
                                imageUrl = img,
                                place = district,
                                description = description,
                                reportUserEmail = reportSelected.reportUserEmail
                            ))
                            navController.popBackStack()
                        }
                    ) {
                        Text(text = "Save", color = SecondaryColor, fontSize = 16.sp)
                    }
                }
            }
        }
    }
}