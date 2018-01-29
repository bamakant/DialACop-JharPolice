package com.kiusoftech.dialacop_jharpolice.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.kiusoftech.dialacop_jharpolice.R;

/**
 * Created by bamakant on 26/1/18.
 */

public class AlertDialogManager {
    /**
     * Function to display simple Alert Dialog
     * @param context - application context
     * @param title - alert dialog title
     * @param message - alert message
     * @param status - success/failure (used to set icon)
     *               - pass null if you don't want icon
     * */

    private Context mContext;

    public AlertDialogManager() {
    }

    public void showAlertDialog(final Context context, String title, String message,
                                Boolean status) {
        mContext = context;

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        if(status != null)
            // Setting alert dialog icon
            alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

     /*   // Setting OK Button
       alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int which) {
               Log.d(TAG, "onClick:");
           }
       });*/

       alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {

           }
       });
        // Showing Alert Message
        alertDialog.show();
    }
}
