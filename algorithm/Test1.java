import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

class Test1 {

	public static void main(String[] args) throws Exception {
		String TOKEN = "Basic eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzbXMiOiJZIiwiYXVkIjoidGJfZ3dfdmlyIiwibW1zIjoiWSIsImV4cCI6MTU3MjQxNTAxMCwicmVwIjoiTiJ9.z0NMjFtuENJP-tTHk_K5ObM5jgfymG8KyOH7Bn4SbBU";
		String API_URL = "https://test-sms.supersms.co:7020/sms/v3/multiple-destinations";

		try {

			URL url = new URL(API_URL);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", TOKEN);
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json");

			String json = "{\"title\": \"Coding Test\",\"from\": \"0316281564\",\"text\": \"text1\",\"fileKey\": \"710535a7a18647e090b4877f8649898f\",\"destinations\":[{\"to\": \"821029248669\", \"replaceWord1\": \"\", \"replaceWord2\": \"\", \"replaceWord3\":\"\", \"replaceWord4\":\"\", \"replaceWord5\":\"\"}], \"ref\":\"\" ,\"ttl\": \"1000\", \"paymentCode\": \"\", \"clientSubId\":\"\"}";

			OutputStream os = con.getOutputStream();

			os.write(json.getBytes("UTF-8"));
			os.flush();
			os.close();

			int responseCode = con.getResponseCode();
			System.out.println(responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();
			System.out.println(response.toString());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}