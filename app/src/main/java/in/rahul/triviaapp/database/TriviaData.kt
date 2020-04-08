package `in`.rahul.triviaapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "triviaData")
class TriviaData(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo val date: String?,
    @ColumnInfo val userName: String?,
    @ColumnInfo val sportsMan: String?,
    @ColumnInfo val flag: String?
) {

}