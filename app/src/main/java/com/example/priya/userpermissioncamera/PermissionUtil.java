package com.example.priya.userpermissioncamera;

/**
 * Created by Priya on 11/28/2017.
 */

import android.app.Activity;

import android.content.pm.PackageManager;





 //Utility class that wraps access to the runtime permissions API in M and provides basic helper methods.

 

public abstract class PermissionUtil {




    public static boolean verifyPermissions(int[] grantResults) {

        // At least one result must be checked.

        if (grantResults.length < 1) {

            return false;

        }



        // Verify that each required permission has been granted, otherwise return false.

        for (int result : grantResults) {

            if (result != PackageManager.PERMISSION_GRANTED) {

                return false;

            }

        }

        return true;

    }



}
