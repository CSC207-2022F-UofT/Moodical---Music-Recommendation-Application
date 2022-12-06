package Controllers;

import Boundaries.SongRecInputBoundary;
import Processors.SongAnalysisProcessing;

import java.util.ArrayList;

public class SongRecController {
    SongRecInputBoundary processor;

    public SongRecController(SongRecInputBoundary inputProcessor){
        this.processor = inputProcessor;
    }

    public void generate(ArrayList<Integer> sliderValues){
        int averageScore = 0;
        for(int i = 0; i < sliderValues.size(); i++) {
            averageScore += sliderValues.get(i);
        }
        processor.calculate5Songs(averageScore / 2);
    }
}
