package `in`.rahul.triviaapp.core.interactors

import `in`.rahul.triviaapp.core.data.TriviaRepository
import `in`.rahul.triviaapp.core.domain.TriviaModel

class SetOpenTriviaData(private val triviaRepository: TriviaRepository) {

    operator fun invoke(triviaData: TriviaModel) = triviaRepository.setOpenTriviaData(triviaData)
}