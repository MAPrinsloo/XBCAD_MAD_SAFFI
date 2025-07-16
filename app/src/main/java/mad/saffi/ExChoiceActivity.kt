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
            //Daniel Hoorn
            "https://www.youtube.com/embed/367PU6B7GhY?si=XfSJjb4HkW2UPmJu",
            //Andre Daniels
            "https://www.youtube.com/embed/HKvMQKRtuQo?si=p2DUTaZmxGlU99wz",
            //Barry Isaacs
            "https://www.youtube.com/embed/EZTIl-rjaXo?si=Y1YTKSEAa8InnkJ6",
            //Ehrlich Erasmus
            "https://www.youtube.com/embed/q8XN6aUfs0M?si=HO9iS6a-J5APrQqo",
            //Fagrie Nasiep
            "https://www.youtube.com/embed/ojvt1ZUNw5Y?si=XvQYlQEe_-TeAW-3",
            //Isaac February
            "https://www.youtube.com/embed/3OMxJmAXD1c?si=5kRrhgCIY3tq5hOk",
            //John Bean
            "https://www.youtube.com/embed/VnSi9vNiKj4?si=5PB4DS7UQUh7IMTI",
            //Patrick Pickering
            "https://www.youtube.com/embed/bFJYPkKKacM?si=meyP0n7VTtKmESSn",
            //Quentin Rapitse
            "https://www.youtube.com/embed/g2bpNXXK-Hg?si=annctZ-pRmP5eWkJ",
            //Raven Benny
            "https://www.youtube.com/embed/FZnsfJIP0Uo?si=VtujSOPxm9oXzb0L",
            //Shawn George
            "https://www.youtube.com/embed/oOU82stw4NM?si=FgbGoji_w9NCkSaC",
            //William Newhoudt
            "https://www.youtube.com/embed/rScw91tZ66s?si=ruhK2KgLAzDbQYUe",
            //Dr Ruben
            "https://www.youtube.com/embed/uQmOMI-rZMs?si=2sVIAlVx16SnG3_U",
            //Francois Titus and Hagin Kortjie
            "https://www.youtube.com/embed/WmlYIm7V47E?si=ip_fFpQwtKZ36AFz",
            //Elizabeth
            "https://www.youtube.com/embed/Sfl75d1VMn8?si=GBxNsqx2eJFg921G"


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
            intent.putExtra("interview_src", urlList[1])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Barry
        ExChoiceBinding.imgBarry.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "barry")
            intent.putExtra("interview_src", urlList[2])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Daniel
        ExChoiceBinding.imgDaniel.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "daniel")
            intent.putExtra("interview_src", urlList[0])
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
            intent.putExtra("interview_src", urlList[8])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Raven
        ExChoiceBinding.imgRaven.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "raven")
            intent.putExtra("interview_src", urlList[9])
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
        ExChoiceBinding.imgFrance.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "francois_hagin")
            intent.putExtra("interview_src", urlList[13])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for William
        ExChoiceBinding.imgWilliam.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "william")
            intent.putExtra("interview_src", urlList[11])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Ruben
        ExChoiceBinding.imgRuben.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "ruben")
            intent.putExtra("interview_src", urlList[12])
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//
        //Logic for click for Elizabeth
        ExChoiceBinding.imgEliza.setOnClickListener()
        {
            val intent = Intent(this, ExhibitionActivity::class.java)
            intent.putExtra("interviewee", "eliza")
            intent.putExtra("interview_src", urlList[14])
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