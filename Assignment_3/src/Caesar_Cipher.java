import java.util.Scanner;

public class Caesar_Cipher{
	
	public static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
	 
	public static String caesar_encryt() {
		String cyper_text ="";
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the plaintext message to encrypt");
		System.out.println("Enter a message: ");
		String plain_text = sc.nextLine();
		System.out.println("Enter a key: ");
	    int	key = sc.nextInt();
		for(int plain=0;plain<plain_text.length();plain++)
		{
			try {
			char pos= plain_text.charAt(plain);
			if(pos >= 'a' && pos <= 'z'){
				pos = (char)(pos + key);
	            
	            if(pos > 'z'){
	            	pos = (char)(pos - 'z' + 'a' - 1);
	            }
	            cyper_text += pos;
	        }
	        else if(pos >= 'A' && pos <= 'Z'){
	        	pos = (char)(pos + key);
	            
	            if(pos > 'Z'){
	            	pos = (char)(pos - 'Z' + 'A' - 1);
	            }
	            
	            cyper_text += pos;
	        }
	        else {
	        	cyper_text += pos;
	        }
		}catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}}
	
		
		return cyper_text;
		
	}
    
    public static String caesar_decrypt(String cyphert, int key)
    {
      	int flag=0;
       	String plain_text = "";
        for (int c = 0; c < cyphert.length();c++) 
        	try{
        {
        	char cyphert_pos=cyphert.charAt(c);
        
        	if(Character.isUpperCase(cyphert_pos)) { 
            		flag=1;
        	}
         if(flag==1) {
        	 
			int posi = ALPHABETS.indexOf(Character.toLowerCase(cyphert_pos));
			plain_text= plain_text+(ALPHABETS.charAt((posi-key) % 26));
	       	}else 
	       	{
          		int posi = ALPHABETS.indexOf(cyphert_pos);
          		plain_text= plain_text+(ALPHABETS.charAt((posi-key) % 26));          		
          	}
         }
        }
        	catch(StringIndexOutOfBoundsException e){
          	char cyphert_pos=cyphert.charAt(c);
          	int posi = ALPHABETS.indexOf(cyphert_pos);           	 
           	plain_text= plain_text+(ALPHABETS.charAt(26 + ((posi-key) % 26)));
             	 }
            return plain_text;
    }

  
  public static void main(String[] args) {
	        @SuppressWarnings("resource")
			Scanner cipher = new Scanner(System.in);
			System.out.println("Choose a option for encrypt and decrypt a message"); 
	        System.out.println("1.Encrypt		2:Decrypt ");
	        String option = new String();
	        option = cipher.next();
	        switch(option){
	        case "1": 
					  String cyper_text = caesar_encryt();
					  System.out.print("The encrypted message is:"+cyper_text);
					  break;
	        case "2": System.out.println("Please enter the message to decrpyt"); 
					  String cyper_text1  = new String();
					  cyper_text1 = cipher.next();
					  System.out.println("Please enter the key "); 
					  int key1 = cipher.nextInt();
					  String plain_text1 =caesar_decrypt(cyper_text1, key1);
					  System.out.print("The decrypted message is:"+ plain_text1);
					  break;		  
	        }
  }
	
}

