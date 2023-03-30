package com.tbi.supplierplus.framework.ui.registration

import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tbi.supplierplus.business.pojo.RegistrationModel
import com.tbi.supplierplus.databinding.ActivityRegistrationBinding
import com.tbi.supplierplus.framework.ui.login.AccountViewModel
import com.tbi.supplierplus.framework.ui.login.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private val viewModel: AccountViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val androidId: String = Settings.Secure.getString(
            contentResolver,
            Settings.Secure.ANDROID_ID
        )


        binding.SendRequestId.setOnClickListener{
          if (  CheckAllFields() ) {
            viewModel.RegistrationInfo(RegistrationModel(
                androidId,
                binding.com.text.toString(),
                binding.POStxt.text.toString().toInt()

            )
            ,this)
            viewModel.registrationLiveData.observe(this){
                when (it) {
                    is State.Loading -> { Log.d("registrationLiveData","Loading")}
                    is State.Success -> {
                        Log.d("registrationLiveData",it.data.message)
                        Toast.makeText(applicationContext,it.data.message, Toast.LENGTH_SHORT).show()

                    }
                    is State.Error -> {
                        Log.d("registrationLiveData",it.messag)
                        Toast.makeText(applicationContext,"خطا", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
        }
    }

    private fun CheckAllFields(): Boolean {
        if (binding.com.length() == 0) {
            binding.com.setError("This field is required")
            return false
        }
        else if (binding.POStxt.length() == 0) {
            binding.POStxt.setError("This field is required")
            return false
        }

        // after all validation return true.
        return true
    }
}