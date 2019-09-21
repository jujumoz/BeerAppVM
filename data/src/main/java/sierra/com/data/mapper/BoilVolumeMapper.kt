package sierra.com.data.mapper

import sierra.com.data.model.BeerDB
import sierra.com.domain.mapper.Mapper
import sierra.com.domain.model.BoilVolume
import javax.inject.Inject

class BoilVolumeMapper @Inject constructor() : Mapper<BeerDB, BoilVolume?> {

    override fun map(value: BeerDB): BoilVolume? {
        return value.boil_volume_unit?.let { boil_volume_unit ->
            value.boil_volume_value?.let { boil_volume_value ->
                BoilVolume(boil_volume_unit, boil_volume_value)
            }
        }
    }
}
