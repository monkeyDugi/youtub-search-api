package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class YoutubAPI {
	  
	public static void main( String[] args ) {
    	test();
    }
	
    public static void test() {
    	try {
	    	String apiurl = "https://www.googleapis.com/youtube/v3/search";
			apiurl += "?key=�ڽ���api key";												//api Ű
			apiurl += "&part=snippet&type=video&maxResults=20&videoEmbeddable=true";	//max result �ִ� 20�� �� �̻��̸� �Ҵ緮 �� �����.
			apiurl += "&q=" + URLEncoder.encode("�౸","UTF-8");							//�˻��� �ѱ۱��� ����.
			
			/* 
			 * HttpURLConnection : ��û����� ������ �� �ִ�, ������ ���� ������ ���� ������ ���̸� �� �� ���� ������ ��û �� ����Ѵ�.
			 *                     protected�̱� ������ ���� ������ �� ���� openConnection() ���� ������ ĳ���� �ؼ� ����� �� �ִ�.
			 */                  
			URL url = new URL(apiurl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			String inputLine;		
	
			while((inputLine = br.readLine()) != null) {
					
				System.out.print(inputLine + "\n");
			}
			
			br.close();
    	}
    	catch(Exception ex) {
    		
    		System.out.print(ex.getMessage());
    	}        	
    }
}
