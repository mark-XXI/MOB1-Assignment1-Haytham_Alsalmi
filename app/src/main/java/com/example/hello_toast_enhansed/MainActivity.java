package com.example.hello_toast_enhansed;

import android.os.Bundle;
import android.graphics.Color;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hello_toast_enhansed.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    public static ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        // Initial button colors
        mainBinding.buttonCount.setBackgroundTintList(
                ColorStateList.valueOf(Color.BLUE)
        );

        mainBinding.buttonZero.setBackgroundTintList(
                ColorStateList.valueOf(Color.GRAY)
        );
    }

    // Show Toast message
    public void show_toast(View view) {

        Toast.makeText(
                this,
                "Hello Toast",
                Toast.LENGTH_SHORT
        ).show();
    }

    // Increase count
    public void increase_count(View view) {

        count++;

        mainBinding.textDisplayCount.setText(
                String.valueOf(count)
        );

        // Change Count button color
        if (count % 2 == 1) {

            mainBinding.buttonCount.setBackgroundTintList(
                    ColorStateList.valueOf(Color.GREEN)
            );

        } else {

            mainBinding.buttonCount.setBackgroundTintList(
                    ColorStateList.valueOf(Color.BLUE)
            );
        }

        // Change Zero button color
        mainBinding.buttonZero.setBackgroundTintList(
                ColorStateList.valueOf(Color.rgb(255, 152, 0))
        );
    }

    // Reset count to zero
    public void show_zero(View view) {

        count = 0;

        mainBinding.textDisplayCount.setText(
                String.valueOf(count)
        );

        // Reset Zero button color to gray
        mainBinding.buttonZero.setBackgroundTintList(
                ColorStateList.valueOf(Color.GRAY)
        );

        // Reset Count button color to blue
        mainBinding.buttonCount.setBackgroundTintList(
                ColorStateList.valueOf(Color.BLUE)
        );
    }
}
