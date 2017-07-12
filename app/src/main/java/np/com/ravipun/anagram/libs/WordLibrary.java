package np.com.ravipun.anagram.libs;

/**
 * Created by ravi on 7/12/17.
 */

public abstract class WordLibrary {
    protected WordLibrary() {
    }

    public static WordLibrary getDefault() {
        return StaticWordLibrary.DEFAULT;
    }

    public abstract String getWord(int idx);

    public abstract String getScrambledWord(int idx);

    public abstract int getSize();

    public abstract boolean isCorrect(int idx, String userGuess);
}
