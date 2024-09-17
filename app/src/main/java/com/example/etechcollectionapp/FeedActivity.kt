package com.example.etechcollectionapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_techcollectionapp.ui.theme.DarkGreen
import com.example.e_techcollectionapp.ui.theme.White
import com.example.e_techcollectionapp.ui.theme.Yellow
import androidx.compose.ui.platform.LocalContext

open class FeedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeedScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen() {
    val context = LocalContext.current

    Scaffold(
        topBar = {
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
        },
        bottomBar = {
            BottomNavBar()
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                val businesses = listOf(
                    Business(
                        "Cel-Tech Eletronicos", "Em breve",
                        "021 99999-9999",
                        "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                    ),
                    Business(
                        "Matias Tech", "Em breve",
                        "021 99999-9999",
                        "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                    ),
                    Business(
                        "Rodri Tech", "Em breve",
                        "021 99999-9999",
                        "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                    ),
                    Business(
                        "Apple Silva", "Em breve",
                        "021 99999-9999",
                        "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                    )
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp)
                        .padding(top = 16.dp)
                        .padding(end = 16.dp)
                ) {
                    items(businesses) { business ->
                        BusinessCard(business)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    )
}

@Composable
fun BusinessCard(business: Business) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = DarkGreen
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = business.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Yellow,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Rating: ${business.rating}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Yellow,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = business.phone,
                color = White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = business.address,
                color = White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                var showItems by remember { mutableStateOf(false) }
                val acceptedItems = listOf("Celular", "Computador", "Bateria")

                Button(
                    onClick = { showItems = !showItems },
                    colors = ButtonDefaults.buttonColors(containerColor = Yellow),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Aceita", color = DarkGreen)
                }

                if (showItems) {
                    Column {
                        acceptedItems.forEach { item ->
                            Text(text = item)
                        }
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                val context = LocalContext.current
                val googleMapsIntentUri = Uri.parse("geo:0,0?q=${business.address}")

                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, googleMapsIntentUri).apply {
                            setPackage("com.google.android.apps.maps")
                        }

                        if (intent.resolveActivity(context.packageManager) != null) {
                            context.startActivity(intent)
                        } else {
                            Toast.makeText(
                                context,
                                "Google Maps não está disponível",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Yellow),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Mapa", color = DarkGreen)
                }

                Spacer(modifier = Modifier.width(8.dp))

                var showSchedule by remember { mutableStateOf(false) }
                val schedule = listOf("Seg-Sex: 9h às 18h", "Sáb: 9h às 13h")

                Button(
                    onClick = { showSchedule = !showSchedule },
                    colors = ButtonDefaults.buttonColors(containerColor = Yellow),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Horário", color = DarkGreen)
                }

                if (showSchedule) {
                    Column {
                        schedule.forEach { time ->
                            Text(text = time)
                        }
                    }
                }
            }
        }
    }
}

data class Business(
    val name: String,
    val rating: String,
    val phone: String,
    val address: String
)

@Preview(showBackground = true)
@Composable
fun PreviewFeedScreen() {
    FeedScreen()
}
