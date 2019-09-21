package sierra.com.app.injection.module.activity

import android.app.Activity
import dagger.Binds
import dagger.Module
import sierra.com.app.injection.module.MapperModule
import sierra.com.app.injection.module.NetworkModule
import sierra.com.app.injection.module.RepositoryModule
import sierra.com.presentation.main.MainActivity

@Module(includes = [NetworkModule::class, MapperModule::class, RepositoryModule::class])
abstract class MainModule {

    @Binds
    abstract fun provideMainActivity(fragment: MainActivity): Activity

//    @Binds
//    abstract fun provideViewModelFactory(impl: ViewModelFactory): ViewModelFactory
}