package com.example.montymath;

import static android.app.Activity.RESULT_OK;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ShowAllUserFragment extends Fragment {
    private EditText edit_user_name;
    private TextView tv;
    private TextView tv2;
    private Button bt;
    private ImageView img;
    private Button btn;
    ModelView vm1;
    Uri uri;


    ActivityResultLauncher<Intent> startCamera = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==RESULT_OK) {
                        img.setImageURI(uri);
                    }




                }
            }
    );


    @Nullable


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view1 = inflater.inflate(R.layout.fragment_showusers,container,false);
        initView(view1);
        vm1 = new ViewModelProvider(requireActivity()).get(ModelView.class);
        String name = vm1.vName.getValue();
        Integer score = vm1.vScore.getValue();
        Integer rate = vm1.vRete.getValue();

        edit_user_name.setText(name+"");

        tv2.setText(score+"");

        tv.setText(rate+"");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE,"New Picture");
                values.put(MediaStore.Images.Media.DESCRIPTION,"From Camera");
                uri = requireContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                startCamera.launch(cameraIntent);
            }
        });
        return view1 ;
    }

    private void initView(View view) {
        edit_user_name = view.findViewById(R.id.edit_user_name);
        tv = view.findViewById(R.id.edit_rate);
        tv2 = view.findViewById(R.id.show_score);
        bt = view.findViewById(R.id.add_picture_button);
        img = view.findViewById(R.id.picture);
        btn = view.findViewById(R.id.add_user_button);

    }
}
