package com.example.custombottomnavigation

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun BottomNavigation(items: List<IconItem>, @DrawableRes backgroundColor:  Color, @DrawableRes circleSelectedColor: Color,@DrawableRes iconTintColor: Color) {
BottomNavigationLayout(backgroundColor){

var selected by remember {
    mutableStateOf(items[0].id)
}

    val animatedValues= LinkedList<State<Float>>()
    items.forEach{x->
        animatedValues.add(animateFloatAsState(targetValue = if(selected==x.id) 1f else 0f))
    }

    for(i in items.indices){
        val item=items[i]
        val animValue=animatedValues[i]
        val itemSelected=selected==item.id
        BottomNavigationItem(circleSelectedColor,animValue.value, {selected=item.id  }) {
            IconBottomNavigation(iconTintColor,icon =if(itemSelected) item.selectedIcon else item.unselectedIcon)
        }
    }





}
}

@Composable
fun IconBottomNavigation(iconTintColor: Color, @DrawableRes icon: Int) {
Icon(painter = painterResource(id = icon),"Icon", modifier = Modifier.size(24.dp), tint = iconTintColor)
}