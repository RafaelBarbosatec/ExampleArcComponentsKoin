package com.rafaelbarbosatec.testekoin.view.home

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rafaelbarbosatec.testekoin.R
import com.rafaelbarbosatec.testekoin.domain.coinDomain.model.Coin
import com.rafaelbarbosatec.testekoin.view.home.adapters.CoinAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var adapter: CoinAdapter? = null

    // Lazy Inject ViewModel
    val myViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initViewModel()
    }

    private fun initViews() {

        adapter = CoinAdapter(ArrayList(),this,recyclerview_coins)
        adapter?.setNextListern {
            myViewModel.nextPage()
        }

    }

    private fun initViewModel() {

        myViewModel.getCoins()?.observe(this, Observer<ArrayList<Coin>> { list ->

            adapter?.replaceData(list?:ArrayList())

        })

        myViewModel.getProgresControl()?.observe(this, Observer<Boolean> { show ->

            if (show == true){
                progressbar.visibility = View.VISIBLE
            }else{
                progressbar.visibility = View.GONE
            }

        })

    }
}
