package edu.asm.quanlythuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.imageView);
        Glide.with(this).load(R.mipmap.book).into(imageView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity2.this,LoginActivity.class));
                finish();
            }
        },2500);
    }
}