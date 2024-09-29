package com.example.etechcollectionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_techcollectionapp.ui.theme.DarkGreen
import com.example.e_techcollectionapp.ui.theme.White
import androidx.compose.ui.tooling.preview.Preview

open class NotificationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotificationScreen()
        }
    }
}

@Composable
fun NotificationScreen() {
    val context = LocalContext.current

    Scaffold(
        topBar = { TopBarWithLogoNotification() },
        bottomBar = { BottomNavBar() },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Estamos em manutenção",
                    fontSize = 24.sp,
                    color = DarkGreen,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithLogoNotification() {
    TopAppBar(
        title = { },
        actions = {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(72.dp)
                )
            }
        },
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = White)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewNotificationScreen() {
    NotificationScreen()
}