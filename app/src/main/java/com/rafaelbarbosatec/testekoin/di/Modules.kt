package com.rafaelbarbosatec.testekoin.di

import com.rafaelbarbosatec.testekoin.domain.coinDomain.CoinDomain
import com.rafaelbarbosatec.testekoin.view.home.HomeViewModel
import com.rafaelbarbosatec.testekoin.view.home.dataProvider.HomeDataProvider
import com.rafaelbarbosatec.testekoin.view.home.dataProvider.HomeDataProviderContract
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object Modules {

    val appModule = module {
        // single instance of HelloRepository
        single { CreateModules.createCoinApi(get()) }
        single { CreateModules.provideGson() }
        single { CreateModules.provideRetrofitInterface(get()) }
    }

    val domainModule = module {
        // single instance of HelloRepository
        single { CoinDomain(get()) }
        single<HomeDataProviderContract> { HomeDataProvider(get()) }
    }
    val viewModelModule = module {
        // MyViewModel ViewModel
        viewModel { HomeViewModel(get()) }
    }

}