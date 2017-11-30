package com.example.priya.userpermissioncamera;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;



import com.example.priya.userpermissioncamera.CameraPreviewFragment;


public class MainActivity extends AppCompatActivity
        implements ActivityCompat.OnRequestPermissionsResultCallback {

    public static final String TAG = "MainActivity";


    //Id to identify a camera permission request.
    private static final int REQUEST_CAMERA = 0;


    //Root of the layout of this Activity.
    private View mLayout;

    /*Called when the 'show camera' button is clicked.
      Callback is defined in resource layout definition.*/

    public void showCamera(View view) {

        Log.i(TAG, "Show camera button pressed. Checking permission.");

        // BEGIN_INCLUDE(camera_permission)

        // Check if the Camera permission is already available.

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

                != PackageManager.PERMISSION_GRANTED) {

            // Camera permission has not been granted.
            requestCameraPermission();

        } else {

            // Camera permissions is already available, show the camera preview.

            Log.i(TAG, "CAMERA permission has already been granted. Displaying camera preview.");

            //showCameraPreview();

        }

        // END_INCLUDE(camera_permission)
    }
        /* Requests the Camera permission.
         //If the permission has been denied previously, a SnackBar will prompt the user to grant the
         //permission, otherwise it is requested directly.*/

    private void requestCameraPermission() {

        Log.i(TAG, "CAMERA permission has NOT been granted. Requesting permission.");

        // BEGIN_INCLUDE(camera_permission_request)

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {

            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // For example if the user has previously denied the permission.

            Log.i(TAG, "Displaying camera permission rationale to provide additional context.");

            Snackbar.make(mLayout, R.string.permission_camera_rationale,

                    Snackbar.LENGTH_INDEFINITE)

                    .setAction(R.string.ok, new View.OnClickListener() {

                        @Override

                        public void onClick(View view) {

                            ActivityCompat.requestPermissions(MainActivity.this,

                                    new String[]{Manifest.permission.CAMERA},

                                    REQUEST_CAMERA);

                        }

                    }).show();

        } else {

            // Camera permission has not been granted yet. Request it directly.

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},

                    REQUEST_CAMERA);

        }

        // END_INCLUDE(camera_permission_request)

    }
}




