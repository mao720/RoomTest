package top.lifegame.roomtest

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope

class WordRepository(context: Context, scope: CoroutineScope) {
    private val wordDao: WordDao by lazy {
        WordRoomDatabase.getDatabase(context, scope).wordDao()
    }
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizeWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}