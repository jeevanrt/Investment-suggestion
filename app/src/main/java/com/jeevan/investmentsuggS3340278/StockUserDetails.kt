package com.jeevan.investmentsuggS3340278

import android.content.Context

object StockUserDetails {
    private const val INVESTMENTGUIDE = "InvestmentGuide"

    fun saveStockUserLoginStatus(context: Context, value: Boolean) {
        val loginStatus = context.getSharedPreferences(INVESTMENTGUIDE, Context.MODE_PRIVATE)
        val editor = loginStatus.edit()
        editor.putBoolean("STOCKUSERLOGIN_STATUS", value).apply()
    }

    fun getStockUserLoginStatus(context: Context): Boolean {
        val loginStatus = context.getSharedPreferences(INVESTMENTGUIDE, Context.MODE_PRIVATE)
        return loginStatus.getBoolean("STOCKUSERLOGIN_STATUS", false)
    }

    fun saveInvestorEmail(context: Context, name: String) {
        val investorEmail = context.getSharedPreferences(INVESTMENTGUIDE, Context.MODE_PRIVATE)
        val editor = investorEmail.edit()
        editor.putString("INVESTOR_EMAIL", name).apply()
    }

    fun getInvestorEmail(context: Context): String? {
        val investorEmail = context.getSharedPreferences(INVESTMENTGUIDE, Context.MODE_PRIVATE)
        return investorEmail.getString("INVESTOR_EMAIL", null)
    }




    fun saveInvestorName(context: Context, email: String) {
        val investorName = context.getSharedPreferences(INVESTMENTGUIDE, Context.MODE_PRIVATE)
        val editor = investorName.edit()
        editor.putString("INVESTOR_NAME", email).apply()
    }

    fun getInvestorName(context: Context): String? {
        val investorName = context.getSharedPreferences(INVESTMENTGUIDE, Context.MODE_PRIVATE)
        return investorName.getString("INVESTOR_NAME", null)
    }
}