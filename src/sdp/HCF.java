package sdp;

public class HCF {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 15;

        while (num2 > 0){
            int temp = num2;
            num2 = num1 % temp;
            num1 = temp;
        }
        System.out.println(num1);
    }
    public static  int calculateHCF(int num1, int num2){
        while(num1!=num2)
        {
            if(num1>num2)
                num1=num1-num2;
            else
                num2=num2-num1;
        }
        return num1;
    }
}
