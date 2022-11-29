package processortests;

import Entities.ReadableFile;
import Entities.questionPool;
import Processors.CSVFileProcessing;
import Processors.QuestionnaireProcessing;
import Processors.SongAnalysisProcessing;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionnaireProcessingTest {
    ReadableFile p;
    String filepath;
    ArrayList<String> example_array;
    questionPool qPool;
    CSVFileProcessing processFile;

    @BeforeEach
    void createExampleData() {
        String exampleQ1 ="I am feeling optimistic about life at the moment";
        String exampleQ2 = " My energy levels are adequate today";
        String exampleQ3 = "My social battery is strong today";
        String exampleQ4 = "My self-esteem is doing alright";
        String exampleQ5 = "I have someone to talk to when I need it";
        String exampleQ6 = "I have emotional support available around me";
        String exampleQ7 ="14. If I want a hug, I know where to go";
        String exampleQ8 = " I am a walking ray of sunshine";
        String exampleQ9 = "I’m content with myself";
        String exampleq10 = "I’m getting my daily dose of Vitamin C(Sea)";
        String exampleQ11 = "I have enough motivation to get through the day";
        String exampleQ12= "I can assure myself that I will be okay";

        qPool.getRandQ().add(exampleQ1);
        qPool.getRandQ().add(exampleQ2);
        qPool.getRandQ().add(exampleQ3);
        qPool.getRandQ().add(exampleQ4);
        qPool.getRandQ().add(exampleQ5);
        qPool.getRandQ().add(exampleQ6);
        qPool.getRandQ().add(exampleQ7);
        qPool.getRandQ().add(exampleQ8);
        qPool.getRandQ().add(exampleQ9);
        qPool.getRandQ().add(exampleq10);
        qPool.getRandQ().add(exampleQ11);
        qPool.getRandQ().add(exampleQ12);
        example_array = qPool.lstOfQs;

    }
    @Test
    void getRandQues(){
        assertEquals(QuestionnaireProcessing.get5RandQues(qPool.lstOfQs).size(), example_array.size());

    }

    @AfterEach
    void testMessage(){
        System.out.println("Test Complete");
    }


}
