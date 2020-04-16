package `in`.rahul.triviaapp.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class TriviaViewModel(application: Application, protected val interactors: Interactors): AndroidViewModel(application) {
    protected val application: TriviaApplication = getApplication()
}

//open class MajesticViewModel(application: Application, protected val interactors: Interactors) :
//    AndroidViewModel(application) {
//
//  protected val application: MajesticReaderApplication = getApplication()
//
//}