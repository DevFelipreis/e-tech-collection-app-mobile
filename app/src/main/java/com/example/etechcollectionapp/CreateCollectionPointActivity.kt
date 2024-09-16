package com.example.etechcollectionapp

import android.os.Bundle
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_techcollectionapp.ui.theme.DarkGreen
import com.example.e_techcollectionapp.ui.theme.White
import androidx.compose.ui.tooling.preview.Preview

open class CreateCollectionPointActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateCollectionPointScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateCollectionPointScreen() {
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
            BottomNavBar() // Passar o contexto aqui
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
                        BusinessCardCreateCollectionPoint(business)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithLogo() {
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

@Composable
fun BusinessCardCreateCollectionPoint(business: Business) {
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
            // Adicione o conteúdo do cartão aqui
            Text(
                text = business.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = business.rating,
                fontSize = 16.sp,
                color = White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = business.phone,
                fontSize = 16.sp,
                color = White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = business.address,
                fontSize = 16.sp,
                color = White,
                textAlign = TextAlign.Center
            )
        }
    }
}


data class BusinessCreate(
    val name: String,
    val rating: String,
    val phone: String,
    val address: String
)

@Preview(showBackground = true)
@Composable
fun PreviewCreateScreen() {
    CreateCollectionPointScreen()
}
