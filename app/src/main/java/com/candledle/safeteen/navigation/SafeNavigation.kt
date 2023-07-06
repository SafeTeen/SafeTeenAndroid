package com.candledle.safeteen.navigation

object SafeNavigation{

    const val Landing = "lading"

    const val SignIn = "signIn"
    const val SignUp = "signUp"

    const val Main = "main"

    const val CreateQuestion = "createQuestion"
    const val QuestionDetails = "createQuestion${Path.index}"

    const val ManualDetails = "manualDetails"

    object Path{
        const val index = "/{index}"
    }

    object Navigation{
        const val Home = "home"
        const val Game = "game"
        const val Info = "info"
        const val Shop = "shop"
        const val MyPage = "myPage"
    }
}