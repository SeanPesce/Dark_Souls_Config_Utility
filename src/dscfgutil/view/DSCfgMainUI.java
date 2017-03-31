/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.view;

import static dscfgutil.DSCfgUtilConstants.ABOUT_DSF;
import static dscfgutil.DSCfgUtilConstants.ABOUT_DSCU;
import static dscfgutil.DSCfgUtilConstants.APPLY_CONFIG;
import static dscfgutil.DSCfgUtilConstants.APPLY_DSF_KEYBINDS;
import static dscfgutil.DSCfgUtilConstants.APPLY_DSPW_CONFIG;
import static dscfgutil.DSCfgUtilConstants.CHECKING_FOR_DS;
import static dscfgutil.DSCfgUtilConstants.CHECKING_FOR_DSF;
import static dscfgutil.DSCfgUtilConstants.CHECKING_FOR_DSM;
import static dscfgutil.DSCfgUtilConstants.CHECKING_FOR_DSPW;
import static dscfgutil.DSCfgUtilConstants.CHECKING_FOR_DS_REG_ENTRIES;
import static dscfgutil.DSCfgUtilConstants.CHECKING_STEAM_LIBRARY;
import static dscfgutil.DSCfgUtilConstants.CHECK_FOR_DS_ITE_ERR;
import static dscfgutil.DSCfgUtilConstants.CHECK_FOR_DS_NO_REG_ACC_ERR;
import static dscfgutil.DSCfgUtilConstants.CHECK_FOR_DS_PROCESS;
import static dscfgutil.DSCfgUtilConstants.CHOOSE_DIRECTORY;
import static dscfgutil.DSCfgUtilConstants.CONFIGURE_DS;
import static dscfgutil.DSCfgUtilConstants.CONFIGURE_DSM;
import static dscfgutil.DSCfgUtilConstants.CONFIGURE_DSM_FAILED;
import static dscfgutil.DSCfgUtilConstants.CONSOLE;
import static dscfgutil.DSCfgUtilConstants.CONSOLE_HOVER;
import static dscfgutil.DSCfgUtilConstants.CONSOLE_POPOUT_HOVER;
import static dscfgutil.DSCfgUtilConstants.CONSOLE_POPOUT_ICON;
import static dscfgutil.DSCfgUtilConstants.COULDNT_APPLY_CFG_ERR;
import static dscfgutil.DSCfgUtilConstants.COULDNT_CHECK_PROCESSES;
import static dscfgutil.DSCfgUtilConstants.COULDNT_EXPORT_INVALID_INPUT_ERR;
import static dscfgutil.DSCfgUtilConstants.COULDNT_FIND_DS_PROCESS;
import static dscfgutil.DSCfgUtilConstants.CSS_DIRECTORY;
import static dscfgutil.DSCfgUtilConstants.DATA_FOLDER;
import static dscfgutil.DSCfgUtilConstants.DEFAULT_STEAM_DIR;
import static dscfgutil.DSCfgUtilConstants.DEFAULT_STEAM_SUBDIR;
import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_APPLY_DSM_CHAIN;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_APPLY_NO_DLL_CHAIN;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_DSM_INST_FIX_CHAINING;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_DSM_NOT_INST_FIX_CHAINING;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_DSM_REINSTALL;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_DSM_UNINSTALL;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_INSTALL_DSF;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_REINSTALL;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_REINSTALL_DSPW;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_UNINSTALL;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_UNINSTALL_DSPW;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_APPLY_CHANGES;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_CFG_NOT_APPLIED;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_DSM_UNINSTALL;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_INSTALL_DSF;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_RESET;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_UNINSTALL;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_UNINSTALL_DSPW;
import static dscfgutil.DSCfgUtilConstants.DIRECTORY;
import static dscfgutil.DSCfgUtilConstants.DIRECTORY_DESC;
import static dscfgutil.DSCfgUtilConstants.DS;
import static dscfgutil.DSCfgUtilConstants.DSCM_DELAY;
import static dscfgutil.DSCfgUtilConstants.DSCM_FILES;
import static dscfgutil.DSCfgUtilConstants.DSCM_FOLDER;
import static dscfgutil.DSCfgUtilConstants.DSCM_SHORT;
import static dscfgutil.DSCfgUtilConstants.DSF;
import static dscfgutil.DSCfgUtilConstants.DSCUTIL_FILE_NOT_FOUND;
import static dscfgutil.DSCfgUtilConstants.DSCU_OPTIONS;
import static dscfgutil.DSCfgUtilConstants.DSF_FILES;
import static dscfgutil.DSCfgUtilConstants.DSF_FOUND;
import static dscfgutil.DSCfgUtilConstants.DSF_NOT_FOUND;
import static dscfgutil.DSCfgUtilConstants.DSF_PARTIALLY_FOUND;
import static dscfgutil.DSCfgUtilConstants.DSF_STATUS;
import static dscfgutil.DSCfgUtilConstants.DSF_STATUS_DESC;
import static dscfgutil.DSCfgUtilConstants.DSM;
import static dscfgutil.DSCfgUtilConstants.DSMOUSE;
import static dscfgutil.DSCfgUtilConstants.DSM_FILES;
import static dscfgutil.DSCfgUtilConstants.DSM_FOUND;
import static dscfgutil.DSCfgUtilConstants.DSM_NOT_FOUND;
import static dscfgutil.DSCfgUtilConstants.DSM_STATUS_DESC;
import static dscfgutil.DSCfgUtilConstants.DSPW_FILES;
import static dscfgutil.DSCfgUtilConstants.DSPW_FOUND;
import static dscfgutil.DSCfgUtilConstants.DSPW_KEYBIND_HEX;
import static dscfgutil.DSCfgUtilConstants.DSPW_KEYBIND_NAMES;
import static dscfgutil.DSCfgUtilConstants.DSPW_NOT_FOUND;
import static dscfgutil.DSCfgUtilConstants.DSPW_SHORT;
import static dscfgutil.DSCfgUtilConstants.DSPW_STATUS_DESC;
import static dscfgutil.DSCfgUtilConstants.DS_EXE;
import static dscfgutil.DSCfgUtilConstants.DS_INSTALL_NOT_FOUND;
import static dscfgutil.DSCfgUtilConstants.DS_INSTALL_REG_VALUE_NAME;
import static dscfgutil.DSCfgUtilConstants.DS_REGISTRY_KEY;
import static dscfgutil.DSCfgUtilConstants.END_TRYING_DS_PROCESS;
import static dscfgutil.DSCfgUtilConstants.EXIT_PROGRAM;
import static dscfgutil.DSCfgUtilConstants.EXPORT_DSF;
import static dscfgutil.DSCfgUtilConstants.EXPORT_DSF_INI;
import static dscfgutil.DSCfgUtilConstants.EXPORT_DSF_KEYBINDS_INI;
import static dscfgutil.DSCfgUtilConstants.FILE;
import static dscfgutil.DSCfgUtilConstants.FOUND_DS;
import static dscfgutil.DSCfgUtilConstants.GRAPHICS;
import static dscfgutil.DSCfgUtilConstants.HELP;
import static dscfgutil.DSCfgUtilConstants.HUD;
import static dscfgutil.DSCfgUtilConstants.IMAGE_DIRECTORY;
import static dscfgutil.DSCfgUtilConstants.INSTALL_DSF;
import static dscfgutil.DSCfgUtilConstants.INVALID_INPUT;
import static dscfgutil.DSCfgUtilConstants.KEY_BINDINGS;
import static dscfgutil.DSCfgUtilConstants.LOAD;
import static dscfgutil.DSCfgUtilConstants.NOT_FOUND;
import static dscfgutil.DSCfgUtilConstants.OPTIONS;
import static dscfgutil.DSCfgUtilConstants.OTHER_OPS;
import static dscfgutil.DSCfgUtilConstants.PROGRAM;
import static dscfgutil.DSCfgUtilConstants.PROGRAM_ICON;
import static dscfgutil.DSCfgUtilConstants.RECHECK_DSF;
import static dscfgutil.DSCfgUtilConstants.REINSTALL_DSF;
import static dscfgutil.DSCfgUtilConstants.EXPORT_MENU;
import static dscfgutil.DSCfgUtilConstants.FAILED_OPEN_FOLDER_ERR;
import static dscfgutil.DSCfgUtilConstants.FILES_DIR;
import static dscfgutil.DSCfgUtilConstants.FOUND_DS_PROCESS;
import static dscfgutil.DSCfgUtilConstants.INSTALL_DSM;
import static dscfgutil.DSCfgUtilConstants.INSTALL_DSPW;
import static dscfgutil.DSCfgUtilConstants.LAUNCH;
import static dscfgutil.DSCfgUtilConstants.LAUNCHING_DS;
import static dscfgutil.DSCfgUtilConstants.LAUNCHING_DSCM;
import static dscfgutil.DSCfgUtilConstants.LAUNCHING_DSM;
import static dscfgutil.DSCfgUtilConstants.LAUNCH_DS;
import static dscfgutil.DSCfgUtilConstants.LAUNCH_DSCM;
import static dscfgutil.DSCfgUtilConstants.LAUNCH_DSCM_FAILED;
import static dscfgutil.DSCfgUtilConstants.LAUNCH_DS_AND_CM;
import static dscfgutil.DSCfgUtilConstants.LAUNCH_DS_FAILED;
import static dscfgutil.DSCfgUtilConstants.LOAD_DSF_CFG;
import static dscfgutil.DSCfgUtilConstants.LOAD_DSF_KEYBINDS;
import static dscfgutil.DSCfgUtilConstants.NONE;
import static dscfgutil.DSCfgUtilConstants.OPEN_DATA_FOLDER;
import static dscfgutil.DSCfgUtilConstants.PROGRAM_LONG;
import static dscfgutil.DSCfgUtilConstants.PROGRAM_VERSION;
import static dscfgutil.DSCfgUtilConstants.RECHECKING;
import static dscfgutil.DSCfgUtilConstants.RECHECK_DSPW;
import static dscfgutil.DSCfgUtilConstants.REINSTALL_DSM;
import static dscfgutil.DSCfgUtilConstants.REINSTALL_DSPW;
import static dscfgutil.DSCfgUtilConstants.SAVE_BACKUP;
import static dscfgutil.DSCfgUtilConstants.SETTINGS;
import static dscfgutil.DSCfgUtilConstants.SLEEP_INTERRUPTED;
import static dscfgutil.DSCfgUtilConstants.STATUS;
import static dscfgutil.DSCfgUtilConstants.STEAM_CFG_ENTRY;
import static dscfgutil.DSCfgUtilConstants.STEAM_CFG_FILE;
import static dscfgutil.DSCfgUtilConstants.STEAM_INSTALL_REG_KEYS;
import static dscfgutil.DSCfgUtilConstants.TEXTURES;
import static dscfgutil.DSCfgUtilConstants.TEXTURE_MODS;
import static dscfgutil.DSCfgUtilConstants.TEX_MOD_TT;
import static dscfgutil.DSCfgUtilConstants.TOGGLE_CONSOLE;
import static dscfgutil.DSCfgUtilConstants.TRYING_DEFAULT_DIR_ERR;
import static dscfgutil.DSCfgUtilConstants.UNABLE_TO_READ_FILE;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_DSF;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_DSM;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_DSPW;
import static dscfgutil.DSCfgUtilConstants.UNSAFE_OPS;
import static dscfgutil.DSCfgUtilConstants.WAITING;
import static dscfgutil.DSCfgUtilConstants.WINDOW_MOUSE;
import static dscfgutil.DSCfgUtilConstants.WRITING_FILE;
import dscfgutil.FileIO.DSFixFileController;
import static dscfgutil.FileIO.DSFixFileController.launchProgram;
import static dscfgutil.FileIO.DSFixFileController.processIsRunning;
import dscfgutil.FileIO.WinRegistry;
import dscfgutil.configs.DSFConfiguration;
import dscfgutil.configs.DSFKeybindsConfiguration;
import dscfgutil.configs.DSPWConfiguration;
import dscfgutil.dialog.AlertDialog;
import dscfgutil.dialog.ContinueDialog;
import dscfgutil.dialog.CopyableMsgDialog;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Sean Pesce
 */
