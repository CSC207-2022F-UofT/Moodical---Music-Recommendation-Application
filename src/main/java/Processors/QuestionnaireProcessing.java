package Processors;

import Entities.ReadableFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static jdk.nashorn.internal.runtime.ScriptingFunctions.readLine;

public class QuestionnaireProcessing implements ReadableFile {
    /**
     * This class has two methods for processing - obtaining the list of questions from Questions.csv and then
     * filtering out this list to obtain 5 questions at random for higher level usage.
     *
     * @param args containing processed CSV line from questions.csv
     * @return
     */
    public static ArrayList<String> main (){

    // this method takes the questions csv file and returns list of questions of type String

        String path = "questions.csv";
        String line = "";
        ArrayList<String> questions = new ArrayList<String>();

        try {BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null){
                String[] values = line.split(", ");
                questions.add(readLine(values));
            }

    } catch (FileNotFoundException error) {
            error.printStackTrace();
        } catch (IOException error) {
            error.printStackTrace();
        }
        return questions;
    }

    public static ArrayList<String> getRandQues(ReadableFile p){

        // this method takes from a list of questions of type string and returns a list of 5 random questions.
        // the value at chosen index is deleted to avoid repetitions of questions

        ArrayList<String> lst = p.readFile();
        ArrayList<String> filteredLst = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i <= lst.size(); i++){
            int randIndex = rand.nextInt(lst.size());
            filteredLst.add(lst.get(randIndex));
            lst.remove(randIndex);

        }
        return (ArrayList<String>) filteredLst.subList(0,5);
    }
    @Override
    public ArrayList<String> readFile() {
        return main();
    }



}

