package sierra.com.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beer")
data class BeerDB(
    val abv: Double,
    val attenuation_level: Double,
    val boil_volume_unit: String?,
    val boil_volume_value: Int?,
    var brewers_tips: String,
    val contributed_by: String,
    val description: String,
    val ebc: Double?,
    val first_brewed: String,
    val ibu: Double?,
    @field:PrimaryKey
    val id: Int,
    val image_url: String,
    val name: String,
    val ph: Double?,
    val srm: Double?,
    val tagLine: String,
    val target_fg: Double,
    val target_og: Double,
    val volume_unit: String?,
    val volume_value: Int?
)