package `in`.rahul.triviaapp.core.data

class GetTriviaData(private val triviaRepository: TriviaRepository) {

    suspend operator fun invoke() = triviaRepository.getTriviaData()
}