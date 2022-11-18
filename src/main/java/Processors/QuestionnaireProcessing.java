package Processors;

import Entities.ReadableFile;

import java.util.ArrayList;
import java.util.Random;


public class QuestionnaireProcessing  {
    /**
     * This class has two methods for processing - obtaining the list of questions from Questions.csv and then
     * filtering out this list to obtain 5 questions at random for higher level usage.
     *
     * Final variables are :
     *          1. lst of questions from csv as they don't change
     *          2. questionOutputBoundary named questionOutputs as it doesn't change - these have
     *          only 5 questions as opposed to 1.
     */
//    final questionPool lstOfQuestions;
//    final QuestionnaireOutputBoundary questionOutputs;
//
//    public QuestionnaireProcessing(questionPool lstOfQuestions,
//                                   QuestionnaireOutputBoundary questionOutputs) {
//        /**
//         * Initialises the two final variables
//         */
//        this.lstOfQuestions = lstOfQuestions;
//        this.questionOutputs = questionOutputs;


    public static ArrayList<String> getRandQues(ReadableFile p, Object filepath ) {

        // this method takes from a list of list questions of type string[] and
        // returns a list of 5 random questions which are of type list.
        // the value at chosen index is deleted to avoid repetitions of questions
        /**
         * Gets 5 randomly generated questions from question file
         */

        ArrayList<String> lst = p.readRows(filepath);
        ArrayList<String> filteredLst = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i <= 5; i++) {
            int randIndex = rand.nextInt(lst.size());
            filteredLst.add(lst.get(randIndex));
            lst.remove(randIndex);
        }
        return filteredLst;
    }


}


