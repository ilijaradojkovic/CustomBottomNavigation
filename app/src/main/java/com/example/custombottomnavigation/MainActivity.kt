package com.example.custombottomnavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.custombottomnavigation.ui.theme.CustomBottomNavigationTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CustomBottomNavigationTheme {

                Scaffold(bottomBar = {
                    BottomNavigation(listOf(
                        IconItem(R.drawable.grid,R.drawable.grid_filled),
                        IconItem( R.drawable.heart,R.drawable.heart_filled),
                        IconItem( R.drawable.user,R.drawable.user_filled)),
                        backgroundColor = Color(0xFF2a1155),
                        circleSelectedColor = Color(0xFFddacf5),
                        iconTintColor = Color(0xFFe6e6e6),)
                }) {

                }
            }
        }
    }

  }

