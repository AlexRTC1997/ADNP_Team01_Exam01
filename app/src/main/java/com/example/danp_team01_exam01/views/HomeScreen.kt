package com.example.danp_team01_exam01.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.example.danp_team01_exam01.composables.RegisterReportForm
import com.example.danp_team01_exam01.model.Report
import com.example.danp_team01_exam01.ui.theme.BlackColor
import com.example.danp_team01_exam01.ui.theme.PrimaryColor
import com.example.danp_team01_exam01.ui.theme.SecondaryColor
import com.example.danp_team01_exam01.viewModel.MainViewModel


@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    navController: NavHostController,
    userEmail: String?) {

    var showDialog by rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(Unit){
        viewModel.userWithReports(userEmail!!)
    }
    val reportsList: List<Report> by viewModel.allReports.observeAsState(initial = listOf())

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
        ) {
            Text(
                fontSize = 24.sp,
                color = SecondaryColor,
                text = "Welcome $userEmail",
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
                .padding(8.dp, 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pollution Reports",
                color = PrimaryColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (reportsList.isEmpty()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.empty),
                        contentDescription = "Empty",
                        modifier = Modifier.size(300.dp)
                    )

                    Text(text = "No reports registered yet", color = PrimaryColor, fontSize = 18.sp)
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(all = 4.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(reportsList) {
                    ReportCard(report = it, navController = navController)
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(
            containerColor = PrimaryColor,
            contentColor = SecondaryColor,
            onClick = { showDialog = true },
            shape = RoundedCornerShape(50.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }

    RegisterReportForm(viewModel = viewModel, showDialog = showDialog, { showDialog = false }, {
            // Save in DataBase
            // TODO: Comment or delete next function when SAVE IN DATABASE is added
            showDialog = false }, userEmail)

}

@Composable
fun ReportCard( report : Report, navController: NavHostController) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color(245, 245, 245))
            .padding(12.dp, 8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(
                    Destination.Details.routeWithArgs(
                        report.id.toString()
                    )
                ) },
        verticalAlignment = Alignment.CenterVertically
//            .shadow(1.dp),

    ) {
        Image(
            painter = painterResource(id = R.drawable.trash),
            contentDescription = "Trash",
            modifier = Modifier.size(50.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = report.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = PrimaryColor
            )
            Text(
                text = report.place,
                fontSize = 14.sp,
                color = PrimaryColor
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.fillMaxHeight()) {
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Go Details",
                modifier = Modifier.size(24.dp),
                tint = BlackColor
            )
        }
    }
}