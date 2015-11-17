package app.sunwell;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ReadDataFromWebsite {
	
	private Document document;
	private Elements playersOnline;
	private Element feronisInfo;
	private Element stormrageInfo;
	private String feronisMoreData;
	private String stormrageMoreData;
	private List<String> dataList;
	private String userAgent;
	private String title;
	private String webAddress;
	
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	
	public List<String> dictionary() {
		
		return Arrays.asList("</FONT>", "<CENTER>", "tooltip.show", "</CENTER>", ", 160, 0, 0, 5, -5", ";",
							"<FONT COLOR=#ff3333>", "<FONT COLOR=#7dafff>", "<BR>", "'", "</B>", "<B>");
	}
	
	public String clean(String dirty) {
		
		for(int i = 0; i < dictionary().size(); i++) {
			if(dictionary().get(i).equals("<B>")) {
				dirty = dirty.replaceAll("<B>", "\n");
			} else {
				dirty = dirty.replaceAll(dictionary().get(i), "");
			}
		}
		return dirty;
	}
	
	public List<String> read() throws IOException {

		dataList = new ArrayList<String>();
		document = Jsoup.connect(webAddress).userAgent(userAgent).get();
		playersOnline = document.select("span[class=zalogowany-jako-username]");
		feronisInfo = document.select("div[class=realm-border]").first();
		stormrageInfo = document.select("div[class=realm-border]").last();
		feronisMoreData = document.select("div[class=realm-border]").first().attr("onmouseover");
		stormrageMoreData = document.select("div[class=realm-border]").last().attr("onmouseover");
		
		dataList.add(title);
		dataList.add(playersOnline.text());
		dataList.add(feronisInfo.text());
		dataList.add(stormrageInfo.text());
		dataList.add(clean(feronisMoreData).replace("(", "").replace(")", ""));
		dataList.add(clean(stormrageMoreData).replace("(", "").replace(")", ""));

		return dataList;
	}
}
