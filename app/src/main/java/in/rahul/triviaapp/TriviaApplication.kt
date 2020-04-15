package `in`.rahul.triviaapp

import `in`.rahul.triviaapp.core.data.TriviaRepository
import `in`.rahul.triviaapp.framework.InMemoryOpenTriviaDataSource
import `in`.rahul.triviaapp.framework.RoomDbTriviaDataSource
import android.app.Application

class TriviaApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        val triviaRepository = TriviaRepository(RoomDbTriviaDataSource(this), InMemoryOpenTriviaDataSource())


    }
}

//override fun onCreate() {
//  super.onCreate()
//
//  val bookmarkRepository = BookmarkRepository(RoomBookmarkDataSource(this))
//  val documentRepository = DocumentRepository(
//      RoomDocumentDataSource(this),
//      InMemoryOpenDocumentDataSource()
//  )
//
//  MajesticViewModelFactory.inject(
//      this,
//      Interactors(
//          AddBookmark(bookmarkRepository),
//          GetBookmarks(bookmarkRepository),
//          RemoveBookmark(bookmarkRepository),
//          AddDocument(documentRepository),
//          GetDocuments(documentRepository),
//          RemoveDocument(documentRepository),
//          GetOpenDocument(documentRepository),
//          SetOpenDocument(documentRepository)
//      )
//  )
//}