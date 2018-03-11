package Client;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringWriter;

/**
 * Created by YATRAONLINE\shubhangi.singh on 19/12/17.
 */
public class GetBookingXml {

    public static void main(String[] args) {

        try
        {
            // create HTTP Client
            HttpClient httpClient = HttpClientBuilder.create().build();
            String s="1612752156338";
            String request = "http://172.16.7.13:3401/hotels-india/hotel-booking/"+s+"/get.htm";
            // Create new getRequest with below mentioned URL
            HttpGet getRequest = new HttpGet(request);
            // Add additional header to getRequest which accepts application/xml data
            // Execute your request and catch response
            HttpResponse response = httpClient.execute(getRequest);

            // Check for HTTP response code: 200 = success
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            StringWriter writer = new StringWriter();
            IOUtils.copy(response.getEntity().getContent(), writer);
            String responseString = writer.toString();
            PrintStream out = new PrintStream(new FileOutputStream(s+".xml"));
            System.out.println("file created");
            out.print(responseString);
            // Simply iterate through XML response and show on console.

        } catch (Exception e)

    {
        e.printStackTrace();
    }
    }
}
