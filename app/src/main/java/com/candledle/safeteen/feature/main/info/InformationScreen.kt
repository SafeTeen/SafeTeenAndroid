package com.candledle.safeteen.feature.main.info

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.candledle.safeteen.R
import com.candledle.safeteen.component.MyQnas
import com.candledle.safeteen.design_system.button.SafeSmallButton
import com.candledle.safeteen.design_system.theme.Body3
import com.candledle.safeteen.design_system.theme.Heading6
import com.candledle.safeteen.design_system.theme.SafeColor
import com.candledle.safeteen.feature.main.mypage.QnA
import com.candledle.safeteen.navigation.SafeNavigation

@Composable
internal fun InformationScreen(
    navController: NavController,
) {

    var currentSelected by rememberSaveable { mutableStateOf(SelectedMenu.QNA) }

    val onClickQnaButton = {
        currentSelected = SelectedMenu.QNA
    }

    val onClickManualButton = {
        currentSelected = SelectedMenu.MANUAL
    }

    val onClickCreateQnaButton = {
        navController.navigate(SafeNavigation.CreateQuestion)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Heading6(text = stringResource(id = R.string.navigation_info))
            Spacer(modifier = Modifier.height(12.dp))
            SelectButtons(
                currentSelected = currentSelected,
                onClickQnaButton = onClickQnaButton,
                onClickManualButton = onClickManualButton,
            )
            when (currentSelected) {
                SelectedMenu.QNA -> {
                    Spacer(modifier = Modifier.height(24.dp))
                    MyQnas(
                        questions = listOf(QnA("seifjseifj"), QnA("sejisejfisj")),
                        backgroundColor = SafeColor.Gray300,
                        navController = navController,
                    )
                }

                SelectedMenu.MANUAL -> {
                    Spacer(modifier = Modifier.height(12.dp))
                    Manuals(
                        manualEntities = listOf(
                            ManualEntity(R.drawable.ic_fire, "화재"),
                            ManualEntity(R.drawable.ic_kick_board, "전동킥보드"),
                            ManualEntity(R.drawable.ic_wind, "태풍"),
                            ManualEntity(R.drawable.ic_motorcycle, "오토바이")
                        ),
                        navController = navController,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        if (currentSelected == SelectedMenu.QNA) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                FloatingActionButton(
                    modifier = Modifier.size(48.dp),
                    onClick = onClickCreateQnaButton,
                    backgroundColor = SafeColor.Main500,
                ) {
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.ic_create_qna),
                            contentDescription = null,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(84.dp))
        }
    }
}

@Composable
private fun SelectButtons(
    currentSelected: SelectedMenu,
    onClickQnaButton: () -> Unit,
    onClickManualButton: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
    ) {
        SafeSmallButton(
            text = stringResource(id = R.string.information_qna),
            textColor = if (currentSelected == SelectedMenu.QNA) SafeColor.White
            else SafeColor.Black,
            backgroundColor = if (currentSelected == SelectedMenu.QNA) SafeColor.Main500
            else SafeColor.Gray300,
            onClick = onClickQnaButton,
        )
        Spacer(modifier = Modifier.width(8.dp))
        SafeSmallButton(
            text = stringResource(id = R.string.information_manual),
            textColor = if (currentSelected == SelectedMenu.MANUAL) SafeColor.White
            else SafeColor.Black,
            backgroundColor = if (currentSelected == SelectedMenu.MANUAL) SafeColor.Main500
            else SafeColor.Gray300,
            onClick = onClickManualButton,
        )
    }
}

@Composable
private fun Manuals(
    manualEntities: List<ManualEntity>,
    navController: NavController,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(manualEntities) {
            Manual(
                drawable = it.drawable,
                manual = it.manual,
            ) {
                navController.navigate(SafeNavigation.ManualDetails)
            }
        }
    }
}

@Composable
private fun Manual(
    @DrawableRes drawable: Int,
    manual: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(color = SafeColor.Gray300),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                modifier = Modifier.size(104.dp),
                painter = painterResource(id = drawable),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Body3(
            modifier = Modifier.align(Alignment.Start),
            text = manual,
        )
    }
}

data class ManualEntity(
    val drawable: Int,
    val manual: String,
)

enum class SelectedMenu {
    QNA, MANUAL,
}