/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProduitForm;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ramandimbinirina
 */
public class dataProduit {    
    
    
    public JsonArray getAllData(){
        JsonArray jA = new JsonArray();
        try{
            URL endpoint = new URL("http://localhost/PhpProject1/read.php");
            HttpURLConnection connexion = (HttpURLConnection) endpoint.openConnection();
            connexion.setRequestMethod("GET");
            connexion.connect();
            Gson gson = new Gson();
            InputStreamReader reader= new InputStreamReader(connexion.getInputStream());
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connexion.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            // Parse the JSON content
            jA= gson.fromJson(response.toString(), JsonArray.class);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return jA;
    }
    
    public String sendData(String data) {
        try {
            URL url = new URL("http://localhost/PhpProject1/create.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            
            // Set the content type
            connection.setRequestProperty("Content-Type", "application/json");

            
            // Get the output stream of the connection and write the data
            try (OutputStream os = connection.getOutputStream()) {
                os.write(data.getBytes(StandardCharsets.UTF_8));
                System.out.println(os);
            }
            
            // Read the response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // If successful, return "ok"
                //this.getAllData();
                return "ok";
                
            } else {
                // If not successful, return error message
                return "Error: " + responseCode;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    
    public String deleteData(String data) {
        try {
            // Create a URL object for your delete endpoint
            URL url = new URL("http://localhost/PhpProject1/delete.php");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST"); // Using POST method for deleting data
            connection.setDoOutput(true);

            // Set the content type
            connection.setRequestProperty("Content-Type", "application/json");

            // Get the output stream of the connection and write the data
            try (OutputStream os = connection.getOutputStream()) {
                os.write(data.getBytes(StandardCharsets.UTF_8));
            }

            // Read the response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // If successful, return "ok"
                return "ok";
            } else {
                // If not successful, return error message
                return "Error: " + responseCode;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    
    public String editData(String data) {
        try {
            URL url = new URL("http://localhost/PhpProject1/update.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            
            // Set the content type
            connection.setRequestProperty("Content-Type", "application/json");

            
            // Get the output stream of the connection and write the data
            try (OutputStream os = connection.getOutputStream()) {
                os.write(data.getBytes(StandardCharsets.UTF_8));
                System.out.println(os);
            }
            
            // Read the response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // If successful, return "ok"
                this.getAllData();
                return "ok";
                
            } else {
                // If not successful, return error message
                return "Error: " + responseCode;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    
}
