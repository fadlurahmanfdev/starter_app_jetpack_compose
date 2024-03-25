package com.fadlurahmanf.starterappcompose.core.navigation


sealed class NavRoute(val path: String) {

    data object ExampleSplashActivity : NavRoute("example_splash_activity")
    data object ListFeatureActivity : NavRoute("list_feature_activity")
    data object ExampleNavigationActivity : NavRoute("example_navigation_activity")
    data object ExampleNavigationWithArgumentActivity :
        NavRoute("example_navigation_with_argument_activity/{path1}/{path2}?optionalArg1={optionalArg1}&optionalArg2={optionalArg2}") {
        fun passPath(path1: String, path2: Int): String {
            return path.replace("{path1}", path1).replace("{path2}", "$path2")
        }

        fun passOptionalArgument1(
            path1: String,
            path2: Int,
            optionalArg1: String
        ): String {
            return path.replace("{path1}", path1).replace("{path2}", "$path2")
                .replace("{optionalArg1}", optionalArg1)
        }

        fun passOptionalArgument2(
            path1: String,
            path2: Int,
            optionalArg2: String
        ): String {
            return path.replace("{path1}", path1).replace("{path2}", "$path2")
                .replace("{optionalArg2}", optionalArg2)
        }
    }

    data object ExampleCryptoActivity : NavRoute("example_crypto_activity")
    data object ExampleUIActivity : NavRoute("example_ui_activity")
    data object ExampleApiActivity : NavRoute("example_api_activity")
}