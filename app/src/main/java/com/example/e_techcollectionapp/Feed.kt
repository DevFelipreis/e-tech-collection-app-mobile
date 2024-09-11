import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_techcollectionapp.R
import com.example.e_techcollectionapp.ui.theme.DarkGreen
import com.example.e_techcollectionapp.ui.theme.White
import com.example.e_techcollectionapp.ui.theme.Yellow

class Feed : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeedScreen()
        }
    }
}

@Composable
fun FeedScreen() {
    val businesses = listOf(
        Business(
            "Cel-Tech Eletronicos",
            4,
            "021 99999-9999",
            "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
        ),
        Business(
            "Matias Tech",
            3,
            "021 99999-9999",
            "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
        ),
        Business(
            "Rodri Tech",
            5,
            "021 99999-9999",
            "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
        ),
        Business(
            "Apple Silva",
            4,
            "021 99999-9999",
            "Rua A - Oliveira - Centro - Rio de Janeiro - RJ"
        )
    )

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(173.dp)
                        .height(81.95.dp)
                )
            }
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(end = 16.dp)
                    .padding(start = 16.dp)


            ) {
                LazyColumn {
                    items(businesses) { business ->
                        BusinessCard(business)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.rodape),
                    contentDescription = "Rodapé",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(81.95.dp)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewFeedScreen() {
    FeedScreen()
}

@Composable
fun BusinessCard(business: Business) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = DarkGreen
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(business.name, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Yellow)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Rating: ${business.rating}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(business.phone, color = White)
            Spacer(modifier = Modifier.height(8.dp))
            Text(business.address, color = White)
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Button(
                    onClick = { /* Lógica para ligar */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Yellow,
                    )
                ) {
                    Text("Itens Aceitos", color = DarkGreen)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* Lógica para ver no mapa */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Yellow,
                    )
                ) {
                    Text("Ver no mapa", color = DarkGreen)
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
