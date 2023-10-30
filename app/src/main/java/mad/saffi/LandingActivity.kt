package mad.saffi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.RelativeLayout
import androidx.core.view.isVisible
import mad.saffi.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    lateinit var LandingBinding: ActivityLandingBinding
    lateinit var LandingView: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LandingBinding = ActivityLandingBinding.inflate(layoutInflater)
        LandingView = LandingBinding.root
        setContentView(R.layout.activity_landing)

        LandingBinding.btnHome.setOnClickListener()
        {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        LandingBinding.btnAboutSaffi.setOnClickListener()
        {
            val slide = Slide()
            slide.slideEdge = Gravity.BOTTOM
            TransitionManager.beginDelayedTransition(LandingBinding.root, slide)
            LandingBinding.flSocialBottomSheet.isVisible = !LandingBinding.flSocialBottomSheet.isVisible
        }

        LandingBinding.rlLanding.setOnClickListener()
        {
            if (LandingBinding.flSocialBottomSheet.isVisible == true)
            {
                CloseSocials()
            }
        }

    }

    private fun CloseSocials()
    {
        TransitionManager.endTransitions(LandingBinding.root)
        val slide = Slide()
        slide.slideEdge = Gravity.BOTTOM
        TransitionManager.beginDelayedTransition(LandingBinding.flSocialBottomSheet, slide)
        LandingBinding.flSocialBottomSheet.isVisible = false
    }





}