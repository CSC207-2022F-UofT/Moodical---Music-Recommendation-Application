package responsetests;

import Entities.ReadableFile;
import Entities.questionPool;
import Processors.CSVFileProcessing;
import Processors.QuestionnaireProcessing;
import ResponseModels.QuestionnaireResponseModel;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionnaireResponseModelTest{
    ReadableFile p;
    String filepath;
    ArrayList<String> example_array;
    ArrayList<String> fiveQs;
    QuestionnaireResponseModel response;

    @BeforeEach
    void createExampleData(){
    filepath = "dataset/questions.csv";
    p = new CSVFileProcessing();
    fiveQs = new ArrayList<>();
    response = new QuestionnaireResponseModel();
    }
    @Test
    void getRandQs() {
        assertEquals(response.getRandQs(), response.fiveQs);
    }




}

