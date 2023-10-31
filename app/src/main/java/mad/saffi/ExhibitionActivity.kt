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
import java.io.InputStream
import java.util.*

class ExhibitionActivity : AppCompatActivity() {
    //binding
    lateinit var ExhibitionBinding: ActivityExhibitionBinding
    lateinit var ExhibitionView: RelativeLayout
    //
    private lateinit var  Interviewee: String
    private lateinit var  IntervieweSRC: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initialise Interviewee
        Interviewee = intent.getStringExtra("interviewee").toString()
        //initialise video
        //IntervieweSRC = intent.getStringExtra("interview_src").toString()

        IntervieweSRC ="https://www.youtube.com/embed/cnm14karKEQ?si=nENzjdDbq7muPmwU"



        ExhibitionBinding = ActivityExhibitionBinding.inflate(layoutInflater)
        ExhibitionView = ExhibitionBinding.root
        setContentView(ExhibitionView)
        LoadVideo(IntervieweSRC);
        //
        val fileName = Interviewee.toLowerCase()
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
        val videoUrl1 = "<iframe width=\"100%\" height=\"100%\" src=\"$src\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        val htmlData = """
    <html>
    <body>
        <div id="video-container">
            $videoUrl1
        </div>
        <script type="text/javascript">
            var iframe = document.querySelector('#video-container iframe');
            iframe.onload = function() {
                var shareButton = iframe.contentDocument.querySelector('.ytp-button-share');
                if (shareButton) {
                    shareButton.style.display = 'none';
                }
            };
        </script>
    </body>
    </html>
    """.trimIndent()
        ExhibitionBinding.wvVideo.settings.javaScriptEnabled = true

        ExhibitionBinding.wvVideo.loadData(htmlData, "text/html", "utf-8")
    }
}