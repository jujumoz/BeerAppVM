package sierra.com.app.injection.module

import android.content.Context
import dagger.Module
import dagger.Provides
import sierra.com.app.MVVMApplication
import javax.inject.Singleton

@Module
class AppModule() {
    @Provides
    @Singleton
    fun provideApplication(app: MVVMApplication): Context = app
}