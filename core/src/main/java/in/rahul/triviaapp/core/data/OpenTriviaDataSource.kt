package `in`.rahul.triviaapp.core.data

import `in`.rahul.triviaapp.core.domain.TriviaModel

interface OpenTriviaDataSource {

    fun setOpenTriviaData(triviaData: TriviaModel)

    fun getOpenTriviaData(): TriviaModel
}