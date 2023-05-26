package com.example.danp_team01_exam01.views

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danp_team01_exam01.R
import com.example.danp_team01_exam01.classes.Destination
import com.example.danp_team01_exam01.composables.BackgroundCircle
import com.example.danp_team01_exam01.ui.theme.ErrorColor
import com.example.danp_team01_exam01.ui.theme.PrimaryColor
import com.example.danp_team01_exam01.ui.theme.SecondaryColor
import com.example.danp_team01_exam01.viewModel.MainViewModel
import java.lang.Integer.parseInt

@Composable
fun DetailsScreen(
    viewModel: MainViewModel,
    navController: NavHostController,
    reportId: String?) {

    viewModel.getReport(parseInt(reportId!!))
    val reportSelected = viewModel.foundReport.observeAsState().value

    if (reportSelected != null) {
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
                        .clickable { navController.popBackStack() }
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

            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(32.dp))
                    .fillMaxSize()
                    .background(SecondaryColor)
                    .padding(12.dp, 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Pollution Report",
                    color = PrimaryColor,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = Color(245, 245, 245))
                        .padding(24.dp)
                        .fillMaxSize()
                        .clickable { navController.navigate(Destination.Details.route + "/" + reportId.toString()) },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.trash),
                        contentDescription = "Trash",
                        modifier = Modifier.size(100.dp)
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = reportSelected.title,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryColor
                            )
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        Text(
                            text = reportSelected.place,
                            color = PrimaryColor
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = reportSelected.description,
                            color = PrimaryColor
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Row {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                contentColor = SecondaryColor,
                                containerColor = PrimaryColor
                            ),
                            elevation = ButtonDefaults.buttonElevation(5.dp),
                            modifier = Modifier.weight(1f),
                            onClick = {
                                navController.navigate(Destination.Edit.route + "/" + reportId.toString())
                            }
                        ) {
                            Icon(
                                Icons.Default.Edit,
                                contentDescription = "Edit",
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "Edit", color = SecondaryColor, fontSize = 16.sp)
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                contentColor = SecondaryColor,
                                containerColor = ErrorColor
                            ),
                            elevation = ButtonDefaults.buttonElevation(5.dp),
                            modifier = Modifier.weight(1f),
                            onClick = { navController.popBackStack() }
                        ) {
                            Icon(
                                Icons.Default.Delete,
                                contentDescription = "Delete",
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "Delete", color = SecondaryColor, fontSize = 16.sp)
                        }
                    }
                }
            }

        }
    }
}