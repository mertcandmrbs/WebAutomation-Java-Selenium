package testinium.network;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import java.lang.Thread;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  




public class App 
{
    public static void main( String[] args ) {
    	
    	System.setProperty("webdriver.chrome.driver", "D:\\selenium-java-4.4.0\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.network.com.tr/");
    	
    	// get current URL and print. (FIRST)
    	String strUrl = driver.getCurrentUrl();
        System.out.println("Current Url is:"+ strUrl);
        

      //Tam ekran yapmak için
    	driver.manage().window().maximize(); 
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	WebElement SearchBox = driver.findElement(By.id("search")); //baz alınacak
    	SearchBox.sendKeys("ceket");   	
    	SearchBox.sendKeys(Keys.ENTER);   	
    	js.executeScript("window.scrollBy(0,17500)");
    	
    	
    	
    	WebElement Button1 = driver.findElement(By.className("-sm"));
    	Button1.click();
    	
    	//tekrarlı kullanılabilir timesleep, url kontrollerinin doğru sayfalarda yapılabilmesi için.
    	try {
    		Thread.sleep(2*1000);
    	} catch (InterruptedException e) {
            e.printStackTrace();
        }
    	   	
    	String strUrl2 = driver.getCurrentUrl();
        System.out.println("Current Url is:"+ strUrl2);
        
        
        
        //en baştakinin üstüne geliyor cursor
        WebElement element = driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div/div[1]"));  //bu               
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        
        WebElement pagePrice = driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div/div[1]/div/div[2]/div/div[2]/div/span[2]"));
        String firstPrice = pagePrice.getText();
        System.out.println(firstPrice);
        
        WebElement radioBox1 = driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div/div[1]/div/div[1]/div/div/div/div[1]/label"));
        String radioBox1Class = radioBox1.getAttribute("class");
        WebElement radioBox2 = driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div/div[1]/div/div[1]/div/div/div/div[2]/label"));
        String radioBox2Class = radioBox2.getAttribute("class");
        WebElement radioBox3 = driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div/div[1]/div/div[1]/div/div/div/div[3]/label"));
        String radioBox3Class = radioBox3.getAttribute("class");
        WebElement radioBox4 = driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div/div[1]/div/div[1]/div/div/div/div[4]/label"));
        String radioBox4Class = radioBox4.getAttribute("class");
        WebElement radioBox5 = driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div/div[1]/div/div[1]/div/div/div/div[5]/label"));
        String radioBox5Class = radioBox5.getAttribute("class");
        WebElement radioBox6 = driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div/div[1]/div/div[1]/div/div/div/div[6]/label"));
        String radioBox6Class = radioBox6.getAttribute("class");
        action.moveToElement(radioBox1).moveToElement(radioBox2).moveToElement(radioBox3).moveToElement(radioBox4).moveToElement(radioBox5).moveToElement(radioBox6).perform();
                      
        
        
       if (radioBox1Class.contains("-disabled") == false) {
        	radioBox1.click();
        }
       else if (radioBox2Class.contains("-disabled") == false) {
    	   radioBox2.click();
       }
       else if (radioBox3Class.contains("-disabled") == false) {
    	   radioBox3.click();
       }
       else if (radioBox4Class.contains("-disabled") == false) {
    	   radioBox4.click();
       }
       else if (radioBox5Class.contains("-disabled") == false) {
    	   radioBox5.click();
       }
       else if (radioBox6Class.contains("-disabled") == false) {
    	   radioBox6.click();
       }
       else  {
    	   System.out.println("This product is currently out of stock.");
       }
            
       
        
        try {
    		Thread.sleep(2*1000);
    	} catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //sepete git butonu tıklama
        WebElement chartButton = driver.findElement(By.xpath("//*[@id=\"header__desktopBasket\"]/div/div[3]/a"));
        chartButton.click();
        
        try {
    		Thread.sleep(2*1000);
    	} catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //ana sayfa ve sepetteki fiyat aynı mı.
        WebElement cartPrice = driver.findElement(By.xpath("//*[@id=\"cop-app\"]/div/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[2]"));
        String secondPrice = cartPrice.getText();
        System.out.println(secondPrice);
        
        if (firstPrice == secondPrice) {
        	System.out.println("Main page price and cart price are equal.");
        }
        else {
        	System.out.println("Main page price and cart price are not equal.");
        }
        //sepette eski fiyat güncel fiyattan büyük mü
        WebElement cartOldPrice = driver.findElement(By.xpath("//*[@id=\"cop-app\"]/div/div[1]/div[1]/div[1]/div[2]/section/div[3]/div/div/div[1]/div[3]/span[2]"));
        String oldPrice = cartOldPrice.getText();
        String parsedSecondPrice = secondPrice.replaceAll("\\D" , "");
        String parsedOldPrice = oldPrice.replaceAll("\\D", "");
        int oldPriceInt = Integer.parseInt(parsedOldPrice);
        int newPriceInt = Integer.parseInt(parsedSecondPrice);
        if (oldPriceInt > newPriceInt ) {
        	System.out.println("Discount applied.");
        }
        else
        	System.out.println("Discount did not apply.");
        
        
        try {
    		Thread.sleep(2*1000);
    	} catch (InterruptedException e) {
            e.printStackTrace();
        }                
        //devam et butonu
        WebElement contButton = driver.findElement(By.xpath("//*[@id=\"cop-app\"]/div/div[1]/div[1]/div[2]/div/div[2]/button"));
        contButton.click();
        
        //csvden mail ve şifre alanını doldurmak için(excel csv)
        try {
    		Thread.sleep(2*1000);
    	} catch (InterruptedException e) {
            e.printStackTrace();
        }           
        
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
        WebElement mailInput = driver.findElement(By.xpath("//*[@id=\"n-input-email\"]"));
        mailInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"n-input-password\"]"));
        passwordInput.sendKeys(password);
        
        }  
        }   
        catch (IOException e)   
        {  
        e.printStackTrace();  
        }  
       
        
        //Giriş Yap butonunun gelip gelmediği kontrol edilir.
        boolean status = driver.findElement(By.xpath("//*[@id=\"login\"]/button")).isEnabled();
		
		if(status){
			System.out.println("Checkbox(Giris Yap) is checked");
		} else {
			System.out.println("Checkbox(Giris Yap) is unchecked");
		}
		
		//Network başlığına tıklamak
		WebElement siteHeader = driver.findElement(By.className("headerCheckout__logo"));
		siteHeader.click();
		
		try {
    		Thread.sleep(2*1000);
    	} catch (InterruptedException e) {
            e.printStackTrace();
        }        
		
		//anasayfanın sol üstünden sepeti görmek
		WebElement mainCart = driver.findElement(By.className("header__basketTrigger"));
		mainCart.click();
		
		try {
    		Thread.sleep(1*1000);
    	} catch (InterruptedException e) {
            e.printStackTrace();
        }        
		
		//sepetteki itemi kaldırmak için.
		WebElement removeItem = driver.findElement(By.className("header__basketProductRemove"));
		removeItem.click();
		
		try {
    		Thread.sleep(1*1000);
    	} catch (InterruptedException e) {
            e.printStackTrace();
        }        
		//gelen son ekranda "vazgeç" "çıkart" seçimi yapmak için.
		WebElement removeComplete = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/button[2]"));
		removeComplete.click();
		
		  try {
	    		Thread.sleep(2*1000);
	    	} catch (InterruptedException e) {
	            e.printStackTrace();
	        }                
		  
		//sepeti temizledikten sonra kontrol
		mainCart.click();
		
		boolean statusCart = driver.findElement(By.xpath("//*[@id=\"header__desktopBasket\"]/div/div[2]/span")).isEnabled();
		
		if(statusCart){
			System.out.println("Sepette ürün yok-silindi.");
		} else {
			System.out.println("Sepette ürün var.");
		}
		
		
		
		
		
		
		
		
      

      
                                
                
        //Actions action = new Actions(driver); //bu
        //action.moveToElement(element).perform(); //bu
        
        //WebElement radioBox = driver.findElement(By.xpath("//div[@id='products']/div[3]/div/div/div/div/div/div/div/div[5]/label"));
        //radioBox.click();
        
        //List<WebElement> randomRadio = driver.findElements(By.className("radio-box__label"));
        //int randomRadiocount = randomRadio.size();
        //System.out.println(randomRadiocount);
        
        //for (int i = 7; i < randomRadiocount; i++) {

			//String linktext = randomRadio.get(i).getText();
			//System.out.println(linktext);
			
			//Random random = new Random();
			//random.linktext.click();
			
        }
        
    }
    


    
        
        
        
        
    	
    	
        
    	
    	
    	
    	
    	
        
    

