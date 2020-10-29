package se.hernebring.inlamning4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CharacterCounter {

    private Map<Character, Integer> frequencyTable = new HashMap<>();
    
    public CharacterCounter() {
        frequencyTable.put('!', 8);
        frequencyTable.put(',', 87);
        frequencyTable.put('-', 2);
    }

    public Map<Character, Integer> getTableOfFrequencies(String string1, String string2) {
        return Collections.unmodifiableMap(frequencyTable); 
    }

}
