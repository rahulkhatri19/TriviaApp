package `in`.rahul.triviaapp.core.data

import `in`.rahul.triviaapp.core.domain.TriviaModel

class TriviaRepository(private val dataSource: TriviaDataSource, private val openDataSource: OpenTriviaDataSource) {

    suspend fun addTriviaData(triviaData: TriviaModel) = dataSource.addTriviaData(triviaData)

    suspend fun getTriviaData() = dataSource.readAllData()

    fun setOpenTriviaData(triviaData: TriviaModel) = openDataSource.setOpenTriviaData(triviaData)

    fun getOpenTriviaData() = openDataSource.getOpenTriviaData()

}