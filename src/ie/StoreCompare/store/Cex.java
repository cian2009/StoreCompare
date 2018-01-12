package ie.StoreCompare.store;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Cex {

	public static void main(int amount, String gameName) throws IOException {

		String url = "https://ie.webuy.com/search/index.php?stext="+gameName+"&num="+amount;  // or whatever goes here
		Document doc = Jsoup.connect(url).followRedirects(false).userAgent("Mozilla").timeout(60000).get();
		
		System.out.println("Sending request..." + "\"" + url + "\"");
		
		//System.out.println(doc);
		
		//parsing HTML after examining DOM
		Elements els  = doc.select("div.searchRecord");
		
		for(Element el : els)
		{
			
			if(el.getElementsByTag("h3").text() != " "){
				System.out.println("Game : " + el.getElementsByTag("h1").text());
				System.out.println("Console : " +  el.getElementsByTag("p").text());
				System.out.println("Link : " + el.getElementsByTag("a").text() + "\n");
			}
			
		}

		
	}

}
