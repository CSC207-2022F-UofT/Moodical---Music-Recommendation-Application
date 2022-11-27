package entitiestests;

import Entities.questionPool;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class QuestionPoolTest {
    questionPool qPool;
    String[] exampleStringArray;

    // before each is a method that runs before every test
    @BeforeEach
    void createExampleData() {
        qPool = new questionPool();
        exampleStringArray = new String[]{
                "I am feeling optimistic about life at the moment",
                " My energy levels are adequate today",
                "My social battery is strong today",
                " My self-esteem is doing alright",
                " I have someone to talk to when I need it"};
        qPool.setRandQ(exampleStringArray);

    }

    // tags for tests themselves
    @Test
    void getRandQues(){
        assertEquals(qPool.getRandQ(), exampleStringArray);
    }


    // after each method happens after every test
    @AfterEach
    void testMessage(){
        System.out.println("Test Completed");
    }
}