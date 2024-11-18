package com.example.toggle;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    ImageView images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        toggleButton=findViewById(R.id.toggleButton);
        images=findViewById(R.id.images);
        images.setImageDrawable(getResources().getDrawable(R.drawable.fourmp));

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton.isChecked()){
                    images.setImageDrawable(getResources().getDrawable(R.drawable.threemp));
                }
                else{
                    images.setImageDrawable(getResources().getDrawable(R.drawable.fourmp));
                }
            }
        });

    }
}
