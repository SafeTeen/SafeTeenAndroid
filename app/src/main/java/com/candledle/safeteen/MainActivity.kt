package com.candledle.safeteen

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.candledle.safeteen.design_system.theme.SafeteenTheme
import com.candledle.safeteen.feature.landing.LandingScreen
import com.candledle.safeteen.feature.main.MainScreen
import com.candledle.safeteen.feature.manual.ManualDetailsScreen
import com.candledle.safeteen.feature.question.CreateQuestion
import com.candledle.safeteen.feature.question.QuestionDetailsScreen
import com.candledle.safeteen.feature.signin.SignInScreen
import com.candledle.safeteen.feature.signup.SignUpScreen
import com.candledle.safeteen.navigation.SafeNavigation
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import org.json.JSONArray


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SharedPreferencesFlipperPlugin.SharedPreferencesDescriptor(
            "Safeteen",
            MODE_PRIVATE,
        )

        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        setContent {

            SafeteenTheme {

                val navHostController = rememberNavController()

                val preferences = getPreferences(this)

                if(!preferences.getBoolean(PrefKey.App.init, false)) {
                    setAppData(editor = preferences.edit())
                }
                NavHost(
                    navController = navHostController,
                    startDestination = SafeNavigation.Landing,
                ) {
                    composable(
                        route = SafeNavigation.Landing,
                    ) {
                        LandingScreen(navController = navHostController)
                    }

                    composable(
                        route = SafeNavigation.SignIn,
                    ) {
                        SignInScreen(navController = navHostController)
                    }

                    composable(
                        route = SafeNavigation.SignUp,
                    ) {
                        SignUpScreen(navController = navHostController)
                    }

                    composable(
                        route = SafeNavigation.Main,
                    ) {
                        MainScreen(navController = navHostController)
                    }

                    composable(
                        route = SafeNavigation.CreateQuestion
                    ) {
                        CreateQuestion(navController = navHostController)
                    }

                    composable(
                        route = SafeNavigation.QuestionDetails,
                        arguments = listOf(
                            navArgument("index") {
                                type = NavType.IntType
                            }
                        )
                    ) {
                        it.arguments?.run {
                            val index = getInt("index")
                            QuestionDetailsScreen(
                                navController = navHostController,
                                index = index,
                            )
                        }
                    }

                    composable(
                        route = SafeNavigation.ManualDetails,
                    ) {
                        ManualDetailsScreen(navController = navHostController)
                    }
                }
            }
        }
    }

    private fun setAppData(
        editor: SharedPreferences.Editor,
    ) {
        editor.apply {
            putList(
                PrefKey.User.descriptions, listOf(
                    "학교에서 지진이 났을 때 책상 아래가 더 안전한가요, 아니면 운동장으로 나가는게 더 안전한가요?",
                    "저의 안전불감증을 해결해보세요",
                )
            )


            putList(
                PrefKey.Common.qnas, listOf(
                    "학교에서 지진 났을 때 책상 아래 vs 운동장으로 질주 뭐가 좋을까요??",
                    "안전불감증 해결방법 추천 받는다",
                    "기숙사에서 계속 실수로 화재 경보기가 울리는데 점점 안전불감증이 생겨요 어떡할까요 안녕하세요 정말 걱정이네요",
                )
            )
            putList(
                PrefKey.Common.descriptions, listOf(
                    "학교에서 지진이 났을 때 책상 아래가 더 안전한가요, 아니면 운동장으로 나가는게 더 안전한가요?",
                    "저의 안전불감증을 해결해보세요",
                    "범인은 바로.."
                )
            )
            putList(
                PrefKey.Common.answers, listOf(
                    "저는 운동장으로 질주합니다 책상 아래로 가는 하남자가 어딨나용??,괜히 달려서 다치는 것보단 책상 아래가... 더 안전할 듯",
                    "가스불 키고 손 10초만 대봐라..,당장 8층 높이의 아파트에서 떨어지세요",
                    "어 저 그거 누군지 알아요!,아 그거 사실 사감쌤이 키는거에요 ㅋㅋ,아이 누가보면 진짠줄 알겠네"
                )
            )
            putBoolean(PrefKey.App.init, true)
        }.apply()
    }
}

fun getPreferences(context: Context): SharedPreferences =
    context.getSharedPreferences("SafeTeen", Context.MODE_PRIVATE)

object PrefKey {
    object User {
        const val id = "id"
        const val password = "password"
        const val name = "name"
        const val reward = "reward"
        const val qnas = "myQnas"
        const val badge = "badge"
        const val descriptions = "myDescriptions"
    }

    object Common {
        const val qnas = "qnas"
        const val descriptions = "descriptions"
        const val answers = "answers"
    }

    object App{
        const val init = "init"
    }
}

fun SharedPreferences.Editor.putList(
    key: String,
    list: List<String>,
) {
    val jsonArray = JSONArray()
    list.forEach {
        jsonArray.put(it)
    }
    putString(key, jsonArray.toString())
}

fun SharedPreferences.getList(
    key: String,
): List<String> {
    val json = getString(key, null)
    val list = arrayListOf<String>()
    if (json != null) {
        val jsonArray = JSONArray(json)
        for (i in 0 until jsonArray.length()) {
            list.add(jsonArray.optString(i))
        }
    }

    return list
}

sealed class Badge(
    @DrawableRes val drawable: Int,
    val name: String,
    val point: Int,
) {
    object Crown : Badge(
        drawable = R.drawable.ic_crown_badge,
        name = "왕관 뱃지",
        point = 600,
    )

    object Silicon : Badge(
        drawable = R.drawable.ic_silicon_badge,
        name = "별 리본 뱃지",
        point = 500,
    )

    object Trophy : Badge(
        drawable = R.drawable.ic_trophy_badge,
        name = "트로피 뱃지",
        point = 600,
    )

    object Heart : Badge(
        drawable = R.drawable.ic_heart_badge,
        name = "하트 뱃지",
        point = 1000,
    )

    object Star : Badge(
        drawable = R.drawable.ic_star_badge,
        name = "별 뱃지",
        point = 1500,
    )

    object Dsm : Badge(
        drawable = R.drawable.ic_dsm_badge,
        name = "DSM 뱃지",
        point = 2500,
    )

    companion object {
        fun getBadge(drawable: Int): Badge? {
            return when (drawable) {
                R.drawable.ic_crown_badge -> Crown
                R.drawable.ic_silicon_badge -> Silicon
                R.drawable.ic_trophy_badge -> Trophy
                R.drawable.ic_heart_badge -> Heart
                R.drawable.ic_star_badge -> Star
                R.drawable.ic_dsm_badge -> Dsm
                else -> null
            }
        }

        fun getBadge(name: String?): Badge? {
            return when (name?.uppercase()) {
                "CROWN" -> Crown
                "SILICON" -> Silicon
                "TROPHY" -> Trophy
                "HEART" -> Heart
                "STAR" -> Star
                "DSM" -> Dsm
                else -> null
            }
        }
    }
}