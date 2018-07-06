package com.example.android.scorekeeper;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int counterAGoal=0,counterAFoul=0,counterAOffside=0,counterBGoal=0,counterBFoul=0,counterBOffside=0;
    private TextView teamAGoalsTextView,teamAFoulsTextView,teamAOffsidesTextView,teamBGoalsTextView,teamBFoulsTextView,teamBOffsidesTextView;
    private Button TeamAGoalsButton,TeamAFoulsButton,TeamAOffsidesButton,TeamBGoalsButton,TeamBFoulsButton,TeamBOffsidesButton,resetButton;
    private MediaPlayer goalSound,foulSound,endOfMatchSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindViewById();

        OnClickListener();

    }


    private void FindViewById()
    {
        teamAGoalsTextView= findViewById(R.id.teamA_goal_tv);
        teamAFoulsTextView= findViewById(R.id.teamA_foul_tv);
        teamAOffsidesTextView= findViewById(R.id.teamA_offside_tv);
        teamBGoalsTextView= findViewById(R.id.teamB_goal_tv);
        teamBFoulsTextView= findViewById(R.id.teamB_foul_tv);
        teamBOffsidesTextView= findViewById(R.id.teamB_offside_tv);


        TeamAGoalsButton= findViewById(R.id.teamA_goal_btn);
        TeamAFoulsButton= findViewById(R.id.teamA_foul_btn);
        TeamAOffsidesButton= findViewById(R.id.teamA_offside_btn);
        TeamBGoalsButton= findViewById(R.id.teamB_goal_btn);
        TeamBFoulsButton= findViewById(R.id.teamB_foul_btn);
        TeamBOffsidesButton= findViewById(R.id.teamB_offside_btn);
        resetButton=findViewById(R.id.reset_btn);

    }

    private  void OnClickListener()
    {
        TeamAGoalsButton.setOnClickListener(this);
        TeamAFoulsButton.setOnClickListener(this);
        TeamAOffsidesButton.setOnClickListener(this);
        TeamBGoalsButton.setOnClickListener(this);
        TeamBFoulsButton.setOnClickListener(this);
        TeamBOffsidesButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId())
        {
            case R.id.teamA_goal_btn:
            {
                 goalSound = MediaPlayer.create(this, R.raw.goal);
                counterAGoal+=1;
                teamAGoalsTextView.setText(String.valueOf(counterAGoal));
                goalSound.start();
                break;
            }

            case R.id.teamA_foul_btn:
            {
                foulSound = MediaPlayer.create(this, R.raw.foul);
                counterAFoul+=1;
                teamAFoulsTextView.setText(String.valueOf(counterAFoul));
                foulSound.start();
                break;
            }

            case R.id.teamA_offside_btn:
            {

                counterAOffside+=1;
                teamAOffsidesTextView.setText(String.valueOf(counterAOffside));
                break;
            }

            case R.id.teamB_goal_btn:
            {
               goalSound = MediaPlayer.create(this, R.raw.goal);
                counterBGoal+=1;
                teamBGoalsTextView.setText(String.valueOf(counterBGoal));
                goalSound.start();
                break;
            }

            case R.id.teamB_foul_btn:
            {
                 foulSound = MediaPlayer.create(this, R.raw.foul);
                counterBFoul+=1;
                teamBFoulsTextView.setText(String.valueOf(counterBFoul));
                foulSound.start();
                break;
            }

            case R.id.teamB_offside_btn:
            {
                counterBOffside+=1;
                teamBOffsidesTextView.setText(String.valueOf(counterBOffside));
                break;
            }


            case R.id.reset_btn:
            {

                endOfMatchSound = MediaPlayer.create(this, R.raw.match_end);

                if(counterAGoal>counterBGoal) {

                    Toast.makeText(this, "Team A Wins !"  ,Toast.LENGTH_LONG).show();

                }
                else if (counterAGoal<counterBGoal)
                {
                    Toast.makeText(this, "Team B Wins !"  ,Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this, "Draw"  ,Toast.LENGTH_LONG).show();
                }

                /*

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Final Score");
                builder.setMessage("Team A  " +counterAGoal +" : "+counterBGoal+ "  Team B");

                // add a button
                builder.setPositiveButton("OK", null);


                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.);

                */


                counterAGoal=0;
                counterAFoul=0;
                counterAOffside=0;

                counterBGoal=0;
                counterBFoul=0;
                counterBOffside=0;

                teamAGoalsTextView.setText(String.valueOf(counterAGoal));
                teamAFoulsTextView.setText(String.valueOf(counterAFoul));
                teamAOffsidesTextView.setText(String.valueOf(counterAOffside));

                teamBGoalsTextView.setText(String.valueOf(counterBGoal));
                teamBFoulsTextView.setText(String.valueOf(counterBFoul));
                teamBOffsidesTextView.setText(String.valueOf(counterBOffside));

                endOfMatchSound.start();



                break;
            }






        }


    }
}
