package com.tbi.supplierplus.framework.ui.login

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.CallLog
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.tbi.supplierplus.MainActivity
import com.tbi.supplierplus.databinding.ActivityLoginAccBinding
import com.tbi.supplierplus.framework.ui.registration.RegistrationActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginAccActivity : AppCompatActivity() {
    private val viewModel: AccountViewModel by viewModels()
    private lateinit var binding: ActivityLoginAccBinding

    //  private lateinit var manifestPermissionsRequestor: ManifestPermissionsRequester

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginAccBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val androidId: String = Settings.Secure.getString(
            contentResolver,
            Settings.Secure.ANDROID_ID
        )

        viewModel.loginInfoCombVM(androidId,this)
        viewModel.loginInfoCombVLiveData.observe(this) {

            when (it) {
                is State.Loading -> Log.d("aziza", "")
                is State.Success -> {
                    Log.d("aziza32", it.data.message)
                    Log.d("aziza32", it.data.State.toString())
                    if (it.data!!.State == 0) {

                        //your Request is pending

                        binding.textView5.text = it.data.message
                        // Toast.makeText(applicationContext, it.data.State.toString() + "your Request is pending", Toast.LENGTH_SHORT).show()
                        Toast.makeText(applicationContext, it.data.State.toString() + it.data.message, Toast.LENGTH_SHORT).show()

                        binding.textView5.setText(it.data.message)

                    } else if (it.data!!.State == 1) {

                        //Successfully Login
                        // viewModel.saveInfoRoom(androidId)

//                        viewModel.saveInfoLogin(it.data.item)
//                        Log.d("saveInfoLogin",it.data.item.Name)
//                        viewModel.saveItems(it.data.item.comid.toString(),it.data.item.AndroidID)

                        Toast.makeText(applicationContext, it.data.State.toString() + it.data.message, Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                        // val intent = Intent(this, MainDrawerActivity::class.java)
                        // startActivity(intent)
                        // finish()

                    } else if (it.data!!.State == 2) {
                        //your Request has been pendding


                        Toast.makeText(
                            applicationContext,
                            it.data.State.toString() + it.data.message,
                            Toast.LENGTH_SHORT
                        ).show()

                    } else if (it.data!!.State == 3) {
                        //your Machine has been Registration
                        Log.d("aziza32", it.data.message)
                        //  Toast.makeText(applicationContext, it.data.State.toString() + "your Machine has been suspended", Toast.LENGTH_SHORT).show()
                        Toast.makeText(
                            applicationContext,
                            it.data.State.toString() + it.data.message,
                            Toast.LENGTH_SHORT
                        ).show()

                        //your Machine has been suspended
                        binding.textView5.text = it.data.message
                        //your Machine has been suspended
                        binding.textView5.setText(it.data.message)
                        val intent = Intent(this, RegistrationActivity::class.java)
                        startActivity(intent)

                        finish()

                    } else if (it.data!!.State == 4) {
                        //go to registeration first
                        //   Toast.makeText(applicationContext, it.data.State.toString() + "go to registeration first", Toast.LENGTH_SHORT).show()
                        Toast.makeText(
                            applicationContext,
                            it.data.State.toString() + it.data.message,
                            Toast.LENGTH_SHORT
                        ).show()
                        //go to registeration first

                        /**
                        val intent = Intent(this, RegisterationActivity::class.java)
                        startActivity(intent)

                         */
                        // go to registration first
                        //  val intent = Intent(this, AccountActivity::class.java)
                        //  startActivity(intent)
                        //  finish()
                    }
                }
                is State.Error -> Log.d("aziza32", it.messag.toString())

            }
        }


    }


    override fun onStart() {
        super.onStart()
        // getPermissions()
        //setAsProtectedApp()
    }


    private fun setAsProtectedApp() {
        if ("huawei".equals(Build.MANUFACTURER, ignoreCase = true)
            && !("google".equals(Build.MANUFACTURER, ignoreCase = true))
        ) {
            val alertDialog = AlertDialog.Builder(this)

            alertDialog.setTitle("huawei_headline").setMessage("huawei_text")
                .setPositiveButton("go_to_protected") { dialogInterface, i ->
                    val intent = Intent()
                    intent.component = ComponentName(
                        "com.huawei.systemmanager",
                        "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"
                    )
                    startActivity(intent)
                    //  sp.edit().putBoolean("protected", true).commit()
                }.create().show()
        }
    }

    private fun displayLog() {
        var cols = arrayOf(
            CallLog.Calls._ID, CallLog.Calls.NUMBER, CallLog.Calls.TYPE, CallLog.Calls.DURATION,
            CallLog.Calls.DATE
        )
        var rs = contentResolver.query(
            CallLog.Calls.CONTENT_URI,
            cols,
            null,
            null,
            "${CallLog.Calls.LAST_MODIFIED} DESC"
        )
        var from = arrayOf(CallLog.Calls.NUMBER, CallLog.Calls.DURATION, CallLog.Calls.TYPE)
        // val adapter= SimpleCursorAdapter(this, R.layout.mylayout,rs,from, intArrayOf(R.id.textView1,R.id.textView2,R.id.textView3),0)
        // val listview=findViewById<ListView>(R.id.listview) as ListView
        // listview.adapter=adapter
    }
}