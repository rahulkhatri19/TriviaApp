package `in`.rahul.triviaapp.core.data

import `in`.rahul.triviaapp.core.domain.TriviaModel

class AddTriviaData(private val triviaRepository: TriviaRepository) {

    suspend operator fun invoke(triviaData: TriviaModel) = triviaRepository.addTriviaData(triviaData)
}