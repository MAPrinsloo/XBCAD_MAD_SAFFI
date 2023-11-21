package mad.saffi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.webkit.WebChromeClient
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import mad.saffi.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    //
    lateinit var HomeBinding: ActivityHomeBinding
    lateinit var HomeView: RelativeLayout
    private val RubenVidSRC = "https://www.youtube.com/embed/Q7eWC_UD-oo?si=-k_jaFFKmFvxekW7"
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        HomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        HomeView = HomeBinding.root
        setContentView(HomeView)
        LoadVideo(RubenVidSRC)
        //

        //----------------------------------------------------------------------------------------//
        //About button click
        //toggle view on the social fragment
        HomeBinding.btnAbout.setOnClickListener()
        {
            val slide = Slide()
            slide.slideEdge = Gravity.BOTTOM
            TransitionManager.beginDelayedTransition(HomeView, slide)
            HomeBinding.flSocialBottomSheet.isVisible = !HomeBinding.flSocialBottomSheet.isVisible
        }
        //----------------------------------------------------------------------------------------//
        //
        HomeBinding.btnMAD.setOnClickListener()
        {
            val intent = Intent(this, ExChoiceActivity::class.java)
            startActivity(intent)
            HomeBinding.tgSelect.clearChecked()
        }
        //----------------------------------------------------------------------------------------//
        //On background click
        //Closes all fragments
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
        //Settings icon click
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
    //----------------------------------------------------------------------------------------//
    //Closes the settings fragment
    private fun CloseSettings()
    {
        val slide = Slide()
        slide.slideEdge = Gravity.END
        TransitionManager.beginDelayedTransition(HomeBinding.flSettings, slide)
        HomeBinding.flSettings.isVisible = false
    }
    //----------------------------------------------------------------------------------------//
    //Closes the social fragment
    private fun CloseSocials()
    {
        val slide = Slide()
        slide.slideEdge = Gravity.BOTTOM
        TransitionManager.beginDelayedTransition(HomeBinding.flSocialBottomSheet, slide)
        HomeBinding.flSocialBottomSheet.isVisible = false
        HomeBinding.tgSelect.clearChecked()
    }
    private fun LoadVideo(src:String)
    {
        HomeBinding.wvVideo.settings.mediaPlaybackRequiresUserGesture = false
        val videoUrl = "<iframe width=\"100%\" height=\"100%\" src=\"$src\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"

        HomeBinding.wvVideo.loadData(videoUrl, "text/html", "utf-8")
        HomeBinding.wvVideo.settings.javaScriptEnabled = true
        HomeBinding.wvVideo.setWebChromeClient(WebChromeClient())
    }
}
//