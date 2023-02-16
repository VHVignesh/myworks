package API_usingjavanet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Httpconnection_examples {

	// get request 
	public void getMethod() throws IOException {

		// open the url connection and store IT in its parent class

		URL url = new URL("https://dummy.restapiexample.com/api/v1/employees");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();

		// set the request type
		connection .setRequestMethod("GET");
		connection.connect();

		// getting status code 
		int  statuscode = connection.getResponseCode();
		System.out.println("Status code is "+statuscode);

		// get response message 
		String responseMessage = connection.getResponseMessage();
		System.out.println("Status response message is "+responseMessage);


		// read the response using getinputstream

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputstreamReader= new InputStreamReader(inputStream);
		BufferedReader bufferedreader = new BufferedReader(inputstreamReader);

		// to read line by line using read line 
		String line;

		//line will add in the buffer
		StringBuffer buffer = new StringBuffer();

		while((line=bufferedreader.readLine())!=null){
			buffer.append(line);
		}
		System.out.println(buffer);
	}


	//  post request 
	public void PostmethodExample() throws IOException {
		URL url = new URL("https://dummy.restapiexample.com/api/v1/create");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();

		connection .setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");

		// for post it will be true set dooutput
		connection.setDoOutput(true);

		// json body to post
		// change a string to byte array
		String jsonbody= "{\"name\":\"viki\",\"salary\":\"30000\",\"age\":\"25\"}";

		byte[] inputjson = jsonbody.getBytes();

		//to write the inuput

		OutputStream outputStream = connection.getOutputStream();

		outputStream.write(inputjson);

		System.out.println("response code "+ connection.getResponseCode());

		System.out.println("response code "+ connection.getResponseMessage());

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputstreamReader= new InputStreamReader(inputStream);
		BufferedReader bufferedreader = new BufferedReader(inputstreamReader);

		// to read line by line using read line 
		String line;

		//line will add in the buffer
		StringBuffer buffer = new StringBuffer();

		while((line=bufferedreader.readLine())!=null){
			buffer.append(line);
		}
		System.out.println(buffer);
	}

	// update request  (put)

	public void PutMethodExample() throws IOException {
		URL url = new URL("https://dummy.restapiexample.com/api/v1/update/7980");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();

		connection .setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");

		// for post it will be true set dooutput
		connection.setDoOutput(true);

		String jsonbody= "{\"name\":\"vignesh\",\"salary\":\"30000\",\"age\":\"5\"}";

		byte[] inputjson = jsonbody.getBytes();

		//to write the inuput

		OutputStream outputStream = connection.getOutputStream();

		outputStream.write(inputjson);

		System.out.println("response code "+ connection.getResponseCode());

		System.out.println("response code "+ connection.getResponseMessage());

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputstreamReader= new InputStreamReader(inputStream);
		BufferedReader bufferedreader = new BufferedReader(inputstreamReader);

		// to read line by line using read line 
		String line;

		//line will add in the buffer
		StringBuffer buffer = new StringBuffer();

		while((line=bufferedreader.readLine())!=null){
			buffer.append(line);
		}
		System.out.println(buffer);

	}

	// Delete request 

	public void DeleteMethodExample() throws IOException {

		URL url = new URL("https://dummy.restapiexample.com/api/v1/delete/7980");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();

		connection .setRequestMethod("DELETE");
		connection.setRequestProperty("Content-Type", "application/json");

		// for post it will be true set dooutput
		connection.setDoOutput(true);

		System.out.println("response code "+ connection.getResponseCode());

		System.out.println("response code "+ connection.getResponseMessage());

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputstreamReader= new InputStreamReader(inputStream);
		BufferedReader bufferedreader = new BufferedReader(inputstreamReader);

		// to read line by line using read line 
		String line;

		//line will add in the buffer
		StringBuffer buffer = new StringBuffer();

		while((line=bufferedreader.readLine())!=null){
			buffer.append(line);
		}
		System.out.println(buffer);


	}

	public static void main(String[] args) throws IOException {

		Httpconnection_examples CE = new Httpconnection_examples();
		CE.getMethod();
		CE.PostmethodExample();
		CE.PutMethodExample();
		CE.DeleteMethodExample();

	}

}
