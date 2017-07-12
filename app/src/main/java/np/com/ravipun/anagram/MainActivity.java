package np.com.ravipun.anagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

import np.com.ravipun.anagram.libs.StaticWordLibrary;
import np.com.ravipun.anagram.libs.WordLibrary;

public class MainActivity extends AppCompatActivity {

EditText scrambledWord, guessedWord;
    Button guess, newWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrambledWord = (EditText) findViewById(R.id.scrambled_word);
        guessedWord = (EditText) findViewById(R.id.guessed_word);
        newWord = (Button) findViewById(R.id.button_new_word);
        guess = (Button) findViewById(R.id.button_guess);

        Random rand = new Random();

        int  n = rand.nextInt(44) + 0;  //generate random number from 0 to 44; 45 is the number of words in out StaticWordLibrary


        scrambledWord.setText(StaticWordLibrary.getDefault().getScrambledWord(n));

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //// TODO: 7/12/17
            }
        });

        newWord.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO: 7/12/17
            }
        });
    }
}
