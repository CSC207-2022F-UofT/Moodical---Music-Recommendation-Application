package Processors;

import Entities.ReadableFile;

import java.util.ArrayList;
import java.util.Random;

public class QuestionnaireProcessing {
    /**
     * This class has two methods for processing - obtaining the list of questions from Questions.csv and then
     * filtering out this list to obtain 5 questions at random for higher level usage.
     * <p>
     * Final variables are :
     * 1. lst of questions from csv as they don't change
     * 2. questionOutputBoundary named questionOutputs as it doesn't change - these have
     * only 5 questions as opposed to 1.
     */
    public QuestionnaireProcessing(){
    }

    public static ArrayList<String> getRandQues(ReadableFile p, Object filepath) {

        // this method takes from a list of list questions of type string[] and
        // returns a list of 5 random questions which are of type list.
        // the value at chosen index is deleted to avoid repetitions of questions


        ArrayList<String> lst = p.readRows(filepath);
        ArrayList<String> filteredLst = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int randIndex = rand.nextInt(lst.size());
            filteredLst.add(lst.get(randIndex));
            lst.remove(randIndex);
        }
        return filteredLst;
    }

//    public static List<String> get5RandQues(ArrayList<String> lstofQ) {
//
//        // this method takes from a list of list questions of type string[] and
//        // returns a list of 5 random questions which are of type list.
//        // the value at chosen index is deleted to avoid repetitions of questions
//
//        ArrayList<String> filteredLst1 = new ArrayList<>();
//        Random rand1 = new Random();
//        for (int i = 0; i < 5; i++) {
//            int rand1Index = rand1.nextInt(lstofQ.size());
//            filteredLst1.add(lstofQ.get(rand1Index));
//            lstofQ.remove(rand1Index);
//        }
//        return filteredLst1;
//
//    }
}

