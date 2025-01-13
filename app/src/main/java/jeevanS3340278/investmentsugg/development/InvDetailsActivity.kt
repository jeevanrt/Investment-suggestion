package jeevanS3340278.investmentsugg.development

import android.app.Activity
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

class InvDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvDetailsScreen()
        }
    }
}

@Composable
fun InvDetailsScreen() {
    val localActivity = LocalContext.current as Activity


    Column(
        modifier = Modifier.fillMaxSize()
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
                contentDescription = "Back",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .clickable {
                        localActivity.finish()
                    }
            )

            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = "Investment Formula",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )

        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Your investment value £ ${InvestmentAmount.amount}",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 6.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "We will suggest you to invest £ ${InvestmentAmount.amount} like below ratio",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 6.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        InvestmentBreakdown(totalAmount = InvestmentAmount.amount)
    }
}

@Composable
fun InvestmentBreakdown(totalAmount: Int) {
    val percentages = listOf(
        15 to "Shares",
        10 to "Debt",
        25 to "Property",
        15 to "Fix Deposits",
        10 to "Insurance products",
        10 to "Government Bonds",
        10 to "ETFs",
        5 to "Individual Savings Accounts (ISAs)"
    )

    val breakdownText = percentages.joinToString(separator = "\n") { (percentage, category) ->
        val amount = (totalAmount * percentage) / 100
        "${percentages.indexOf(Pair(percentage, category)) + 1}) $amount £ $category"
    }

    Text(
        text = breakdownText,
        color = Color.Black,
        fontSize = 14.sp,
        modifier = Modifier.padding(start = 12.dp)
    )
}
