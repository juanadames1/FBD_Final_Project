package control;

import management.GestionCiudades;
import management.GestionLenguajes;
import management.GestionPaises;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.sql.*;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Ciudad;
import models.Lenguaje;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import models.Pais;
import connectcionDb.Connector;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author adams
 */


public class ManagementController implements Initializable {
    GestionPaises p = new GestionPaises();
    GestionCiudades c = new GestionCiudades();
    GestionLenguajes l = new GestionLenguajes();

    private int id;

    @FXML
    private Pane paneHome;
    @FXML
    private MenuItem menuItemPagPrincipal;
    @FXML
    private MenuItem menuItemVerPaises;
    @FXML
    private MenuItem menuItemVerCiudades;
    @FXML
    private MenuBar myMenuBar;
    @FXML
    private MenuItem menuItemCrearPaís;
    @FXML
    private MenuItem menuItemModificaryEliminarPaís;
    @FXML
    private MenuItem menuItemCrearCiudad;
    @FXML
    private MenuItem menuItemModificaryEliminarCiudad;
    @FXML
    private MenuItem menuItemCrearLenguaje;
    @FXML
    private MenuItem menuItemModificaryEliminarLenguaje;
    // Pais
    @FXML
    private Pane paneVerPais;
    @FXML
    private TableView<Pais> tblVerPais;
    @FXML
    private TableColumn<Pais, String> colCodP;
    @FXML
    private TableColumn<Pais, String> colNameP;
    @FXML
    private TableColumn<Pais, String> colContiP;
    @FXML
    private TableColumn<Pais, String> colRegionP;
    @FXML
    private TableColumn<Pais, Float> colSurfAP;
    @FXML
    private TableColumn<Pais, Integer> colIndYP;
    @FXML
    private TableColumn<Pais, Integer> colPopulationP;
    @FXML
    private TableColumn<Pais, Float> colLifeEP;
    @FXML
    private TableColumn<Pais, Float> colGNPP;
    @FXML
    private TableColumn<Pais, Float> colGNPOP;
    @FXML
    private TableColumn<Pais, String> colLocalNP;
    @FXML
    private TableColumn<Pais, String> colGovFormP;
    @FXML
    private TableColumn<Pais, String> colHeadOSP;
    @FXML
    private TableColumn<Pais, Integer> colCapitalP;
    @FXML
    private TableColumn<Pais, String> colCod2P;
    //lenguajes
    @FXML
    private MenuItem menuItemVerLenguajes;
    @FXML
    private Pane paneVerLenguajes;
    @FXML
    private TableView<Lenguaje> tblVerLenguajes;
    @FXML
    private TableColumn<Lenguaje, String> colCountryCodL;
    @FXML
    private TableColumn<Lenguaje, String> collanguageL;
    @FXML
    private TableColumn<Lenguaje, String> colisOffL;
    @FXML
    private TableColumn<Lenguaje, Float> colPercentageL;
    //Ciudades
    @FXML
    private Pane paneVerCiudades;
    @FXML
    private TableView<Ciudad> tblVerCiudad;
    @FXML
    private TableColumn<Ciudad, Integer> colIdC;
    @FXML
    private TableColumn<Ciudad, String> colNameC;
    @FXML
    private TableColumn<Ciudad, String> colCountryCodC;
    @FXML
    private TableColumn<Ciudad, String> colDistrictC;
    @FXML
    private TableColumn<Ciudad, Integer> colPopulationC;
    @FXML
    private TableView<Pais> tblPaisME;
    @FXML
    private TableColumn<Pais, String> colCodigoME;
    @FXML
    private TableColumn<Pais, String> colNombreME;
    @FXML
    private TableColumn<Pais, String> colContinenteME;
    @FXML
    private TableColumn<Pais, Float> colAreaSuperficieME;
    @FXML
    private TableColumn<Pais, Integer> colAñoIndepeME;
    @FXML
    private TableColumn<Pais, Integer> colPoblacionME;
    @FXML
    private TableColumn<Pais, String> colRegionME;
    @FXML
    private TableColumn<Pais, Float> colEspeVidaME;
    @FXML
    private TableColumn<Pais, Float> colPibME;
    @FXML
    private TableColumn<Pais, Float> colPibOld;
    @FXML
    private TableColumn<Pais, String> colNomLocalME;
    @FXML
    private TableColumn<Pais, String> colFormGobME;
    @FXML
    private TableColumn<Pais, String> colCabEstME;
    @FXML
    private TableColumn<Pais, Integer> colCapitalME;
    @FXML
    private TableColumn<Pais, String> colCodigo2ME;
    @FXML
    private TextField txtFiltroTLBP;
    @FXML
    private TextField txtFiltroTNP;
    @FXML
    private TextField txtFiltroTCP;
    @FXML
    private TextField txtFiltroTLBC;
    @FXML
    private TextField txtFiltroTNC;
    @FXML
    private TextField txtFiltroTCC;
    @FXML
    private TextField txtFiltroTLBL;
    @FXML
    private TextField txtFiltroTCL;
    @FXML
    private TextField txtFiltroTNL;
    @FXML
    private Pane paneMEP;
    @FXML
    private TextField txtFiltroCod1MEP;
    @FXML
    private TextField txtFiltroNombreMEP;
    @FXML
    private TextField txtFiltroNombreLocalMEP;
    @FXML
    private Button btnModificarP;
    @FXML
    private Button btnEliminarP;
    private Pane paneMOD;
    private Pane paneMODP;
    private Pane paneMODC;
    @FXML
    private TextField txtModNombreCi;
    @FXML
    private Pane paneMEC;

    @FXML
    private TableView<Ciudad> tblCiudadesME;
    @FXML
    private TextField txtFiltroCod1MEC;
    @FXML
    private TextField txtFiltroNombreMEC;
    @FXML
    private Button btnModificarC;
    @FXML
    private Button btnEliminarC;
    @FXML
    private Pane paneMEL;
    @FXML
    private TextField txtFiltroCod1MEL;
    @FXML
    private TextField txtFiltroNombreMEL;
    @FXML
    private Button btnModificarL;
    @FXML
    private Button btnEliminarL;
    @FXML
    private Pane paneMODL;
    @FXML
    private Button btnGuardarCambiosL;
    @FXML
    private Pane paneCrearP;
    @FXML
    private TextField txtCreaCodP;
    @FXML
    private TextField txtCreaEdvP;
    @FXML
    private TextField txtCreaGobP;
    @FXML
    private TextField txtCreaPresP;
    @FXML
    private TextField txtCreaSupP;
    @FXML
    private TextField txtCreaIndP;
    @FXML
    private TextField txtCreaNombreP;
    @FXML
    private TextField txtCreaNombreLocalP;
    @FXML
    private TextField txtCreaPoblacionP;
    @FXML
    private TextField txtCreaRegionP;
    @FXML
    private TextField txtCreaPIBP;
    @FXML
    private TextField txtCreaPBIoldP;
    @FXML
    private Button btnCrearP;
    @FXML
    private Pane paneCrearC;
    @FXML
    private Pane paneCrearL;
    @FXML
    private MenuItem menuItemBusquedaAvanzadaP;
    @FXML
    private MenuItem menuItemBusquedaAvanzadaC;
    @FXML
    private MenuItem menuItemBusquedaAvanzadaL;
    @FXML
    private Pane paneBAP;
    @FXML
    private Pane paneBAC;
    @FXML
    private Pane paneBAL;
    @FXML
    private TextField txtCreaCod2P;
    @FXML
    private Pane paneModificar;
    @FXML
    public TextField txtCodM;
    @FXML
    private TextField txtNombreM;
    @FXML
    private TextField txtCapitalM;
    @FXML
    private TextField txtPIBM;
    @FXML
    private Button btnModificarM;
    @FXML
    private TextField txtNombreLocalM;
    @FXML
    private TextField txtPoblacionM;
    @FXML
    private TextField txtRegionM;
    @FXML
    private TextField txtEdvM;
    @FXML
    private TextField txtGobM;
    @FXML
    private TextField txtPresM;
    @FXML
    private TextField txtSupM;
    @FXML
    private TextField txtIndM;
    @FXML
    private TextField txtPibOldM;
    @FXML
    private TextField txtCod2M2;

