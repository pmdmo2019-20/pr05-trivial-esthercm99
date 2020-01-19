package ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import data.GameSettings

import es.iessaladillo.pedrojoya.pr05_trivial.R

class AboutFragment : Fragment(R.layout.about_fragment) {
    companion object {
        fun newInstance() = AboutFragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupAppBar()
    }
    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.title_mnuAbout)
        }
        GameSettings.goBack = false
    }
}