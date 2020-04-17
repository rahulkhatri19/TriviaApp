package `in`.rahul.triviaapp.presentation

import `in`.rahul.triviaapp.core.domain.TriviaModel
import `in`.rahul.triviaapp.framework.Interactors
import `in`.rahul.triviaapp.framework.TriviaViewModel
import android.app.Application
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class GameViewModel(application: Application, interactor: Interactors) :
    TriviaViewModel(application, interactor) {
    // viewModel Job for canceling coroutines


    /**
     * A [CoroutineScope] keeps track of all coroutines started by this ViewModel.
     */

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    val triviaList: MutableLiveData<List<TriviaModel>> = MutableLiveData()

    fun getTriviaData() {
        uiScope.launch {
            triviaList.postValue(interactors.getTriviaData())
        }
    }

    fun addTriviaData(triviaData: TriviaModel) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                interactors.addTriviaData(triviaData)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
