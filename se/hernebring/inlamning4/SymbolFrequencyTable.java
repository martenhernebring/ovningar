package se.hernebring.inlamning4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        countSymbolFrequency(textCollection);
    }

    public SymbolFrequencyTable(String textUnit) {
        countSymbolFrequency(textUnit);
    }

    public void countSymbolFrequency(Collection<String> textCollection) {
        for (String textUnit : textCollection) {
            countSymbolFrequency(textUnit);
        }
    }

    final static Logger logger = LoggerFactory.getLogger(SymbolFrequencyReader.class);

    public void countSymbolFrequency(String textUnit) {
        logger.debug("Text before split: " + textUnit);
        String[] words = textUnit.split("\\s+");
        logger.debug("Text after split: " + words);
        countIfAnySymbol(words);
    }

    private void countIfAnySymbol(String[] words) {
        if (words != null && words.length > 0) {
            countSymbolFrequency(words);
        } else {
            throw new IllegalArgumentException("Text has no symbols and is blank!");
        }
    }

    private void countSymbolFrequency(String[] words) {
        for (String word : words) {
            if (word.isBlank()) {
                continue;
            } else {
                countSymbolFrequency(word.toCharArray());
            }
        }
    }

    private void countSymbolFrequency(char[] symbols) {
        for (char symbol : symbols) {
            countSymbolFrequency(symbol);
        }
    }

    // 1 (integer) looks too much like l (variable)
    private static final int ONE = 1;

    private void countSymbolFrequency(char symbol) {
        if (symbolFrequencyTable.containsKey(symbol)) {
            symbolFrequencyTable.put(symbol, symbolFrequencyTable.get(symbol) + ONE);
        } else {
            symbolFrequencyTable.put(symbol, ONE);
        }
    }

}
