package com.example.zvonimir.gcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText num1;
    private EditText num2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.editText);
        num2 = (EditText) findViewById(R.id.editText2);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        num1.setText("");
        num2.setText("");
    }

    public void onClick(View v) {
        boolean a = TextUtils.isEmpty(num1.getText());
        boolean b = TextUtils.isEmpty(num2.getText());

        if (!a & !b) {
            int firstNumber = Integer.parseInt(num1.getText().toString());
            int secondNumber = Integer.parseInt(num2.getText().toString());

            Intent intent = new Intent(this, Calculate.class);
            Bundle bundle = new Bundle();
            bundle.putInt("num1", firstNumber);
            bundle.putInt("num2", secondNumber);
            intent.putExtra("gcfdata", bundle);
            startActivity(intent);
        }
    }
}
