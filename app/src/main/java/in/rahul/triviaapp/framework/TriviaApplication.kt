package `in`.rahul.triviaapp.framework

import `in`.rahul.triviaapp.core.interactors.AddTriviaData
import `in`.rahul.triviaapp.core.data.TriviaRepository
import `in`.rahul.triviaapp.core.interactors.GetOpenTriviaData
import `in`.rahul.triviaapp.core.interactors.GetTriviaData
import `in`.rahul.triviaapp.core.interactors.SetOpenTriviaData
import `in`.rahul.triviaapp.framework.Interactors
import `in`.rahul.triviaapp.framework.InMemoryOpenTriviaDataSource
import `in`.rahul.triviaapp.framework.RoomDbTriviaDataSource
import `in`.rahul.triviaapp.framework.TriviaViewModelFactory
import android.app.Application

class TriviaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val triviaRepository =
            TriviaRepository(RoomDbTriviaDataSource(this), InMemoryOpenTriviaDataSource())

        TriviaViewModelFactory.inject(
            this,
            Interactors(
                AddTriviaData(triviaRepository),
                GetOpenTriviaData(triviaRepository),
                GetTriviaData(triviaRepository),
                SetOpenTriviaData(triviaRepository)
            )
        )

    }
}