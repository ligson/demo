package demo.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

/**
 * 模拟两次JSESSIONID一致
 * 
 * @author ligson
 * 
 */
public class SessionTest {
	public static CookieStore cookieStore;

	public static void login() throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(
				"http://192.168.0.109:8080/nts/index/checkLogin");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("name", "master"));
		params.add(new BasicNameValuePair("password", "password"));
		params.add(new BasicNameValuePair("returnType", "json"));

		post.setEntity(new UrlEncodedFormEntity(params));

		HttpResponse response = httpClient.execute(post);
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		System.out.println(result);

		Header[] headers = response.getAllHeaders();
		for (Header header : headers) {
			System.out.println(header);
		}

		cookieStore = httpClient.getCookieStore();
		List<Cookie> cookies = cookieStore.getCookies();
		System.out.println(cookies.size());

	}

	public static void create() throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet post = new HttpGet("http://192.168.0.109:8080/nts/my/myInfo");
		// httpClient.setCookieStore(cookieStore);
		CookieStore cookieStore2 = new BasicCookieStore();
		HttpContext context = new BasicHttpContext();
		context.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

		List<Cookie> cookies = cookieStore.getCookies();
		for (Cookie cookie : cookies) {
			BasicClientCookie stdCookie = new BasicClientCookie(
					cookie.getName(), cookie.getValue());
			// stdCookie.setVersion(cookie.getVersion());
			stdCookie.setDomain(cookie.getDomain());
			// stdCookie.setPath(cookie.getPath());
			// stdCookie.setSecure(cookie.isSecure());
			cookieStore2.addCookie(stdCookie);
		}

		httpClient.setCookieStore(cookieStore2);
		HttpResponse response = httpClient.execute(post);

		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		System.out.println(result);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		login();
		create();
	}

}
