package sierra.com.data.mapper

import sierra.com.data.model.BeerDB

import sierra.com.domain.mapper.Mapper
import sierra.com.domain.model.Volume
import javax.inject.Inject

class VolumeMapper @Inject constructor() : Mapper<BeerDB, Volume?> {

    override fun map(value: BeerDB): Volume? {
        return value.volume_unit?.let { boil_volume_unit ->
            value.volume_value?.let { boil_volume_value ->
                Volume(boil_volume_unit, boil_volume_value)
            }
        }
    }
}
