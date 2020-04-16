package `in`.rahul.triviaapp.framework

import `in`.rahul.triviaapp.core.data.*
import `in`.rahul.triviaapp.core.interactors.AddTriviaData
import `in`.rahul.triviaapp.core.interactors.GetOpenTriviaData
import `in`.rahul.triviaapp.core.interactors.GetTriviaData
import `in`.rahul.triviaapp.core.interactors.SetOpenTriviaData

data class Interactors(val addTriviaData: AddTriviaData, val getOpenTriviaData: GetOpenTriviaData, val getTriviaData: GetTriviaData, val setOpenTriviaData: SetOpenTriviaData)
