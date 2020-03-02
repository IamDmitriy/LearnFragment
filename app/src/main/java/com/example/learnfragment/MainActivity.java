package com.example.learnfragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        MyFragment myFragment = new MyFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, myFragment, "m").commit();


        //Вот так я могу заменить стандарнтый actionbar полностью кастомным
        //Осталось только дать понять активности, что создан нужный фрагмент
        Toolbar myFragmentToolBar = findViewById(R.id.myFragmentToolBar);
        Toolbar myMainToolBar = findViewById(R.id.myMainToolBar);
        myMainToolBar.setVisibility(View.GONE);
        setSupportActionBar(myFragmentToolBar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
