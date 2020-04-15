package `in`.rahul.triviaapp.core.data

import `in`.rahul.triviaapp.core.domain.TriviaModel

interface TriviaDataSource {

    suspend fun addTriviaData(triviaData: TriviaModel)

    suspend fun readAllData(): List<TriviaModel>
}