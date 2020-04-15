package `in`.rahul.triviaapp.core.data

class GetOpenTriviaData(private val triviaRepository: TriviaRepository) {

    operator fun invoke() = triviaRepository.getOpenTriviaData()
}