package `in`.rahul.triviaapp.activity

import `in`.rahul.triviaapp.R
import `in`.rahul.triviaapp.adapter.GameAdapter
import `in`.rahul.triviaapp.framework.database.TriviaDatabase
import `in`.rahul.triviaapp.core.domain.TriviaModel
import `in`.rahul.triviaapp.framework.RoomDbTriviaDataSource
import `in`.rahul.triviaapp.framework.TriviaViewModelFactory
import `in`.rahul.triviaapp.presentation.GameDelegate
import `in`.rahul.triviaapp.presentation.GameViewModel
import `in`.rahul.triviaapp.utils.CommonUtils.showMessage
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_summary.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SummaryActivity : AppCompatActivity() {

    private lateinit var viewModel:GameViewModel
    lateinit var gameDelegate: GameDelegate

   lateinit var database: TriviaDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        database = TriviaDatabase.getInstance(this)!!



//         val adapter = DocumentsAdapter(glide = Glide.with(this)) {
//        mainActivityDelegate.openDocument(it)
//    }
//    documentsRecyclerView.adapter = adapter
//
//    viewModel = ViewModelProviders.of(this, MajesticViewModelFactory)
//        .get(LibraryViewModel::class.java)
//    viewModel.documents.observe(this, Observer { adapter.update(it) })
//    viewModel.loadDocuments()

//        val adapter = GameAdapter()
        /* {
                viewModel.getTriviaData()
        }*/
//        adapter.setGameList()


        viewModel = ViewModelProviders.of(this, TriviaViewModelFactory).get(GameViewModel::class.java)
//        viewModel.triviaList.observe(this, Observer { adapter.update(it) })


        recycle_view.visibility = View.GONE
        cl_summary.visibility = View.VISIBLE
        val stUserName = intent.getStringExtra("userName")
        val stSportsMan = intent.getStringExtra("sportsMan")
        val stFlag = intent.getStringExtra("flag")

        tv_hello.text = "Hello $stUserName, "
        tv_ans_cricketer.text = "Answer : $stSportsMan"
        tv_ans_flag.text = "Answer : $stFlag"

        btn_finish.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        btn_history.setOnClickListener {
           val data = viewModel.getTriviaData()
            fetchDataFmDatabase()
        }
    }

    private fun fetchDataFmDatabase() {
        GlobalScope.launch(Dispatchers.IO) {
            val triviaDataList = database.triviaDao().getAllData()
            val datalist = RoomDbTriviaDataSource(this@SummaryActivity).readAllData()
            val triviaModelList = mutableListOf<TriviaModel>()

            if (triviaDataList == null || triviaDataList.size == 0){
                showMessage(this@SummaryActivity, "No Database Found")
            } else {
                for (i in triviaDataList.indices){
                    triviaModelList.add(
                        TriviaModel(
                            triviaDataList[i].id,
                            triviaDataList[i].date,
                            triviaDataList[i].userName,
                            triviaDataList[i].sportsMan,
                            triviaDataList[i].flag
                        )
                    )
                }

                runOnUiThread {
                    cl_summary.visibility = View.GONE
                    recycle_view.layoutManager = LinearLayoutManager(this@SummaryActivity, LinearLayoutManager.VERTICAL, false)
//                    recycle_view.adapter = GameAdapter(this@SummaryActivity, triviaModelList)
                    recycle_view.adapter = GameAdapter(datalist)
                        recycle_view.visibility = View.VISIBLE
                }
            }
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
            ab.title = "Game Summary"
        }
        ab?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}
