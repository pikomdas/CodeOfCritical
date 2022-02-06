package org.codeOfCritical.api;

import java.io.IOException;

import org.codeOfCritical.api.api.utils.ContentType;
import org.codeOfCritical.api.api.utils.GetAdapter;
import org.codeOfCritical.api.api.utils.PostAdapter;
import org.codeOfCritical.api.api.utils.RestAdapter;
import org.codeOfCritical.api.request.PostRequest;
import org.codeOfCritical.api.response.GetResponse;
import org.codeOfCritical.api.response.PostResponse;
import org.junit.Test;

public class ApiTest
{

	public void testSetUp() throws IOException {

		/*PostRequest request = new PostRequest();
		request.setPassword("passw0rd");
		request.setName("Syed");

		RestAdapter adapter = PostAdapter.builder().setContentType(ContentType.JSON).setRequestObject(request)
				.setEndPoint("http://jsonplaceholder.typicode.com").setMethodName("/posts").build();
		PostResponse response = adapter.execute(PostResponse.class);
		response.getId();
		response.getBody();*/

	}

	@Test
	public void testSetUp1() throws IOException {

		/*RestAdapter adapter = GetAdapter.builder().setContentType(ContentType.JSON).setEndPoint(
				"http://mf.accordwebservices.com/MF/GetSchemeISIN_Mst?pageno=1&pagesize=5&token=9SdAbWzd8PnpuGBZb4w0n6kZi3nNsCxm")
				.setMethodName("").build();
		GetResponse response = adapter.execute(GetResponse.class);
		response.getBody();*/
	}
}
