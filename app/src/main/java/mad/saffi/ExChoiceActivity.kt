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

        //A Mutable List to Store All of the YouTube URLs
        val urlList = mutableListOf(
            //Andre Daniels
            "https://www.youtube.com/embed/zu22I6iGQO8?si=GfYEdj6DfOGa4R7l",
            //Barry Isaacs
            "https://www.youtube.com/embed/1YdPY1HhCts?si=efA0vriOpCEQhEfR",
            //Daniel Hoorn
            "https://www.youtube.com/embed/3_DJvAVpl7M?si=SyD51UDS_wn38cyh",
            //Ehrlich Erasmus
            "https://www.youtube.com/embed/19SC8z8hn8s?si=5x6-yGfvMStCPlMK",
            //Fagrie Nasiep
            "https://www.youtube.com/embed/Wg9mZGJ9d4s?si=KPSWRvPdy9bRTv6Z",
            //Isaac February
            "https://www.youtube.com/embed/-Zs3uB-QW1M?si=ytshQUrGlEkTCPeO",
            //John Bean
            "https://www.youtube.com/embed/K74YDXxXMjs?si=J9gKx05Vzr_UjnsE",
            //Patrick Pickering
            "https://www.youtube.com/embed/PYc1oUoWnaA?si=Segm70Ph8kq2E8DZ",
            //Quentin Rapitse
            "https://www.youtube.com/embed/WYBvVbb8Igc?si=TpQq8a6QqdQ8NWcb",
            //Raven Benny
            "https://www.youtube.com/embed/EKNU-Gch4cA?si=hZmDhmIl-1C2Id0U",
            //Shawn George
            "https://www.youtube.com/embed/_m8scazcNaY?si=BpaaU0UxHnFonym2",
            //Francois Titus and Hagin Kortjie
            "https://www.youtube.com/embed/WmlYIm7V47E?si=U9E0U_hHhhFLLY9F",
            //William Newhoudt
            "https://www.youtube.com/embed/PdPPRFc8O6o?si=dbUphL0ux6qepH2f"
        )

        //----------------------------------------------------------------------------------------//
        //Settings Icon Click
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
        //Back Click
        ExChoiceBinding.mtExChoice.setOnClickListener()
        {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //On Background Click
        //Closes All Fragments
        ExChoiceBinding.rlExChoice.setOnClickListener()
        {
            if (ExChoiceBinding.flSettings.isVisible == true)
            {
                CloseSettings()
            }
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Andre
        ExChoiceBinding.imgAndre.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "andre")
            intent.putExtra("interview_src", urlList[0])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Barry
        ExChoiceBinding.imgBarry.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "barry")
            intent.putExtra("interview_src", urlList[1])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Daniel
        ExChoiceBinding.imgDaniel.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "daniel")
            intent.putExtra("interview_src", urlList[2])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Ehrlich
        ExChoiceBinding.imgEhrlich.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "ehrlich")
            intent.putExtra("interview_src", urlList[3])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Fagri
        ExChoiceBinding.imgFagri.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "fagrie")
            intent.putExtra("interview_src", urlList[4])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Isaac
        ExChoiceBinding.imgIsaac.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "isaac")
            intent.putExtra("interview_src", urlList[5])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for John
        ExChoiceBinding.imgJohn.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "john")
            intent.putExtra("interview_src", urlList[6])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Patrick
        ExChoiceBinding.imgPatrick.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "patrick")
            intent.putExtra("interview_src", urlList[7])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Quentin
        ExChoiceBinding.imgQuentin.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "quentin")
            intent.putExtra("interview_src", urlList[9])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Raven
        ExChoiceBinding.imgRaven.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "raven")
            intent.putExtra("interview_src", urlList[8])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Shawn
        ExChoiceBinding.imgShawn.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "shawn")
            intent.putExtra("interview_src", urlList[10])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Fancois
        ExChoiceBinding.imgFrancoisHagin.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "francois_hagin")
            intent.putExtra("interview_src", urlList[11])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for William
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