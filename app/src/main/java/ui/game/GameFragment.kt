package ui.game


import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels

import es.iessaladillo.pedrojoya.pr05_trivial.R
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment(R.layout.fragment_game) {

    companion object {
        fun newInstance() = GameFragment()
    }

    private val viewModel: GameViewModel by viewModels() {
        GameViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_activity, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAppBar()
        setupViews()
        submit()
    }

    private fun submit() {
        btnSubmit.setOnClickListener {
            when {
                ans1.isChecked -> viewModel.nextQuestion(ans1.text.toString())
                ans2.isChecked -> viewModel.nextQuestion(ans2.text.toString())
                ans3.isChecked -> viewModel.nextQuestion(ans3.text.toString())
                ans4.isChecked -> viewModel.nextQuestion(ans4.text.toString())
            }
        }
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHasOptionsMenu(false)
            title = String.format(getString(R.string.game_question_title), viewModel.actualRound, viewModel.numQuestion)
        }
    }
    private fun setupViews() {
        question.text = viewModel.actualQuestion?.question
        ans1.text = viewModel.actualQuestion?.answer1?.answer
        ans2.text = viewModel.actualQuestion?.answer2?.answer
        ans3.text = viewModel.actualQuestion?.answer3?.answer
        ans4.text = viewModel.actualQuestion?.answer4?.answer
    }
}
