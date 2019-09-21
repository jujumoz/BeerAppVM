package sierra.com.app.injection.module

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import sierra.com.presentation.di.naming.SchedulersNaming

@Module
class SchedulersModule {

    @Provides
    @SchedulersNaming.UI
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @SchedulersNaming.IO
    fun backgroundScheduler(): Scheduler = Schedulers.io()
}