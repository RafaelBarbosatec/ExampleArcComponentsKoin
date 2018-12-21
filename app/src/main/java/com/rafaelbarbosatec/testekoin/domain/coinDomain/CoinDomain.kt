package com.rafaelbarbosatec.testekoin.domain.coinDomain

import com.rafaelbarbosatec.testekoin.data.network.CoinApi
import com.rafaelbarbosatec.testekoin.domain.coinDomain.model.Coin
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by rafael on 22/10/18.
 */
class CoinDomain( val coinApi: CoinApi){


    fun loadCoins(page:Int, limite:String, onNext:(ArrayList<Coin>) -> Unit, onError:(Throwable) -> Unit ){

        coinApi.getCoins("BRL",limite,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext,onError)

    }

}