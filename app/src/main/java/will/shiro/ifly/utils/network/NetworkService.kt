package will.shiro.ifly.utils.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import will.shiro.ifly.BuildConfig
import java.util.concurrent.TimeUnit

object NetworkService {

    private const val DEFAULT_TIMEOUT = 10L

    inline fun <reified T> providesRetrofit(
        baseUrl: String,
        okHttpClient: OkHttpClient
    ): T {
        val client = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        return client.build().create(T::class.java)
    }

    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addNetworkInterceptor(httpLoggingInterceptor)
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)

        return builder.build()
    }

    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        } else {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}
