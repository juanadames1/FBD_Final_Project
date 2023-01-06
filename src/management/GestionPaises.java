package management;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Pais;
import connectcionDb.Connector;
import javax.swing.JOptionPane;

public class GestionPaises {

    Connector con = new Connector();

    public ObservableList<Pais> getTodosPaises() {
        ObservableList<Pais> obs = FXCollections.observableArrayList();

        try {
            this.con.connect();

            this.con.rs = this.con.stmt.executeQuery("SELECT * FROM country");

            while (this.con.rs.next()) {
                String Code = this.con.rs.getString("Code");
                String Name = this.con.rs.getString("Name");
                String Continent = this.con.rs.getString("Continent");
                String Region = this.con.rs.getString("Region");
                float SurfaceArea = this.con.rs.getFloat("SurfaceArea");
                int IndepYear = this.con.rs.getInt("IndepYear");
                int Population = this.con.rs.getInt("Population");
                float LifeExpectancy = this.con.rs.getFloat("LifeExpectancy");
                float GNP = this.con.rs.getFloat("GNP");
                float GNPOld = this.con.rs.getFloat("GNPOld");
                String LocalName = this.con.rs.getString("LocalName");
                String GovernmentForm = this.con.rs.getString("GovernmentForm");
                String HeadOfState = this.con.rs.getString("HeadOfState");
                int Capital = this.con.rs.getInt("Capital");
                String Code2 = this.con.rs.getString("Code2");

                Pais p = new Pais(Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2);
                obs.add(p);
            }
            this.con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(GestionPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public ObservableList<Pais> getFiltroBasicoPaises(String code, String name, String limit) {
        ObservableList<Pais> obs = FXCollections.observableArrayList();
        String query = "SELECT * FROM country ";

        try {
            this.con.connect();

            if (!code.isEmpty() || !name.isEmpty()) {
                query += "WHERE ";
            }
            if (!code.isEmpty() && !name.isEmpty()) {
                query += "(Code REGEXP '" + code + "') AND (Name REGEXP '" + name + "')";
            } else {
                if (!code.isEmpty()) {
                    query += "(Code REGEXP '" + code + "')";
                }
                if (!name.isEmpty()) {
                    query += "(Name REGEXP '" + name + "')";
                }
            }
            if (!limit.isEmpty()) {
                query += " LIMIT " + limit;
            }

            System.out.println(query);
            this.con.rs = this.con.stmt.executeQuery(query);

            while (this.con.rs.next()) {
                String Code = this.con.rs.getString("Code");
                String Name = this.con.rs.getString("Name");
                String Continent = this.con.rs.getString("Continent");
                String Region = this.con.rs.getString("Region");
                float SurfaceArea = this.con.rs.getFloat("SurfaceArea");
                int IndepYear = this.con.rs.getInt("IndepYear");
                int Population = this.con.rs.getInt("Population");
                float LifeExpectancy = this.con.rs.getFloat("LifeExpectancy");
                float GNP = this.con.rs.getFloat("GNP");
                float GNPOld = this.con.rs.getFloat("GNPOld");
                String LocalName = this.con.rs.getString("LocalName");
                String GovernmentForm = this.con.rs.getString("GovernmentForm");
                String HeadOfState = this.con.rs.getString("HeadOfState");
                int Capital = this.con.rs.getInt("Capital");
                String Code2 = this.con.rs.getString("Code2");

                Pais p = new Pais(Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2);
                obs.add(p);
            }
            this.con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(GestionPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public ObservableList<Pais> getFiltroBasicoPaisesME(String code, String name, String localname) {
        ObservableList<Pais> obs = FXCollections.observableArrayList();
        String query = "SELECT * FROM country ";

        try {
            this.con.connect();

            if (!code.isEmpty() || !name.isEmpty() || !localname.isEmpty()) {
                query += "WHERE ";
            }
            if (!code.isEmpty() && !name.isEmpty() && !localname.isEmpty()) {
                query += "(Code REGEXP '" + code + "') AND (Name REGEXP '" + name + "') AND (LocalName REGEXP '" + localname + "')";
            } else if (!code.isEmpty() && !name.isEmpty()) {
                query += "(Code REGEXP '" + code + "') AND (Name REGEXP '" + name + "')";
            } else if (!code.isEmpty() && !localname.isEmpty()) {
                query += "(Code REGEXP '" + code + "') AND (LocalName REGEXP '" + localname + "')";
            } else if (!name.isEmpty() && !localname.isEmpty()) {
                query += "(Name REGEXP '" + name + "') AND (LocalName REGEXP '" + localname + "')";
            } else if (!code.isEmpty()) {
                query += "(Code REGEXP '" + code + "')";
            } else if (!name.isEmpty()) {
                query += "(Name REGEXP '" + name + "')";
            } else if (!localname.isEmpty()) {
                query += "(LocalName REGEXP '" + localname + "')";
            }

            System.out.println(query);
            this.con.rs = this.con.stmt.executeQuery(query);

            while (this.con.rs.next()) {
                String Code = this.con.rs.getString("Code");
                String Name = this.con.rs.getString("Name");
                String Continent = this.con.rs.getString("Continent");
                String Region = this.con.rs.getString("Region");
                float SurfaceArea = this.con.rs.getFloat("SurfaceArea");
                int IndepYear = this.con.rs.getInt("IndepYear");
                int Population = this.con.rs.getInt("Population");
                float LifeExpectancy = this.con.rs.getFloat("LifeExpectancy");
                float GNP = this.con.rs.getFloat("GNP");
                float GNPOld = this.con.rs.getFloat("GNPOld");
                String LocalName = this.con.rs.getString("LocalName");
                String GovernmentForm = this.con.rs.getString("GovernmentForm");
                String HeadOfState = this.con.rs.getString("HeadOfState");
                int Capital = this.con.rs.getInt("Capital");
                String Code2 = this.con.rs.getString("Code2");

                Pais p = new Pais(Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2);
                obs.add(p);
            }
            this.con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(GestionPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public Boolean verifyCountryCode(String cod) {
        boolean existe = false;
        String Code = "";
        try {
            this.con.connect();

            this.con.rs = this.con.stmt.executeQuery("SELECT * FROM country");

            while (this.con.rs.next()) {
                Code = this.con.rs.getString("Code");
                if (Code.equals(cod)) {
                    existe = true;
                    break;
                }
            }
            this.con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(GestionPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }

    public ObservableList<Pais> getFiltroAvanzadoPaises(String limit, String tipodeBusq, String code, String name, String continent, String region, String surfaceArea, String indepYear, String population, String lifeExpectancy, String gnp, String gnpOld, String localName, String governmentForm, String headOfState, String capital, String code2, String comparatorCol, String comparator, String comparatornum) {
        ObservableList<Pais> obs = FXCollections.observableArrayList();
        int llenos = 0;
        int campos = 1;
        String query = "SELECT * FROM country ";

        if (!code.isEmpty()) {
            llenos++;
        }
        if (!name.isEmpty()) {
            llenos++;
        }
        if (!continent.isEmpty()) {
            llenos++;
        }
        if (!region.isEmpty()) {
            llenos++;
        }
        if (!surfaceArea.isEmpty()) {
            llenos++;
        }
        if (!indepYear.isEmpty()) {
            llenos++;
        }
        if (!population.isEmpty()) {
            llenos++;
        }
        if (!lifeExpectancy.isEmpty()) {
            llenos++;
        }
        if (!gnp.isEmpty()) {
            llenos++;
        }
        if (!gnpOld.isEmpty()) {
            llenos++;
        }
        if (!localName.isEmpty()) {
            llenos++;
        }
        if (!governmentForm.isEmpty()) {
            llenos++;
        }
        if (!headOfState.isEmpty()) {
            llenos++;
        }
        if (!capital.isEmpty()) {
            llenos++;
        }
        if (!code2.isEmpty()) {
            llenos++;
        }
        try {
            this.con.connect();

            if (llenos >= 1) {
                query += "WHERE ";
            }
            if (!code.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "Code", code, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "Code", code, 2);
                }
                campos++;
            }
            if (!name.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "Name", name, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "Name", name, 2);
                }
                campos++;
            }
            if (!continent.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "Continent", continent, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "Continent", continent, 2);
                }
                campos++;
            }
            if (!region.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "Region", region, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "Region", region, 2);
                }
                campos++;
            }
            if (!surfaceArea.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "SurfaceArea", surfaceArea, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "SurfaceArea", surfaceArea, 2);
                }
                campos++;
            }
            if (!indepYear.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "IndepYear", indepYear, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "IndepYear", indepYear, 2);
                }
                campos++;
            }
            if (!population.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "Population", population, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "Population", population, 2);
                }
                campos++;
            }
            if (!lifeExpectancy.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "LifeExpectancy", lifeExpectancy, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "LifeExpectancy", lifeExpectancy, 2);
                }
                campos++;
            }
            if (!gnp.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "GNP", gnp, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "GNP", gnp, 2);
                }
                campos++;
            }
            if (!gnpOld.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "GNPOld", gnpOld, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "GNPOld", gnpOld, 2);
                }
                campos++;
            }
            if (!localName.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "LocalName", localName, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "LocalName", localName, 2);
                }
                campos++;
            }
            if (!governmentForm.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "GovernmentForm", governmentForm, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "GovernmentForm", governmentForm, 2);
                }
                campos++;
            }
            if (!headOfState.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "HeadOfState", headOfState, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "HeadOfState", headOfState, 2);
                }
                campos++;
            }
            if (!capital.isEmpty()) {
                if (campos < llenos) {
                    this.creaQuery(tipodeBusq, "Capital", capital, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "Capital", capital, 2);
                }
                campos++;
            }
            if (!code2.isEmpty()) {
                if (campos < llenos) {
                    query += this.creaQuery(tipodeBusq, "Code2", code2, 1);
                } else if (campos == llenos) {
                    query += this.creaQuery(tipodeBusq, "Code2", code2, 2);
                }
                campos++;
            }

            if (comparatorCol != null && comparator != null && !comparatornum.isEmpty()) {
                comparatorCol = this.valorNum(comparatorCol);
                if (llenos == 0) {
                    query += "WHERE (" + comparatorCol + " " + comparator + " " + comparatornum + ")";
                } else {
                    query += " AND (" + comparatorCol + " " + comparator + " " + comparatornum + ")";
                }
            }

            if (!limit.isEmpty()) {
                query += " LIMIT " + limit;
            }

            System.out.println(query);
            this.con.rs = this.con.stmt.executeQuery(query);

            while (this.con.rs.next()) {
                String Code = this.con.rs.getString("Code");
                String Name = this.con.rs.getString("Name");
                String Continent = this.con.rs.getString("Continent");
                String Region = this.con.rs.getString("Region");
                float SurfaceArea = this.con.rs.getFloat("SurfaceArea");
                int IndepYear = this.con.rs.getInt("IndepYear");
                int Population = this.con.rs.getInt("Population");
                float LifeExpectancy = this.con.rs.getFloat("LifeExpectancy");
                float GNP = this.con.rs.getFloat("GNP");
                float GNPOld = this.con.rs.getFloat("GNPOld");
                String LocalName = this.con.rs.getString("LocalName");
                String GovernmentForm = this.con.rs.getString("GovernmentForm");
                String HeadOfState = this.con.rs.getString("HeadOfState");
                int Capital = this.con.rs.getInt("Capital");
                String Code2 = this.con.rs.getString("Code2");

                Pais p = new Pais(Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2);
                obs.add(p);
            }
            this.con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(GestionPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public String creaQuery(String tipodeBusq, String nombre, String valor, int caso) {
        String query = "";
        int casodeBusq = this.casoDeBusq(tipodeBusq);

        switch (casodeBusq) {
            case 1:
                //"Que contenga..."
                if (caso == 1) {
                    query = "(" + nombre + " REGEXP '" + valor + "') AND ";
                } else if (caso == 2) {
                    query = "(" + nombre + " REGEXP '" + valor + "')";
                }   break;
            case 2:
                //Que empiece por...
                if (caso == 1) {
                    query = "(" + nombre + " REGEXP '^" + valor + "') AND ";
                } else if (caso == 2) {
                    query = "(" + nombre + " REGEXP '^" + valor + "')";
                }   break;
            case 3:
                //Que termine por...
                if (caso == 1) {
                    query = "(" + nombre + " REGEXP '" + valor + "$') AND ";
                } else if (caso == 2) {
                    query = "(" + nombre + " REGEXP '" + valor + "$')";
                }   break;
            default:
                break;
        }
        return query;
    }

    public String valorNum(String column) {
        String vColumn = "NO";
        if (null != column) {
            switch (column) {
                case "Área de superficie":
                    vColumn = "SurfaceArea";
                    break;
                case "Año de independencia":
                    vColumn = "IndepYear";
                    break;
                case "Población":
                    vColumn = "Population";
                    break;
                case "Esperanza de vida":
                    vColumn = "LifeExpectancy";
                    break;
                case "PIB":
                    vColumn = "GNP";
                    break;
                case "PIBold":
                    vColumn = "GNPOld";
                    break;
                case "Capital":
                    vColumn = "Capital";
                    break;
                default:
                    vColumn = "NO";
                    break;
            }
        }
        return vColumn;
    }
    
    public Integer casoDeBusq(String tipo){
        int caso = 1;
        if(tipo != null){
            switch (tipo){
                case "Que contenga...":
                    caso = 1;
                    break;
                case "Que empiece por...":
                    caso = 2;
                    break;
                case "Que termine por...":
                    caso = 3;
                    break;
                default:
                    caso = 1;
                    break;
            }
        }
        return caso;
    }


    public void alterkeys() {
        try {
            String sql = "ALTER TABLE city DROP FOREIGN KEY city_ibfk_1";
            String sql1 = "ALTER TABLE city add constraint city_ibfk_1 FOREIGN KEY (CountryCode) REFERENCES country(CODE) ON DELETE CASCADE ON UPDATE CASCADE";
            String sql2 = "ALTER TABLE countrylanguage DROP FOREIGN KEY countryLanguage_ibfk_1";
            String sql3 = "ALTER TABLE countrylanguage add constraint countryLanguage_ibfk_1 FOREIGN KEY (CountryCode) REFERENCES country(CODE) ON DELETE CASCADE ON UPDATE CASCADE";

            this.con.pst = con.connect().prepareStatement(sql);
            this.con.pst.execute();
            this.con.pst = con.connect().prepareStatement(sql1);
            this.con.pst.execute();
            this.con.pst = con.connect().prepareStatement(sql2);
            this.con.pst.execute();
            this.con.pst = con.connect().prepareStatement(sql3);
            this.con.pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(null, "No se eliminó");
        }
    }

    public void modPaises(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15) {
        try {
            this.con.connect();
            if (this.validaModPais(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14, value15)) {
                String sqls = "UPDATE country set "
                        + "Code='" + value1 + "',"
                        + "Name='" + value2 + "',"
                        + "Continent='" + value3 + "',"
                        + "Region='" + value4 + "',"
                        + "SurfaceArea='" + value5 + "',"
                        + "IndepYear='" + value6 + "',"
                        + "Population='" + value7 + "',"
                        + "LifeExpectancy='" + value8 + "',"
                        + "GNP='" + value9 + "',"
                        + "GNPOld='" + value10 + "',"
                        + "LocalName='" + value11 + "',"
                        + "GovernmentForm='" + value12 + "',"
                        + "HeadOfState='" + value13 + "',"
                        + "Capital='" + value14 + "',"
                        + "Code2='" + value15 + "' WHERE Code ='" + value1 + "'";
                this.con.pst = con.connect().prepareStatement(sqls);
                this.con.pst.execute();
                JOptionPane.showMessageDialog(null, "Modificación exitosa");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique el tipo de dato ingresado");

        }

    }

    private boolean validaModPais(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15) {

        if (value1.equals("") || value2.equals("") || value3.equals("") || value4.equals("") || value5.equals("") || value6.equals("") || value7.equals("") || value8.equals("") || value9.equals("") || value10.equals("") || value11.equals("") || value12.equals("") || value13.equals("") || value14.equals("") || value15.equals("")) {
            JOptionPane.showMessageDialog(null, "¡Ingrese todos los datos!");
            return false;
        } else if (value1.length() > 3) {
            JOptionPane.showMessageDialog(null, "Código no debe pasar los 3 dígitos");
            return false;
        } else if (value2.length() > 52) {
            JOptionPane.showMessageDialog(null, "Nombre no debe pasar los 52 dígitos");
            return false;
        } else if (value4.length() > 26) {
            JOptionPane.showMessageDialog(null, "Región no debe pasar los 26 dígitos");
            return false;
        } else if (value6.length() > 6) {
            JOptionPane.showMessageDialog(null, "Año de independencia no debe pasar los 6 dígitos");
            return false;
        } else if (value7.length() > 11) {
            JOptionPane.showMessageDialog(null, "Población no debe pasar los 11 dígitos");
            return false;
        } else if (value11.length() > 45) {
            JOptionPane.showMessageDialog(null, "Nombre local no debe pasar los 45 dígitos");
            return false;
        } else if (value12.length() > 45) {
            JOptionPane.showMessageDialog(null, "Forma de gobierno no debe pasar los 45 dígitos");
            return false;
        } else if (value13.length() > 60) {
            JOptionPane.showMessageDialog(null, "Presidente no debe pasar los 60 dígitos");
            return false;
        } else if (value14.length() > 11) {
            JOptionPane.showMessageDialog(null, "Capital no debe pasar los 11 dígitos");
            return false;
        } else if (value15.length() > 2) {
            JOptionPane.showMessageDialog(null, "Código 2 no debe pasar los 2 dígitos");
            return false;
        } else {
            return true;
        }
    }

    public void elimPais(String code) {
        try {
            this.con.connect();
            this.alterkeys();

            String sql = "DELETE from country WHERE Code='" + code + "'";
            this.con.pst = con.connect().prepareStatement(sql);
            this.con.pst.execute();

            JOptionPane.showMessageDialog(null, "Eliminado correctamente");

        } catch (SQLException ex) {
            Logger.getLogger(null, "País no fue eliminado correctamente");
        }
    }
    
    public void creaPais(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15){
        
        try {
            if(this.validaModPais(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14, value15)){
            String sql = "INSERT INTO country (Code,Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2) "
                    + "VALUES ('" + value1 + "','"
                    + value2 + "','" + value3 + "','"
                    + value4 + "','" + value5 + "','"
                    + value6 + "','" + value7 + "','"
                    + value8 + "','" + value9 + "','"
                    + value10 + "','" + value11 + "','"
                    + value12 + "','" + value13 + "','"
                    + value14 + "','" + value15 + "')";
            System.out.println(sql);           
            this.con.pst = con.connect().prepareStatement(sql);
            this.con.pst.execute();
            JOptionPane.showMessageDialog(null, "País no fue creado correctamente!");}
        } catch (SQLException ex) {
            Logger.getLogger(null, "El país no fue creado correctamente");
        }
    
    }   

}