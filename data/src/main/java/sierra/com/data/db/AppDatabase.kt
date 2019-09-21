package sierra.com.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import sierra.com.data.db.dao.BeerDao
import sierra.com.data.model.BeerDB

@Database(
    entities = [
        BeerDB::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun beerDao(): BeerDao
}