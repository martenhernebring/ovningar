package se.hernebring.inlamning4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SymbolFrequencyTable {

    private Map<Character, Integer> symbolFrequencyTable = new HashMap<>();;

    @Override
    public String toString() {
        var tableBuilder = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        for (Map.Entry<Character, Integer> entry : symbolFrequencyTable.entrySet()) {
            tableBuilder.append(entry.getKey() + ": " + entry.getValue() + newLine);
        }
        return tableBuilder.toString();
    }

    public SymbolFrequencyTable(Collection<String> textCollection) {
        addSymbolCount(textCollection);
    }

    public void addSymbolCount(Collection<String> textCollection) {
        for (String textUnit : textCollection) {
            addSymbolCount(textUnit);
        }
    }

    public void addSymbolCount(String anyText) {
        String[] symbolWords = anyText.split("\\s+");
        addSymbolCount(symbolWords);
    }

    public void addSymbolCount(String[] symbolWords) {
        for (String word : symbolWords) {
            addSymbolCount(word.toCharArray());
        }
    }

    public void addSymbolCount(char[] symbols) {
        for (char symbol : symbols) {
            addSymbolCount(symbol);
        }
    }

    public void addSymbolCount(char symbol) {
        if (!Character.isWhitespace(symbol)) {
            addSymbol(symbol);
        } else {
            throw new IllegalArgumentException("Only symbols are counted. No white spaces.");
        }
    }

    //1 (integer) looks too much like l (variable)
    private static final int ONE = 1;

    private void addSymbol(char symbol) {
        if (symbolFrequencyTable.containsKey(symbol)) {
            symbolFrequencyTable.put(symbol, symbolFrequencyTable.get(symbol) + ONE);
        } else {
            symbolFrequencyTable.put(symbol, ONE);
        }
    }

}
