package `in`.rahul.triviaapp.core.interactors

import `in`.rahul.triviaapp.core.data.*

data class Interactors(val addTriviaData: AddTriviaData, val getOpenTriviaData: GetOpenTriviaData, val getTriviaData: GetTriviaData, val openTriviaDataSource: OpenTriviaDataSource, val setOpenTriviaData: SetOpenTriviaData, val triviaDataSource: TriviaDataSource, val triviaRepository: TriviaRepository)
//Interactors(
//    val addBookmark: AddBookmark,
//    val getBookmarks: GetBookmarks,
//    val deleteBookmark: RemoveBookmark,
//    val addDocument: AddDocument,
//    val getDocuments: GetDocuments,
//    val removeDocument: RemoveDocument,
//    val getOpenDocument: GetOpenDocument,
//    val setOpenDocument: SetOpenDocument
//)