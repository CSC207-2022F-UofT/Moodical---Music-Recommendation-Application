package responsetests;

import Entities.ReadableFile;
import Processors.CSVFileProcessing;
import ResponseModels.QuestionnaireResponseModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionnaireResponseModelTest{
    ReadableFile p;
    String filepath;
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



    @AfterEach
    void testMessage(){
        System.out.println("Test Completed");
    }
}

