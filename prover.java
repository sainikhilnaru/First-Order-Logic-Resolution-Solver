
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prover {


    public static void main(String[] args) {
        problems p = new problems();
        String howling = p.howling;
        String rr = p.rr;
        String customs = p.customs;
        String harmonia = p.harmonia;
        String myOwnTheorom = p.myOwnTheorom;

        //problems

        two_pointer(howling,6);
        //two_pointer(customs,7);
        //two_pointer(harmonia,7);
        //two_pointer(myOwnTheorom,7);
        //two_pointer(rr,7);






//        for(int i=1; i<=8; i++){
//            for(int j=1; j<=8; j++ ) {
//                System.out.println("Doing "+ i+ " and "+j);
//                s.resesolve2clauses(debugTheorom.get(i), debugTheorom.get(j));
//            }
//        }

    }

    static void two_pointer(String problem, int pt2){
        ParseListExpression pp = new ParseListExpression();
        HashMap<Integer, ArrayList<ArrayList<FunctionConstantVariable>>> debugTheorom = pp.parseLispTheorom(problem);
        debugTheorom.entrySet().forEach(entry->{
            String s = entry.getValue().toString();
            System.out.println(entry.getKey() + " " + s);
        });
        Unifier s= new Unifier(debugTheorom);
        s.fullResolutionSteps(debugTheorom,pt2);
    }


}
