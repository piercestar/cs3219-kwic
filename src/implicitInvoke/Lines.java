package implicitInvoke;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Terence on 30/1/17.
 */
public class Lines extends Observable {
    private ArrayList<String> lines = new ArrayList<>();

    public void insert(String newLine) {
        lines.add(newLine);
        setChanged();
        notifyObservers();
    }

    public String peek() {
        return lines.get(lines.size()-1);
    }

    public ArrayList<String> getLines() {
        return lines;
    }
}
