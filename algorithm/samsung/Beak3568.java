package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak3568 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine()
            .replace(",", "")
            .replace(";", "");

        String[] arr = str.split(" ");
        String cType = arr[0];

        int size = arr.length - 1;

        for (int i = 1; i <= size; i++) {
            String tmp = arr[i];

            StringBuilder sb = new StringBuilder();
            for (int j = tmp.length() - 1; j >= 0; j--) {
                char c = tmp.charAt(j);

                if (c == '[') {
                    continue;
                }

                if (c != ']' && c != '&' && c != '*') {
                    continue;
                }

                if (c == ']') {
                    sb.append("[]");
                } else {
                    sb.append(c);
                }
            }

            tmp = tmp.replace("[", "")
                .replace("]", "")
                .replace("*", "")
                .replace("&", "");

            System.out.println(cType + sb + " " + tmp + ";");
        }
    }
}
