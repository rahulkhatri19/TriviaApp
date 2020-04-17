package `in`.rahul.triviaapp.presentation.activity

import `in`.rahul.triviaapp.R
import `in`.rahul.triviaapp.utils.CommonUtils.showMessage
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_sports.*
import kotlinx.android.synthetic.main.activity_sports.btn_next
import kotlinx.android.synthetic.main.activity_sports.toolbar

class SportsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sports)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        btn_next.setOnClickListener {
            var stSportsMan = ""
            val radioGroupId = rg_cricket.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(radioGroupId)
            if (radioGroupId == -1){
                showMessage(this, "Please select any Option")
            } else {
                stSportsMan = radioButton.text.toString()
                val stUserName = intent.extras?.getString("userName")
                val bundle = Bundle()
                bundle.putString("userName", stUserName)
                bundle.putString("sportsMan", stSportsMan)
                startActivity(Intent(this, FlagActivity::class.java).putExtras(bundle))
                finish()
            }
//            logMessage("Sports:", "radio:$radioGroupId, stSp: $stSportsMan")
        }
    }
    override fun onResume() {
        super.onResume()
        val ab = supportActionBar
        if (ab != null) {
            ab.title = "Sports Man"
        }
        ab?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}
