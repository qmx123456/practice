public class NumberOut {
    int num;

    public NumberOut(int i) {
        num=i;
    }

    public String out() {
        String res = "";
        if (isRelatedTo(3) && isRelatedTo(5)){
            res = "FizzBuzz";
        }
        if (res=="" && isRelatedTo(5)){
            res = "Buzz";
        }
        if (res=="" && isRelatedTo(3)){
            res = "Fizz";
        }
        if(res==""){
            res = Integer.toString(num);
        }
        return res;
    }

    private boolean isRelatedTo(int i) {
        return num % i == 0;
    }

}
