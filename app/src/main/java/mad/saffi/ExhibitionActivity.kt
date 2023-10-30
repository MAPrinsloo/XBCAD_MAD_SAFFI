package mad.saffi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import mad.saffi.databinding.ActivityExhibitionBinding

class ExhibitionActivity : AppCompatActivity() {
    //binding
    lateinit var ExhibitionBinding: ActivityExhibitionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exhibition)

        ExhibitionBinding = ActivityExhibitionBinding.inflate(layoutInflater)
        val ExhibitionView = ExhibitionBinding.root
        setContentView(ExhibitionView)

        ExhibitionBinding.btnAcknowledgements.setOnClickListener()
        {

        }
    }
}