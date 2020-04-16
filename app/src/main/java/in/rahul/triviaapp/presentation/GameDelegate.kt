package `in`.rahul.triviaapp.presentation

import `in`.rahul.triviaapp.core.domain.TriviaModel

interface GameDelegate {
   fun openData(triviaModel: TriviaModel)
}