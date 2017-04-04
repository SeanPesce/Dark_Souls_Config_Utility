/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.view;

import static dscfgutil.DSCfgUtilConstants.ADAPTEROVERRIDE;
import static dscfgutil.DSCfgUtilConstants.ADAPTER_OPTIONS;
import static dscfgutil.DSCfgUtilConstants.APPLY_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.CANT_CHAIN_DLL_WITH_DEFAULT;
import static dscfgutil.DSCfgUtilConstants.CANT_CHAIN_DLL_WITH_SELF;
import static dscfgutil.DSCfgUtilConstants.D3D_OR_TT;
import static dscfgutil.DSCfgUtilConstants.D3D_OVERRIDE_LABEL;
import static dscfgutil.DSCfgUtilConstants.DATA_FOLDER;
import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_RESTORE_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_DLL;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_RESET;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_SCREENSHOTS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_WRONG_FOLDER;
import static dscfgutil.DSCfgUtilConstants.DLL_CHAIN_LABEL;
import static dscfgutil.DSCfgUtilConstants.DLL_CHAIN_TOOLTIP;
import static dscfgutil.DSCfgUtilConstants.DLL_CHAIN_TT;
import static dscfgutil.DSCfgUtilConstants.DLL_EXT_FILTER;
import static dscfgutil.DSCfgUtilConstants.DLL_MUST_BE_IN_DATA;
import static dscfgutil.DSCfgUtilConstants.DSF_FILES;
import static dscfgutil.DSCfgUtilConstants.DSM_CHAIN_BT;
import static dscfgutil.DSCfgUtilConstants.DSM_FILES;
import static dscfgutil.DSCfgUtilConstants.DS_DEFAULT_DLLS;
import static dscfgutil.DSCfgUtilConstants.FOLDER;
import static dscfgutil.DSCfgUtilConstants.INVALID_DLL;
import static dscfgutil.DSCfgUtilConstants.LANGUAGES;
import static dscfgutil.DSCfgUtilConstants.LANGUAGE_LABEL;
import static dscfgutil.DSCfgUtilConstants.LANGUAGE_OPTIONS;
import static dscfgutil.DSCfgUtilConstants.LANGUAGE_TT;
import static dscfgutil.DSCfgUtilConstants.LANGUAGE_WINDOWS_XP;
import static dscfgutil.DSCfgUtilConstants.LOGLEVEL;
import static dscfgutil.DSCfgUtilConstants.LOG_LEVEL_LABEL;
import static dscfgutil.DSCfgUtilConstants.LOG_LEVEL_TT;
import static dscfgutil.DSCfgUtilConstants.NONE;
import static dscfgutil.DSCfgUtilConstants.NO_CHAIN_BT;
import static dscfgutil.DSCfgUtilConstants.OTHER_OPS;
import static dscfgutil.DSCfgUtilConstants.RESTORE_DEFAULTS;
import static dscfgutil.DSCfgUtilConstants.SETTINGS;
import static dscfgutil.DSCfgUtilConstants.SKIPINTRO;
import static dscfgutil.DSCfgUtilConstants.SKIP_INTRO;
import static dscfgutil.DSCfgUtilConstants.SKIP_INTROS_TT;
import static dscfgutil.DSCfgUtilConstants.SS_DIRECTORY;
import static dscfgutil.DSCfgUtilConstants.SS_DIR_BT_TOOLTIP;
import static dscfgutil.DSCfgUtilConstants.USE_BASE_SS_DIR;
import static dscfgutil.DSCfgUtilConstants.USE_BASE_SS_DIR_TT;
import static dscfgutil.DSCfgUtilConstants.WINDOWS_XP_LANGUAGE_DISABLED;
import dscfgutil.configs.DSFConfiguration;
import dscfgutil.dialog.AlertDialog;
import dscfgutil.dialog.ContinueDialog;
import java.io.File;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author Sean Pesce
 */
class DSFOtherSettingsPane extends ScrollPane {
    
    //Main UI Components
    GridPane primaryPane;
    ColumnConstraints spacerColumn;
    ColumnConstraints primaryColumn;
    VBox primaryVBox;
    HBox titleBar;
    Label titleLabel;
    HBox restoreDefaultsBar;
    public Button applySettingsButton;
    Button restoreDefaultsButton;
    HBox spacerHBox;
    HBox bottomSpacerHBox;
    
