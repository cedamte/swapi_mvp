package com.aten5.swapi_mvp.model

import com.aten5.swapi_mvp.BuildConfig
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

class RetrofitClient(private val listener: DataSource.Listener) : DataSource {

    private val rxAdapter = RxJava3CallAdapterFactory.create()

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        ).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(rxAdapter)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val service: SWAPIService = retrofit.create(SWAPIService::class.java)


    override fun getCharactersList() {
        service.getCharactersList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ chara ->
                listener.onSuccess(chara)
            }, { error ->
                listener.onFailure(error)
            })
    }

    override fun getCharacterDetail(name: String) {
        service.getCharacterDetail(name = name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ chara ->
                Timber.d("🌟 $chara")
                listener.onSuccess(chara)
            }, { error ->
                Timber.d("🌟 $error")
                listener.onFailure(error)
            })
    }
}