package ResponseModels;

import Entities.ReadableFile;
import Processors.CSVFileProcessing;
import Processors.QuestionnaireProcessing;

import java.util.ArrayList;

public class QuestionnaireResponseModel {
    /**
     * This class stores 5 random questions from questions csv file.
     * This class consists of setters and getters to update and store the
     * 5 questions.
     */
    ReadableFile q = new CSVFileProcessing();
    Object filepath = "dataset/questions.csv";
    public ArrayList<String> fiveQs;

    public QuestionnaireResponseModel() {
        fiveQs = QuestionnaireProcessing.getRandQues(q, filepath);
    }

    public ArrayList<String> getRandQs() {

        return fiveQs;
    }

    public void setRandQs(ArrayList<String> fiveQs) {
        this.fiveQs = fiveQs;

    }


}
