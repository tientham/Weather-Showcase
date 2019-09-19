package com.tientham.weather.di

import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.tientham.weather.BuildConfig
import com.tientham.weather.data.repository.PreferenceRepository
import com.tientham.weather.network.JSON
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
@Module
class NetworkModule {

    companion object {
        private const val HEADER_AUTH = "Authorization"
        private const val HEADER_AUTH_BEARER = "bearer "
    }

    @Provides
    @Singleton
    fun provideJSON() = JSON()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, json: JSON) : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("http://www.google.it")
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonCustomConverterFactory.create(json.gson))
            .build()
    }

    @Provides
    fun provideHttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
    }

    @Provides
    @Singleton
    fun provideHttpClient(prefs: PreferenceRepository, builder: OkHttpClient.Builder, json: JSON) : OkHttpClient {
        return builder
            .addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                            .addHeader(HEADER_AUTH, HEADER_AUTH_BEARER + prefs.getToken())
                            .build()
                    chain.proceed(newRequest)
                }
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .build()
    }

    /**
     * This wrapper is to take care of this case:
     * when the deserialization fails due to JsonParseException and the
     * expected type is String, then just return the body string.
     */
    @Suppress("UNCHECKED_CAST")
    internal class GsonResponseBodyConverterToString<T>(private val gson: Gson, private val type: Type) :
        Converter<ResponseBody, T> {

        @Throws(IOException::class)
        override fun convert(value: ResponseBody): T? {
            val returned = value.string()
            return try {
                gson.fromJson(returned, type)
            } catch (e: JsonParseException) {
                returned as T
            }

        }
    }

    internal class GsonCustomConverterFactory private constructor(private val gson: Gson) : Converter.Factory() {

        private val gsonConverterFactory: GsonConverterFactory = GsonConverterFactory.create(gson)

        override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>, retrofit: Retrofit): Converter<ResponseBody, *>? {
            return if (type == String::class.java)
                GsonResponseBodyConverterToString<String>(gson, type)
            else
                gsonConverterFactory.responseBodyConverter(type!!, annotations, retrofit)
        }

        override fun requestBodyConverter(type: Type?, parameterAnnotations: Array<Annotation>, methodAnnotations: Array<Annotation>, retrofit: Retrofit): Converter<*, RequestBody>? {
            return gsonConverterFactory.requestBodyConverter(type!!, parameterAnnotations, methodAnnotations, retrofit)
        }

        companion object {

            fun create(gson: Gson): GsonCustomConverterFactory {
                return GsonCustomConverterFactory(gson)
            }
        }
    }
}