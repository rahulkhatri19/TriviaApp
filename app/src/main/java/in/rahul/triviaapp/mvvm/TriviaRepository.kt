package `in`.rahul.triviaapp.mvvm

import `in`.rahul.triviaapp.core.domain.TriviaModel
import androidx.lifecycle.LiveData

interface TriviaRepository {

    fun insert(triviaModel: TriviaModel)

    fun getAllTriviaData(): LiveData<List<TriviaModel>>
}