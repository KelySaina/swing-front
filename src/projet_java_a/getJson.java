/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_java_a;
import ProduitForm.ModelProduit;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JTable;


/**
 *
 * @author Ramandimbinirina
 */
public class getJson {
    
    public static void main(String[] args){
        try{
            URL endpoint = new URL("http://localhost/PhpProject1/read.php");
            HttpURLConnection connexion = (HttpURLConnection) endpoint.openConnection();
            connexion.setRequestMethod("GET");
            connexion.connect();
            Gson gson = new Gson();
            //InputStreamReader reader= new InputStreamReader(connexion.getInputStream());
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connexion.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }


            // Parse the JSON content
            JsonArray jA = gson.fromJson(response.toString(), JsonArray.class);
            
//            ModelProduit mp = gson.fromJson(reader, ModelProduit.class);
//            System.out.println(mp.getNumProduit());
            
            
            for(JsonElement jE : jA){
                ModelProduit mp = gson.fromJson(jE, ModelProduit.class);
                System.out.println(mp.getNumProduit());
            }
            
            

            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
