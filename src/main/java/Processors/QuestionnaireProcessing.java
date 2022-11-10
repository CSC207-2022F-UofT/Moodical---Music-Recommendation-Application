package Processors;


import Entities.Readable;
import Entities.Recommendable;
import Entities.Writeable;
import Entities.questionPool;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QuestionnaireProcessing implements Readable, Writeable{
    // 5 random questions is generated from QuestionPool for questionnaire
    // processing talks to question pool

    public static ArrayList<String> getRandQues(Readable questPool) {
        Random rand = new Random();
        ArrayList<String> newLst = new ArrayList();
        ArrayList<String> lst = ArrayList<String> questPool.readFile();
        for (int i = 0; i < lst.size(); i++) {
            int randomIndex = rand.nextInt(lst.size());
            lst.remove(randomIndex);
            newLst.add(lst.get(randomIndex));
        }
        return (ArrayList<String>) newLst.subList(0, 5);
    }




    @Override
    public void writeFile() {

    }
    // want to read questions csv but how?

//    @Override
//    public ArrayList<String> readFile(String fileName) throws FileNotFoundException {
//        try (Readable reader = OpenCSV(new FileReader(fileName)) {
//        String[] lineInArray;
//        })

//
//    }


    @Override
    public void readFile() {
        // open questions csv
        // read questions csv
        //write questions csv
    }
}

