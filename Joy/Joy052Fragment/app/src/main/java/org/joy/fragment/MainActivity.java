package org.joy.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelectable {
    ListFragment listFragment;
    ViewFragment viewFragment;
    int[] images = {R.drawable.alexhonnold1, R.drawable.alexhonnold2, R.drawable.alexhonnold3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        listFragment = (ListFragment) manager.findFragmentById(R.id.listfragment);
        viewFragment = (ViewFragment) manager.findFragmentById(R.id.viewfragment);
    }

    @Override
    public void onImageSelected(int position) {
        viewFragment.setImage(images[position]);
    }
}