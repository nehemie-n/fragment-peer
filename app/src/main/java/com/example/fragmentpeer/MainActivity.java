package com.example.fragmentpeer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements  Fragment1.FragmentAListener{

    private Fragment1 fragmentA;
    private Fragment2 fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new Fragment1();
        fragmentB = new Fragment2();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_1, fragmentA)
                .addToBackStack("container_1")
                .replace(R.id.container_2, fragmentB)
                .addToBackStack("container_2")
                .commit();
    }

    @Override
    public void onInputASent(CharSequence input) {
        fragmentB.updateEditText(input);
    }


    public void sendToChild(View view){
        fragmentB.updateEditText("Sent Data From Parent");
    }

    public void removeLastFragment(View view){
        getFragmentManager().popBackStack();
//        hide
    }
}
