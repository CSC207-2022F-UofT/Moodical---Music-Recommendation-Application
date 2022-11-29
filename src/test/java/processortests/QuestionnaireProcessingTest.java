package processortests;

import Entities.ReadableFile;
import Entities.questionPool;
import Processors.CSVFileProcessing;
import Processors.QuestionnaireProcessing;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionnaireProcessingTest {
    ReadableFile p;
    String filepath;
    ArrayList<String> example_array;
    questionPool qPool;

    @BeforeEach
    void createExampleData() {
        filepath = "dataset/questions.csv";
        p = new CSVFileProcessing();

        String exampleQ1 = "I am feeling optimistic about life at the moment";
        String exampleQ2 = " My energy levels are adequate today";
        String exampleQ3 = "My social battery is strong today";
        String exampleQ4 = "My self-esteem is doing alright";
        String exampleQ5 = "I have someone to talk to when I need it";


        qPool.getRandQ().add(exampleQ1);
        qPool.getRandQ().add(exampleQ2);
        qPool.getRandQ().add(exampleQ3);
        qPool.getRandQ().add(exampleQ4);
        qPool.getRandQ().add(exampleQ5);


        example_array = qPool.lstOfQs;

    }
//    }
//    @Test
//    void getRandQuesByQPool(){
//        assertEquals(QuestionnaireProcessing.get5RandQues(qPool.lstOfQs).size(), example_array.size());
//
//    }
    @Test
    void getRandQuesByReadable(){
        assertEquals(QuestionnaireProcessing.getRandQues(p, filepath).size(), example_array.size());

    }

    @AfterEach
    void testMessage(){
        System.out.println("Test Complete");
    }


}
