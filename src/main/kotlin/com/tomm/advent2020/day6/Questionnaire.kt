package com.tomm.advent2020.day6

import com.tomm.advent2020.InputParser

typealias AnswerSet = Set<Char>

data class Questionnaire(
    val answers: List<AnswerSet>
)

class QuestionnaireParser : InputParser<List<Questionnaire>> {

    override fun parse(input: Sequence<String>): List<Questionnaire> {
        val questionnaires = mutableListOf<Questionnaire>()
        val answerList = mutableListOf<AnswerSet>()
        input.forEach { line ->
            if (line.isBlank()) {
                questionnaires += Questionnaire(answerList.toList())
                answerList.clear()
                return@forEach
            }
            answerList += line.toSet()
        }
        if (answerList.isNotEmpty()) {
            questionnaires += Questionnaire(answerList.toList())
            answerList.clear()
        }
        return questionnaires
    }
}
