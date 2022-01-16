package will.shiro.ifly.di

import will.shiro.ifly.flight.di.FlightModule
import will.shiro.ifly.utils.network.networkModule
import will.shiro.ifly.utils.scheduler.schedulerModule

object AppModules {
    fun modules() = arrayOf(
        networkModule,
        schedulerModule,
        FlightModule.module()
    )
}