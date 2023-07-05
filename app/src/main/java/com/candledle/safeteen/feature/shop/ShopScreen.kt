package com.candledle.safeteen.feature.shop

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.candledle.safeteen.R
import com.candledle.safeteen.design_system.button.SafeMediumButton
import com.candledle.safeteen.design_system.theme.Body1
import com.candledle.safeteen.design_system.theme.Body2
import com.candledle.safeteen.design_system.theme.Body3
import com.candledle.safeteen.design_system.theme.Caption
import com.candledle.safeteen.design_system.theme.Heading6
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
internal fun ShopScreen(
    navController: NavController,
) {

    var currentReward by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SafeColor.Gray300),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Heading6(text = stringResource(id = R.string.navigation_shop))
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                Body2(
                    text = stringResource(id = R.string.shop_current_reward),
                    color = SafeColor.Gray800,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Body1(
                    text = currentReward.toString(),
                    color = SafeColor.Gray900,
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Caption(
                text = stringResource(id = R.string.shop_description),
                color = SafeColor.Gray700,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Items(
                itemEntities = listOf(
                    ItemEntity(
                        drawable = R.drawable.ic_shop,
                        name = "fsefse",
                        point = 1000,
                    ),
                    ItemEntity(
                        drawable = R.drawable.ic_shop,
                        name = "fsefse",
                        point = 1000,
                    ),
                    ItemEntity(
                        drawable = R.drawable.ic_shop,
                        name = "fsefse",
                        point = 1000,
                    ),
                    ItemEntity(
                        drawable = R.drawable.ic_shop,
                        name = "fsefse",
                        point = 1000,
                    ),
                    ItemEntity(
                        drawable = R.drawable.ic_shop,
                        name = "fsefse",
                        point = 1000,
                    ),
                    ItemEntity(
                        drawable = R.drawable.ic_shop,
                        name = "fsefse",
                        point = 1000,
                    ),
                )
            )
        }
    }
}

@Composable
private fun Items(
    itemEntities: List<ItemEntity>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
    ) {
        items(itemEntities) {
            Item(
                drawable = it.drawable,
                name = it.name,
                point = it.point,
            )
        }
    }
}

@Composable
private fun Item(
    @DrawableRes drawable: Int,
    name: String,
    point: Int,
) {
    Column {
        Box(
            modifier = Modifier
                .size(112.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color = SafeColor.White),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Body3(
            text = name,
            color = SafeColor.Gray900,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier.width(112.dp),
        ) {
            SafeMediumButton(
                text = "$point point",
                backgroundColor = SafeColor.Main500,
                onClick = {}
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
    }
}

data class ItemEntity(
    val drawable: Int,
    val name: String,
    val point: Int,
)