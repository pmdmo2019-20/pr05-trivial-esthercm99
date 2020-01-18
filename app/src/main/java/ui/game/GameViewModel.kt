package ui.game

import android.app.Application
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModel
import data.GameSettings
import data.LocalRepository
import data.entity.Answer
import data.entity.Question
import es.iessaladillo.pedrojoya.pr05_trivial.R
import ui.game_over.GameOverFragment
import ui.game_won.GameWonFragment
import ui.title.TitleFragment

class GameViewModel(private val fragment: GameFragment) : ViewModel() {

    var actualRound: Int = 1
    var numQuestion: Int = GameSettings.numQuestions

    private val questions: List<Question> = LocalRepository.queryAllQuestion()
    var actualQuestion: Question? = questions[0]
    private var actualQuestionCorrectAnswer: Answer?= null

    fun nextQuestion(answer: String) {
        checkCorrectAnswer(answer)
        if (GameSettings.isWinner && (GameSettings.actualQuestion != GameSettings.numQuestions)) {
            GameSettings.actualQuestion = GameSettings.actualQuestion++
            actualRound = GameSettings.actualQuestion
            selectQuestion()
        } else if (!GameSettings.isWinner) {
            goToLoseFragment()
        } else {
            goToWinFragment()
        }
    }

    private fun selectQuestion() {
    }

    private fun checkCorrectAnswer(answer: String) {
        GameSettings.isWinner = answer.equals(actualQuestionCorrectAnswer?.answer)
    }

    private fun goToWinFragment() {
        fragment.requireActivity().supportFragmentManager.commit {
            replace(R.id.fcDetail, GameWonFragment.newInstance())
        }
    }

    private fun goToLoseFragment() {
        fragment.requireActivity().supportFragmentManager.commit {
            replace(R.id.fcDetail, GameOverFragment.newInstance())
        }
    }


}
