import java.util.Arrays;

public class JobScheduling {
    public static void main(String[] args) {
        String[][] arr = {{"a", "4", "10"},
                          {"b", "1", "19"},
                          {"c", "2", "27"},
                          {"d", "1", "25"},
                          {"e", "3", "15"}};

        System.out.println("Following is the maximum profit sequence of jobs:");
        printJobScheduling(arr, 3);
    }

    public static void printJobScheduling(String[][] arr, int t) {
        int n = arr.length;
        // Sorting the jobs in descending order based on profit
        Arrays.sort(arr, (a, b) -> Integer.parseInt(b[2]) - Integer.parseInt(a[2]));

        boolean[] result = new boolean[t];
        String[] job = new String[t];

        // Scheduling the jobs
        for (int i = 0; i < n; i++) {
            // Finding the earliest available time slot for each job
            for (int j = Math.min(t - 1, Integer.parseInt(arr[i][1]) - 1); j >= 0; j--) {
                if (!result[j]) {
                    // Assigning the job to the available time slot
                    result[j] = true;
                    job[j] = arr[i][0];
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(job));
    }
}
