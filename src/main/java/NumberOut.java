public class NumberOut {
    int num;
    public NumberOut(int i) {
        num=i;
    }

    public String out() {
        String res = "";
        if (num%3 == 0){
            res = "Fizz";
        }
        if (res==""&& num%5==0) {
            res = "Buzz";
        }
        if (res=="") {
            res = Integer.toString(num);
        }
        return res;
    }
}
