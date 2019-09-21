package sierra.com.presentation.main

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import sierra.com.domain.model.Beer
import sierra.com.domain.usecase.GetBeersUseCase
import sierra.com.presentation.R
import javax.inject.Inject

class BeerListViewModelImpl @Inject constructor(
    private val useCase: GetBeersUseCase,
    private val uiScheduler: Scheduler,
    private val ioScheduler: Scheduler
) : ViewModel() {

    val adapter: BeerListAdapter =
        BeerListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadBeers() }

    private lateinit var subscription: Disposable

    init {
        loadBeers()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadBeers() {
        subscription = useCase.build()
            .subscribeOn(ioScheduler)
            .observeOn(uiScheduler)
            .doOnSubscribe { doOnSubscribe() }
            .doFinally { doFinally() }
            .subscribe(
                { result -> onSuccess(result) },
                { onError() }
            )
    }

    private fun doOnSubscribe() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun doFinally() {
        loadingVisibility.value = View.GONE
    }

    private fun onSuccess(beerList: List<Beer>) {
        adapter.updateList(beerList)
    }

    private fun onError() {
        errorMessage.value = R.string.error_default
    }
}