package dbms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cursor extends ArrayList<HashMap<String, String>> implements CursorFase {
	private String[] cursorKeys;
    private int position;
    
    Cursor (String[] headers) {
        super();
        this.cursorKeys = headers;
        this.position = 0;
    }
    
    private static String getHTTP(String urlStr) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            
            while( (line = br.readLine()) != null ){
                result.append(line);
            }
            br.close();
        } catch (MalformedURLException ex) {
            System.out.println("MalformedURLException");
        } catch (IOException ex) {
        	System.out.println("IOException");
        }
        
        return result.toString();
    }
    
    
    
    public void createItem(String[] values) {
        HashMap<String, String> localMap = new HashMap<String, String>();
        
        for (int i = 0; i < cursorKeys.length; i++) {
            localMap.put(cursorKeys[i], values[i]);
        }
        this.add(localMap);
    }
    
    
    
    public void select() {
    	int size = 0;
    	String httpData = getHTTP("http://cityfinder.esy.es/javaapi.php?type=get&user=baydala");
        System.out.println(httpData);
        
        HashMap<String, String> localMap = new HashMap<String, String>();
        
        String[] dataArray = httpData.split("#");
        String[] values = null;
        for (int i = 0; i < dataArray.length; i++) {
            values = dataArray[i].split(";");
            this.createItem(values);
        }
        
        size = this.size();
        for (int i = 0; i < size; i++ ) {
        	this.printItemCursor(i);
        	System.out.println("--------------------------------");
        }
    }
    
    
        
    private void printItemCursor(int pos) {
        HashMap<String, String> local = new HashMap<String, String>();
        try {
            local = this.get(pos);
            for (int i = 0; i < cursorKeys.length ; i++) {
                System.out.println( cursorKeys[i] +":"+ local.get(cursorKeys[i]));
                
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR: No such position."); 
        }
        
    }
    
    
    
    
    public void update(int pos, String[] values) {
    	this.delete(pos);
        this.insert(pos, values);
    }
    
    public void delete(int pos) {
    	Integer succes = 1;
    	    	
    	String result = getHTTP("http://cityfinder.esy.es/javaapi.php?type=delete&id=1&user=baydala");
        System.out.println(result);
        
        if ( result.equals(succes) ) {
        	this.remove(pos);
        	System.out.println("Row #" + pos +"deleted succesfully.");
        } else {
        	System.out.println("ERROR: return code: " + result);
        }
    	
    }
    
    public void insert(int pos, String[] values) {}
    
    public boolean isLast() {}
    
    
    
    
    

}
