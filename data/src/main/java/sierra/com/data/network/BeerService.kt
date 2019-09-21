package sierra.com.data.network

import io.reactivex.Single
import retrofit2.http.GET
import sierra.com.domain.model.Beer

interface BeerService {

    @GET("/v2/beers")
    fun getAll(): Single<List<Beer>>
}