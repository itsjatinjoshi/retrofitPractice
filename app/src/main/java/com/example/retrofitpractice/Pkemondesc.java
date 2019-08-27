package com.example.retrofitpractice;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.util.Property;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class Pkemondesc extends AppCompatActivity {
    ImageView img_poke;
    TextView txt_name, txt_type, txt_ability, txt_h, txt_w, txt_desc;
    Toolbar mActionBarToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pkemondesc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        img_poke = findViewById(R.id.desc_img);
        txt_name = findViewById(R.id.txt_name);
        txt_type = findViewById(R.id.txt_type);
        txt_ability = findViewById(R.id.txt_ability);
        txt_h = findViewById(R.id.txt_height);
        txt_w = findViewById(R.id.txt_weight);
        txt_desc = findViewById(R.id.txt_desc);

        String uName = getIntent().getExtras().getString("name");
        String uImage = getIntent().getExtras().getString("image");
        String uType = getIntent().getExtras().getString("type");
        String uAbility = getIntent().getExtras().getString("ability");
        String uHeight = getIntent().getExtras().getString("height");
        String uWeight = getIntent().getExtras().getString("weight");
        String uDescription = getIntent().getExtras().getString("description");


        txt_name.setText(uName);
        // Linkify.addLinks(txt_name, Linkify.WEB_URLS);
        Glide.with(this).load(uImage).placeholder(R.drawable.desc_img).into(img_poke);

        txt_type.setText(uType);
        txt_ability.setText(uAbility);
        txt_h.setText(uHeight);
        txt_w.setText(uWeight);
        txt_desc.setText(uDescription);
        txt_desc.setMovementMethod(new ScrollingMovementMethod());

        getSupportActionBar().setTitle("Pokemon Details");

    }



}
