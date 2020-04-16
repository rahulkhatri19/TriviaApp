package `in`.rahul.triviaapp.core.interactors

import `in`.rahul.triviaapp.core.data.TriviaRepository

class GetTriviaData(private val triviaRepository: TriviaRepository) {

    suspend operator fun invoke() = triviaRepository.getTriviaData()
}