package fvtc.edu.galleryapp;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Navbar extends AppCompatActivity {
    public static final String TAG = "Navbar";

    int cardNum = 0;

    public void setNavbar(Activity activity){
        Log.d(TAG, "setNavbar: start");
        Log.d(TAG, "setNavbar: 1");
        setNavbarImgs(activity);
        setNavbarLbls(activity);
        Log.d(TAG, "setNavbar: end");
    }
    public void setNavbarImgs(Activity activity){
        Log.d(TAG, "setNavbarImgs: start");
        ImageButton imgCharacter1 = activity.findViewById(R.id.imgCharacter1);
        ImageButton imgCharacter2 = activity.findViewById(R.id.imgCharacter2);
        ImageButton imgCharacter3 = activity.findViewById(R.id.imgCharacter3);

        int[] imgs = IntialData.CreateImgs();


        imgCharacter1.setImageResource(imgs[cardNum]);
        imgCharacter2.setImageResource(imgs[cardNum] + 2);
        imgCharacter3.setImageResource(imgs[cardNum] + 4);
        Log.d(TAG, "setNavbarImgs: end");
    }
    public void setNavbarLbls(Activity activity){
        Log.d(TAG, "setNavbarLbls: start");
        TextView tvCharacter1 = activity.findViewById(R.id.tvCharacter1);
        TextView tvCharacter2 = activity.findViewById(R.id.tvCharacter2);
        TextView tvCharacter3 = activity.findViewById(R.id.tvCharacter3);

        Character[] characters = IntialData.CreateCharacters();

        tvCharacter1.setText(characters[cardNum].getName());
        tvCharacter2.setText(characters[cardNum + 1].getName());
        tvCharacter3.setText(characters[cardNum + 2].getName());
        Log.d(TAG, "setNavbarLbls: end");
    }
}
