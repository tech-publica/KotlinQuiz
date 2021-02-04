package com.example.kotlinquiz

class Questionnaire {
    companion object Data {
        val questions = listOf(
            Question("What is a class?", listOf(
                "something with style",
                "a social group",
                "a blueprint for objects"
            ), 2),
            Question("What is polymorphism?", listOf(
                "a winter festivity",
                "having a base type reference pointing a derived type object",
                "a rare disease"
            ), 1),
            Question("Why do you study Kotlin?", listOf(
                "I wanna create cool android apps",
                "I like how it sounds",
                "They told me to do it!"
            ), 0),
        )
    }
}