package com.example.tourismapp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class PlaceFragment extends Fragment {

    private static final String TITLE="TITLE";
    private static final String DESCRIPTION="DESCRIPTION";
    private static final String IMAGE="IMAGE";

    private String mTitle;
    private String mDescription;
    private Integer mImageView;

    TextView title;
    TextView description;
    ImageView iv;

    public PlaceFragment() {
        // Required empty public constructor
    }

    public static com.example.tourismapp2.PlaceFragment newInstance(Integer mImageView, String mTitle, String mDescription) {
        com.example.tourismapp2.PlaceFragment fragment = new com.example.tourismapp2.PlaceFragment();
        Bundle args = new Bundle();
        args.putString(TITLE,mTitle);
        args.putString(DESCRIPTION,mDescription);
        args.putInt(IMAGE,mImageView);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mImageView=getArguments().getInt(IMAGE);
            mTitle=getArguments().getString(TITLE);
            mDescription=getArguments().getString(DESCRIPTION);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_place, container, false);
        title=view.findViewById(R.id.title);
        description=view.findViewById(R.id.description);
        iv=view.findViewById(R.id.iv);

        title.setText(mTitle);
        description.setText(mDescription);
        iv.setImageResource(mImageView);
        return view;
    }
}