public class DSCfgMainUI {
    
    //INSTANCE VARIABLES:
    private int dsfStatus; //Installed status of DSFix (Installed, Not Installed, or Unknown)
    private int dsmStatus; //Installed status of DSMouseFix (Installed, Not Installed, or Unknown)
    private int dspwStatus; //Installed status of DS PvP Watchdog (Installed, Not Installed, or Unknown)
    DSFConfiguration config; //Config object for saving/loading/editing DSFix configs
    DSFKeybindsConfiguration dsfKeybinds; //Config object for saving/loading/editing DSFix keybinds
    DSPWConfiguration dspwConfig; //Config object for saving/loading/editing DS PvP Watchdog settings
    File dataFolder; //Directory of DATA folder in Dark Souls install directory, if it exists
    boolean showConsoleBar = true; //Indicates if the console bar is visible
    boolean showConsoleWindow = false;//Indicates if the console window is open
    String consoleLog;
    DSFixFileController fileController;
    CopyableMsgDialog consoleWindow;
    
    //UI COMPONENTS:
    //Primary window builders
    Stage primaryStage;
    Scene primaryScene;
    VBox primaryVBox;
    //
    //File toolbar
    MenuBar fileToolbar;
    Menu fileMenu;
    //////File options
        Menu loadMenu;
            MenuItem loadDSFCfg;
            MenuItem loadDSFKeybinds;
        Menu     exportMenu;
            MenuItem exportDSFIni;
            MenuItem exportDSFKeybindsIni;
            MenuItem exportDSF;
        MenuItem exitProgram;
    //////Dark Souls options
    Menu dsMenu;
        MenuItem launchDS;
        MenuItem configureDS;
        MenuItem openDataFolder;
    //
    ///////DSFix options
    Menu dsfMenu;
        MenuItem applyConfig;
        MenuItem applyDSFKeybinds;
        MenuItem installDSF;
        MenuItem uninstallDSF;
        MenuItem recheckDSF;
    //
    ///////DSMFix options
    Menu dsmMenu;
        MenuItem installDSM;
        MenuItem uninstallDSM;
        MenuItem configureDSM;
    //
    ///////DS PvP Watchdog options
    Menu dspwMenu;
        MenuItem applyDSPWConfig;
        MenuItem installDSPW;
        MenuItem uninstallDSPW;
        MenuItem recheckDSPW;
    //
    ///////Dark Souls Connectivity Mod options
    Menu dscmMenu;
        MenuItem launchDSCM;
        MenuItem launchDSAndCM;
    //
    //////DSCfgUtil options
    Menu optionsMenu;
        MenuItem toggleConsole;
    Menu helpMenu;
    //////Help options
        MenuItem aboutDSF;
        MenuItem aboutDSCU;
    //
    //Directory toolbar
    HBox directoryToolbar;
    Label directoryLabel;
    TextField directoryField;
    Button directoryButton;
    //
    //Tab Pane
    TabPane primaryTabPane;
    Tab graphicsTab;
    DSFGraphicsPane graphicsPane;
    Tab hudTab;
    DSFHudPane hudPane;
    Tab windowMouseTab;
    DSFWindowMousePane wmPane;
    Tab savesTab;
    DSFSavesPane savesPane;
    Tab texturesTab;
    DSFTexturesPane texPane;
    Tab otherTab;
    DSFOtherSettingsPane otherPane;
    Tab unsafeTab;
    DSFUnsafeSettingsPane unsafePane;
    Tab keysTab;
    DSFKeybindsPane keysPane;
    Tab dspwTab;
    DSPWPane dspwPane;
    Tab texModsTab;
    DSFTextureModPane texModsPane;
    //
    //Console
    HBox consoleBar;
    Label consoleLabel;
    TextField consoleText;
    Button consoleButton;
    //Status bar
    HBox statusBar;
    Label dsfStatusLabeller;
    Label dsfStatusLabel;
    Label dsmStatusLabeller;
    Label dsmStatusLabel;
    Label dspwStatusLabeller;
    Label dspwStatusLabel;
    
    /**
     * Default (and only) constructor.
     */
    public DSCfgMainUI(Stage initStage){
        primaryStage = initStage;
        fileController = new DSFixFileController(this);
        consoleLog = new String("");
        fileController.getVersion();
        initUI();
    }
    
