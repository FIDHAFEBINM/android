package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
//     Button bt;
//     EditText user,pswdr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button bt=(Button) findViewById(R.id.bt);
        EditText user=(EditText) findViewById(R.id.user);
        EditText pswdr=(EditText) findViewById(R.id.pswdr);
        Intent intent=new Intent(this,MainActivity2.class);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( user.getText().toString().equals("admin") && pswdr.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(),"redirecting",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"wrong credential",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
