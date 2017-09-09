package np.com.ravipun.anagram;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import np.com.ravipun.anagram.libs.StaticWordLibrary;
import np.com.ravipun.anagram.libs.WordLibrary;

public class MainActivity extends AppCompatActivity {

    EditText guessedWord;
    Button guess, newWord;
    int WordIdx=0;
    TextView scrambledWord, feedback, levelIndicator;

    MediaPlayer mp;

    int points=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrambledWord = (TextView) findViewById(R.id.scrambled_word);
        guessedWord = (EditText) findViewById(R.id.guessed_word);
        newWord = (Button) findViewById(R.id.button_new_word);
        guess = (Button) findViewById(R.id.button_guess);
        feedback = (TextView) findViewById(R.id.feedback_area);
        levelIndicator = (TextView) findViewById(R.id.level_indicator);

        generateRandomScrambledWord();

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((StaticWordLibrary.getDefault().isCorrect(WordIdx,guessedWord.getText().toString()))){
                    mp  = MediaPlayer.create(MainActivity.this, R.raw.correct);//for sounds
                    mp.start();
                    feedback.setText(R.string.correct_ans);
                    points++;
                }
                else {
                    mp  = MediaPlayer.create(MainActivity.this,R.raw.wrong);
                    mp.start();
                    feedback.setText(R.string.wrong_ans);
                }
            }
        });

        newWord.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                generateRandomScrambledWord();
                guessedWord.setText("");
                feedback.setText("");
            }
        });
    }



    private void generateRandomScrambledWord() {
        Random rand = new Random();
        int n=0;
        if(points<5){
            n = rand.nextInt(8) + 0;  //generate random number from 0 to 8; 45 is the number of words in out StaticWordLibrary
        }else if (points>=5 && points<10){
            n = rand.nextInt(17) + 9;
            levelIndicator.setText("You are now level 2");
            mp  = MediaPlayer.create(MainActivity.this, R.raw.level_up);//for sounds
            mp.start();
        } else if (points>=10 && points<15){
            n = rand.nextInt(26) + 18;
            levelIndicator.setText("You are now level 3");
            mp  = MediaPlayer.create(MainActivity.this, R.raw.level_up);//for sounds
            mp.start();
        } else if (points>=15 && points<20){
            n = rand.nextInt(35) + 27;
            levelIndicator.setText("You are now level 4");
            mp  = MediaPlayer.create(MainActivity.this, R.raw.level_up);//for sounds
            mp.start();
        } else if (points>=20 && points<25){
            n = rand.nextInt(44) + 36;
            levelIndicator.setText("You are now level 5");
            mp  = MediaPlayer.create(MainActivity.this, R.raw.level_up);//for sounds
            mp.start();
        }
        scrambledWord.setText(StaticWordLibrary.getDefault().getScrambledWord(n));
        WordIdx=n;
    }


}
