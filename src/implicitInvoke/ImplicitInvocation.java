package implicitInvoke;

import java.util.ArrayList;

/**
 * Created by Terence on 30/1/17.
 */
public class ImplicitInvocation {
    private Lines lineBuffer;
    private Lines shiftedLines;
    private CircularShift shifter;
    private Alphabetizer sorter;
    private Output output;

    public ImplicitInvocation() {
        lineBuffer = new Lines();
        shiftedLines = new Lines();
        shifter = new CircularShift(shiftedLines);
        sorter = new Alphabetizer();
        output = new Output(shiftedLines);

        lineBuffer.addObserver(shifter);
        shiftedLines.addObserver(sorter);
    }


    public String run(ArrayList<String> inputText, ArrayList<String> outputText) {

        shifter.setIgnoreWords(outputText);

        for (int i=0; i<inputText.size(); i++) {
            lineBuffer.insert(inputText.get(i));
        }

        // storage.printShiftedLines();
        return output.run();
    }

}
