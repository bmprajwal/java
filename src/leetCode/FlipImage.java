package leetCode;

public class FlipImage {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row : image){
            // reverse the elements in row
            for (int i = 0; i < (row.length + 1) / 2; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[row.length - 1 - i] ^ 1;
                row[row.length - 1 - i] = temp;
            }
        }
        return image;
    }
}
