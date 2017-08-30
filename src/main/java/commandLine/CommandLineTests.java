package commandLine;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.log4j.Logger;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Meyttt on 15.08.2017.
 */
/*
Вывод даты/дня недели, с приветствием или без
 */
public class CommandLineTests {

    static final String greetingOption = "gr";
    static final String typeOption = "type";
    static String[] realArgs;
    public static void main(String[] args) throws Exception {
        System.setProperty("file.encoding","windows-1251");
        List<Argument> expected = new LinkedList<Argument>();
        expected.add(new Argument(greetingOption,new HashSet<String>(Arrays.asList(new String[]{"true","false"}))));
        expected.add(new Argument(typeOption,new HashSet<String>(Arrays.asList(new String[]{"date","day"}))));
        Argument.compareLists(Argument.parseLine(args),expected);
        List<Argument> argumentList = Argument.parseLine(args);
        StringBuilder stringBuilder = new StringBuilder();
        for (Argument argument:argumentList){
            switch (argument.getName()){
                case (typeOption):
                    switch (argument.getValue()){
                        case ("date"):
                            stringBuilder.insert(0,"Date is: "+ new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
                            break;
                        case("day"):
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(new Date());
                            String date = convertDay(calendar.get(Calendar.DAY_OF_WEEK));
                            stringBuilder.insert(0,"Today is: "+date);
                            break;
                    }
                    break;
                case(greetingOption):
                    switch (argument.getValue()){
                        case ("true"):
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
    static boolean requireArgs(String... required) throws Exception {
        Set<String> missedArgs = new HashSet<String>();
        for(String arg:required){
            if(!(Arrays.asList(realArgs).contains("-"+arg))){
                missedArgs.add(arg);
            }
        }
        if (missedArgs.isEmpty()) {
            return true;
        }else{
            throw new Exception("Необходимо ввести следующие параметры: "+ formatSet(missedArgs));
        }
    }
//    static String formatSet(Set<String> strings){
//        StringBuilder stringBuilder = new StringBuilder();
//        for(String string:strings){
//            if (stringBuilder.length()!=0){
//                stringBuilder.append(", ");
//            }
//            stringBuilder.append(string);
//        }
//        return stringBuilder.toString();
//    }
    static String formatSet(Set<? extends Object> strings){
        StringBuilder stringBuilder = new StringBuilder();
        for(Object object:strings){
            String string=object.toString();
            if (stringBuilder.length()!=0){
                stringBuilder.append(", ");
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
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
    static class Argument{
        private String name;
        private String value;
        Set<String> allowed=null;

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        public Set<String> getAllowed() {
            return allowed;
        }

        public Argument(String name, String value) {
            if(name.charAt(0)=='-'){name=name.replaceFirst("-","");}
            this.name = name;
            this.value = value;
        }

        public Argument(String name, Set<String> allowed) {
            this.name = name;
            this.value = null;
            this.allowed = allowed;
        }

        public Argument(String name) {
            this.name = name;
            this.value=null;
        }

        public static List<Argument> parseLine(String[] lineArgs) throws Exception {
            List<Argument> arguments= new LinkedList<Argument>();
            boolean isMain = false;
            String mainArg = null;
            for(String arg:lineArgs){
                if((arg.charAt(0)=='-')){
                    if(isMain) {
                        if (mainArg != null) {
                            arguments.add(new Argument(mainArg));
                        }

                    }
                    mainArg = arg.replaceFirst("-", "");
                    isMain = true;
                }else {
                    if(!isMain){throw  new Exception("Ошибка парсинга параметров командной строки.");}
                    arguments.add(new Argument(mainArg,arg));
                    isMain=false;
                }
            }
            return arguments;
        }
        public static boolean compareLists(List<Argument> real, List<Argument> expected) throws Exception {
            Set<Argument> valueError= new HashSet<Argument>();
            Set<Argument> nameError= new HashSet<Argument>();
            loop:
            for(Argument eArgument:expected){
                for(Argument rArgument:real){
                    if (eArgument.getName().equals(rArgument.getName())){
                        if(eArgument.getAllowed()!=null){
                            if(!eArgument.getAllowed().contains(rArgument.value)){
                                valueError.add(rArgument);
                            }else {continue loop;}
                        }
                    }
                }
                nameError.add(eArgument);
            }
            StringBuilder stringBuilder = new StringBuilder();
            if(valueError.isEmpty()){
                if (nameError.isEmpty()){
                    return true;
                }else {
                    stringBuilder.append("Ошибка параметров командной строки: необходимо задать параметры: "+formatSet(nameError));
                }
            }else {
                if (!(stringBuilder.length()==0)){
                    stringBuilder.append("\n");
                }
                stringBuilder.append("Ошибка параметров командной строки: неверные значения параметров: "+formatSet(valueError));
            }
            throw new Exception(stringBuilder.toString());
        }
        @Override
        public String toString(){return this.getName();}
    }


}

