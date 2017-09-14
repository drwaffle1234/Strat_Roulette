package com.android_examples.readtextfromurl_android_examplescom;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static boolean debug=false;
    SaveInfo SI=new SaveInfo();
    MiniGames MG=new MiniGames();
    TextView rainstrat;
    Button teamatk;
    Button teamdef;
    Button atk;
    Button def;
    Button atkstrt;
    Button defstrt;

    URL url ;
    String TextHolder = "" , TextHolder2 = "";
    BufferedReader bufferReader ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rainstrat = (TextView) findViewById(R.id.strat);
        teamatk = (Button) findViewById(R.id.team1);
        teamdef = (Button) findViewById(R.id.team2);
        atk = (Button) findViewById(R.id.atk);
        def = (Button) findViewById(R.id.def);
        atkstrt = (Button) findViewById(R.id.atkstrat);
        defstrt = (Button) findViewById(R.id.defstrat);
        teamatk.setOnClickListener(this);
        teamdef.setOnClickListener(this);
        atk.setOnClickListener(this);
        def.setOnClickListener(this);
        atkstrt.setOnClickListener(this);
        defstrt.setOnClickListener(this);

    }

    public void onClick(View evt) {
        if (evt==teamatk) {
            rainstrat.setText(SI.giveStrt(SI.Tatk));
        }else if (evt==teamdef) {
            rainstrat.setText(SI.giveStrt(SI.Tdef));
        }else if (evt==atk) {
            rainstrat.setText(SI.giveStrt(SI.OPatk));
        }else if (evt==def) {
            rainstrat.setText(SI.giveStrt(SI.OPdef));
        }else if (evt==atkstrt) {
            rainstrat.setText(SI.giveStrt(SI.atk));
        }else if (evt==defstrt) {
            rainstrat.setText(SI.giveStrt(SI.def));
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menustrat, menu);

        return true;
    }
    public boolean onPrepareOptionsMenu (Menu menu) {
        if (debug) {
            menu.findItem(R.id.addSt).setEnabled(true);
            menu.findItem(R.id.RemveSt).setEnabled(true);
            // You can also use something like: menu.findItem(R.id.example_foobar).setEnabled(false);

        }else{
            menu.findItem(R.id.addSt).setEnabled(false);
            menu.findItem(R.id.RemveSt).setEnabled(false);
        }
        return true;
    }
    @Override
    public void onStart() {
        new GetNotePadFileFromServer().execute();
        invalidateOptionsMenu();
            super.onStart();

    }

    public void onStop() {
        SI.atk.clear();
        SI.def.clear();
        SI.Tatk.clear();
        SI.Tdef.clear();
        SI.OPatk.clear();
        SI.OPdef.clear();
        super.onStop();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        if (id == R.id.addatkstrt) {
            //addStrat("Atk.txt",rSstrtatt,in.atk,rSstrtattT);
        }else if (id == R.id.addteamdefstrt) {
           // addStrat("Team def.txt",rSteamdef,in.def1,rSteamattT);
        }else if (id == R.id.addteamaskstrt) {
            //addStrat("Team atk.txt",rSteamatt,in.atk1,rSteamdefT);
        }else if (id == R.id.adddefstrt) {
           // addStrat("Def.txt",rSstrtdef,in.def,rSstrtdefT);
        }else if (id == R.id.rematkstrt) {
           // removeStrat( rSstrtattT, "Atk.txt",rSstrtatt,in.atk);
        }else if (id == R.id.remdefstrt) {
           // removeStrat( rSstrtdefT, "Def.txt",rSstrtdef,in.def );
        }else if (id == R.id.remteamaskstrt) {
           // removeStrat( rSteamattT, "Team atk",rSteamatt,in.atk1 );
        }else if (id == R.id.remteamdefstrt) {
          //  removeStrat( rSteamdefT, "Team Def",rSstrtdef,in.def1 );
        } else if (id==R.id.Codes){
            onCreateDialog();
        }else if (id==R.id.Rules){
            ListItems(SI.getRules(), "Rules", false);
        }else if (id==R.id.Game1){
            ListItems(MG.Drinking, "Drinking game", false);
        }else if (id==R.id.Game2){
            ListItems(MG.MiniGame1(SI.atk), "One friend picks the strat 1-5", false);
        }else if (id==R.id.Game3){
            ListItems(MG.MiniGame1(SI.def), "One friend picks the strat 1-5", false);
        }




        return super.onOptionsItemSelected(item);


    }
    public void ListItems(String[]temp, String name, final boolean hasOnClick) {

        final CharSequence[] items =temp.clone();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(name).setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(hasOnClick){


                }else{

                }
            }
        });
        builder.show();
    }


    public void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter code here.");
        final EditText input = new EditText(this);
        builder.setView(input);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String m_Text = input.getText().toString();
                rainstrat.setText( m_Text );
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public class GetNotePadFileFromServer extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {

            for (int i = 0; i < SI.UrlList.size(); i++){
                    try {

                        url = new URL(""+SI.UrlList.get(i));

                        bufferReader = new BufferedReader(new InputStreamReader(url.openStream()));

                        while ((TextHolder2 = bufferReader.readLine()) != null) {

                            SI.getList(i).add(TextHolder2);
                        }
                        bufferReader.close();

                    } catch (MalformedURLException malformedURLException) {


                        malformedURLException.printStackTrace();
                        TextHolder = malformedURLException.toString();

                    } catch (IOException iOException) {


                        iOException.printStackTrace();

                        TextHolder = iOException.toString();
                    }
             }
            return null;

        }


    }


}
