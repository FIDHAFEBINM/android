package com.example.intentlist;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button bt;

    EditText text;

    ListView lv;

    ArrayList<Integer> list;

//    String[] arr=new String[]{};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv);
        text=findViewById(R.id.text);
        TextView ans=findViewById(R.id.ans);
        bt=findViewById(R.id.bt);
        list= new ArrayList<>();
        ArrayAdapter<Integer> arr= new ArrayAdapter<Integer>(this,R.layout.itemview,R.id.tv,list);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int name=Integer.parseInt(text.getText().toString());
                list.add(name);
                lv.setAdapter(arr);
                text.setText("");
                int sum = 0;
                for (int num : list) {
                    sum += num;
                }

                // Display the sum in the TextView
                ans.setText("Sum: " + sum);



            }
        });
    }
}
