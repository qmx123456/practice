public class NumberOut {
    int num;
    public NumberOut(int i) {
        num=i;
    }

    public String out() {
        if (num%3 == 0){
            return "Fizz";
        }
        return Integer.toString(num);
    }
}
