package za.ac.iie.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import za.ac.iie.weatherapp.R.id.buttonDetails

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val editTextMonday: EditText = findViewById(R.id.editTextMonday)
        val editTextTuesday: EditText = findViewById(R.id.editTextTuesday)
        val editTextWednesday: EditText = findViewById(R.id.editTextWednesday)
        val editTextThursday: EditText = findViewById(R.id.editTextThursday)
        val editTextFriday: EditText = findViewById(R.id.editTextFriday)

        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonExit2: Button = findViewById(R.id.buttonExit2)
        val buttonDetails: Button = findViewById(buttonDetails)
        val textViewAverage: TextView = findViewById(R.id.textViewAverage)

        buttonCalculate.setOnClickListener {
            val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
            val inputs = arrayOf(
                editTextMonday.text.toString(),
                editTextTuesday.text.toString(),
                editTextWednesday.text.toString(),
                editTextThursday.text.toString(),
                editTextFriday.text.toString()
            )

            val numbers = Array(days.size) { 0 }
            for (i in inputs.indices) {
                numbers[i] = inputs[i].toIntOrNull() ?: 0
            }

            var sum = 0
            for (number in numbers) {
                sum += number
            }
            val average = sum / numbers.size.toDouble()

            textViewAverage.text = "Average: $average"
        }

        buttonExit2.setOnClickListener {
            finish()
        }

        buttonDetails.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("Monday", editTextMonday.text.toString())
            intent.putExtra("Tuesday", editTextTuesday.text.toString())
            intent.putExtra("Wednesday", editTextWednesday.text.toString())
            intent.putExtra("Thursday", editTextThursday.text.toString())
            intent.putExtra("Friday", editTextFriday.text.toString())
            startActivity(intent)
        }
    }
}
