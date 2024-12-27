package com.jeevanS3340278.investmentsugg

import android.app.Activity
import android.content.Intent
import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
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
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jeevanS3340278.investmentsugg.ui.theme.StockData

class StockDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockDetailsScreen(SelectedStock.selStock)
        }
    }
}

@Composable
fun StockDetailsScreen(stockData: StockData) {

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
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
                text = "Stock Details",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )

        }
        Spacer(modifier = Modifier.height(12.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .verticalScroll(rememberScrollState())
        ) {


            Image(
                painter = painterResource(id = stockData.companyImage),
                contentDescription = "Stock Image",
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.width(4.dp))

            Column(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stockData.stockName,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(start = 6.dp)
                )

                Text(
                    text = "${stockData.quantity}",
                    color = Color.Black,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .padding(start = 6.dp)
                )

            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Market Cap",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 6.dp)
            )

            Text(
                text = stockData.marketCap,
                color = Color.Black,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,

                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Revenue",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 6.dp)
            )

            Text(
                text = stockData.revenue,
                color = Color.Black,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Earnings",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 6.dp)
            )

            Text(
                text = stockData.earnings,
                color = Color.Black,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Price History",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 6.dp)
            )

            Text(
                text = stockData.priceHistory,
                color = Color.Black,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
            )


        }
    }
}