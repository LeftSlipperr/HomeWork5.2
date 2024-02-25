package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
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

        // Находим кнопки по их ID
        Button btn = findViewById(R.id.btn);
        Button btn2 = findViewById(R.id.btn2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCounterAndSetText();
            }
        });
    }

    private void updateTextView() {
        TextView tv1 = findViewById(R.id.textView1);
        i++;
        tv1.setText(Integer.toString(i));
    }

    private void resetCounterAndSetText() {
        EditText et1 = findViewById(R.id.editTextText);
        TextView tv1 = findViewById(R.id.textView2);
        tv1.setText("Привет " + et1.getText());
    }
}
