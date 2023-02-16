package API_using_unirest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Using_unirest {

	// GET request
	public void GetReq() throws UnirestException {

		HttpResponse<JsonNode> jsonResponse = Unirest.get("https://dummy.restapiexample.com/api/v1/employees").asJson();

		System.out.println(jsonResponse.getStatus());
		System.out.println(jsonResponse.getStatusText());
		System.out.println(jsonResponse.getBody());

	}
	// POST Request 
	public void PostReq() throws UnirestException {

		HttpResponse<JsonNode> jsonresponse = Unirest.post("https://dummy.restapiexample.com/api/v1/create").
				body("{\"name\":\"viki\",\"salary\":\"30000\",\"age\":\"25\"}").asJson();

		System.out.println(jsonresponse.getStatus());
		System.out.println(jsonresponse.getStatusText());
		System.out.println(jsonresponse.getBody());

	}
	// PUT request (update)
	public void PutReq() throws UnirestException {

		HttpResponse<JsonNode> jsonresponse = Unirest.put("https://dummy.restapiexample.com/api/v1/update/7321").
				body("{\"name\":\"viki\",\"salary\":\"30000\",\"age\":\"5\"}").asJson();

		System.out.println(jsonresponse.getStatus());
		System.out.println(jsonresponse.getStatusText());
		System.out.println(jsonresponse.getBody());

	}
	// Delete Request 
	public void DeleteReq() throws UnirestException {
		HttpResponse<JsonNode> jsonresponse = Unirest.delete("https://dummy.restapiexample.com/api/v1/update/7321").
				asJson();

		System.out.println(jsonresponse.getStatus());
		System.out.println(jsonresponse.getStatusText());
		System.out.println(jsonresponse.getBody());

	}
	public static void main(String[] args) throws UnirestException {
		Using_unirest UR = new Using_unirest();
		UR.GetReq();
		UR.PostReq();
		UR.PutReq();
		UR.DeleteReq();
	}

}
