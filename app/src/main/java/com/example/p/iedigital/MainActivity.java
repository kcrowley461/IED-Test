package com.example.p.iedigital;
//https://github.com/ie/Code-Challenge-1
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int x = 0;
    int y = 0;
    String direction = "";
    int getx = 0;
    int gety = 0;
    String getdirection = "";

    public TextView MainText;
    public TextView ReportText;
    public EditText EnterMove;
    public Button ButtonGo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainText = (TextView) findViewById(R.id.mainText);
        ReportText = (TextView) findViewById(R.id.reportText);
        EnterMove = (EditText) findViewById(R.id.enterMove);
        ButtonGo = (Button) findViewById(R.id.buttonGo);

        ButtonGo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String content = EnterMove.getText().toString();
                EnterMove.setText("");
                //Get first value
                String[] separated = content.split(" ");
                String command = separated[0];
                if(separated.length > 1) {
                    String contentNew = separated[1];
                    String[] separatedAgain = contentNew.split(",");
                    getx = Integer.parseInt(separatedAgain[0]);
                    gety = Integer.parseInt(separatedAgain[1]);
                    getdirection = separatedAgain[2];
                }

                MainText.setText(content);

                if(getx > 5) {
                    getx = 0;
                    MainText.setText("value over 5, its now 0");
                }

                if(gety > 5) {
                    gety = 0;
                    MainText.setText("value too high, its now 0");
                }



                if(command.equals("PLACE")){
                    x = getx;
                    y = gety;
                    direction = getdirection;
                }
                else if (command.equals("MOVE")){

                    if(direction.equals("NORTH")){
                        if(y == 5){
                            MainText.setText("Cannot move further North");
                        }
                        else {
                            y = y + 1;
                        }
                    }
                    else if(direction.equals("SOUTH")){
                        if(y == 0){
                            MainText.setText("Cannot move further South");
                        }
                        else {
                            y = y - 1;
                        }
                    }
                    else if(direction.equals("EAST")){
                        if(x == 5){
                            MainText.setText("Cannot move further East");
                        }
                        else {
                            x = x + 1;
                        }
                    }
                    else if(direction.equals("WEST")){
                        if(x == 0){
                            MainText.setText("Cannot move further West");
                        }
                        else {
                            x = x - 1;
                        }
                    }
                    else{

                    }






                }
                else if (command.equals("LEFT")){

                    if(direction.equals("NORTH")){
                        direction = "WEST";
                    }
                    else if(direction.equals("EAST")){
                        direction = "NORTH";
                    }
                    else if(direction.equals("SOUTH")){
                        direction = "EAST";
                    }
                    else if(direction.equals("WEST")){
                        direction = "SOUTH";
                    }
                    else{

                    }
                }

                else if (command.equals("RIGHT")){


                    if(direction.equals("NORTH")){
                        direction = "EAST";
                    }
                    else if(direction.equals("EAST")){
                        direction = "SOUTH";
                    }
                    else if(direction.equals("SOUTH")){
                        direction = "WEST";
                    }
                    else if(direction.equals("WEST")){
                        direction = "NORTH";
                    }
                    else{

                    }

                }
                else if (command.equals("REPORT")){
                    ReportText.setText(x + "," + y + "," + direction);
                }
                else{
                    MainText.setText("invalid command");
                }
            }


        });

    }






}
