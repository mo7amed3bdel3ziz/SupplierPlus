package com.tbi.supplierplus.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tbi.supplierplus.business.models.User

@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class SupplierDatabase : RoomDatabase() {
    abstract fun dao(): SupplierDao
}
