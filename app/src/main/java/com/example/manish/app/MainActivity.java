package com.example.manish.app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button rollButton;
    TextView rollResult;
    Random rand=new Random();
    ImageView image1,image2, image3;
    ArrayList<ImageView> imageViews=new ArrayList<>();
    EditText editText;
    int p=0;
    int flag=0;
    int score=0;
    ArrayList<Integer> randi= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollButton=(Button)findViewById(R.id.rollButton);
        rollResult=(TextView)findViewById(R.id.rollResult);
        image1 = (ImageView) findViewById(R.id.imageView2);
        image2 = (ImageView) findViewById(R.id.imageView3);
        image3 = (ImageView) findViewById(R.id.imageView4);
        imageViews.add(image1);
        imageViews.add(image2);
        imageViews.add(image3);
    }

    public void rollDice(View v) throws IOException {
            randi.clear();
            for(int i=0;i<3;i++) {
            int die1 = rand.nextInt(6) + 1;
            randi.add(die1);;
            String fileName = "die_"+randi.get(i)+ ".png";
            InputStream stream = getAssets().open(fileName);
            Drawable d = Drawable.createFromStream(stream, null);
            imageViews.get(i).setImageDrawable(d);
        }

        if(randi.get(0)==randi.get(1) && randi.get(1)==randi.get(2)){
            score+= randi.get(0)*100;
        }
        else if(randi.get(0)==randi.get(1) || randi.get(2)==randi.get(1) || randi.get(2)==randi.get(0)){
                score+=50;
        }
        rollResult.setText("You current score is: "+String.valueOf(score)+" !");
    }
}
