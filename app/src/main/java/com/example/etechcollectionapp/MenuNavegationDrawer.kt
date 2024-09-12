import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import com.example.e_techcollectionapp.ui.theme.DarkGreen
import com.example.etechcollectionapp.R

@Composable
fun DrawerContent(onCloseDrawer: () -> Unit) {
    Column(
        modifier = Modifier
            .width(300.dp)
            .background(color = DarkGreen)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.perfil),
            contentDescription = "Perfil",
            modifier = Modifier
                .size(64.dp)
                .padding(8.dp)
        )
        Text(
            "Meu Nome",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White),
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(
            "Minha Conta",
            style = TextStyle(fontSize = 21.sp, fontWeight = FontWeight.Normal, color = Color.White),
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        DrawerOption("Início", Icons.Filled.Home)
        DrawerOption("Notificações", Icons.Filled.Notifications)
        DrawerOption("Meus locais de coleta", Icons.Filled.Place)
        DrawerOption("Cadastrar locais de coleta", Icons.Filled.Add)
        DrawerOption("Meus Descartes", Icons.Filled.Delete)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = onCloseDrawer,
                modifier = Modifier.height(32.dp)
            ) {
                Text("Sair")
            }
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
fun DrawerOption(text: String, icon: ImageVector) {
    Row(modifier = Modifier.padding(8.dp)) {
        Icon(imageVector = icon, contentDescription = text, tint = Color.White, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text, style = TextStyle(fontSize = 16.sp, color = Color.White))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDrawerContent() {
    DrawerContent {}
}
