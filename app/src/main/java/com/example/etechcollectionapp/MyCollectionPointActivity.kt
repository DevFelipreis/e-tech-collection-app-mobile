package com.example.etechcollectionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Delete
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
import kotlinx.coroutines.launch

open class MyCollectionPoint : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCollectionPointScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCollectionPointScreen() {
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
                            BusinessMyCollectionPoint(
                                "Cel-Tech Eletrônicos", "Em Breve",
                                "021 99999-9999",
                                "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                            ),
                            BusinessMyCollectionPoint(
                                "Matias Tech", "Em Breve",
                                "021 99999-9999",
                                "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                            ),
                            BusinessMyCollectionPoint(
                                "Jofá Tech", "Em Breve",
                                "021 99999-9999",
                                "Rua A - Travessa - Interior - São Paulo - SP"
                            )
                        )

                        val footerHeight = 50.dp

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 18.dp)
                                    .padding(bottom = footerHeight)
                            ) {
                                items(businesses) { business ->
                                    BusinessCardMyCollectionPoint(business)
                                    Spacer(modifier = Modifier.height(16.dp))
                                }
                            }

                            baseboardMyCollectionPoint(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(footerHeight)
                                    .align(Alignment.BottomCenter)
                            )
                        }
                    }
                }
            )
        }
    )
}

@Composable
fun baseboardMyCollectionPoint(modifier: Modifier = Modifier) {
    val footerHeight = 60.dp

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(footerHeight)
            .background(color = White)
            .border(2.dp, DarkGreen)
            .padding(8.dp)
    ) {
        Text(
            text = "ANUNCIE AQUI",
            color = DarkGreen,
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        )
    }
}

@Composable
fun BusinessCardMyCollectionPoint(business: BusinessMyCollectionPoint) {
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
                text = "Telefone: ${business.phone}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Endereço: ${business.address}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                IconButton(
                    onClick = {
                        // lógica
                    },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar",
                        tint = Yellow
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = {
                        // lógica
                    },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Excluir",
                        tint = Yellow
                    )
                }
            }
        }
    }
}

data class BusinessMyCollectionPoint(
    val name: String,
    val rating: String,
    val phone: String,
    val address: String
)

@Preview(showBackground = true)
@Composable
fun PreviewFeedScreenMyCollectionPoint() {
    MyCollectionPointScreen()
}