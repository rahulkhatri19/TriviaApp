package `in`.rahul.triviaapp.framework

import `in`.rahul.triviaapp.core.data.TriviaDataSource
import `in`.rahul.triviaapp.core.domain.TriviaModel
import `in`.rahul.triviaapp.framework.database.TriviaData
import `in`.rahul.triviaapp.framework.database.TriviaDatabase
import android.content.Context

class RoomDbTriviaDataSource(context: Context): TriviaDataSource {

    private val triviaDao = TriviaDatabase.getInstance(context)?.triviaDao()

    override suspend fun addTriviaData(triviaData: TriviaModel) {
        triviaDao?.insertTriviaData(TriviaData(null, triviaData.date, triviaData.name, triviaData.cricketer, triviaData.flag))
    }
    override suspend fun readAllData(): List<TriviaModel> = triviaDao?.getAllData()!!.map {
        TriviaModel(it.id, it.date, it.userName, it.sportsMan, it.flag)
    }

}