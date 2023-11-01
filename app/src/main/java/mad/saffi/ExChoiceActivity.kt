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
            "https://www.youtube.com/embed/EKNU-Gch4cA?si=hZmDhmIl-1C2Id0U",
            "https://www.youtube.com/embed/27KzNfDbm60?si=CcdZT67-bnHRrjT5",
            "https://www.youtube.com/embed/ob_cmoKERxA?si=11N2ZEdL9ls4EHzJ",
            "https://www.youtube.com/embed/PdPPRFc8O6o?si=dbUphL0ux6qepH2f"
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
            intent.putExtra("interview_src", urlList[0])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgBarry.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "barry")
            intent.putExtra("interview_src", urlList[1])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgDaniel.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "daniel")
            intent.putExtra("interview_src", urlList[2])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgEhrlich.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "ehrlich")
            intent.putExtra("interview_src", urlList[3])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgFagri.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "fagrie")
            intent.putExtra("interview_src", urlList[4])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgIsaac.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "isaac")
            intent.putExtra("interview_src", urlList[5])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgJohn.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "john")
            intent.putExtra("interview_src", urlList[6])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgPatrick.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "patrick")
            intent.putExtra("interview_src", urlList[7])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgQuentin.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "quentin")
            intent.putExtra("interview_src", urlList[9])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgRaven.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "raven")
            intent.putExtra("interview_src", urlList[8])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgShawn.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "shawn")
            intent.putExtra("interview_src", urlList[10])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgFrancoisHagin.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "francois_hagin")
            intent.putExtra("interview_src", urlList[11])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //
        ExChoiceBinding.imgWilliam.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "william")
            intent.putExtra("interview_src", urlList[12])
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