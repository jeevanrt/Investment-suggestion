package jeevanS3340278.investmentsugg.development

import android.content.Context

object StockUserDetails {
    private const val INVESTMENTGUIDE = "InvestmentGuide"

    fun saveStockUserLoginStatus(localActivity: Context, value: Boolean) {
        val loginStatus = localActivity.getSharedPreferences(INVESTMENTGUIDE, Context.MODE_PRIVATE)
        val editor = loginStatus.edit()
        editor.putBoolean("STOCKUSERLOGIN_STATUS", value).apply()
    }

    fun getStockUserLoginStatus(localActivity: Context): Boolean {
        val loginStatus = localActivity.getSharedPreferences(INVESTMENTGUIDE, Context.MODE_PRIVATE)
        return loginStatus.getBoolean("STOCKUSERLOGIN_STATUS", false)
    }

    fun saveInvestorEmail(localActivity: Context, name: String) {
        val investorEmail = localActivity.getSharedPreferences(INVESTMENTGUIDE, Context.MODE_PRIVATE)
        val editor = investorEmail.edit()
        editor.putString("INVESTOR_PRIMARY", name).apply()
    }

    fun getInvestorEmail(localActivity: Context): String? {
        val investorEmail = localActivity.getSharedPreferences(INVESTMENTGUIDE, Context.MODE_PRIVATE)
        return investorEmail.getString("INVESTOR_PRIMARY", null)
    }




    fun saveInvestorName(localActivity: Context, email: String) {
        val investorName = localActivity.getSharedPreferences(INVESTMENTGUIDE, Context.MODE_PRIVATE)
        val editor = investorName.edit()
        editor.putString("NAMEINVESTOR", email).apply()
    }

    fun getInvestorName(localActivity: Context): String? {
        val investorName = localActivity.getSharedPreferences(INVESTMENTGUIDE, Context.MODE_PRIVATE)
        return investorName.getString("NAMEINVESTOR", null)
    }
}