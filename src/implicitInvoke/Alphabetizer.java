package implicitInvoke;

import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Terence on 30/1/17.
 */
public class Alphabetizer implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Lines lines = (Lines) o;
        Collections.sort(lines.getLines());
    }
}
