package com.captaindeer.myinstagram.ui.main

import androidx.fragment.app.Fragment
import com.captaindeer.myinstagram.ui.bases.BaseView

interface MainInterface {

    interface Presenter {

    }
    interface View: BaseView {
        fun changeFragment(fragment: Fragment)
    }

}