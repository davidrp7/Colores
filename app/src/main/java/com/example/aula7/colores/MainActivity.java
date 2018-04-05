package com.example.aula7.colores;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    int seekR, seekG, seekB, seekA;
    SeekBar seekBarRed, seekBarGreen, seekBarBlue, seekBarAlpha;
    View viewBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarRed = (SeekBar) findViewById(R.id.id_sb_red);
        seekBarGreen = (SeekBar) findViewById(R.id.id_sb_green);
        seekBarBlue= (SeekBar) findViewById(R.id.id_sb_blue);
        seekBarAlpha = (SeekBar) findViewById(R.id.id_sb_alpha);
        viewBackground = (View) findViewById(R.id.id_v_backg);

        //registerForContextMenu(textViewName);
        seekBarRed.setOnSeekBarChangeListener(this);
        seekBarGreen.setOnSeekBarChangeListener(this);
        seekBarBlue.setOnSeekBarChangeListener(this);
        seekBarAlpha.setOnSeekBarChangeListener(this);

    }

    public void updateBackground() {
        seekR = seekBarRed.getProgress();
        seekG = seekBarGreen.getProgress();
        seekB = seekBarBlue.getProgress();
        seekA = seekBarAlpha.getProgress();

        int color = Color.argb(seekA, seekR, seekG, seekB);
        viewBackground.setBackgroundColor(color);

        //AUMENTAR UN TEXTVIEW A CADA BARRA Y CADA VEZ QUE MUEVA LA BARRA CAMBIE EL NUMERO
        // CUANDO SE DESPLIEGUE EL MENU QUE MUESTRE UNA PALETA DE COLORES Y AL DARLE CLICK CAMBIE LOS COLORES
    }


    //**********************************************************************

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_index, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_item_menu_1:
                Toast.makeText(this, "item 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.id_item_menu_2:
                Toast.makeText(this, "item 2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_index, menu);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        updateBackground();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    //************************************************************************
}
