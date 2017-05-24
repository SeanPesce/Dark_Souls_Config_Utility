/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.view;

import static dscfgutil.DSCfgUtilConstants.APPLY_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.BOTTOM_LEFT_HUD_OP_LABEL;
import static dscfgutil.DSCfgUtilConstants.BOTTOM_LEFT_HUD_TT;
import static dscfgutil.DSCfgUtilConstants.BOTTOM_RIGHT_HUD_OP_LABEL;
import static dscfgutil.DSCfgUtilConstants.BOTTOM_RIGHT_HUD_TT;
import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_RESTORE_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_RESET;
import static dscfgutil.DSCfgUtilConstants.DISABLE_ENABLE;
import static dscfgutil.DSCfgUtilConstants.HUD;
import static dscfgutil.DSCfgUtilConstants.HUD_MODS_LABEL;
import static dscfgutil.DSCfgUtilConstants.HUD_MODS_TT;
import static dscfgutil.DSCfgUtilConstants.HUD_OPACITIES_LABEL;
import static dscfgutil.DSCfgUtilConstants.HUD_OPS_TT;
import static dscfgutil.DSCfgUtilConstants.HUD_SCALE_LABEL;
import static dscfgutil.DSCfgUtilConstants.HUD_SCALE_TT;
import static dscfgutil.DSCfgUtilConstants.INPUT_TOO_LARGE;
import static dscfgutil.DSCfgUtilConstants.INVALID_DOUBLE_0_1;
import static dscfgutil.DSCfgUtilConstants.INVALID_INPUT;
import static dscfgutil.DSCfgUtilConstants.MINIMAL_HUD_LABEL;
import static dscfgutil.DSCfgUtilConstants.MIN_HUD_TT;
import static dscfgutil.DSCfgUtilConstants.RESTORE_DEFAULTS;
import static dscfgutil.DSCfgUtilConstants.SETTINGS;
import static dscfgutil.DSCfgUtilConstants.TOP_LEFT_HUD_OP_LABEL;
import static dscfgutil.DSCfgUtilConstants.TOP_LEFT_HUD_TT;
import dscfgutil.configs.DSFConfiguration;
import dscfgutil.dialog.ContinueDialog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author Sean Pesce
 */
class DSFHudPane extends ScrollPane {
    
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
    //
    FlowPane hudModsPane;
    Label hudModsLabel;
    ComboBox<String> hudModsPicker;
    //
    FlowPane minimalHUDPane;
    Label minimalHUDLabel;
    ComboBox<String> minimalHUDPicker;
    //
    FlowPane hudScalePane;
    Label hudScaleLabel;
    TextField hudScaleField;
    //
    FlowPane hudOpacitiesPane;
    Label hudOpacitiesLabel;
    //
    FlowPane topLeftHUDOpPane;
    Label topLeftHUDOpLabel;
    TextField topLeftHUDOpField;
    //
    FlowPane bottomLeftHUDOpPane;
    Label bottomLeftHUDOpLabel;
    TextField bottomLeftHUDOpField;
    //
    FlowPane bottomRightHUDOpPane;
    Label bottomRightHUDOpLabel;
    TextField bottomRightHUDOpField;
    //
    
    //Instance Variables
    DSCfgMainUI ui;
    DSFConfiguration config;
    DecimalFormat decimalFormat = new DecimalFormat("#.##"); 
    
