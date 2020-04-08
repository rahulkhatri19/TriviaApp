package `in`.rahul.triviaapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TriviaDao {
    @Query("Select * from triviaData")
    fun getAllData(): MutableList<TriviaData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTriviaData(triviaData: TriviaData)
}