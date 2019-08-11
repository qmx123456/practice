public class NumberOut {
    int num;

    public NumberOut(int i) {
        num=i;
    }

    public String out() {
        String res = null;
        if (isRelatedTo(3) && isRelatedTo(5)){
            res = "FizzBuzz";
        }else if (isRelatedTo(5)){
            res = "Buzz";
        }else if (isRelatedTo(3)){
            res = "Fizz";
        }else {
            res = Integer.toString(num);
        }
        return res;
    }

    private boolean isRelatedTo(int i) {
        return num % i == 0;
    }

}
