package com.tbi.supplierplus.framework.ui.sales.customers

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.tbi.supplierplus.BillActivity2
import com.tbi.supplierplus.business.utils.showHelperDialog
import com.tbi.supplierplus.databinding.FragmentCustomersBinding
import com.tbi.supplierplus.framework.datasource.requests.State
import com.tbi.supplierplus.framework.ui.sales.SalesViewModel
import com.tbi.supplierplus.testAdabters.AllCustomersAdapter
import com.tbi.supplierplus.testAdabters.OnClickListenerss
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomersFragment : Fragment() {

    private lateinit var binding: FragmentCustomersBinding
    private val viewModel: SalesViewModel by activityViewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCustomersBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        // Toast.makeText(activity," data", Toast.LENGTH_LONG).show()
        viewModel.  getAllCustomerTesthandel1()

       viewModel. Regionsd.observe(viewLifecycleOwner) {

          when( it){

                  is State.Loading -> { createSimpleOkDialog(context!!.applicationContext,"","") }
                  //Log.d("makeText","Loading")
              is State.Success -> Log.d("makeText","Success")
              is State.Error -> Log.d("makeText","Error")

          }

       }

    //    val adapter = CustomersAdapter(OnClickListener {
    //        viewModel.setCustomerID(it.customerID)
    //        findNavController().navigate(
    //            CustomersFragmentDirections.actionCustomersFragmentToCustomerProfileFragment()
//
    //        )
//
//
    //    })
       viewModel.getAllCustomerTesthandel1()
 //      lifecycleScope.launchWhenStarted{
 //          viewModel.addRateStateFlow.collect {
 //              when (it) {
 //                  is NetworkState.Idle -> {
 //                      return@collect
 //                  }
 //                  is NetworkState.Loading -> {
 //                     // visProgress(true)
 //                  }
 //                  is NetworkState.Error -> {
 //                     // visProgress(false)
 //                     // it.handleErrors(mContext, null)
 //                  }
 //                  is NetworkState.Result<*> -> {
 //                   //   visProgress(false)
 //                     // handleResult(it.response as TaskUsersResponse)
 //                  }
 //              }
//
 //          }
 //      }


        val adapters = CustomersAdapter1(OnClickListeners {
          // viewModel.setCustomerID(it.customerID)
          // findNavController().navigate(
          //     CustomersFragmentDirections.actionCustomersFragmentToCustomerProfileFragment()
          // )
        })
        //بيضرب هنا
    //   viewModel.setUser(
    //       CustomersFragmentArgs.fromBundle(requireArguments()).user
    //   )
        val  adapte=AllCustomersAdapter(OnClickListenerss {
        //    viewModel.setCustomerID("2")

            val Customer_ID=it.Customer_ID.toString()
            val Unpaid_deferred=it.Unpaid_deferred.toString()
            val CompanyName=it.item.toString()
           // val x=it.Customer_ID.toString()
           // Toast.makeText(activity,it.Customer_ID.toString(),Toast.LENGTH_LONG).show()
            val intent = Intent(activity, BillActivity2::class.java)
                .apply {
                putExtra("Customer_ID", Customer_ID)
                putExtra("Unpaid_deferred", Unpaid_deferred)
                putExtra("CompanyName", CompanyName)
               // putExtra("EXTRA_MESSAGE", s)
            //    putExtra("EXTRA_MESSAGE", s)
            }
            startActivity(intent)
         //  findNavController().navigate(
         //     // CustomersFragmentDirections.actionCustomersFragmentToBillItemsFragment()
         //     CustomersFragmentDirections.actionCustomersFragmentToBillItems2Fragment(s)

         //    //  CustomersFragmentDirections.actionCustomersFragmentToProductSelectionFragment()
         //          //.actionCustomersFragmentToCustomerProfileFragment()
         //  )
         //  getActivity()?.getFragmentManager()?.popBackStack()

          //  getActivity()?.getFragmentManager().  popBackStack(R.id.customersFragment, true)
           // activity?.onBackPressed()
            // findNavController().navigate(
            //     CustomersFragmentDirections.actionCustomersFragmentToCustomerProfileFragment()
            // )

        })

        lifecycleScope.launchWhenStarted{
            viewModel.customes(activity!!)
            viewModel.getAllCustomers()
        }
        viewModel.Regionsd2.observe(viewLifecycleOwner){

        }
        viewModel.getAllCustomersLiveData.observe(viewLifecycleOwner){
         //   Toast.
            Log.d("makeText","Loading")
            binding.recyclerView.adapter = adapte
            adapte.submitList(it)
        }
 //      viewModel.getAllItemss()
 //      viewModel.x.observe(viewLifecycleOwner){
 //          binding.recyclerView.adapter = adapters
 //            adapters.submitList(it)
 //          //  adapters.submitList(viewModel.x.value)
 //  //Toast.makeText(activity,it.get(0).item, Toast.LENGTH_LONG).show()
 //          //   //    Log.d("haaaagaaaar", it.AllCustomers.get(0).item)

 //      }
  //    viewModel._allItemss.observe(viewLifecycleOwner){
  //     val a:   List<CustomersModel> = it.AllCustomers
  //        binding.recyclerView.adapter = adapters
  //      //  adapter.submitList(viewModel.customers.value)
  //        adapter.submitList(it.AllCustomers)
  //     //   val a=it.AllCustomers
  //   //    binding.recyclerView.adapter = adapter
  //   //    adapter.submitList(it.AllCustomers)

  //   //    Log.d("haaaagaaaar", it.AllCustomers.get(0).item)
  //    // Toast.makeText(activity,it.AllCustomers.get(0).item, Toast.LENGTH_LONG).show()
  //      //  it.get(0).Customer_ID

  //   }

 //  viewModel.customers.observe(viewLifecycleOwner) {
 //      binding.recyclerView.adapter = adapter
 //      adapter.submitList(viewModel.customers.value)
 //  }


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
              //  if (query.length > 1)
                //    adapte.filter.filter(query)
             //   adapte.notifyDataSetChanged()
                   viewModel.filterCustomers(query)
             //   adapte.notifyDataSetChanged()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
              //  if (newText.length > 1)
             //       adapte.filter.filter(newText)


                 viewModel.filterCustomers(newText)
              //  adapte.notifyDataSetChanged()
                return false
            }
        })

