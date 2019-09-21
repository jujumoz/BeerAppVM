package sierra.com.app.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import sierra.com.app.injection.module.activity.MainModule
import sierra.com.app.injection.naming.ActivityScope
import sierra.com.presentation.main.MainActivity

@Module
abstract class ActivityModule {

    /**
     * Activity
     */

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun mainActivity(): MainActivity

}