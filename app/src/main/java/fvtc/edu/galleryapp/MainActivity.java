package fvtc.edu.galleryapp;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import fvtc.edu.galleryapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
public static final String TAG = "MainActivity";
    Character[] characters = {
            new Character("Beakon", "thunder bird"),
            new Character("Chillet", "ice dragon"),
            new Character("Daedream","poison fae"),
            new Character("Foxsparks","fire fox"),
            new Character("Helzypher", "hell dragon"),
            new Character("Nitewing", "bird"),
            new Character("Pyrin Noct", "dark flaming kyrin"),
            new Character("Tombat", "bat"),
            new Character("Univolt", "lightning unicorn")
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

    };
    int cardNum = 0;
    boolean isFront = true;
    ImageView imgCard;
    TextView tvCard;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_character1, R.id.navigation_character2, R.id.navigation_character3)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
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
}