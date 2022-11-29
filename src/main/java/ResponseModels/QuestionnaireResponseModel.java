package ResponseModels;

import Entities.ReadableFile;
import Processors.CSVFileProcessing;
import Processors.QuestionnaireProcessing;

import java.util.ArrayList;

public class QuestionnaireResponseModel{
    /**
     * Have setter and getters for your variable
     * This is the Output Data for 5 questions.
     */
    ReadableFile q = new CSVFileProcessing();
    Object filepath = "dataset/questions.csv";
    public ArrayList<String> fiveQs;

    public QuestionnaireResponseModel(){
        fiveQs = QuestionnaireProcessing.getRandQues(q , filepath);
    }

    public ArrayList<String> getRandQs(){
        /**
         * Returns a list of five random questions in the questionnaire
         */
        return fiveQs;
    }

    public void setRandQs(ArrayList<String> fiveQs) {
        this.fiveQs = fiveQs;
    }


}
