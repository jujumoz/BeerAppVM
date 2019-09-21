package sierra.com.app.injection.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import sierra.com.data.db.AppDatabase
import sierra.com.data.db.dao.BeerDao
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    internal fun providesRoomDatabase(application: Application): AppDatabase {
        //return Room.inMemoryDatabaseBuilder(application, AppDatabase::class.java).build()
        return Room.databaseBuilder(application, AppDatabase::class.java, "MVVM").build()
    }

    @Singleton
    @Provides
    internal fun providesUnitDao(appDatabase: AppDatabase): BeerDao {
        return appDatabase.beerDao()
    }
}