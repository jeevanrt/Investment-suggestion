package com.jeevan.investmentsugg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeevan.investmentsugg.ui.theme.CommonData
import com.jeevan.investmentsugg.ui.theme.StockData

class StocksActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StocksActivityScreen()
        }
    }
}


@Composable
fun StocksActivityScreen() {

    val availableStocks = CommonData.getStockData()

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
                painter = painterResource(id = R.drawable.ic_investment),
                contentDescription = "Stock Image",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )

            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = "Investment Recommendations",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(12.dp))


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {

            items(availableStocks.size) { index ->
                StockItem(availableStocks[index])
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }
}

@Composable
fun StockItem(stockData: StockData) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(modifier = Modifier.padding(6.dp)) {

            Column {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.stock_img),
                        contentDescription = "Stock Image",
                        modifier = Modifier
                            .width(36.dp)
                            .height(36.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    Column {
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
                            text = "Equity : ${stockData.quantity}",
                            color = Color.Black,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )

                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Arrow Forward"
                    )

                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(18.dp)
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = Color.Gray)
                )

                Row {
                    Column {

                        Text(
                            text = "Last 3Y",
                            color = Color.Gray,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 14.dp)
                        )

                        Text(
                            text = stockData.lastYear,
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 2.dp)
                        )

                    }

                    Spacer(modifier = Modifier.weight(1f))


                    Column {

                        Text(
                            text = "Min Invest",
                            color = Color.Gray,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 14.dp)
                        )

                        Text(
                            text = stockData.minInvest,
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 2.dp)
                        )

                    }

                    Spacer(modifier = Modifier.weight(1f))


                    Column {

                        Text(
                            text = "Fund Size",
                            color = Color.Gray,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 14.dp)
                        )

                        Text(
                            text = stockData.fundSize,
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 2.dp)
                        )

                    }
                }

            }

        }

    }

}