    //Settings components
    FlowPane skipIntroPane;
    Label skipIntroLabel;
    ComboBox<String> skipIntroPicker;
    //
    FlowPane screenshotDirPane;
    Label screenshotDirLabel;
    TextField screenshotDirField;
    Button screenshotDirButton;
    Button useBaseDirButton;
    //
    FlowPane languagePane;
    Label languageLabel;
    ComboBox<String> languagePicker;
    //
    FlowPane dllChainPane;
    Label dllChainLabel;
    TextField dllChainField;
    Button dllChainButton;
    Button dsmButton;
    Button noChainButton;
    //
    FlowPane d3dOverridePane;
    Label d3dOverrideLabel;
    ComboBox<String> d3dOverridePicker;
    //
    FlowPane logLevelPane;
    Label logLevelLabel;
    ComboBox<String> logLevelPicker;
    
    //Instance Variables
    DSCfgMainUI ui;
    DSFConfiguration config;
    
    public DSFOtherSettingsPane(DSCfgMainUI initUI){
        ui = initUI;
        config = ui.getConfig();
        initialize();
    }
    
    //Build the pane
    private void initialize(){
        
        //Basic layout
        this.setFitToWidth(true);
        
        spacerColumn = new ColumnConstraints();
        spacerColumn.setFillWidth(true);
        spacerColumn.setPercentWidth(3.0);
        primaryColumn = new ColumnConstraints();
        primaryColumn.setFillWidth(true);
        primaryColumn.setPercentWidth(95.0);
        primaryPane = new GridPane();
        primaryPane.getColumnConstraints().addAll(spacerColumn, primaryColumn);
        primaryVBox = new VBox();
        primaryVBox.getStyleClass().add("spacing_15");
        primaryPane.add(primaryVBox, 1, 0);
        titleLabel = new Label(OTHER_OPS.toUpperCase() + " " + SETTINGS.toUpperCase());
        titleLabel.getStyleClass().add("settings_title");
        titleBar = new HBox();
        titleBar.setAlignment(Pos.CENTER);
        titleBar.getChildren().add(titleLabel);
        restoreDefaultsBar = new HBox();
        restoreDefaultsBar.setAlignment(Pos.CENTER);
        restoreDefaultsBar.setSpacing(5.0);
        applySettingsButton = new Button(APPLY_SETTINGS);
        restoreDefaultsButton = new Button(RESTORE_DEFAULTS);
        applySettingsButton.getStyleClass().add("translate_y_4");
        restoreDefaultsButton.getStyleClass().add("translate_y_4");
        restoreDefaultsBar.getChildren().addAll(applySettingsButton, restoreDefaultsButton);
        spacerHBox = new HBox();
        spacerHBox.setMinHeight(10.0);
        bottomSpacerHBox = new HBox();
        bottomSpacerHBox.setMinHeight(10.0);
        
        /////////////////////SETTINGS PANES/////////////////////
        //
        //
        //Skip Intro Logos
        skipIntroPane = new FlowPane();
        skipIntroPane.getStyleClass().add("settings_pane");
        skipIntroLabel = new Label(SKIP_INTRO + "  ");
        skipIntroLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        skipIntroLabel.setTooltip(new Tooltip(SKIP_INTROS_TT));
        skipIntroPicker = new ComboBox(FXCollections.observableArrayList(SKIPINTRO));
        if(config.skipIntro.get() == 0){
            skipIntroPicker.setValue(skipIntroPicker.getItems().get(0));
        }else{
            skipIntroPicker.setValue(skipIntroPicker.getItems().get(1));
        }
        skipIntroPane.getChildren().addAll(skipIntroLabel, skipIntroPicker);
        //
        //Screenshot directory
        screenshotDirPane = new FlowPane();
        screenshotDirPane.getStyleClass().add("settings_pane");
        screenshotDirLabel = new Label(SS_DIRECTORY + "  ");
        screenshotDirLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        screenshotDirField = new TextField();
        screenshotDirField.setEditable(false);
        screenshotDirField.setPrefWidth((ui.getStage().getWidth() * 0.95) - (ui.getStage().getWidth() * 0.05) - 400.0);
        useBaseDirButton = new Button(USE_BASE_SS_DIR);
        useBaseDirButton.setTooltip(new Tooltip(USE_BASE_SS_DIR_TT));
        if(config.screenshotDir.toString().equals(".")){
            if(ui.getDataFolder() != null){
                screenshotDirField.setText(ui.dataFolder.getPath());
            }else{
                screenshotDirField.setText(DATA_FOLDER.substring(1) + " " + FOLDER);
            }
            useBaseDirButton.setDisable(true);
        }else{
            screenshotDirField.setText(config.screenshotDir.toString());
        }
        screenshotDirButton = new Button("...");
        screenshotDirButton.setTooltip(new Tooltip(SS_DIR_BT_TOOLTIP));
        screenshotDirPane.getChildren().addAll(screenshotDirLabel, screenshotDirField,
                                                screenshotDirButton, useBaseDirButton);
        //
        //Override Language
        languagePane = new FlowPane();
        languagePane.getStyleClass().add("settings_pane");
        languageLabel = new Label(LANGUAGE_LABEL + "  ");
        languageLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        languageLabel.setTooltip(new Tooltip(LANGUAGE_TT));
        languagePicker = new ComboBox(FXCollections.observableArrayList(LANGUAGES));
        if(System.getProperty("os.name").equals("Windows XP")){
            languagePicker.setDisable(true);
            ui.printConsole(WINDOWS_XP_LANGUAGE_DISABLED);
            languageLabel.setTooltip(new Tooltip(LANGUAGE_WINDOWS_XP));
            languagePicker.setTooltip(new Tooltip(LANGUAGE_WINDOWS_XP));
        }
        for(int i = 0; i < LANGUAGE_OPTIONS.length; i++){
            if(config.overrideLanguage.toString().equals(LANGUAGE_OPTIONS[i])){
                languagePicker.setValue(LANGUAGES[i]);
            }
        }
        languagePane.getChildren().addAll(languageLabel, languagePicker);
        //
        //DLL Chaining
        dllChainPane = new FlowPane();
        dllChainPane.getStyleClass().add("settings_pane");
        dllChainLabel = new Label(DLL_CHAIN_LABEL + "  ");
        dllChainLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        dllChainLabel.setTooltip(new Tooltip(DLL_CHAIN_TT));
        dllChainField = new TextField();
        dllChainField.setEditable(false);
        dllChainButton = new Button("...");
        dllChainButton.setTooltip(new Tooltip(DLL_CHAIN_TOOLTIP));
        dsmButton = new Button(DSM_CHAIN_BT);
        noChainButton = new Button(NO_CHAIN_BT);
        if(ui.getDataFolder() != null){
            File dsmCheck = new File(ui.getDataFolder().getPath() + "\\" + DSM_FILES[0]);
            if(!dsmCheck.exists()){
                dsmButton.setDisable(true);
            }
            dsmCheck = new File(ui.getDataFolder().getPath() + "\\" + config.dinput8dllWrapper);
            if(config.dinput8dllWrapper.toString().equals(dsmCheck.getName()) &&
                    !dsmCheck.exists()){
                config.dinput8dllWrapper.replace(0, config.dinput8dllWrapper.length(), NONE);
            }
            if(config.dinput8dllWrapper.toString().equals(NONE)){
                dllChainField.setStyle("-fx-text-fill: gray;");
                noChainButton.setDisable(true);
            }else if(config.dinput8dllWrapper.toString().equals(DSM_FILES[0])){
                dllChainField.setText(DSM_FILES[0]);
                dsmButton.setDisable(true);
            }
        }else{
            dllChainField.setText(config.dinput8dllWrapper.toString());
            dllChainField.setDisable(true);
            dllChainButton.setDisable(true);
            dsmButton.setDisable(true);
            if(!config.dinput8dllWrapper.toString().equals(NONE)){
                noChainButton.setDisable(false);
            }else{
                noChainButton.setDisable(true);
            }
        }
        dllChainField.setText(config.dinput8dllWrapper.toString());
        dllChainPane.getChildren().addAll(dllChainLabel, dllChainField,
                                          dllChainButton, dsmButton, noChainButton);
        //
        //D3D Adapter Override
        d3dOverridePane = new FlowPane();
        d3dOverridePane.getStyleClass().add("settings_pane");
        d3dOverrideLabel = new Label(D3D_OVERRIDE_LABEL + "  ");
        d3dOverrideLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        d3dOverrideLabel.setTooltip(new Tooltip(D3D_OR_TT));
        d3dOverridePicker = new ComboBox(FXCollections.observableArrayList(ADAPTEROVERRIDE));
        if(config.d3dAdapterOverride.toString().equals("-1")){
            d3dOverridePicker.setValue(d3dOverridePicker.getItems().get(0));
        }else{
            d3dOverridePicker.setValue(d3dOverridePicker.getItems().get(1));
        }
        d3dOverridePane.getChildren().addAll(d3dOverrideLabel, d3dOverridePicker);
        //
        //Log Level
        logLevelPane = new FlowPane();
        logLevelPane.getStyleClass().add("settings_pane");
        logLevelLabel = new Label(LOG_LEVEL_LABEL + "  ");
        logLevelLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        logLevelLabel.setTooltip(new Tooltip(LOG_LEVEL_TT));
        logLevelPicker = new ComboBox();
        for(int i = 0; i < LOGLEVEL.length; i++){
            logLevelPicker.getItems().add(i + "");
            if(config.logLevel.get() == i){
                logLevelPicker.setValue(i + "");
            }
        }
        logLevelPane.getChildren().addAll(logLevelLabel, logLevelPicker);
        
        primaryVBox.getChildren().addAll(titleBar, restoreDefaultsBar, spacerHBox,
                                        skipIntroPane, screenshotDirPane,
                                        languagePane, dllChainPane,
                                        d3dOverridePane, logLevelPane,
                                        bottomSpacerHBox);
        
        initializeEventHandlers();
        
        this.setContent(primaryPane);
    }
    
