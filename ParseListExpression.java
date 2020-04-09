import java.util.ArrayList;
import java.util.HashMap;

public class ParseListExpression {

    public HashMap<Integer,ArrayList<ArrayList<FunctionConstantVariable>>> parseLispTheorom(String theorom){
        HashMap<Integer,ArrayList<ArrayList<FunctionConstantVariable>>> clauseList= new HashMap<>();
        ArrayList<FunctionConstantVariable> positiveListTotal = new ArrayList<>();
        ArrayList<FunctionConstantVariable> negativeListTotal = new ArrayList<>();

        int counterp = 0;
        int increntivevalue=1;
        int clauseNumber=0;
        int start=0;
        int startConstant=0;
        FunctionConstantVariable funClass=new FunctionConstantVariable();
        boolean constant =false;
        boolean positive=true;
        while(counterp!=1) {
            String Subvalue = theorom.substring(increntivevalue, increntivevalue + 1);
            if (Subvalue.equals("(")) {
                counterp--;
                if (counterp == -2) {
                    increntivevalue++;
                    clauseNumber = Integer.parseInt(theorom.substring(increntivevalue, increntivevalue + 1));
                } else if (counterp == -4) {
                    start = increntivevalue+1;

                }else if(counterp == -5){
                    startConstant=increntivevalue+1;
                    constant=true;
                }
            } else if (Subvalue.equals(")")) {
                counterp++;
                if (counterp == -3) {
                    if(!constant){
                        funClass.addVariable(theorom.substring(start, increntivevalue));
                    }
                    constant=false;
                    if (positive) {

                        positiveListTotal.add(funClass);
                        funClass= new FunctionConstantVariable();
                    }
                    else {
                        negativeListTotal.add(funClass);
                        funClass= new FunctionConstantVariable();
                    }
                }
                if (counterp == -2) {
                    if (positive) {
                        positive = false;
                    } else {
                        ArrayList<ArrayList<FunctionConstantVariable>> posNegList = new ArrayList<>();
                        posNegList.add(positiveListTotal);
                        posNegList.add(negativeListTotal);
                        clauseList.put(clauseNumber, posNegList);

                        positive = true;
                        //System.out.println(clauseNumber);
                        //System.out.println(posNegList);
                        positiveListTotal = new ArrayList<>();
                        negativeListTotal = new ArrayList<>();
                    }

                }else if(counterp == -4){
                    funClass.addConstant(theorom.substring(startConstant,increntivevalue));
                }
            } else if (counterp == -2 && Subvalue.equals("n")) {
                if (positive) {
                    positive = false;
                } else {
                    ArrayList<ArrayList<FunctionConstantVariable>> posNegList = new ArrayList<>();
                    posNegList.add(positiveListTotal);
                    posNegList.add(negativeListTotal);
                    clauseList.put(clauseNumber, posNegList);
                    positive = true;
                    //System.out.println(clauseNumber);
                    //System.out.println(posNegList);
                    positiveListTotal = new ArrayList<>();
                    negativeListTotal = new ArrayList<>();
                }
            }else if(Subvalue.equals(" ") && counterp == -4 ){
                if(!funClass.setFunction){
                    funClass.setFunctionName(theorom.substring(start,increntivevalue));
                }else if(!constant){
                    funClass.addVariable(theorom.substring(start,increntivevalue));
                }
                constant=false;
                start=increntivevalue+1;
            }
            increntivevalue++;
        }
        return clauseList;

    }

    HashMap<Integer,ArrayList<ArrayList>> parseConstant( HashMap<Integer,ArrayList<ArrayList>> thm){

        return null;
    }

    StringBuffer makeCapital(String s){
        String str1=s;
        StringBuffer newStr=new StringBuffer(str1);

        for(int i = 0; i < str1.length(); i++) {

            //Checks for lower case character
            if(Character.isLowerCase(str1.charAt(i))) {
                //Convert it into upper case using toUpperCase() function
                newStr.setCharAt(i, Character.toUpperCase(str1.charAt(i)));
            }
            //Checks for upper case character
            else if(Character.isUpperCase(str1.charAt(i))) {
                //Convert it into upper case using toLowerCase() function
                newStr.setCharAt(i, Character.toLowerCase(str1.charAt(i)));
            }
        }
        return newStr;
    }
}
