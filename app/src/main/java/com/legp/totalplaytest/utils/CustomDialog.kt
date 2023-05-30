package com.legp.totalplaytest.utils

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import com.legp.totalplaytest.R

object AlertsLoading {
    lateinit var dialog: Dialog

    fun showDialogLoading(context: Activity) {
        dialog = Dialog(context)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.alert_loading)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val displayMetrics = context.resources.displayMetrics
        val dialogWidth = (displayMetrics.widthPixels * 0.90).toInt()
        val dialogHeight = (displayMetrics.heightPixels * 0.70).toInt()

        dialog.window!!.setLayout(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )

        dialog.show()
    }

    fun hidenDialogLoading(context: Activity) {

        if (::dialog.isInitialized) {
            dialog.dismiss()
        }
    }

}


object AlertsMessage {
    lateinit var dialog: Dialog

    fun showError(context: Activity, message: String) {

        AlertDialog.Builder(context)
            .setTitle(context.getString(R.string.app_name))
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton("Ok",
                DialogInterface.OnClickListener { dialog, which ->
                    // Continue with delete operation
                    dialog.dismiss()

                })
            .setIcon(R.drawable.ic_launcher_foreground)
            .show()
    }

}