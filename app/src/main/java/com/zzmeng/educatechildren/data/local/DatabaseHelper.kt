package com.zzmeng.educatechildren.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.zzmeng.educatechildren.data.entity.UserEntity
import com.zzmeng.educatechildren.data.local.dao.UserEntityDao

/** Create by chenzhuang on 2018/11/26 0026 下午 2:58
 *      本地数据库
 */
@Database(entities = [(UserEntity::class)], version = DatabaseConstant.DB_VERSION, exportSchema = false)
abstract class DatabaseHelper: RoomDatabase() {

    abstract fun userDao(): UserEntityDao

    companion object {
        private var INSTANCE: DatabaseHelper? = null

        private val lock = Any()

        fun getInstance(context: Context): DatabaseHelper{
            synchronized(lock){
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            DatabaseHelper::class.java, DatabaseConstant.DB_NAME)
                            .build()
                }
            }
            return INSTANCE!!
        }
    }

}