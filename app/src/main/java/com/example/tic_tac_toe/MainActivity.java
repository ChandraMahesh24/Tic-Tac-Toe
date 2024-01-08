package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tic_tac_toe.databinding.NeumorphismlayoutBinding;

import java.util.Objects;

import soup.neumorphism.NeumorphButton;

public class MainActivity extends AppCompatActivity {

    private NeumorphismlayoutBinding binding;
    int flag=0;
    int finalResultX,finalResult0;
    int count =0;
    int player0Counter = 0;
    int playerXCounter = 0;
    int matchDrawCounter = 0;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9, result;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
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
                restAll();
            }
        });

        TextView textView = findViewById(R.id.player_0_count);
        textView.setText(String.valueOf(matchWin0()));

        TextView textView2 = findViewById(R.id.playerXCount);
       textView2.setText(String.valueOf(matchWinX()));
    }

    private void init() {
        btn5=findViewById(R.id.btn5);
        btn1= findViewById(R.id.btn1);
        btn2= findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5= findViewById(R.id.btn5);
        btn6= findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

    }


    public  void  onCheck(View view) {
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
            count++;
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

                if (b1.equals(b2) && b2.equals(b3) &&! b1.equals("")) {
                    //condition 1
                    Toast.makeText(this, " " + b1, Toast.LENGTH_SHORT).show();
                    result=b1;
                    restAll();
                    winner(result);
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    //condition 2
                    Toast.makeText(this, " " + b4, Toast.LENGTH_SHORT).show();
                    result=b4;
                    restAll();
                    winner(result);
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    //condition 3
                    Toast.makeText(this, " " + b7, Toast.LENGTH_SHORT).show();
                    result=b7;
                    restAll();
                    winner(result);
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    //condition4
                    Toast.makeText(this, " " + b1, Toast.LENGTH_SHORT).show();
                    result=b1;

                    restAll();
                    winner(result);
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    //condition5
                    Toast.makeText(this, "" + b2, Toast.LENGTH_SHORT).show();
                    result=b2;
                    restAll();
                    winner(result);
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    //condition 6
                    Toast.makeText(this, " " + b3, Toast.LENGTH_SHORT).show();
                    result=b3;
                    restAll();
                    winner(result);
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    //condition 7
                    Toast.makeText(this, " " + b1, Toast.LENGTH_SHORT).show();
                    result=b1;
                    restAll();
                    winner(result);
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    //condition 8
                    Toast.makeText(this, " " + b3, Toast.LENGTH_SHORT).show();
                    result=b3;
                    restAll();
                    winner(result);
                }
            }

        }

    }


    public  void  restAll(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count=0;
        flag=0;
    }
    public void winner(String result){
        if(Objects.equals(result, "X")){
            playerXCounter+=1;
            System.out.println("count is "+playerXCounter);
            binding.playerXCount.setText(String.valueOf(playerXCounter));
        }
        else {
            player0Counter+=1;
            binding.player0Count.setText(String.valueOf(player0Counter));
        }
    }

    public  int    matchWinX(){
        System.out.println("final result is  "+finalResultX);
        return  finalResultX;
    }


   public  int matchWin0(){
        return finalResult0;
    }

//    private boolean playerXTurn = true;
//    private int[][] board = new int[3][3];
//    private boolean gameOver = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.neumorphismlayout);
//        initializeUI();
//        initializeGame();
    }

//    private void initializeUI() {
//        // Initialize Neumorphism UI elements and set listeners
//        NeumorphButton btn1 = findViewById(R.id.btn1);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onCellClicked(view);
//            }
//        });
//
//
//        NeumorphButton btn2 = findViewById(R.id.btn2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onCellClicked(view);
//            }
//        });
//        NeumorphButton btn3 = findViewById(R.id.btn3);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onCellClicked(view);
//            }
//        });
//        NeumorphButton btn4 = findViewById(R.id.btn4);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onCellClicked(view);
//            }
//        });
//        NeumorphButton btn5 = findViewById(R.id.btn5);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onCellClicked(view);
//            }
//        });
//        NeumorphButton btn6 = findViewById(R.id.btn6);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onCellClicked(view);
//            }
//        });
//        NeumorphButton btn7 = findViewById(R.id.btn7);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onCellClicked(view);
//            }
//        });
//        NeumorphButton btn8 = findViewById(R.id.btn8);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onCellClicked(view);
//            }
//        });
//        NeumorphButton btn9 = findViewById(R.id.btn9);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onCellClicked(view);
//            }
//        });
//
//        NeumorphButton resetButton = findViewById(R.id.restButton);
//        resetButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                resetGame();
//            }
//        });
//
//
//        TextView player0Count = findViewById(R.id.player_0_count);
//        player0Count.setText("0");
//
//        TextView playerXCount = findViewById(R.id.playerXCount);
//        playerXCount.setText("0");
//    }

