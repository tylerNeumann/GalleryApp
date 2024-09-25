package fvtc.edu.galleryapp;

import android.os.Bundle;
import android.view.GestureDetector;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import fvtc.edu.galleryapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
public static final String TAG = "MainActivity";
    Character[] Characters = {
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
            R.drawable.beakon,
            R.drawable.chillet,
            R.drawable.daedream,
            R.drawable.foxsparks,
            R.drawable.helzypher,
            R.drawable.nitewing,
            R.drawable.pyrin_noct,
            R.drawable.tombat,
            R.drawable.univolt,
            R.drawable.beakon2,
            R.drawable.chillet2,
            R.drawable.daedream2,
            R.drawable.foxsparks2,
            R.drawable.helzypher2,
            R.drawable.nitewing2,
            R.drawable.pyrin_noct2,
            R.drawable.tombat2,
            R.drawable.univolt2
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
            R.raw._xinagling,
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

}