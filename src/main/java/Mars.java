public class Mars {
    public static void main(String[] args) {
        MarCar car = new MarCar(new Blocks(new PointMar[0]));
        String location = car.run("size:100,100 location:0,0,N f:1");
        System.out.println("小车的位置:"+location);
    }
}
