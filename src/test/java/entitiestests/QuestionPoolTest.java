package entitiestests;

import Entities.questionPool;
import org.junit.jupiter.api.*;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class QuestionPoolTest {
    ArrayList<String> exampleStringArray;

    // before each is a method that runs before every test
    @BeforeEach
    void createExampleData(){
        ArrayList<String> exampleStringArray = new ArrayList<>();
        exampleStringArray.add("I am feeling optimistic about life at the moment");
        exampleStringArray.add(" My energy levels are adequate today");
        exampleStringArray.add("My social battery is strong today");
        exampleStringArray.add(" My self-esteem is doing alright");
        exampleStringArray.add(" I have someone to talk to when I need it" );

        questionPool.setRandQ(exampleStringArray);
    }

    // tags for tests themselves
    @Test
    void getLstOfQs(){
        questionPool.setRandQ(exampleStringArray);
        assertEquals(questionPool.getRandQ(),
                exampleStringArray);
    };


    // after each method happens after every test
    @AfterEach
    void testMessage(){
        System.out.println("Test Completed");
    }
}