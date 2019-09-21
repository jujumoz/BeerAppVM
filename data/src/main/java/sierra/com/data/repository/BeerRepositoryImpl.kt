package sierra.com.data.repository

import io.reactivex.Single
import sierra.com.data.db.dao.BeerDao
import sierra.com.data.model.BeerDB
import sierra.com.data.network.BeerService
import sierra.com.domain.mapper.Mapper
import sierra.com.domain.model.Beer
import sierra.com.domain.repository.BeerRepository
import javax.inject.Inject

class BeerRepositoryImpl @Inject constructor(
    private val dao: BeerDao,
    private val beerMapper: Mapper<Beer, BeerDB>,
    private val beerService: BeerService
) : BeerRepository {

    override fun getAll(): Single<List<Beer>> {
        return Single.fromCallable { dao.all }
            .flatMap {
                if (it.isEmpty()) {
                    getFromNetwork()
                } else {
                    Single.just(beerMapper.reverse(it))
                }
            }
    }

    private fun getFromNetwork(): Single<List<Beer>> {
        return beerService.getAll()
            .flatMap { list ->
                dao.insertAll(*beerMapper.map(list).toTypedArray())
                Single.just(list)
            }
    }
}