//       binding.btnQr.setOnClickListener {
//           findNavController().navigate(
//               CustomersFragmentDirections.actionCustomersFragmentToCustomerQRCodeScannerFragment(
//                   "customer"
//               )
//           )
//       }

   //   viewModel.navigateToCustomersProfile.observe(viewLifecycleOwner) {
   //       if (it) {
   //           findNavController().navigate(
   //               CustomersFragmentDirections.actionCustomersFragmentToCustomerProfileFragment()
   //           )
   //           viewModel.onDoneNavigateToCustomersProfile()
   //       }
   //   }



        return binding.root
    }
   // private fun <T> handleResult(response: T) {

     //   Log.e(TAG, "handleResult: $response")

   //    when (response) {
   //        is GeneralResponse -> {
   //            when (response.code) {
   //                Constants.Codes.SUCCESSES_CODE -> {
   //                    goto(getString(R.string.task_rated_sucessfully))
   //                }
   //                else -> {
   //                    NetworkState.Error(response.code, response.msg).handleErrors(mContext)
   //                }
   //            }
   //        }
   //        is TaskUsersResponse -> {
   //            when (response.code) {
   //                Constants.Codes.SUCCESSES_CODE -> {
   //                    if (response.data.isEmpty())
   //                        goto(getString(R.string.there_are_no_users_to_rate))
   //                    else {
   //                        users.addAll(response.data)
   //                        ui()
   //                    }
   //                }
   //                else -> {
   //                    NetworkState.Error(response.code, response.msg).handleErrors(mContext)
   //                }
   //            }
   //        }
   //    }
   //}
}

//fun showHelperDialog(
//    msg: String,
//    mContext: Context,
//    mDialogsListener: DialogsListener?
//) {
//
//    //Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show()
//    mDialogsListener?.onDismiss()
//}

fun createSimpleOkDialog(context: Context?, title: String?, message: String?): Dialog? {
    val alertDialog: AlertDialog.Builder = AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setNegativeButton(android.R.string.ok, null)
    return alertDialog.create()
}