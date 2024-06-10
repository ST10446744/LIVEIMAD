package za.ac.iie.weatherapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val textViewDetails: TextView = findViewById(R.id.textViewDetails)
        val buttonBack: Button = findViewById(R.id.buttonBack)

        val monday = intent.getStringExtra("Monday")?.toIntOrNull() ?: 0
        val tuesday = intent.getStringExtra("Tuesday")?.toIntOrNull() ?: 0
        val wednesday = intent.getStringExtra("Wednesday")?.toIntOrNull() ?: 0
        val thursday = intent.getStringExtra("Thursday")?.toIntOrNull() ?: 0
        val friday = intent.getStringExtra("Friday")?.toIntOrNull() ?: 0

        val details = """
            Monday:
            High: 30°C, Low: 12°C
            User input: $monday°C
            
            Tuesday:
            High: 31°C, Low: 6°C
            User input: $tuesday°C
            
            Wednesday:
            High: 26°C, Low: 9°C
            User input: $wednesday°C
            
            Thursday:
            High: 38°C, Low: 15°C
            User input: $thursday°C
            
            Friday:
            High: 29°C, Low: 4°C
            User input: $friday°C
        """.trimIndent()

        textViewDetails.text = details

        buttonBack.setOnClickListener {
            // Navigate back to InputActivity
            finish()
        }
    }
}
