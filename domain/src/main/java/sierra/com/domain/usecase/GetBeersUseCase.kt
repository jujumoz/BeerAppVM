package sierra.com.domain.usecase

import io.reactivex.Single
import sierra.com.domain.model.Beer
import sierra.com.domain.repository.BeerRepository
import javax.inject.Inject

class GetBeersUseCase @Inject constructor(
    private val repo: BeerRepository
) : SingleUseCase<List<Beer>, UseCase.NotUseCaseParams>() {

    override fun build(params: NotUseCaseParams?): Single<List<Beer>> {
        return repo.getAll()
    }
}