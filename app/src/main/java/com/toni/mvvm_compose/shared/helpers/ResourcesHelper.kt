package com.toni.mvvm_compose.shared.helpers

import android.content.Context
import com.toni.mvvm_compose.R

class ResourcesHelper(val ctx: Context) {

    fun getString(id:Int):String{
        return ctx.resources.getString(id)
    }

}