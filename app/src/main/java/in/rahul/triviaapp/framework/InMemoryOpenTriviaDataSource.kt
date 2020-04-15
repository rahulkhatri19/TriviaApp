package `in`.rahul.triviaapp.framework

import `in`.rahul.triviaapp.core.data.OpenTriviaDataSource
import `in`.rahul.triviaapp.core.domain.TriviaModel

class InMemoryOpenTriviaDataSource: OpenTriviaDataSource {

    private var openTrivia: TriviaModel? = null
    override fun setOpenTriviaData(triviaData: TriviaModel) {
   openTrivia = triviaData
    }

    override fun getOpenTriviaData(): TriviaModel = openTrivia!!
}

//class InMemoryOpenDocumentDataSource : OpenDocumentDataSource {
//
//  private var openDocument: Document = Document.EMPTY
//
//  override fun setOpenDocument(document: Document) {
//    openDocument = document
//  }
//
//  override fun getOpenDocument() = openDocument
//}