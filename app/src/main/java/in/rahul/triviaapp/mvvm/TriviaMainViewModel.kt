package `in`.rahul.triviaapp.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TriviaMainViewModel(private val repository: TriviaRepository): ViewModel() {

//    val uiModel: MutableLiveData<UiModel> by lazy {
//        MutableLiveData<UiModel>()
//    }
}

//class BasicMainViewModel(private val repository: Repository) : ViewModel() {
//  val uiModel: MutableLiveData<UiModel> by lazy {
//    MutableLiveData< UiModel >()
//  }
//
//  fun generateReport (){
//    // TODO Add complicated report computation
//  }
//
//  fun deleteUser(user: User?) {
//    deleteUserFromRepository(user)
//    uiModel.value?.userList?.remove(user)
//  }
//
//  fun deleteUserFromRepository(user: User?) {
//    if(user != null) { repository.delete(user) }
//  }
//}