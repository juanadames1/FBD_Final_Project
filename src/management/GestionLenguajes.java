package management;

import connectcionDb.Connector;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import models.Lenguaje;

public class GestionLenguajes {

    Connector con = new Connector();
    GestionPaises p = new GestionPaises();

    public ObservableList<Lenguaje> getTodosLenguajes() {
        ObservableList<Lenguaje> obs = FXCollections.observableArrayList();

        try {
            this.con.connect();

            this.con.rs = this.con.stmt.executeQuery("SELECT * FROM countryLanguage");

            while (this.con.rs.next()) {
                String CountryCode = this.con.rs.getString("CountryCode");
                String Language = this.con.rs.getString("Language");
                String IsOfficial = this.con.rs.getString("IsOfficial");
                float Percentage = this.con.rs.getFloat("Percentage");

                Lenguaje l = new Lenguaje(CountryCode, Language, IsOfficial, Percentage);
                obs.add(l);
            }
            this.con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(GestionPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public ObservableList<Lenguaje> getFiltroBasicoLenguajes(String code, String name, String limit) {
        ObservableList<Lenguaje> obs = FXCollections.observableArrayList();
        String query = "SELECT * FROM countrylanguage ";

        try {
            this.con.connect();

            if (!code.isEmpty() || !name.isEmpty()) {
                query += "WHERE ";
            }
            if (!code.isEmpty() && !name.isEmpty()) {
                query += "(CountryCode REGEXP '" + code + "') AND (Language REGEXP '" + name + "')";
            } else {
                if (!code.isEmpty()) {
                    query += "(CountryCode  REGEXP '" + code + "')";
                }
                if (!name.isEmpty()) {
                    query += "(Language REGEXP '" + name + "')";
                }
            }
            if (!limit.isEmpty()) {
                query += " LIMIT " + limit;
            }

            System.out.println(query);
            this.con.rs = this.con.stmt.executeQuery(query);

            while (this.con.rs.next()) {
                String CountryCode = this.con.rs.getString("CountryCode");
                String Language = this.con.rs.getString("Language");
                String IsOfficial = this.con.rs.getString("IsOfficial");
                float Percentage = this.con.rs.getFloat("Percentage");

                Lenguaje l = new Lenguaje(CountryCode, Language, IsOfficial, Percentage);
                obs.add(l);
            }
            this.con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(GestionPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public ObservableList<Lenguaje> getFiltroBasicoLenguajesME(String code, String language) {
        ObservableList<Lenguaje> obs = FXCollections.observableArrayList();
        String query = "SELECT * FROM countrylanguage ";

        try {
            this.con.connect();

            if (!code.isEmpty() || !language.isEmpty()) {
                query += "WHERE ";
            }
            if (!code.isEmpty() && !language.isEmpty()) {
                query += "(CountryCode REGEXP '" + code + "') AND (Language REGEXP '" + language + "')";
            } else {
                if (!code.isEmpty()) {
                    query += "(CountryCode  REGEXP '" + code + "')";
                }
                if (!language.isEmpty()) {
                    query += "(Language REGEXP '" + language + "')";
                }
            }

            System.out.println(query);
            this.con.rs = this.con.stmt.executeQuery(query);

            while (this.con.rs.next()) {
                String CountryCode = this.con.rs.getString("CountryCode");
                String Language = this.con.rs.getString("Language");
                String IsOfficial = this.con.rs.getString("IsOfficial");
                float Percentage = this.con.rs.getFloat("Percentage");

                Lenguaje l = new Lenguaje(CountryCode, Language, IsOfficial, Percentage);
                obs.add(l);
            }
            this.con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(GestionPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public ObservableList<Lenguaje> getFiltroAvanzadoLenguajes(String limit, String tipodeBusq,String countryCode, String language, String isOfficial, String percentage, String comparatorCol, String comparator, String comparatornum) {
        ObservableList<Lenguaje> obs = FXCollections.observableArrayList();
        int llenos = 0;
        int campos = 1;
        String query = "SELECT * FROM countrylanguage ";
        
        if (!countryCode.isEmpty()) {
            llenos++;
        }
        if (!language.isEmpty()) {
            llenos++;
        }
        if (!isOfficial.isEmpty()) {
            llenos++;
        }
        if (!percentage.isEmpty()) {
            llenos++;
        }

        try {
            this.con.connect();

            if (llenos >= 1) {
                query += "WHERE ";
            }
            if (!countryCode.isEmpty()) {
                if (campos < llenos) {
                    query += this.p.creaQuery(tipodeBusq, "CountryCode", countryCode, 1);
                } else if (campos == llenos) {
                    query += this.p.creaQuery(tipodeBusq, "CountryCode", countryCode, 2);
                }
                campos++;
            }
            if (!language.isEmpty()) {
                if (campos < llenos) {
                    query += this.p.creaQuery(tipodeBusq, "Language", language, 1);
                } else if (campos == llenos) {
                    query += this.p.creaQuery(tipodeBusq, "Language", language, 2);
                }
                campos++;
            }
            if (!isOfficial.isEmpty()) {
                if (campos < llenos) {
                    query += this.p.creaQuery(tipodeBusq, "IsOfficial", isOfficial, 1);
                } else if (campos == llenos) {
                    query += this.p.creaQuery(tipodeBusq, "IsOfficial", isOfficial, 2);
                }
                campos++;
            }
            if (!percentage.isEmpty()) {
                if (campos < llenos) {
                    query += this.p.creaQuery(tipodeBusq, "Percentage", percentage, 1);
                } else if (campos == llenos) {
                    query += this.p.creaQuery(tipodeBusq, "Percentage", percentage, 2);
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
                String CountryCode = this.con.rs.getString("CountryCode");
                String Language = this.con.rs.getString("Language");
                String IsOfficial = this.con.rs.getString("IsOfficial");
                float Percentage = this.con.rs.getFloat("Percentage");

                Lenguaje l = new Lenguaje(CountryCode, Language, IsOfficial, Percentage);
                obs.add(l);
            }
            this.con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(GestionPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    private String valorNum(String column) {
        String vColumn = "";
        if (null != column) {
            switch (column) {
                case "Porcentaje":
                    vColumn = "Percentage";
                    break;
                default:
                    vColumn = "";
                    break;
            }
        }
        return vColumn;
    }

    public void modLeng(String value1, String value2, String value3, String value4) {

        try {
            if (this.validaModLeng(value1, value2, value3, value4)) {
                String sqls = "UPDATE CountryLanguage set "
                        + "CountryCode='" + value1 + "',"
                        + "Language='" + value2 + "',"
                        + "IsOfficial='" + value3 + "',"
                        + "Percentage='" + value4 + "' WHERE CountryCode ='" + value1 + "' AND Language='" + value2 + "'";
                System.out.println(sqls);
                this.con.pst = con.connect().prepareStatement(sqls);
                this.con.pst.execute();
                JOptionPane.showMessageDialog(null, "Modificación exitosa");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique el tipo de datos ingresados");
        }
    }

    private boolean validaModLeng(String value1, String value2, String value3, String value4) {
        try {
            Float.parseFloat(value4);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Recuerde que el decimal se expresa con un .");
            return false;
        }
        if (value1.equals("") || value2.equals("") || value3 == null || value4.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
            return false;
        } else if ((value1).length() > 3) {
            JOptionPane.showMessageDialog(null, "Código no debe pasar los 3 dígitos");
            return false;
        } else if ((value2).length() > 30) {
            JOptionPane.showMessageDialog(null, "Idioma no debe pasar los 30 dígitos");
            return false;
        } else if (!p.verifyCountryCode(value1)) {
            JOptionPane.showMessageDialog(null, "El código no existe");
            return false;
        } else {
            return true;
        }

    }

    public void elimLeng(String code1, String name1) {
        try {
            this.con.connect();
            String sql = "DELETE from countrylanguage WHERE Countrycode='" + code1 + "' AND Language='" + name1 + "'";
            System.out.println("" + sql);
            this.con.pst = con.connect().prepareStatement(sql);
            this.con.pst.execute();
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(null, "El idioma no fue eliminado correctamente");
        }
    }

    public void creaLeng(String value1, String value2, String value3, String value4) {
        try {
            if (this.validaModLeng(value1, value2, value3, value4)) {
                this.con.connect();
                String sql = "INSERT INTO countrylanguage (CountryCode, Language, IsOfficial, Percentage) "
                        + "VALUES ('" + value1 + "','" + value2 + "','" + value3 + "','" + value4 + "')";
                this.con.pst = con.connect().prepareStatement(sql);
                this.con.pst.execute();
                JOptionPane.showMessageDialog(null, "Idioma creado correctamente!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(null, "El idioma no fue creado correctamente");
        }
    }
}