    /**
     * Initializes the entire UI.
     * 
     */
    private void initUI(){
        initWindow();
        
        
        //Check that DLL chaining is enabled if DSMFix is installed, or check
        // that DLL chaining is not set to dsmfix.dll if DSMfix is not installed
        if(dsmStatus == 0 && !config.dinput8dllWrapper.toString().equals(DSM_FILES[0])){
            config.dinput8dllWrapper.replace(0, config.dinput8dllWrapper.length(), DSM_FILES[0]);
            setSelectedTab(5);
            AlertDialog aD = new AlertDialog(300.0, 80.0, DIALOG_TITLE_APPLY_CHANGES,
                                            DIALOG_MSG_DSM_INST_FIX_CHAINING + 
                                            "\n\n" + DIALOG_MSG_APPLY_DSM_CHAIN,
                                            DIALOG_BUTTON_TEXTS[0]);
        }else if((dsmStatus == 1 || dsmStatus == 2) && config.dinput8dllWrapper.toString().equals(DSM_FILES[0])){
            config.dinput8dllWrapper.replace(0, config.dinput8dllWrapper.length(), NONE);
            setSelectedTab(5);
            AlertDialog aD = new AlertDialog(300.0, 80.0, DIALOG_TITLE_APPLY_CHANGES,
                                            DIALOG_MSG_DSM_NOT_INST_FIX_CHAINING + 
                                            "\n\n" + DIALOG_MSG_APPLY_NO_DLL_CHAIN,
                                            DIALOG_BUTTON_TEXTS[0]);
        }
    }
    
    private void initWindow(){
        
        //Set window size
        Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setX(bounds.getMaxX() / 4.0);
	primaryStage.setY(bounds.getMaxY() / 4.0);
	primaryStage.setWidth(bounds.getWidth() / 2.0);
	primaryStage.setHeight(bounds.getHeight() / 2.0);
        
        primaryVBox = new VBox();
        primaryScene = new Scene(primaryVBox);
        
        //Set window title, icon, and stylesheet
        primaryStage.setTitle(PROGRAM_LONG + " v" + PROGRAM_VERSION);
        primaryStage.getIcons().add(new Image("file:" + IMAGE_DIRECTORY +
                                                          "\\" + PROGRAM_ICON));
        primaryScene.getStylesheets().add(getClass().getResource(
                                               CSS_DIRECTORY).toExternalForm());
        //Set up UI
        initializeFileToolbar();
        initializeDirectoryToolbar();
        initializeConsoleBar();
        initializeStatusBar();
        checkForDS();
        dsfKeybinds = new DSFKeybindsConfiguration(this, true);
        config = new DSFConfiguration(this, true);
        dspwConfig = new DSPWConfiguration(this, true);
        initializeSettingsTabs();
        primaryVBox.getChildren().addAll(fileToolbar, directoryToolbar,
                                         primaryTabPane, statusBar, consoleBar);
        primaryStage.setScene(primaryScene);
        
        
        primaryStage.show();
        
        initializeEventHandlers();
        
        refreshUI();
        
        if(dsfStatus == 1){
            ContinueDialog cD = new ContinueDialog(300.0, 80.0, DIALOG_TITLE_INSTALL_DSF,
                                DIALOG_MSG_INSTALL_DSF, DIALOG_BUTTON_TEXTS[2],
                                DIALOG_BUTTON_TEXTS[3]);
            if(cD.show()){
                fileController.installDSFix();
            }
        }
        
    }
    
    private void initializeFileToolbar(){
        
        //File toolbar options
        fileToolbar = new MenuBar();
        fileMenu = new Menu(FILE);
        dsMenu = new Menu(DS);
        dsfMenu = new Menu(DSF);
        dsmMenu = new Menu(DSMOUSE);
        dspwMenu = new Menu(DSPW_SHORT);
        dscmMenu = new Menu(DSCM_SHORT);
        optionsMenu = new Menu(DSCU_OPTIONS);
        helpMenu = new Menu(HELP);
        fileToolbar.getMenus().addAll(fileMenu, dsMenu, dsfMenu, dsmMenu,
                                      dspwMenu, dscmMenu, optionsMenu, helpMenu);
        
        //File menu options
        loadMenu = new Menu(LOAD);
            loadDSFCfg = new MenuItem(LOAD_DSF_CFG);
            loadDSFKeybinds = new MenuItem(LOAD_DSF_KEYBINDS);
        loadMenu.getItems().addAll(loadDSFCfg, loadDSFKeybinds);
        exportMenu = new Menu(EXPORT_MENU);
            exportDSFIni = new MenuItem(EXPORT_DSF_INI);
            exportDSFKeybindsIni = new MenuItem(EXPORT_DSF_KEYBINDS_INI);
            exportDSF = new MenuItem(EXPORT_DSF);
        exportMenu.getItems().addAll(exportDSFIni, exportDSFKeybindsIni, exportDSF);
        exitProgram = new MenuItem(EXIT_PROGRAM);
        fileMenu.getItems().addAll(loadMenu, exportMenu, exitProgram);
        
        //Dark Souls menu options
        launchDS = new MenuItem(LAUNCH + " " + DS);
        configureDS = new MenuItem(CONFIGURE_DS);
        openDataFolder = new MenuItem(OPEN_DATA_FOLDER);
        dsMenu.getItems().addAll(launchDS, openDataFolder); //@todo: add configureDS if you want to add support for configuring in-game settings
        
        //DSFix menu options
        applyConfig = new MenuItem(APPLY_CONFIG);
        applyDSFKeybinds = new MenuItem(APPLY_DSF_KEYBINDS);
        installDSF = new MenuItem(INSTALL_DSF);
        uninstallDSF = new MenuItem(UNINSTALL_DSF);
        recheckDSF = new MenuItem(RECHECK_DSF);
        dsfMenu.getItems().addAll(applyConfig, applyDSFKeybinds, installDSF,
                                                uninstallDSF, recheckDSF);
        
        //DSMfix menu options
        installDSM = new MenuItem(INSTALL_DSM);
        uninstallDSM = new MenuItem(UNINSTALL_DSM);
        configureDSM = new MenuItem(CONFIGURE_DSM);
        dsmMenu.getItems().addAll(installDSM, uninstallDSM, configureDSM);
        
        //DS PvP Watchdog menu options
        applyDSPWConfig = new MenuItem(APPLY_DSPW_CONFIG);
        installDSPW = new MenuItem(INSTALL_DSPW);
        uninstallDSPW = new MenuItem(UNINSTALL_DSPW);
        recheckDSPW = new MenuItem(RECHECK_DSPW);
        dspwMenu.getItems().addAll(applyDSPWConfig, installDSPW, uninstallDSPW,
                                    recheckDSPW);
        
        //Dark Souls Connectivity Mod options
        launchDSCM = new MenuItem(LAUNCH_DSCM);
        launchDSAndCM = new MenuItem(LAUNCH_DS_AND_CM);
        dscmMenu.getItems().addAll(launchDSCM, launchDSAndCM);
        
        //DSCfgUtil Options menu
        toggleConsole = new MenuItem(TOGGLE_CONSOLE[0]);
        optionsMenu.getItems().add(toggleConsole);
        
        //Help menu options
        aboutDSF = new MenuItem(ABOUT_DSF);
        aboutDSCU = new MenuItem(ABOUT_DSCU);
        helpMenu.getItems().addAll(aboutDSF, aboutDSCU);
    }
    
    private void initializeDirectoryToolbar(){
        
        //Initialize
        directoryToolbar = new HBox();
        directoryLabel = new Label("   " + DS + " " + DIRECTORY + ":  ");
        directoryLabel.setTooltip(new Tooltip(DIRECTORY_DESC));
        directoryField = new TextField();
        directoryField.setEditable(false);
        directoryField.setTooltip(new Tooltip(DIRECTORY_DESC));
        directoryButton = new Button("...");
        directoryButton.setTooltip(new Tooltip(CHOOSE_DIRECTORY));
        
        
        //Stylize
        directoryToolbar.getStyleClass().add("gray_background");
        directoryLabel.getStyleClass().add("translate_y_4");
        directoryLabel.setPrefWidth(127.0);
        directoryField.getStyleClass().add("text_field");
        directoryField.setPrefWidth(primaryStage.getWidth() - 164.0);
        
        directoryToolbar.getChildren().addAll(directoryLabel, directoryField,
                                              directoryButton);
        
    }
    
