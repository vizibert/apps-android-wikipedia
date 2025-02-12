package org.wikipedia.homeworks.homework05

import io.github.kakaocup.kakao.slider.KSlider
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

class ThemeScreen  {

    val textSettingsTitle = KTextView {
        withId(R.id.textSettingsCategory)
    }

    val textSize = KTextView {
        withId(R.id.text_size_percent)
    }

    val textSizeSlider = KSlider {
        withId(R.id.text_size_seek_bar)
    }

    val sansSerif = KButton {
        withId(R.id.button_font_family_sans_serif)
    }

    val serifButton = KButton {
        withId(R.id.button_font_family_serif)
    }

    val readingModeSwitch = KSwitch {
        withId(R.id.theme_chooser_reading_focus_mode_switch)
    }

    val readingModeDescription = KTextView {
        withId(R.id.theme_chooser_reading_focus_mode_description)
    }

    val themeTitle = KTextView {
        withText(R.string.color_theme_select)
    }

    val buttonThemeLight = KButton {
        withId(R.id.button_theme_light)
    }

    val buttonThemeDark = KButton {
        withId(R.id.button_theme_dark)
    }

    val buttonThemeSepia = KButton {
        withId(R.id.button_theme_sepia)
    }

    val buttonThemeBlack = KButton {
        withId(R.id.button_theme_black)
    }

    val systemThemeChooserSwitch = KSwitch {
        withId(R.id.theme_chooser_match_system_theme_switch)
    }

    val dimImageSwitch = KSwitch {
        withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    }
}