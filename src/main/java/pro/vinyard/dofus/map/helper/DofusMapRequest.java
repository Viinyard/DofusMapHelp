package pro.vinyard.dofus.map.helper;

import java.io.IOException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;

import pro.vinyard.dofus.map.helper.model.Direction;

public class DofusMapRequest {
	
	private static final String DOFUS_MAP_URL = "https://dofus-map.com/huntTool/getData.php";
	 
	private static HttpRequestFactory REQ_FACTORY;
	
	private static HttpTransport TRANSPORT;
	
	private static final JsonFactory JSON_FACTORY = new JacksonFactory();
	
	public static void main(String[] args) {
		try {
			DofusMapRequest.getRequestWithQueryParameters(new Position(-2, 0), Direction.NORTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	private static HttpTransport transport() {
	    if (null == TRANSPORT) {
	        TRANSPORT = new NetHttpTransport();
	    }
	    return TRANSPORT;
	}
	 
	private static HttpRequestFactory reqFactory() {
	    if (null == REQ_FACTORY) {
	        REQ_FACTORY = transport().createRequestFactory();
	    }
	    return REQ_FACTORY;
	}
	
	public static DofusMapIndice getRequestWithQueryParameters(Position position, Direction direction) throws IOException {
	    GenericUrl url = new GenericUrl(DOFUS_MAP_URL);
	    url.put("x", position.getPosX());
	    url.put("y", position.getPosY());
	    url.put("direction", direction.getDirection());
	    url.put("world", 0);
	    url.put("language", "fr");
	    HttpRequest req = reqFactory().buildGetRequest(url);
	    req.setParser(new JsonObjectParser(JSON_FACTORY));
	    
	    HttpResponse resp = req.execute();
	    System.out.println(resp);
	    
	    Type type = new TypeToken<DofusMapIndice>() {}.getType();
	   	return (DofusMapIndice) req
	      .execute()
	      .parseAs(type);
	}

}
