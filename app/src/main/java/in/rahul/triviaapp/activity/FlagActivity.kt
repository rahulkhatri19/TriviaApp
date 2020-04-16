package `in`.rahul.triviaapp.activity

import `in`.rahul.triviaapp.R
import `in`.rahul.triviaapp.framework.database.TriviaData
import `in`.rahul.triviaapp.framework.database.TriviaDatabase
import `in`.rahul.triviaapp.utils.CommonUtils.logMessage
import `in`.rahul.triviaapp.utils.CommonUtils.showMessage
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_flag.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FlagActivity : AppCompatActivity() {

    lateinit var database: TriviaDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flag)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        database = TriviaDatabase.getInstance(this)!!
        btn_next.setOnClickListener {

            val cbWhite = cb_white.isChecked
            val cbYellow = cb_yellow.isChecked
            val cbOrange = cb_orange.isChecked
            val cbGreen = cb_green.isChecked
            val flagList:MutableList<String> = mutableListOf()
            if (cbWhite || cbYellow || cbOrange || cbGreen){
                if (cbWhite){
                   flagList.add("White")
                }
                if (cbYellow){
                    flagList.add("Yellow")
                }
                if (cbOrange){
                   flagList.add("Orange")
                }
                if (cbGreen){
                    flagList.add("Green")
                }

                var stFlag = flagList.toString()
                stFlag = stFlag.replace("[","")
                stFlag = stFlag.replace("]","")

                logMessage("Flag","list: $flagList")
                val stUserName = intent.getStringExtra("userName")
                val stSportsMan = intent.getStringExtra("sportsMan")
                val bundle = Bundle()
                bundle.putString("userName", stUserName)
                bundle.putString("sportsMan", stSportsMan)
                bundle.putString("flag", stFlag)

//                15th March 2:00 pm
                val calendar = Calendar.getInstance()
                val simpleDateFormat = SimpleDateFormat("dd MMM hh:mm a", Locale.ENGLISH)
                val stDate = simpleDateFormat.format(calendar.time)
                logMessage("Flag","list: $flagList, date:$stDate")
                val triviaData =
                    TriviaData(
                        null,
                        stDate,
                        stUserName,
                        stSportsMan,
                        stFlag
                    )
                insertIntoDatabase(triviaData)
                startActivity(Intent(this, SummaryActivity::class.java).putExtras(bundle))
                finish()

            } else {
                showMessage(this,"Please Selected Flag Color")
            }
        }
    }

    private fun insertIntoDatabase(triviaData: TriviaData) {
        GlobalScope.launch {
            database.triviaDao().insertTriviaData(triviaData)
        }
    }

    override fun onDestroy() {
        TriviaDatabase.destroyInstance()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        val ab = supportActionBar
        if (ab != null) {
            ab.title = "Flag Color"
        }
        ab?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}
