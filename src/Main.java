public class Main {

    final static int MAX_VAL = 10001;
    final static int MIN_VAL = 2001;
    final static int MAX_LEN = 21;

    static int get_ways(int[] c, int n, int m, int[][] dp) {

        int res = 0;

        if(m == 0 && n == 0) {
            return 1;
        }

        if(m == 0 && n != 0) {
            return 0;
        }

        if(m < 0) {
            return 0;
        }

        int index = n + MIN_VAL;
        if(dp[m][index] != -1) {
            return dp[m][index];
        }

        if(m > 0) {
            res = get_ways(c, n + c[m - 1], m - 1, dp) + get_ways(c, n - c[m - 1], m - 1, dp);
        }

        dp[m][index] = res;

        return res;
    }

    static void init_dp(int[][] dp, int nr, int nc) {

        for(int i = 0; i < nr; ++i) {
            for(int j = 0; j < nc; ++j) {
                dp[i][j] = -1;
            }
        }
    }

    static int find_target_sum_ways(int[] nums, int target) {

        int m = nums.length;

        int[][] dp = new int[MAX_LEN][MAX_VAL];

        init_dp(dp, MAX_LEN, MAX_VAL);

        return get_ways(nums, target, m, dp);
    }

    public static void main(String[] args) {

        // Initialize target value
        int target = 3;

        // Initialize nums array
        int[] nums = {1, 1, 1, 1, 1};

        // Compute number of expressions which evaluate to target
        int num_ways = find_target_sum_ways(nums, target);

        // Print results
        System.out.println("num_ways: " + num_ways);
    }
}
