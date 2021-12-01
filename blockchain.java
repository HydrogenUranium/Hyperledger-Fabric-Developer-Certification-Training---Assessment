public class blockchain {

    public static void main(String[] args) {
        factorial(30);
    }

    public static void factorial(Integer num) {
        Integer testNum = 1;
        Integer totalSum = 0;
        for (int i = 1; i <= num; i++) {
            testNum = testNum * i;
        }

        int[] testNumArry = String.valueOf(testNum).chars().map(Character::getNumericValue).toArray();

        for (int i = 0 ; i < testNumArry.length ; i++ ){
            totalSum = totalSum + testNumArry[i];
        }
        
        System.out.println("Factorial Number " + testNum);
        System.out.println("Total Number " + totalSum);  

    }

}
