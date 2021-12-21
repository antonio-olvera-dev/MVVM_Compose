package com.toni.mvvm_compose.ui.home.controler

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.toni.mvvm_compose.data.article.models.ArticleGetRequest
import com.toni.mvvm_compose.ui.home.viewModel.HomeViewModel

class HomeController {

    var pressBtnStart: Boolean = false

    @RequiresApi(Build.VERSION_CODES.N)
    fun getDatePickerDialog(
        ctx: Context,
        articleParametersGet: ArticleGetRequest,
    ): DatePickerDialog {

        val datePickerDialog: DatePickerDialog = DatePickerDialog(ctx)
        val arrayDate: List<String> = articleParametersGet.startDate.split("-")

        datePickerDialog.updateDate(arrayDate[0].toInt(),
            arrayDate[1].toInt(),
            arrayDate[2].toInt())

        return datePickerDialog
    }

    fun getBuildDate(year: String, month: Int, dayOfMonth: String): String {

        val monthFix: String = "${(month + 1)}"
        var newDate: String = "$year-"

        newDate += if (monthFix.length > 1) "$monthFix-" else "0$monthFix-"
        newDate += if (dayOfMonth.length > 1) dayOfMonth else "0$dayOfMonth"

        return newDate
    }


    @RequiresApi(Build.VERSION_CODES.N)
    fun launchDateListener(
        calendar: DatePickerDialog,
        homeViewModel: HomeViewModel
    ) {
        calendar.setOnDateSetListener(DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            val date: String = getBuildDate(year.toString(), month, dayOfMonth.toString())

            if (pressBtnStart) {
                homeViewModel.setArticleGetRequest(startDate = date)
            } else {
                homeViewModel.setArticleGetRequest(endDate = date)
            }
        })
    }

    fun showCalendar(  calendar: DatePickerDialog, startDate:Boolean = false){
        pressBtnStart = startDate
        calendar.show()
    }

}