import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

data class Company(val name: String, val address: String, val phone: String)

val companies = listOf(
    Company("e-Tech Collection", "Gondo do Ioda alatronico", "123-456-789"),
    Company("Cel Oliveira", "Centro - Rio de Janeiro - RJ", "987-654-321"),
    Company("Matias Tech", "Centro - Rio de Janeiro - RJ", "456-789-123"),
    Company("Rodri Tech", "Centro - Rio de Janeiro - RJ", "321-654-987")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                CompanyList(companies)
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}

@Composable
fun CompanyList(companies: List<Company>) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(companies) { company ->
            CompanyItem(company)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun CompanyItem(company: Company) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = company.name, style = MaterialTheme.typography.bodyLarge)
        Text(text = company.address, style = MaterialTheme.typography.bodySmall)
        Text(text = company.phone, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        CompanyList(companies)
    }
}
