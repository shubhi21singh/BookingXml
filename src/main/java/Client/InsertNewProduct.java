package Client;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by YATRAONLINE\shubhangi.singh on 11/1/18.
 */
public class InsertNewProduct {
    public static void main(String[] args) throws IOException {
        InsertNewProduct object = new InsertNewProduct();
        String body;
        String completeUrl="http://mo.internals.yatra.com/mo/v1/GST/";
                //"http://127.0.0.1:8082/mo/v1/GST/";
                //"http://192.168.61.73:2498/mo/v1/GST/";
                //"http://172.16.6.15:2498/mo/v1/GST/";
        ArrayList<Integer> union_territories =new ArrayList<>();
        union_territories.add(4);
        union_territories.add(7);
        union_territories.add(25);
        union_territories.add(26);
        union_territories.add(31);
        union_territories.add(34);
        union_territories.add(35);
        for(int i=1;i<38;i++) {
            if (!union_territories.contains(i)) {
                 body = "{\n" +
                        "  \"stateCode\":" + i + " ,\n" +
                        "  \"productName\": \"others\",\n" +
                        "  \"channel\": \"b2b\",\n" +
                        "  \"igstPercent\": 18.0,\n" +
                        "  \"cgstPercent\": 9.0,\n" +
                        "  \"sgstPercent\": 9.0\n" +
                        "}";
            }else{
                 body = "{\n" +
                        "  \"stateCode\":" + i + " ,\n" +
                        "  \"productName\": \"others\",\n" +
                        "  \"channel\": \"b2b\",\n" +
                        "  \"igstPercent\": 18.0,\n" +
                        "  \"cgstPercent\": 9.0,\n" +
                        "  \"utgstPercent\": 9.0\n" +
                        "}";
            }
            object.post(completeUrl,body);
            System.out.println("done");
        }
    }
    public void post(String completeUrl, String body) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(completeUrl);
        httpPost.setHeader("Content-type", "application/json");
        try {
            StringEntity stringEntity = new StringEntity(body);
            httpPost.getRequestLine();
            httpPost.setEntity(stringEntity);
            httpClient.execute(httpPost);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
