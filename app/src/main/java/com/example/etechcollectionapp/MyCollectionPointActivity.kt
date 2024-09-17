package com.example.etechcollectionapp

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_techcollectionapp.ui.theme.DarkGreen
import com.example.e_techcollectionapp.ui.theme.White
import com.example.e_techcollectionapp.ui.theme.Yellow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.tooling.preview.Preview

open class MyCollectionPointActivity : ComponentActivity() {
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
                    BusinessMyCollectionPoint(
                        "Cel-Tech Eletronicos", "Em breve",
                        "021 99999-9999",
                        "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                    ),
                    BusinessMyCollectionPoint(
                        "Matias Tech", "Em breve",
                        "021 99999-9999",
                        "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                    ),
                    BusinessMyCollectionPoint(
                        "Rodri Tech", "Em breve",
                        "021 99999-9999",
                        "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
                    ),
                    BusinessMyCollectionPoint(
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
                        BusinessCardMyCollectionPoint(business)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    )
}

@Composable
fun BusinessCardMyCollectionPoint(business: BusinessMyCollectionPoint) {
    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = DarkGreen
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 64.dp)
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
            }

            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            ) {
                IconButton(
                    onClick = {
                        Toast.makeText(context, "Editar ${business.name}", Toast.LENGTH_SHORT).show()
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
                        Toast.makeText(context, "Apagar ${business.name}", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Apagar",
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
fun PreviewMyCollectionPointScreen() {
    MyCollectionPointScreen()
}
