package com.tbi.supplierplus.framework.datasource.network

import com.tbi.supplierplus.business.pojo.*
import com.tbi.supplierplus.business.pojo.addCustomer.NewCustomer
import com.tbi.supplierplus.business.pojo.addCustomer.Ranges
import com.tbi.supplierplus.business.pojo.addCustomer.Regions
import com.tbi.supplierplus.business.pojo.addCustomer.RusNewCustomer
import com.tbi.supplierplus.business.pojo.addItem.NewItem
import com.tbi.supplierplus.business.pojo.addItem.Supplier
import com.tbi.supplierplus.business.pojo.addItem.TypeOfcategory
import com.tbi.supplierplus.business.pojo.bills.NewBill
import com.tbi.supplierplus.business.pojo.closing.SupplierReport
import com.tbi.supplierplus.business.pojo.expenses.AddExpenses
import com.tbi.supplierplus.business.pojo.expenses.ExpensesSearch
import com.tbi.supplierplus.business.pojo.expenses.Expensese
import com.tbi.supplierplus.business.pojo.opening.AddCollection
import com.tbi.supplierplus.business.pojo.opening.AddOpening
import com.tbi.supplierplus.business.pojo.opening.OpeningBalance
import com.tbi.supplierplus.business.pojo.price.EditProductprice
import com.tbi.supplierplus.business.pojo.price.SpecialPrice
import com.tbi.supplierplus.business.pojo.puarchase.AddBurchace
import com.tbi.supplierplus.business.pojo.puarchase.ItemsPRCh
import com.tbi.supplierplus.business.pojo.puarchase.Puarchase
import com.tbi.supplierplus.business.pojo.reports.*
import com.tbi.supplierplus.business.pojo.returns.ReturnItems
import com.tbi.supplierplus.business.pojo.returns.Suppliers
import com.tbi.supplierplus.business.pojo.settelment.ItemsSettelment
import com.tbi.supplierplus.business.pojo.settelment.SetItemsSettelment
import com.tbi.supplierplus.business.utils.Constants.HEADERS
import com.tbi.supplierplus.business.utils.Constants.WEBSERVICE
import com.tbi.supplierplus.framework.datasource.responses.*
import com.tbi.supplierplus.framework.ui.login.LoginModel
import com.tbi.supplierplus.framework.ui.login.Task3
import kotlinx.coroutines.Deferred
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*
import retrofit2.http.Body

interface SupplierAPI {

