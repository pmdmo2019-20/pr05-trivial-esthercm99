package ui.game_over

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

import es.iessaladillo.pedrojoya.pr05_trivial.R
import kotlinx.android.synthetic.main.game_over_fragment.*
import ui.game.GameFragment

class GameOverFragment : Fragment(R.layout.game_over_fragment) {

    companion object {
        fun newInstance() = GameOverFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAppBar()
        btnTry.setOnClickListener { tryAgain() }
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHasOptionsMenu(false)
            title = getString(R.string.game_over_title)
        }
    }
    private fun tryAgain() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fcDetail, GameFragment.newInstance())
            addToBackStack(null)
        }
    }

}
