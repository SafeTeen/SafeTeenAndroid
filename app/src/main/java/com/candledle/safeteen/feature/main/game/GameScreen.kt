package com.candledle.safeteen.feature.main.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import com.candledle.safeteen.design_system.button.SafeSmallButton
import com.candledle.safeteen.design_system.theme.Body1
import com.candledle.safeteen.design_system.theme.Caption
import com.candledle.safeteen.design_system.theme.Heading6
import com.candledle.safeteen.design_system.theme.SafeColor
import com.candledle.safeteen.feature.main.home.Challenge

@Composable
internal fun GameScreen(
    navController: NavController,
){

    var currentSelected by rememberSaveable { mutableStateOf(SelectedMenu.SPEED_QUIZ) }

    val onClickQuizButton = {
        currentSelected = SelectedMenu.SPEED_QUIZ
    }

    val onClickSimulationButton = {
        currentSelected = SelectedMenu.SIMULATION
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ){
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ){
            Spacer(modifier = Modifier.height(48.dp))
            Heading6(text = stringResource(id = R.string.navigation_game))
            Spacer(modifier = Modifier.height(12.dp))
            SelectButtons(
                currentSelected = currentSelected,
                onClickQuizButton = onClickQuizButton,
                onClickSimulationButton = onClickSimulationButton,
            )
        }
    }
}

@Composable
private fun SelectButtons(
    currentSelected: SelectedMenu,
    onClickQuizButton: () -> Unit,
    onClickSimulationButton: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
    ) {
        SafeSmallButton(
            text = stringResource(id = R.string.game_speed_quiz),
            textColor = if (currentSelected == SelectedMenu.SPEED_QUIZ) SafeColor.White
            else SafeColor.Black,
            backgroundColor = if (currentSelected == SelectedMenu.SPEED_QUIZ) SafeColor.Main500
            else SafeColor.Gray300,
            onClick = onClickQuizButton,
        )
        Spacer(modifier = Modifier.width(8.dp))
        SafeSmallButton(
            text = stringResource(id = R.string.game_simulation),
            textColor = if (currentSelected == SelectedMenu.SIMULATION) SafeColor.White
            else SafeColor.Black,
            backgroundColor = if (currentSelected == SelectedMenu.SIMULATION) SafeColor.Main500
            else SafeColor.Gray300,
            onClick = onClickSimulationButton,
        )
    }
}

@Composable
private fun SpeedQuizs(
    challenges: List<Challenge>,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(challenges) {
            SpeedQuiz(challenge = it)
        }
    }
}

@Composable
private fun SpeedQuiz(
    challenge: Challenge,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(SafeColor.Gray300)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(SafeColor.Gray300),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = challenge.drawable),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Body1(text = challenge.title)
            Spacer(modifier = Modifier.height(4.dp))
            Caption(
                text = "${challenge.point} 포인트 받기",
                color = SafeColor.Main500,
            )
        }
    }
}

private enum class SelectedMenu{
    SPEED_QUIZ, SIMULATION
}