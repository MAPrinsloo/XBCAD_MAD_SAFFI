package mad.saffi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.RelativeLayout
import androidx.core.view.isVisible
import mad.saffi.databinding.ActivityExhibitionBinding
import java.io.InputStream
import java.util.*

class ExhibitionActivity : AppCompatActivity() {
    //binding
    lateinit var ExhibitionBinding: ActivityExhibitionBinding
    lateinit var ExhibitionView: RelativeLayout
    //
    private lateinit var  Interviewee: String
    private lateinit var  InterviewSRC: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initialise Interviewee
        Interviewee = intent.getStringExtra("interviewee").toString()
        //initialise video
        InterviewSRC = intent.getStringExtra("interview_src").toString()

        ExhibitionBinding = ActivityExhibitionBinding.inflate(layoutInflater)
        ExhibitionView = ExhibitionBinding.root
        setContentView(ExhibitionView)

        LoadVideo(InterviewSRC)
        //
        val fileName = Interviewee.lowercase(Locale.getDefault())
        val resourceId = resources.getIdentifier(fileName, "raw", packageName)

        //
        val inputStream: InputStream = resources.openRawResource(resourceId)

        val scanner = Scanner(inputStream)
        val stringBuilder = StringBuilder()
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine())
            stringBuilder.append("\n")
        }
        val storyContent = stringBuilder.toString()

        ExhibitionBinding.tvDisplay.text = storyContent

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
            val intent = Intent(this, ExChoiceActivity::class.java)
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
    private fun LoadVideo(src:String)
    {
        ExhibitionBinding.wvVideo.settings.mediaPlaybackRequiresUserGesture = false
        val videoUrl = "<iframe width=\"100%\" height=\"100%\" src=\"$src\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"

        ExhibitionBinding.wvVideo.loadData(videoUrl, "text/html", "utf-8")
        ExhibitionBinding.wvVideo.settings.javaScriptEnabled = true
        ExhibitionBinding.wvVideo.webChromeClient = WebChromeClient()
    }
}