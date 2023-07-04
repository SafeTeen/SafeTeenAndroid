package com.candledle.safeteen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.candledle.safeteen.R
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
internal fun Logo(){
    Box(
        modifier = Modifier
            .size(106.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(SafeColor.White),
        contentAlignment = Alignment.Center,
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_safeteen_logo),
            contentDescription = null,
        )
    }
}