    private void initializeSettingsTabs(){
        
        primaryTabPane = new TabPane();
        graphicsTab = new Tab(GRAPHICS);
        hudTab = new Tab(HUD);
        windowMouseTab = new Tab(WINDOW_MOUSE);
        savesTab = new Tab(SAVE_BACKUP);
        texturesTab = new Tab(TEXTURES);
        otherTab = new Tab(OTHER_OPS);
        unsafeTab = new Tab(UNSAFE_OPS);
        keysTab = new Tab(KEY_BINDINGS);
        dspwTab = new Tab(DSPW_SHORT);
        texModsTab = new Tab(TEXTURE_MODS);
        
        
        //Populate tabs
        graphicsPane = new DSFGraphicsPane(this);
        graphicsPane.setPrefHeight(Integer.MAX_VALUE);
        graphicsTab.setContent(graphicsPane);
        hudPane = new DSFHudPane(this);
        hudPane.setPrefHeight(Integer.MAX_VALUE);
        hudTab.setContent(hudPane);
        wmPane = new DSFWindowMousePane(this);
        wmPane.setPrefHeight(Integer.MAX_VALUE);
        windowMouseTab.setContent(wmPane);
        savesPane = new DSFSavesPane(this);
        savesPane.setPrefHeight(Integer.MAX_VALUE);
        savesTab.setContent(savesPane);
        texPane = new DSFTexturesPane(this);
        texPane.setPrefHeight(Integer.MAX_VALUE);
        texturesTab.setContent(texPane);
        otherPane = new DSFOtherSettingsPane(this);
        otherPane.setPrefHeight(Integer.MAX_VALUE);
        otherTab.setContent(otherPane);
        unsafePane = new DSFUnsafeSettingsPane(this);
        unsafePane.setPrefHeight(Integer.MAX_VALUE);
        unsafeTab.setContent(unsafePane);
        keysPane = new DSFKeybindsPane(this);
        keysPane.setPrefHeight(Integer.MAX_VALUE);
        keysTab.setContent(keysPane);
        dspwPane = new DSPWPane(this);
        dspwPane.setPrefHeight(Integer.MAX_VALUE);
        dspwTab.setContent(dspwPane);
        texModsPane = new DSFTextureModPane(this);
        texModsPane.setPrefHeight(Integer.MAX_VALUE);
        texModsTab.setContent(texModsPane);
        
        primaryTabPane.getTabs().addAll(graphicsTab, hudTab, windowMouseTab,
                                        savesTab, texturesTab, otherTab,
                                        unsafeTab, keysTab, dspwTab, texModsTab);
        
        for(Tab tab : primaryTabPane.getTabs()){
            tab.setClosable(false);
            tab.setTooltip(new Tooltip(DSF +  " " + tab.getText() + " " + OPTIONS));
        }
        keysTab.setTooltip(new Tooltip(KEY_BINDINGS));
        dspwTab.setTooltip(new Tooltip(DSPW_SHORT + " " + OPTIONS));
        texModsTab.setTooltip(new Tooltip(TEX_MOD_TT));
    }
    
    private void initializeConsoleBar(){
        
        //Initialize
        consoleBar = new HBox();
        consoleLabel = new Label("    " + CONSOLE + ":  ");
        consoleText = new TextField();
        consoleText.setEditable(false);
        consoleButton = new Button();
        
        //Stylize
        consoleBar.getStyleClass().add("gray_background");
        consoleLabel.getStyleClass().add("translate_y_4");
        consoleLabel.setTooltip(new Tooltip(CONSOLE_HOVER));
        consoleText.getStyleClass().add("console_text");
        consoleText.setTooltip(new Tooltip(CONSOLE_HOVER));
        consoleText.setAlignment(Pos.CENTER);
        consoleText.setPrefWidth(primaryStage.getWidth() - 115.0);
        consoleButton.setGraphic(new ImageView("file:" + IMAGE_DIRECTORY + "\\"+
                                            CONSOLE_POPOUT_ICON));
        consoleButton.setTooltip(new Tooltip(CONSOLE_POPOUT_HOVER));
        consoleBar.getChildren().addAll(consoleLabel, consoleText, consoleButton);
    }
    
    private void initializeStatusBar(){
        
        
        //Initialize
        statusBar = new HBox();
        statusBar.setMinHeight(24.0);
        dsfStatusLabeller = new Label("  " + DSF + " " + STATUS + ": ");
        dsfStatusLabeller.setTooltip(new Tooltip(DSF_STATUS_DESC));
        dsfStatusLabel = new Label();
        dsfStatusLabel.setTextOverrun(OverrunStyle.CLIP);
        dsfStatusLabel.setTooltip(new Tooltip(DSF_STATUS_DESC));
        dsmStatusLabeller = new Label("  " + DSMOUSE + " " + STATUS + ": ");
        dsmStatusLabeller.setTooltip(new Tooltip(DSM_STATUS_DESC));
        dsmStatusLabel = new Label();
        dsmStatusLabel.setTextOverrun(OverrunStyle.CLIP);
        dsmStatusLabel.setTooltip(new Tooltip(DSM_STATUS_DESC));
        dspwStatusLabeller = new Label("  " + DSPW_SHORT + " " + STATUS + ": ");
        dspwStatusLabeller.setTooltip(new Tooltip(DSPW_STATUS_DESC));
        dspwStatusLabel = new Label();
        dspwStatusLabel.setTextOverrun(OverrunStyle.CLIP);
        dspwStatusLabel.setTooltip(new Tooltip(DSPW_STATUS_DESC));
        
        //Stylize
        statusBar.getStyleClass().add("light_gray_background_border");
        statusBar.setAlignment(Pos.TOP_CENTER);
        dsfStatusLabeller.getStyleClass().add("translate_y_4");
        dsfStatusLabeller.setPrefWidth(80.0);
        //dsfStatusLabeller.setPrefWidth(primaryStage.getWidth() - 487.0);
        dsfStatusLabeller.setAlignment(Pos.CENTER_RIGHT);
        dsfStatusLabel.setPrefWidth(80.0);
        //dsfStatusLabel.setAlignment(Pos.CENTER);
        dsmStatusLabeller.getStyleClass().add("translate_y_4");
        dsmStatusLabeller.setPrefWidth(117.0);
        //dsmStatusLabeller.setAlignment(Pos.CENTER);
        dsmStatusLabel.setPrefWidth(80.0);
        //dsmStatusLabel.setAlignment(Pos.CENTER);
        dspwStatusLabeller.getStyleClass().add("translate_y_4");
        dspwStatusLabeller.setPrefWidth(130.0);
        //dspwStatusLabeller.setAlignment(Pos.CENTER);
        dspwStatusLabel.setPrefWidth(80.0);
        //dspwStatusLabel.setAlignment(Pos.CENTER);
        
        statusBar.getChildren().addAll(dsfStatusLabeller, dsfStatusLabel,
                                       dsmStatusLabeller, dsmStatusLabel,
                                       dspwStatusLabeller, dspwStatusLabel);
    }
    
