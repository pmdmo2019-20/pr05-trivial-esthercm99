package ui.title

import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

import es.iessaladillo.pedrojoya.pr05_trivial.R

import ui.about.AboutFragment
import ui.game.GameFragment
import ui.reglas.RulesFragment

import android.view.*
import kotlinx.android.synthetic.main.title_fragment.*


class TitleFragment : Fragment(R.layout.title_fragment) {

    companion object {
        fun newInstance() = TitleFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupAppBar()
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAppBar()
        btnPlay.setOnClickListener { play() }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_activity, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btnAbout -> showAbout()
            R.id.btnRules -> showRules()
            //R.id.btnSettings -> viewModel.settings()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun showAbout() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fcDetail, AboutFragment.newInstance())
                .addToBackStack(null)
        }
    }
    private fun showRules() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fcDetail, RulesFragment.newInstance())
            addToBackStack(null)
        }
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(false)
            setHasOptionsMenu(true)
            title = getString(R.string.app_name)
        }
    }

    private fun play() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fcDetail, GameFragment.newInstance())
            addToBackStack(null)
        }
    }

}
