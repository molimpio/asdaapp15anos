package br.com.sindromedoamor.asda15anos.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import br.com.sindromedoamor.asda15anos.R
import kotlinx.android.synthetic.main.fragment_links.*

class LinksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_links, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickButtons()
    }

    private fun onClickButtons() {
        btHistoria.setOnClickListener {
            openUrl("https://drive.google.com/file/d/1plZiE9CXzGFUDfNRTKe-5w24J_370_hj/view")
        }

        btShopping.setOnClickListener {
            openUrl("https://linktr.ee/shoppingdoamor")
        }

        btCeu.setOnClickListener {
            openUrl("http://olimpiodev.kinghost.net/ceudeestrelinhas/")
        }

        btCadastreSeuFilho.setOnClickListener {
            val cadastreSeuFilhoFragment = CadastreSeuFilhoFragment.newInstance()
            openFragment(cadastreSeuFilhoFragment)
        }

        btSolicitacaoHospedagem.setOnClickListener {
            val reservaHotelFragment = ReservaHotelFragment.newInstance()
            openFragment(reservaHotelFragment)
        }

        btWhatsappAmoroso.setOnClickListener {
            openWhatsapp("https://api.whatsapp.com/send?phone=+5516981161520")
        }

        btSiteOficial.setOnClickListener {
            openUrl("http://sindromedoamor.com.br/2017/")
        }

        btFolderOficial.setOnClickListener {
            openUrl("https://drive.google.com/file/d/1dVQY_KJNNu01X8rAZXK78VA1ZBlu36QU/view")
        }

        btBaixeGratuitamente.setOnClickListener {
            openUrl("http://sindromedoamor.com.br/2017/2020/05/31/2209/")
        }

        btFacaDoacao.setOnClickListener {
            openUrl("http://sindromedoamor.com.br/2017/como-ajudar/seja-associado/")
        }

        btFacebook.setOnClickListener {
            openFacebook("https://www.facebook.com/sindromedoamor")
        }

        btYoutubeT18.setOnClickListener {
            openUrl("https://www.youtube.com/trissomia18")
        }
        btInstagramSindrome.setOnClickListener {
            openUrl("https://www.instagram.com/sindromedoamor/")
        }

        btInstagramT18.setOnClickListener {
            openUrl("https://www.instagram.com/trissomia18/")
        }

        btIndiqueProfissionais.setOnClickListener {
            openUrl("https://docs.google.com/forms/d/e/1FAIpQLSdvrDvJI071oXLGfCMG0FRHxMU4WuISLvMaVQcqFEUcb64BgQ/viewform")
        }

        btFamiliasIndicam.setOnClickListener {
            openUrl("https://docs.google.com/spreadsheets/d/1iVjYHGOPwEdWvMEJ3VsyBHyXOB3zLQ9X52JyM3gfy4U/edit#gid=0")
        }

        btEstatuto.setOnClickListener {
            openUrl("http://sindromedoamor.com.br/2017/pagina-exemplo/estatuto-e-reconhecimentos/")
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun openFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    private fun openWhatsapp(url: String) {
        val packageManager = requireContext().packageManager
        try {
            val applicationInfo = packageManager.getApplicationInfo("com.whatsapp", 0)
            if (applicationInfo.enabled) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
            } else {
                openUrl(url)
            }
        } catch (e: PackageManager.NameNotFoundException) {
            openUrl(url)
        }
    }

    private fun openFacebook(url: String) {
        val packageManager = requireContext().packageManager
        try {
            val applicationInfo = packageManager.getApplicationInfo("com.facebook.katana", 0)
            if (applicationInfo.enabled) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=${url}")))
            } else {
                openUrl(url)
            }
        } catch (e: PackageManager.NameNotFoundException) {
            openUrl(url)
        }
    }

    companion object {
        fun newInstance() = LinksFragment()
    }
}