package data

import data.entity.Question

interface Repository {
    fun queryAllQuestion(): List<Question>
}
