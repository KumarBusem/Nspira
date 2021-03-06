package com.busem.data.common

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import com.busem.data.local.roomDatabase.RoomProvider
import com.busem.data.local.sharedPrefs.SharedPreferencesHelper
import com.busem.data.remote.NetworkClient


internal class ContextProvider : ContentProvider() {

    override fun onCreate(): Boolean {

        context?.let { context ->

            SharedPreferencesHelper.initialize(context)
            RoomProvider.initialize(context)
            NetworkClient.initialize()

            return true
        }
        return false
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        return null
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        return 0
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun getType(uri: Uri): String? {
        return null
    }
}