package Controllers;
import Entities.ReadableFile;
import Processors.CSVFileProcessing;
import Processors.QuestionnaireProcessing;
import Presenters.QuestionnairePresenter;
import Entities.ReadableFile;
import Entities.Recommendable;
import Entities.Writeable;

import java.util.ArrayList;

public class QuestionnaireController implements Recommendable, ReadableFile, Writeable {
    // generates questionnaire via readable/writeable
    Readable questions ;
    public static ArrayList<String> doneGeneration{
        if (true){
          //  QuestionnairePresenter();
            // prompts questionnaire presenter to present questionnaire via interface to user
        }


    }

    public boolean QuestionnaireController(String[] x) {
        if (true) {
           // QuestionnairePresenter();
            // prompts questionnaire presenter to present questionnaire via interface to user
            ArrayList<String> p = QuestionnaireProcessing.main(x);
            QuestionnaireProcessing.getRandQues((ReadableFile) p);


        }
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
