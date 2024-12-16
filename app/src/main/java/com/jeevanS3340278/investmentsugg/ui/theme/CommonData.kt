package com.jeevanS3340278.investmentsugg.ui.theme

import com.jeevanS3340278.investmentsugg.R

object CommonData {
    fun getStockData(): List<StockData> {
        return listOf(
            StockData(
                stockName = "Linde",
                quantity = "LIN",
                lastYear = "11.97%",
                minInvest = "$1,000",
                fundSize = "$219.50 B",
                companyImage = R.drawable.linde
            ),
            StockData(
                stockName = "AstraZeneca",
                quantity = "AZN",
                lastYear = "4.37%",
                minInvest = "$67.62",
                fundSize = "$209.66 B",
                companyImage = R.drawable.azn
            ),
            StockData(
                stockName = "Shell",
                quantity = "SHEL",
                lastYear = "-1.05%",
                minInvest = "$64.74",
                fundSize = "$197.93 B",
                companyImage = R.drawable.shell
            ),
            StockData(
                stockName = "HSBC",
                quantity = "HSBC",
                lastYear = "21.29%",
                minInvest = "$46.89",
                fundSize = "$168.69 B",
                companyImage = R.drawable.hsbc
            ),
            StockData(
                stockName = "Unilever",
                quantity = "UL",
                lastYear = "24.90%",
                minInvest = "$59.84",
                fundSize = "$148.13 B",
                companyImage = R.drawable.ul
            ),
            StockData(
                stockName = "Arm Holdings",
                quantity = "ARM",
                lastYear = "110.16%",
                minInvest = "$134.29",
                fundSize = "$141.13 B",
                companyImage = R.drawable.arm
            ),
            StockData(
                stockName = "Rio Tinto",
                quantity = "RIO",
                lastYear = "-11.69%",
                minInvest = "$62.84",
                fundSize = "$100.36 B",
                companyImage = R.drawable.rio
            ),
            StockData(
                stockName = "RELX",
                quantity = "RELX",
                lastYear = "22.10%",
                minInvest = "$47.08",
                fundSize = "$87.38 B",
                companyImage = R.drawable.relx
            ),
            StockData(
                stockName = "Aon",
                quantity = "AON",
                lastYear = "19.82%",
                minInvest = "$391.54",
                fundSize = "$85.05 B",
                companyImage = R.drawable.aon
            ),
            StockData(
                stockName = "British American Tobacco",
                quantity = "BTI",
                lastYear = "18.41%",
                minInvest = "$37.94",
                fundSize = "$83.65 B",
                companyImage = R.drawable.bti
            )
        )
    }

}

data class StockData(
    val stockName: String = "",
    val quantity: String = "",
    val lastYear: String = "",
    val minInvest: String = "",
    val fundSize: String = "",
    var companyImage : Int = 0
)

data class StockUserData(
    var fullName: String = "",
    var gender: String = "",
    var qualification: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = "",

)