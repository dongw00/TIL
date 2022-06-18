package dp;

import java.util.Arrays;

/**
 * 호텔 사업은 성공하기 힘들다. 특히, 라스베가스와 같은 관광도시에서 경쟁할 때는 더욱 그렇다. 마케팅은 매우 중요하며 총 매출의 큰 부분을 차지한다. 당신은 홍보할 수 있는
 * 도시 목록과 각 도시에 사용하는 비용 대비 어 느 정도의 고객을 데려올 수 있는 지에 대한 좋은 견적이 있다. 주어진 int[] customers과 int[] cost을 통해
 * i번째 도시에서 cost[i]만큼의 비용으로 customers[i]만큼의 고객 을 데려올 수 있음을 알 수 있다. 당신은 어느 도시든 정해진 비용의 정수의 배수만큼만 쓸 수
 * 있다. 예를 들어, 어느 도시에서 3명의 고객을 데려오기 위해 9의 비용이 필요하다면, 9를 내고 3명을 데려오거나, 18을 내고 6 명을 데려오거나, 27을 내고 9명을
 * 데려올 수 있다. 하지만 3을 내고 1명을 데려오거나 12를 내고 4명을 데려올 순 없다. 각 도시는 무한한 숫자의 예비 고객이 있다. int minCustomers의 고객을
 * 데려오기 위해 필요한 최소 한의 비용을 리턴하시오.
 * <p>
 * <p>
 * 참고 / 제약 사항 ● minCustomers는 최소값 1, 최대값 1000의 범위를 가진다. ● customers는 최소 1개, 최대 20개의 요소를 가진다. ● cost는
 * customers와 동일한 개수의 요소를 가진다. ● cost와 customers의 각 요소는 최소값 1, 최대값 100의 범위를 가진다.
 */
public class Mylittle01 {

    static final int INF = 100000;

    public static void main(String[] args) throws Exception {
        System.out.println(solve(new int[]{1, 2, 3}, new int[]{3, 2, 1}, 10));
        System.out.println(solve(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
        System.out.println(solve(new int[]{5, 1}, new int[]{3, 1}, 12));
        System.out.println(solve(new int[]{9, 11, 4, 7, 2, 8}, new int[]{4, 9, 3, 8, 1, 9}, 100));
        System.out.println(solve(new int[]{3, 5, 7, 9, 13, 17}, new int[]{17, 13, 9, 7, 5, 3}, 99));
    }

    public static int solve(int[] customers, int[] cost, int minCustomers) {
        int maxCustomer = Arrays.stream(customers).max().getAsInt();

        int[] dp = new int[minCustomers + maxCustomer + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < customers.length; i++) {
            for (int j = customers[i]; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - customers[i]] + cost[i]);
            }
        }

        int ans = INF;
        for (int i = minCustomers; i < dp.length; i++) {
            ans = Math.min(dp[i], ans);
        }
        return ans;
    }
}
