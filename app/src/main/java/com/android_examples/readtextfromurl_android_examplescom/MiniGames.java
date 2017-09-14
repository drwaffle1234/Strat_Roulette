package com.android_examples.readtextfromurl_android_examplescom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by assas on 9/8/2017.
 */

public class MiniGames {
    Random strt = new Random();


    String[] Drinking={"Death = 1 shot.","Team Kill = 2 shots.","killing Hostage = 2 shots."};






    public String[] MiniGame1(ArrayList temp){
        String[] TempAr=new String[5];
        int num =strt.nextInt(temp.size());
        int tempnum=0;
        for(int i=0; i<TempAr.length; i++){

            if(tempnum==num){
                num =strt.nextInt(temp.size());
            }
            tempnum = num;
            TempAr[i]=i+1+". "+temp.get(num).toString();
        }

            return TempAr;
    }
















}
