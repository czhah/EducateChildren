package com.zzmeng.educatechildren.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import com.zzmeng.educatechildren.data.local.DatabaseConstant

/** Create by chenzhuang on 2018/11/26 0026 上午 10:52
 *
 */
@Entity(tableName = DatabaseConstant.TB_USER_NAME)
class UserEntity @JvmOverloads constructor(@NonNull @PrimaryKey @ColumnInfo(name = DatabaseConstant.FIELD_USER_ID) var monoId: String = "",
                                           @ColumnInfo(name = DatabaseConstant.FIELD_USER_NICKNAME) var nickname: String = "",
                                           @ColumnInfo(name = DatabaseConstant.FIELD_USER_ACCOUNT) var account: String = "",
                                           @ColumnInfo(name = DatabaseConstant.FIELD_USER_AVATAR) var avatar: String = "",
                                           @ColumnInfo(name = DatabaseConstant.FIELD_USER_GENDER) var gender: Int = 0)