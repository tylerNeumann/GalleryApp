package fvtc.edu.galleryapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    public static final String TAG = "MainActivity";
    Character[] characters = {
            new Character("Amber", "flame archer"),
            new Character("Barbara", "water mage"),
            new Character("Bennett","flame swordsman"),
            new Character("Charlotte","ice mage"),
            new Character("Chonyun", "ice greatsword wielder"),
            new Character("Diona", "ice archer"),
            new Character("Freminet", "ice greatsword wielder"),
            new Character("Gaming", "flame greatsword wielder"),
            new Character("Gorou", "earth archer"),
            new Character("Jean", "wind swordswoman"),
            new Character("Kaeya", "ice swordsman"),
            new Character("Kirara","plant swordswoman"),
            new Character("Kujou Sara","lightning archer"),
            new Character("Lisa", "lightning mage"),
            new Character("Lynette", "wind swordswoman"),
            new Character("Mona", "water mage"),
            new Character("Ningguang", "earth mage"),
            new Character("Noelle", "earth greatsword wielder"),
            new Character("Player", "swordsman"),
            new Character("Razor", "lightning greatsword wielder"),
            new Character("Rosaria","ice spearwoman"),
            new Character("Tighnari","plant archer"),
            new Character("Xiangling", "flame spearwoman "),
            new Character("Xingqui", "water swordsman"),
            new Character("Xinyan", "flame greatsword wielder"),
    };
    int[] imgs ={
            R.drawable._amber,
            R.drawable._barbara,
            R.drawable._bennett,
            R.drawable._charlotte,
            R.drawable._chongyun,
            R.drawable._diona,
            R.drawable._freminet,
            R.drawable._gaming,
            R.drawable._gorou,
            R.drawable._jean,
            R.drawable._kaeya,
            R.drawable._kirara,
            R.drawable._kujou_sara,
            R.drawable._lisa,
            R.drawable._lynette,
            R.drawable._mona,
            R.drawable._ningguang,
            R.drawable._noelle,
            R.drawable._player,
            R.drawable._razor,
            R.drawable._rosaria,
            R.drawable._tighnari,
            R.drawable._xiangling,
            R.drawable._xingqiu,
            R.drawable._xinyan,
            R.drawable._amber_fb,
            R.drawable._barbara_fb,
            R.drawable._bennett_fb,
            R.drawable._charlotte_fb,
            R.drawable._chongyun_fb,
            R.drawable._diona_fb,
            R.drawable._freminet_fb,
            R.drawable._gaming_fb,
            R.drawable._gorou_fb,
            R.drawable._jean_fb,
            R.drawable._kaeya_fb,
            R.drawable._kirara_fb,
            R.drawable._kujou_sara_fb,
            R.drawable._lisa_fb,
            R.drawable._lynette_fb,
            R.drawable._mona_fb,
            R.drawable._ningguang_fb,
            R.drawable._noelle_fb,
            R.drawable._player_fb,
            R.drawable._razor_fb,
            R.drawable._rosaria_fb,
            R.drawable._tighnari_fb,
            R.drawable._xiangling_fb,
            R.drawable._xingqiu_fb,
            R.drawable._xinyan_fb,
    };
    int[] textFiles= {
            R.raw._amber,
            R.raw._barbara,
            R.raw._bennett,
            R.raw._charlotte,
            R.raw._chongyun,
            R.raw._diona,
            R.raw._freminet,
            R.raw._gaming,
            R.raw._gorou,
            R.raw._jean,
            R.raw._kaeya,
            R.raw._kirara,
            R.raw._kujou_sara,
            R.raw._lisa,
            R.raw._lynette,
            R.raw._mona,
            R.raw._ningguang,
            R.raw._noelle,
            R.raw._player,
            R.raw._razor,
            R.raw._rosaria,
            R.raw._tighnari,
            R.raw._xiangling,
            R.raw._xingqiu,
            R.raw._xinyan,
    };
    int cardNum = 0;
    boolean isFront = true;
    ImageView imgCard;
    TextView tvCard;
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imgCard = findViewById(R.id.imageView);
        tvCard = findViewById(R.id.tvInfo);
        tvCard.setMovementMethod(new ScrollingMovementMethod());
        tvCard.setText(characters[cardNum].getName());
        updateToNextCard();
        gestureDetector = new GestureDetector(this,this);
        Log.d(TAG, "onCreate: complete");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private class AnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Log.d(TAG, "onAnimationEnd: ");
            updateToNextCard();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
    private void updateToNextCard() {
        characters[cardNum].setDescription(readFile(textFiles[cardNum]));

        isFront = true;
        imgCard.setVisibility(View.VISIBLE);
        imgCard.setImageResource(imgs[cardNum]);
        tvCard.setText(characters[cardNum].getName());
    }
    private String readFile(int fileId){
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        StringBuffer stringBuffer;
        try {
            inputStream = getResources().openRawResource(fileId);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            stringBuffer = new StringBuffer();

            String data;

            while ((data = bufferedReader.readLine())!=null){
                stringBuffer.append(data).append("\n");
            }

            //clean up objects
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            Log.d(TAG, "readFile: " + stringBuffer.toString());
            return stringBuffer.toString();
        }
        catch (Exception e){
            Log.d(TAG, "readFile: " + e.getMessage());
            e.printStackTrace();
            return e.getMessage();
        }
    }
    public boolean onFling(@Nullable MotionEvent motionEvent1,
                           @NonNull MotionEvent motionEvent2,
                           float velocityX,
                           float velocityY) {
        Log.d(TAG, "onFling: ");

        int numOfCards = characters.length;
        try {
            //decide which direction I'm flinging
            int x1 = (int) (motionEvent1 != null ? motionEvent1.getX() : 0);
            int x2 = (int)motionEvent2.getX();



            if(x1 < x2){
                Animation move = AnimationUtils.loadAnimation(this, R.anim.moveright);
                move.setAnimationListener(new MainActivity.AnimationListener());
                imgCard.startAnimation(move);
                tvCard.startAnimation(move);
                //swipe right
                Log.d(TAG, "onFling: Right");
                cardNum = (cardNum - 1 + numOfCards) % numOfCards;
            }else{
                Animation move = AnimationUtils.loadAnimation(this, R.anim.moveleft);
                move.setAnimationListener(new MainActivity.AnimationListener());
                imgCard.startAnimation(move);
                tvCard.startAnimation(move);
                //swipe left
                Log.d(TAG, "onFling: Left");
                cardNum = (cardNum + 1) % numOfCards;
            }
        }
        catch (Exception ex){
            Log.e(TAG, "onSingleTapUp: " + ex.getMessage());
            ex.printStackTrace();
        }

        return true;
    }
    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
        Log.d(TAG, "onSingleTapUp: ");
        String message;
        try {
            if(isFront){
                //go to back
                message = "go to back";
                imgCard.setVisibility(View.VISIBLE);
                imgCard.setImageResource(imgs[cardNum + 25]);
                tvCard.setText(characters[cardNum].getDescription());
                String description = characters[cardNum].getDescription();
                tvCard.setTypeface(Typeface.DEFAULT);
                tvCard.setTypeface(Typeface.SERIF,Typeface.BOLD);
            }
            else{
                //go to front
                message = "go to front";
                tvCard.setTypeface(Typeface.DEFAULT);
                imgCard.setImageResource(imgs[cardNum]);
                imgCard.setVisibility(View.VISIBLE);
                tvCard.setText(characters[cardNum].getName());
            }

            isFront = !isFront;
            Log.d(TAG, "onSingleTapUp: " + message);
        }
        catch (Exception ex){
            Log.e(TAG, "onSingleTapUp: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        return gestureDetector.onTouchEvent(motionEvent);
    }
    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        return false;
    }
    @Override
    public void onShowPress(@NonNull MotionEvent e) {

    }
    public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }
    @Override
    public void onLongPress(@NonNull MotionEvent e) {

    }
}