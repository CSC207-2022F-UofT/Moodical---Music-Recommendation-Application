package Entities;/* Below is the Question Pool entity object with its constructor.

 */


//public class questionPool{
//    public String[] lstOfQs;
//
//    public String[] questionPool() {
//    lstOfQs = new String[]{};
//
//    public String[] getRandQ(ArrayList<String> lst)
//        return this.lstOfQs;
//    }
//    public void setRandQ(String[] lst){
//        this.lstOfQs = lst;
//    }
//
//}
public class questionPool{
    private String[] lstOfQ;
    public questionPool(){
        this.lstOfQ = new String[]{};
    }

    public String[] getRandQ(){
        return this.lstOfQ;
    }

    public void setRandQ(String[] lst){
        this.lstOfQ = lst;
    }
}

/*
This class only consists of a list of strings.
We will store and save questions from a csv file using interface which is another doc
 */