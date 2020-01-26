package ui.main

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import es.iessaladillo.pedrojoya.pr05_trivial.R
import ui.title.TitleFragment
import android.app.AlertDialog
import data.GameSettings
import ui.game.GameFragment

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
        goBack()
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        goBack()
        return true
    }
    private fun goBack() {
        if (supportFragmentManager.findFragmentById(R.id.fcDetail) is GameFragment && GameSettings.showDialog) {
            AlertDialog.Builder(this).setTitle("Confirmation")
                                            .setMessage("Are you sure you want to quit the game?")
                                            .setCancelable(false)
                                            .setPositiveButton("YES") { _, _ -> navigateToInitialDestination() }
                                            .setNegativeButton("NO"){ _, _ -> }             // No hace nada
                                            .show()
        } else {
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