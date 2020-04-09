import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class usefullFunctions {
    String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }
    ArrayList<String> getLiterals(String string) {
        Pattern pattern = Pattern.compile("(\\(((\\w+)\\s?)+\\)\\s?)");
        Matcher matcher = pattern.matcher(string);
        ArrayList<String> Literals = new ArrayList<>();
        if (matcher.find()) {
           // System.out.println(matcher.groupCount());
           // for(int i =0 ; i < matcher.groupCount(); i++){
           //     System.out.println(i);
                Literals.add(matcher.group());
                System.out.println("Start :"+matcher.start()+", End : "+matcher.end()+", Group "+matcher.group());
           // }
        }
        if(string == "nil"){
            Literals.add("nil");
            System.out.println("nil");
        }
        return Literals;
    }


}
