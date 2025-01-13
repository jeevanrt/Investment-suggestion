package jeevanS3340278.investmentsugg.development

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import com.google.firebase.database.FirebaseDatabase
import jeevanS3340278.investmentsugg.development.ui.theme.StockUserData

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RegisterScreen()
        }
    }
}


@Composable
fun RegisterScreen() {
    var investorMail by remember { mutableStateOf("") }
    var investorAuthCode by remember { mutableStateOf("") }
    var investorAuthCodeConfirm by remember { mutableStateOf("") }
    var investorName by remember { mutableStateOf("") }
    var investorQalification by remember { mutableStateOf("") }
    var investorError by remember { mutableStateOf("") }


    val localActivity = LocalContext.current as Activity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        {
            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )


            {
                Image(
                    painter = painterResource(id = R.drawable.ic_investment), // Replace with your drawable resource
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .size(64.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))


                Text(
                    text = "Register To\nInvestment Suggesting",
                    color = Color(0xFF64A70B),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
                )


                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = investorName,
                    onValueChange = { investorName = it },
                    label = { Text("Full Name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))


                OutlinedTextField(
                    value = investorMail,
                    onValueChange = { investorMail = it },
                    label = { Text("Email Address") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                OutlinedTextField(
                    value = investorQalification, onValueChange = { investorQalification = it },
                    label = { Text(text = "Qualification") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 12.dp,
                        )
                )
                OutlinedTextField(
                    value = investorAuthCode,
                    onValueChange = { investorAuthCode = it },
                    label = { Text("Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(
                    value = investorAuthCodeConfirm,
                    onValueChange = { investorAuthCodeConfirm = it },
                    label = { Text("Confirm Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                )
                Spacer(modifier = Modifier.height(14.dp))
                if (investorError.isNotEmpty()) {
                    Text(
                        text = investorError,
                        color = Color.Red,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }


                Button(
                    onClick = {
                        when {
                            investorName.isBlank() -> {
                                investorError = "Investor Name cannot be empty"
                            }

                            investorMail.isBlank() -> {
                                investorError = "Investor Mail cannot be empty"
                            }

                            investorQalification.isBlank() -> {
                                investorError = "Investor Qualification cannot be empty"
                            }

                            investorAuthCode.isBlank() -> {
                                investorError = "Investor Password cannot be empty"
                            }

                            investorAuthCodeConfirm.isBlank() -> {
                                investorError = "Confirm Password cannot be empty"
                            }

                            investorAuthCode != investorAuthCodeConfirm -> {
                                investorError = "Make sure passwords match"

                            }

                            else -> {
                                investorError = ""
                                val userData = StockUserData(
                                    fullName = investorName,
                                    qualification = investorQalification,
                                    email = investorMail,
                                    password = investorAuthCode
                                    )
                                saveStockUserData(userData, localActivity)
                            }
                        }

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .height(38.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)

                ) {
                    Text(text = "Register")
                }

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Login",
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .clickable {
                            localActivity.startActivity(Intent(localActivity, SignInActivity::class.java))
                            localActivity.finish()
                        }
                        .align(Alignment.CenterHorizontally)


                )
                Spacer(modifier = Modifier.height(30.dp))
            }
            Spacer(modifier = Modifier.weight(1f))

        }
    }
}

private fun saveStockUserData(userData: StockUserData, localActivity: Activity) {
    val firebaseDatabase = FirebaseDatabase.getInstance()
    val databaseReference = firebaseDatabase.getReference("Users")

    databaseReference.child(userData.email.replace(".", ",")).setValue(userData)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(localActivity, "Registration Successful", Toast.LENGTH_SHORT).show()
                localActivity.startActivity(Intent(localActivity, SignInActivity::class.java))
                localActivity.finish()

            } else {
                Toast.makeText(
                    localActivity,
                    "User creation failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        .addOnFailureListener { exception ->
            Toast.makeText(
                localActivity,
                "User creation failed",
                Toast.LENGTH_SHORT
            ).show()
        }
}


@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}