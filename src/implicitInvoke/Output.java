package implicitInvoke;// import SD_DataRepn.SD_Characters;

/**
 * Created by Llednar on 29/1/17.
 */
public class Output {
    // private SD_Characters storage;
    private Lines lines;

    public Output(Lines lines) {
        this.lines = lines;
    }

    public String run() {
        String result = "";
        for (String line : lines.getLines()) {
            result += line + "\n";
        }
        return result;
    }

}
