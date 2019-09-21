package sierra.com.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sierra.com.data.model.BeerDB

@Dao
interface BeerDao {
    @get:Query("SELECT * FROM beer")
    val all: List<BeerDB>

    @Insert
    fun insertAll(vararg beer: BeerDB)
}