package will.shiro.ifly.utils.scheduler

import org.koin.dsl.module

val schedulerModule = module {

    factory<SchedulerProvider> {
        SchedulerProviderImpl()
    }
}
