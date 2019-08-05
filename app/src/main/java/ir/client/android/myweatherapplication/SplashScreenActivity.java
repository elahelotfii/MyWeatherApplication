package ir.client.android.myweatherapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.cunoraz.gifview.library.GifView;

public class SplashScreenActivity extends AppCompatActivity {
    private MediaPlayer splashSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashSound = MediaPlayer.create(this,R.raw.stbassdrumloop);
        splashSound.start();

        //GifView gifView1 = (GifView) findViewById(R.id.gif1);
        //gifView1.setVisibility(View.VISIBLE);
        //gifView1.play();
        //gifView1.setGifResource(R.mipmap.weathertest4);
        //gifView1.getGifResource();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 7000);
    }
}
