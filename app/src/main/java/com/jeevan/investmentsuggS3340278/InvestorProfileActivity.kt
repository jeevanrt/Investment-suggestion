package com.jeevan.investmentsuggS3340278

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class InvestorProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvestorProfile()
        }
    }
}

@Composable
fun InvestorProfile() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF64A70B)),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(12.dp))

            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_36),
                contentDescription = "Back Arrow",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .clickable {
                        (context as Activity).finish()
                    }
            )

            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = "Investment Guide",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )

            Image(painter = painterResource(id = R.drawable.baseline_logout_24),
                contentDescription = "Logout",
                modifier = Modifier
                    .clickable {
                        // Navigate to LoginActivity when clicked
                        StockUserDetails.saveStockUserLoginStatus(context, false)

                        val intent = Intent(context, SignInActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        context.startActivity(intent)
                        (context as Activity).finish()
                    }

            )

            Spacer(modifier = Modifier.width(12.dp))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Image(
            painter = painterResource(id = R.drawable.investor),
            contentDescription = "Investor Profile",
            modifier = Modifier
                .size(64.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))


        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = StockUserDetails.getInvestorName(context)!!,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 14.sp,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = StockUserDetails.getInvestorEmail(context)!!,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 14.sp,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )


    }
}