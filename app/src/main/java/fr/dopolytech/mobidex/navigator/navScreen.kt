package fr.dopolytech.mobidex.navigator

import androidx.annotation.StringRes
import fr.dopolytech.mobidex.R

enum class navScreen(@StringRes val title: Int) {
    StartPage(title = R.string.app_name),
    DetailPage(title = R.string.detail_page),
}
