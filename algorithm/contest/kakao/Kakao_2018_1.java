package contest.kakao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Kakao_2018_1 {

    public static void main(String[] args) throws Exception {
        System.out.println(solution(new String[] {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"}));
    }

    public static int solution(String[] lines) throws Exception {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date[] startDate = new Date[lines.length];
        Date[] endDate = new Date[lines.length];

        int max = 0;

        for (int i = 0; i < lines.length; i++) {
            String[] log = lines[i].split(" ");
            String dateStr = log[0] + " " + log[1];

            int procMil = (int) (Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * -1000);
            endDate[i] = sf.parse(dateStr);
            startDate[i] = addMil(endDate[i], procMil + 1);
        }

        for (Date date : endDate) {
            long endTimeMillI = date.getTime();
            long finalTimeMillI = addMil(date, 1000).getTime();
            int tmp = 0;

            for (int j = 0; j < startDate.length; j++) {
                long startTimeMillJ = startDate[j].getTime();
                long endTimeMillJ = endDate[j].getTime();

                if (finalTimeMillI - startTimeMillJ <= 0)
                    continue;

                if (endTimeMillI - startTimeMillJ <= 0 || (endTimeMillI - endTimeMillJ <= 0
                    && finalTimeMillI - endTimeMillJ > 0) || (endTimeMillI - startTimeMillJ > 0
                    && endTimeMillI - endTimeMillJ <= 0)) {
                    tmp++;
                }
            }
            max = Math.max(max, tmp);
        }
        return max;
    }

    private static Date addMil(Date date, int procMil) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MILLISECOND, procMil);
        return cal.getTime();
    }
}