    private String codeME;
    @FXML
    private TableColumn<Ciudad, Integer> colIdMEC;
    @FXML
    private TableColumn<Ciudad, String> colNombreMEC;
    @FXML
    private TableColumn<Ciudad, String> codigoMEC;
    @FXML
    private TableColumn<Ciudad, String> colDistritoMEC;
    @FXML
    private TableColumn<Ciudad, Integer> colPoblacionMEC;
    @FXML
    private Pane paneModificarC;
    @FXML
    private TextField txtModIDC;
    @FXML
    private TextField txtCodPM;
    @FXML
    private TextField txtDistritoMC;
    @FXML
    private TextField txtPoblacionMC;
    @FXML
    private Button btnModC;
    @FXML
    private TextField txtFiltroCodPaisMEC;
    @FXML
    private TableView<Lenguaje> tblIdiomasME;

    @FXML
    private TextField txtCountryCodeL;
    @FXML
    private TextField txtLanguaje;
    @FXML
    private TextField txtPorcentajeL;
    @FXML
    private TextField txtCreaCapitalP;
    @FXML
    private ComboBox<String> cbxCreaContinenteP;
    @FXML
    private TextField txtCreaIDC;
    @FXML
    private TextField txtCreaNombreC;
    @FXML
    private TextField txtCiudadCodP;
    @FXML
    private TextField txtCreaDistrictC;
    @FXML
    private TextField txtCreaPobC;
    @FXML
    private Button btnCrearC;
    @FXML
    private TextField txtCodePL;
    @FXML
    private TextField txtCreaL;
    @FXML
    private Button btnCrearL;
    @FXML
    private ComboBox<String> cbxCreaOfL;
    @FXML
    private TextField txtCreaPorL;
    @FXML
    private TableColumn<Lenguaje, String> colCountryCodLA;
    @FXML
    private TableColumn<Lenguaje, String> collanguageLA;
    @FXML
    private TableColumn<Lenguaje, String> colisOffLA;
    @FXML
    private TableColumn<Lenguaje, String> colPercentageLA;
    @FXML
    private ComboBox<?> cbxCreaOfL1;

    //==================================================Busq Avanaz Pais================================
    @FXML
    private TableView<Pais> tblPaisPBA;
    @FXML
    private CheckBox chbxCodPBA;
    @FXML
    private CheckBox chbxNomPBA;
    @FXML
    private CheckBox chbxContPBA;
    @FXML
    private CheckBox chbxRegPBA;
    @FXML
    private CheckBox chbxSurfAPBA;
    @FXML
    private CheckBox chbxIndepYPBA;
    @FXML
    private CheckBox chbxPopulationPBA;
    @FXML
    private CheckBox chbxLifeExpPBA;
    @FXML
    private CheckBox chbxgnpPBA;
    @FXML
    private CheckBox chbxgnpOldPBA;
    @FXML
    private CheckBox chbxlocalNPBA;
    @FXML
    private CheckBox chbxCapPBA;
    @FXML
    private CheckBox chbxGovFormPBA;
    @FXML
    private CheckBox chbxHeadOfSPBA;
    @FXML
    private CheckBox chbxCode2PBA;
    @FXML
    private TableColumn<Pais, String> colCodPBA;
    @FXML
    private TableColumn<Pais, String> colNamePBA;
    @FXML
    private TableColumn<Pais, String> colContiPBA;
    @FXML
    private TableColumn<Pais, String> colRegionPBA;
    @FXML
    private TableColumn<Pais, Float> colSurfAPBA;
    @FXML
    private TableColumn<Pais, Integer> colIndYPBA;
    @FXML
    private TableColumn<Pais, Integer> colPopulationPBA;
    @FXML
    private TableColumn<Pais, Float> colLifeEPBA;
    @FXML
    private TableColumn<Pais, Float> colGNPPBA;
    @FXML
    private TableColumn<Pais, Float> colGNPOPBA;
    @FXML
    private TableColumn<Pais, String> colLocalNPBA;
    @FXML
    private TableColumn<Pais, String> colGovFormPBA;
    @FXML
    private TableColumn<Pais, String> colHeadOSPBA;
    @FXML
    private TableColumn<Pais, Integer> colCapitalPBA;
    @FXML
    private TableColumn<Pais, String> colCod2PBA;
    @FXML
    private TextField txtFiltroTCPBA;
    @FXML
    private TextField txtFiltroTNPBA;
    @FXML
    private TextField txtFiltroTlocalNPBA;
    @FXML
    private TextField txtFiltroTpopPBA;
    @FXML
    private TextField txtFiltroTContPBA;
    @FXML
    private TextField txtFiltroTregPBA;
    @FXML
    private TextField txtFiltroTlifeExpPBA;
    @FXML
    private TextField txtFiltroTgovFormPBA;
    @FXML
    private TextField txtFiltroTheadOfSPBA;
    @FXML
    private TextField txtFiltroTsurfAPBA;
    @FXML
    private TextField txtFiltroTindepYPBA;
    @FXML
    private TextField txtFiltroTCod2PBA;
    @FXML
    private TextField txtFiltroTCapPBA;
    @FXML
    private TextField txtFiltroTgnpPBA;
    @FXML
    private TextField txtFiltroTgnpOldPBA;
    @FXML
    private TextField txtFiltroTLPBA;
    @FXML
    private ComboBox<String> cbxValoresNumPBA;
    @FXML
    private ComboBox<String> cbxcomparadorPBA;
    @FXML
    private TextField txtcomparaUsrPBA;
    @FXML
    private ComboBox<String> cbxSBBAP;
    //================================================Busq Avanz Ciudad================================================
    @FXML
    private CheckBox chbxidBAC;
    @FXML
    private CheckBox chbxnameBAC;
    @FXML
    private CheckBox chbxcountryCodeBAC;
    @FXML
    private CheckBox chbxdistrictBAC;
    @FXML
    private CheckBox chbxpopBAC;
    @FXML
    private TextField txtlimitBAC;
    @FXML
    private TextField txtidBAC;
    @FXML
    private TextField txtnameBAC;
    @FXML
    private TextField txtcountrycodeBAC;
    @FXML
    private TextField txtdistrictBAC;
    @FXML
    private TextField txtpopBAC;
    @FXML
    private ComboBox<String> cbxValoresNumCBA;
    @FXML
    private ComboBox<String> cbxcomparadorCBA;
    @FXML
    private TextField txtcomparaUsrCBA;
    @FXML
    private TableView<Ciudad> tblCiudadCBA;
    @FXML
    private TableColumn<Ciudad, Integer> colIdCBA;
    @FXML
    private TableColumn<Ciudad, String> colNameCBA;
    @FXML
    private TableColumn<Ciudad, String> colCountryCodCBA;
    @FXML
    private TableColumn<Ciudad, String> colDistrictCBA;
    @FXML
    private TableColumn<Ciudad, Integer> colPopulationCBA;
    @FXML
    private ComboBox<String> cbxSBBAC;
    //================================================Busq Avanz Lenguaje================================================
    @FXML
    private CheckBox chbxccodeBAL;
    @FXML
    private CheckBox chbxlanguageBAL;
    @FXML
    private CheckBox chbxisoffBAL;
    @FXML
    private CheckBox chbxpercBAL;
    @FXML
    private TextField txtLimitBAL;
    @FXML
    private TextField txtcountrycodeBAL;
    @FXML
    private TextField txtlangBAL;
    @FXML
    private TextField txtpercentageBAL;
    @FXML
    private TextField txtisoffBAL;
    @FXML
    private ComboBox<String> cbxValoresNumLBA;
    @FXML
    private ComboBox<String> cbxcomparadorLBA;
    @FXML
    private TextField txtcomparaUsrLBA;
    @FXML
    private TableColumn<Lenguaje, String> colCountryCodLBA;
    @FXML
    private TableColumn<Lenguaje, String> collanguageLBA;
    @FXML
    private TableColumn<Lenguaje, String> colisOffLBA;
    @FXML
    private TableColumn<Lenguaje, Float> colPercentageLBA;
    @FXML
    private TableView<Lenguaje> tblLenguajesLBA;
    @FXML
    private ComboBox<String> cbxSBBAL;
    //================================================================================================
    @FXML
    private ComboBox cbxCreaContinenteP1;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.paneHome.setVisible(true);
        this.paneVerPais.setVisible(true);
        this.paneVerCiudades.setVisible(true);
        this.paneVerLenguajes.setVisible(true);
        this.paneMEP.setVisible(true);
        this.paneMODL.setVisible(true);
        this.paneMEC.setVisible(true);
        this.paneMEL.setVisible(true);
        this.paneCrearP.setVisible(true);
        this.paneCrearC.setVisible(true);
        this.paneCrearL.setVisible(true);
        this.paneBAP.setVisible(true);
        this.paneBAC.setVisible(true);
        this.paneBAL.setVisible(true);
        this.paneHome.toFront();

