package com.android_examples.readtextfromurl_android_examplescom;



import java.util.ArrayList;
import java.util.Random;

/**
 * Created by assas on 9/7/2017.
 */

public class SaveInfo {


    Random strt = new Random();
    int x1,x2;

    ArrayList atk= new ArrayList();
    ArrayList def= new ArrayList();
    ArrayList Tatk= new ArrayList();
    ArrayList Tdef= new ArrayList();
    ArrayList OPatk= new ArrayList();
    ArrayList OPdef= new ArrayList();
    ArrayList Rules= new ArrayList();
    ArrayList broke= new ArrayList();
    ArrayList UrlList= new ArrayList();



    String URLATK = "http://game.x10host.com/cgi-bin/Atk.txt" ;
    String URLDEF = "http://game.x10host.com/cgi-bin/Def.txt" ;
    String URLTATK = "http://game.x10host.com/cgi-bin/Team%20atk.txt" ;
    String URLTDEF = "http://game.x10host.com/cgi-bin/Team%20def.txt" ;
    String URLTOPD = "http://game.x10host.com/cgi-bin/DEFOPS.txt" ;
    String URLTOPA = "http://game.x10host.com/cgi-bin/ATKOPS.txt" ;
    String URLRULES = "http://game.x10host.com/cgi-bin/Rules.txt" ;


    public String giveStrt(ArrayList temp){
        int num =strt.nextInt(temp.size());
        if(num==x1){
            num =strt.nextInt(temp.size());
            if(num==x2){
                num =strt.nextInt(temp.size());
                return temp.get( num ).toString();
            }
            x2=num;
            return temp.get( num ).toString();
        }
        x1=num;
        if(MainActivity.debug)
            return temp.get( num ).toString()+" "+num+" "+ temp.size();
        else
            return temp.get( num ).toString();
    }

    public String[] getRules(){
        String[] rules = new String[Rules.size()];

        for(int i=0; i<rules.length; i++){
            rules[i]=Rules.get(i).toString();
        }
        return rules;
    }

    public SaveInfo(){
        UrlList.add(URLATK);
        UrlList.add(URLDEF);
        UrlList.add(URLTATK);
        UrlList.add(URLTDEF);
        UrlList.add(URLTOPD);
        UrlList.add(URLTOPA);
        UrlList.add(URLRULES);


    }

    public ArrayList getList(int i){
        if(i==0){
            return atk;
        }else if(i==1){
            return def;
        }else if(i==2){
            return Tatk;
        }else if(i==3){
            return Tdef;
        }else if(i==4){
            return OPdef;
        }else if(i==5){
            return OPatk;
        }else if(i==6){
            return Rules;
        }
        else{
            return broke;
        }
    }


}
