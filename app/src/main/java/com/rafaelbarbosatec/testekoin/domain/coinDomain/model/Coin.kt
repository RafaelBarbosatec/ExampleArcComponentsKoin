package com.rafaelbarbosatec.testekoin.domain.coinDomain.model


/**
 * Created by rafael on 22/10/18.
 */
class Coin(val id:String,
           val name:String,
           val symbol:String,
           val rank:String,
           val price_brl:String,
           val percent_change_24h:String
){
    override fun toString(): String {
        return "Coin(id='$id', name='$name', symbol='$symbol', rank='$rank', price_brl='$price_brl', percent_change_24h='$percent_change_24h')"
    }
}