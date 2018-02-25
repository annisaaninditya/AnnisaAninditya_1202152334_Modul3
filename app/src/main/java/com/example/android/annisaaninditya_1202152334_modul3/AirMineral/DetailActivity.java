package com.example.android.annisaaninditya_1202152334_modul3.AirMineral;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private  int liter = 1;
    private ImageView v;
    private TextView LiterAir;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initialize the views
        TextView airJudul = (TextView)findViewById(R.id.judul_detail);
        ImageView airGambar = (ImageView)findViewById(R.id.gambar_detail);
        v = (ImageView) findViewById(R.id.botol_air);
        LiterAir = (TextView)findViewById(R.id.liter);

        //Get the drawable
        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(Air.IMAGE_KEY, 0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Make it the same size as the image
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        //Set the text from the Intent extra
        airJudul.setText(getIntent().getStringExtra(Air.TITLE_KEY));

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra(Air.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(airGambar);


    }

    public void kurang(View view) {
        liter--;
        if(liter<1){
            liter=1;
        }
        v.setImageLevel(liter);
        LiterAir.setText(liter+"L");
        if (liter<5){
            Toast.makeText(this, "Air  Sedikit", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Air Penuh", Toast.LENGTH_SHORT).show();
        }

    }
    public void tambah(View view) {
        liter++;
        if(liter>5){
            liter=5;
        }
        v.setImageLevel(liter);
        LiterAir.setText(liter+"L");
        if (liter<5){
            Toast.makeText(this, "Air  Sedikit", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Air Penuh", Toast.LENGTH_SHORT).show();
        }

    }
}

