package com.jeevan.investmentsugg.ui.theme

object CommonData {
    fun getStockData(): List<StockData> {
        return listOf(
            StockData(
                stockName = "Tech Innovators Inc.",
                quantity = "150",
                lastYear = "12%",
                minInvest = "$1,000",
                fundSize = "$50M"
            ),
            StockData(
                stockName = "Green Energy Ltd.",
                quantity = "200",
                lastYear = "8%",
                minInvest = "$500",
                fundSize = "$30M"
            ),
            StockData(
                stockName = "Global Pharma Corp.",
                quantity = "300",
                lastYear = "10%",
                minInvest = "$1,500",
                fundSize = "$40M"
            ),
            StockData(
                stockName = "Future Retail",
                quantity = "100",
                lastYear = "15%",
                minInvest = "$2,000",
                fundSize = "$60M"
            ),
            StockData(
                stockName = "Blue Ocean Shipping",
                quantity = "250",
                lastYear = "9%",
                minInvest = "$1,200",
                fundSize = "$35M"
            ),
            StockData(
                stockName = "Urban Tech Solutions",
                quantity = "180",
                lastYear = "11%",
                minInvest = "$800",
                fundSize = "$25M"
            ),
            StockData(
                stockName = "HealthPlus Care",
                quantity = "400",
                lastYear = "7%",
                minInvest = "$1,000",
                fundSize = "$45M"
            ),
            StockData(
                stockName = "AgriGrowth Ventures",
                quantity = "350",
                lastYear = "13%",
                minInvest = "$1,300",
                fundSize = "$55M"
            ),
            StockData(
                stockName = "Crypto Pioneers",
                quantity = "500",
                lastYear = "20%",
                minInvest = "$2,500",
                fundSize = "$70M"
            ),
            StockData(
                stockName = "TechPioneers Global",
                quantity = "120",
                lastYear = "14%",
                minInvest = "$900",
                fundSize = "$32M"
            )
        )
    }

}

data class StockData(
    val stockName: String = "",
    val quantity: String = "",
    val lastYear: String = "",
    val minInvest: String = "",
    val fundSize: String = ""
)