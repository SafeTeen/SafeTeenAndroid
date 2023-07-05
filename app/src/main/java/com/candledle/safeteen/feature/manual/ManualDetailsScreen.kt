package com.candledle.safeteen.feature.manual

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.candledle.safeteen.R
import com.candledle.safeteen.component.Header
import com.candledle.safeteen.design_system.theme.Body3
import com.candledle.safeteen.design_system.theme.Body4

@Composable
internal fun ManualDetailsScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Header(text = "화재 메뉴얼") {
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.height(12.dp))
            Body3(text = "[쿠팡 ‘안전불감증’ 화재규모 키워]")
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_coupang),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Body4(
                text = "쿠팡 덕평 물류센터에서 발생한 화재사고는 쿠팡의 안전불감증으로 사고규모를 키운 것으로 드러났다.\n" +
                        "\n" +
                        "이번 사고는 쿠팡측의 초기대응과 안전관리가 매우 부실해 화재규모를 키웠다는 주장이 제기됐다. 관리자가 스프링클러 수신기를 임의로 조작해 화재 초기 스프링클러가 작동하지 않아 초기진압이 지연 됐다는 것이다.\n" +
                        "\n" +
                        "쿠팡의 안전불감증, 노동차 처우문제, 김 의장의 책임회피 의혹 등 문제가 불거지면서 소비자들의 불매운동이 거세지고 있다.",
            )
            Spacer(modifier = Modifier.height(20.dp))
            Body3(text = "[화재가 발생했을 때는?]")
            Spacer(modifier = Modifier.height(8.dp))
            Body4(
                text = "탈출이 가능한 경우\n" +
                        "- 화재 경보장치를 눌러 같은 아파트 사람들한테 화재 난 사실을 알립니다.\n" +
                        "- 손수건이나 옷등으로 호흡기로 연기가 들어오지 못하게 보호하면서 낮은 자세를 유지하고 신속하게  탈출합니다.\n" +
                        "- 화재로부터 안전이 확인된 상태라면 119에 신속하게 신고합니다.\n" +
                        "\n" +
                        "불길에 발이 묶인 상황의 경우\n" +
                        "- 밖에 상황을 모르는 상황에서 무리하게 탈출 시 위험하므로 문 손잡이를 잡아 뜨거운 경우에는 안에서 기다리면서 구조를 기다려야 합니다.\n" +
                        "- 빨리 탈출하기 위해서 해당 구조대가 찾기 쉽게 주변에 옷가지나 수건들로 흔들어서 위치를 확인시켜줍니다.",
            )
        }
    }
}