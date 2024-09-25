package com.example.etechcollectionapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_techcollectionapp.ui.theme.DarkGreen
import com.example.e_techcollectionapp.ui.theme.LightGreen

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
fun CreateCollectionPointScreen(onSubmit: (String, String, String) -> Unit = { _, _, _ -> }) {
    val context = LocalContext.current
    var localName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var acceptedItems by remember { mutableStateOf("") }
    var hours by remember { mutableStateOf("") }
    var showLocalNameError by remember { mutableStateOf(false) }
    var showPhoneNumberError by remember { mutableStateOf(false) }
    var showAddressError by remember { mutableStateOf(false) }
    var showCepError by remember { mutableStateOf(false) }
    var showAcceptedItemsError by remember { mutableStateOf(false) }
    var showHoursError by remember { mutableStateOf(false) }

    fun validateFields(): Boolean {
        showLocalNameError = localName.isEmpty()
        showPhoneNumberError = phoneNumber.isEmpty()
        showAddressError = address.isEmpty()
        showCepError = address.isEmpty()

        return !(showLocalNameError || showPhoneNumberError || showAddressError || showCepError || showAcceptedItemsError)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.perfil2),
                contentDescription = "perfil",
                modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth(),
                alignment = Alignment.TopEnd
            )
            Text(
                text = "Olá, User",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = DarkGreen,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                textAlign = TextAlign.End
            )

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Cadastrar Local de Coleta",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkGreen,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .padding(top = 32.dp),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(24.dp))

                BasicTextField(
                    value = localName,
                    onValueChange = { localName = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White),
                    decorationBox = { innerTextField ->
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.ic_menu_myplaces),
                                    contentDescription = "Local Name Icon",
                                    tint = DarkGreen,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                if (localName.isEmpty()) {
                                    Text("Digite o nome do local", color = DarkGreen)
                                }
                                innerTextField()
                            }
                            if (showLocalNameError) {
                                Text("Campo obrigatório", color = Color.Red, fontSize = 12.sp)
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(color = LightGreen)
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(22.dp))


                BasicTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White),
                    decorationBox = { innerTextField ->
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.ic_menu_call),
                                    contentDescription = "Phone Icon",
                                    tint = DarkGreen,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                if (phoneNumber.isEmpty()) {
                                    Text("Digite o número de telefone", color = DarkGreen)
                                }
                                innerTextField()
                            }
                            if (showPhoneNumberError) {
                                Text("Campo obrigatório", color = Color.Red, fontSize = 12.sp)
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(color = LightGreen)
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(22.dp))

                BasicTextField(
                    value = address,
                    onValueChange = { address = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White),
                    decorationBox = { innerTextField ->
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.ic_menu_mylocation),
                                    contentDescription = "Address Icon",
                                    tint = DarkGreen,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                if (address.isEmpty()) {
                                    Text("Digite o endereço", color = DarkGreen)
                                }
                                innerTextField()
                            }
                            if (showAddressError) {
                                Text("Campo obrigatório", color = Color.Red, fontSize = 12.sp)
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(color = LightGreen)
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(22.dp))

                BasicTextField(
                    value = cep,
                    onValueChange = { cep = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White),
                    decorationBox = { innerTextField ->
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.ic_menu_mylocation),
                                    contentDescription = "Address Icon",
                                    tint = DarkGreen,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                if (address.isEmpty()) {
                                    Text("Digite o CEP", color = DarkGreen)
                                }
                                innerTextField()
                            }
                            if (showCepError) {
                                Text("Campo obrigatório", color = Color.Red, fontSize = 12.sp)
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(color = LightGreen)
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(22.dp))

                BasicTextField(
                    value = acceptedItems,
                    onValueChange = { acceptedItems = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White),
                    decorationBox = { innerTextField ->
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.checkbox_on_background),
                                    contentDescription = "Iten Icon",
                                    tint = DarkGreen,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                if (address.isEmpty()) {
                                    Text("Itens Aceitos", color = DarkGreen)
                                }
                                innerTextField()
                            }
                            if (showAddressError) {
                                Text("Campo obrigatório", color = Color.Red, fontSize = 12.sp)
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(color = LightGreen)
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(22.dp))

                BasicTextField(
                    value = hours,
                    onValueChange = { hours = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White),
                    decorationBox = { innerTextField ->
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.ic_menu_recent_history),
                                    contentDescription = "Hours Icon",
                                    tint = DarkGreen,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                if (hours.isEmpty()) {
                                    Text("Horário de Funcionamento", color = DarkGreen)
                                }
                                innerTextField()
                            }
                            if (showHoursError) {
                                Text("Campo obrigatório", color = Color.Red, fontSize = 12.sp)
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(color = LightGreen)
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        if (validateFields()) {
                            onSubmit(localName, phoneNumber, address)
                        } else {
                            Toast.makeText(
                                context,
                                "Preencha todos os campos obrigatórios!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkGreen),
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.ic_menu_send),
                            contentDescription = "Register Icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Cadastrar", color = Color.White)
                    }
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.rodape),
            contentDescription = "Footer",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCreateCollectionPointScreen() {
    CreateCollectionPointScreen()
}

