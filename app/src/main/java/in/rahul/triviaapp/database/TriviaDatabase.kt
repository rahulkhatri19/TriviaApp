package `in`.rahul.triviaapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TriviaData::class], version = 1)
abstract class TriviaDatabase : RoomDatabase() {

    abstract fun triviaDao(): TriviaDao

    companion object {
        private var instance: TriviaDatabase? = null

        fun getInstance(context: Context): TriviaDatabase? {
            if (instance == null) {
                synchronized(TriviaDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TriviaDatabase::class.java,
                        "trivia.db"
                    ).build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }
    }
}