    public DSFHudPane(DSCfgMainUI initUI){
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
        titleLabel = new Label(HUD.toUpperCase() + " " + SETTINGS.toUpperCase());
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
        //Toggle HUD Modifications
        hudModsPane = new FlowPane();
        hudModsPane.getStyleClass().add("settings_pane");
        hudModsLabel = new Label(HUD_MODS_LABEL + "  ");
        hudModsLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        hudModsLabel.setTooltip(new Tooltip(HUD_MODS_TT));
        hudModsPicker = new ComboBox(FXCollections.observableArrayList(DISABLE_ENABLE));
        if(config.enableHudMod.get() == 0){
            hudModsPicker.setValue(hudModsPicker.getItems().get(0));
        }else{
            hudModsPicker.setValue(hudModsPicker.getItems().get(1));
        }
        hudModsPane.getChildren().addAll(hudModsLabel, hudModsPicker);
        //
        //Minimal HUD
        minimalHUDPane = new FlowPane();
        minimalHUDPane.getStyleClass().add("settings_pane");
        minimalHUDLabel = new Label(MINIMAL_HUD_LABEL + "  ");
        minimalHUDLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        minimalHUDLabel.setTooltip(new Tooltip(MIN_HUD_TT));
        minimalHUDPicker = new ComboBox(FXCollections.observableArrayList(DISABLE_ENABLE));
        if(config.enableMinimalHud.get() == 0){
            minimalHUDPicker.setValue(minimalHUDPicker.getItems().get(0));
        }else{
            minimalHUDPicker.setValue(minimalHUDPicker.getItems().get(1));
        }
        minimalHUDPane.getChildren().addAll(minimalHUDLabel, minimalHUDPicker);
        //
        //HUD Scale
        hudScalePane = new FlowPane();
        hudScalePane.getStyleClass().add("settings_pane");
        hudScaleLabel = new Label(HUD_SCALE_LABEL + "  ");
        hudScaleLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        hudScaleLabel.setTooltip(new Tooltip(HUD_SCALE_TT));
        hudScaleField = new TextField(config.hudScaleFactor.toString());
        hudScaleField.getStyleClass().add("settings_med_text_field");
        hudScalePane.getChildren().addAll(hudScaleLabel, hudScaleField);
        //
        //HUD Opacities Parent Label
        hudOpacitiesPane = new FlowPane();
        hudOpacitiesPane.getStyleClass().add("settings_pane");
        hudOpacitiesLabel = new Label(HUD_OPACITIES_LABEL + "  ");
        hudOpacitiesLabel.getStyleClass().addAll("bold_text", "font_14_pt");
        hudOpacitiesLabel.setTooltip(new Tooltip(HUD_OPS_TT));
        hudOpacitiesPane.getChildren().addAll(hudOpacitiesLabel);
        //
        //Top Left HUD Opacity
        topLeftHUDOpPane = new FlowPane();
        topLeftHUDOpPane.getStyleClass().add("settings_pane");
        topLeftHUDOpLabel = new Label(TOP_LEFT_HUD_OP_LABEL + "  ");
        topLeftHUDOpLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        topLeftHUDOpLabel.setTooltip(new Tooltip(TOP_LEFT_HUD_TT));
        topLeftHUDOpField = new TextField(config.hudTopLeftOpacity.toString().substring(0, config.hudTopLeftOpacity.length() - 1));
        topLeftHUDOpField.getStyleClass().add("settings_med_text_field");
        topLeftHUDOpPane.getChildren().addAll(topLeftHUDOpLabel, topLeftHUDOpField);
        //
        //Bottom Left HUD Opacity
        bottomLeftHUDOpPane = new FlowPane();
        bottomLeftHUDOpPane.getStyleClass().add("settings_pane");
        bottomLeftHUDOpLabel = new Label(BOTTOM_LEFT_HUD_OP_LABEL + "  ");
        bottomLeftHUDOpLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        bottomLeftHUDOpLabel.setTooltip(new Tooltip(BOTTOM_LEFT_HUD_TT));
        bottomLeftHUDOpField = new TextField(config.hudBottomLeftOpacity.toString().substring(0, config.hudBottomLeftOpacity.length() - 1));
        bottomLeftHUDOpField.getStyleClass().add("settings_med_text_field");
        bottomLeftHUDOpPane.getChildren().addAll(bottomLeftHUDOpLabel, bottomLeftHUDOpField);
        //
        //Bottom Riht HUD Opacity
        bottomRightHUDOpPane = new FlowPane();
        bottomRightHUDOpPane.getStyleClass().add("settings_pane");
        bottomRightHUDOpLabel = new Label(BOTTOM_RIGHT_HUD_OP_LABEL + "  ");
        bottomRightHUDOpLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        bottomRightHUDOpLabel.setTooltip(new Tooltip(BOTTOM_RIGHT_HUD_TT));
        bottomRightHUDOpField = new TextField(config.hudBottomRightOpacity.toString().substring(0, config.hudBottomRightOpacity.length() - 1));
        bottomRightHUDOpField.getStyleClass().add("settings_med_text_field");
        bottomRightHUDOpPane.getChildren().addAll(bottomRightHUDOpLabel, bottomRightHUDOpField);
        
        if(config.enableHudMod.get() == 0){
           minimalHUDPicker.setDisable(true);
           hudScaleField.setDisable(true);
           topLeftHUDOpField.setDisable(true);
           bottomLeftHUDOpField.setDisable(true);
           bottomRightHUDOpField.setDisable(true);
        }
        
        primaryVBox.getChildren().addAll(titleBar, restoreDefaultsBar, spacerHBox,
                                        hudModsPane, minimalHUDPane, hudScalePane,
                                        hudOpacitiesPane, topLeftHUDOpPane,
                                        bottomLeftHUDOpPane, bottomRightHUDOpPane,
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
               config.restoreDefaultHUDOptions(); 
               ui.refreshUI();
           }
        });
        
        hudModsPicker.setOnAction(e -> {
            if(hudModsPicker.getValue().equals(DISABLE_ENABLE[0])){
                minimalHUDPicker.setDisable(true);
                hudScaleField.setDisable(true);
                topLeftHUDOpField.setDisable(true);
                bottomLeftHUDOpField.setDisable(true);
                bottomRightHUDOpField.setDisable(true);
                config.enableHudMod.set(0);
            }else{
                minimalHUDPicker.setDisable(false);
                hudScaleField.setDisable(false);
                topLeftHUDOpField.setDisable(false);
                bottomLeftHUDOpField.setDisable(false);
                bottomRightHUDOpField.setDisable(false);
                config.enableHudMod.set(1);
            }
        });
        
        minimalHUDPicker.setOnAction(e -> {
            if(minimalHUDPicker.getValue().equals(DISABLE_ENABLE[0])){
                config.enableMinimalHud.set(0);
            }else{
                config.enableMinimalHud.set(1);
            }
        });
        
        hudScaleField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) || Double.parseDouble(newText) < 0.0 ||
                            Double.parseDouble(newText) > 1.0){
                        hudScaleField.pseudoClassStateChanged(INVALID_INPUT, true);
                        hudScaleField.setTooltip(new Tooltip(INVALID_DOUBLE_0_1));
                    }else{
                        hudScaleField.pseudoClassStateChanged(INVALID_INPUT, false);
                        hudScaleField.setTooltip(new Tooltip(""));
                        config.hudScaleFactor.replace(0, config.hudScaleFactor.length(), Double.parseDouble(decimalFormat.format(Double.parseDouble(newText))) + "");
                    }
                }catch(NumberFormatException nFE){
                    ui.printConsole(INPUT_TOO_LARGE);
                    hudScaleField.setText("");
                }
            }
        });
        
        topLeftHUDOpField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) || Double.parseDouble(newText) < 0.0 ||
                            Double.parseDouble(newText) > 1.0){
                        topLeftHUDOpField.pseudoClassStateChanged(INVALID_INPUT, true);
                        topLeftHUDOpField.setTooltip(new Tooltip(INVALID_DOUBLE_0_1));
                    }else{
                        topLeftHUDOpField.pseudoClassStateChanged(INVALID_INPUT, false);
                        topLeftHUDOpField.setTooltip(new Tooltip(""));
                        config.hudTopLeftOpacity.replace(0, config.hudTopLeftOpacity.length(), decimalFormat.format(Double.parseDouble(newText)) + "f");
                    }
                }catch(NumberFormatException nFE){
                    ui.printConsole(INPUT_TOO_LARGE);
                    topLeftHUDOpField.setText("");
                }
            }
        });
        
        bottomLeftHUDOpField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) || Double.parseDouble(newText) < 0.0 ||
                            Double.parseDouble(newText) > 1.0){
                        bottomLeftHUDOpField.pseudoClassStateChanged(INVALID_INPUT, true);
                        bottomLeftHUDOpField.setTooltip(new Tooltip(INVALID_DOUBLE_0_1));
                    }else{
                        bottomLeftHUDOpField.pseudoClassStateChanged(INVALID_INPUT, false);
                        bottomLeftHUDOpField.setTooltip(new Tooltip(""));
                        config.hudBottomLeftOpacity.replace(0, config.hudBottomLeftOpacity.length(), decimalFormat.format(Double.parseDouble(newText)) + "f");
                    }
                }catch(NumberFormatException nFE){
                    ui.printConsole(INPUT_TOO_LARGE);
                    bottomLeftHUDOpField.setText("");
                }
            }
        });
        
        bottomRightHUDOpField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) || Double.parseDouble(newText) < 0.0 ||
                            Double.parseDouble(newText) > 1.0){
                        bottomRightHUDOpField.pseudoClassStateChanged(INVALID_INPUT, true);
                        bottomRightHUDOpField.setTooltip(new Tooltip(INVALID_DOUBLE_0_1));
                    }else{
                        bottomRightHUDOpField.pseudoClassStateChanged(INVALID_INPUT, false);
                        bottomRightHUDOpField.setTooltip(new Tooltip(""));
                        config.hudBottomRightOpacity.replace(0, config.hudBottomRightOpacity.length(), decimalFormat.format(Double.parseDouble(newText)) + "f");
                    }
                }catch(NumberFormatException nFE){
                    ui.printConsole(INPUT_TOO_LARGE);
                    bottomRightHUDOpField.setText("");
                }
            }
        });
    }
    
    public boolean hasInvalidInputs(){
        ArrayList<TextField> fields = new ArrayList();
        
        fields.add(hudScaleField);
        fields.add(topLeftHUDOpField);
        fields.add(bottomLeftHUDOpField);
        fields.add(bottomRightHUDOpField);
        
        for(TextField field : fields){
            if(field.getPseudoClassStates().toString().contains("invalid")){
                return true;
            }
        }
        
        return false;
    }
}
