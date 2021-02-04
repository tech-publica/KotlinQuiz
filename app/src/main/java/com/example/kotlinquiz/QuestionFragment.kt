package com.example.kotlinquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.navigation.findNavController


class QuestionFragment : Fragment() {

    lateinit var answers: RadioGroup
    lateinit var question: TextView
    lateinit var confirmButton: Button
    var numGuessed = 0
    var numTotal = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_question)
       val view =  inflater.inflate(R.layout.fragment_question, container, false)
        answers = view.findViewById(R.id.answers)
        question = view.findViewById(R.id.question)
        confirmButton = view.findViewById(R.id.confirm)
        var currentIndex = 0
        showNextQuestion(currentIndex)
        confirmButton.setOnClickListener {
           val checkedId = answers.checkedRadioButtonId
           val buttonPressed = answers.findViewById<RadioButton>(checkedId)
           if( answers.indexOfChild(buttonPressed) == Questionnaire.questions[currentIndex].answerPos) {
               numGuessed++
               Toast.makeText(this.context, "You rock! Got another one...", Toast.LENGTH_SHORT).show()
           } else {
               Toast.makeText(this.context, "You suck! Wrong...", Toast.LENGTH_SHORT).show()
           }
           currentIndex++
           if(currentIndex >= Questionnaire.questions.size ) {
               if(numGuessed > 2.0/3.0 * Questionnaire.questions.size) {
                   view.findNavController().navigate(R.id.action_questionFragment_to_success)
               } else {
                   view.findNavController().navigate(R.id.action_questionFragment_to_failure)
               }
           } else {
              showNextQuestion(currentIndex)
           }
       }
        return view
    }

    private fun showNextQuestion(currentIndex: Int) {
        var currentQuestion = Questionnaire.questions[currentIndex]
        question.text = currentQuestion.question
        answers.children.forEachIndexed { index, view ->
            view as RadioButton
            view.text = currentQuestion.options[index]
        }
    }



}