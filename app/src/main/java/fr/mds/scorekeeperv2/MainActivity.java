package fr.mds.scorekeeperv2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.media.Image;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mScore1;
    private int mScore2;
    private TextView mScoreText1 ;
    private TextView mScoreText2;
//    private ImageButton btnMinus1;
//    private ImageButton btnMinus2;
//    private ImageButton btnPlus1;
//    private ImageButton btnPlus2;

    // tages for instance states
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mScoreText1 = (TextView) findViewById(R.id.score_1);
        this.mScoreText2 = (TextView)findViewById(R.id.score_2);

//        this.btnMinus1 = (ImageButton) findViewById(R.id.decreaseTeam1);
//        this.btnMinus2 = (ImageButton) findViewById(R.id.decreaseTeam2);
//        this.btnPlus1 = (ImageButton) findViewById(R.id.increaseTeam1);
//        this.btnPlus2 = (ImageButton) findViewById(R.id.increaseTeam2);

        if (savedInstanceState != null) {
            this.mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            this.mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            mScoreText1.setText(String.valueOf(this.mScore1));
            mScoreText2.setText(String.valueOf(this.mScore2));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

            }

            // Recreate the activity for the theme change to take effect.
            recreate(); // seemns optional :|
        }
        return true;
    }

//    /**
//     * Change theme of buttons
//     * @deprecated
//     * @param i if 0 sets a dark style to the buttons, if 1 sets a light style to the buttons
//     */
//    private void setButtonsStyle(int i) {
//        switch (i) {
////            case 0 :
////               setTheme(R.style.PlusButtons_dark);
////               setTheme(R.style.MinusButtons_dark);
////                break;
////            case 1:
////                setTheme(R.style.PlusButtons);
////                setTheme(R.style.MinusButtons);
////                break;
////            case 0 :
////                this.btnMinus1 = new ImageButton(this, null, R.attr.buttonStyle ,  R.style.MinusButtons_dark);
////                this.btnMinus2 = new ImageButton(this, null, R.style.MinusButtons_dark);
////                this.btnPlus1 = new ImageButton(this, null,  R.style.PlusButtons_dark);
////                this.btnPlus2 = new ImageButton(this, null,  R.style.PlusButtons_dark);
////                break;
////            case 1:
////                this.btnMinus1 = new ImageButton(this, null, R.attr.buttonStyle ,  R.style.MinusButtons);
////                this.btnMinus2 = new ImageButton(this, null, R.style.MinusButtons);
////                this.btnPlus1 = new ImageButton(this, null,  R.style.PlusButtons);
////                this.btnPlus2 = new ImageButton(this, null,  R.style.PlusButtons);
////                break;
//          case 0 :
//                this.btnMinus1.setImageResource(R.drawable.ic_minus_dark);
//                this.btnMinus2.setImageResource(R.drawable.ic_minus_dark);
//                this.btnPlus1.setImageResource(R.drawable.ic_plus_dark);
//                this.btnPlus2.setImageResource(R.drawable.ic_plus_dark);
//                break;
//            case 1:
//                this.btnMinus1.setImageResource(R.drawable.ic_minus);
//                this.btnMinus2.setImageResource(R.drawable.ic_minus);
//                this.btnPlus1.setImageResource(R.drawable.ic_plus);
//                this.btnPlus2.setImageResource(R.drawable.ic_plus);
//                break;
//            default:
//                Toast.makeText(this, "impossible to change button style !", Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;

    }

    public void decreaseScore(View view) {
        int viewID = view.getId();

        switch (viewID) {
            case R.id.decreaseTeam1:
                mScore1-- ;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                mScore2-- ;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();

        switch (viewID) {
            case R.id.increaseTeam1:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle out) {
        out.putInt(STATE_SCORE_1, mScore1);
        out.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(out);
    }


}
