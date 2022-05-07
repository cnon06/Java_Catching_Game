package com.cnon.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView scoreText, timeText;
    ImageView img00,img01,img02,img03,img10,img11,img12,img13,img20,img21,img22,img23,
            img30,img31,img32,img33,img40,img41,img42,img43;
    ImageView [] imageArray;
    int score=0;
    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreText = findViewById(R.id.scoreText);
        timeText = findViewById(R.id.timeText);
        img00 = findViewById(R.id.imageView00);
        img01 = findViewById(R.id.imageView01);
        img02 = findViewById(R.id.imageView02);
        img03 = findViewById(R.id.imageView03);
        img10 = findViewById(R.id.imageView10);
        img11 = findViewById(R.id.imageView11);
        img12 = findViewById(R.id.imageView12);
        img13 = findViewById(R.id.imageView13);
        img20 = findViewById(R.id.imageView20);
        img21 = findViewById(R.id.imageView21);
        img22 = findViewById(R.id.imageView22);
        img23 = findViewById(R.id.imageView23);
        img30 = findViewById(R.id.imageView30);
        img31 = findViewById(R.id.imageView31);
        img32 = findViewById(R.id.imageView32);
        img33 = findViewById(R.id.imageView33);
        img40 = findViewById(R.id.imageView40);
        img41 = findViewById(R.id.imageView41);
        img42 = findViewById(R.id.imageView42);
        img43 = findViewById(R.id.imageView43);


       imageArray = new  ImageView []{img00,img01,img02,img03,img10,img11,img12,img13,img20,img21,img22,img23,
                img30,img31,img32,img33,img40,img41,img42,img43};

       hide_img();





    new CountDownTimer(30000,1000)
    {

        @Override
        public void onTick(long l) {




            timeText.setText("Time: "+l/1000);
        }

        @Override
        public void onFinish() {
            handler.removeCallbacks(runnable);
            for(ImageView img : imageArray) img.setVisibility(View.INVISIBLE);
            alert_dialog();
        }
    }.start();


    }

    public void alert_dialog()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);


        alert.setTitle("Game Over");
        alert.setMessage("Restart game?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                //  Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               finish();
                // Toast.makeText(MainActivity.this, "Not Saved", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }


    public void hide_img()
    {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {


                //int random =(int)(Math.random()*(imageArray.length-1));
                Random random = new Random();
                int random1 = random.nextInt(imageArray.length);
                for(ImageView img : imageArray) img.setVisibility(View.INVISIBLE);
                imageArray[random1].setVisibility(View.VISIBLE);
                //int random1 =(int)(Math.random()*(imageArray.length-1));



                /*
                   for(int i =0;i<imageArray.length;i++)
                {
                    if(i==random1) imageArray[i].setVisibility(View.VISIBLE);
                    else imageArray[i].setVisibility(View.INVISIBLE);
                }
                 */



              //  i++;
               // text.setText(i+"");
                //  Log.e("Output: ",i+"");
                handler.postDelayed(runnable,500);

            }
        };

        handler.post(runnable);
    }

    public void increaseScore(View view)
    {
            score++;
        scoreText.setText("Score: "+score);

    }



}