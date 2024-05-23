package co.edu.uniquindio.gri.utils;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Iterator;

@Service
public class JSoupUtil {
	/**
	 * Método provisto por JSoup para comprobar el Status code de la respuesta que
	 * recibo al hacer la petición Codigos: 200 OK 300 Multiple Choices 301 Moved
	 * Permanently 305 Use Proxy 400 Bad Request 403 Forbidden 404 Not Found 500
	 * Internal Server Error 502 Bad Gateway 503 Service Unavailable
	 * 
	 * @param url, el enlace de la página web a analizar.
	 * @return Status Code, el código que identifica el estado de la página.
	 */

	public int getStatusConnectionCode(String url) {

		trustCertificate();
		Response response = null;
		try {
			response = Jsoup.connect(url).ignoreContentType(true)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
					.timeout(0).ignoreHttpErrors(true).followRedirects(true).execute();
		} catch (IOException ex) {

			return getStatusConnectionCode(url);
		}
		return response.statusCode();

	}

	/**
	 * Método que retorna un objeto de la clase Document con el contenido del HTML
	 * de la web para poder ser parseado posteriormente con JSoup
	 * 
	 * @param url, el enlace de la página web a analizar.
	 * @return Documento con el HTML de la página en cuestión.
	 */

	public Document getHtmlDocument(String url) {
		trustCertificate();
		Document document = null;
		try {
			document = (Document) Jsoup.connect(url).ignoreContentType(true)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
					.timeout(0).ignoreHttpErrors(true).followRedirects(true).execute();
		} catch (IOException ex) {
			return getHtmlDocument(url);
		}
		return document;
	}

	public void trustCertificate() {
		try {
			TrustManager[] trustAllCertificates = new TrustManager[] { new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {

				}
			} };

			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String s, SSLSession sslSession) {
					return true;
				}
			});

		} catch (NoSuchAlgorithmException | KeyManagementException e) {
			e.printStackTrace();
		}
		
		try {
			  // Configurar un TrustManager que no realiza ninguna verificación
	        TrustManager[] trustAllCerts = new TrustManager[]{
	            new X509TrustManager() {
	                public X509Certificate[] getAcceptedIssuers() {
	                    return null;
	                }
	                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
	                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
	            }
	        };

	        // Configurar un SSLContext con el TrustManager personalizado
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new SecureRandom());

	        // Aplicar el SSLContext a la conexión HTTPS
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	        // Realizar la conexión HTTPS
	        // ... tu código de conexión HTTPS aquí ...
	    
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

		
      
}