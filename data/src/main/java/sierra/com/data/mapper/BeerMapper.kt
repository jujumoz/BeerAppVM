package sierra.com.data.mapper

import sierra.com.data.model.BeerDB
import sierra.com.domain.mapper.Mapper
import sierra.com.domain.model.Beer
import sierra.com.domain.model.BoilVolume
import sierra.com.domain.model.Volume
import javax.inject.Inject

class BeerMapper @Inject constructor(
    private val volumeMapper: Mapper<BeerDB, Volume?>,
    private val boilVolumeMapper: Mapper<BeerDB, BoilVolume?>
) : Mapper<Beer, BeerDB> {

    override fun map(value: Beer): BeerDB {
        return BeerDB(
            value.abv,
            value.attenuation_level,
            value.boil_volume?.unit,
            value.boil_volume?.value,
            value.brewers_tips,
            value.contributed_by,
            value.description,
            value.ebc,
            value.first_brewed,
            value.ibu,
            value.id,
            value.image_url,
            value.name,
            value.ph,
            value.srm,
            value.tagline,
            value.target_fg,
            value.target_og,
            value.volume?.unit,
            value.volume?.value
        )
    }

    override fun reverse(value: BeerDB): Beer {
        return Beer(
            value.abv,
            value.attenuation_level,
            boilVolumeMapper.map(value),
            value.brewers_tips,
            value.contributed_by,
            value.description,
            value.ebc,
            value.first_brewed,
            null,
            value.ibu,
            value.id,
            value.image_url,
            null,
            null,
            value.name,
            value.ph,
            value.srm,
            value.tagLine,
            value.target_fg,
            value.target_og,
            volumeMapper.map(value)
        )
    }
}