    private void initializeEventHandlers(){
        
        applySettingsButton.setOnAction(e -> {
            ui.applyDSFConfig();
        });
        
        restoreDefaultsButton.setOnAction(e -> {
            ContinueDialog cD = new ContinueDialog(300.0, 80.0, DIALOG_TITLE_RESET,
                                            DIALOG_MSG_RESTORE_SETTINGS,
                                            DIALOG_BUTTON_TEXTS[2],
                                            DIALOG_BUTTON_TEXTS[1]);
           if(cD.show()){
               config.restoreDefaultOtherOptions(); 
               ui.refreshUI();
           }
        });
        
        skipIntroPicker.setOnAction(e -> {
            config.skipIntro.set(skipIntroPicker.getSelectionModel().getSelectedIndex());
        });
        
        screenshotDirButton.setOnAction(e -> {
            DirectoryChooser dirChooser = new DirectoryChooser();
            dirChooser.setTitle(DIALOG_TITLE_SCREENSHOTS);
            if(ui.getDataFolder() != null && config.screenshotDir.toString().equals(".")){
                dirChooser.setInitialDirectory(ui.getDataFolder());
            }
            
            File ssDir = dirChooser.showDialog(ui.getStage());
            if(ssDir != null){
                if(ui.getDataFolder() != null && ssDir.equals(ui.getDataFolder())){
                    config.screenshotDir.replace(0, config.screenshotDir.length(), ".");
                    useBaseDirButton.setDisable(true);
                }else{
                    config.screenshotDir.replace(0, config.screenshotDir.length(), ssDir.getPath());
                    useBaseDirButton.setDisable(false);
                }
                screenshotDirField.setText(ssDir.getPath());
            }
        });
        
        screenshotDirField.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2){
                    DirectoryChooser dirChooser = new DirectoryChooser();
                    dirChooser.setTitle(DIALOG_TITLE_SCREENSHOTS);
                    if(ui.getDataFolder() != null && config.screenshotDir.toString().equals(".")){
                        dirChooser.setInitialDirectory(ui.getDataFolder());
                    }

                    File ssDir = dirChooser.showDialog(ui.getStage());
                    if(ssDir != null){
                        if(ui.getDataFolder() != null && ssDir.equals(ui.getDataFolder())){
                            config.screenshotDir.replace(0, config.screenshotDir.length(), ".");
                            useBaseDirButton.setDisable(true);
                        }else{
                            config.screenshotDir.replace(0, config.screenshotDir.length(), ssDir.getPath());
                            useBaseDirButton.setDisable(false);
                        }
                        screenshotDirField.setText(ssDir.getPath());
                    }
                }
            }
        });
        
        useBaseDirButton.setOnAction(e -> {
            config.screenshotDir.replace(0, config.screenshotDir.length(), ".");
            if(ui.getDataFolder() != null){
                screenshotDirField.setText(ui.getDataFolder().getPath());
            }else{
                screenshotDirField.setText(DATA_FOLDER.substring(1) + " " + FOLDER);
            }
            useBaseDirButton.setDisable(true);
            screenshotDirButton.requestFocus();
        });
        
        languagePicker.setOnAction(e -> {
            for(int i = 0; i < LANGUAGES.length; i++){
                if(languagePicker.getValue().equals(LANGUAGES[i])){
                    config.overrideLanguage.replace(0, config.overrideLanguage.length(), LANGUAGE_OPTIONS[i]);
                }
            }
        });
        
        dllChainButton.setOnAction(e -> {
            FileChooser dllChooser = new FileChooser();
            dllChooser.setTitle(DIALOG_TITLE_DLL);
            if(ui.getDataFolder() != null){
                dllChooser.setInitialDirectory(ui.getDataFolder());
            }
            ExtensionFilter dllFilter = new ExtensionFilter(DLL_EXT_FILTER[0], DLL_EXT_FILTER[1]);
            dllChooser.getExtensionFilters().add(dllFilter);
            
            File dll = dllChooser.showOpenDialog(ui.getStage());
            
            if(dll != null && ui.getDataFolder() != null){
                File checkDLL = new File(ui.getDataFolder() + "\\" + dll.getName());
                if(!checkDLL.exists()){
                    AlertDialog aD = new AlertDialog(300.0, 80.0, DIALOG_TITLE_WRONG_FOLDER,
                                                    DLL_MUST_BE_IN_DATA, DIALOG_BUTTON_TEXTS[0]);
                }else{
                    if(dll.getName().equals(DSM_FILES[0])){
                        dsmButton.setDisable(true);
                        config.dinput8dllWrapper.replace(0, config.dinput8dllWrapper.length(), dll.getName());
                        dllChainField.setText(dll.getName());
                        dllChainField.setStyle("-fx-text-fill: black;");
                        noChainButton.setDisable(false);
                    }else if(dll.getName().equals(DSF_FILES[0])){
                        AlertDialog aD = new AlertDialog(300.0, 80.0, INVALID_DLL,
                                                    CANT_CHAIN_DLL_WITH_SELF,
                                                        DIALOG_BUTTON_TEXTS[0]);
                    }else if(dll.getName().equals(DS_DEFAULT_DLLS[0]) ||
                            dll.getName().equals(DS_DEFAULT_DLLS[1]) ||
                            dll.getName().equals(DS_DEFAULT_DLLS[2])){
                        AlertDialog aD = new AlertDialog(300.0, 80.0, INVALID_DLL,
                                                    CANT_CHAIN_DLL_WITH_DEFAULT,
                                                        DIALOG_BUTTON_TEXTS[0]);
                    }else{
                        config.dinput8dllWrapper.replace(0, config.dinput8dllWrapper.length(), dll.getName());
                        dllChainField.setText(dll.getName());
                        dllChainField.setStyle("-fx-text-fill: black;");
                        noChainButton.setDisable(false);
                        File checkDSM = new File(ui.getDataFolder().getPath() + "\\" + DSM_FILES[0]);
                        if(checkDSM.exists()){
                            dsmButton.setDisable(false);
                        }else{
                            dsmButton.setDisable(true);
                        }
                    }
                }
            }
        });
        
        dllChainField.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2){
                    FileChooser dllChooser = new FileChooser();
                    dllChooser.setTitle(DIALOG_TITLE_DLL);
                    if(ui.getDataFolder() != null){
                        dllChooser.setInitialDirectory(ui.getDataFolder());
                    }
                    ExtensionFilter dllFilter = new ExtensionFilter(DLL_EXT_FILTER[0], DLL_EXT_FILTER[1]);
                    dllChooser.getExtensionFilters().add(dllFilter);

                    File dll = dllChooser.showOpenDialog(ui.getStage());

                    if(dll != null && ui.getDataFolder() != null){
                        File checkDLL = new File(ui.getDataFolder() + "\\" + dll.getName());
                        if(!checkDLL.exists()){
                            AlertDialog aD = new AlertDialog(300.0, 80.0, DIALOG_TITLE_WRONG_FOLDER,
                                                            DLL_MUST_BE_IN_DATA, DIALOG_BUTTON_TEXTS[0]);
                        }else{
                            if(dll.getName().equals(DSM_FILES[0])){
                                dsmButton.setDisable(true);
                                config.dinput8dllWrapper.replace(0, config.dinput8dllWrapper.length(), dll.getName());
                                dllChainField.setText(dll.getName());
                                dllChainField.setStyle("-fx-text-fill: black;");
                                noChainButton.setDisable(false);
                            }else if(dll.getName().equals(DSF_FILES[0])){
                                AlertDialog aD = new AlertDialog(300.0, 80.0, INVALID_DLL,
                                                            CANT_CHAIN_DLL_WITH_SELF,
                                                                DIALOG_BUTTON_TEXTS[0]);
                            }else if(dll.getName().equals(DS_DEFAULT_DLLS[0]) ||
                                    dll.getName().equals(DS_DEFAULT_DLLS[1]) ||
                                    dll.getName().equals(DS_DEFAULT_DLLS[2])){
                                AlertDialog aD = new AlertDialog(300.0, 80.0, INVALID_DLL,
                                                            CANT_CHAIN_DLL_WITH_DEFAULT,
                                                                DIALOG_BUTTON_TEXTS[0]);
                            }else{
                                config.dinput8dllWrapper.replace(0, config.dinput8dllWrapper.length(), dll.getName());
                                dllChainField.setText(dll.getName());
                                dllChainField.setStyle("-fx-text-fill: black;");
                                noChainButton.setDisable(false);
                                File checkDSM = new File(ui.getDataFolder().getPath() + "\\" + DSM_FILES[0]);
                                if(checkDSM.exists()){
                                    dsmButton.setDisable(false);
                                }else{
                                    dsmButton.setDisable(true);
                                }
                            }
                        }
                    }
                }
            }
        });
        
        dsmButton.setOnAction(e -> {
           config.dinput8dllWrapper.replace(0, config.dinput8dllWrapper.length(), DSM_FILES[0]);
           dllChainField.setText(DSM_FILES[0]);
           dllChainField.setStyle("-fx-text-fill: black;");
           dsmButton.setDisable(true);
           noChainButton.setDisable(false);
        });
        
        noChainButton.setOnAction(e -> {
            config.dinput8dllWrapper.replace(0, config.dinput8dllWrapper.length(), NONE);
            dllChainField.setText(NONE);
            dllChainField.setStyle("-fx-text-fill: gray;");
            if(ui.getDataFolder().exists()){
                File checkDSM = new File(ui.getDataFolder().getPath() + "\\" + DSM_FILES[0]);
                if(checkDSM.exists()){
                    dsmButton.setDisable(false);
                }else{
                    dsmButton.setDisable(true);
                }
            }
            noChainButton.setDisable(true);
            dllChainButton.requestFocus();
        });
        
        d3dOverridePicker.setOnAction(e -> {
            if(d3dOverridePicker.getSelectionModel().getSelectedIndex() == 0){
                config.d3dAdapterOverride.replace(0, config.d3dAdapterOverride.length(), ADAPTER_OPTIONS[0]);
            }else{
                config.d3dAdapterOverride.replace(0, config.d3dAdapterOverride.length(), ADAPTER_OPTIONS[1]);
            }
        });
        
        logLevelPicker.setOnAction(e -> {
            config.logLevel.set(logLevelPicker.getSelectionModel().getSelectedIndex());
        });
        
        ui.getStage().widthProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldWidth, Number newWidth) {
                    screenshotDirField.setPrefWidth((newWidth.doubleValue() * 0.95) - (newWidth.doubleValue() * 0.05) - 400.0);
                }
            });
    }
}
