package `in`.rahul.triviaapp.activity

import `in`.rahul.triviaapp.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Trivia App"

        btn_next.setOnClickListener {
            val stName = et_name.text.trim().toString()
            if (stName == null || stName.equals("") || stName.equals(" ")){
                et_name.error = "Please enter Name"
                et_name.requestFocus()
            } else {
                val stOutName = et_name.text.toString()
//                showMessage(this, "User Name: $stOutName")
                startActivity(Intent(this, SportsActivity::class.java).putExtra("userName",stOutName))
            }
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}
