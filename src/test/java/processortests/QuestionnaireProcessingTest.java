package processortests;

import Entities.ReadableFile;
import Processors.CSVFileProcessing;
import Processors.QuestionnaireProcessing;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionnaireProcessingTest {
    /** This test converts questions from the questions csv file into strings
     * and provides 5 random questions for the questionnaire.
     *
     */
    ReadableFile p;
    String filepath;
    @BeforeEach
    void createExampleData() {
        filepath = "dataset/questions.csv";
        p = new CSVFileProcessing();

    }

    @Test
    void getRandQuesByReadable(){
        assertEquals(QuestionnaireProcessing.getRandQues(p, filepath).size(), 5 );

    }

    @AfterEach
    void testMessage(){
        System.out.println("Test Completed");
    }


}
