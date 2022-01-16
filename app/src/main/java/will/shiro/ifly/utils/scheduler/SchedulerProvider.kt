package will.shiro.ifly.utils.scheduler

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun io(): Scheduler
    fun computation(): Scheduler
    fun ui(): Scheduler
}
