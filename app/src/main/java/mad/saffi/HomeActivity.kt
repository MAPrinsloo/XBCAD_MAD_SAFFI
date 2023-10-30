package mad.saffi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.RelativeLayout
import androidx.core.view.isVisible
import mad.saffi.databinding.ActivityExhibitionBinding
import mad.saffi.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var HomeBinding: ActivityHomeBinding
    lateinit var HomeView: RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        HomeView = HomeBinding.root
        setContentView(HomeView)

        HomeBinding.btnAbout.setOnClickListener()
        {
            val slide = Slide()
            slide.slideEdge = Gravity.BOTTOM
            TransitionManager.beginDelayedTransition(HomeView, slide)
            HomeBinding.flSocialBottomSheet.isVisible = !HomeBinding.flSocialBottomSheet.isVisible
        }
        HomeBinding.rlHome.setOnClickListener()
        {
            if (HomeBinding.flSettings.isVisible == true)
            {
                CloseSettings()
            }
            if (HomeBinding.flSocialBottomSheet.isVisible == true)
            {
                CloseSocials()
            }
        }
        //----------------------------------------------------------------------------------------//
        //Settings click
        HomeBinding.mtHome.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.account) {
                val rightSlide = Slide()
                rightSlide.slideEdge = Gravity.END
                TransitionManager.beginDelayedTransition(HomeBinding.flSettings, rightSlide)
                HomeBinding.flSettings.isVisible =
                    !HomeBinding.flSettings.isVisible
                true
            } else {
                false
            }
        }

    }
    private fun CloseSettings():Boolean
    {
        TransitionManager.endTransitions(HomeView)

        val slide = Slide()
        slide.slideEdge = Gravity.END
        TransitionManager.beginDelayedTransition(HomeBinding.flSettings, slide)
        HomeBinding.flSettings.isVisible = false
        return true
    }
    private fun CloseSocials():Boolean
    {
        TransitionManager.endTransitions(HomeView)

        val slide = Slide()
        slide.slideEdge = Gravity.BOTTOM
        TransitionManager.beginDelayedTransition(HomeBinding.flSocialBottomSheet, slide)
        HomeBinding.flSocialBottomSheet.isVisible = false
        HomeBinding.tgSelect.clearChecked()
        return true

    }
}