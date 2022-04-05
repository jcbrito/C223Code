

/**
 *
 * @author Juan B
 */
public class Capital {
    
    private String name;
    private int population;
    private double area;
    
    public Capital(String name, int population, double area){
        
        this.name = name;
        this.population = population;
        this.area = area;
        
    }
    
    public void setName(String name){
        
        this.name = name;
    }
    
    public String getName(){
        
        return name;
    }
    
    public void setPopulation(int population){
        
        this.population = population;
    }
    
    public int getPopulation(){
        
        return population;
    }
    
    public void setArea(double area){
        
        this.area = area;
    }
    
    public double getArea(){
        
        return area;
    }
    
    @Override
    public String toString(){
        
        return "Name: " + name +" | Population: " + population +" | Area: " + area +" sq mi";
    }
    
}
