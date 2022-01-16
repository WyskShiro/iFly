package will.shiro.ifly.utils.network

import org.koin.dsl.module
import will.shiro.ifly.utils.network.NetworkService.providesHttpLoggingInterceptor
import will.shiro.ifly.utils.network.NetworkService.providesOkHttpClient

val networkModule = module {

    factory {
        providesOkHttpClient(
            httpLoggingInterceptor = get()
        )
    }

    factory { providesHttpLoggingInterceptor() }
}
