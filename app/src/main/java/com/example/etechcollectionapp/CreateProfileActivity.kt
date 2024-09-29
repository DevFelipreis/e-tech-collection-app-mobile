package com.example.etechcollectionapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_techcollectionapp.ui.theme.DarkGreen
import com.example.e_techcollectionapp.ui.theme.LightGreen
import com.google.firebase.auth.FirebaseAuth

class CreateProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SetupNavGraphCreateProfile(navController)
        }
    }
}

@Composable
fun SetupNavGraphCreateProfile(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("createProfile") { CreateProfileScreen(navController) }
    }
}

private fun createProfileInFirebase(
    email: String,
    password: String,
    context: Context,
    onResult: (Boolean) -> Unit
) {
    val firebaseAuth = FirebaseAuth.getInstance()

    firebaseAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "Conta criada com sucesso!", Toast.LENGTH_SHORT).show()
                onResult(true)
            } else {
                Toast.makeText(
                    context,
                    "Falha ao criar conta: Email ou senha inválidos ou já existem",
                    Toast.LENGTH_SHORT
                ).show()
                onResult(false)
            }
        }
}

@Composable
fun CreateProfileScreen(navController: NavHostController) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

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
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 90.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Criar Conta",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = DarkGreen,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Start
            )

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
                                painter = painterResource(id = android.R.drawable.ic_dialog_email),
                                contentDescription = "Email Icon",
                                tint = DarkGreen,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            if (email.isEmpty()) {
                                Text("Digite seu email", color = DarkGreen)
                            }
                            innerTextField()
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
                    if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                        if (password == confirmPassword) {
                            createProfileInFirebase(email, password, context) { isSuccess ->
                                if (isSuccess) {
                                    val intent = Intent(context, FeedActivity::class.java)
                                    context.startActivity(intent)

                                    (context as Activity).finish()
                                }
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "As senhas não correspondem!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            context,
                            "Por favor, preencha todos os campos",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DarkGreen),
            ) {
                Text("Criar Conta", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    append("Já tem uma conta? ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("Faça login")
                    }
                },
                color = DarkGreen,
                modifier = Modifier
                    .clickable {
                        navController.navigate("login")
                    }
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center
            )
        }

        Image(
            painter = painterResource(id = R.drawable.rodape),
            contentDescription = "Rodapé",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
                .align(Alignment.BottomCenter)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCreateProfileScreen() {
    val navController = rememberNavController()
    CreateProfileScreen(navController = navController)
}