//    private void initializeGame() {
//        // Clear the game board
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                board[i][j] = 0;
//            }
//        }
//        gameOver = false;
//        playerXTurn = true;
//        NeumorphButton btn1 = findViewById(R.id.btn1);
//        btn1.setText("");
//        NeumorphButton btn2 = findViewById(R.id.btn2);
//        btn1.setText("");
//        NeumorphButton btn3 = findViewById(R.id.btn3);
//        btn1.setText("");
//        NeumorphButton btn4 = findViewById(R.id.btn4);
//        btn1.setText("");
//        NeumorphButton btn5 = findViewById(R.id.btn5);
//        btn1.setText("");
//        NeumorphButton btn6 = findViewById(R.id.btn6);
//        btn1.setText("");
//        NeumorphButton btn7 = findViewById(R.id.btn7);
//        btn1.setText("");
//        NeumorphButton btn8 = findViewById(R.id.btn8);
//        btn1.setText("");
//        NeumorphButton btn9 = findViewById(R.id.btn9);
//        btn1.setText("");
//
//    }
//
//
//    public void onCellClicked(View view) {
//        if (!gameOver && view instanceof NeumorphButton) {
//            NeumorphButton clickedButton = (NeumorphButton) view;
//            int tag = (int) clickedButton.getTag(); // Get the cell index from tag
//
//            int row = tag / 3; // Calculate row from cell index
//            int col = tag % 3; // Calculate column from cell index
//
//            if (board[row][col] == 0) {
//                board[row][col] = playerXTurn ? 1 : 2; // Set the player's mark on the board
//                clickedButton.setText(playerXTurn ? "X" : "O"); // Update UI with X or O
//
//                // Check for a winner or a draw and update game state accordingly
//                checkWinner();
//
//                // Switch players if the game is ongoing
//                playerXTurn = !playerXTurn;
//            }
//        }
//    }
//    private boolean checkWinner() {
//        for (int i = 0; i < 3; i++) {
//            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
//                gameOver = true;
//                announceWinner(board[i][0]);
//                return false;
//            }
//            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
//                gameOver = true;
//                announceWinner(board[0][i]);
//                return false;
//            }
//        }
//
//        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
//            gameOver = true;
//            announceWinner(board[0][0]);
//            return false;
//        }
//
//        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
//            gameOver = true;
//            announceWinner(board[0][2]);
//            return false;
//        }
//        boolean isBoardFull = true;
//        for (int[] row : board) {
//            for (int cell : row) {
//                if (cell == 0) {
//                    isBoardFull = false;
//                    break;
//                }
//            }
//        }
//        if (isBoardFull) {
//            gameOver = true;
//            announceDraw();
//        }
//        return isBoardFull;
//    }
//    private void announceDraw() {
//        Toast.makeText(this, "It's a draw!", Toast.LENGTH_SHORT).show();
//    }
//    private boolean checkDraw() {
//        // Check if all cells are filled
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (board[i][j] == 0) {
//                    return false; // At least one empty cell found, game is not a draw
//                }
//            }
//        }
//        return true; // All cells filled, game is a draw
//    }
//
//    private void announceWinner(int winner) {
//        String winnerText;
//        if (winner == 1) {
//            winnerText = "Player X wins!";
//        } else {
//            winnerText = "Player O wins!";
//        }
//        TextView winnerTextView = findViewById(R.id.winnerTextView);
//        winnerTextView.setText(winnerText);
//        if (winner == 1) {
//            // Increment Player X's score
//            TextView playerXCount = findViewById(R.id.playerXCount);
//            int currentScore = Integer.parseInt(playerXCount.getText().toString());
//            playerXCount.setText(String.valueOf(currentScore + 1));
//        } else {
//            // Increment Player O's score
//            TextView player0Count = findViewById(R.id.player_0_count);
//            int currentScore = Integer.parseInt(player0Count.getText().toString());
//            player0Count.setText(String.valueOf(currentScore + 1));
//        }
//    }
//    private void resetGame() {
//        // Reset the game (clear the board, reset UI, etc.)
//        // ...
//    }
//    // Add other methods for game logic, checking winner, announcing results, etc.
//    // ...




