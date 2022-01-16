package will.shiro.ifly

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import will.shiro.ifly.di.AppModules

class IFlyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(this@IFlyApplication)
            modules(*AppModules.modules())
        }
    }
}