package com.example.wordle



import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wordle.FourLetterWordList.getRandomFourLetterWord
import com.example.wordle.Keyboard.hideKeyboard



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    var inputText = findViewById<EditText>(R.id.textInput)
    var buttonGuess = findViewById<Button>(R.id.guess)
    val wordToGuess = getRandomFourLetterWord()
    val guess1 = findViewById<TextView>(R.id.guess1)
    val guess1check = findViewById<TextView>(R.id.guess1Check)
    val guess2 = findViewById<TextView>(R.id.guess2)
    val guess2check = findViewById<TextView>(R.id.guess2Check)
    val guess3 = findViewById<TextView>(R.id.guess3)
    val guess3check = findViewById<TextView>(R.id.guess3Check)
    val correctWord = findViewById<TextView>(R.id.correctWord)


        inputText = findViewById(R.id.textInput)
        buttonGuess = findViewById(R.id.guess)


        fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                }
                else if (guess[i] in wordToGuess) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        }
        var count = 0

        buttonGuess.setOnClickListener {
            hideKeyboard(this)
            val inputGuess =  inputText.text.toString().uppercase()
            count ++
            if (count == 1){
                val guess = checkGuess(inputGuess)
                guess1.text = inputGuess.lowercase()
                guess1check.text = guess
                guess1.visibility = View.VISIBLE
                guess1check.visibility = View.VISIBLE

            }

            if (count == 2){
                val guess = checkGuess(inputGuess)
                guess2.text = inputGuess.lowercase()
                guess2check.text = guess
                guess2.visibility = View.VISIBLE
                guess2check.visibility = View.VISIBLE

            }
            if (count == 3){
                val guess = checkGuess(inputGuess)
                guess3.text = inputGuess.lowercase()
                guess3check.text = guess
                guess3.visibility = View.VISIBLE
                guess3check.visibility = View.VISIBLE
                correctWord.text = wordToGuess
                correctWord.visibility = View.VISIBLE
            }
            if (count > 3){
                Toast.makeText(this, "Guess limit reached!", Toast.LENGTH_LONG).show()
                buttonGuess.isClickable = false
                buttonGuess.setBackgroundColor(Color.DKGRAY)
            }

    }

}
}