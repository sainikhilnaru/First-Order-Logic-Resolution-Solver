

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Unifier {
    HashMap<Integer, ArrayList<ArrayList<FunctionConstantVariable>>> Clauses;

    public Unifier(HashMap<Integer, ArrayList<ArrayList<FunctionConstantVariable>>> Clauses){
        this.Clauses= Clauses;
    }
    public ArrayList<ArrayList<ArrayList<FunctionConstantVariable>>> resesolve2clauses(ArrayList<ArrayList<FunctionConstantVariable>> Clause1, ArrayList<ArrayList<FunctionConstantVariable>> Clause2, int index1, int index2){
        ArrayList<ArrayList<ArrayList<FunctionConstantVariable>>> resolvedclauses= new ArrayList<>();

        ArrayList<FunctionConstantVariable> Clause1LN=Clause1.get(0);
        ArrayList<FunctionConstantVariable> Clause2LN=Clause2.get(1);
        int iteration=0;
        while(iteration!=2) {
            for (FunctionConstantVariable Clause1L : Clause1LN
            ) {
                for (FunctionConstantVariable Clause2L : Clause2LN
                ) {

                    if (Clause1L.function.equals(Clause2L.function) && +
                            Clause1L.variables.size() + Clause1L.constants.size() == Clause2L.variables.size() + Clause2L.constants.size()) {
                        FunctionConstantVariable newFunction = new FunctionConstantVariable();
                        HashMap<String, String> subsitutionVariable = new HashMap<>();
                        HashMap<String, String> subsitutionConstant = new HashMap<>();
                        HashMap<String, String> subsitutionVariabletoConstant = new HashMap<>();

                        newFunction.setFunctionName(Clause1L.function);
                        ArrayList<String> RemovableVariables1 = new ArrayList<>(Clause1L.variables);
                        ArrayList<String> RemovableVariables2 = new ArrayList<>(Clause2L.variables);
                        ArrayList<String> RemovableConstant1 = new ArrayList<>(Clause1L.constants);
                        ArrayList<String> RemovableConstant2 = new ArrayList<>(Clause2L.constants);
                        for (int i = RemovableConstant1.size() - 1; i >= 0; i--) {
                            for (int j = RemovableConstant2.size() - 1; j >= 0; j--) {
                                if (RemovableConstant1.get(i).equals(RemovableConstant2.get(j))) {
                                    newFunction.addConstant(RemovableConstant1.get(i));
                                    RemovableConstant1.remove(i);
                                    RemovableConstant2.remove(j);
                                    break;

                                }
                            }
                        }
                        for (int i = RemovableVariables1.size() - 1; i >= 0; i--) {
                            for (int j = RemovableVariables2.size() - 1; j >= 0; j--) {
                                if (RemovableVariables1.get(i).equals(RemovableVariables2.get(j))) {
                                    newFunction.addVariable(RemovableVariables1.get(i));
                                    RemovableVariables1.remove(i);
                                    RemovableVariables2.remove(j);
                                    break;

                                }
                            }
                        }
                        for (int i = RemovableVariables1.size() - 1; i >= 0; i--) {
                            if (RemovableVariables2.size() == 0)
                                break;
                            newFunction.addVariable(RemovableVariables2.get(0));
                            subsitutionVariable.put(RemovableVariables1.remove(i), RemovableVariables2.remove(0));
                        }
                        for (int i = RemovableConstant1.size() - 1; i >= 0; i--) {
                            if (RemovableConstant2.size() == 0)
                                break;
                            newFunction.addConstant(RemovableConstant2.get(0));
                            subsitutionConstant.put(RemovableConstant1.remove(i), RemovableConstant2.remove(0));
                        }
                        if (RemovableVariables1.size() > RemovableVariables2.size()) {
                            for (int i = RemovableVariables1.size() - 1; i >= 0; i--) {
                                newFunction.addConstant(RemovableConstant2.get(0));
                                subsitutionVariabletoConstant.put(RemovableVariables1.remove(i), RemovableConstant2.remove(0));
                            }
                        } else {
                            for (int i = RemovableVariables2.size() - 1; i >= 0; i--) {
                                newFunction.addConstant(RemovableConstant1.get(0));
                                subsitutionVariabletoConstant.put(RemovableVariables2.remove(i), RemovableConstant1.remove(0));
                            }
                        }
                        System.out.println("Resolving "+index1+ " and "+index2);
                        //System.out.println(newFunction);
                        System.out.println("For Function: "+Clause1L.function+" Replacing Variables: " + subsitutionVariable + ", Replacing Constant: " +
                                subsitutionConstant+", and Replacing Variables to Constant: "+ subsitutionVariabletoConstant);
                        ArrayList<ArrayList<FunctionConstantVariable>> resolveClause = new ArrayList<>();
                        ArrayList<FunctionConstantVariable> temp1= new ArrayList<>();
                        for(FunctionConstantVariable Clause1val: Clause1.get(0)){
                            if(!Clause1val.equals( Clause1L))
                                temp1.add(new FunctionConstantVariable(Clause1val,subsitutionVariable, subsitutionConstant, subsitutionVariabletoConstant));
                        }
                        for(FunctionConstantVariable Clause1val: Clause2.get(0)){
                            if(!Clause1val.equals( Clause1L))
                                temp1.add(new FunctionConstantVariable(Clause1val,subsitutionVariable, subsitutionConstant, subsitutionVariabletoConstant));
                        }
                        ArrayList<FunctionConstantVariable> temp2= new ArrayList<>();
                        for(FunctionConstantVariable Clause2val: Clause2.get(1)){
                            if(!Clause2val.equals( Clause2L))
                                temp2.add(new FunctionConstantVariable(Clause2val,subsitutionVariable, subsitutionConstant, subsitutionVariabletoConstant));
                        }
                        for(FunctionConstantVariable Clause2val: Clause1.get(1)){
                            if(!Clause2val.equals( Clause2L))
                                temp2.add(new FunctionConstantVariable(Clause2val,subsitutionVariable, subsitutionConstant, subsitutionVariabletoConstant));
                        }
                        resolveClause.add(temp1);
                        resolveClause.add(temp2);
                        resolvedclauses.add(resolveClause);
                        //System.out.println(resolveClause);

                    }
                }
            }
            Clause1LN=Clause2.get(0);
            Clause2LN=Clause1.get(1);
            iteration++;
        }
        return resolvedclauses;
    }
    HashMap<Integer,ArrayList<ArrayList<FunctionConstantVariable>>> fullResolutionSteps(HashMap<Integer,ArrayList<ArrayList<FunctionConstantVariable>>> theorom, int pt2){
        HashMap<Integer,ArrayList<ArrayList<FunctionConstantVariable>>> AllResolutionSteps = theorom;
        int pointerOneClauseNumber = 1;
        int pointerTwoClauseNumber = pt2;
        int newClauseNumber = theorom.size();
        ArrayList<ArrayList<FunctionConstantVariable>> pointer1 = theorom.get(pointerOneClauseNumber);
        ArrayList<ArrayList<FunctionConstantVariable>> pointer2 = theorom.get(pointerTwoClauseNumber);
        //System.out.println("pointer 1 -: " + pointer1 + "pointer 2 : - " + pointer2);
        AtomicInteger iteration= new AtomicInteger();
        while (pointerTwoClauseNumber <= AllResolutionSteps.size()) {

            ArrayList<ArrayList<ArrayList<FunctionConstantVariable>>> resClauses = resesolve2clauses(theorom.get(pointerOneClauseNumber), theorom.get(pointerTwoClauseNumber), pointerOneClauseNumber, pointerTwoClauseNumber);

            boolean end=false;
            for (int j = 0; j < resClauses.size(); j++) {
                int finalJ = j;
                boolean duplicateFound=false;
                for (Map.Entry<Integer, ArrayList<ArrayList<FunctionConstantVariable>>> entry : AllResolutionSteps.entrySet()) {
                    if (entry.getValue().equals(resClauses.get(finalJ))) {
                        System.out.println("Duplicate Removed : " + resClauses.get(finalJ));
                        duplicateFound=true;
                        break;
                    }


                }
                if(duplicateFound)
                    continue;
                newClauseNumber++;
                System.out.println(newClauseNumber + " : " + resClauses.get(j));
                AllResolutionSteps.put(newClauseNumber, resClauses.get(j));
                iteration.getAndIncrement();
                if( resClauses.get(j).get(0).isEmpty() && resClauses.get(j).get(1).isEmpty()) {
                    end=true;
                    break;
                }
            }
            if(end){
                break;
            }


            pointerOneClauseNumber++;
            if (pointerOneClauseNumber == pointerTwoClauseNumber) {
                pointerTwoClauseNumber++;
                pointerOneClauseNumber = 1;
            }

        }
        System.out.println("Iterations: "+AllResolutionSteps.size());

        return AllResolutionSteps;
    }
}