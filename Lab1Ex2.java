class Number {
    private int intpart;
    private double doubpart;
    public int getIntpart() {
        return intpart;
    }
    public double getDoubpart() {
        return doubpart;
    }
    public void init() {
        intpart = 0;
        doubpart = 0.0;
    }
    public void read(int intpart, double doubpart){
        this.intpart = intpart;
        this.doubpart = doubpart;
    }
    public void display(){
        System.out.println("Число: " + (getIntpart() + getDoubpart()));
    }
    public int round(){
        if (getDoubpart() < 0.5){
            return getIntpart();
        } else {
            return getIntpart() + 1;
        }
    }
    public static Number add(Number num1, Number num2) {
        int sumint = num1.getIntpart() + num2.getIntpart();
        double sumdoub = num1.getDoubpart() + num2.getDoubpart();
        if (sumdoub >= 1.0) {
            sumint += 1;
            sumdoub -= 1.0;
        }
        Number result = new Number();
        result.intpart = sumint;
        result.doubpart = sumdoub;

        return result;
    }
}
public class Main
{
    public static void main(String[] args) {
        Number num1 = new Number();
        num1.init();
        num1.read(3, 0.7);
        num1.display();
        System.out.println("Округленное число: " + num1.round());
        Number num2 = new Number();
        num2.init();
        num2.read(2, 0.4);
        num2.display();
        System.out.println("Результат сложения: ");
        Number sum = Number.add(num1,num2);
        sum.display();
    }
}
