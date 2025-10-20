class City {
    private int population;
    private double area;
    
    public void init() {
        population = 0;
        area = 0.0;
    }
    public void read(int population, double area){
        this.population = population;
        this.area = area;
    }
    public void display(){
        System.out.println("Население: " + population + " Площадь: " + area);
    }
    public double plotCity(){
        return population / area;
    }
    public int getPopu(){
        return population;
    }
    public double getArea(){
        return area;
    }
    public String toString() {
        return "Население: " + population + ", Площадь: " + area;
    }
}
class Country {
    private City city1 = new City();
    private City city2 = new City();
    private City city3 = new City();
    private double NoCityArea;
    private int NoCityPopu;
    
    public void init() {
        city1.init();
        city2.init();
        city3.init();
        NoCityPopu = 0;
        NoCityArea = 0.0;
    }
    public void read(City c1, City c2, City c3, double NoCityArea, int NoCityPopu){
        this.city1 = c1;
        this.city2 = c2;
        this.city3 = c3;
        this.NoCityPopu = NoCityPopu;
        this.NoCityArea = NoCityArea;
    }
    public void display(){
        System.out.println("Город 1:");
        city1.display();
        System.out.println("Город 2:");
        city2.display();
        System.out.println("Город 3:");
        city3.display();
        System.out.println("Население проживающие не в городах: "+ NoCityPopu);
        System.out.println("Площадь не занятая городами: " + NoCityArea);
    }
    public double plotCountry(){
        int totalPopu = city1.getPopu() + city2.getPopu() + city3.getPopu() + NoCityPopu;
        double totalArea = city1.getArea() + city2.getArea() + city3.getArea() + NoCityArea;
        return totalPopu / totalArea;
    }
    public City MostPlotCity(){
        double plot1 = city1.plotCity();
        double plot2 = city2.plotCity();
        double plot3 = city3.plotCity();
        if (plot1 > plot2 && plot1 > plot3) {
            return city1;}
        else if (plot2 > plot1 && plot2 > plot3) {
            return city2;}
        else {
            return city3;}
    }
}
public class Main
{
    public static void main(String[] args) {
        City city1 = new City();
        city1.read(10000, 23763.71);
        City city2 = new City();
        city2.read(12000, 21030.6);
        City city3 = new City();
        city3.read(29000, 70293.0);
        Country country = new Country();
        country.read(city1, city2, city3, 120563.9, 46324);
        country.display();
        System.out.println("Средняя плотность населения страны: "+ country.plotCountry());
        System.out.println("Самый плотнозаселенный город: "+ country.MostPlotCity());
    }
}