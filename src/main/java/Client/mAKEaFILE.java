package Client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by YATRAONLINE\shubhangi.singh on 13/2/18.
 */
public class mAKEaFILE {

    public static void main(String args[]) {
        String csvFile = "/home/shubhangi.singh/bookling_funnel_issues/updationBookingMaster.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "#";
        String finalXml="";

        try {
            br = new BufferedReader(new FileReader(csvFile));
        } catch (FileNotFoundException e) {

        }
        try {
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] superPNR = line.split(cvsSplitBy);
                //String email = superPNR[0];
                //String firstName = superPNR[1];
                //String lastName = superPNR[2];
               // String mobile = superPNR[1];
                String client_id=superPNR[2];
                String ybooking_ref=superPNR[0];
                String email=superPNR[0];
                finalXml=finalXml+"update booking_master set client_id="+client_id+" where ybooking_ref='"+ybooking_ref+"'\n";
                //"insert into client_master(email,mobile,company_id) values('"+email+"','"+mobile+"','YT')\n";
        }
            try {

                PrintStream out = new PrintStream(
                        new FileOutputStream("/home/shubhangi.singh/Desktop/updateBookingMasterScript.txt"));
                System.out.println("file created");
                out.print(finalXml);
            } catch (IOException e) {

            } catch (RuntimeException re) {
            }
        }catch(IOException e){

        }

    }

}
