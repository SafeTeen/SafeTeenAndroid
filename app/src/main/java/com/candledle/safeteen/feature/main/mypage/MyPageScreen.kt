package com.candledle.safeteen.feature.main.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.candledle.safeteen.R
import com.candledle.safeteen.component.MyQna
import com.candledle.safeteen.design_system.theme.Body1
import com.candledle.safeteen.design_system.theme.Body3
import com.candledle.safeteen.design_system.theme.Caption
import com.candledle.safeteen.design_system.theme.Heading6
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
internal fun MyPageScreen(
    navController: NavController,
) {

    val onClickEditProfile = {

    }

    val onClickSignOut = {

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SafeColor.Gray300),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Heading6(text = stringResource(id = R.string.navigation_my_page))
            Spacer(modifier = Modifier.height(12.dp))
            MyInformation(
                profileImageUrl = "",
                name = "name",
                currentReward = "1212",
                currentRank = "1222",
            )
            Spacer(modifier = Modifier.height(20.dp))
            Body3(text = stringResource(id = R.string.my_page_qna))
            Spacer(modifier = Modifier.height(8.dp))
            MyQnas(questions = listOf(QnA("seifjseifj"), QnA("sejisejfisj")))
            Spacer(modifier = Modifier.height(20.dp))
            Body3(text = stringResource(id = R.string.my_page_manage_account))
            Spacer(modifier = Modifier.height(8.dp))
            MyQna(
                question = stringResource(id = R.string.my_page_edit_profile),
                onClick = onClickEditProfile,
                backgroundColor = SafeColor.White,
            )
            Spacer(modifier = Modifier.height(8.dp))
            MyQna(
                question = stringResource(id = R.string.my_page_sign_out),
                questionColor = SafeColor.Red,
                onClick = onClickSignOut,
                backgroundColor = SafeColor.White,
            )
        }
    }
}

@Composable
private fun MyInformation(
    profileImageUrl: String,
    name: String,
    currentReward: String,
    currentRank: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = SafeColor.White)
            .padding(
                horizontal = 14.dp,
                vertical = 12.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(color = SafeColor.Gray300),
            contentAlignment = Alignment.Center,
        ) {
            AsyncImage(
                model = profileImageUrl,
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Body1(text = name)
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Caption(
                    text = stringResource(id = R.string.my_page_current_reward),
                    color = SafeColor.Gray800,
                )
                Spacer(modifier = Modifier.width(2.dp))
                Caption(text = currentReward)
                Spacer(modifier = Modifier.width(8.dp))
                Caption(
                    text = stringResource(id = R.string.my_page_cureent_rank),
                    color = SafeColor.Gray800,
                )
                Spacer(modifier = Modifier.width(2.dp))
                Caption(text = currentRank)
            }
        }
    }
}

@Composable
private fun MyQnas(
    questions: List<QnA>,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(questions) {
            MyQna(
                question = it.question,
                backgroundColor = SafeColor.White,
            )
        }
    }
}

data class QnA(
    val question: String,
)