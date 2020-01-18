package data

import data.entity.Answer
import data.entity.Question

object LocalRepository : Repository {

    private val questions = listOf(
        Question("¿Qué lenguaje de programación se usa por defecto para desarrollar aplicaciones para Android?", Answer("JavaScript", false), Answer("C#", false), Answer("C++", false), Answer("Java", true)),
        Question("¿Cuáles de esta lista de palabras, han sido nombres de versiones de Android?", Answer("Ice Cream", true), Answer("Eclair", false), Answer("Donut", false), Answer("Raspberry", false))/*,
        Question("", Answer(), Answer(), Answer(), Answer()),
        Question("", Answer(), Answer(), Answer(), Answer()),
        Question("", Answer(), Answer(), Answer(), Answer()),
        Question("", Answer(), Answer(), Answer(), Answer()),
        Question("", Answer(), Answer(), Answer(), Answer()),
        Question("", Answer(), Answer(), Answer(), Answer()),
        Question("", Answer(), Answer(), Answer(), Answer()),
        Question("", Answer(), Answer(), Answer(), Answer())*/

    )

    override fun queryAllQuestion(): List<Question> = questions

}

