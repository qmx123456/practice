public class NumberOut {
    public static void main(String[] args) {
        getNum(50);
        getAll(100);
    }

    private static void getNum(int i) {
        System.out.println(i + " = " + new NumberOut(i).out());
    }

    private static void getAll(int max) {
        for (int i = 1; i<= max; i++){
            getNum(i);
        }
    }

    int num;
    public NumberOut(int i) {
        num=i;
    }

    public String out() {

        String res = "";
        if (isRelatedTo(3) && isRelatedTo(5)) {
            res = "FizzBuzz";
        }
        if (res=="" && isRelatedTo(3)){
            res = "Fizz";
        }
        if (res=="" && isRelatedTo(5)) {
            res = "Buzz";
        }
        if (res=="") {
            res = Integer.toString(num);
        }
        return res;
    }

    private boolean isRelatedTo(int i) {
        return num % i == 0;
    }
}
