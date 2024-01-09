package com.example.tic_tac_toe;

import static kotlinx.coroutines.DelayKt.delay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tic_tac_toe.databinding.NeumorphismlayoutBinding;

import java.util.Objects;

import soup.neumorphism.NeumorphButton;

public class MainActivity extends AppCompatActivity {

    private NeumorphismlayoutBinding binding;
    int flag = 0;
    int finalResultX, finalResult0;
    int count = 0;
    int player0Counter = 0;
    int playerXCounter = 0;
    int matchDrawCounter = 0;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9, result;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = NeumorphismlayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();

        Button resetButton = findViewById(R.id.restButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAll();
            }
        });

        TextView textView = findViewById(R.id.player_0_count);
        textView.setText(String.valueOf(matchWin0()));

        TextView textView2 = findViewById(R.id.playerXCount);
        textView2.setText(String.valueOf(matchWinX()));
    }

    private void init() {
        btn5 = findViewById(R.id.btn5);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

    }


    public void onCheck(View view) {
        Button currentBtn = (Button) view;
//        matchWinX(result);

        if (currentBtn.getText().toString().equals("")) {

            count++;
            if (flag == 0) {
                currentBtn.setText("X");
                flag = 1;
            } else {
                currentBtn.setText("O");
                flag = 0;
            }
//            count++;
            if (count > 4) {

                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    //condition 1
                    Toast.makeText(this, " " + b1, Toast.LENGTH_SHORT).show();
                    result = b1;
                    binding.winnerTextView.setText("Winner : "+ result);
                    playWinSoundAndVibrate();
                    winner(result);
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    //condition 2
                    Toast.makeText(this, " " + b4, Toast.LENGTH_SHORT).show();
                    result = b4;
                    binding.winnerTextView.setText(result);
                    binding.winnerTextView.setText("Winner : "+ result);
                    playWinSoundAndVibrate();
                    resetAll();
                    winner(result);
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    //condition 3
                    Toast.makeText(this, " " + b7, Toast.LENGTH_SHORT).show();
                    result = b7;
                    binding.winnerTextView.setText("Winner : "+ result);
                    resetAll();
                    winner(result);
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    //condition4
                    Toast.makeText(this, " " + b1, Toast.LENGTH_SHORT).show();
                    result = b1;
                    binding.winnerTextView.setText("Winner : "+ result);
                    resetAll();
                    winner(result);
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    //condition5
                    Toast.makeText(this, "" + b2, Toast.LENGTH_SHORT).show();
                    result = b2;
                    binding.winnerTextView.setText("Winner : "+ result);
                    resetAll();
                    winner(result);
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    //condition 6
                    Toast.makeText(this, " " + b3, Toast.LENGTH_SHORT).show();
                    result = b3;
                    binding.winnerTextView.setText("Winner : "+ result);
                    resetAll();
                    winner(result);
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    //condition 7
                    Toast.makeText(this, " " + b1, Toast.LENGTH_SHORT).show();
                    result = b1;
                    binding.winnerTextView.setText("Winner : "+ result);
                    resetAll();
                    winner(result);
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    //condition 8
                    Toast.makeText(this, " " + b3, Toast.LENGTH_SHORT).show();
                    result = b3;
                    binding.winnerTextView.setText("Winner : "+ result);
                    resetAll();
                    winner(result);
                } else {
                    Log.d("Count", "onCheck: " + count);

                    if (count == 9) {
                        matchDrawCounter++;
                        binding.matchDrawCount.setText(String.valueOf(matchDrawCounter));
                        resetAll();
                    }
                }
            }
        }

    }
    public void resetAll() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 0;
        flag = 0;
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(vibrator!=null){
            vibrator.vibrate(500);
        }

            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.bubbpopupalert);
            mediaPlayer.start();
        }


    public void winner(String result) {
        if (Objects.equals(result, "X")) {
            playerXCounter += 1;
            System.out.println("count is " + playerXCounter);
            binding.playerXCount.setText(String.valueOf(playerXCounter));
        } else {
            player0Counter += 1;
            binding.player0Count.setText(String.valueOf(player0Counter));
        }

        WinnerDialog dialog = new WinnerDialog(MainActivity.this, result);
        dialog.setCancelable(true);
        dialog.show(getSupportFragmentManager(), dialog.getTag());
    }

    public int matchWinX() {
        System.out.println("final result is  " + finalResultX);
        return finalResultX;
    }


    public int matchWin0() {
        return finalResult0;
    }
    private void playWinSoundAndVibrate() {
        // Play sound
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.happybells); // Replace with your sound file
        mediaPlayer.start();

        // Vibrate
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator != null) {
            // Vibrate for 500 milliseconds
            vibrator.vibrate(500);
        }
    }
}




