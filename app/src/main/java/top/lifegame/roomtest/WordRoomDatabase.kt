package top.lifegame.roomtest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    private class WordDataBaseCallback(private val scope: CoroutineScope) : Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
//                    val wordDao = database.wordDao()
//                    wordDao.deleteAll()
//                    var word = Word("Hello")
//                    wordDao.insert(word)
//                    word = Word("World!")
//                    wordDao.insert(word)
//                    word = Word("MMM")
//                    wordDao.insert(word)
                }
            }
        }
    }

    companion object {
        private var INSTANCE: WordRoomDatabase? = null
        fun getDatabase(context: Context, scope: CoroutineScope): WordRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "room_database"
                )
                    .addCallback(WordDataBaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}