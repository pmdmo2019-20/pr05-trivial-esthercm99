package data

import data.entity.Answer
import data.entity.Question

object LocalRepository : Repository {

    private val questions = listOf(
        Question("Which language can you program with in android?", Answer("JavaScript", false), Answer("C#", false), Answer("C++", false), Answer("Java", true)),
        Question("Which of this word list have been Android version names?", Answer("Ice Cream", true), Answer("Eclair", false), Answer("Donut", false), Answer("Raspberry", false)),
        Question("What is android?", Answer("Desktop Operating System", false), Answer("Programming Language", false), Answer("Mobile Operating System", true), Answer("Database", false)),
        Question("Which of the following holds Java source code for the application?", Answer("res/", false), Answer("assets/", false), Answer("src/", true), Answer("bin/", false)),
        Question("If you want to increase the whitespace between widgets, you will need to use the _____________ property", Answer("android:padding", true), Answer("android:digits", false), Answer("android:autoText", false), Answer("android:capitalize", false)),
        Question("Which company developed android?", Answer("Apple", false), Answer("Android Inc.", true), Answer("Nokia", false), Answer("Google", false)),
        Question("Web browser available in android is based on", Answer("Chrome", false), Answer("Firefox", false), Answer("Opera", false), Answer("Open source Webkit", true)),
        Question("What is the RecyclerView?", Answer("It's flexible and efficient version of ListView", true), Answer("It is an inflexible and efficient version of ListView", false), Answer("It is an inflexible and inefficient version of ListView", false), Answer("It's flexible and inefficient version of ListView", false)),
        Question("What was the latest version of android in 2018?", Answer("KitKat (4.4)", false), Answer("Nougat (7.0)", false), Answer("Oreo (8.0)", false), Answer("Pie (9.0)", true)),
        Question("When was the first version of android?", Answer("2011", false), Answer("2008", true), Answer("2009", false), Answer("2012", false)),
        Question("What is the Android version names related to?", Answer("Flowers", false), Answer("Sweets", true), Answer("Countries", false), Answer("Movies", false))
    )

    override fun queryAllQuestion(): List<Question> = questions

}

