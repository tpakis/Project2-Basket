package com.example.android.basket;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int pointsHome = 0;
    int pointsGuest = 0;
    int foulsHome = 0;
    int foulsGuest = 0;
    int timeoutsHome = 0;
    int timeoutsGuest = 0;
    TextView textviewPointsHome;
    TextView textviewPointsGuests;
    TextView textviewFoulsHome;
    TextView textviewFoulsGuests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typeface awsomefont = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Typeface ledfont = Typeface.createFromAsset(getAssets(), "light_led_board-7.ttf");
        setContentView(R.layout.activity_main);
        textviewPointsHome = (TextView) findViewById(R.id.homePoints);
        textviewPointsGuests = (TextView) findViewById(R.id.guestPoints);
        textviewFoulsHome = (TextView) findViewById(R.id.homeFoulsTimeouts);
        textviewFoulsGuests = (TextView) findViewById(R.id.guestFoulsTimeouts);
        textviewPointsHome.setTypeface(ledfont);
        textviewPointsGuests.setTypeface(ledfont);
        textviewFoulsGuests.setTypeface(ledfont);
        textviewFoulsHome.setTypeface(ledfont);
    }

    public void onClickPoint(View v) {
        String tag = (String) v.getTag();
        int tagint = Integer.parseInt(tag);
        int teamNumber = tagint / 100;
        if (teamNumber == 1) {
            pointsHome = pointsHome + tagint - (teamNumber * 100);
        } else {
            pointsGuest = pointsGuest + tagint - (teamNumber * 100);
        }
        displayScore(teamNumber);
    }

    public void onClickFoulsTimeouts(View v) {
        String tag = (String) v.getTag();
        int tagint = Integer.parseInt(tag);
        int teamNumber = tagint / 100;
        int timeoutOrFoul = tagint - teamNumber * 100;
        if (teamNumber == 1) {
            if (timeoutOrFoul == 1) {
                foulsHome++;
            } else {
                timeoutsHome++;
            }
        } else {
            if (timeoutOrFoul == 1) {
                foulsGuest++;
            } else {
                timeoutsGuest++;
            }
        }
        displayFoulsTimeouts(teamNumber);
    }

    public void resetGame(View v) {
        pointsHome = 0;
        pointsGuest = 0;
        foulsHome = 0;
        foulsGuest = 0;
        timeoutsGuest = 0;
        timeoutsHome = 0;
        displayScore(1);
        displayScore(2);
        displayFoulsTimeouts(1);
        displayFoulsTimeouts(2);
    }

    /**
     * Displays the score of the teams.
     * TeamNum accepts 2 values 1 is the home team 2 the guest team.
     */
    public void displayScore(int teamNum) {
        if (teamNum == 1) {
            textviewPointsHome.setText(" " + pointsHome + " ");
        } else {
            textviewPointsGuests.setText(" " + pointsGuest + " ");
        }
    }

    public void displayFoulsTimeouts(int teamNum) {
        if (teamNum == 1) {
            textviewFoulsHome.setText(" " + foulsHome + " | " + timeoutsHome + " ");
        } else {
            textviewFoulsGuests.setText(" " + foulsGuest + " | " + timeoutsGuest + " ");
        }
    }
}
