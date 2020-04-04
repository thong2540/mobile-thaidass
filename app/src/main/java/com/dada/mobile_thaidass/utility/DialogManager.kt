package com.dada.mobile_thaidass.utility

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.dada.mobile_thaidass.R


class DialogManager {

    var alertdialog: Dialog? = null

    private lateinit var dialogInterface: (Int) -> Unit

    fun setOnDialogSuccessListener(listener: (Int) -> Unit) {
        dialogInterface = listener
    }

    fun alertError(activity: Activity,message: String,checkButton: Boolean) {
        alertdialog = Dialog(activity)
        alertdialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        alertdialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog!!.setContentView(R.layout.dialog_alert_error)
        alertdialog!!.setCancelable(false)

        val textAlertConfirm = alertdialog!!.findViewById(R.id.textConfirm) as TextView
        val textAlertCancel = alertdialog!!.findViewById(R.id.textCancel) as TextView
        val alertContent = alertdialog!!.findViewById(R.id.alertContent) as TextView

        if (checkButton){
            textAlertCancel.visibility = View.GONE
            textAlertConfirm.text = "ตกลง"
        }

        alertContent.text = message

        textAlertConfirm.setOnClickListener {
            if (dialogInterface != null)
                dialogInterface.invoke(it.id)
            if (alertdialog != null)
                alertdialog!!.dismiss()
        }

        textAlertCancel.setOnClickListener {
            if (dialogInterface != null)
                dialogInterface.invoke(it.id)
            if (alertdialog != null)
                alertdialog!!.dismiss()
        }
        alertdialog!!.show()
    }

    fun alertShow(activity: Activity,image: Int) {
        alertdialog = Dialog(activity)
        alertdialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        alertdialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertdialog!!.setContentView(R.layout.dialog_alert)
        alertdialog!!.setCancelable(false)

        val imageViewShow = alertdialog!!.findViewById(R.id.imageViewShow) as ImageView
        val textAlertConfirm = alertdialog!!.findViewById(R.id.textAlertConfirm) as TextView

        imageViewShow.setImageDrawable(
            ContextCompat.getDrawable(
                activity,
                image
            )
        )

        textAlertConfirm.setOnClickListener {
            if (dialogInterface != null)
                dialogInterface.invoke(it.id)

            if (alertdialog != null)
                alertdialog!!.dismiss()
        }

        alertdialog!!.show()
    }

}