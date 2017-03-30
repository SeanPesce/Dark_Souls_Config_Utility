/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.view;

import static dscfgutil.DSCfgUtilConstants.APPLY_KEYBINDS;
import static dscfgutil.DSCfgUtilConstants.APPLY_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_RESTORE_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_RESET;
import static dscfgutil.DSCfgUtilConstants.DISABLED;
import static dscfgutil.DSCfgUtilConstants.DISABLE_ENABLE;
import static dscfgutil.DSCfgUtilConstants.DSF_FILES;
import static dscfgutil.DSCfgUtilConstants.DSF_KEYS;
import static dscfgutil.DSCfgUtilConstants.DSF_KEY_ACTION_NAMES;
import static dscfgutil.DSCfgUtilConstants.KEY_BINDINGS;
import static dscfgutil.DSCfgUtilConstants.RESTORE_DEFAULTS;
import static dscfgutil.DSCfgUtilConstants.SETTINGS;
import dscfgutil.configs.DSFKeybindsConfiguration;
import dscfgutil.dialog.ContinueDialog;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Sean Pesce
 */
class DSFKeybindsPane extends ScrollPane {
    
    //Main UI Components
    GridPane primaryPane;
    ColumnConstraints spacerColumn;
    ColumnConstraints primaryColumn;
    VBox primaryVBox;
    FlowPane titleBar;
    Label titleLabel;
    HBox restoreDefaultsBar;
    public Button applySettingsButton;
    Button restoreDefaultsButton;
    HBox spacerHBox;
    HBox bottomSpacerHBox;
    
    //Keybind Components
    GridPane keybindPane;
    ColumnConstraints keybindLeftColumn;
    ColumnConstraints keybindRightColumn;
    FlowPane keybindLeftPane[];
    FlowPane keybindRightPane[];
    ToggleGroup keybindChoice[];
    RadioButton keybindDisabled[];
    RadioButton keybindEnabled[];
    Label keybindLabel[];
    ComboBox<String> keybindPicker[];
    
    //Instance Variables
    DSCfgMainUI ui;
    DSFKeybindsConfiguration config;
    
    public DSFKeybindsPane(DSCfgMainUI initUI){
        ui = initUI;
        config = ui.getDSFKeybinds();
        initialize();
    }
    
