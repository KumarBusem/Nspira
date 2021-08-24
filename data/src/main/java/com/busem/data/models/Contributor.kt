package com.busem.data.models

import com.google.gson.annotations.SerializedName
import kotlin.String

data class Contributor(
    @SerializedName(ID) val id: Int,
    @SerializedName(LOGIN) val loginName: String?,
    @SerializedName(AVATAR_IMAGE) val profilePicUrl: String?,
    @SerializedName(URL) val link: String?
) {
    companion object {
        const val ID = "id"
        const val LOGIN = "login"
        const val AVATAR_IMAGE = "avatar_url"
        const val URL = "html_url"
    }
}