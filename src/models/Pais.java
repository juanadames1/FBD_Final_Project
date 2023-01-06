
package models;

import java.util.Objects;

public class Pais {
    private String Code;                                     
    private String Name;                                     
    private String Continent;                            
    private String Region;                                
    private float SurfaceArea;                          
    private int IndepYear;                             
    private int Population;                   
    private float LifeExpectancy;                          
    private float GNP;                                    
    private float GNPOld;                                   
    private String LocalName;                                     
    private String GovernmentForm;                                
    private String HeadOfState;                                   
    private int Capital;                                              
    private String Code2;                                             
    
    public Pais(){
        this.Code ="";
        this.Name ="";
        this.Continent ="";
        this.Region ="";
        this.SurfaceArea = 0;
        this.IndepYear = 0;
        this.Population = 0;
        this.LifeExpectancy = 0;
        this.GNP = 0;
        this.GNPOld = 0;
        this.LocalName ="";
        this.GovernmentForm ="";
        this.HeadOfState ="";
        this. Capital = 0;
        this.Code2 ="";
    }

    public Pais(String Code, String Name, String Continent, String Region, float SurfaceArea, int IndepYear, int Population, float LifeExpectancy, float GNP, float GNPOld, String LocalName, String GovernmentForm, String HeadOfState, int Capital, String Code2) {
        this.Code = Code;
        this.Name = Name;
        this.Continent = Continent;
        this.Region = Region;
        this.SurfaceArea = SurfaceArea;
        this.IndepYear = IndepYear;
        this.Population = Population;
        this.LifeExpectancy = LifeExpectancy;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        this.LocalName = LocalName;
        this.GovernmentForm = GovernmentForm;
        this.HeadOfState = HeadOfState;
        this.Capital = Capital;
        this.Code2 = Code2;
    }
    

    public void setCode(String Code) {
        this.Code = Code;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setContinent(String Continent) {
        this.Continent = Continent;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public void setSurfaceArea(float SurfaceArea) {
        this.SurfaceArea = SurfaceArea;
    }

    public void setIndepYear(int IndepYear) {
        this.IndepYear = IndepYear;
    }

    public void setPopulation(int Population) {
        this.Population = Population;
    }

    public void setLifeExpectancy(float LifeExpectancy) {
        this.LifeExpectancy = LifeExpectancy;
    }

    public void setGNP(float GNP) {
        this.GNP = GNP;
    }

    public void setGNPOld(float GNPOld) {
        this.GNPOld = GNPOld;
    }

    public void setLocalName(String LocalName) {
        this.LocalName = LocalName;
    }

    public void setGovernmentForm(String GovernmentForm) {
        this.GovernmentForm = GovernmentForm;
    }

    public void setHeadOfState(String HeadOfState) {
        this.HeadOfState = HeadOfState;
    }

    public void setCapital(int Capital) {
        this.Capital = Capital;
    }

    public void setCode2(String Code2) {
        this.Code2 = Code2;
    }
    
    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }

    public String getContinent() {
        return Continent;
    }

    public String getRegion() {
        return Region;
    }

    public float getSurfaceArea() {
        return SurfaceArea;
    }

    public int getIndepYear() {
        return IndepYear;
    }

    public int getPopulation() {
        return Population;
    }

    public float getLifeExpectancy() {
        return LifeExpectancy;
    }

    public float getGNP() {
        return GNP;
    }

    public float getGNPOld() {
        return GNPOld;
    }

    public String getLocalName() {
        return LocalName;
    }

    public String getGovernmentForm() {
        return GovernmentForm;
    }

    public String getHeadOfState() {
        return HeadOfState;
    }

    public int getCapital() {
        return Capital;
    }

    public String getCode2() {
        return Code2;
    }

    @Override
    public String toString() {
        return "Pais{" + "Code=" + this.Code + ", Name=" + this.Name + ", Continent=" + this.Continent + ", Region=" + this.Region + ", SurfaceArea=" + this.SurfaceArea + ", IndepYear=" + this.IndepYear + ", Population=" + this.Population + ", LifeExpectancy=" + this.LifeExpectancy + ", GNP=" + this.GNP + ", GNPOld=" + this.GNPOld + ", LocalName=" + this.LocalName + ", GovernmentForm=" + this.GovernmentForm + ", HeadOfState=" + this.HeadOfState + ", Capital=" + this.Capital + ", Code2=" + this.Code2 + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        if (Float.floatToIntBits(this.SurfaceArea) != Float.floatToIntBits(other.SurfaceArea)) {
            return false;
        }
        if (this.IndepYear != other.IndepYear) {
            return false;
        }
        if (this.Population != other.Population) {
            return false;
        }
        if (Float.floatToIntBits(this.LifeExpectancy) != Float.floatToIntBits(other.LifeExpectancy)) {
            return false;
        }
        if (Float.floatToIntBits(this.GNP) != Float.floatToIntBits(other.GNP)) {
            return false;
        }
        if (Float.floatToIntBits(this.GNPOld) != Float.floatToIntBits(other.GNPOld)) {
            return false;
        }
        if (this.Capital != other.Capital) {
            return false;
        }
        if (!Objects.equals(this.Code, other.Code)) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Continent, other.Continent)) {
            return false;
        }
        if (!Objects.equals(this.Region, other.Region)) {
            return false;
        }
        if (!Objects.equals(this.LocalName, other.LocalName)) {
            return false;
        }
        if (!Objects.equals(this.GovernmentForm, other.GovernmentForm)) {
            return false;
        }
        if (!Objects.equals(this.HeadOfState, other.HeadOfState)) {
            return false;
        }
        if (!Objects.equals(this.Code2, other.Code2)) {
            return false;
        }
        return true;
    } 
}
