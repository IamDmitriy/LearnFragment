package com.example.learnfragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MyFragment extends Fragment {
    public static final String TAG = "MyFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_fragment,container,false);

        Button myButton = view.findViewById(R.id.my_button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Такой вариант не работает
                //Intent intent = new Intent(this, ActionBarFragment.class);

                ActionBarFragment actionBarFragment = new ActionBarFragment();

                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("m")
                        .add(R.id.container, actionBarFragment).commit();
            }
        });



        return view;
    }

    void showToast() {
        Toast.makeText(getContext(), "ткунли кнопочку", Toast.LENGTH_SHORT).show();
    }
}
