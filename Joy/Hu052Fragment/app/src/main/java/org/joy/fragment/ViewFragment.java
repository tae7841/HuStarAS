package org.joy.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewFragment extends Fragment {
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_view, container, false);

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_view, container, false);

        imageView = rootView.findViewById(R.id.imageView);
        return rootView;
    }

    public void setImage(int index) {
        imageView.setImageResource(index);
    }
}