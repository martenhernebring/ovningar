package se.hernebring.inlamning4;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolCounter {

    private Map<Character, Integer> frequencyTable;

    public SymbolCounter() {
        frequencyTable = new HashMap<>();
    }

    public Map<Character, Integer> getReadOnlyTable() {
        return Collections.unmodifiableMap(frequencyTable);
    }

    public void addSymbolCount(List<String> books) {
        for (String book : books) {
            addSymbolCount(book);
        }
    }

    public void addSymbolCount(String book) {
        String[] words = book.split("\\s+");
        addSymbolCount(words);
    }

    public void addSymbolCount(String[] words) {
        for (String word : words) {
            addSymbolCount(word.toCharArray());
        }
    }

    public void addSymbolCount(char[] charArray) {
        for (char ch : charArray) {
            addSymbolCount(ch);
        }
    }

    public void addSymbolCount(char ch) {
        if (!Character.isWhitespace(ch)) {
            addSymbol(ch);
        }
    }

    private static final int ONE = 1;

    private void addSymbol(char symbol) {
        if (frequencyTable.containsKey(symbol)) {
            frequencyTable.put(symbol, frequencyTable.get(symbol) + ONE);
        } else {
            frequencyTable.put(symbol, ONE);
        }
    }

}
