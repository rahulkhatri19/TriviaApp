package `in`.rahul.triviaapp.core.interactors

import `in`.rahul.triviaapp.core.data.TriviaRepository

class GetOpenTriviaData(private val triviaRepository: TriviaRepository) {

    operator fun invoke() = triviaRepository.getOpenTriviaData()
}