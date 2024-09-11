package com.example.e_techcollectionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
import com.example.etechcollectionapp.R
import kotlinx.coroutines.launch

class Feed : ComponentActivity() {
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
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent {
                scope.launch { drawerState.close() }
            }
        },
        content = {
            Scaffold(
                topBar = {
                    Box {
                        TopAppBar(
                            title = { },
                            navigationIcon = {
                                IconButton(onClick = {
                                    scope.launch {
                                        if (drawerState.isClosed) drawerState.open()
                                        else drawerState.close()
                                    }
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "Menu",
                                        tint = DarkGreen
                                    )
                                }
                            },
                            modifier = Modifier
                                .height(72.dp)
                                .fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "Logo",
                                modifier = Modifier
                                    .height(48.dp)
                                    .widthIn(max = 180.dp)
                            )
                        }
                    }
                },
                content = { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        val businesses = listOf(
                            Business(
                                "Cel-Tech Eletronicos", 4,
                                "021 99999-9999",
                                "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                            ),
                            Business(
                                "Matias Tech", 3,
                                "021 99999-9999",
                                "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                            ),
                            Business(
                                "Rodri Tech", 5,
                                "021 99999-9999",
                                "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                            ),
                            Business(
                                "Apple Silva", 4,
                                "021 99999-9999",
                                "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                            )
                        )

                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 18.dp)
                        ) {
                            items(businesses) { business ->
                                BusinessCard(business)
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }

                        baseboard()
                    }
                }
            )
        }
    )
}

@Composable
fun baseboard() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.rodape),
            contentDescription = "Rodapé",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun DrawerContent(onCloseDrawer: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Option 1", modifier = Modifier.padding(8.dp))
        Text("Option 2", modifier = Modifier.padding(8.dp))
        Text("Option 3", modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onCloseDrawer) {
            Text("Fechar Menu")
        }
    }
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
                Button(
                    onClick = { /* Lógica para mostrar itens aceitos */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Yellow),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Aceita", color = DarkGreen)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* Lógica para ver no mapa */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Yellow),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Local", color = DarkGreen)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* Lógica para mostrar horário de funcionamento */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Yellow),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Horários", color = DarkGreen)
                }
            }
        }
    }
}

data class Business(
    val name: String,
    val rating: Int,
    val phone: String,
    val address: String
)

@Preview(showBackground = true)
@Composable
fun PreviewFeedScreen() {
    FeedScreen()
}
