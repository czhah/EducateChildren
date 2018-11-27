package com.zzmeng.common.util

import android.content.Context
import android.content.SharedPreferences
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/** Create by chenzhuang on 2018/11/27 0027 下午 1:16
 *      SharePreferences帮助类
 */
object SharePreUtils {

    private val SHAPRE_PUBLIC = "edu_kotlin_public"

    private val SHAPE_PRIVATE = "edu_kotlin_private"

    const val KEY_PRIVATE_USER_ID = "user_mono_id"

    fun put(context: Context, key: String, any: Any) {
        put(context, key, any, true)
    }

    fun put(context: Context, key: String, any: Any, isPublic: Boolean){
        val sp = context.getSharedPreferences(if (isPublic) SHAPRE_PUBLIC else SHAPE_PRIVATE, Context.MODE_PRIVATE)
        val editor = sp.edit()
        when (any) {
            is String -> {
                editor.putString(key, any)
            }
            is Int -> {
                editor.putInt(key, any)
            }
            is Boolean -> {
                editor.putBoolean(key, any)
            }
            is Float -> {
                editor.putFloat(key, any)
            }
            is Long -> {
                editor.putLong(key, any)
            }
            else -> {
                editor.putString(key, any.toString())
            }
        }
        SharedPreferencesCompat.apply(editor)
    }

    fun get(context: Context, key: String, defaultAny: Any): Any?{
        return get(context, key, defaultAny, true)
    }

    fun get(context: Context, key: String, defaultAny: Any, isPublic: Boolean): Any?{
        val sp = context.getSharedPreferences(if (isPublic) SHAPRE_PUBLIC else SHAPE_PRIVATE, Context.MODE_PRIVATE)
        when(defaultAny){
            is String -> {
                return sp.getString(key, defaultAny)
            }
            is Int -> {
                return sp.getInt(key, defaultAny)
            }
            is Boolean -> {
                return sp.getBoolean(key, defaultAny)
            }
            is Float -> {
                return sp.getFloat(key, defaultAny)
            }
            is Long -> {
                return sp.getLong(key, defaultAny)
            }
            else -> {
                return null
            }
        }
    }

    fun clearPrivate(context: Context) {
        val sp = context.getSharedPreferences(SHAPE_PRIVATE, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.clear()
        SharedPreferencesCompat.apply(editor)
    }

    object SharedPreferencesCompat {

        private val sApplyMethod: Method? = findApplyMethod()

        private fun findApplyMethod(): Method?{
            try {
                val clz = SharedPreferences.Editor::class.java
                return clz.getMethod("apply")
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
            }
            return null
        }

        fun apply(editor: SharedPreferences.Editor){
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor)
                    return
                }
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InvocationTargetException) {
                e.printStackTrace()
            }
            editor.commit()
        }
    }
}