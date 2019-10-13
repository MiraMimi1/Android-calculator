package com.alger1.l3.tp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

public class Homeact extends AppCompatActivity {

    private static int time_out=2000;
    private TextView txtv,txtvv;
    private ImageView imgv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeact);
        txtv=(TextView)findViewById(R.id.txtv);
        txtvv=(TextView)findViewById(R.id.txtvv);
        imgv=(ImageView)findViewById(R.id.imgv);

            //change the fonts its ugly
        Typeface ft=Typeface.createFromAsset(getAssets(),"fonts/digital.ttf");
        txtv.setTypeface(ft);
        Animation an= AnimationUtils.loadAnimation(this,R.anim.myanimm);
        txtv.startAnimation(an);
        txtvv.startAnimation(an);
        imgv.startAnimation(an);

            //tomporaly thread pour l'intro
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent Homeint =new Intent(Homeact.this,MainActivity.class);
                startActivity(Homeint);
                finish();
            }
        },time_out);

    }
}
