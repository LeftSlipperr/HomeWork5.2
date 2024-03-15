package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Находим кнопки по их ID
        Button btn = findViewById(R.id.btn);
        Button btn2 = findViewById(R.id.btn2);

        EditText et1 = findViewById(R.id.editTextText);
        TextView tv2 = findViewById(R.id.textView2);
        TextView tv1 = findViewById(R.id.textView1);
        //tv2.setText("Привет " + viewModel.name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                tv1.setText(Integer.toString(i));
                viewModel.name.postValue(tv1.getText().toString());
            }
        });

        viewModel.name.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv1.setText(viewModel.name.getValue());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.name.postValue(et1.getText().toString());
//                tv2.setText("Привет " + viewModel.name);
            }
        });

        viewModel.name.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv2.setText("Привет " + viewModel.name.getValue());
            }
        });

    }
}
