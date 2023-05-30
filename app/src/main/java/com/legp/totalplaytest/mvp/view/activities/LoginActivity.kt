package com.legp.totalplaytest.mvp.view.activities

import android.os.Bundle
import android.text.InputType
import com.legp.totalplaytest.R
import com.legp.totalplaytest.databinding.ActivityLoginBinding
import com.legp.totalplaytest.mvp.presenter.LoginActivityPresenter
import com.legp.totalplaytest.mvp.presenter.view.LoginView
import com.legp.totalplaytest.utils.goToActivity


class LoginActivity : BaseActivity<LoginActivityPresenter>(), LoginView {

    private lateinit var binding: ActivityLoginBinding
    private var showPass: Boolean = true
    override fun instantiatePresenter(): LoginActivityPresenter {
        return LoginActivityPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setActionsButtons()
    }

    private fun setActionsButtons() {

        binding.ivShowpass.setOnClickListener {
            if (showPass) {
                binding.ivShowpass.setImageDrawable(getDrawable(R.drawable.ic_hide_pass))
                binding.edtxPass.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                showPass = false
            } else {
                binding.ivShowpass.setImageDrawable(getDrawable(R.drawable.ic_show_pass))
                binding.edtxPass.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                showPass = true
            }
            binding.edtxPass.setSelection(binding.edtxPass.length())
        }

        binding.ivHelp.setOnClickListener {
            showToast("Puedes ingresar tu cuenta que viene en el contrato")
        }

        binding.btnLogin.setOnClickListener {

            if (binding.edtxUser.text.toString().isNullOrEmpty()) {
                showErrorMessage("Es necesario la cuenta / correo / teléfono")
                return@setOnClickListener
            }
            if (binding.edtxPass.text.toString().isNullOrEmpty()) {
                showErrorMessage("Es necesaria la contraseña")
                return@setOnClickListener
            }

            presenter.loginUser(binding.edtxUser.text.toString(), binding.edtxPass.text.toString())

        }

    }

    override fun succesLogin() {

        goToActivity<MainActivity> {
        }
        finish()

    }


}