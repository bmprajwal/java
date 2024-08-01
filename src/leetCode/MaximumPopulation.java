package leetCode;

public class MaximumPopulation {
    public static void main(String[] args) {
        int[][] logs = {
                {1950, 1961},
                {1960, 1971},
                {1970, 1979}
        };
        System.out.println(maximumPopulation(logs));
    }

    public static int maximumPopulation(int[][] logs) {
        int[] year = new int[101];
        for(int[] log: logs){
            year[log[0] - 1950] += 1;
            year[log[1] - 1950] -= 1;
        }

        int maxPopulation = year[0];
        int maxYear = 1950;

        for (int i = 1; i < year.length; i++) {
            year[i] += year[i-1];
            if(year[i] > maxPopulation){
                maxPopulation = year[i];
                maxYear = i + 1950;
            }
        }
        return maxYear;
    }
}
