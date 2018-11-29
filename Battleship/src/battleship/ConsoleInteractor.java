package battleship;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;

public class ConsoleInteractor {
    private static final String REGEX_BEGINNING = "^\\s*";
    private static final String REGEX_ENDING = "\\s*$";
    // An elaborate version of the format specified in PROMPT_COORDINATE_ERR.
    public static final String COORDINATE_REGEX =
        REGEX_BEGINNING + "(?<x>[A-J])\\s*(?<y>10|[0-9])" + REGEX_ENDING;
    public static final Pattern COORDINATE_PATTERN =
        Pattern.compile(COORDINATE_REGEX, Pattern.CASE_INSENSITIVE);

    public static final String PLACEMENT_REGEX =
       REGEX_BEGINNING + COORDINATE_REGEX + "\\s*(?<orientation>v|h)"
       + REGEX_ENDING;
    public static final Pattern PLACEMENT_PATTERN =
        Pattern.compile(COORDINATE_REGEX, Pattern.CASE_INSENSITIVE);

    private static final String PROMPT_COORDINATE = "Enter coordinate";    
    private static final String PROMPT_COORDINATE_ERR =
        "Invalid coordinate; must be [A-J][1-10] (w/o brackets).";

    private Scanner input;
    private PrintWriter output;

    // Use InputStream/OutputStream; that way the driver can
    // either work from stdout/stdin or from files.
    public ConsoleInteractor(InputStream in, OutputStream out) {
        this.input = new Scanner(in);
        this.output = new PrintWriter(out);
        output.println("HELLO");
    }

    // Or whatever type/data structure will be used to represent
    // a coordinate on the graph.
    // This method is intended to be general purpose, i.e.,
    // we're not val
    public int promptCoordinate() {
        Matcher inputMatcher = prompt(PROMPT_COORDINATE, PROMPT_COORDINATE_ERR,
            COORDINATE_PATTERN);
        return 0;
    }

    private Matcher prompt(String promptStr, String errStr, Pattern pattern) {
        Matcher ret = null;
        boolean valid = true;

        do {
            ret = pattern.matcher(prompt(promptStr));
            valid = ret.matches();

            if (!valid) {
                output.println(errStr);
            }
        } while (!valid);

        return ret;
    }

    public String prompt(String promptStr) {
        output.print(promptStr + ": ");
        return input.nextLine();
    }
}
