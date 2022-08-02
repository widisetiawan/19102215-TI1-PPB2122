package com.widi_19102215.praktikum14.`interface`

import com.widi_19102215.praktikum14.model.Login
import com.widi_19102215.praktikum14.model.Quote

interface MainView {
    fun showMessage(messsage : String)
    fun resultQuote(data: ArrayList<Quote>)
    fun resultLogin(data: Login)
}