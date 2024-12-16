package com.jeevanS3340278.investmentsugg

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MaterialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialScreen()
        }
    }
}


@Composable
fun MaterialScreen() {
    val context = LocalContext.current as Activity

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
                        context.finish()
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
            modifier = Modifier.fillMaxSize()
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

    val context = LocalContext.current as Activity

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
                context.startActivity(intent)
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