package com.zzmeng.educatechildren.data.local.dao

import android.arch.persistence.room.*
import com.zzmeng.educatechildren.data.entity.UserEntity
import com.zzmeng.educatechildren.data.local.DatabaseConstant

/** Create by chenzhuang on 2018/11/26 0026 下午 3:14
 *
 */
@Dao interface UserEntityDao {

    @Query("SELECT * FROM ${DatabaseConstant.TB_USER_NAME} WHERE ${DatabaseConstant.FIELD_USER_ID} = :monoId")
    fun getUserById(monoId: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(entity: UserEntity)

    @Update
    fun updateUser(entity: UserEntity): Int
}