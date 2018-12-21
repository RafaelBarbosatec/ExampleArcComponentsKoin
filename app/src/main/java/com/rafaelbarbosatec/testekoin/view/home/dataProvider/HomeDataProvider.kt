package com.rafaelbarbosatec.testekoin.view.home.dataProvider
import com.rafaelbarbosatec.testekoin.domain.coinDomain.CoinDomain
import com.rafaelbarbosatec.testekoin.domain.coinDomain.model.Coin

/**
 * Created by rafael on 24/10/18.
 */
class HomeDataProvider(private val coinDomain: CoinDomain): HomeDataProviderContract{

    override fun loadCoins(page: Int, limite: String, onNext: (ArrayList<Coin>) -> Unit, onError: (Throwable) -> Unit) {

        coinDomain.loadCoins(page,limite,onNext,onError)

    }

}