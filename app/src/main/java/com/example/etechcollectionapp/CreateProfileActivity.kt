package com.example.etechcollectionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_techcollectionapp.ui.theme.DarkGreen
import com.example.e_techcollectionapp.ui.theme.LightGreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class CreateProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateProfileScreen { fullName, email, phoneNumber, password, confirmPassword ->
                createProfileInFirebase(fullName, email, phoneNumber, password, confirmPassword)
            }
        }
    }

    private fun createProfileInFirebase(
        fullName: String,
        email: String,
        phoneNumber: String,
        password: String,
        confirmPassword: String,
    ) {
        val firebaseAuth = FirebaseAuth.getInstance()

        if (fullName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || password.isEmpty()) {
            showToast("Todos os campos devem ser preenchidos!")
            return
        }
        if (password != confirmPassword) {
            showToast("Senhas são diferentes!")
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    val database = FirebaseDatabase.getInstance()
                    val userRef = database.getReference("user").child(user!!.uid)

                    val userMap = mapOf(
                        "fullName" to fullName,
                        "phoneNumber" to phoneNumber
                    )

                    userRef.setValue(userMap)
                        .addOnCompleteListener { dbTask ->
                            if (dbTask.isSuccessful) {
                                showToast("Cadastrado com sucesso!.")
                                startActivity(Intent(this, FeedActivity::class.java))
                            } else {
                                showToast("Falha ao cadastrar. Por favor, tente novamente")
                            }
                        }
                } else {
                    showToast("Falha ao cadastrar. Por favor, confira seus dados")
                }
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateProfileScreen(onSubmit: (String, String, String, String, String) -> Unit = { _, _, _, _, _ -> }) {
    val context = LocalContext.current
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showFullNameError by remember { mutableStateOf(false) }
    var showEmailError by remember { mutableStateOf(false) }
    var showPhoneNumberError by remember { mutableStateOf(false) }
    var showPasswordError by remember { mutableStateOf(false) }
    var showConfirmPasswordError by remember { mutableStateOf(false) }

    fun validateFields(): Boolean {
        showFullNameError = fullName.isEmpty()
        showEmailError = email.isEmpty()
        showPhoneNumberError = phoneNumber.isEmpty()
        showPasswordError = password.isEmpty()
        showConfirmPasswordError = confirmPassword.isEmpty()

        return !(showFullNameError || showEmailError ||
                showPhoneNumberError || showPasswordError || showConfirmPasswordError)
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
                painter = painterResource(id = R.drawable.perfil2
                ),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 90.dp)
            )

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Editar perfil",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkGreen,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .padding(top = 32.dp),
                    textAlign = TextAlign.Start
                )

                BasicTextField(
                    value = fullName,
                    onValueChange = { fullName = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White),
                    decorationBox = { innerTextField ->
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.ic_menu_myplaces),
                                    contentDescription = "Full Name Icon",
                                    tint = DarkGreen,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                if (fullName.isEmpty()) {
                                    Text("Editar nome completo", color = DarkGreen)
                                }
                                innerTextField()
                            }
                            if (showFullNameError) {
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

                Spacer(modifier = Modifier.height(16.dp))

                BasicTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White),
                    decorationBox = { innerTextField ->
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.ic_menu_call),
                                    contentDescription = "Email Icon",
                                    tint = DarkGreen,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                if (email.isEmpty()) {
                                    Text("Editar número de celular", color = DarkGreen)
                                }
                                innerTextField()
                            }
                            if (showEmailError) {
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

                Spacer(modifier = Modifier.height(16.dp))

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
                                    painter = painterResource(id = android.R.drawable.ic_dialog_email),
                                    contentDescription = "Phone Icon",
                                    tint = DarkGreen,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                if (phoneNumber.isEmpty()) {
                                    Text("Editar email", color = DarkGreen)
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

                Spacer(modifier = Modifier.height(16.dp))

                BasicTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White),
                    visualTransformation = PasswordVisualTransformation(),
                    decorationBox = { innerTextField ->
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.ic_lock_idle_lock),
                                    contentDescription = "Password Icon",
                                    tint = DarkGreen,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                if (password.isEmpty()) {
                                    Text("Digite sua senha", color = DarkGreen)
                                }
                                innerTextField()
                            }
                            if (showPasswordError) {
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

                Spacer(modifier = Modifier.height(16.dp))

                BasicTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White),
                    visualTransformation = PasswordVisualTransformation(),
                    decorationBox = { innerTextField ->
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.ic_lock_idle_lock),
                                    contentDescription = "Confirm Password Icon",
                                    tint = DarkGreen,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                if (confirmPassword.isEmpty()) {
                                    Text("Confirme sua senha", color = DarkGreen)
                                }
                                innerTextField()
                            }
                            if (showConfirmPasswordError) {
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

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (validateFields()) {
                            if (password == confirmPassword) {
                                onSubmit(fullName, email, phoneNumber, password, confirmPassword)
                            } else {
                                Toast.makeText(context, "Senhas são diferentes!", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(context, "Preencha todos os campos obrigatórios!", Toast.LENGTH_SHORT).show()
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
                        Text("Atualizar", color = Color.White)
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
fun PreviewCreateProfileScreen() {
    CreateProfileScreen { _, _, _, _, _ ->
    }
}
