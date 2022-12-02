package com.example.anew;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ProfileFragment extends Fragment {

    private static final int RESULT_OK = 101;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    ImageView profileimage;
    Button Camera;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        firebaseDatabase = FirebaseDatabase.getInstance("https://new-project-b58ac-default-rtdb.firebaseio.com/");
        profileimage = v.findViewById(R.id.imageProfile);
        Camera = v.findViewById(R.id.cameraBtn);

        Camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!checkCameraPermission()) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                                    Manifest.permission.CAMERA,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                    Manifest.permission.READ_EXTERNAL_STORAGE}
                            , 1


                    );
                } else {
                    takeImage();
                }
            }
        });


        return v;
    }

    public boolean checkCameraPermission() {
        int result = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA);
        int result1 = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int result2 = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);

        return result == PackageManager.PERMISSION_GRANTED &&
                result1 == PackageManager.PERMISSION_GRANTED &&
                result2 == PackageManager.PERMISSION_GRANTED;

    }

    void takeImage() {
    return;
    }


    }
//Camera previous code
//    private static final int TAKE_PHOTO_CODE = 1888;
//    Button button;
//    private Uri fileUri1,fileUri;
//    ImageView imageView;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        final View rootView = inflater.inflate(R.layout.fragment_profile,
//                container, false);
//
//        button = (Button) rootView.findViewById(R.id.button);
//        imageView = (ImageView) rootView.findViewById(R.id.imageProfile);
//
//        button.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                fileUri1 = getOutputMediaFileUri();
//                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
//                startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
//
//            }
//        });
//
//        return rootView;
//
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == TAKE_PHOTO_CODE) {
//            if (resultCode == Activity.RESULT_OK) {
//
//                BitmapFactory.Options options;
//
//
//                try {
//                    Bitmap bitmap = BitmapFactory.decodeFile(pathname);
//                    showDialog(bitmap, 1);
//                } catch (OutOfMemoryError e) {
//                    try {
//                        options = new BitmapFactory.Options();
//                        options.inSampleSize = 2;
//                        Bitmap bitmap = BitmapFactory.decodeFile(pathname, options);
//                        imageView.setImageBitmap(bitmap);
//                    } catch (Exception e2) {
//                        Log.e("Camera", "" + e2 + "    " + e);
//                    }
//                }
//            }
//        }
//    }    }
//
//    public Uri getOutputMediaFileUri() {
//        return Uri.fromFile(getOutputMediaFile());
//    }
//
//    private static File getOutputMediaFile() {
//
//        File mediaStorageDir = new File(
//                Environment
//                        .getExternalStoragePublicDirectory(MyApplication.getAppContext().getFilesDir().getAbsolutePath()),
//                IMAGE_DIRECTORY_NAME);
//
//        if (!mediaStorageDir.exists()) {
//            if (!mediaStorageDir.mkdirs()) {
//                Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
//                        + IMAGE_DIRECTORY_NAME + " directory");
//                return null;
//            }
//        }
//        // Create a media file name
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
//                Locale.getDefault()).format(new Date());
//        File mediaFile;
//
//        try {
//            mediaFile = File.createTempFile(
//                    "IMG_" + timeStamp,
//                    ".jpg",
//                    mediaStorageDir
//            );
//        } catch (Exception e) {
//            Log.e("Camera", "" + e);
//            mediaFile = new File(mediaStorageDir.getPath() + File.separator
//                    , "IMG_" + timeStamp + ".jpg");
//        }
//        return mediaFile;
//    }
//
//}


//    old code





