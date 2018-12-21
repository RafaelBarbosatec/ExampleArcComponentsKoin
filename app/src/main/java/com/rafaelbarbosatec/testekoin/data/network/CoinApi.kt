package com.rafaelbarbosatec.testekoin.data.network


import com.rafaelbarbosatec.testekoin.domain.coinDomain.model.Coin
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by rafael on 22/10/18.
 */
interface CoinApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("ticker/")
    fun getCoins(
            @Query("convert") convert:String,
            @Query("limit") limit:String,
            @Query("start") page:Int
    ): Observable<ArrayList<Coin>>
}