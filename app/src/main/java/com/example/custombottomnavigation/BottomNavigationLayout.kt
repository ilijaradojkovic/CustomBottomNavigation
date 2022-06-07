package com.example.custombottomnavigation

import android.util.Log
import androidx.annotation.FloatRange
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationItem(
    circleSelectedColor:Color,
    animatedFloat: Float,
    onClick:()->Unit,
    content: @Composable () -> Unit

){
    val interactionSource = remember { MutableInteractionSource() }
    Layout(content = content, modifier = Modifier.clickable(interactionSource, indication = null){ onClick() }.drawBehind { drawCircle(circleSelectedColor, radius =animatedFloat*size.height/3f) }){measurables,constraints->

        val placeables=measurables.map { x->
            x.measure(constraints.copy())
        }
        layout(constraints.maxWidth,placeables[0].height*3){
            placeables.forEachIndexed { index, placeable ->
                placeable.place(constraints.maxWidth/2-placeable.width/2,placeables[0].height*3/2-placeable.height/2)
            }
        }

    }
}

@Composable
fun BottomNavigationLayout(

    backgroundColor: Color,
    content: @Composable () -> Unit
){


    Layout(content = content, modifier = Modifier.background(backgroundColor)){ measurables, constraints->

        val itemX= constraints.maxWidth/measurables.size

        val placeables =measurables.map { x-> x.measure(constraints.copy(minWidth = itemX, maxWidth = itemX)) }
        layout(constraints.maxWidth,placeables[0].height){
            placeables.forEachIndexed { index, placeable ->
                placeable.place(itemX*index,0)
            }
        }

    }



}