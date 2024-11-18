package com.example.intentnew;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn;

    RadioButton r1;

    RadioGroup rg;
    SharedPreferences sp;
    EditText name,phone,email,pswdr;

    CheckBox  cb;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.b1);
        name = findViewById(R.id.na);
        phone = findViewById(R.id.ph);
        email = findViewById(R.id.em);
        rg = findViewById(R.id.rg);
        pswdr=findViewById(R.id.pswdr);
//        r1=findViewById(rg.getCheckedRadioButtonId());
//        r2=findViewById(R.id.r2);

        cb = findViewById(R.id.cb);


        sp = getSharedPreferences("file", 0);
        editor = sp.edit();
        Intent intent = new Intent(this, MainActivity2.class);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cb.isChecked()) {
                        startActivity(intent);
                        String na = name.getText().toString();
                        String ph = phone.getText().toString();
                        String em = email.getText().toString();
                        String pw=pswdr.getText().toString();
                        editor.putString("name", na);
                        editor.commit();
                        editor.putString("phone", ph);
                        editor.commit();
                        editor.putString("email", em);
                        editor.commit();
                        editor.putString("pswdr",pw);
                        editor.commit();
                        int selectid = rg.getCheckedRadioButtonId();
//                    Log.d("RadioGroup", "Selected RadioButton ID: " + selectid);

                        if (selectid == -1) {
                            editor.remove("gender");
                            editor.apply();
                            Toast.makeText(getApplicationContext(), "nothing selected", Toast.LENGTH_SHORT).show();
                        } else {
                            r1 = findViewById(selectid);
                            String radio = r1.getText().toString();
                            editor.putString("gender", radio);
                            editor.apply();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "tick on checkbox", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
}
*********************************************************************************************************************************************************************************************************************
package com.example.intentnew;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView name,phone,email,gender;
    SharedPreferences sp;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        name=findViewById(R.id.names);
        phone=findViewById(R.id.names2);
        email=findViewById(R.id.names3);
        gender=findViewById(R.id.names4);
        btn=findViewById(R.id.btn);
        Intent intent=new Intent(this, MainActivity3.class);
        sp=getSharedPreferences("file",0);
        String na=sp.getString("name","");
        String ph=sp.getString("phone", " ");
        String em=sp.getString("email", " ");
        String ge=sp.getString("gender","");
        name.setText(na);
        phone.setText(ph);
        email.setText(em);
        gender.setText(ge);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
