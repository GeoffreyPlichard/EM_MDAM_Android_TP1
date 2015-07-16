package com.myschool.tp1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;


public class TP1Activity extends ActionBarActivity {

    Button btn_fr = null;
    Button btn_en = null;
    TextView texte = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp1);

        btn_fr = (Button) findViewById(R.id.btn_fr);
        btn_en = (Button) findViewById(R.id.btn_en);

        btn_fr.setOnClickListener(frenchListener);
        btn_en.setOnClickListener(englishListener);

        Toast.makeText(TP1Activity.this, "Démarrage...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tp1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Quitter l'application ?");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });

            builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }

        return super.onOptionsItemSelected(item);
    }

    private OnClickListener frenchListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            texte = (TextView) findViewById(R.id.texte);
            texte.setText(R.string.bonjour);
        }
    };

    private OnClickListener englishListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            texte = (TextView) findViewById(R.id.texte);
            texte.setText(R.string.hello);
        }
    };
}
