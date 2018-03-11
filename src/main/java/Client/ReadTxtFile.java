package Client;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadTxtFile {

    public static String readTextFile(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        return content;
    }
    public static String finalText(String fileName) throws IOException{
        String text = readTextFile(fileName);
        String singleLine;
        String finalString="";
        while(true) {
            singleLine="";
            Pattern pattern = Pattern.compile("<Doc>.*</BookingRef>", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                singleLine = singleLine + matcher.group(0);
            }

            pattern = Pattern.compile("<Code>ERROR</Code>");
            matcher = pattern.matcher(text);
            if (matcher.find()) {
                Pattern pattern1 = Pattern.compile("<Message>.*</Message>", Pattern.CASE_INSENSITIVE);
                Matcher matcher1 = pattern1.matcher(text);
                if (matcher1.find())
                    singleLine = singleLine + matcher1.group(0)+"\n";
                text = text.substring(text.indexOf(matcher1.group(0)) + matcher1.group(0).length());
            }
            else{
                break;
            }
            finalString=finalString+singleLine;
        }
        return finalString;
    }
    public static void main(String args[]) throws IOException{
        File write_file = new File("/home/shubhangi.singh/mo/BookingXml/src/test/resources/write_file");
        final File folder = new File("/home/shubhangi.singh/Downloads/Dec/");
//        String file1 = "/home/shubhangi.singh/mo/BookingXml/src/main/resources/file1";
//        String file2 = "/home/shubhangi.singh/mo/BookingXml/src/main/resources/file2";
//        String file3 = "/home/shubhangi.singh/mo/BookingXml/src/main/resources/file3";
//        String file4 = "/home/shubhangi.singh/mo/BookingXml/src/main/resources/file4";
//        String file5 = "/home/shubhangi.singh/mo/BookingXml/src/main/resources/file5";
        File[] listOfFiles = folder.listFiles();
        String finalTxt="";
        for (int i = 0; i < listOfFiles.length; i++) {
            finalTxt = finalTxt + finalText(listOfFiles[i].getAbsolutePath());
        } //String finalTxt =finalText(file1)+finalText(file2)+finalText(file3)+finalText(file4)+finalText(file5);
            FileUtils.writeStringToFile(write_file, finalTxt);

        // File[] fList = directory.listFiles();
        }
        //for (File file : fList){

         //   String f = finalText(directory.getName());
        //System.out.println(f);
}
