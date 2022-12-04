package br.com.sindromedoamor.asda15anos.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import br.com.sindromedoamor.asda15anos.R
import kotlinx.android.synthetic.main.fragment_cadastre_seu_filho.*

class CadastreSeuFilhoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cadastre_seu_filho, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wvCadastreSeuFilho.settings.javaScriptEnabled = true
        wvCadastreSeuFilho.settings.setSupportZoom(true)
        wvCadastreSeuFilho.loadUrl("https://docs.google.com/forms/u/0/d/e/1FAIpQLSd6DuTjDZ94NoiiSWPDqY0bOYR_9XDVgqTm-vnXdX9O0Y29uw/formResponse?embedded=true")
        wvCadastreSeuFilho.webViewClient = WebViewClient()
    }

    companion object {
        private const val FRAGMENT_CADASTRE_SEU_FILHO = "fragmentCadastreSeuFilho"
        fun newInstance() = CadastreSeuFilhoFragment()
    }
}