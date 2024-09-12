import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete

@Composable
fun DrawerContent(onCloseDrawer: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            "Menu Navegação Drawer",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        DrawerOption("Início", Icons.Filled.Home)
        DrawerOption("Notificações", Icons.Filled.Notifications)
        DrawerOption("Meus locais de coleta", Icons.Filled.Place)
        DrawerOption("Cadastrar locais de coleta", Icons.Filled.Add)
        DrawerOption("Meus Descartes", Icons.Filled.Delete)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onCloseDrawer, modifier = Modifier.fillMaxWidth()) {
            Text("Sair")
        }
    }
}

@Composable
fun DrawerOption(text: String, icon: ImageVector) {
    Row(modifier = Modifier.padding(8.dp)) {
        Icon(imageVector = icon, contentDescription = text, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text, style = TextStyle(fontSize = 16.sp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDrawerContent() {
    DrawerContent {}
}
