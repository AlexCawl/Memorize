package org.alexcawl.memorize.network

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.DefaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import kotlinx.serialization.json.Json
import org.alexcawl.memorize.network.datasource.INewsArticleDataSource
import org.alexcawl.memorize.network.datasource.NewsArticleDataSource
import javax.inject.Singleton

@Module
interface NetworkModule {
    companion object {
        @Provides
        @NetworkQualifier
        fun provideTimeout(): Int = 60_000

        @Provides
        @Singleton
        fun provideKtorClient(@NetworkQualifier timeout: Int): HttpClient = HttpClient(Android) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })

                engine {
                    connectTimeout = timeout
                    socketTimeout = timeout
                }
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.v("Logger Ktor =>", message)
                    }

                }
                level = LogLevel.ALL
            }

            install(ResponseObserver) {
                onResponse { response ->
                    Log.d("HTTP status:", "${response.status.value}")
                }
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }

    @Binds
    @Singleton
    fun bindNewsArticleDatasource(source: NewsArticleDataSource): INewsArticleDataSource
}