package sierra.com.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.Scheduler
import sierra.com.domain.usecase.GetBeersUseCase
import sierra.com.presentation.di.naming.SchedulersNaming
import sierra.com.presentation.main.BeerListViewModelImpl
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val getBeersUseCase: GetBeersUseCase,
    @SchedulersNaming.UI
    private val uiScheduler: Scheduler,
    @SchedulersNaming.IO
    private val ioScheduler: Scheduler
) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(BeerListViewModelImpl::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                return BeerListViewModelImpl(
                    getBeersUseCase,
                    uiScheduler,
                    ioScheduler
                ) as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}