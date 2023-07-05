package com.candledle.safeteen.feature.main.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.candledle.safeteen.R
import com.candledle.safeteen.design_system.theme.Body1
import com.candledle.safeteen.design_system.theme.Caption
import com.candledle.safeteen.design_system.theme.Heading4
import com.candledle.safeteen.design_system.theme.Heading6
import com.candledle.safeteen.design_system.theme.SafeColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
internal fun HomeScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SafeColor.Gray300),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier.size(
                        width = 20.dp,
                        height = 26.dp,
                    ),
                    painter = painterResource(id = R.drawable.ic_safeteen_logo),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(12.dp))
                Heading6(
                    modifier = Modifier.padding(top = 2.dp),
                    text = stringResource(id = R.string.landing_safeteen),
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            CurrentPoint(currentReward = 2300)
            Spacer(modifier = Modifier.height(16.dp))
            Body1(text = stringResource(id = R.string.home_today_challenge))
            Spacer(modifier = Modifier.height(8.dp))
            TodayChallenges(
                challenges = listOf(
                    Challenge(
                        drawable = R.drawable.ic_fire,
                        title = "화재 경보기 점검하고",
                        point = 100,
                    ),
                    Challenge(
                        drawable = R.drawable.ic_fire,
                        title = "화재 경보기 점검하고",
                        point = 100,
                    ),
                    Challenge(
                        drawable = R.drawable.ic_fire,
                        title = "화재 경보기 점검하고",
                        point = 100,
                    ),
                )
            )
        }
    }
}

@Composable
private fun CurrentPoint(
    currentReward: Int,
) {

    val rank = when (currentReward) {
        in Rank.HeartShake.minReward until Rank.HeartShake.maxReward -> Rank.HeartShake
        in Rank.LumbarDisk.minReward until Rank.LumbarDisk.maxReward -> Rank.LumbarDisk
        in Rank.Flu.minReward until Rank.Flu.maxReward -> Rank.Flu
        in Rank.Cold.minReward until Rank.Cold.maxReward -> Rank.Cold
        else -> Rank.Happy
    }

    val coroutineScope = rememberCoroutineScope()

    var isInitialized by remember { mutableStateOf(false) }

    val animateProgress by animateFloatAsState(
        targetValue = if (!isInitialized) 0f
        else (currentReward.toFloat() / rank.maxReward.toFloat()),
        animationSpec = tween(
            durationMillis = 2000,
            easing = LinearOutSlowInEasing,
        ),
    )

    val animateReward by animateIntAsState(
        targetValue = if (!isInitialized) 0
        else currentReward,
        animationSpec = tween(2000),
    )

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            delay(300)
            isInitialized = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = SafeColor.White)
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Caption(
                text = stringResource(id = R.string.my_page_current_reward),
                color = SafeColor.Gray700,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Body1(text = stringResource(id = rank.rank))
        }
        Spacer(modifier = Modifier.height(20.dp))
        RewardProgress(
            currentReward = currentReward,
            rank = rank,
            coroutineScope = coroutineScope,
            isInitialize = isInitialized,
            animateProgress = animateProgress,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Caption(text = stringResource(id = R.string.home_reward_point))
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.Bottom,
        ) {
            Heading4(text = animateReward.toString())
            Spacer(modifier = Modifier.width(4.dp))
            Heading6(
                text = "/${rank.maxReward}",
                color = SafeColor.Gray700,
            )
        }
        Spacer(modifier = Modifier.height(22.dp))
    }
}

@Composable
private fun RewardProgress(
    currentReward: Int,
    rank: Rank,
    coroutineScope: CoroutineScope,
    isInitialize: Boolean,
    animateProgress: Float,
) {

    Box(
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(162.dp)
                .clip(CircleShape)
                .background(SafeColor.Gray300),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = rank.drawable),
                contentDescription = null,
            )
        }
        CircularProgressIndicator(
            modifier = Modifier
                .size(202.dp)
                .clip(CircleShape),
            progress = 1f,
            color = SafeColor.Gray300,
            strokeWidth = 8.dp,
        )
        CircularProgressIndicator(
            modifier = Modifier.size(202.dp),
            progress = animateProgress,
            color = SafeColor.Main500,
            strokeWidth = 8.dp,
        )
    }
}

@Composable
private fun TodayChallenges(
    challenges: List<Challenge>,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(challenges) {
            TodayChallenge(challenge = it)
        }
    }
}

@Composable
private fun TodayChallenge(
    challenge: Challenge,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(SafeColor.White)
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

data class Challenge(
    @DrawableRes val drawable: Int,
    val title: String,
    val point: Int,
)

sealed class Rank(
    @DrawableRes val drawable: Int,
    @StringRes val rank: Int,
    val minReward: Int,
    val maxReward: Int,
) {
    object HeartShake : Rank(
        drawable = R.drawable.ic_heart_badge,
        rank = R.string.rank_heart_shake,
        minReward = 0,
        maxReward = 1500,
    )

    object LumbarDisk : Rank(
        drawable = R.drawable.ic_lumbar_disk,
        rank = R.string.rank_lumbar_disk,
        minReward = 1500,
        maxReward = 3400,
    )

    object Flu : Rank(
        drawable = R.drawable.ic_flu,
        rank = R.string.rank_flu,
        minReward = 3400,
        maxReward = 5700,
    )

    object Cold : Rank(
        drawable = R.drawable.ic_cold,
        rank = R.string.rank_cold,
        minReward = 5700,
        maxReward = 8400,
    )

    object Happy : Rank(
        drawable = R.drawable.ic_happy,
        rank = R.string.rank_happy,
        minReward = 8400,
        maxReward = 10000,
    )
}