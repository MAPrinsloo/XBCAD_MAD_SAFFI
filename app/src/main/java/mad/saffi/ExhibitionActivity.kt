package mad.saffi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.RelativeLayout
import androidx.core.view.isVisible
import mad.saffi.databinding.ActivityExhibitionBinding

class ExhibitionActivity : AppCompatActivity() {
    //binding
    lateinit var ExhibitionBinding: ActivityExhibitionBinding
    lateinit var ExhibitionView: RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ExhibitionBinding = ActivityExhibitionBinding.inflate(layoutInflater)
        ExhibitionView = ExhibitionBinding.root
        setContentView(ExhibitionView)
        //----------------------------------------------------------------------------------------//
        //acknowledgements click
        //Opens acknowledgements page
        ExhibitionBinding.btnAcknowledgements.setOnClickListener()
        {
            val intent = Intent(this, AcknowledgementsActivity::class.java)
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Back click
        ExhibitionBinding.mtExhibition.setOnClickListener()
        {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Settings icon click
        ExhibitionBinding.mtExhibition.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.account) {
                val rightSlide = Slide()
                rightSlide.slideEdge = Gravity.END
                TransitionManager.beginDelayedTransition(ExhibitionBinding.flSettings, rightSlide)
                ExhibitionBinding.flSettings.isVisible =
                    !ExhibitionBinding.flSettings.isVisible
                true
            } else {
                false
            }
        }
        //----------------------------------------------------------------------------------------//
        //On background click
        //Closes all fragments
        ExhibitionBinding.rlExhibition.setOnClickListener()
        {
            if (ExhibitionBinding.flSettings.isVisible == true)
            {
                CloseSettings()
            }
        }
    }
    //----------------------------------------------------------------------------------------//
    //Closes the settings fragment
    private fun CloseSettings()
    {
        val slide = Slide()
        slide.slideEdge = Gravity.END
        TransitionManager.beginDelayedTransition(ExhibitionBinding.flSettings, slide)
        ExhibitionBinding.flSettings.isVisible = false
    }
}