        this.llenaCombosContinente();
        this.llenaCombosOficial();
        this.modelaTablaPaisBA();
        this.modelacomboboxPaisBA();
        this.modelaTablaCiudadBA();
        this.modelacomboboxCiudadBA();
        this.modelaTablaLenguajeBA();
        this.modelacomboboxLenguajeBA();
    }

    @FXML
    private void goBackHome(ActionEvent event) {
        this.paneHome.toFront();
    }

    @FXML
    private void goVerPaises(ActionEvent event) {
        this.paneVerPais.toFront();
        this.initVerPaises();
    }

    @FXML
    private void goVerCiudades(ActionEvent event) {
        this.paneVerCiudades.toFront();
        this.initVerCiudades();
    }

    @FXML
    private void goVerLenguajes(ActionEvent event) {
        this.paneVerLenguajes.toFront();
        this.initVerLenguajes();

    }

    private void doSalir(ActionEvent event) {
        var stage = (Stage) this.paneHome.getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    private void goVentanas(String name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/" + name + ".fxml")); 
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setOnCloseRequest(even -> {
                even.consume();
            });
            stage.setResizable(false);
            stage.setTitle(name);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void doCrearPaís(ActionEvent event) {
        this.paneCrearP.toFront();
    }

    private void doModificaryEliminarPaís(ActionEvent event) {
        this.paneMEP.toFront();
    }

    @FXML
    private void doCrearCiudad(ActionEvent event) {
        this.paneCrearC.toFront();

    }

    @FXML
    private void doCrearLenguaje(ActionEvent event) {
        this.paneCrearL.toFront();

    }

    @FXML
    private void doFiilTextINV(KeyEvent event) {
    }

    private void goModificarP(ActionEvent event) {
        this.paneMODP.toFront();
    }

    @FXML
    private void goBAP(ActionEvent event) {
        this.paneBAP.toFront();
        this.initPaisesBA();
    }

    @FXML
    private void goBAC(ActionEvent event) {
        this.paneBAC.toFront();
        this.initCiudadesBA();
    }

    @FXML
    private void goBAL(ActionEvent event) {
        this.paneBAL.toFront();
        this.initLenguajesBA();
    }
    private int index = -1;

    //===================================VER PAIS========================================
    private void initVerPaises() {
        this.modelaTablaVerPais();

        ObservableList<Pais> items = p.getTodosPaises();
        this.tblVerPais.setItems(items);
    }

    private void modelaTablaVerPais() {

        this.colCodP.setCellValueFactory(new PropertyValueFactory("Code"));
        this.colNameP.setCellValueFactory(new PropertyValueFactory("Name"));
        this.colContiP.setCellValueFactory(new PropertyValueFactory("Continent"));
        this.colRegionP.setCellValueFactory(new PropertyValueFactory("Region"));
        this.colSurfAP.setCellValueFactory(new PropertyValueFactory("SurfaceArea"));
        this.colIndYP.setCellValueFactory(new PropertyValueFactory("IndepYear"));
        this.colPopulationP.setCellValueFactory(new PropertyValueFactory("Population"));
        this.colLifeEP.setCellValueFactory(new PropertyValueFactory("LifeExpectancy"));
        this.colGNPP.setCellValueFactory(new PropertyValueFactory("GNP"));
        this.colGNPOP.setCellValueFactory(new PropertyValueFactory("GNPOld"));
        this.colLocalNP.setCellValueFactory(new PropertyValueFactory("LocalName"));
        this.colGovFormP.setCellValueFactory(new PropertyValueFactory("GovernmentForm"));
        this.colHeadOSP.setCellValueFactory(new PropertyValueFactory("HeadOfState"));
        this.colCapitalP.setCellValueFactory(new PropertyValueFactory("Capital"));
        this.colCod2P.setCellValueFactory(new PropertyValueFactory("Code2"));

    }

    @FXML
    private void doLimitBusqP(KeyEvent event) {
        this.filtroBasicoP();
    }

    @FXML
    private void doBuscNomP(KeyEvent event) {
        this.filtroBasicoP();
    }

    @FXML
    private void doBuscCodP(KeyEvent event) {
        this.filtroBasicoP();
    }

    private void filtroBasicoP() {
        String code = this.txtFiltroTCP.getText();
        String name = this.txtFiltroTNP.getText();
        String limit = this.txtFiltroTLBP.getText();

        ObservableList<Pais> items = p.getFiltroBasicoPaises(code, name, limit);
        this.tblVerPais.setItems(items);
    }

    //===================================VER CIUDAD========================================
    private void initVerCiudades() {
        this.modelaTablaVerCiudad();

        ObservableList<Ciudad> items = c.getTodasCiudades();
        this.tblVerCiudad.setItems(items);
    }

    private void modelaTablaVerCiudad() {
        this.colIdC.setCellValueFactory(new PropertyValueFactory("ID"));
        this.colNameC.setCellValueFactory(new PropertyValueFactory("Name"));
        this.colCountryCodC.setCellValueFactory(new PropertyValueFactory("CountryCode"));
        this.colDistrictC.setCellValueFactory(new PropertyValueFactory("District"));
        this.colPopulationC.setCellValueFactory(new PropertyValueFactory("Population"));
    }

    @FXML
    private void doLimitBusqC(KeyEvent event) {
        this.filtroBasicoC();
    }

    @FXML
    private void doBuscCodC(KeyEvent event) {
        this.filtroBasicoC();
    }

    @FXML
    private void doBuscNomC(KeyEvent event) {
        this.filtroBasicoC();
    }

    private void filtroBasicoC() {
        String code = this.txtFiltroTCC.getText();
        String name = this.txtFiltroTNC.getText();
        String limit = this.txtFiltroTLBC.getText();

        ObservableList<Ciudad> items = c.getFiltroBasicoCiudades(code, name, limit);
        this.tblVerCiudad.setItems(items);
    }

    //===================================VER LENGUAJE========================================
    private void initVerLenguajes() {
        this.modelaTablaVerLenguajes();

        ObservableList<Lenguaje> items = l.getTodosLenguajes();
        this.tblVerLenguajes.setItems(items);
    }

    private void modelaTablaVerLenguajes() {
        this.colCountryCodLA.setCellValueFactory(new PropertyValueFactory("CountryCode"));
        this.collanguageLA.setCellValueFactory(new PropertyValueFactory("Language"));
        this.colisOffLA.setCellValueFactory(new PropertyValueFactory("IsOfficial"));
        this.colPercentageLA.setCellValueFactory(new PropertyValueFactory("Percentage"));
    }

    @FXML
    private void doLimitBusqL(KeyEvent event) {
        this.filtroBasicoL();
    }

    @FXML
    private void doBuscCodL(KeyEvent event) {
        this.filtroBasicoL();
    }

    @FXML
    private void doBuscNomL(KeyEvent event) {
        this.filtroBasicoL();
    }

    private void filtroBasicoL() {
        String code = this.txtFiltroTCL.getText();
        String name = this.txtFiltroTNL.getText();
        String limit = this.txtFiltroTLBL.getText();

        ObservableList<Lenguaje> items = l.getFiltroBasicoLenguajes(code, name, limit);
        this.tblVerLenguajes.setItems(items);
    }

       //=================================== MODIFICAR Y ELIMINAR PAIS ========================================
       private void modelaTablaMEPais() {

        this.colCodigoME.setCellValueFactory(new PropertyValueFactory("Code"));
        this.colNombreME.setCellValueFactory(new PropertyValueFactory("Name"));
        this.colContinenteME.setCellValueFactory(new PropertyValueFactory("Continent"));
        this.colRegionME.setCellValueFactory(new PropertyValueFactory("Region"));
        this.colAreaSuperficieME.setCellValueFactory(new PropertyValueFactory("SurfaceArea"));
        this.colAñoIndepeME.setCellValueFactory(new PropertyValueFactory("IndepYear"));
        this.colPoblacionME.setCellValueFactory(new PropertyValueFactory("Population"));
        this.colEspeVidaME.setCellValueFactory(new PropertyValueFactory("LifeExpectancy"));
        this.colPibME.setCellValueFactory(new PropertyValueFactory("GNP"));
        this.colPibOld.setCellValueFactory(new PropertyValueFactory("GNPOld"));
        this.colNomLocalME.setCellValueFactory(new PropertyValueFactory("LocalName"));
        this.colFormGobME.setCellValueFactory(new PropertyValueFactory("GovernmentForm"));
        this.colCabEstME.setCellValueFactory(new PropertyValueFactory("HeadOfState"));
        this.colCapitalME.setCellValueFactory(new PropertyValueFactory("Capital"));
        this.colCodigo2ME.setCellValueFactory(new PropertyValueFactory("Code2"));
        
    }
    
    @FXML
    private void doMEPaís(ActionEvent event) {
        
        this.paneMEP.toFront();
        this.modelaTablaMEPais();
        GestionPaises p = new GestionPaises();
        ObservableList<Pais> items = p.getTodosPaises();
        this.tblPaisME.setItems(items);
    }
    
    @FXML
    private void getSelected(MouseEvent event) {
        
        index = this.tblPaisME.getSelectionModel().getSelectedIndex();
        
        txtCodM.setText(this.colCodigoME.getCellData(index));
        txtNombreM.setText(this.colNombreME.getCellData(index));
        cbxCreaContinenteP.setValue(this.colContinenteME.getCellData(index));
        txtRegionM.setText(this.colRegionME.getCellData(index));
        txtSupM.setText(this.colAreaSuperficieME.getCellData(index).toString());
        txtIndM.setText(this.colAñoIndepeME.getCellData(index).toString());
        txtPoblacionM.setText(this.colPoblacionME.getCellData(index).toString());
        txtEdvM.setText(this.colEspeVidaME.getCellData(index).toString());
        txtPIBM.setText(this.colPibME.getCellData(index).toString());
        txtPibOldM.setText(this.colPibOld.getCellData(index).toString());
        txtNombreLocalM.setText(this.colNomLocalME.getCellData(index));
        txtGobM.setText(this.colFormGobME.getCellData(index));
        txtPresM.setText(this.colCabEstME.getCellData(index));
        txtCapitalM.setText(this.colCapitalME.getCellData(index).toString());
        txtCod2M2.setText(this.colCodigo2ME.getCellData(index));
        
        System.out.println("" + codeME);
        
    }
    
    public void UpdateTable() {
        
        this.modelaTablaMEPais();
        GestionPaises pa = new GestionPaises();
        ObservableList<Pais> items = pa.getTodosPaises();
        this.tblPaisME.setItems(items);
        
    }

    //===================================MODIFICAR PAIS========================================
    @FXML
    private void doModificarPane(ActionEvent event) {
        
        if (txtCodM.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una fila");
        } else {
            this.paneModificar.toFront();
        }
        
    }
    
    @FXML
    private void doModificarM(ActionEvent event) {
        
        String value1 = txtCodM.getText();
        String value2 = txtNombreM.getText();
        String value3 = cbxCreaContinenteP.getValue();
        String value4 = txtRegionM.getText();
        String value5 = txtSupM.getText();
        String value6 = txtIndM.getText();
        String value7 = txtPoblacionM.getText();
        String value8 = txtEdvM.getText();
        String value9 = txtPIBM.getText();
        String value10 = txtPibOldM.getText();
        String value11 = txtNombreLocalM.getText();
        String value12 = txtGobM.getText();
        String value13 = txtPresM.getText();
        String value14 = txtCapitalM.getText();
        String value15 = txtCod2M2.getText();
        p.modPaises(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14, value15);
        this.UpdateTable();
    }
//=============================== ELIMINAR PAIS ========================================

    @FXML
    private void doEliminarP(ActionEvent event) {
        
        String code = this.colCodigoME.getCellData(index);
        
        int n = JOptionPane.showConfirmDialog(
                null,
                "¿Desea eliminar el país teniendo en cuenta que esta acción puede eliminar sus ciudades e idiomas asociados?",
                "",
                JOptionPane.YES_NO_OPTION);
        
        if (n == JOptionPane.YES_OPTION) {
            p.elimPais(code);
            this.UpdateTable();
        }
        
    }
//=============================== MODIFICAR Y ELIMINAR CIUDAD ========================================

    @FXML
    private void doModificaryEliminarCiudad(ActionEvent event) {
        this.paneMEC.toFront();
        this.modelaTablaVerCiudadME();
        ObservableList<Ciudad> items = c.getTodasCiudades();
        this.tblCiudadesME.setItems(items);
    }
    
    private void modelaTablaVerCiudadME() {
        this.colIdMEC.setCellValueFactory(new PropertyValueFactory("ID"));
        this.colNombreMEC.setCellValueFactory(new PropertyValueFactory("Name"));
        this.codigoMEC.setCellValueFactory(new PropertyValueFactory("CountryCode"));
        this.colDistritoMEC.setCellValueFactory(new PropertyValueFactory("District"));
        this.colPoblacionMEC.setCellValueFactory(new PropertyValueFactory("Population"));
    }
    
    @FXML
    private void doTextFillCodP(KeyEvent event) {
        this.filtroBasicoPME();
    }
    
    @FXML
    private void doTextFillNombreP(KeyEvent event) {
        this.filtroBasicoPME();
    }
    
    @FXML
    private void doTextFillNombreLocalP(KeyEvent event) {
        this.filtroBasicoPME();
    }
    
    private void filtroBasicoPME() {
        String code = this.txtFiltroCod1MEP.getText();
        String name = this.txtFiltroNombreMEP.getText();
        String localname = this.txtFiltroNombreLocalMEP.getText();
        
        ObservableList<Pais> items = p.getFiltroBasicoPaisesME(code, name, localname);
        this.tblPaisME.setItems(items);
    }
    
    @FXML
    private void getSelectedC(MouseEvent event) {
        index = this.tblCiudadesME.getSelectionModel().getSelectedIndex();
        txtModIDC.setText(this.colIdMEC.getCellData(index).toString());
        txtModNombreCi.setText(this.colNombreMEC.getCellData(index));
        txtCodPM.setText(this.codigoMEC.getCellData(index));
        txtDistritoMC.setText(this.colDistritoMEC.getCellData(index));
        txtPoblacionMC.setText(this.colPoblacionMEC.getCellData(index).toString());
    }
    
    public void UpdateTableC() {
        
        this.modelaTablaVerCiudadME();
        ObservableList<Ciudad> items = c.getTodasCiudades();
        this.tblCiudadesME.setItems(items);
    }

    //=================================== MODIFICAR CIUDADES ========================================
    @FXML
    private void goModificarC(ActionEvent event) {
        if (txtModIDC.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una fila");
        } else {
            
            this.paneModificarC.toFront();
        }
        
    }
    
    @FXML
    private void doModC(ActionEvent event) {
        
        String value1 = txtModIDC.getText();
        String value2 = txtModNombreCi.getText();
        String value3 = txtCodPM.getText();
        String value4 = txtDistritoMC.getText();
        String value5 = txtPoblacionMC.getText();
        c.modCiudad(value1, value2, value3, value4, value5);
        this.UpdateTableC();
    }
    
    @FXML
    private void doTextFillCodC(KeyEvent event) {
        this.filtroBasicoPMEC();
    }
    
    @FXML
    private void doTextFillNombreC(KeyEvent event) {
        this.filtroBasicoPMEC();
    }
    
    @FXML
    private void doTextFilllCodPaisC(KeyEvent event) {
        this.filtroBasicoPMEC();
    }
    
    private void filtroBasicoPMEC() {
        String id1 = this.txtFiltroCod1MEC.getText();
        String name = this.txtFiltroNombreMEC.getText();
        String countrycode = this.txtFiltroCodPaisMEC.getText();
        ObservableList<Ciudad> items = c.getFiltroBasicoCiudadesMEC(id1, name, countrycode);
        this.tblCiudadesME.setItems(items);
    }

    //=================================== ELIMINAR CIUDADES ========================================
    @FXML
    private void goEliminarC(ActionEvent event) {
        String code = txtModIDC.getText();
        
        int n = JOptionPane.showConfirmDialog(
                null,
                "¿Desea eliminar la ciudad?",
                "",
                JOptionPane.YES_NO_OPTION);
        
        if (n == JOptionPane.YES_OPTION) {
            c.eliminCiud(code);
            this.UpdateTableC();
        }
    }

    //===================================MODIFICAR Y ELIMINAR IDIOMAS========================================
    @FXML
    private void doModificaryEliminarLenguaje(ActionEvent event) {
        
        this.paneMEL.toFront();
        this.modelaTablaVerLenguajesME();
        ObservableList<Lenguaje> items = l.getTodosLenguajes();
        this.tblIdiomasME.setItems(items);
    }
    
    @FXML
    private void getSelectedL(MouseEvent event) {
        
        index = this.tblIdiomasME.getSelectionModel().getSelectedIndex();
        txtCountryCodeL.setText(this.colCountryCodL.getCellData(index));
        txtLanguaje.setText(this.collanguageL.getCellData(index));
        cbxCreaOfL.setValue(this.colisOffL.getCellData(index));
        txtPorcentajeL.setText(this.colPercentageL.getCellData(index).toString());
    }
    
    @FXML
    private void goModificarL(ActionEvent event) {
        
        if (txtCountryCodeL.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una fila");
        } else {
            this.paneMODL.toFront();
        }
        
    }
    
    public void UpdateTableL() {
        
        this.modelaTablaVerLenguajesME();
        ObservableList<Lenguaje> items = l.getTodosLenguajes();
        this.tblIdiomasME.setItems(items);
    }

    //=================================== MODIFICAR IDIOMAS ========================================
    @FXML
    private void doTextFillCodL(KeyEvent event) {
        this.filtroBasicoLME();
    }
    
    @FXML
    private void doTextFillNombreL(KeyEvent event) {
        this.filtroBasicoLME();
        
    }
    
    private void filtroBasicoLME() {
        String codigo = this.txtFiltroCod1MEL.getText();
        String language = this.txtFiltroNombreMEL.getText();
        ObservableList<Lenguaje> items = l.getFiltroBasicoLenguajesME(codigo, language);
        this.tblIdiomasME.setItems(items);
    }
    
    private void modelaTablaVerLenguajesME() {
        this.colCountryCodL.setCellValueFactory(new PropertyValueFactory("CountryCode"));
        this.collanguageL.setCellValueFactory(new PropertyValueFactory("Language"));
        this.colisOffL.setCellValueFactory(new PropertyValueFactory("IsOfficial"));
        this.colPercentageL.setCellValueFactory(new PropertyValueFactory("Percentage"));
    }
    
    @FXML
    private void doUpdateL(ActionEvent event) {
        
        String value1 = txtCountryCodeL.getText();
        String value2 = txtLanguaje.getText();
        String value3 = cbxCreaOfL.getValue();
        String value4 = txtPorcentajeL.getText();
        l.modLeng(value1, value2, value3, value4);
        this.UpdateTableL();
        
    }

    //================================= ELIMINAR IDIOMAS ========================================
    @FXML
    private void goEliminarL(ActionEvent event) {
        
        String code1 = this.colCountryCodL.getCellData(index);
        String name1 = this.collanguageL.getCellData(index);
        
        int n = JOptionPane.showConfirmDialog(
                null,
                "¿Desea eliminar el idioma?",
                "",
                JOptionPane.YES_NO_OPTION);
        
        if (n == JOptionPane.YES_OPTION) {
            
            l.elimLeng(code1, name1);
            this.UpdateTableL();
        }
        
    }

    //===================================CREAR PAIS========================================
    @FXML
    private void doCrearP(ActionEvent event) {
        
        String value1 = txtCreaCodP.getText();
        String value2 = txtCreaNombreP.getText();
        String value3 = cbxCreaContinenteP.getValue();
        String value4 = txtCreaRegionP.getText();
        String value5 = txtCreaSupP.getText();
        String value6 = txtCreaIndP.getText();
        String value7 = txtCreaPoblacionP.getText();
        String value8 = txtCreaEdvP.getText();
        String value9 = txtCreaPIBP.getText();
        String value10 = txtCreaPBIoldP.getText();
        String value11 = txtCreaNombreLocalP.getText();
        String value12 = txtCreaGobP.getText();
        String value13 = txtCreaPresP.getText();
        String value14 = txtCreaCapitalP.getText();
        String value15 = txtCreaCod2P.getText();
        
        p.creaPais(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14, value15);
        this.UpdateTableCP();
        
    }
    
    private void llenaCombosContinente() {
        this.cbxCreaContinenteP.getItems().add("Asia");
        this.cbxCreaContinenteP.getItems().add("Europe");
        this.cbxCreaContinenteP.getItems().add("North America");
        this.cbxCreaContinenteP.getItems().add("Africa");
        this.cbxCreaContinenteP.getItems().add("Oceania");
        this.cbxCreaContinenteP.getItems().add("Antarctica");
        this.cbxCreaContinenteP.getItems().add("South America");
    }
    
    public void UpdateTableCP() {
        
        this.modelaTablaVerPais();
        GestionPaises pa = new GestionPaises();
        ObservableList<Pais> items = pa.getTodosPaises();
        this.tblVerPais.setItems(items);
    }

    //=================================== CREAR CIUDAD ========================================
    @FXML
    private void doCrearC(ActionEvent event) {       
            String value1 = txtCreaIDC.getText();
            String value2 = txtCreaNombreC.getText();
            String value3 = txtCiudadCodP.getText();
            String value4 = txtCreaDistrictC.getText();
            String value5 = txtCreaPobC.getText();
            c.creaCiud(value1, value2, value3, value4, value5);
            this.UpdateTableCC();
           
    }
    
    public void UpdateTableCC() {
        this.modelaTablaVerCiudadME();
        ObservableList<Ciudad> items = c.getTodasCiudades();
        this.tblCiudadesME.setItems(items);
    }

    //===================================CREAR IDIOMA========================================
    @FXML
    private void doCrearL(ActionEvent event) {
            
            String value1 = txtCodePL.getText();
            String value2 = txtCreaL.getText();
            String value3 = cbxCreaOfL.getValue();
            String value4 = txtCreaPorL.getText();
            
            l.creaLeng(value1, value2, value3, value4);
            this.UpdateTableCL();
        
    }
    
    public void UpdateTableCL() {
        
        this.modelaTablaVerPais();
        GestionPaises pa = new GestionPaises();
        ObservableList<Pais> items = pa.getTodosPaises();
        this.tblVerPais.setItems(items);
    }
    
    private void llenaCombosOficial() {
        this.cbxCreaOfL.getItems().add("F");
        this.cbxCreaOfL.getItems().add("T");
    }

    //================================================Busq Avanz PAIS================================================
    private void initPaisesBA() {
        ObservableList<Pais> items = p.getTodosPaises();
        this.tblPaisPBA.setItems(items);
    }

    @FXML
    private void doActColCodPBA(ActionEvent event) {
        boolean Code;

        Code = this.chbxCodPBA.isSelected();

        this.actualizaTablaAvanz(Code, this.colCodPBA);
    }

    @FXML
    private void doActColNomPBA(ActionEvent event) {
        boolean Name;

        Name = this.chbxNomPBA.isSelected();

        this.actualizaTablaAvanz(Name, this.colNamePBA);
    }

    @FXML
    private void doActColContPBA(ActionEvent event) {
        boolean Continent;

        Continent = this.chbxContPBA.isSelected();

        this.actualizaTablaAvanz(Continent, this.colContiPBA);
    }

    @FXML
    private void doActColRegPBA(ActionEvent event) {
        boolean Region;

        Region = this.chbxRegPBA.isSelected();

        this.actualizaTablaAvanz(Region, this.colRegionPBA);
    }

    @FXML
    private void doActColSurfAPBA(ActionEvent event) {
        boolean SurfaceArea;

        SurfaceArea = this.chbxSurfAPBA.isSelected();

        this.actualizaTablaAvanz(SurfaceArea, this.colSurfAPBA);
    }

    @FXML
    private void doActColIndepYPBA(ActionEvent event) {
        boolean IndepYear;

        IndepYear = this.chbxIndepYPBA.isSelected();

        this.actualizaTablaAvanz(IndepYear, this.colIndYPBA);
    }

    @FXML
    private void doActColPopulPBA(ActionEvent event) {
        boolean Population;

        Population = this.chbxPopulationPBA.isSelected();

        this.actualizaTablaAvanz(Population, this.colPopulationPBA);
    }

    @FXML
    private void doActColLifeExpPBA(ActionEvent event) {
        boolean LifeExpectancy;

        LifeExpectancy = this.chbxLifeExpPBA.isSelected();

        this.actualizaTablaAvanz(LifeExpectancy, this.colLifeEPBA);
    }

    @FXML
    private void doActColgnpPBA(ActionEvent event) {
        boolean GNP;

        GNP = this.chbxgnpPBA.isSelected();

        this.actualizaTablaAvanz(GNP, this.colGNPPBA);
    }

    @FXML
    private void doActColgnpOldPBA(ActionEvent event) {
        boolean GNPOld;

        GNPOld = this.chbxgnpOldPBA.isSelected();

        this.actualizaTablaAvanz(GNPOld, this.colGNPOPBA);
    }

    @FXML
    private void doActCollocalNPBA(ActionEvent event) {
        boolean LocalName;

        LocalName = this.chbxlocalNPBA.isSelected();

        this.actualizaTablaAvanz(LocalName, this.colLocalNPBA);
    }

    @FXML
    private void doActColcapPBA(ActionEvent event) {
        boolean Capital;

        Capital = this.chbxCapPBA.isSelected();

        this.actualizaTablaAvanz(Capital, this.colCapitalPBA);
    }

    @FXML
    private void doActColGovFormPBA(ActionEvent event) {
        boolean GovernmentForm;

        GovernmentForm = this.chbxGovFormPBA.isSelected();

        this.actualizaTablaAvanz(GovernmentForm, this.colGovFormPBA);
    }

    @FXML
    private void doActColHeadOfSPBA(ActionEvent event) {
        boolean HeadOfState;

        HeadOfState = this.chbxHeadOfSPBA.isSelected();

        this.actualizaTablaAvanz(HeadOfState, this.colHeadOSPBA);

    }

    @FXML
    private void doActColCode2PBA(ActionEvent event) {
        boolean Code2;

        Code2 = this.chbxCode2PBA.isSelected();

        this.actualizaTablaAvanz(Code2, this.colCod2PBA);
    }

    private void actualizaTablaAvanz(Boolean title, TableColumn column) {
        if (title) {
            column.setVisible(true);
        } else {
            column.setVisible(false);
        }
    }

    private void modelaTablaPaisBA() {
        this.colCodPBA.setCellValueFactory(new PropertyValueFactory("Code"));
        this.colNamePBA.setCellValueFactory(new PropertyValueFactory("Name"));
        this.colContiPBA.setCellValueFactory(new PropertyValueFactory("Continent"));
        this.colRegionPBA.setCellValueFactory(new PropertyValueFactory("Region"));
        this.colSurfAPBA.setCellValueFactory(new PropertyValueFactory("SurfaceArea"));
        this.colIndYPBA.setCellValueFactory(new PropertyValueFactory("IndepYear"));
        this.colPopulationPBA.setCellValueFactory(new PropertyValueFactory("Population"));
        this.colLifeEPBA.setCellValueFactory(new PropertyValueFactory("LifeExpectancy"));
        this.colGNPPBA.setCellValueFactory(new PropertyValueFactory("GNP"));
        this.colGNPOPBA.setCellValueFactory(new PropertyValueFactory("GNPOld"));
        this.colLocalNPBA.setCellValueFactory(new PropertyValueFactory("LocalName"));
        this.colGovFormPBA.setCellValueFactory(new PropertyValueFactory("GovernmentForm"));
        this.colHeadOSPBA.setCellValueFactory(new PropertyValueFactory("HeadOfState"));
        this.colCapitalPBA.setCellValueFactory(new PropertyValueFactory("Capital"));
        this.colCod2PBA.setCellValueFactory(new PropertyValueFactory("Code2"));
    }

    @FXML
    private void filtroAvanzadoP() {
        String limit = this.txtFiltroTLPBA.getText();
        String tipodeBusq = this.cbxSBBAP.getValue();
        String code = this.txtFiltroTCPBA.getText();
        String name = this.txtFiltroTNPBA.getText();
        String continent = this.txtFiltroTContPBA.getText();
        String region = this.txtFiltroTregPBA.getText();
        String surfaceArea = this.txtFiltroTsurfAPBA.getText();
        String indepYear = this.txtFiltroTindepYPBA.getText();
        String population = this.txtFiltroTpopPBA.getText();
        String lifeExpectancy = this.txtFiltroTlifeExpPBA.getText();
        String gnp = this.txtFiltroTgnpPBA.getText();
        String gnpOld = this.txtFiltroTgnpOldPBA.getText();
        String localName = this.txtFiltroTlocalNPBA.getText();
        String governmentForm = this.txtFiltroTgovFormPBA.getText();
        String headOfState = this.txtFiltroTheadOfSPBA.getText();
        String capital = this.txtFiltroTCapPBA.getText();
        String code2 = this.txtFiltroTCod2PBA.getText();
        String comparatorCol = this.cbxValoresNumPBA.getValue();
        String comparator = this.cbxcomparadorPBA.getValue();
        String comparatornum = this.txtcomparaUsrPBA.getText();

        ObservableList<Pais> items = p.getFiltroAvanzadoPaises(limit, tipodeBusq, code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2, comparatorCol, comparator, comparatornum);
        this.tblPaisPBA.setItems(items);
    }

    private void modelacomboboxPaisBA() {
        this.cbxValoresNumPBA.getItems().addAll("Área de superficie", "Año de independencia", "Población", "Esperanza de vida", "PIB", "PIBold", "Capital");
        this.cbxValoresNumPBA.setPromptText("Seleccione");
        this.cbxcomparadorPBA.getItems().addAll("=", "<", ">", "<=", ">=");
        this.cbxcomparadorPBA.setValue("=");
        this.cbxSBBAP.getItems().addAll("Que contenga...", "Que empiece por...", "Que termine por...");
        this.cbxSBBAP.setValue("Que contenga...");
    }

    @FXML
    private void doCompararPBA(ActionEvent event) {
        if (this.cbxValoresNumPBA.getValue() != null) {
            this.txtcomparaUsrPBA.setDisable(false);
            if (this.cbxcomparadorPBA.getValue() != null) {
                this.filtroAvanzadoP();
            }
        }
    }

    //================================================Busq Avanz CIUDAD================================================
    private void initCiudadesBA() {
        ObservableList<Ciudad> items = c.getTodasCiudades();
        this.tblCiudadCBA.setItems(items);
    }

    @FXML
    private void doActColIDBAC(ActionEvent event) {
        boolean ID;

        ID = this.chbxidBAC.isSelected();

        this.actualizaTablaAvanz(ID, this.colIdCBA);
    }

    @FXML
    private void doActColnameBAC(ActionEvent event) {
        boolean Name;

        Name = this.chbxnameBAC.isSelected();

        this.actualizaTablaAvanz(Name, this.colNameCBA);
    }

    @FXML
    private void doActColCCodeBAC(ActionEvent event) {
        boolean CountryCode;

        CountryCode = this.chbxcountryCodeBAC.isSelected();

        this.actualizaTablaAvanz(CountryCode, this.colCountryCodCBA);
    }

    @FXML
    private void doActColdistrictBAC(ActionEvent event) {
        boolean District;

        District = this.chbxdistrictBAC.isSelected();

        this.actualizaTablaAvanz(District, this.colDistrictCBA);
    }

    @FXML
    private void doActColpopBAC(ActionEvent event) {
        boolean Population;

        Population = this.chbxpopBAC.isSelected();

        this.actualizaTablaAvanz(Population, this.colPopulationCBA);
    }

    @FXML
    private void filtroAvanzadoC() {
        String limit = this.txtlimitBAC.getText();
        String tipodeBusq = this.cbxSBBAC.getValue();
        String id = this.txtidBAC.getText();
        String name = this.txtnameBAC.getText();
        String countryCode = this.txtcountrycodeBAC.getText();
        String district = this.txtdistrictBAC.getText();
        String population = this.txtpopBAC.getText();
        String comparatorCol = this.cbxValoresNumCBA.getValue();
        String comparator = this.cbxcomparadorCBA.getValue();
        String comparatornum = this.txtcomparaUsrCBA.getText();

        ObservableList<Ciudad> items = c.getFiltroAvanzadoCiudades(limit, tipodeBusq, id, name, countryCode, district, population, comparatorCol, comparator, comparatornum);
        this.tblCiudadCBA.setItems(items);
    }

    @FXML
    private void doCompararCBAC(ActionEvent event) {
        if (this.cbxValoresNumCBA.getValue() != null) {
            this.txtcomparaUsrCBA.setDisable(false);
            if (this.cbxcomparadorCBA.getValue() != null) {
                this.filtroAvanzadoC();
            }
        }
    }

    private void modelaTablaCiudadBA() {
        this.colIdCBA.setCellValueFactory(new PropertyValueFactory("ID"));
        this.colNameCBA.setCellValueFactory(new PropertyValueFactory("Name"));
        this.colCountryCodCBA.setCellValueFactory(new PropertyValueFactory("CountryCode"));
        this.colDistrictCBA.setCellValueFactory(new PropertyValueFactory("District"));
        this.colPopulationCBA.setCellValueFactory(new PropertyValueFactory("Population"));
    }

    private void modelacomboboxCiudadBA() {
        this.cbxValoresNumCBA.getItems().addAll("ID", "Población");
        this.cbxValoresNumCBA.setPromptText("Seleccione");
        this.cbxcomparadorCBA.getItems().addAll("=", "<", ">", "<=", ">=");
        this.cbxcomparadorCBA.setValue("=");
        this.cbxSBBAC.getItems().addAll("Que contenga...", "Que empiece por...", "Que termine por...");
        this.cbxSBBAC.setValue("Que contenga...");
    }

    //================================================Busq Avanz Lenguaje================================================
    private void initLenguajesBA() {
        ObservableList<Lenguaje> items = l.getTodosLenguajes();
        this.tblLenguajesLBA.setItems(items);
    }

    @FXML
    private void doActColCCodeBAL(ActionEvent event) {
        boolean CountryCode;

        CountryCode = this.chbxccodeBAL.isSelected();

        this.actualizaTablaAvanz(CountryCode, this.colCountryCodLBA);
    }

    @FXML
    private void doActColLangBAL(ActionEvent event) {
        boolean Language;

        Language = this.chbxlanguageBAL.isSelected();

        this.actualizaTablaAvanz(Language, this.collanguageLBA);
    }

    @FXML
    private void doActIsOffBAL(ActionEvent event) {
        boolean IsOfficial;

        IsOfficial = this.chbxisoffBAL.isSelected();

        this.actualizaTablaAvanz(IsOfficial, this.colisOffLBA);
    }

    @FXML
    private void doActColPercBAL(ActionEvent event) {
        boolean Percentage;

        Percentage = this.chbxpercBAL.isSelected();

        this.actualizaTablaAvanz(Percentage, this.colPercentageLBA);
    }

    @FXML
    private void filtroAvanzadoL() {
        String limit = this.txtLimitBAL.getText();
        String tipodeBusq = this.cbxSBBAL.getValue();
        String countryCode = this.txtcountrycodeBAL.getText();
        String language = this.txtlangBAL.getText();
        String isOfficial = this.txtisoffBAL.getText();
        String percentage = this.txtpercentageBAL.getText();
        String comparatorCol = this.cbxValoresNumLBA.getValue();
        String comparator = this.cbxcomparadorLBA.getValue();
        String comparatornum = this.txtcomparaUsrLBA.getText();

        ObservableList<Lenguaje> items = l.getFiltroAvanzadoLenguajes(limit, tipodeBusq,countryCode, language, isOfficial, percentage, comparatorCol, comparator, comparatornum);
        this.tblLenguajesLBA.setItems(items);
    }

    @FXML
    private void doCompararLBA(ActionEvent event) {
        if (this.cbxValoresNumLBA.getValue() != null) {
            this.txtcomparaUsrLBA.setDisable(false);
            if (this.cbxcomparadorLBA.getValue() != null) {
                this.filtroAvanzadoL();
            }
        }
    }

    private void modelaTablaLenguajeBA() {
        this.colCountryCodLBA.setCellValueFactory(new PropertyValueFactory("CountryCode"));
        this.collanguageLBA.setCellValueFactory(new PropertyValueFactory("Language"));
        this.colisOffLBA.setCellValueFactory(new PropertyValueFactory("IsOfficial"));
        this.colPercentageLBA.setCellValueFactory(new PropertyValueFactory("Percentage"));
    }

    private void modelacomboboxLenguajeBA() {
        this.cbxValoresNumLBA.getItems().addAll("Porcentaje");
        this.cbxValoresNumLBA.setPromptText("Seleccione");
        this.cbxcomparadorLBA.getItems().addAll("=", "<", ">", "<=", ">=");
        this.cbxcomparadorLBA.setValue("=");
        this.cbxSBBAL.getItems().addAll("Que contenga...", "Que empiece por...", "Que termine por...");
        this.cbxSBBAL.setValue("Que contenga...");
    }
    //==============================================================================================================

    private void goBackIdioma(MouseEvent event) {
        this.paneMEL.toFront();

    }

    private void goBackPais(MouseEvent event) {
        this.paneMEP.toFront();
    }

    private void goBackCiudad(MouseEvent event) {
        this.paneMEC.toFront();
    }
}