package com.example.etechcollectionapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import com.example.e_techcollectionapp.ui.theme.DarkGreen


@Composable
fun DrawerContent(onOptionClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .width(300.dp)
            .background(color = DarkGreen)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = "Perfil",
                modifier = Modifier
                    .size(64.dp)
                    .padding(8.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = "Meu Nome",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Text(
                    text = "Minha Conta",
                    style = TextStyle(
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )
            }
        }

        DrawerOption("Início", Icons.Filled.Home) { onOptionClick("home") }
        DrawerOption("Notificações", Icons.Filled.Notifications) { onOptionClick("notifications") }
        DrawerOption(
            "Meus locais de coleta",
            Icons.Filled.Place
        ) { onOptionClick("collection_locations") }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { onOptionClick("logout") },
            colors = ButtonDefaults.buttonColors(containerColor = DarkGreen),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Logout",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Sair", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@Composable
fun DrawerOption(text: String, icon: ImageVector, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text, style = TextStyle(fontSize = 16.sp, color = Color.White))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDrawerContent() {
    DrawerContent {}
}
