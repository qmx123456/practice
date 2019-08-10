public class NumberOut {
    int num;
    public NumberOut(int i) {
        num=i;
    }

    public String out() {
        String res = null;
        if (num%3 == 0){
            res = "Fizz";
        }else {
            res = Integer.toString(num);
        }
        return res;
    }
}
