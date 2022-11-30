package processortests;

import Entities.ReadableFile;
import Entities.questionPool;
import Processors.CSVFileProcessing;
import Processors.QuestionnaireProcessing;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionnaireProcessingTest {
    ReadableFile p;
    String filepath;

    @BeforeEach
    void createExampleData() {
        filepath = "dataset/questions.csv";
        p = new CSVFileProcessing();

        String exampleQ1 = "I am feeling optimistic about life at the moment";
        String exampleQ2 = " My energy levels are adequate today";
        String exampleQ3 = "My social battery is strong today";
        String exampleQ4 = "My self-esteem is doing alright";
        String exampleQ5 = "I have someone to talk to when I need it";

        questionPool.getRandQ().add(exampleQ1);
        questionPool.getRandQ().add(exampleQ2);
        questionPool.getRandQ().add(exampleQ3);
        questionPool.getRandQ().add(exampleQ4);
        questionPool.getRandQ().add(exampleQ5);

    }

    @Test
    void getRandQuesByQPool() {
        assertEquals(QuestionnaireProcessing.get5RandQues(questionPool.lstOfQs).size(), 5);
    }

    @Test
    void getRandQuesByReadable(){
        assertEquals(QuestionnaireProcessing.getRandQues(p, filepath).size(), 5);

    }

    @AfterEach
    void testMessage(){
        System.out.println("Test Completed");
    }


}