    @Headers(HEADERS)
    @POST("${WEBSERVICE}Registration_Request")
    fun registerAsync(@Body body: RequestBody?): Deferred<RegisterEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetLogin_By_Mac_ID")
    fun loginAsync(@Body body: RequestBody?): Deferred<LoginEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetCusBySearch")
    fun getCustomerBySearchAsync(@Body body: RequestBody?): Deferred<CustomerBySearchEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetItemBySearch")
    fun getItemsBySearchAsync(@Body body: RequestBody?): Deferred<ItemsBySearchEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetCus")
    fun getCustomerInfoAsync(@Body body: RequestBody?): Deferred<CustomerInfoEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetPurchases")
    fun getPurchasesAsync(@Body body: RequestBody?): Deferred<PurchaseEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}Purchases")
    fun addPurchaseAsync(@Body body: RequestBody?): Deferred<AddPurchaseEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetExpenses")
    fun getExpensesAsync(@Body body: RequestBody?): Deferred<ExpensesEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetFillSpinner")
    fun getExpensesTypesAsync(@Body body: RequestBody?): Deferred<ExpensesTypesEnvelope>


    @Headers(HEADERS)
    @POST("${WEBSERVICE}AddExpensesResponse")
    fun setExpensesAsync(@Body body: RequestBody?): Deferred<AddExpensesEnvelope>


    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetClosingDay_Summry_Expenses")
    fun getClosingDaySummaryExpensesAsync(@Body body: RequestBody?): Deferred<DailyClosingExpensesEnvelope>


    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetItemsSummryReport")
    fun getItemsSummaryAsync(@Body body: RequestBody?): Deferred<ItemsSummaryReportEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}Get_Customer_Statement")
    fun getCustomerStatementAsync(@Body body: RequestBody?): Deferred<StatementReportEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetselesSummry")
    fun getSalesSummaryAsync(@Body body: RequestBody?): Deferred<SalesSummaryEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetItemByBarcode")
    fun getItemInfoAsync(@Body body: RequestBody?): Deferred<ItemInfoEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}setpill")
    fun addBillAsync(@Body body: RequestBody?): Deferred<AddBillEnvelope>


    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetClosingDay_Summry_items")
    fun getClosingDaySummaryItemsAsync(@Body body: RequestBody?): Deferred<DailyClosingSummaryItemsEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetPurchases")
    fun getClosingDayPurchasesAsync(@Body body: RequestBody?): Deferred<DailyClosingPurchasesEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetClosingDay_Summry_Supplier")
    fun getClosingDaySummarySupplierAsync(@Body body: RequestBody?): Deferred<DailyClosingSummarySupplierEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}SetClosingDay")
    fun setClosingDayAsync(@Body body: RequestBody?): Deferred<SetDailyClosingEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetFillSpinner")
    fun getFillSpinnerReturnItemsAsync(@Body body: RequestBody?): Deferred<GetFillSpinnerReturnItemsEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}Get_Return_items_settelment")
    fun getReturnItemsSettelmentAsync(@Body body: RequestBody?): Deferred<GetReturnItemsSettelmentEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}Set_items_settelment")
    fun setReturnItemsSettlementAsync(@Body body: RequestBody?): Deferred<SetReturnItemsSettlementEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}Get_Pill_Details")
    fun getBillDetailsAsync(@Body body: RequestBody?): Deferred<BillDetailsEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetAllDebts")
    fun getCustomerDebitsAsync(@Body body: RequestBody?): Deferred<CustomerDebitsEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}GetAllcustomersOpeningBalance")
    fun getOpeningBalancesAsync(@Body body: RequestBody?): Deferred<OpeningBalanceEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}AddOpeningBalance")
    fun addOpeningBalanceAsync(@Body body: RequestBody?): Deferred<AddOpeningBalanceEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}AddCollection")
    fun addCollectionAsync(@Body body: RequestBody?): Deferred<AddCollectionEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}Get_Region")
    fun getRegionsAsync(@Body body: RequestBody?): Deferred<RegionEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}AddCustomer")
    fun addCustomerAsync(@Body body: RequestBody?): Deferred<AddCustomerEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}Get_items_settelment")
    fun getItemsSettlementAsync(@Body body: RequestBody?): Deferred<GetItemsSettlementEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}Get_itemsVS_Bill")
    fun getItemsVsBillAsync(@Body body: RequestBody?): Deferred<GetItemsVsBillEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}Set_items_settelment")
    fun setItemsSettlementAsync(@Body body: RequestBody?): Deferred<SetItemsSettlementEnvelope>

    @Headers(HEADERS)
    @POST("${WEBSERVICE}AddItemsReturn")
    fun addItemsReturnAsync(@Body body: RequestBody?): Deferred<AddItemsReturnEnvelope>

    //  @Headers("Content-Type: application/json")
    //  @GET("api/Sale/GetCusBySearch")
    //  fun GetCusBySearch(@Query("UserID") UserID:String): Deferred<Customerss>


    @Headers("Content-Type: application/json")
    @GET("api/Sale/AllCusWithDeffered")
    fun getAllCus(@Query("UserID") UserID: String): Deferred<Tasks<AllCustomers>>

    @Headers("Content-Type: application/json")
    @GET("api/Sale/AllCusWithDeffered")
    fun getAllCustomers(@Query("UserID") UserID: String): Deferred<Tasks<AllCustomers>>


    @Headers("Content-Type: application/json")
    @GET("api/Report/Get_Customer_Statement")
    fun getCustomerStatementAPI(@Query("CusID") UserID: String): Deferred<Tasks<Invoices>>


    @Headers("Content-Type: application/json")
    @GET("api/Sale/GetItemsWithCusDeffered")
    fun getitem(
        @Query("UserID") UserID: Int,
        @Query("CustID") Cus_id: Int
    ): Deferred<Tasks<Items>>


    @Headers("Content-Type: application/json")
    @GET("api/Sale/GetItemByBarcode")
    fun GetItemByBarcode(
        @Query("sales_Id") sales_Id: Int, @Query("Item_ID") Item_ID: String,
        @Query("Cus_id") Cus_id: String?
    ): Deferred<Tasks<Producer>>

    @Headers("Content-Type: application/json")
    @GET("api/Sale/GetItemByBarcode")
    fun GetItemByBarcode2(
        @Query("sales_Id") sales_Id: Int, @Query("Item_ID") Item_ID: String,
        @Query("Cus_id") Cus_id: String?
    ): Response<Tasks<Producer>>


    @Headers("Content-Type: application/json")
    @GET("api/Purchases/GetItemsForPurchases")
    fun getItemsforPuarches(@Query("UserID") User_ID: String): Deferred<Tasks<ItemsPRCh>>

    @Headers("Content-Type: application/json")
    @GET("api/ClosingDay/GetPurchases")
    fun GetPurchases(@Query("User_ID") User_ID: String): Deferred<Tasks<Puarchase>>


    @Headers("Content-Type: application/json")
    @POST("api/Purchases/Purchases")
    fun addPurchases(@Body addBurchace: AddBurchace): Deferred<Tasks<Puarchase>>


    //Expensese
    @Headers("Content-Type: application/json")
    @POST("api/Expenses/AddExpenses")
    fun addExpensesAPI(@Body addExpenses: AddExpenses): Deferred<Tasks<Expensese>>

    @Headers("Content-Type: application/json")
    @GET("api/Expenses/ExpensesSearch")
    fun getExpensesSearchTypeAPI(): Deferred<Tasks<ExpensesSearch>>

    @Headers("Content-Type: application/json")
    @GET("api/Expenses/GetExpenses")
    fun GetExpensesAPI(@Query("UserID") User_ID: String): Deferred<Tasks<Expensese>>


    @Headers("Content-Type: application/json")
    @GET("api/Report/GetItemsSummryReport")
    fun getItemsReportAPI(@Query("UserID") User_ID: String): Deferred<Tasks<ItemReport>>

    @Headers("Content-Type: application/json")
    @GET("api/Report/GetselesSummry")
    fun getselesReportAPI(@Query("Userid") User_ID: String): Deferred<Tasks<SelesReport>>


    @Headers("Content-Type: application/json")
    @GET("api/Report/Get_Customer_Statement")
    fun get_Customer_StatementAPI(@Query("Userid") User_ID: String): Deferred<Tasks<SelesReport>>


    //closing
    @Headers("Content-Type: application/json")
    @GET("api/ClosingDay/GetClosingDay_Summry_Supplier")
    fun getClosingDaySupplierAPI(@Query("User_ID") User_ID: String): Deferred<Tasks<SupplierReport>>

    @Headers("Content-Type: application/json")
    @GET("api/ClosingDay/GetClosingDay_Summry_Expenses")
    fun getClosingDayExpensesAPI(@Query("User_ID") User_ID: String): Deferred<Tasks<SupplierReport>>


    @Headers("Content-Type: application/json")
    @GET("api/ClosingDay/GetClosingDay_Summry_items")
    fun getClosingDayitemsAPI(@Query("User_ID") User_ID: String): Deferred<Tasks<SupplierReport>>

    //api/ClosingDay/GetPurchases
    @Headers("Content-Type: application/json")
    @GET("api/ClosingDay/GetPurchasesForClosing")
    fun getClosingDayPurchasesAPI(@Query("User_ID") User_ID: String): Deferred<Tasks<SupplierReport>>


    @Headers("Content-Type: application/json")
    @GET("api/Customer/GetAllcustomersOpeningBalance")
    fun getAllcustomersOpeningBalanceAPI(@Query("distributor_id") User_ID: String): Deferred<Tasks<OpeningBalance>>


    @Headers("Content-Type: application/json")
    @POST("api/Customer/AddOpeningBalance")
    fun addCustomerOpeningBalanceAPI(@Body add: AddOpening): Deferred<Tasks<OpeningBalance>>


    @Headers("Content-Type: application/json")
    @GET("api/Items/Get_Return_items_settelment")
    fun getReturnitemsAPI(
        @Query("user_id") user_id: String,
        @Query("supplier_id") supplier_id: String
    ): Deferred<Tasks<ReturnItems>>

    @Headers("Content-Type: application/json")
    @GET("api/Supplier/GetSuppliers")
    fun getSuppliersAPI(@Query("UserId") user_id: String): Deferred<Tasks<Suppliers>>

    @Headers("Content-Type: application/json")
    @GET("api/Items/Get_items_settelment")
    fun Get_items_settelmentAPI(
        @Query("user_id") user_id: String,
        @Query("supplier_id") supplier_id: String
    ): Deferred<Tasks<ItemsSettelment>>


    @Headers("Content-Type: application/json")
    @POST("api/Sale/setpill")
    fun setPillAPI(@Body bill: NewBill): Deferred<Tasks<Tesssst>>


    @Headers("Content-Type: application/json")
    @GET("api/Sale/GetItemByBarcodeV1")
    fun getItemByBarcodeV1API(
        @Query("sales_Id") salas_Id: String,
        @Query("Barcode") Barcode: String, @Query("Cus_id") Cus_id: String
    ): Deferred<Tasks<Items>>


    @Headers("Content-Type: application/json")
    @GET("api/Customer/Get_AllDebts")
    fun Get_AllDebtsAPI(@Query("Distributor_ID") salas_Id: String): Deferred<Tasks<OpeningBalance>>

    @Headers("Content-Type: application/json")
    @POST("api/Customer/AddCollection")
    fun AddCollectionAPI(@Body addCollection: AddCollection): Deferred<Tasks<AddCollection>>


    @Headers("Content-Type: application/json")
    @GET("api/Items/GetItemGroup")
    fun GetItemGroupAPI(
        @Query("UserId") UserId: String,
        @Query("Supplier_ID") Supplier_ID: String
    ): Deferred<Tasks<TypeOfcategory>>


    @Headers("Content-Type: application/json")
    @POST("api/Items/Set_items_settelment")
    fun SetitemssettelmentAPI(@Body setItemsSettelment: SetItemsSettelment): Deferred<Tasks<TypeOfcategory>>


    @Headers("Content-Type: application/json")
    @GET("api/Supplier/GetSuppliers")
    fun GetSuppliersAPI(@Query("UserId") UserId: String): Deferred<Tasks<Supplier>>


    @Headers("Content-Type: application/json")
    @POST("api/Items/Set_New_Item")
    fun Set_New_ItemAPI(@Body setItem: NewItem): Deferred<Tasks<Supplier>>


    @Headers("Content-Type: application/json")
    @GET("api/Report/Get_Pill_Details")
    fun getPillDetailsAPI(
        @Query("PillNo") PillNo: String,
        @Query("Cusid") Cusid: String
    ): Deferred<Tasks<InvoiceDetails>>

    @Headers("Content-Type: application/json")
    @POST("api/ClosingDay/SetClosingDay")
    fun SetClosingDayAPI(@Query("User_ID") User_ID: String): Deferred<Tasks<InvoiceDetails>>

    @Headers("Content-Type: application/json")
    @GET("api/Customer/Get_Region")
    fun Get_RegionAPI(
        @Query("UserID") User_ID: String,
        @Query("Range_Id") Range_Id: String
    ): Deferred<Tasks<Regions>>

    @Headers("Content-Type: application/json")
    @POST("api/Customer/AddCustomer")
    fun AddCustomerAPI(@Body newCustomer: NewCustomer): Deferred<Tasks<RusNewCustomer>>

    @Headers("Content-Type: application/json")
    @GET("api/Customer/GetRange")
    fun GetRangeAPI(@Query("UserId") UserId: String): Deferred<Tasks<Ranges>>


    @Headers("Content-Type: application/json")
    @POST("api/Items/SetSpecialItemPrice")
    fun SetSpecialItemPriceAPI(@Body specialPrice: SpecialPrice): Deferred<Tasks<SpecialPrice>>

    @Headers("Content-Type: application/json")
    @GET("api/Report/GetselesSummryForSpecificCustomer")
    fun GetselesSummryForSpecificCustomerAPI(
        @Query("Userid") User_ID: String,
        @Query("CusID") CusID: String
    ): Deferred<Tasks<ReportSpecificCustomer>>

///api/Items/EditItemByBarcode


    @Headers("Content-Type: application/json")
    @POST("api/Items/EditItemByBarcode")
    fun EditItemByBarcodeAPI(@Body editProductprice: EditProductprice): Deferred<Tasks<ReportSpecificCustomer>>


    @Headers("Content-Type: application/json")
    @GET("api/Account/GetLogin_By_Mac_ID")
    fun LoginAPI(@Query("android_id") android_id: String): Deferred<Task3<LoginModel>>

    @Headers("Content-Type: application/json")
    @POST("api/Account/Registration_Request")
    fun RegistrationAPI(@Body registrationModel: RegistrationModel): Deferred<Task3<RegistrationModel>>



//    @Headers("Content-Type: application/json")
//    @GET("api/Account/GetBranch")
//    fun GetBranchAPI(@Query("comID") ComID: String?): Deferred<Task2<BranchModel>>
}