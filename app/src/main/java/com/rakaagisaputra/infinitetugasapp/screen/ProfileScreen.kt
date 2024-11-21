package com.rakaagisaputra.infinitetugasapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rakaagisaputra.infinitetugasapp.R

@Composable
fun ProfileScreen(){
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Text(text = "About Us", fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Spacer(Modifier.height(20.dp))
        Card(
            modifier = Modifier.wrapContentSize().aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(R.drawable.raka_profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.aspectRatio(1f)
            )
        }
        Spacer(Modifier.height(20.dp))

        Card (colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ){

            Text("Nama: Raka Agi Saputra\nEmail: Raka_Agi_Saputra@teknokrat.ac.id\nProdi: Informatika\nUniversitas: Universitas Teknokrat Indonesia")
        }

    }
}