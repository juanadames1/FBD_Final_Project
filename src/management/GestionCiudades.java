package management;

import connectcionDb.Connector;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import models.Ciudad;

public class GestionCiudades {

    Connector con = new Connector();
    GestionPaises p = new GestionPaises();

    public ObservableList<Ciudad> getTodasCiudades() {
        ObservableList<Ciudad> obs = FXCollections.observableArrayList();

        try {
            //Se abre la conexión con la base de datos
            this.con.connect();

            //Hago la consulta
            this.con.rs = this.con.stmt.executeQuery("SELECT * FROM city");

            // recorre por los resultados
            while (this.con.rs.next()) {
                // Tomo los datos
                int ID = this.con.rs.getInt("ID");
                String Name = this.con.rs.getString("Name");
                String CountryCode = this.con.rs.getString("CountryCode");
                String District = this.con.rs.getString("District");
                int Population = this.con.rs.getInt("Population");

                //Creamos la vista
                Ciudad p = new Ciudad(ID, Name, CountryCode, District, Population);
                obs.add(p);
            }
            //Por seguridad, siempre cerramos la conexión
            this.con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(GestionPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public ObservableList<Ciudad> getFiltroBasicoCiudades(String code, String name, String limit) {
        ObservableList<Ciudad> obs = FXCollections.observableArrayList();
        String query = "SELECT * FROM city ";

        try {
            this.con.connect();

            //Validaciones filtros 
            if (!code.isEmpty() || !name.isEmpty()) {
                query += "WHERE ";
            }
            if (!code.isEmpty() && !name.isEmpty()) {
                query += "(ID REGEXP '" + code + "') AND (Name REGEXP '" + name + "')";
            } else {
                if (!code.isEmpty()) {
                    query += "(ID REGEXP '" + code + "')";
                }
                if (!name.isEmpty()) {
                    query += "(Name REGEXP '" + name + "')";
                }
            }

            if (!limit.isEmpty()) {
                query += " LIMIT " + limit;
            }

            System.out.println(query);
            //Hago la consulta
            this.con.rs = this.con.stmt.executeQuery(query);

            //while encargado de recorrer los resultados obtenidos de la base
            while (this.con.rs.next()) {
                int ID = this.con.rs.getInt("ID");
                String Name = this.con.rs.getString("Name");
                String CountryCode = this.con.rs.getString("CountryCode");
                String District = this.con.rs.getString("District");
                int Population = this.con.rs.getInt("Population");

                Ciudad p = new Ciudad(ID, Name, CountryCode, District, Population);
                obs.add(p);
            }

            this.con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(GestionPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public ObservableList<Ciudad> getFiltroBasicoCiudadesMEC(String id1, String name, String countrycode) {
        ObservableList<Ciudad> obs = FXCollections.observableArrayList();
        String query = "SELECT * FROM city ";

        try {
            this.con.connect();

            if (!id1.isEmpty() || !name.isEmpty() || !countrycode.isEmpty()) {
                query += "WHERE ";
            }
            if (!id1.isEmpty() && !name.isEmpty() && !countrycode.isEmpty()) {
                query += "(ID REGEXP '" + id1 + "') AND (Name REGEXP '" + name + "') AND (CountryCode REGEXP '" + countrycode + "')";
            } else if (!id1.isEmpty() && !name.isEmpty()) {
                query += "(ID REGEXP '" + id1 + "') AND (Name REGEXP '" + name + "')";

            } else if (!countrycode.isEmpty() && !name.isEmpty()) {
                query += "(CountryCode REGEXP '" + countrycode + "') AND (Name REGEXP '" + name + "')";

            } else if (!countrycode.isEmpty() && !id1.isEmpty()) {
                query += "(CountryCode REGEXP '" + countrycode + "') AND (ID REGEXP '" + id1 + "')";

            } else if (!id1.isEmpty()) {
                query += "(ID REGEXP '" + id1 + "')";
            } else if (!name.isEmpty()) {
                query += "(Name REGEXP '" + name + "')";
            } else if (!countrycode.isEmpty()) {
                query += "(CountryCode REGEXP '" + countrycode + "')";
            }

            System.out.println(query);
            this.con.rs = this.con.stmt.executeQuery(query);

            while (this.con.rs.next()) {
                int ID = this.con.rs.getInt("ID");
                String Name = this.con.rs.getString("Name");
                String CountryCode = this.con.rs.getString("CountryCode");
                String District = this.con.rs.getString("District");
                int Population = this.con.rs.getInt("Population");

                Ciudad c = new Ciudad(ID, Name, CountryCode, District, Population);
                obs.add(c);
            }
            this.con.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(GestionPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public ObservableList<Ciudad> getFiltroAvanzadoCiudades(String limit, String tipodeBusq, String id, String name, String countryCode, String district, String population, String comparatorCol, String comparator, String comparatornum) {
        ObservableList<Ciudad> obs = FXCollections.observableArrayList();
        int llenos = 0;
        int campos = 1;
        String query = "SELECT * FROM city ";

        if (!id.isEmpty()) {
            llenos++;
        }
        if (!name.isEmpty()) {
            llenos++;
        }
        if (!countryCode.isEmpty()) {
            llenos++;
        }
        if (!district.isEmpty()) {
            llenos++;
        }
        if (!population.isEmpty()) {
            llenos++;
        }

        try {
            this.con.connect();

            if (llenos >= 1) {
                query += "WHERE ";
            }
            if (!id.isEmpty()) {
                if (campos < llenos) {
                    query += this.p.creaQuery(tipodeBusq, "ID", id, 1);
                } else if (campos == llenos) {
                    query += this.p.creaQuery(tipodeBusq, "ID", id, 2);
                }
                campos++;
            }
            if (!name.isEmpty()) {
                if (campos < llenos) {
                    query += this.p.creaQuery(tipodeBusq, "Name", name, 1);
                } else if (campos == llenos) {
                    query += this.p.creaQuery(tipodeBusq, "Name", name, 2);
                }
                campos++;
            }
            if (!countryCode.isEmpty()) {
                if (campos < llenos) {
                    query += this.p.creaQuery(tipodeBusq, "CountryCode", countryCode, 1);
                } else if (campos == llenos) {
                    query += this.p.creaQuery(tipodeBusq, "CountryCode", countryCode, 2);
                }
                campos++;
            }
            if (!district.isEmpty()) {
                if (campos < llenos) {
                    query += this.p.creaQuery(tipodeBusq, "District", district, 1);
                } else if (campos == llenos) {
                    query += this.p.creaQuery(tipodeBusq, "District", district, 2);
                }
                campos++;
            }
            if (!population.isEmpty()) {
                if (campos < llenos) {
                    query += this.p.creaQuery(tipodeBusq, "Population", population, 1);
                } else if (campos == llenos) {
                    query += this.p.creaQuery(tipodeBusq, "Population", population, 2);
                }
                campos++;
            }

            //Comparador
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
                int ID = this.con.rs.getInt("ID");
                String Name = this.con.rs.getString("Name");
                String CountryCode = this.con.rs.getString("CountryCode");
                String District = this.con.rs.getString("District");
                int Population = this.con.rs.getInt("Population");

                Ciudad p = new Ciudad(ID, Name, CountryCode, District, Population);
                obs.add(p);
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
                case "ID":
                    vColumn = "ID";
                    break;
                case "Población":
                    vColumn = "Population";
                    break;
                default:
                    vColumn = "";
                    break;
            }
        }
        return vColumn;
    }
    public void modCiudad(String value1, String value2, String value3, String value4, String value5) {
        try {
            this.con.connect();
            if (this.validaModLeng(value1, value2, value3, value4, value5)) {

                String sqls = "UPDATE city set "
                        + "ID='" + value1 + "',"
                        + "Name='" + value2 + "',"
                        + "CountryCode='" + value3 + "',"
                        + "District='" + value4 + "',"
                        + "Population='" + value5 + "' WHERE ID ='" + value1 + "'";
                this.con.pst = con.connect().prepareStatement(sqls);
                this.con.pst.execute();
                JOptionPane.showMessageDialog(null, "Modificación exitosa");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique el tipo de dato ingresado");

        }

    }

    private boolean validaModLeng(String value1, String value2, String value3, String value4, String value5) {

        try {
            Integer.parseInt(value5);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Recuerde que la población debe ser ingresada en números enteros");
        }
        if (value1.length() > 11) {
            JOptionPane.showMessageDialog(null, "La longitud  del id no debe superar los 11 carácteres");
            return false;

        } else if (value2.length() > 35) {
            JOptionPane.showMessageDialog(null, "La longitud  del nombre no debe superar los 35 carácteres");
            return false;

        } else if (value3.length() > 3) {
            JOptionPane.showMessageDialog(null, "La longitud  del código del país no debe superar los 3 carácteres");
            return false;

        } else if (value4.length() > 20) {
            JOptionPane.showMessageDialog(null, "La longitud  del distrito no debe superar los 20 carácteres");
            return false;

        } else if (value5.length() > 11) {
            JOptionPane.showMessageDialog(null, "La longitud del valor de la población no debe superar los 11 carácteres");
            return false;

        } else if (!p.verifyCountryCode(value3)){
         JOptionPane.showMessageDialog(null, "El código no existe");
            return false;
        }else {
            return true;
        }
    }

    public void eliminCiud(String code) {
        try {
            this.con.connect();
            System.out.println("" + code);
            String sql = "DELETE from city WHERE ID='" + code + "'";
            System.out.println("" + sql);
            this.con.pst = con.connect().prepareStatement(sql);
            this.con.pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(null, "La ciudad no fue eliminada correctamente");
        }

        JOptionPane.showMessageDialog(null, "Eliminado correctamente");
    }
    
    public void creaCiud(String value1, String value2, String value3, String value4, String value5) {
        try {
            if (this.validaModLeng(value1, value2, value3, value4, value5)) {
                this.con.connect();
                String sql = "INSERT INTO city (ID, Name, CountryCode, District, Population) "
                        + "VALUES ('" + value1 + "','" + value2 + "','" + value3 + "','" + value4 + "','" + value5 + "')";
                this.con.pst = con.connect().prepareStatement(sql);
                System.out.println(sql);
                this.con.pst.execute();
                JOptionPane.showMessageDialog(null, "Ciudad creada correctamente!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(null, "La ciudad no fue creada correctamente");
        }
    }
}
