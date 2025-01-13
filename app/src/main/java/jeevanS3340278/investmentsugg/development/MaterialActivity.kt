package jeevanS3340278.investmentsugg.development

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MaterialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            if (PageSelected.selectioin == 1) {
                MaterialScreen()
            } else {
                RiskProfileForm()
            }
        }
    }
}

object PageSelected {
    var selectioin = 0
}

@Composable
fun MaterialScreen() {
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
                text = "Educational Resources",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) // Makes the column scrollable

        ) {


            Spacer(modifier = Modifier.height(12.dp))

            ImageWithTitle(
                R.drawable.inv1,
                "Selling HL after investors accept a low-ball takeover offer",
                "https://www.ukdividendstocks.com/blog/selling-hargreaves-lansdown-shares"
            )

            Spacer(modifier = Modifier.height(6.dp))

            ImageWithTitle(
                R.drawable.inv2,
                "Simple rules to diversify your dividend portfolio",
                "https://www.ukdividendstocks.com/blog/simple-rules-to-diversify-your-dividend-portfolio"
            )

            Spacer(modifier = Modifier.height(6.dp))


            ImageWithTitle(
                R.drawable.inv3,
                "Removing Headlam from my dividend portfolio",
                "https://www.ukdividendstocks.com/blog/removing-headlam-from-my-dividend-portfolio"
            )

            Spacer(modifier = Modifier.height(6.dp))

            ImageWithTitle(
                R.drawable.inv4,
                "2 Ways to value dividend-paying shares",
                "https://www.ukdividendstocks.com/blog/2-ways-to-value-dividend-paying-shares"
            )

            Spacer(modifier = Modifier.height(6.dp))

            ImageWithTitle(
                R.drawable.inv5,
                "How I'm hunting for UK dividend hero stocks",
                "https://www.ukdividendstocks.com/blog/hunting-for-dividend-hero-stocks"
            )

            Spacer(modifier = Modifier.height(12.dp))

        }
    }
}

@Composable
fun ImageWithTitle(imageThumbnail: Int, title: String, urlP: String) {

    val localActivity = LocalContext.current as Activity

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 12.dp)
            .clickable {
                // Open URL in Chrome
                val url = urlP // Replace with your desired URL
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                localActivity.startActivity(intent)
            }
    ) {
        // Image
        Image(
            painter = painterResource(id = imageThumbnail), // Replace with your image resource
            contentDescription = "Thumbnail",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )


        // Title at the bottom of the image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.Black.copy(alpha = 0.5f)) // Background with fade-in effect
                .padding(8.dp)
        ) {

            Row(modifier = Modifier.align(Alignment.CenterStart)) {


                Text(
                    text = title, // Replace with your title
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(2.dp)
                )


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MaterialScreenPreview() {
    MaterialScreen()
}

//---------------------------

@Composable
fun RiskProfileFormOld() {
    val riskToleranceOptions = listOf("Low", "Moderate", "High")
    val timeHorizonOptions =
        listOf("Short-Term (<3 years)", "Medium-Term (3–7 years)", "Long-Term (>7 years)")
    val financialGoalOptions = listOf("Wealth Preservation", "Balanced Growth", "Aggressive Growth")
    val investmentExperienceOptions = listOf("Beginner", "Intermediate", "Advanced")
    val sectorPreferencesOptions = listOf(
        "Basic Materials",
        "Healthcare",
        "Energy",
        "Financial Services",
        "Consumer Goods",
        "Technology"
    )

    var selectedRiskTolerance by remember { mutableStateOf(riskToleranceOptions[0]) }
    var selectedTimeHorizon by remember { mutableStateOf(timeHorizonOptions[0]) }
    var selectedFinancialGoal by remember { mutableStateOf(financialGoalOptions[0]) }
    var selectedInvestmentExperience by remember { mutableStateOf(investmentExperienceOptions[0]) }
    val selectedSectorPreferences = remember { mutableStateListOf<String>() }

    val riskProfile = calculateRiskProfile(
        riskTolerance = selectedRiskTolerance,
        timeHorizon = selectedTimeHorizon,
        financialGoals = selectedFinancialGoal,
        investmentExperience = selectedInvestmentExperience,
        sectorPreferences = selectedSectorPreferences
    )

    val localActivity = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
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
                        (localActivity as Activity).finish()
                    }
            )

            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = "Risk Profile Form",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )

        }

        Text(text = "Risk Tolerance")
        RiskToleranceRadioButtons(
            options = riskToleranceOptions,
            selectedOption = selectedRiskTolerance,
            onOptionSelected = { selectedRiskTolerance = it }
        )

        // Time Horizon Radio Buttons
        Text(text = "Time Horizon")
        RiskToleranceRadioButtons(
            options = timeHorizonOptions,
            selectedOption = selectedTimeHorizon,
            onOptionSelected = { selectedTimeHorizon = it }
        )

        // Financial Goals Radio Buttons
        Text(text = "Financial Goals")
        RiskToleranceRadioButtons(
            options = financialGoalOptions,
            selectedOption = selectedFinancialGoal,
            onOptionSelected = { selectedFinancialGoal = it }
        )

        // Investment Experience Radio Buttons
        Text(text = "Investment Experience")
        RiskToleranceRadioButtons(
            options = investmentExperienceOptions,
            selectedOption = selectedInvestmentExperience,
            onOptionSelected = { selectedInvestmentExperience = it }
        )

        // Sector Preferences Chips
        Text(text = "Sector Preferences")
        SectorPreferencesChips(
            options = sectorPreferencesOptions,
            selectedOptions = selectedSectorPreferences
        )

        // Display Risk Profile
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .height(38.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Save")
        }


    }
}

