package commandLine;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
//        if(!isAllowed())




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
