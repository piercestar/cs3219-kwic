package implicitInvoke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Terence on 30/1/17.
 */
public class CircularShift implements Observer {
    private Lines shiftedLines;
    private ArrayList<String> ignoreWords = new ArrayList<>();

    public CircularShift(Lines shiftedLines) {
        this.shiftedLines = shiftedLines;
    }

    public void setIgnoreWords(ArrayList<String> ignoreWords) {
        this.ignoreWords = ignoreWords;
    }

    @Override
    public void update(Observable o, Object arg) {
        Lines lines = (Lines) o;
        String[] words = lines.peek().split(" ");
        ArrayList<String> shift = new ArrayList<>(Arrays.asList(words));

        for (int i=0; i<words.length; i++) {
            shift.add(shift.remove(0));   // remove the first element and add it to the back
            if (!isIgnoreWord(shift.get(0))) {
                shiftedLines.insert(array2Line(shift));   // store this shifted title
            } else {
                // do nothing
            }
        }
    }

    private String array2Line(ArrayList<String> array) {
        String line = "";
        for (int i=0; i<array.size() - 1; i++) {
            line += array.get(i) + " ";
        }
        return line + array.get(array.size()-1);
    }

    private boolean isIgnoreWord(String word) {
        return ignoreWords.contains(word);
    }
}
