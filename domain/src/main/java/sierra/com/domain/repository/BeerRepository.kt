package sierra.com.domain.repository

import io.reactivex.Single
import sierra.com.domain.model.Beer

interface BeerRepository {
    fun getAll(): Single<List<Beer>>
}