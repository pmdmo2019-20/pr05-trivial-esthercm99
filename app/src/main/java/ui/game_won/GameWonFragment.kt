package ui.game_won

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

import es.iessaladillo.pedrojoya.pr05_trivial.R
import kotlinx.android.synthetic.main.game_won_fragment.*
import ui.game.GameFragment

class GameWonFragment : Fragment(R.layout.game_won_fragment) {

    companion object {
        fun newInstance() = GameWonFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAppBar()
        btnWin.setOnClickListener { tryAgain() }
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHasOptionsMenu(false)
            title = getString(R.string.game_win_title)
        }
    }

    private fun tryAgain() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fcDetail, GameFragment.newInstance())
            addToBackStack(null)
        }
    }

}
