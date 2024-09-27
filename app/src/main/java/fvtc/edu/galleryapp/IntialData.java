package fvtc.edu.galleryapp;

import java.util.ArrayList;

public class IntialData {
    public static void SetInitailData(){

        CreateCharacters();
        CreateImgs();
        CreateTextFiles();
    }
    public static Character[] CreateCharacters(){
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
                /*new Character("Jean", "wind swordswoman"),
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
                new Character("Xinyan", "flame greatsword wielder"),*/
        };
        return characters;
    }
    public static int[] CreateImgs(){
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
                /*R.drawable._jean,
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
                R.drawable._xinyan,*/
                R.drawable._amber_fb,
                R.drawable._barbara_fb,
                R.drawable._bennett_fb,
                R.drawable._charlotte_fb,
                R.drawable._chongyun_fb,
                R.drawable._diona_fb,
                R.drawable._freminet_fb,
                R.drawable._gaming_fb,
                R.drawable._gorou_fb,
                /*R.drawable._jean_fb,
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
                R.drawable._xinyan_fb,*/
        };
        return imgs;
    }
    public static int[] CreateTextFiles(){
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
                /*R.raw._jean,
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
                R.raw._xinyan,*/
        };
        return textFiles;
    }

}
