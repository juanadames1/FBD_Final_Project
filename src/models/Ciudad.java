
package models;

public class Ciudad {
    private int ID;              
    private String Name;          
    private String CountryCode;   
    private String District;           
    private int Population;                    
    
    public Ciudad(){
        this.ID = 0;         
        this.Name = "";       
        this.CountryCode = "";
        this.District = "";   
        this.Population = 0; 
    }

    public Ciudad(int ID, String Name, String CountryCode, String District, int Population) {
        this.ID = ID;
        this.Name = Name;
        this.CountryCode = CountryCode;
        this.District = District;
        this.Population = Population;
    }
    

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public void setPopulation(int Population) {
        this.Population = Population;
    }
    

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getDistrict() {
        return District;
    }

    public int getPopulation() {
        return Population;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); 
    }
}
