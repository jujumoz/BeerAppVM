package sierra.com.app.injection.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import sierra.com.data.repository.BeerRepositoryImpl
import sierra.com.domain.repository.BeerRepository

@Module
object RepositoryModule {

    @Provides
    @Reusable
    @JvmStatic
    fun provideBeerRepository(impl: BeerRepositoryImpl): BeerRepository = impl
}