package `in`.rahul.triviaapp.framework

import `in`.rahul.triviaapp.core.data.TriviaDataSource
import `in`.rahul.triviaapp.core.domain.TriviaModel
import `in`.rahul.triviaapp.database.TriviaData
import `in`.rahul.triviaapp.database.TriviaDatabase
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

//class RoomBookmarkDataSource(context: Context) : BookmarkDataSource {
//
//  // 1
//  private val bookmarkDao = MajesticReaderDatabase.getInstance(context).bookmarkDao()
//
//  // 2
//  override suspend fun add(document: Document, bookmark: Bookmark) =
//    bookmarkDao.addBookmark(BookmarkEntity(
//      documentUri = document.url,
//      page = bookmark.page
//    ))
//
//  override suspend fun read(document: Document): List<Bookmark> = bookmarkDao
//      .getBookmarks(document.url).map { Bookmark(it.id, it.page) }
//
//  override suspend fun remove(document: Document, bookmark: Bookmark) =
//    bookmarkDao.removeBookmark(
//        BookmarkEntity(id = bookmark.id, documentUri = document.url, page = bookmark.page)
//    )
//}