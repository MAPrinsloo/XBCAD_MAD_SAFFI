package mad.saffi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import mad.saffi.databinding.FragmentSettingsBinding
class SettingsFragment : Fragment() {
    lateinit var SettingsBinding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        SettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)

        SettingsBinding.btnSignOUt.setOnClickListener()
        {
            val intent = Intent(requireContext(), LandingActivity::class.java)
            startActivity(intent)
        }

        return SettingsBinding.root
    }
}