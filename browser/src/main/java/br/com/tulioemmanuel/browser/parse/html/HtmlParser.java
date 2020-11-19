package br.com.tulioemmanuel.browser.parse.html;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class HtmlParser {

    private static String currentTokenFormingString = null;
    private static Stack<String> currentStack = null;
    private static Stack<String> validationStack = null;
    private static boolean isReadingToken = false;
    public static List<String> tokenStringList = null;

    private static void initializeParser() {
        currentTokenFormingString = new String();
        currentStack = new Stack<String>();
        validationStack = new Stack<String>();
        isReadingToken = false;
        tokenStringList = new ArrayList<String>();
    }

    private static void readFile(File htmlFile) {
        try (Reader reader = new FileReader(htmlFile)) {
            char c;
            int i;
            do {
                i = reader.read();
                c = (char) i;
                try {
                    formTokenString(c);
                } catch (Exception e) {
                    System.err.println(e);
                }
            } while (i != -1);

            reader.close();

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static void formTokenString(char c) throws Exception {
        if (c == '<' && !isReadingToken) {
            isReadingToken = true;
        } else if (c == '/' && isReadingToken) {
            currentStack.push(currentTokenFormingString);
            currentTokenFormingString = "";
            currentTokenFormingString += c;
        } else if (c == '>' && isReadingToken) {
            isReadingToken = false;
            currentStack.push(currentTokenFormingString);
            if (currentTokenFormingString.charAt(0) == '/')
                validationStack.push(currentTokenFormingString.substring(1));
            else
                validationStack.push(currentTokenFormingString);
            currentTokenFormingString = new String();
        } else {
            currentTokenFormingString += c;
        }
    }

    private static boolean validateTagPairs() {

        Iterator<String> stackIt = validationStack.iterator();
        Map validationMap = new HashMap<String, Integer>();
        while (stackIt.hasNext()) {
            String key = stackIt.next();
            if (validationMap.get(key) == null) {
                validationMap.put(key, 1);
            } else {
                validationMap.put(key, (Integer) validationMap.get(key) + 1);
            }
        }
        
        Iterator<Map.Entry<String, Integer>> mapIt = validationMap.entrySet().iterator();
        while (mapIt.hasNext()) {
            Map.Entry<String, Integer> entry = mapIt.next();
            if(entry.getValue() % 2 != 0)return false;
        }

        return true;
    }

    public static Stack<String> getHTMLStackFromFile(File file) throws Exception {

        /* TODO(tulio) - Da pau se o fonte tiver LF CR ou espaços */

        initializeParser();

        if (file == null)
            throw new Exception("No input HTML File");
        readFile(file);
        boolean isValid = validateTagPairs();
        if (!isValid)
            throw new Exception("Invalid HTML File");
            
        return currentStack;
    }
}