    private void initializeEventHandlers(){
        
        //FILE TOOLBAR
        //File menu
        //
        loadDSFCfg.setOnAction(e -> {
           fileController.loadDSFConfig();
           if(getCurrentTab() >= 7){
               primaryTabPane.getSelectionModel().select(0);
           }
           refreshUI();
        });
        //
        loadDSFKeybinds.setOnAction(e -> {
           fileController.loadDSFKeybinds();
           primaryTabPane.getSelectionModel().select(7);
           refreshUI();
        });
        //
        exportDSF.setOnAction(e -> {
            if(!invalidDSFInputsExist()){
                fileController.exportDSF();
            }else{
                AlertDialog aD = new AlertDialog(300.0, 80.0, DIALOG_TITLE_CFG_NOT_APPLIED,
                                                  COULDNT_EXPORT_INVALID_INPUT_ERR,
                                                  DIALOG_BUTTON_TEXTS[0]);
            }
        });
        //
        exportDSFIni.setOnAction(e -> {
            if(!invalidDSFInputsExist()){
                fileController.exportDSFIniFile();
            }else{
                AlertDialog aD = new AlertDialog(300.0, 80.0, DIALOG_TITLE_CFG_NOT_APPLIED,
                                                  COULDNT_EXPORT_INVALID_INPUT_ERR,
                                                  DIALOG_BUTTON_TEXTS[0]);
            }
        });
        //
        exportDSFKeybindsIni.setOnAction(e -> {
            fileController.exportDSFKeybindsIniFile();
        });
        //
        exitProgram.setOnAction(e -> {
            if(showConsoleWindow & consoleWindow != null){
                consoleWindow.close();
            }
            System.exit(0);
        });
        //
        //Dark Souls Menu
        launchDS.setOnAction(e -> {
            try {
                URI dsURI = new URI(LAUNCH_DS);
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().browse(dsURI);
                }
            } catch (URISyntaxException | IOException ex) {
                printConsole(LAUNCH_DS_FAILED + ", " + ex.toString());
            }
        });
        //
        openDataFolder.setOnAction(e -> {
            try {
                Desktop.getDesktop().open(dataFolder);
            } catch (IOException ex) {
                //Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
                printConsole(FAILED_OPEN_FOLDER_ERR);
            }
        });
        //
        //DSFix menu
        applyConfig.setOnAction(e -> {
            applyDSFConfig();
        });
        //
        applyDSFKeybinds.setOnAction(e -> {
            keysPane.applySettingsButton.setDisable(true);
            dsfKeybinds.writeSettingsToIniFile(dataFolder.getPath() + "\\" + DSF_FILES[2]);
            keysPane.applySettingsButton.setDisable(false);
        });
        //
        installDSF.setOnAction(e -> {
            if(dsfStatus == 0 || dsfStatus == 2){
                ContinueDialog cD = new ContinueDialog(300.0, 80.0, 
                                        DIALOG_TITLE_RESET, DIALOG_MSG_REINSTALL,
                                        DIALOG_BUTTON_TEXTS[2], DIALOG_BUTTON_TEXTS[1]);
                if(cD.show()){
                    fileController.installDSFix();
                }
            }else{
                fileController.installDSFix();
            }
        });
        //
        uninstallDSF.setOnAction(e -> {
            ContinueDialog cD = new ContinueDialog(300.0, 80.0, 
                                        DIALOG_TITLE_UNINSTALL, DIALOG_MSG_UNINSTALL,
                                        DIALOG_BUTTON_TEXTS[2], DIALOG_BUTTON_TEXTS[1]);
            if(cD.show()){
                fileController.uninstallDSFix();
            }
        });
        //
        recheckDSF.setOnAction(e -> {
            checkForDSFix();
            if(dsfStatus == 0){
                printConsole(DSF_FOUND);
            }else if(dsfStatus == 1){
                printConsole(DSF_NOT_FOUND);
            }else{
                printConsole(DSF_PARTIALLY_FOUND);
            }
        });
        //
        //DSMFix menu
        installDSM.setOnAction(e -> {
           if(dsmStatus == 0 || dsmStatus == 2){
                ContinueDialog cD = new ContinueDialog(300.0, 80.0, 
                                        DIALOG_TITLE_RESET, DIALOG_MSG_DSM_REINSTALL,
                                        DIALOG_BUTTON_TEXTS[2], DIALOG_BUTTON_TEXTS[1]);
                if(cD.show()){
                    fileController.installDSMFix();
                    enableAndDisableElements();
                }
            }else{
                fileController.installDSMFix();
                enableAndDisableElements();
            }
        });
        //
        uninstallDSM.setOnAction(e -> {
            ContinueDialog cD = new ContinueDialog(300.0, 80.0, 
                                        DIALOG_TITLE_DSM_UNINSTALL, DIALOG_MSG_DSM_UNINSTALL,
                                        DIALOG_BUTTON_TEXTS[2], DIALOG_BUTTON_TEXTS[1]);
            if(cD.show()){
                fileController.uninstallDSMFix();
                enableAndDisableElements();
            }
        });
        //
        configureDSM.setOnAction(e -> {
            try {
                printConsole(LAUNCHING_DSM);
                String cfgDSM = dataFolder.toPath() + "\\" + DSM_FILES[2];
                File cfgDSMFile = new File(cfgDSM);
                Process dsmFix = Runtime.getRuntime().exec(cfgDSMFile.getPath(), null, dataFolder);
            } catch (IOException ex) {
                printConsole(CONFIGURE_DSM_FAILED + ": " + ex.toString());
            }
        });
        //
        //PvP Watchdog menu
        applyDSPWConfig.setOnAction(e -> {
            applyDSPWConfig();
        });
        //
        installDSPW.setOnAction(e -> {
            if(dspwStatus == 0 || dspwStatus == 2){
                ContinueDialog cD = new ContinueDialog(300.0, 80.0, 
                                        DIALOG_TITLE_RESET, DIALOG_MSG_REINSTALL_DSPW,
                                        DIALOG_BUTTON_TEXTS[2], DIALOG_BUTTON_TEXTS[1]);
                if(cD.show()){
                    fileController.installDSPW();
                }
            }else{
                fileController.installDSPW();
            }
        });
        //
        uninstallDSPW.setOnAction(e -> {
            ContinueDialog cD = new ContinueDialog(300.0, 80.0, 
                                        DIALOG_TITLE_UNINSTALL_DSPW, DIALOG_MSG_UNINSTALL_DSPW,
                                        DIALOG_BUTTON_TEXTS[2], DIALOG_BUTTON_TEXTS[1]);
            if(cD.show()){
                fileController.uninstallDSPW();
            }
        });
        //
        recheckDSPW.setOnAction(e -> {
            checkForDSPW();
        });
        //
        //Dark Souls Connectivity Mod menu
        launchDSAndCM.setOnAction(e -> {
            try {
                printConsole(LAUNCHING_DS);
                URI programURI = new URI(LAUNCH_DS);
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().browse(programURI);
                }
            } catch (URISyntaxException | IOException ex) {
                printConsole(LAUNCH_DS_FAILED + ", " + ex.toString());
                return;
            }
            
            printConsole(CHECK_FOR_DS_PROCESS);
            
            disableElementsForSleeping();
            for(int i = DSCM_DELAY; i >= 0; i--){
                try {
                    Thread.sleep(1000); //Sleep 1 second
                    try{
                        if(processIsRunning(DS_EXE)){
                            //Dark Souls process found
                            i = -1; //End counter and loop
                            printConsole(FOUND_DS_PROCESS);
                            Thread.sleep(2000);
                        }else{
                            //Dark Souls process not found
                            if(i != 0){
                                printConsole(COULDNT_FIND_DS_PROCESS
                                        + RECHECKING[0] + i + RECHECKING[1]);
                            }else{
                                printConsole(END_TRYING_DS_PROCESS);
                                Thread.sleep(2000);
                            }
                        }
                    }catch(SecurityException | IOException ex){
                        //Error when attempting to check current process list
                        i = -1; //End counter and loop
                        printConsole(COULDNT_CHECK_PROCESSES);
                        for(int j = DSCM_DELAY; j >= 0; j--){
                            Thread.sleep(1000); //Sleep 1 second
                            printConsole(WAITING[0] + j + WAITING[1]);
                        }
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(DSCfgMainUI.class.getName()).log(Level.SEVERE, null, ex);
                    printConsole(SLEEP_INTERRUPTED);
                }
                
            }
            enableElementsForSleeping();
            
            try {
                printConsole(LAUNCHING_DSCM);
                launchProgram(FILES_DIR + DSCM_FOLDER + "\\" + DSCM_FILES[1]);
            } catch (IOException ex) {
                printConsole(LAUNCH_DSCM_FAILED + ": " + ex.toString());
            }
        });
        
        launchDSCM.setOnAction(e -> {
            try {
                printConsole(LAUNCHING_DSCM);
                launchProgram(FILES_DIR + DSCM_FOLDER + "\\" + DSCM_FILES[1]);
            } catch (IOException ex) {
                printConsole(LAUNCH_DSCM_FAILED + ": " + ex.toString());
            }
        });
        //
        //Options menu
        toggleConsole.setOnAction(e -> {
            if(showConsoleBar){
                primaryVBox.getChildren().remove(consoleBar);
                showConsoleBar = false;
                showConsoleWindow = false;
                toggleConsole.setText(TOGGLE_CONSOLE[0]);
            }else if(showConsoleWindow){
                showConsoleBar = false;
                showConsoleWindow = false;
                consoleWindow.close();
                toggleConsole.setText(TOGGLE_CONSOLE[0]);
            }else{
                primaryVBox.getChildren().add(consoleBar);
                showConsoleBar = true;
                toggleConsole.setText(TOGGLE_CONSOLE[1]);
            }
            enableAndDisableElements();
        });
        
