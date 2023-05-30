package com.legp.totalplaytest.mvp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.legp.totalplaytest.R
import com.legp.totalplaytest.app.preferences
import com.legp.totalplaytest.databinding.ActivityLoginBinding
import com.legp.totalplaytest.mvp.model.response.BankModel

import com.legp.totalplaytest.mvp.presenter.MainActivityPresenter
import com.legp.totalplaytest.mvp.presenter.view.MainView
import com.legp.totalplaytest.databinding.ActivityMainBinding
import com.legp.totalplaytest.mvp.view.adapters.BanksAdapter
import com.legp.totalplaytest.utils.goToActivity

class MainActivity: BaseActivity<MainActivityPresenter>(), MainView {

    private lateinit var binding: ActivityMainBinding

    private var lstReferences: ArrayList<BankModel> = arrayListOf()

    override fun instantiatePresenter(): MainActivityPresenter {
        return MainActivityPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter.getReferences(preferences.token)

        toolbarToLoad(binding.toolbar.root)
        enableHomeDisplay(true)

        supportActionBar!!.title = "Referencias bancarias"
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                goToActivity<LoginActivity> {  }
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun setAdapter(arrayReferences: ArrayList<BankModel>) {
        lstReferences = arrayReferences
        val layoutManager = LinearLayoutManager(this@MainActivity)
        val adapater  = BanksAdapter(this, lstReferences)

        binding.rvReferences.adapter = adapater
        binding.rvReferences.setHasFixedSize(true)
        binding.rvReferences.layoutManager = layoutManager
        binding.rvReferences.itemAnimator = DefaultItemAnimator()

    }
}