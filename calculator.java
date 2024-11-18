package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    EditText num1,num2;
    TextView result;
    Button add,sub,mul,div,next,prev;


    private Double n1,n2,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        num1=(EditText) findViewById(R.id.num1);
        num2=(EditText) findViewById(R.id.num2);
        result=(TextView) findViewById(R.id.result);
        add=(Button) findViewById(R.id.add);
        sub=(Button) findViewById(R.id.sub);
        mul=(Button) findViewById(R.id.mul);
        div=(Button) findViewById(R.id.div);
        next=(Button) findViewById(R.id.next);
        prev=(Button) findViewById(R.id.prev);
        Intent intent=new Intent(this, MainActivity.class);
        Intent intent1=new Intent(this, MainActivity3.class);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View s) {
                n1=Double.parseDouble(num1.getText().toString());
                n2=Double.parseDouble(num2.getText().toString());
                r=n1+n2;
                result.setText(String.valueOf(r));

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View s) {
                n1=Double.parseDouble(num1.getText().toString());
                n2=Double.parseDouble(num2.getText().toString());
                r=n1-n2;
                //are you fine//
                result.setText(r.toString());


            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View s) {
                n1=Double.parseDouble(num1.getText().toString());
                n2=Double.parseDouble(num2.getText().toString());
                r=n1*n2;
                result.setText(r.toString());

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View s) {
                n1=Double.parseDouble(num1.getText().toString());
                n2=Double.parseDouble(num2.getText().toString());
                r=n1/n2;
                result.setText(r.toString());
                num1.setText("");
                num2.setText("");
            }
        });
    prev.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View s) {
            startActivity(intent);
        }
    });
    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View s) {
            startActivity(intent1);
        }
    });

    }
}
