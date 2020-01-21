package ui.game

import androidx.fragment.app.commit
import androidx.lifecycle.ViewModel
import data.GameSettings
import data.LocalRepository
import data.entity.Question
import es.iessaladillo.pedrojoya.pr05_trivial.R
import ui.game_over.GameOverFragment
import ui.game_won.GameWonFragment
import kotlin.random.Random

class GameViewModel(private val fragment: GameFragment) : ViewModel() {

    var actualRound: Int = 1
    var numQuestion: Int = GameSettings.numQuestions

    private val questions: List<Question> = LocalRepository.queryAllQuestion()
    lateinit var actualQuestion: Question
    private var actualQuestionCorrectAnswer: String = ""

    private var questionResolves: MutableList<Int> = mutableListOf()

    fun nextQuestion(answer: String) {
        checkCorrectAnswer(answer)
        if (GameSettings.isWinner && (actualRound < GameSettings.numQuestions)) {
            actualRound++
            GameSettings.actualQuestion = actualRound
            actualRound = GameSettings.actualQuestion
            selectQuestion()
        } else if (!GameSettings.isWinner) {
            goToLoseFragment()
        } else {
            goToWinFragment()
        }
    }

    fun selectQuestion() {
        var rnd : Int
        var rep = false

        rnd = Random.nextInt(10)

        if (questionResolves.isEmpty()) {
            actualQuestion = questions[rnd]
            questionResolves.add(rnd)
        } else {
            while(true) {
                for (i in 0 until questionResolves.size) {
                    if (questionResolves[i] == rnd) {
                        rep = true
                    }
                }

                if (rep) {
                    rnd = Random.nextInt(10)
                    rep = false
                } else {
                    actualQuestion = questions[rnd]
                    questionResolves.add(rnd)
                    return
                }

            }
        }
    }

    private fun checkCorrectAnswer(answer: String) {
        when {
            actualQuestion.answer1.isCorrect -> actualQuestionCorrectAnswer = actualQuestion.answer1.answer
            actualQuestion.answer2.isCorrect -> actualQuestionCorrectAnswer = actualQuestion.answer2.answer
            actualQuestion.answer3.isCorrect -> actualQuestionCorrectAnswer = actualQuestion.answer3.answer
            actualQuestion.answer4.isCorrect -> actualQuestionCorrectAnswer = actualQuestion.answer4.answer
        }
        GameSettings.isWinner = answer.equals(actualQuestionCorrectAnswer)
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
