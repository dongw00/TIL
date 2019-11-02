import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.UUID;

class Test2 {

	public static void main(String[] args) throws Exception {
		String TOKEN = "Basic eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzbXMiOiJZIiwiYXVkIjoidGJfZ3dfdmlyIiwibW1zIjoiWSIsImV4cCI6MTU3MjQxNTAxMCwicmVwIjoiTiJ9.z0NMjFtuENJP-tTHk_K5ObM5jgfymG8KyOH7Bn4SbBU";
		String API_URL_SEND = "https://test-sms.supersms.co:7020/sms/v3/multiple-destinations";
		String API_URL_UPLOAD = "https://test-file.supersms.co:7010/sms/v3/file";

		try {
			String boundary = UUID.randomUUID().toString();
			// 이미지 파일 업로
			URL url = new URL(API_URL_UPLOAD);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", TOKEN);
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

			File file = new File("data/logo.jpg");

			// String json = "{\"title\": \"Coding Test\",\"from\": \"0316281564\",\"text\":
			// \"text1\",\"fileKey\": \"\",\"destinations\":[{\"to\": \"821029248669\",
			// \"replaceWord1\": \"\", \"replaceWord2\": \"\", \"replaceWord3\":\"\",
			// \"replaceWord4\":\"\", \"replaceWord5\":\"\"}], \"ref\":\"\" ,\"ttl\":
			// \"1000\", \"paymentCode\": \"\", \"clientSubId\":\"\"}";

			OutputStream os = con.getOutputStream();

			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int readcount = 0;
			while ((readcount = fis.read(buffer)) != -1) {
				os.write(buffer, 0, readcount);
			}
			os.flush();

			// os.write(json.getBytes("UTF-8"));
			os.close();
			fis.close();

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