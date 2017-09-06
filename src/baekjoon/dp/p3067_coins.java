package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by advJava3_2 on 2017. 5. 12..
 * <p>
 * 문제
 * 우리나라 화폐단위, 특히 동전에는 1원, 5원, 10원, 50원, 100원, 500원이 있다.
 * 이 동전들로는 모든 정수의 금액을 만들 수 있으며 그 방법도 여러 가지가 있을 수 있다.
 * 예를 들어 30원을 만들기 위해서는 1원짜리 30개 또는 10원짜리 2개와 5원짜리 2개 등의 방법이 가능하다.
 * <p>
 * 동전의 종류가 주어질 때에 주어진 금액을 만드는 모든 방법을 세는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스는 첫 번째 줄에는 동전의 가지 수 N(1 ≤ N ≤ 20)이 주어지고
 * 두 번째 줄에는 N 가지 동전의 각 금액이 오름차순으로 정렬되어 주어진다.
 * 각 금액은 정수로서 1원부터 10000원까지 있을 수 있으며 공백으로 구분된다.
 * 세 번째 줄에는 주어진 N가지 동전으로 만들어야 할 금액 M(1 ≤ M ≤ 10000)이 주어진다.
 * <p>
 * 편의를 위해 방법의 수는 231 - 1 보다 작다고 가정해도 된다.
 * <p>
 * 출력
 * 각 테스트 케이스에 대해 입력으로 주어지는 N가지 동전으로 금액 M을 만드는 모든 방법의 수를 한 줄에 하나씩 출력한다.
 * <p>
 * 예제 입력
 * -----------------
 * 3 테스트케이스
 * 2 2가지종류 코인
 * 1원 2원 을 활용해서
 * 1000원을 만들수있는 경우의 수 출력
 * 3
 * 1 5 10
 * 100
 * 2
 * 5 7
 * 22
 * ----------------
 * 예제 출력
 * ----------------
 * 501
 * 121
 * 1
 * ----------------
 */
public class p3067_coins {
    public static void main(String[] args) {
        int[] dp = new int[1001];
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[] coin = new int[n];
            for (int j = 0; j < n; j++) {
                coin[j] = scan.nextInt();
            }
            int result = scan.nextInt();
            Arrays.fill(dp, 0);
            dp[0]=1;
            for (int j = 0; j < n; j++) {
                for (int k = coin[j]; k <= result; k++) {
                    dp[k] += dp[k - coin[j]];
                }
            }
            System.out.println(dp[result]);
            System.out.println(Arrays.toString(dp));
        }
    }
}
