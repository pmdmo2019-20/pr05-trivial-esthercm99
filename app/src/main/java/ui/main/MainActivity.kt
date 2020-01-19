package ui.main

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import es.iessaladillo.pedrojoya.pr05_trivial.R
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
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // if (GameSettings.goBack && GameSettings.showDialog) {} else {}
        goBack()
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        goBack()
        return true
    }
    private fun goBack() {
        onBackPressed()
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(false)
            title = getString(R.string.app_name)
            navigateToInitialDestination()
        }
    }

    // Navegaciones:
    private fun navigateToInitialDestination() {
        supportFragmentManager.commit {
            replace(R.id.fcDetail, TitleFragment.newInstance())
        }
    }
}