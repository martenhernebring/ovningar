package se.hernebring.repetition2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharacterFrequencyFromList {

    static String mostOf(List<String> textLines, char ch){
        String mostFrequent = null;
        int occurencies = 0;
        int counter = 0;
        for(String textLine : textLines){
            for(char oneChar : textLine.toCharArray()){
                if(oneChar == ch){
                    counter++;
                }
            }
            if (counter > occurencies){
                occurencies = counter;
                mostFrequent = textLine;
            }
            counter = 0;
        }
        return mostFrequent;
    }
    public static void main(String[] args) {
        String[] textLines = {"Hoppsan.", "Vem kommer hem klockan fem?","Hello everybody."};
        List<String> textList = new ArrayList<>(Arrays.asList(textLines));
        System.out.println(mostOf(textList,'e'));
    }
}
