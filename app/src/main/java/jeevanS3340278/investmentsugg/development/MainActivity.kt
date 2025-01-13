package jeevanS3340278.investmentsugg.development

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import jeevanS3340278.investmentsugg.development.ui.theme.InvestmentSuggTheme
import kotlinx.coroutines.delay

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InvestmentSuggTheme {
                StartUpViewScreen(this)
            }
        }
    }
}

@Composable
fun StartUpViewScreen(fa: FragmentActivity) {
    var canSplash by remember { mutableStateOf(true) }
    val localActivity = LocalContext.current as Activity

    LaunchedEffect(Unit) {
        delay(3000)
        canSplash = false
    }

    if (canSplash) {
        StartUpView()

    } else {
        val investerMovement = StockUserDetails.getStockUserLoginStatus(localActivity)

        if (investerMovement) {
            userAuthorization(LocalContext.current,fa)
        } else {
            localActivity.startActivity(Intent(localActivity, SignInActivity::class.java))
            localActivity.finish()
        }
    }
}

@Composable
fun StartUpView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Transparent),
                )
                {
                    Image(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        painter = painterResource(id = R.drawable.ic_investment),
                        contentDescription = "Investment Suggestion",
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Investment Suggesting App\nby Jeevan",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF64A70B), // Green color similar to the design
                        fontSize = 26.sp,
                        style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center
                    )
                }
            }


        }
    }

}


fun userAuthorization(ct: Context, fa: FragmentActivity) {
    val authManager = BiometricManager.from(fa)
    if (authManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG) == BiometricManager.BIOMETRIC_SUCCESS) {
        val authExecutor = ContextCompat.getMainExecutor(fa)
        val authPrompt =
            BiometricPrompt(fa, authExecutor, object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    gotoStockActivity(ct)
                }

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(ct, "Failed to verify", Toast.LENGTH_LONG).show()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(ct, "Failed", Toast.LENGTH_LONG).show()
                }
            })

        val authInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Authorize FingerPrint")
            .setSubtitle("Place your finger to continue")
            .setNegativeButtonText("Close")
            .build()

        authPrompt.authenticate(authInfo)
    } else {
        Toast.makeText(fa, "FingerPrint not supported", Toast.LENGTH_LONG).show()
        gotoStockActivity(ct)
    }
}

fun gotoStockActivity(ct: Context) {
    ct.startActivity(Intent(ct, StocksActivity::class.java))
    (ct as Activity).finish()
}


@Preview(showBackground = true)
@Composable
fun StartUpViewPreview() {
    StartUpView()
}