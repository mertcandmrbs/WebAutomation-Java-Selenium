package testinium.network;

import java.util.StringTokenizer;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
public class csv 
{  
public static void main(String[] args)   
{  
String line = "";  
String splitBy = ";";  
try   
{  
//parsing a CSV file into BufferedReader class constructor  
BufferedReader br = new BufferedReader(new FileReader("ktp.csv"));  
while ((line = br.readLine()) != null)   //returns a Boolean value  
{  
String[] user = line.split(splitBy);    // use comma as separator  
String email = user[0];
String password = user[1];

}  
}   
catch (IOException e)   
{  
e.printStackTrace();  
}  
}  
}  