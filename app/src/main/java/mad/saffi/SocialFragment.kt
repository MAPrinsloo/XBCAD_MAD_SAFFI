package mad.saffi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mad.saffi.databinding.FragmentSettingsBinding
import mad.saffi.databinding.FragmentSocialBinding

class SocialFragment : Fragment() {
    //Binding
    lateinit var SocialBinding: FragmentSocialBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        SocialBinding = FragmentSocialBinding.inflate(inflater, container, false)

        //----------------------------------------------------------------------------------------//
        //CLick Listener
        SocialBinding.ivFacebook.setOnClickListener {
            val facebookUrl = getString(R.string.facebook_link)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl))
            startActivity(intent)
        }

        SocialBinding.ivWeb.setOnClickListener {
            val webUrl = getString(R.string.web_link)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))
            startActivity(intent)
        }

        SocialBinding.ivEmail.setOnClickListener {
            val email = getString(R.string.email_link)
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
            startActivity(intent)
        }

        SocialBinding.ivPhone.setOnClickListener {
            val phoneNumber = getString(R.string.phone_link)
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }
        //----------------------------------------------------------------------------------------//



        return SocialBinding.root

    }
}