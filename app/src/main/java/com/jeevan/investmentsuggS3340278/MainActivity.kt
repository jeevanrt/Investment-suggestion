package com.jeevan.investmentsuggS3340278

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.jeevan.investmentsuggS3340278.ui.theme.InvestmentSuggTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InvestmentSuggTheme {
                StartUpViewScreen()
            }
        }
    }


}

@Composable
fun StartUpViewScreen() {
    var canSplash by remember { mutableStateOf(true) }
    val context = LocalContext.current as Activity

    LaunchedEffect(Unit) {
        delay(3000)
        canSplash = false
    }

    if (canSplash) {
        StartUpView()

    } else {
        val UserStatus = StockUserDetails.getStockUserLoginStatus(context)

        if (UserStatus) {
            context.startActivity(Intent(context, StocksActivity::class.java))
            context.finish()
        } else {
            context.startActivity(Intent(context, SignInActivity::class.java))
            context.finish()
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


@Preview(showBackground = true)
@Composable
fun StartUpViewPreview() {
    StartUpView()
}