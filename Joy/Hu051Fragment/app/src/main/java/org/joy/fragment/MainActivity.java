package org.joy.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /****
        mainFragment = (MainFragment) getSupportFragmentManager().
                findFragmentById(R.id.mainfragment);
        menuFragment = new MenuFragment();
         ****/

        mainFragment = new MainFragment();
        menuFragment = new MenuFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container, mainFragment).commit();
    }

    public void onFragmentChanged(int index) {
        if (index == 1) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.container, mainFragment).commit();
        } else if (index == 0) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.container, menuFragment).commit();
        }
    }
}