package fvtc.edu.galleryapp;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
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
    /*LinearLayout navbar;*/
    GestureDetector gestureDetector;
   /* Boolean swipingRight;
    ImageButton imgCharacter1;
    ImageButton imgCharacter2;
    ImageButton imgCharacter3;
    TextView tvCharacter1;
    TextView tvCharacter2;
    TextView tvCharacter3;
    int currentCard = 1;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        IntialData.SetInitailData();
        /*initNavbar();*/
        imgCard = findViewById(R.id.imageView);
        tvCard = findViewById(R.id.tvInfo);
        /*navbar = findViewById(R.id.navbar);*/
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

    /*private void initNavbar() {
        Log.d(TAG, "setNavbar: start");

        Log.d(TAG, "setNavbarImgs: start");
        imgCharacter1 = findViewById(R.id.imgCharacter1);
        imgCharacter2 = findViewById(R.id.imgCharacter2);
        imgCharacter3 = findViewById(R.id.imgCharacter3);

        setUpListenerEvent(imgCharacter1);
        setUpListenerEvent(imgCharacter2);
        setUpListenerEvent(imgCharacter3);

        int[] imgs = IntialData.CreateImgs();

        imgCharacter1.setImageResource(imgs[cardNum]);
        imgCharacter2.setImageResource(imgs[cardNum] + 2);
        imgCharacter3.setImageResource(imgs[cardNum] + 4);
        Log.d(TAG, "setNavbarImgs: end");

        Log.d(TAG, "setNavbarLbls: start");
        tvCharacter1 = findViewById(R.id.tvCharacter1);
        tvCharacter2 = findViewById(R.id.tvCharacter2);
        tvCharacter3 = findViewById(R.id.tvCharacter3);

        tvCharacter1.setText(characters[cardNum].getName());
        tvCharacter2.setText(characters[cardNum + 1].getName());
        tvCharacter3.setText(characters[cardNum + 2].getName());
        Log.d(TAG, "setNavbarLbls: end");



        Log.d(TAG, "setNavbar: end");


    }
    public void setUpListenerEvent(ImageButton imageButton){
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCurrentCard();
                Log.d(TAG, "onClick: starting current card: " + checkCurrentCard());
                Log.d(TAG, "onClick: starting cardnum: " + cardNum);
                if(checkCurrentCard() == 1){
                    Log.d(TAG, "onClick: meth 1 start");
                    if(imageButton == imgCharacter2){
                        Log.d(TAG, "onClick: hit meth 1 if 1");
                        cardNum +=1;
                        imgCard.setImageResource(imgs[cardNum]);
                        tvCard.setText(characters[cardNum].getName());
                        currentCard = 2;
                    }
                    else if(imageButton == imgCharacter3){
                        Log.d(TAG, "onClick: hit meth 1 if 2");
                        cardNum +=2;
                        imgCard.setImageResource(imgs[cardNum]);
                        tvCard.setText(characters[cardNum].getName());
                        currentCard = 3;
                    }
                    else {
                        currentCard = 1;
                        cardNum = 0;
                        imgCard.setImageResource(imgs[cardNum]);
                        tvCard.setText(characters[cardNum].getName());
                    }
                    Log.d(TAG, "onClick: meth 1 end");
                    Log.d(TAG, "onClick: ending current card: " + checkCurrentCard());
                    Log.d(TAG, "onClick: ending cardnum: " + cardNum);
                }
                else if(checkCurrentCard() == 2){
                    Log.d(TAG, "onClick: meth 2 start");
                    if(imageButton == imgCharacter1){
                        cardNum -=1;
                        imgCard.setImageResource(imgs[cardNum]);
                        tvCard.setText(characters[cardNum].getName());
                        currentCard = 1;
                    }
                    else if(imageButton == imgCharacter3){
                        cardNum +=1;
                        imgCard.setImageResource(imgs[cardNum]);
                        tvCard.setText(characters[cardNum].getName());
                        currentCard = 3;
                    }
                    else {
                        currentCard = 2;
                        cardNum = 1;
                        imgCard.setImageResource(imgs[cardNum]);
                        tvCard.setText(characters[cardNum].getName());
                    }
                    Log.d(TAG, "onClick: meth 2 end");
                    Log.d(TAG, "onClick: ending current card: " + checkCurrentCard());
                    Log.d(TAG, "onClick: ending cardnum: " + cardNum);
                }
                else if(checkCurrentCard() == 3){
                    Log.d(TAG, "onClick: meth 3 start");
                    if(imageButton == imgCharacter2){
                        cardNum -=1;
                        imgCard.setImageResource(imgs[cardNum]);
                        tvCard.setText(characters[cardNum].getName());
                        currentCard = 2;
                    }
                    else if(imageButton == imgCharacter1){
                        cardNum -=2;
                        imgCard.setImageResource(imgs[cardNum]);
                        tvCard.setText(characters[cardNum].getName());
                        currentCard = 3;
                    }
                    else{
                        currentCard = 3;
                        cardNum = 2;
                        imgCard.setImageResource(imgs[cardNum]);
                        tvCard.setText(characters[cardNum].getName());
                    }
                    Log.d(TAG, "onClick: meth 3 end");
                    Log.d(TAG, "onClick: ending current card: " + checkCurrentCard());
                    Log.d(TAG, "onClick: ending cardnum: " + cardNum);
                }
                else{
                    currentCard = 1;
                    cardNum = 0;
                    imgCard.setImageResource(imgs[cardNum]);
                    tvCard.setText(characters[cardNum].getName());
                }
                Log.d(TAG, "onClick: end");

//                if(imageButton == imgCharacter2){
//                    cardNum +=1;
//                    imgCard.setImageResource(imgs[cardNum]);
//                    tvCard.setText(characters[cardNum].getName());
//                    updateNavbar();
//                }
            }
        });
    }

    private int checkCurrentCard() {
        if (tvCard.getText().toString() == tvCharacter1.getText().toString()) return currentCard = 1;
        else if(tvCard.getText().toString() == tvCharacter2.getText().toString()) return currentCard = 2;
        else if(tvCard.getText().toString() == tvCharacter3.getText().toString()) return currentCard = 3;
        else return currentCard = 0;
    }
*/
    private class AnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Log.d(TAG, "onAnimationEnd: ");
            updateToNextCard();
            /*updateNavbar();*/
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.amber)
        {
            cardNum = 0;
            Log.d(TAG, "onOptionsItemSelected: " + item.getTitle());
            tvCard.setTypeface(Typeface.DEFAULT);
            imgCard.setImageResource(imgs[cardNum]);
            tvCard.setText(characters[cardNum].getName());

        }
        else if (id == R.id.barbara) {
            cardNum = 1;
            Log.d(TAG, "onOptionsItemSelected: " + item.getTitle());
            tvCard.setTypeface(Typeface.DEFAULT);
            imgCard.setImageResource(imgs[cardNum]);
            tvCard.setText(characters[cardNum].getName());

        }
        else if (id == R.id.bennett) {
            cardNum = 2;
            Log.d(TAG, "onOptionsItemSelected: " + item.getTitle());
            tvCard.setTypeface(Typeface.DEFAULT);
            imgCard.setImageResource(imgs[cardNum]);
            tvCard.setText(characters[cardNum].getName());
        }
        else if(id == R.id.charlotte){
            cardNum = 3;
            Log.d(TAG, "onOptionsItemSelected: " + item.getTitle());
            tvCard.setTypeface(Typeface.DEFAULT);
            imgCard.setImageResource(imgs[cardNum]);
            tvCard.setText(characters[cardNum].getName());
        }
        else if(id == R.id.chongyun){
            cardNum = 4;
            Log.d(TAG, "onOptionsItemSelected: " + item.getTitle());
            tvCard.setTypeface(Typeface.DEFAULT);
            imgCard.setImageResource(imgs[cardNum]);
            tvCard.setText(characters[cardNum].getName());
        }
        else if(id == R.id.diona){
            cardNum = 5;
            Log.d(TAG, "onOptionsItemSelected: " + item.getTitle());
            tvCard.setTypeface(Typeface.DEFAULT);
            imgCard.setImageResource(imgs[cardNum]);
            tvCard.setText(characters[cardNum].getName());
        }
        else if(id == R.id.freminet){
            cardNum = 6;
            Log.d(TAG, "onOptionsItemSelected: " + item.getTitle());
            tvCard.setTypeface(Typeface.DEFAULT);
            imgCard.setImageResource(imgs[cardNum]);
            tvCard.setText(characters[cardNum].getName());
        } else if(id == R.id.gaming){
            cardNum = 7;
            Log.d(TAG, "onOptionsItemSelected: " + item.getTitle());
            tvCard.setTypeface(Typeface.DEFAULT);
            imgCard.setImageResource(imgs[cardNum]);
            tvCard.setText(characters[cardNum].getName());

        } else if(id == R.id.gorou){
            cardNum = 8;
            Log.d(TAG, "onOptionsItemSelected: " + item.getTitle());
            tvCard.setTypeface(Typeface.DEFAULT);
            imgCard.setImageResource(imgs[cardNum]);
            tvCard.setText(characters[cardNum].getName());

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_characters, menu);
        return true;
    }
    private void updateToNextCard() {
        characters[cardNum].setDescription(readFile(textFiles[cardNum]));

        isFront = true;
        imgCard.setVisibility(View.VISIBLE);
        imgCard.setImageResource(imgs[cardNum]);
        tvCard.setText(characters[cardNum].getName());
    }
    /*public void updateNavbar() {
        imgCharacter1 = findViewById(R.id.imgCharacter1);
        imgCharacter2 = findViewById(R.id.imgCharacter2);
        imgCharacter3 = findViewById(R.id.imgCharacter3);
        tvCharacter1 = findViewById(R.id.tvCharacter1);
        tvCharacter2 = findViewById(R.id.tvCharacter2);
        tvCharacter3 = findViewById(R.id.tvCharacter3);

        imgCharacter1.setImageResource(imgs[cardNum]);
        tvCharacter1.setText(characters[cardNum].getName());

        imgCharacter2.setImageResource(imgs[getCardNum1()]);
        tvCharacter2.setText(characters[cardNum].getName());

        imgCharacter3.setImageResource(imgs[getCardNum1()]);
        tvCharacter3.setText(characters[cardNum].getName());

    }*/
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
    /*public int getCardNum1() {
        if(swipingRight) return cardNum = (cardNum - 1 + numOfCards) % numOfCards;
        else return cardNum = (cardNum + 1) % numOfCards;
    }*/
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
                /*navbar.startAnimation(move);*/
                //swipe right
                /*swipingRight = true;*/
                Log.d(TAG, "onFling: Right");
                cardNum = (cardNum - 1 + numOfCards) % numOfCards; /*getCardNum1();*/
            }else{
                Animation move = AnimationUtils.loadAnimation(this, R.anim.moveleft);
                move.setAnimationListener(new MainActivity.AnimationListener());
                imgCard.startAnimation(move);
                tvCard.startAnimation(move);
                /*navbar.startAnimation(move);*/
                //swipe left
                /*swipingRight = false;*/
                Log.d(TAG, "onFling: Left");
                cardNum = (cardNum + 1) % numOfCards; /*getCardNum1();*/
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
        characters[cardNum].setDescription(readFile(textFiles[cardNum]));
        String message;
        try {
            if(isFront){
                //go to back
                message = "go to back";
                imgCard.setImageResource(imgs[cardNum]);
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