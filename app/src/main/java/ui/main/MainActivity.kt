package ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import es.iessaladillo.pedrojoya.pr05_trivial.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.title_fragment.*
import ui.about.AboutFragment
import ui.game.GameFragment
import ui.reglas.RulesFragment
import ui.title.TitleFragment

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) {
            navigateToInitialDestination()
        }
    }

    // Para poder volver atrás:
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(false)
            title = getString(R.string.app_name)
            navigateToInitialDestination()
        }
        return true
    }

    // Navegaciones:
    private fun navigateToInitialDestination() {
        supportFragmentManager.commit {
            replace(R.id.fcDetail, TitleFragment.newInstance())
        }
    }
}