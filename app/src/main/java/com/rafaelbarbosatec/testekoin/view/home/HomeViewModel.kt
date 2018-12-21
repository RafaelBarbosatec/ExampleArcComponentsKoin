package com.rafaelbarbosatec.testekoin.view.home


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.rafaelbarbosatec.testekoin.domain.coinDomain.model.Coin
import com.rafaelbarbosatec.testekoin.view.home.dataProvider.HomeDataProviderContract


/**
 * Created by rafael on 22/10/18.
 */
class HomeViewModel(val homeDataProvider: HomeDataProviderContract) : ViewModel() {

    private val coins: MutableLiveData<ArrayList<Coin>> by lazy {
        MutableLiveData<ArrayList<Coin>>()
    }

    private val loading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    private var page = 0
    private val limit = 20

    init {
        loadCoins()
    }

    fun loadCoins() {

        page = 0
        loading.postValue(true)
        homeDataProvider.loadCoins(
                page,
                limit.toString(),
                {
                    loading.postValue(false)
                    coins.postValue(it)
                },
                {
                    loading.postValue(false)
                    Log.i("LOG","resp: ERROR: ${it.message}")
                }
        )

    }

    fun nextPage(){

        if (loading.value == false){

            loading.postValue(true)

            page ++

            homeDataProvider.loadCoins(
                    (page*limit),
                    limit.toString(),
                    {
                        loading.postValue(false)
                        val list = coins.value
                        list?.addAll(it)
                        coins.postValue(list)
                    },
                    {
                        loading.postValue(false)
                        Log.i("LOG","resp: nextPage ERROR: ${it.message}")
                    }
            )
        }

    }

    fun getCoins(): LiveData<ArrayList<Coin>>? {
        return this.coins
    }
    fun getProgresControl(): LiveData<Boolean>?{
        return this.loading
    }
}