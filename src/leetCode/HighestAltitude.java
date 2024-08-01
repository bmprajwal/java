package leetCode;

public class HighestAltitude {
    static public int largestAltitude(int[] gain) {
        int currentAlt = 0;
        int max = 0;
        for(int alt: gain){
            currentAlt += alt;
            if(currentAlt > max){
                max = currentAlt;
            }
        }
        return max;
    }
}