@Composable
fun RiskToleranceRadioButtons(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        options.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { onOptionSelected(option) }
                )
                Text(text = option, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}

@Composable
fun SectorPreferencesChips(
    options: List<String>,
    selectedOptions: MutableList<String>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(options.size) { index ->
            FilterChip(
                selected = selectedOptions.contains(options[index]),
                onClick = {
                    if (selectedOptions.contains(options[index])) {
                        selectedOptions.remove(options[index])
                    } else {
                        selectedOptions.add(options[index])
                    }
                },
                label = { Text(options[index]) }
            )
        }
    }
}

// Dummy function to demonstrate risk profile calculation (modify as per actual logic)
fun calculateRiskProfile(
    riskTolerance: String,
    timeHorizon: String,
    financialGoals: String,
    investmentExperience: String,
    sectorPreferences: List<String>
): String {
    // Logic to calculate risk profile based on selected options
    return "Risk Profile: $riskTolerance, $timeHorizon, $financialGoals, $investmentExperience"
}


@Composable
fun RiskProfileForm() {
    val localActivity = LocalContext.current
    val sharedPreferences = localActivity.getSharedPreferences("RiskProfilePrefs", Context.MODE_PRIVATE)

    val riskToleranceOptions = listOf("Low", "Moderate", "High")
    val timeHorizonOptions =
        listOf("Short-Term (<3 years)", "Medium-Term (3–7 years)", "Long-Term (>7 years)")
    val financialGoalOptions = listOf("Wealth Preservation", "Balanced Growth", "Aggressive Growth")
    val investmentExperienceOptions = listOf("Beginner", "Intermediate", "Advanced")
    val sectorPreferencesOptions = listOf(
        "Basic Materials",
        "Healthcare",
        "Energy",
        "Financial Services",
        "Consumer Goods",
        "Technology"
    )

    var selectedRiskTolerance by remember {
        mutableStateOf(
            sharedPreferences.getString("riskTolerance", riskToleranceOptions[0])
                ?: riskToleranceOptions[0]
        )
    }
    var selectedTimeHorizon by remember {
        mutableStateOf(
            sharedPreferences.getString("timeHorizon", timeHorizonOptions[0])
                ?: timeHorizonOptions[0]
        )
    }
    var selectedFinancialGoal by remember {
        mutableStateOf(
            sharedPreferences.getString("financialGoal", financialGoalOptions[0])
                ?: financialGoalOptions[0]
        )
    }
    var selectedInvestmentExperience by remember {
        mutableStateOf(
            sharedPreferences.getString(
                "investmentExperience",
                investmentExperienceOptions[0]
            ) ?: investmentExperienceOptions[0]
        )
    }
    val selectedSectorPreferences = remember {
        mutableStateListOf<String>().apply {
            val savedSectors = sharedPreferences.getStringSet("sectorPreferences", emptySet())
            addAll(savedSectors ?: emptySet())
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
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
                        (localActivity as Activity).finish()
                    }
            )

            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = "Risk Profile Form",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )

        }

        Column(
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {


            Text(text = "Risk Tolerance")
            RiskToleranceRadioButtons(
                options = riskToleranceOptions,
                selectedOption = selectedRiskTolerance,
                onOptionSelected = { selectedRiskTolerance = it }
            )

            Text(text = "Time Horizon")
            RiskToleranceRadioButtons(
                options = timeHorizonOptions,
                selectedOption = selectedTimeHorizon,
                onOptionSelected = { selectedTimeHorizon = it }
            )

            Text(text = "Financial Goals")
            RiskToleranceRadioButtons(
                options = financialGoalOptions,
                selectedOption = selectedFinancialGoal,
                onOptionSelected = { selectedFinancialGoal = it }
            )

            Text(text = "Investment Experience")
            RiskToleranceRadioButtons(
                options = investmentExperienceOptions,
                selectedOption = selectedInvestmentExperience,
                onOptionSelected = { selectedInvestmentExperience = it }
            )

            Text(text = "Sector Preferences")
            SectorPreferencesChips(
                options = sectorPreferencesOptions,
                selectedOptions = selectedSectorPreferences
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    with(sharedPreferences.edit()) {
                        putString("riskTolerance", selectedRiskTolerance)
                        putString("timeHorizon", selectedTimeHorizon)
                        putString("financialGoal", selectedFinancialGoal)
                        putString("investmentExperience", selectedInvestmentExperience)
                        putStringSet("sectorPreferences", selectedSectorPreferences.toSet())
                        apply()
                    }
                    Toast.makeText(localActivity, "Saved successfully!", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(38.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(text = "Save")
            }

            Spacer(modifier = Modifier.height(16.dp))


        }
    }
}

