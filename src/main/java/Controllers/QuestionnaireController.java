package Controllers;
import Processors.QuestionnaireProcessing;

import Entities.Readable;
import Entities.Recommendable;
import Entities.Writeable;

import java.util.ArrayList;

public class QuestionnaireController implements Recommendable, Readable, Writeable {
    // generates questionnaire via readable/writeable
    Readable questions ;
    public static ArrayList<String> doneGeneration{

    }

    public QuestionnaireController(Readable questions) {
        this.questions = questions;
    }

    @Override
    public ArrayList<String> recommend() {
        return null;
    }

    @Override
    public void readFile() {

    }

    @Override
    public void writeFile() {

    }
}
