package ui.reglas

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import data.GameSettings
import es.iessaladillo.pedrojoya.pr05_trivial.R

class RulesFragment : Fragment(R.layout.rules_fragment) {
    companion object {
        fun newInstance() = RulesFragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
        setupAppBar()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.emptybar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHasOptionsMenu(false)
            title = getString(R.string.title_mnuRules)
        }
        GameSettings.goBack = false
    }
}
