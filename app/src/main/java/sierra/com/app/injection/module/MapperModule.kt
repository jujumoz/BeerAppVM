package sierra.com.app.injection.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import sierra.com.data.mapper.BeerMapper
import sierra.com.data.mapper.BoilVolumeMapper
import sierra.com.data.mapper.VolumeMapper
import sierra.com.data.model.BeerDB
import sierra.com.domain.mapper.Mapper
import sierra.com.domain.model.Beer
import sierra.com.domain.model.BoilVolume
import sierra.com.domain.model.Volume

@Module
object MapperModule {

    @Provides
    @Reusable
    @JvmStatic
    fun provideBeerMapper(impl: BeerMapper): Mapper<Beer, BeerDB> = impl

    @Provides
    @Reusable
    @JvmStatic
    fun provideBoilVolumeMapper(impl: BoilVolumeMapper): Mapper<BeerDB, BoilVolume?> = impl

    @Provides
    @Reusable
    @JvmStatic
    fun provideVolumeMapper(impl: VolumeMapper): Mapper<BeerDB, Volume?> = impl
}