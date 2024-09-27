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
import android.widget.LinearLayout;
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
    Character[] characters = IntialData.CreateCharacters();
    int[] imgs = IntialData.CreateImgs();
    int[] textFiles = IntialData.CreateTextFiles();
    int cardNum = 0;
    boolean isFront = true;
    ImageView imgCard;
    TextView tvCard;
    LinearLayout navbar;
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        IntialData.SetInitailData();
        new Navbar().setNavbar(this);
        imgCard = findViewById(R.id.imageView);
        tvCard = findViewById(R.id.tvInfo);
        navbar = findViewById(R.id.navbar);
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
                navbar.startAnimation(move);
                //swipe right
                Log.d(TAG, "onFling: Right");
                cardNum = (cardNum - 1 + numOfCards) % numOfCards;
            }else{
                Animation move = AnimationUtils.loadAnimation(this, R.anim.moveleft);
                move.setAnimationListener(new MainActivity.AnimationListener());
                imgCard.startAnimation(move);
                tvCard.startAnimation(move);
                navbar.startAnimation(move);
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