        //Directory bar
        //
        directoryField.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(dataFolder != null && mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getClickCount() == 2){
                        try {
                            Desktop.getDesktop().open(dataFolder);
                        } catch (IOException ex) {
                            //Logger.getLogger(DSFixFileController.class.getName()).log(Level.SEVERE, null, ex);
                            printConsole(FAILED_OPEN_FOLDER_ERR);
                        }
                    }
                }
            }
        });
        //
        directoryButton.setOnAction(e -> {
            fileController.chooseDataFolder();
        });
        
        //Console bar
        //
        consoleButton.setOnAction(e -> {
            consoleWindow = new CopyableMsgDialog(500.0, 200.0, 
                                        CONSOLE.toUpperCase(), consoleLog,
                                        DIALOG_BUTTON_TEXTS[5]);
            consoleWindow.getAlert().initModality(Modality.NONE);
            primaryVBox.getChildren().remove(primaryVBox.getChildren().size() - 1);
            
            showConsoleBar = false;
            showConsoleWindow = true;
            
            consoleWindow.getAlert().setResizable(true);
            //consoleWindow.getStage().setX(Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 
            //                            consoleWindow.getDPane().getMinWidth() - 30); //this was causing issues for some people
            consoleWindow.show();
            
            if(showConsoleWindow){
                showConsoleWindow = false;
                showConsoleBar = true;
                primaryVBox.getChildren().add(consoleBar);
            }
            
        });
        
        //When exiting program:
        primaryStage.setOnCloseRequest(e -> {
            if(showConsoleWindow & consoleWindow != null){
                consoleWindow.close();
            }
        });
        
        //When changing tabs:
        primaryTabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldWidth, Number newWidth) {
                    refreshUI();
                }
            });
        
        //All resizings based on window size will happen here
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldWidth, Number newWidth) {
                    directoryField.setPrefWidth(newWidth.doubleValue() - 164.0);
                    consoleText.setPrefWidth(newWidth.doubleValue() - 115.0);
                }
            });
        
        
        directoryField.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue,
                                    String oldText, String newText) {
                    //Check for valid Dark Souls directory
                    File tempDirectoryChecker = new File(newText);
                    if(!tempDirectoryChecker.exists()){
                        directoryField.pseudoClassStateChanged(INVALID_INPUT, true);
                    }else{
                        directoryField.pseudoClassStateChanged(INVALID_INPUT, false);
                    }
                    
                }
            });
    }
    
    private void checkForDS(){
        printConsole(CHECKING_FOR_DS);
        
        //Check for DARKSOULS.exe in current working directory
        boolean checkReg = true;
        String workingDir = Paths.get(".").toAbsolutePath().toString();
        if(workingDir.lastIndexOf(DATA_FOLDER) != -1){
            workingDir = workingDir.substring(0, workingDir.lastIndexOf(DATA_FOLDER) + DATA_FOLDER.length());
            dataFolder = new File(workingDir + "\\" + DS_EXE);
            if(dataFolder.exists()){
                checkReg = false;
                dataFolder = new File(workingDir);
            }else{
                dataFolder = null;
            }
        }
        
        //Check for Steam install in registry, and use config.vdf to find games library directory
        File steamFolder;
        String line;
        printConsole(CHECKING_STEAM_LIBRARY);
        for(int i = 0; i < STEAM_INSTALL_REG_KEYS.length && checkReg; i++){
            try{
                String installDir = WinRegistry.readString(
                            WinRegistry.HKEY_LOCAL_MACHINE, //HKEY
                            STEAM_INSTALL_REG_KEYS[i], //Key
                            DS_INSTALL_REG_VALUE_NAME[2]); //ValueName
                steamFolder = new File(installDir + STEAM_CFG_FILE);
                if(steamFolder.exists()){
                    try {
                        Scanner cfgReader = new Scanner(steamFolder);
                        while(cfgReader.hasNext()){
                            line = cfgReader.nextLine();
                            if(line.contains(STEAM_CFG_ENTRY)){
                                line = line.trim();
                                line = line.substring(line.indexOf(':') - 1);
                                line = line.substring(0, line.indexOf('"'));
                                line = line.replace("\\\\", "\\");
                                line += DEFAULT_STEAM_SUBDIR + DATA_FOLDER;
                                dataFolder = new File(line);
                                if(dataFolder.exists()){
                                    checkReg = false;
                                    printConsole(FOUND_DS + line);
                                    break;
                                }else{
                                    dataFolder = null;
                                }
                            }
                        }
                    } catch (FileNotFoundException ex) {
                        printConsole(UNABLE_TO_READ_FILE + steamFolder.getName());
                    }
                }
            }catch(IllegalAccessException iAE){
                //User doesn't have permission to access registry, try crappy method
                printConsole(CHECK_FOR_DS_NO_REG_ACC_ERR + TRYING_DEFAULT_DIR_ERR);
                break;
            }catch(InvocationTargetException iTE){
                printConsole(CHECK_FOR_DS_ITE_ERR + TRYING_DEFAULT_DIR_ERR);
                break;
            }
        }
        
        //Check for Dark Souls install in registry
        if(checkReg){
            printConsole(CHECKING_FOR_DS_REG_ENTRIES);
        }
        for(int i = 0; i < DS_REGISTRY_KEY.length && checkReg; i++){
            try{
                String installDir;
                if(i == 0 || i == 1){ //Check Windows uninstall registry keys
                    installDir = WinRegistry.readString(
                            WinRegistry.HKEY_LOCAL_MACHINE, //HKEY
                            DS_REGISTRY_KEY[i], //Key
                            DS_INSTALL_REG_VALUE_NAME[0]); //ValueName
                }else{ //Check Dark Souls game registry keys
                    installDir = WinRegistry.readString(
                            WinRegistry.HKEY_LOCAL_MACHINE, //HKEY
                            DS_REGISTRY_KEY[i], //Key
                            DS_INSTALL_REG_VALUE_NAME[1]); //ValueName
                }
                dataFolder = new File(installDir + DATA_FOLDER);
                if(dataFolder.exists()){
                    printConsole(FOUND_DS + installDir);
                    break;
                }else{
                    dataFolder = null;
                }
            }catch(IllegalAccessException iAE){
                //User doesn't have permission to access registry, try crappy method
                printConsole(CHECK_FOR_DS_NO_REG_ACC_ERR + TRYING_DEFAULT_DIR_ERR);
                checkForDSDefaultDirectories();
                if(dataFolder != null && dataFolder.exists()){
                    break;
                }else{
                    dataFolder = null;
                }
            }catch(InvocationTargetException iTE){
                printConsole(CHECK_FOR_DS_ITE_ERR + TRYING_DEFAULT_DIR_ERR);
                checkForDSDefaultDirectories();
                if(dataFolder != null && dataFolder.exists()){
                    break;
                }else{
                    dataFolder = null;
                }
            }
        }
        
        if(dataFolder != null && dataFolder.exists()){
            checkForDSFix();
            checkForDSPW();
        }else{
            printConsole(DS_INSTALL_NOT_FOUND);
            dataFolder = null;
            setDSFStatus(2);
            setDSPWStatus(1);
        }
    }
    
    private void checkForDSDefaultDirectories(){
        //Get user drive letter in case it's not C:
        char drive = System.getProperty("user.dir").charAt(0);
        
        switch(drive){
            //Check current drive
            default:
            for(int j = 0; j < DEFAULT_STEAM_DIR.length; j++){
                dataFolder = new File(drive + ":" + DEFAULT_STEAM_DIR[j] +
                    DEFAULT_STEAM_SUBDIR + DATA_FOLDER);
                if(!dataFolder.exists()){
                    System.out.println(NOT_FOUND);
                }else{
                    break;
                }
            }
            //If user drive letter is C: or Dark Souls was not
            //  installed in the current drive, check C:
            case 'C':
                for(int j = 0; j < DEFAULT_STEAM_DIR.length; j++){
                    dataFolder = new File("C:" + DEFAULT_STEAM_DIR[j] +
                        DEFAULT_STEAM_SUBDIR + DATA_FOLDER);
                    if(!dataFolder.exists()){
                        System.out.println(NOT_FOUND);
                    }else{
                        break;
                    }
                }
                break;
        }
        
        if(dataFolder != null && dataFolder.exists()){
            return;
        }else{
            dataFolder = null;
            setDSFStatus(2);
        }
    }
    
    public void checkForDSFix(){
        
        if(dataFolder != null && dataFolder.exists()){
            printConsole(CHECKING_FOR_DSF);

            //Check for DINPUT8.dll
            File dsfFile = new File("");
            int i;
            for(i = 0; i < DSF_FILES.length - 1; i++){
                if(i != 3 && i !=4){ //Ignore unnecessary files
                    dsfFile = new File(dataFolder.getPath() + "\\" + DSF_FILES[i]);
                    if(!dsfFile.exists()){
                        printConsole(DSF_FILES[i] + DSCUTIL_FILE_NOT_FOUND);
                        break;
                    }
                }
            }

            if(dsfFile.exists()){
                //DSFix is installed
                printConsole(DSF_FOUND);
                setDSFStatus(0);
            }else{
                if(i == 0){
                    //DSFix is not installed
                    printConsole(DSF_NOT_FOUND);
                    setDSFStatus(1);
                }else{
                    //DSFix is partially installed
                    printConsole(DSF_PARTIALLY_FOUND);
                    setDSFStatus(2);
                }
            }

            enableAndDisableElements();
        }else{
            setDSFStatus(2);
            checkForDS();
        }
        
    }
    
    public void checkForDSMFix(){
        
        printConsole(CHECKING_FOR_DSM);
        
        for(int i = 0; i < DSM_FILES.length - 1; i++){
            File dsmCheck = new File(dataFolder + "\\" + DSM_FILES[i]);
            if(!dsmCheck.exists()){
                setDSMStatus(1);
                printConsole(DSM_FILES[i] + DSCUTIL_FILE_NOT_FOUND);
                printConsole(DSM_NOT_FOUND);
                break;
            }else if(i == 2){
                setDSMStatus(0);
                printConsole(DSM_FOUND);
            }
        }
        
    }
    
    public void checkForDSPW(){
        
        printConsole(CHECKING_FOR_DSPW);
        
        for(int i = 0; i < DSPW_FILES.length; i++){
            if(i == 2){
                //Ignore readme file
                i++;
            }
            File dspwCheck = new File(dataFolder + "\\" + DSPW_FILES[i]);
            if(!dspwCheck.exists()){ 
                setDSPWStatus(1);
                printConsole(DSPW_FILES[i] + DSCUTIL_FILE_NOT_FOUND);
                printConsole(DSPW_NOT_FOUND);
                break;
            }else if(i == 6){
                setDSPWStatus(0);
                printConsole(DSPW_FOUND);
            }
        }
        
        enableAndDisableElements();
    }
    
    public void refreshUI(){
        
        //Check for data folder
        if(dataFolder == null){
            directoryField.pseudoClassStateChanged(INVALID_INPUT, true);
            directoryField.setText(NOT_FOUND);
            directoryButton.requestFocus();
        }else{
            directoryField.setText(dataFolder.getPath());
            directoryField.pseudoClassStateChanged(INVALID_INPUT, false);
        }
        
        //Check console status
        if(showConsoleBar || showConsoleWindow){
            toggleConsole.setText(TOGGLE_CONSOLE[1]);
        }else{
            toggleConsole.setText(TOGGLE_CONSOLE[0]);
        }
        
        //Find selected pane and refresh it
        if(primaryTabPane != null){
            switch(getCurrentTab()){
                case 0:
                    graphicsPane = new DSFGraphicsPane(this);
                    graphicsTab.setContent(graphicsPane);
                    break;
                case 1:
                    hudPane = new DSFHudPane(this);
                    hudTab.setContent(hudPane);
                    break;
                case 2:
                    wmPane = new DSFWindowMousePane(this);
                    windowMouseTab.setContent(wmPane);
                    break;
                case 3:
                    savesPane = new DSFSavesPane(this);
                    savesTab.setContent(savesPane);
                    break;
                case 4:
                    texPane = new DSFTexturesPane(this);
                    texturesTab.setContent(texPane);
                    break;
                case 5:
                    otherPane = new DSFOtherSettingsPane(this);
                    otherTab.setContent(otherPane);
                    break;
                case 6:
                    unsafePane = new DSFUnsafeSettingsPane(this);
                    unsafeTab.setContent(unsafePane);
                    break;
                case 7:
                    keysPane = new DSFKeybindsPane(this);
                    keysTab.setContent(keysPane);
                    break;
                case 8:
                    dspwPane = new DSPWPane(this);
                    dspwTab.setContent(dspwPane);
                    break;
                default:
                    break;
                
            }
        }
        
        enableAndDisableElements();
        
    }
    
    public void enableAndDisableElements(){
        
        //File menu
        if(config != null && dsfKeybinds != null){
            exportDSFIni.setDisable(false);
            exportDSFKeybindsIni.setDisable(false);
            exportDSF.setDisable(false);
        }else{
            exportDSFIni.setDisable(true);
            exportDSFKeybindsIni.setDisable(true);
            exportDSF.setDisable(true);
        }
        
        //Dark Souls menu
        if(dataFolder != null){
            openDataFolder.setDisable(false);
            File dsEXE = new File(dataFolder.toPath() + "\\" + DS_EXE);
            if(dsEXE.exists()){
                launchDS.setDisable(false);
                configureDS.setDisable(false);
            }else{
                launchDS.setDisable(true);
                configureDS.setDisable(true);
            }
        }else{
            launchDS.setDisable(true);
            configureDS.setDisable(true);
            openDataFolder.setDisable(true);
        }
        
        //DSFix menu
        switch(dsfStatus){
            case 0:
                if(config != null){
                    applyConfig.setDisable(false);
                    if(graphicsPane != null){
                        graphicsPane.applySettingsButton.setDisable(false);
                        hudPane.applySettingsButton.setDisable(false);
                        otherPane.applySettingsButton.setDisable(false);
                        savesPane.applySettingsButton.setDisable(false);
                        texPane.applySettingsButton.setDisable(false);
                        unsafePane.applySettingsButton.setDisable(false);
                        wmPane.applySettingsButton.setDisable(false);
                        keysPane.applySettingsButton.setDisable(false);
                    }
                    applyDSFKeybinds.setDisable(false);
                }else{
                    applyConfig.setDisable(true);
                    if(graphicsPane != null){
                        graphicsPane.applySettingsButton.setDisable(true);
                        hudPane.applySettingsButton.setDisable(true);
                        otherPane.applySettingsButton.setDisable(true);
                        savesPane.applySettingsButton.setDisable(true);
                        texPane.applySettingsButton.setDisable(true);
                        unsafePane.applySettingsButton.setDisable(true);
                        wmPane.applySettingsButton.setDisable(true);
                        keysPane.applySettingsButton.setDisable(true);
                    }
                    applyDSFKeybinds.setDisable(true);
                }
                installDSF.setText(REINSTALL_DSF);
                installDSF.setDisable(false);
                uninstallDSF.setDisable(false);
                recheckDSF.setDisable(false);
                if(texModsTab != null){
                    texModsTab.setDisable(false);
                }
                break;
            case 1:
                applyConfig.setDisable(true);
                if(graphicsPane != null){
                    graphicsPane.applySettingsButton.setDisable(true);
                    hudPane.applySettingsButton.setDisable(true);
                    otherPane.applySettingsButton.setDisable(true);
                    savesPane.applySettingsButton.setDisable(true);
                    texPane.applySettingsButton.setDisable(true);
                    unsafePane.applySettingsButton.setDisable(true);
                    wmPane.applySettingsButton.setDisable(true);
                    keysPane.applySettingsButton.setDisable(true);
                }
                applyDSFKeybinds.setDisable(true);
                installDSF.setDisable(false);
                installDSF.setText(INSTALL_DSF);
                uninstallDSF.setDisable(true);
                recheckDSF.setDisable(false);
                if(texModsTab != null){
                    texModsTab.setDisable(true);
                }
                break;
            case 2:
                applyConfig.setDisable(true);
                if(graphicsPane != null){
                    graphicsPane.applySettingsButton.setDisable(true);
                    hudPane.applySettingsButton.setDisable(true);
                    otherPane.applySettingsButton.setDisable(true);
                    savesPane.applySettingsButton.setDisable(true);
                    texPane.applySettingsButton.setDisable(true);
                    unsafePane.applySettingsButton.setDisable(true);
                    wmPane.applySettingsButton.setDisable(true);
                    keysPane.applySettingsButton.setDisable(true);
                }
                applyDSFKeybinds.setDisable(true);
                if(dataFolder != null){
                    installDSF.setDisable(false);
                    uninstallDSF.setDisable(false);
                    recheckDSF.setDisable(false);
                }else{
                    installDSF.setDisable(true);
                    uninstallDSF.setDisable(true);
                    recheckDSF.setDisable(true);
                }
                if(texModsTab != null){
                    texModsTab.setDisable(true);
                }
                installDSF.setText(INSTALL_DSF);
                break;
            default:
                break;
        }
        
        //DSMfix menu
        if(dsmStatus == 0){
            installDSM.setText(REINSTALL_DSM);
            installDSM.setDisable(false);
            uninstallDSM.setDisable(false);
            configureDSM.setDisable(false);
        }else{
            installDSM.setText(INSTALL_DSM);
            if(dsfStatus == 0){
                installDSM.setDisable(false);
            }else{
                installDSM.setDisable(true);
            }
            uninstallDSM.setDisable(true);
            configureDSM.setDisable(true);
        }
        
        //DS PvP Watchdog Menu
        if(dataFolder != null){
            installDSPW.setDisable(false);
            recheckDSPW.setDisable(false);
            if(dspwStatus == 0 || dspwStatus == 2){
                installDSPW.setText(REINSTALL_DSPW);
                uninstallDSPW.setDisable(false);
                applyDSPWConfig.setDisable(false);
                if(dspwTab != null){
                    dspwTab.setDisable(false);
                }
            }else if(dspwStatus == 1){
                installDSPW.setText(INSTALL_DSPW);
                uninstallDSPW.setDisable(true);
                applyDSPWConfig.setDisable(true);
                if(dspwTab != null){
                    dspwTab.setDisable(true);
                }
            }
        }else{
            installDSPW.setText(INSTALL_DSPW);
            applyDSPWConfig.setDisable(true);
            installDSPW.setDisable(true);
            uninstallDSPW.setDisable(true);
            recheckDSPW.setDisable(true);
            if(dspwTab != null){
                dspwTab.setDisable(true);
            }
        }
        
        //Dark Souls Connectivity Mod Menu
        if(dataFolder != null){
            launchDSCM.setDisable(false);
            File dsEXE = new File(dataFolder.toPath() + "\\" + DS_EXE);
            if(dsEXE.exists()){
                launchDSAndCM.setDisable(false);
            }else{
                launchDSAndCM.setDisable(true);
            }
        }else{
            launchDSCM.setDisable(true);
            launchDSAndCM.setDisable(true);
        }
        
        //Console bar
        if(showConsoleBar){
            consoleButton.setDisable(false);
        }else{
            consoleButton.setDisable(true);
        }
        
    }
    
    public void disableElementsForSleeping(){
        graphicsPane.applySettingsButton.setDisable(true);
        hudPane.applySettingsButton.setDisable(true);
        otherPane.applySettingsButton.setDisable(true);
        savesPane.applySettingsButton.setDisable(true);
        texPane.applySettingsButton.setDisable(true);
        unsafePane.applySettingsButton.setDisable(true);
        wmPane.applySettingsButton.setDisable(true);
        keysPane.applySettingsButton.setDisable(true);
        dspwPane.applySettingsButton.setDisable(true);
        dsMenu.setDisable(true);
        dsfMenu.setDisable(true);
        dsmMenu.setDisable(true);
        dspwMenu.setDisable(true);
        dscmMenu.setDisable(true);
    }
    
    public void enableElementsForSleeping(){
        graphicsPane.applySettingsButton.setDisable(false);
        hudPane.applySettingsButton.setDisable(false);
        otherPane.applySettingsButton.setDisable(false);
        savesPane.applySettingsButton.setDisable(false);
        texPane.applySettingsButton.setDisable(false);
        unsafePane.applySettingsButton.setDisable(false);
        wmPane.applySettingsButton.setDisable(false);
        keysPane.applySettingsButton.setDisable(false);
        dspwPane.applySettingsButton.setDisable(false);
        dsMenu.setDisable(false);
        dsfMenu.setDisable(false);
        dsmMenu.setDisable(false);
        dspwMenu.setDisable(false);
        dscmMenu.setDisable(false);
    }
    
    public void applyDSFConfig(){
        if(invalidDSFInputsExist()){
            AlertDialog aD = new AlertDialog(300.0, 80.0, DIALOG_TITLE_CFG_NOT_APPLIED,
                                              COULDNT_APPLY_CFG_ERR, DIALOG_BUTTON_TEXTS[0]);
        }else{
            graphicsPane.applySettingsButton.setDisable(true);
            hudPane.applySettingsButton.setDisable(true);
            otherPane.applySettingsButton.setDisable(true);
            savesPane.applySettingsButton.setDisable(true);
            texPane.applySettingsButton.setDisable(true);
            unsafePane.applySettingsButton.setDisable(true);
            wmPane.applySettingsButton.setDisable(true);
            config.writeSettingsToIniFile(dataFolder.getPath() + "\\" + DSF_FILES[1]);
            graphicsPane.applySettingsButton.setDisable(false);
            hudPane.applySettingsButton.setDisable(false);
            otherPane.applySettingsButton.setDisable(false);
            savesPane.applySettingsButton.setDisable(false);
            texPane.applySettingsButton.setDisable(false);
            unsafePane.applySettingsButton.setDisable(false);
            wmPane.applySettingsButton.setDisable(false);
        }
    }
    
    public void applyDSPWConfig(){
        if(dspwPane.hasInvalidInputs()){
            AlertDialog aD = new AlertDialog(300.0, 80.0, DIALOG_TITLE_CFG_NOT_APPLIED,
                                              COULDNT_APPLY_CFG_ERR, DIALOG_BUTTON_TEXTS[0]);
        }else{
            dspwPane.applySettingsButton.setDisable(true);
            dspwConfig.applySettings(dataFolder.getPath() + "\\" + DSPW_FILES[3]);
            dspwPane.applySettingsButton.setDisable(false);
        }
    }
    
    public void printConsole(String message){
        
        System.out.println(message);
        consoleText.setText(message);
        message += "\n";
        consoleLog += message;
        
        if(consoleWindow != null){
            consoleWindow.setMessage(consoleLog);
        }
    }
    
    //Getter/Accessor Methods
    public Stage getStage(){
        return primaryStage;
    }
    
    public int getCurrentTab(){
        return primaryTabPane.getSelectionModel().getSelectedIndex();
    }
    
    public File getDataFolder(){
        return this.dataFolder;
    }
    
    public int getDSFStatus(){
        return dsfStatus;
    }
    
    public int getDSPWStatus(){
        return dspwStatus;
    }
    
    public DSFConfiguration getConfig(){
        return config;
    }
    
    public DSFKeybindsConfiguration getDSFKeybinds(){
        return dsfKeybinds;
    }
    
    public DSPWConfiguration getDSPWConfig(){
        return dspwConfig;
    }
    
    public boolean invalidDSFInputsExist(){
        if(graphicsPane == null){
            return true;
        }else if(graphicsPane.hasInvalidInputs()){
            return true;
        }
        
        if(hudPane == null){
            return true;
        }else if(hudPane.hasInvalidInputs()){
            return true;
        }
        
        if(savesPane == null){
            return true;
        }else if(savesPane.hasInvalidInputs()){
            return true;
        }
        
        if(unsafePane == null){
            return true;
        }else if(unsafePane.hasInvalidInputs()){
            return true;
        }
        return false;
    }
    
    //Setter/Mutator Methods
    public void setDSFStatus(int newStatus){
        dsfStatus = newStatus;
        dsfStatusLabel.setText(DSF_STATUS[newStatus] + "         ");
        dsfStatusLabel.getStyleClass().clear();
        
        if(newStatus == 0){
            //DSFix is installed
            dsfStatusLabel.getStyleClass().addAll("label", "translate_y_4",
                                                  "green_text");
            checkForDSMFix();
        }else{
            //DSFix is not installed, or status is unknown
            dsfStatusLabel.getStyleClass().addAll("label", "translate_y_4",
                                                  "red_text");
            setDSMStatus(dsfStatus);
        }
        
    }
    
    public void setDSMStatus(int newStatus){
        dsmStatus = newStatus;
        dsmStatusLabel.setText(DSF_STATUS[newStatus] + "         ");
        dsmStatusLabel.getStyleClass().clear();
        
        if(newStatus == 0){
            //DSFix is installed
            dsmStatusLabel.getStyleClass().addAll("label", "translate_y_4",
                                                  "green_text");
        }else{
            //DSFix is not installed, or status is unknown
            dsmStatusLabel.getStyleClass().addAll("label", "translate_y_4",
                                                  "red_text");
        }
        
        refreshUI();
    }
    
    public void setDSPWStatus(int newStatus){
        dspwStatus = newStatus;
        dspwStatusLabel.setText(DSF_STATUS[newStatus] + "         ");
        dspwStatusLabel.getStyleClass().clear();
        
        if(newStatus == 0){
            //DSFix is installed
            dspwStatusLabel.getStyleClass().addAll("label", "translate_y_4",
                                                  "green_text");
        }else{
            //DSFix is not installed, or status is unknown
            dspwStatusLabel.getStyleClass().addAll("label", "translate_y_4",
                                                  "red_text");
        }
        
        refreshUI();
    }
    
    public void setDataFolder(String newPath){
        dataFolder = new File(newPath);
        checkForDSFix();
        checkForDSPW();
        refreshUI();
    }
    
    public void setSelectedTab(int index){
        primaryTabPane.getSelectionModel().select(index);
    }
    
    public void resetDSFConfigDefaults(){
        config = new DSFConfiguration(this, false);
        config.setWindowsResolution();
    }
    
    public void showConsoleBar(boolean show){
        showConsoleBar = show;
    }
    
    public void showConsoleWindow(boolean show){
        showConsoleWindow = show;
    }
}
