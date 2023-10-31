package mad.saffi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.RelativeLayout
import androidx.core.view.isVisible
import mad.saffi.databinding.ActivityExChoiceBinding
import mad.saffi.databinding.ActivityExhibitionBinding

class ExChoiceActivity : AppCompatActivity() {
    //binding
    lateinit var ExChoiceBinding: ActivityExChoiceBinding
    lateinit var ExChoiceView: RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ExChoiceBinding = ActivityExChoiceBinding.inflate(layoutInflater)
        ExChoiceView = ExChoiceBinding.root
        setContentView(ExChoiceView)

        val urlList = mutableListOf(
            "https://www.youtube.com/embed/xWbGaUApvaw?si=GMVpE_FtjtuAUAV-",
            "https://www.youtube.com/embed/1YdPY1HhCts?si=efA0vriOpCEQhEfR",
            "https://www.youtube.com/embed/ODP06L8yzsI?si=cFl1jru6oH1zul1A",
            "https://www.youtube.com/embed/HedSajfNjiE?si=LdJ5JD4WlLr5P4xN",
            "https://www.youtube.com/embed/7fcABOqNRSk?si=NGIFDT2eqzQqihzB",
            "https://www.youtube.com/embed/-Zs3uB-QW1M?si=ytshQUrGlEkTCPeO",
            "https://www.youtube.com/embed/8l44xyG0Wfg?si=p6vRLo7EpL8UM_UU",
            "https://www.youtube.com/embed/PYc1oUoWnaA?si=Segm70Ph8kq2E8DZ",
            "https://www.youtube.com/embed/WYBvVbb8Igc?si=TpQq8a6QqdQ8NWcb",
            "https://www.example.com/url10",
            "https://www.example.com/url11",
            "https://www.example.com/url12",
            "https://www.example.com/url13"
        )

        //----------------------------------------------------------------------------------------//
        //Settings icon click
        ExChoiceBinding.mtExChoice.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.account) {
                val rightSlide = Slide()
                rightSlide.slideEdge = Gravity.END
                TransitionManager.beginDelayedTransition(ExChoiceBinding.flSettings, rightSlide)
                ExChoiceBinding.flSettings.isVisible =
                    !ExChoiceBinding.flSettings.isVisible
                true
            } else {
                false
            }
        }
        //----------------------------------------------------------------------------------------//
        //Back click
        ExChoiceBinding.mtExChoice.setOnClickListener()
        {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //On background click
        //Closes all fragments
        ExChoiceBinding.rlExChoice.setOnClickListener()
        {
            if (ExChoiceBinding.flSettings.isVisible == true)
            {
                CloseSettings()
            }
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgAndre.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "andre")
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgBarry.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "barry")
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgDaniel.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "daniel")
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgEhrlich.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "ehrlich")
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgFagri.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "fagrie")
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgIsaac.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "isaac")
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgJohn.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "john")
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgPatrick.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "patrick")
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgQuentin.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "quentin")
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgRaven.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "raven")
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgShawn.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "shawn")
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgFrancoisHagin.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "francois_hagin")
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgWilliam.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "william")
            startActivity(intent)
        }
    }
    //----------------------------------------------------------------------------------------//
    //Closes the settings fragment
    private fun CloseSettings()
    {
        val slide = Slide()
        slide.slideEdge = Gravity.END
        TransitionManager.beginDelayedTransition(ExChoiceBinding.flSettings, slide)
        ExChoiceBinding.flSettings.isVisible = false
    }
}