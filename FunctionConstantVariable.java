//import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.HashMap;

public class FunctionConstantVariable {
    public ArrayList<String> variables;
    public ArrayList<String> constants;
    public String function;
    public Boolean setFunction;
    public FunctionConstantVariable(){
        function="";
        setFunction=false;
        variables=new ArrayList<>();
        constants= new ArrayList<>();
    }
    public FunctionConstantVariable(FunctionConstantVariable copy, HashMap<String, String> subsitutionVariable,
                                    HashMap<String, String> subsitutionConstant, HashMap<String, String> subsitutionVariabletoConstant){
        function=copy.function;
        setFunction=true;
        variables=new ArrayList<>(copy.variables);
        constants=new ArrayList<>(copy.constants);
        for(int i=0; i<constants.size();i++) {
            if (subsitutionConstant.containsKey(constants.get(i))) {
                constants.set(i, subsitutionConstant.get(constants.get(i)));
            }
        }
        for(int i=variables.size()-1; i>=0;i--){
            if(subsitutionVariable.containsKey(variables.get(i))){
                variables.set(i, subsitutionVariable.get(variables.get(i)));
            }else if(subsitutionVariabletoConstant.containsKey(variables.get(i))){

                constants.add(subsitutionVariabletoConstant.get(variables.get(i)));
                variables.remove(i);
            }
        }

    }
    public void setFunctionName(String name){
        setFunction=true;
        function=name;
    }
    public void addVariable(String variable){
        variables.add(variable);
    }
    public void addConstant(String constant){
        constants.add(constant);
    }
    public String toString() {
        if(constants.size() == 1) {
            String s = "( " + function + " " +
                    variables.toString().substring(1, variables.toString().length() - 1) +
                    " " + "( " + constants.toString().substring(1, constants.toString().length() - 1) + ")"
                    + ")";
            return s;

        }else if(constants.size() == 2) {
            String s = "(" + function + " ( " +
                    constants.get(0) + " ) " + "(" + constants.get(1) + " ) "+
                    " " + variables.toString().substring(1, variables.toString().length() - 1)
                    + ")";
            return s;
        }
        else {
            String s = "( " + function + " " +
                    variables.toString().substring(1, variables.toString().length() - 1) +
                    " " + constants.toString().substring(1, constants.toString().length() - 1)
                    + ")";
            return s;
        }
        //return "Function name: "+ function +", Variables: "+ variables.toString()+", Constants: "+constants ;

    }
    public boolean equals(FunctionConstantVariable copy){
        if(function.equals(copy.function)){
            if(variables.size()==copy.variables.size() && constants.size()==copy.constants.size()){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!FunctionConstantVariable.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final FunctionConstantVariable copy = (FunctionConstantVariable) obj;
        if(function.equals(copy.function)){
            return variables.size() == copy.variables.size() && constants.size() == copy.constants.size();
        }
        return false;


    }

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
//        hash = 53 * hash + this.age;
//        return hash;
//    }

}
