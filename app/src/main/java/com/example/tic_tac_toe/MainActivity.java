package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView view1,view2,view3,view4,view5,view6,view7,view8,view9,playerTurn;
    int PLAYER_O = 0;
    int PLAYER_X = 1;

    int activePlayer = PLAYER_O;

    int []fillPosition ={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    boolean gameActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        view5 = findViewById(R.id.view5);
        view6 = findViewById(R.id.view6);
        view7 = findViewById(R.id.view7);
        view8 = findViewById(R.id.view8);
        view9 = findViewById(R.id.view9);

        playerTurn = findViewById(R.id.playerTurn);


        view1.setOnClickListener(this);
        view2.setOnClickListener(this);
        view3.setOnClickListener(this);
        view4.setOnClickListener(this);
        view5.setOnClickListener(this);
        view6.setOnClickListener(this);
        view7.setOnClickListener(this);
        view8.setOnClickListener(this);
        view9.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (!gameActive)
            return;
        TextView clickedView = findViewById(view.getId());
        int clickedTag = Integer.parseInt(view.getTag().toString());

        if (fillPosition[clickedTag] != -1) {
            return;
        }
            fillPosition[clickedTag] = activePlayer;

        if (activePlayer==PLAYER_O){
          //clickedView.setText("O");
          activePlayer = PLAYER_X;
          playerTurn.setText("O Turn");
          clickedView.setBackground(getDrawable(R.drawable.player1));
        }
        else {
            //clickedView.setText("X");
            activePlayer=PLAYER_O;
            playerTurn.setText("X Turn");
            clickedView.setBackground(getDrawable(R.drawable.player0));
        }
        checkForWin();
    }

    public void checkForWin() {
        int[][] winningpos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        for (int i=0;i<8;i++){
            int val0 = winningpos[i][0];
            int val1 = winningpos[i][1];
            int val2 = winningpos[i][2];

            if (fillPosition[val0] == fillPosition[val1] && fillPosition[val1]== fillPosition[val2]){
                if (fillPosition[val0] != -1){
                    gameActive=false;
                    //winner declearetion
                    if (fillPosition[val0]==PLAYER_O)
                        showWinnerDialogBox("O is Winner");
                    else
                        showWinnerDialogBox("X is Winner");
                }
            }
        }
    }

    private void showWinnerDialogBox(String winnerAnnouncement){
        new AlertDialog.Builder(this).setTitle(winnerAnnouncement)
                        .setPositiveButton("Restart Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                restartAgain();
            }
        }).show();
    }

        private void restartAgain(){
        activePlayer = PLAYER_O;
        playerTurn.setText("O Turn");
        fillPosition = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,};
        view1.setText("");
        view2.setText("");
        view3.setText("");
        view4.setText("");
        view5.setText("");
        view6.setText("");
        view7.setText("");
        view8.setText("");
        view9.setText("");


        view1.setBackground(getDrawable(R.drawable.box));
        view2.setBackground(getDrawable(R.drawable.box));
        view3.setBackground(getDrawable(R.drawable.box));
        view4.setBackground(getDrawable(R.drawable.box));
        view5.setBackground(getDrawable(R.drawable.box));
        view6.setBackground(getDrawable(R.drawable.box));
        view7.setBackground(getDrawable(R.drawable.box));
        view8.setBackground(getDrawable(R.drawable.box));
        view9.setBackground(getDrawable(R.drawable.box));

            gameActive=true;

        }



}