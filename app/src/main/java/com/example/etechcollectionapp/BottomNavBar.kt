package com.example.etechcollectionapp

import com.example.etechcollectionapp.LoginActivity
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.platform.LocalContext
import com.example.e_techcollectionapp.ui.theme.DarkGreen
import com.example.e_techcollectionapp.ui.theme.White

@Composable
fun BottomNavBar() {
    val context = LocalContext.current

    BottomAppBar(
        containerColor = White,
        contentColor = DarkGreen,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(icon = Icons.Filled.Home, label = "Home") {
                context.startActivity(Intent(context, FeedActivity::class.java))
            }
            BottomNavItem(icon = Icons.Filled.Notifications, label = "Notificações") {
                context.startActivity(Intent(context, NotificationActivity::class.java))
            }
            BottomNavItem(icon = Icons.Filled.Place, label = "Meus Locais") {
                context.startActivity(Intent(context, MyCollectionPointActivity::class.java))
            }
            BottomNavItem(icon = Icons.Filled.Add, label = "Cadastrar") {
                context.startActivity(Intent(context, CreateCollectionPointActivity::class.java))
            }
            BottomNavItem(icon = Icons.Filled.AccountCircle, label = "Meu Perfil") {
                context.startActivity(Intent(context, UpdateProfileActivity::class.java))
            }
            BottomNavItem(icon = Icons.Filled.Close, label = "Sair") {
                context.startActivity(Intent(context, LoginActivity::class.java))
            }
        }
    }
}

@Composable
fun BottomNavItem(icon: ImageVector, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Icon(imageVector = icon, contentDescription = label, tint = DarkGreen)
        Text(text = label, color = DarkGreen, fontSize = 12.sp)
    }
}
