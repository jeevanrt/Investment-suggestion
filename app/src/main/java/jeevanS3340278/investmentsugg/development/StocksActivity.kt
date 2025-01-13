package jeevanS3340278.investmentsugg.development

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import jeevanS3340278.investmentsugg.development.ui.theme.CommonData
import jeevanS3340278.investmentsugg.development.ui.theme.StockData

class StocksActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        setContent {
            StocksActivityScreen()
        }
    }
}


@Composable
fun StocksActivityScreen() {

    val availableStocks = CommonData.getStockData()
    val localActivity = LocalContext.current as Activity

    var isRiskProfileSet by remember { mutableStateOf(true) }

    val sharedPreferences = localActivity.getSharedPreferences("RiskProfilePrefs", Context.MODE_PRIVATE)

    val selectedSectorPreferences =
        sharedPreferences.getStringSet("sectorPreferences", emptySet()) ?: emptySet()

    if (selectedSectorPreferences.isEmpty()) {
        isRiskProfileSet = false
    }

    val filteredStocks = availableStocks.filter { stock ->
        stock.sector in selectedSectorPreferences
    }

    var stockData: List<StockData> = if (isRiskProfileSet) filteredStocks else availableStocks

    fun showAll() {
        stockData = if (isRiskProfileSet) filteredStocks else availableStocks
    }


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

            Image(painter = painterResource(id = R.drawable.investor),
                contentDescription = "Logout",
                modifier = Modifier
                    .size(28.dp)
                    .clickable {
                        val intent = Intent(localActivity, InvestorProfileActivity::class.java)
                        localActivity.startActivity(intent)
                    }

            )

            Spacer(modifier = Modifier.width(12.dp))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row {

            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .clickable {
                        PageSelected.selectioin = 0
                        localActivity.startActivity(Intent(localActivity, MaterialActivity::class.java))
                    },
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.stock_img),
                        contentDescription = "Stock Image",
                        modifier = Modifier
                            .width(36.dp)
                            .height(36.dp)
                    )

                    Text(
                        text = "Risk\nProfile",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(start = 6.dp)
                    )
                }

            }

            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .clickable {
                        PageSelected.selectioin = 1
                        localActivity.startActivity(Intent(localActivity, MaterialActivity::class.java))
                    },
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.stock_img),
                        contentDescription = "Stock Image",
                        modifier = Modifier
                            .width(36.dp)
                            .height(36.dp)
                    )

                    Text(
                        text = "Educational\nResources",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(start = 6.dp)
                    )
                }
            }
        }

        Row {

            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .clickable {
                        PageSelected.selectioin = 0
                        localActivity.startActivity(Intent(localActivity, InvestmentFormulaActivity::class.java))
                    },
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.stock_img),
                        contentDescription = "Stock Image",
                        modifier = Modifier
                            .width(36.dp)
                            .height(36.dp)
                    )

                    Text(
                        text = "Investment\nFormula",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(start = 6.dp)
                    )
                }

            }

            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .clickable {
                        PageSelected.selectioin = 1
                        localActivity.startActivity(Intent(localActivity, KnowYourInvActivity::class.java))
                    },
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.stock_img),
                        contentDescription = "Stock Image",
                        modifier = Modifier
                            .width(36.dp)
                            .height(36.dp)
                    )

                    Text(
                        text = "Know Your\nInvestment",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(start = 6.dp)
                    )
                }
            }
        }

        Text(
            text = "Suggested Stocks For You",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 6.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {

            Text(
                text = if (isRiskProfileSet) "Filtered by Risk Profile" else "Showing available stocks",
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 6.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = if (isRiskProfileSet) "Show All" else "Filter by RiskProfile",
                color = Color.Blue,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 6.dp)
                    .clickable {
                        isRiskProfileSet = !isRiskProfileSet
                        showAll()
                    }
            )

        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {

            items(stockData.size) { index ->
                StockItem(stockData[index])
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }
}

@Composable
fun StockItem(stockData: StockData) {

    val localActivity = LocalContext.current

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
                        painter = painterResource(id = stockData.companyImage),
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
                            text = "${stockData.quantity}",
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
                        contentDescription = "Arrow Forward",
                        modifier = Modifier.clickable {
                            SelectedStock.selStock = stockData
                            localActivity.startActivity(Intent(localActivity, StockDetailsActivity::class.java))
                        }
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
                            text = "Last 1Y",
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
                            text = "Share Price",
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
                            text = "Marketcap",
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

object SelectedStock {
    var selStock = StockData()
}

@Preview(showBackground = true)
@Composable
fun WelComeScreenDesignPreview() {
    StocksActivityScreen()
}