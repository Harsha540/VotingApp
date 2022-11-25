package com.example.anew;


import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

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


//    TODO: Rename parameter arguments, choose names that match
//    the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

//     TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    //TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }


}