    //Build the pane
    private void initialize(){
        
        //Basic layout
        this.setFitToWidth(true);
        
        spacerColumn = new ColumnConstraints();
        spacerColumn.setFillWidth(true);
        spacerColumn.setPercentWidth(5.0);
        primaryColumn = new ColumnConstraints();
        primaryColumn.setFillWidth(true);
        primaryColumn.setPercentWidth(95.0);
        primaryPane = new GridPane();
        //primaryPane.getColumnConstraints().addAll(spacerColumn, primaryColumn);
        primaryPane.getColumnConstraints().add(primaryColumn);
        primaryVBox = new VBox();
        primaryVBox.getStyleClass().add("spacing_15");
        primaryPane.add(primaryVBox, 0, 0);
        titleLabel = new Label(KEY_BINDINGS.toUpperCase() + " " + SETTINGS.toUpperCase());
        titleLabel.getStyleClass().add("settings_title");
        titleBar = new FlowPane();
        titleBar.setAlignment(Pos.CENTER);
        titleBar.getChildren().add(titleLabel);
        restoreDefaultsBar = new HBox();
        restoreDefaultsBar.setAlignment(Pos.CENTER);
        restoreDefaultsBar.setSpacing(5.0);
        applySettingsButton = new Button(APPLY_KEYBINDS);
        restoreDefaultsButton = new Button(RESTORE_DEFAULTS);
        applySettingsButton.getStyleClass().add("translate_y_4");
        restoreDefaultsButton.getStyleClass().add("translate_y_4");
        restoreDefaultsBar.getChildren().addAll(applySettingsButton, restoreDefaultsButton);
        spacerHBox = new HBox();
        spacerHBox.setMinHeight(10.0);
        bottomSpacerHBox = new HBox();
        bottomSpacerHBox.setMinHeight(10.0);
        primaryVBox.getChildren().addAll(titleBar, restoreDefaultsBar, spacerHBox);
        
        /////////////////////KEYBIND PANES/////////////////////
        keybindPane = new GridPane();
        keybindPane.setVgap(15);
        keybindLeftColumn = new ColumnConstraints();
        keybindLeftColumn.setFillWidth(true);
        keybindLeftColumn.setPercentWidth(49.0);
        keybindLeftColumn.setHalignment(HPos.LEFT);
        keybindRightColumn = new ColumnConstraints();
        keybindRightColumn.setFillWidth(true);
        keybindRightColumn.setPercentWidth(22.0);
        keybindRightColumn.setHalignment(HPos.RIGHT);
        keybindPane.getColumnConstraints().addAll(keybindLeftColumn, keybindRightColumn);
        keybindLeftPane = new FlowPane[18];
        keybindRightPane = new FlowPane[18];
        keybindChoice = new ToggleGroup[18];
        keybindDisabled = new RadioButton[18];
        keybindEnabled = new RadioButton[18];
        keybindLabel = new Label[18];
        keybindPicker = new ComboBox[18];
        for(int i = 0; i < keybindChoice.length; i++){
            keybindLeftPane[i] = new FlowPane();
            keybindLeftPane[i].getStyleClass().add("keybinds_pane");
            keybindRightPane[i] = new FlowPane();
            keybindRightPane[i].getStyleClass().add("keybinds_pane");
            keybindChoice[i] = new ToggleGroup();
            keybindDisabled[i] = new RadioButton(DISABLE_ENABLE[0] + "    ");
            keybindDisabled[i].setToggleGroup(keybindChoice[i]);
            keybindEnabled[i] = new RadioButton(DISABLE_ENABLE[1]);
            keybindEnabled[i].setToggleGroup(keybindChoice[i]);
            keybindLabel[i] = new Label(DSF_KEY_ACTION_NAMES[i] + ":   ");
            keybindLabel[i].getStyleClass().add("bold_text");
            keybindPicker[i] = new ComboBox(FXCollections.observableArrayList(DSF_KEYS));
            keybindLeftPane[i].getChildren().addAll(keybindDisabled[i], keybindEnabled[i]);
            keybindRightPane[i].getChildren().addAll(keybindLabel[i], keybindPicker[i]);
            keybindPane.add(keybindLeftPane[i], 1, i);
            keybindPane.add(keybindRightPane[i], 0, i);
            if(!config.getBinds().get(i).toString().equals(DISABLED)){
                keybindPicker[i].setValue(config.getBinds().get(i).toString());
                keybindEnabled[i].setSelected(true);
            }else{
                keybindPicker[i].setDisable(true);
                keybindDisabled[i].setSelected(true);
            }
        }
        
        primaryVBox.getChildren().addAll(keybindPane, bottomSpacerHBox);
        initializeEventHandlers();
        
        this.setContent(primaryPane);
    }
    
    private void initializeEventHandlers(){
        
        applySettingsButton.setOnAction(e -> {
            applySettingsButton.setDisable(true);
            ui.dsfKeybinds.writeSettingsToIniFile(ui.dataFolder.getPath() + "\\" + DSF_FILES[2]);
            applySettingsButton.setDisable(false);
        });
        
        restoreDefaultsButton.setOnAction(e -> {
           ContinueDialog cD = new ContinueDialog(300.0, 80.0, DIALOG_TITLE_RESET,
                                            DIALOG_MSG_RESTORE_SETTINGS,
                                            DIALOG_BUTTON_TEXTS[2],
                                            DIALOG_BUTTON_TEXTS[1]);
           
           if(cD.show()){
               config.restoreDefaultKeybinds();
               ui.refreshUI();
           }
        });
        
        for(int i = 0; i < keybindChoice.length; i++){
            final int ii = i;
            
            keybindEnabled[i].setOnAction(e -> {
                
                keybindPicker[ii].setDisable(false);
            });
            
            keybindDisabled[i].setOnAction(e -> {
                keybindPicker[ii].setDisable(true);
                keybindPicker[ii].setValue("");
                config.getBinds().get(ii).replace(0, config.getBinds().get(ii).length(), DISABLED);
            });
            
            keybindPicker[i].setOnAction(e -> {
                config.getBinds().get(ii).replace(0, config.getBinds().get(ii).length(), keybindPicker[ii].getValue());
            });
        }
    }
}
