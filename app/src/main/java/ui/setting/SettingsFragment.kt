package ui.setting

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import android.widget.CompoundButton
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import data.GameSettings

import es.iessaladillo.pedrojoya.pr05_trivial.R
import kotlinx.android.synthetic.main.settings_fragment.*

class SettingsFragment : Fragment(R.layout.settings_fragment) {

    companion object {
        fun newInstance() = SettingsFragment()
    }

    private lateinit var viewModel: SettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
        setupAppBar()
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        changeSeekBar()
        changeSwitch()
        GameSettings.goBack = false
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.emptybar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHasOptionsMenu(false)
            title = getString(R.string.title_mnuSettings)
        }
    }
    private fun changeSwitch() {
        switchDialog.setOnCheckedChangeListener { _, _ ->
            GameSettings.showDialog = switchDialog.splitTrack
        }
    }
    private fun changeSeekBar() {
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // var value = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax()
                numQuestion.text = progress.toString()
                GameSettings.numQuestions = progress
            }
        })
    }
}
