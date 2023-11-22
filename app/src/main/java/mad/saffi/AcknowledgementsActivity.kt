package mad.saffi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import mad.saffi.databinding.ActivityAcknowledgementsBinding
import mad.saffi.databinding.ActivityLandingBinding
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import androidx.core.view.isVisible

class AcknowledgementsActivity : AppCompatActivity() {
    //Binding
    lateinit var AcknowledgementBinding: ActivityAcknowledgementsBinding
    lateinit var AcknowledgementView : RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AcknowledgementBinding = ActivityAcknowledgementsBinding.inflate(layoutInflater)
        AcknowledgementView = AcknowledgementBinding.root
        setContentView(AcknowledgementView)

        //Starts ExhibitionActivity when clicked
        AcknowledgementBinding.mtExhibition.setOnClickListener()
        {
            var intent = Intent(this, ExhibitionActivity::class.java)
            startActivity(intent)
        }

        //Click Listener
        AcknowledgementBinding.mtExhibition.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.account) {
                val rightSlide = Slide()
                rightSlide.slideEdge = Gravity.END
                TransitionManager.beginDelayedTransition(AcknowledgementBinding.flSettings, rightSlide)
                AcknowledgementBinding.flSettings.isVisible =
                    !AcknowledgementBinding.flSettings.isVisible
                true
            } else {
                false
            }
        }

        AcknowledgementBinding.rlAcknowledgements.setOnClickListener()
        {
            if (AcknowledgementBinding.flSettings.isVisible == true)
            {
                CloseSettings()
            }
        }
    }
    private fun CloseSettings()
    {
        val slide = Slide()
        slide.slideEdge = Gravity.END
        TransitionManager.beginDelayedTransition(AcknowledgementBinding.flSettings, slide)
        AcknowledgementBinding.flSettings.isVisible = false
    }
}