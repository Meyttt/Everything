package commandLine;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Meyttt on 16.08.2017.
 */
public class CommandLine2 {
    static final String greetingOption = "gr";
    static final Set<String> greetingAllowed = new HashSet<>(Arrays.asList("true","false"));
    static final String typeOption = "type";
    static final Set<String> typeAllowed = new HashSet<>(Arrays.asList("day","date"));
    public static void main(String[] args) throws Exception {
        Option greeting = new Option(greetingOption,true,"Включение/отключение приветствия(true/false)");
        greeting.setRequired(true);
        Option type = new Option(typeOption, true, "Выбор представления времени - дата/ день недели(date/day");
        type.setRequired(true);
        Options options = new Options();
        options.addOption(greeting);
        options.addOption(type);
        CommandLine commandLine = new BasicParser().parse(options,args);
        getMessage(commandLine);





    }
    static void getMessage(CommandLine commandLine){
        StringBuilder stringBuilder = new StringBuilder();
        for (Option option:commandLine.getOptions()){
            switch (option.getOpt()){
                case (typeOption):
                    switch (option.getValue()){
                        case ("date"):
                            stringBuilder.insert(0,"Date is: "+ new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
                            break;
                        case("day"):
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(new Date());
                            String date = convertDay(calendar.get(Calendar.DAY_OF_WEEK));
                            stringBuilder.insert(0,"Today is "+date);
                            break;
                    }
                    break;
                case(greetingOption):
                    switch (option.getValue()){
                        case("true"):
                            stringBuilder.append("\nHave a good day, dear :)");
                            break;
                        case ("false"):
                            stringBuilder.append("\nThat's all.");
                            break;
                    }
            }
        }
        System.out.println(stringBuilder.toString());
    }
    static String convertDay(int day){
        switch (day){
            case(1):return "Sunday";
            case(2):return "Monday";
            case(3):return "Tuesday";
            case(4):return "Wednesday";
            case(5):return "Thursday";
            case(6):return "Friday";
            case(7):return "Saturday";
            default:return "Are you serious?";

        }
    }
    static boolean isAllowed (Option option, Set<String> allowed){
        if(allowed.contains(option.getValue())){
            return true;
        }
        return false;
    }



//        for (String arg: args){
//            System.out.println(arg);
//        }
//        requireArgs(typeOption,greetingOption);
}
