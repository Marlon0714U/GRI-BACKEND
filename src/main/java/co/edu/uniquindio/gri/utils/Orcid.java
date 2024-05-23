package co.edu.uniquindio.gri.utils;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Orcid {

	
	public static String getOrcidData(String id) {
        final String uri = "https://pub.orcid.org/v3.0/".concat(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody();
        
        return result;
    }
}


