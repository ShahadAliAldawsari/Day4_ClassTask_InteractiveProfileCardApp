package com.example.day4_classtask_interactiveprofilecardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCard()
        }
    }
}
@Composable
fun ProfileCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Picture
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Profile Picture",
                modifier = Modifier,

                )


            // Name
            Text(
                text = "Shahad Ali",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            // Bio
            Text(
                text = "Android Dev Track",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            // count of followers
            var followCount by remember { mutableStateOf(20) }  // Initial count
            Text(
                text = followCount.toString()+ " Followers",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            // Follow Button
            var isFollwing by remember { mutableStateOf(false) }
            Button(
                onClick = {
                    isFollwing = !isFollwing
                    if (isFollwing)
                        followCount += 1
                    else
                        followCount -= 1
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDA62C9))
            ) {
                if (isFollwing)
                    Text(text = "Following", fontSize = 16.sp)
                else
                    Text(text = "Following", fontSize = 16.sp)
            }


        }
    }
}

//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Day4_ClassTask_InteractiveProfileCardAppTheme {
//        Greeting("Android")
//    }
//}