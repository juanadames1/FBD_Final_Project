
package models;

public class Lenguaje {
    private String CountryCode ;                   
    private String Language ;                            
    private String IsOfficial;                       
    private float Percentage;                         
    
    public Lenguaje(){
        this.CountryCode = "";         
        this.Language = "";       
        this.IsOfficial = "";
        this.Percentage = 0; 
    }

    public Lenguaje(String CountryCode, String Language, String IsOfficial, float Percentage) {
        this.CountryCode = CountryCode;
        this.Language = Language;
        this.IsOfficial = IsOfficial;
        this.Percentage = Percentage;
    }
    
    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public void setIsOfficial(String IsOfficial) {
        this.IsOfficial = IsOfficial;
    }

    public void setPercentage(float Percentage) {
        this.Percentage = Percentage;
    }
    
    public String getCountryCode() {
        return CountryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public String getIsOfficial() {
        return IsOfficial;
    }

    public float getPercentage() {
        return Percentage;
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
