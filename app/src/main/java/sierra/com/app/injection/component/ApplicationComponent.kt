package sierra.com.app.injection.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import sierra.com.app.MVVMApplication
import sierra.com.app.injection.module.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        MapperModule::class,
        AndroidInjectionModule::class,
        SchedulersModule::class,
        ActivityModule::class,
        RoomModule::class]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: MVVMApplication)
}
