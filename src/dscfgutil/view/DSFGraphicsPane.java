/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.view;

import static dscfgutil.DSCfgUtilConstants.AAQUALITIES;
import static dscfgutil.DSCfgUtilConstants.AATYPES;
import static dscfgutil.DSCfgUtilConstants.AA_QUALITY_LABEL;
import static dscfgutil.DSCfgUtilConstants.AA_QUALITY_TT;
import static dscfgutil.DSCfgUtilConstants.AA_TYPE_LABEL;
import static dscfgutil.DSCfgUtilConstants.AA_TYPE_TT;
import static dscfgutil.DSCfgUtilConstants.APPLY_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_RESTORE_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_TRY_ALTERNATE_NO_DOF;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_NOT_RECOMMENDED;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_RESET;
import static dscfgutil.DSCfgUtilConstants.DOFOVERRIDERESOLUTIONS;
import static dscfgutil.DSCfgUtilConstants.DOF_ADDITIONAL_BLUR;
import static dscfgutil.DSCfgUtilConstants.DOF_ADDITIONAL_BLUR_OPTIONS;
import static dscfgutil.DSCfgUtilConstants.DOF_ADD_BLUR_LABEL;
import static dscfgutil.DSCfgUtilConstants.DOF_ADD_BLUR_TT;
import static dscfgutil.DSCfgUtilConstants.DOF_OVERRIDE_LABEL;
import static dscfgutil.DSCfgUtilConstants.DOF_OVERRIDE_OPTIONS;
import static dscfgutil.DSCfgUtilConstants.DOF_OVERRIDE_TT;
import static dscfgutil.DSCfgUtilConstants.DOF_SCALING_LABEL;
import static dscfgutil.DSCfgUtilConstants.DOF_SCALING_OR_TT;
import static dscfgutil.DSCfgUtilConstants.DONT_USE_PRES_RES;
import static dscfgutil.DSCfgUtilConstants.ENABLE_DISABLE;
import static dscfgutil.DSCfgUtilConstants.FILES_EDITED_ERR;
import static dscfgutil.DSCfgUtilConstants.FILTERINGOVERRIDES;
import static dscfgutil.DSCfgUtilConstants.FILTERING_OVERRIDE_OPTIONS;
import static dscfgutil.DSCfgUtilConstants.FPS_FIX_FILES;
import static dscfgutil.DSCfgUtilConstants.FPS_FIX_KEYS;
import static dscfgutil.DSCfgUtilConstants.FPS_FIX_KEYS_ARRAY_LIST;
import static dscfgutil.DSCfgUtilConstants.FPS_FIX_KEYS_HEX;
import static dscfgutil.DSCfgUtilConstants.FPS_FIX_KEYS_HEX_ARRAY_LIST;
import static dscfgutil.DSCfgUtilConstants.FPS_FIX_KEY_LABEL;
import static dscfgutil.DSCfgUtilConstants.FPS_FIX_TT;
import static dscfgutil.DSCfgUtilConstants.FPS_LIMIT_LABEL;
import static dscfgutil.DSCfgUtilConstants.FPS_LIMIT_TT;
import static dscfgutil.DSCfgUtilConstants.FPS_THRESHOLD_LABEL;
import static dscfgutil.DSCfgUtilConstants.FPS_THRESHOLD_TT;
import static dscfgutil.DSCfgUtilConstants.GRAPHICS;
import static dscfgutil.DSCfgUtilConstants.INPUT_FPS_TOO_HIGH;
import static dscfgutil.DSCfgUtilConstants.INPUT_GREATER_THAN;
import static dscfgutil.DSCfgUtilConstants.INPUT_TOO_LARGE;
import static dscfgutil.DSCfgUtilConstants.INVALID_INPUT;
import static dscfgutil.DSCfgUtilConstants.LOCK_UNLOCK;
import static dscfgutil.DSCfgUtilConstants.POSITIVE_INTEGER;
import static dscfgutil.DSCfgUtilConstants.PRESENT_RES_LABEL;
import static dscfgutil.DSCfgUtilConstants.PRESENT_RES_TT;
import static dscfgutil.DSCfgUtilConstants.PRES_HEIGHT_TOO_LOW;
import static dscfgutil.DSCfgUtilConstants.PRES_WIDTH_TOO_LOW;
import static dscfgutil.DSCfgUtilConstants.RENDER_RES_LABEL;
import static dscfgutil.DSCfgUtilConstants.RENDER_RES_TT;
import static dscfgutil.DSCfgUtilConstants.RESTORE_DEFAULTS;
import static dscfgutil.DSCfgUtilConstants.SAME_RESOLUTIONS;
import static dscfgutil.DSCfgUtilConstants.SETTINGS;
import static dscfgutil.DSCfgUtilConstants.SSAOSCALES;
import static dscfgutil.DSCfgUtilConstants.SSAOSTRENGTHS;
import static dscfgutil.DSCfgUtilConstants.SSAOTYPES;
import static dscfgutil.DSCfgUtilConstants.SSAO_SCALE_LABEL;
import static dscfgutil.DSCfgUtilConstants.SSAO_SCALE_TT;
import static dscfgutil.DSCfgUtilConstants.SSAO_STRENGTH_LABEL;
import static dscfgutil.DSCfgUtilConstants.SSAO_STRENGTH_TT;
import static dscfgutil.DSCfgUtilConstants.SSAO_TYPE_LABEL;
import static dscfgutil.DSCfgUtilConstants.SSAO_TYPE_TT;
import static dscfgutil.DSCfgUtilConstants.TEX_FILTERING_OVERRIDE_LABEL;
import static dscfgutil.DSCfgUtilConstants.TEX_FILT_OR_TT;
import static dscfgutil.DSCfgUtilConstants.UNLOCK_FPS_LABEL;
import static dscfgutil.DSCfgUtilConstants.UNLOCK_FPS_TT;
import static dscfgutil.DSCfgUtilConstants.USE_PRESENT_RES;
import static dscfgutil.DSCfgUtilConstants.USE_WINDOWS_RES;
import static dscfgutil.DSCfgUtilConstants.WIDTH_HEIGHT;
import static dscfgutil.DSCfgUtilConstants.WRITING_FILE;
import static dscfgutil.FileIO.DSFixFileController.readTextFile;
import static dscfgutil.FileIO.DSFixFileController.writeTextFile;
import dscfgutil.configs.DSFConfiguration;
import dscfgutil.dialog.ContinueDialog;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javax.imageio.IIOException;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author Sean Pesce
 */
public class DSFGraphicsPane extends ScrollPane {
    
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
    
    //Settings UI Components
    //
    Label resCatLabel;
    //
    FlowPane renderResPane;
    Label renderResLabel;
    Label renderWidthLabel;
    Label renderHeightLabel;
    TextField renderWidthField;
    TextField renderHeightField;
    public Button setWindowsRenderRes;
    //
    FlowPane presentResPane;
    Label presentResLabel;
    HBox presentResSpacer;
    Label presentWidthLabel;
    Label presentHeightLabel;
    TextField presentWidthField;
    TextField presentHeightField;
    public Button setWindowsPresentRes;
    ToggleGroup presentResChoice;
    RadioButton usePresentRes;
    RadioButton dontUsePresentRes;
    HBox presentResSpacer2;
    //
    Label aaCatLabel;
    //
    FlowPane aaQualityPane;
    Label aaQualityLabel;
    ComboBox<String> aaQualityPicker;
    //
    FlowPane aaTypePane;
    Label aaTypeLabel;
    ComboBox<String> aaTypePicker;
    //
    Label aoCatLabel;
    //
    FlowPane ssaoStrengthPane;
    Label ssaoStrengthLabel;
    ComboBox<String> ssaoStrengthPicker;
    //
    FlowPane ssaoScalePane;
    Label ssaoScaleLabel;
    ComboBox<String> ssaoScalePicker;
    //
    FlowPane ssaoTypePane;
    Label ssaoTypeLabel;
    ComboBox<String> ssaoTypePicker;
    //
    Label dofCatLabel;
    //
    FlowPane dofOverridePane;
    Label dofOverrideLabel;
    ComboBox<String> dofOverridePicker;
    //
    FlowPane dofScalingPane;
    Label dofScalingLabel;
    ToggleGroup dofScalingChoice;
    RadioButton dofScalingEnabled;
    RadioButton dofScalingDisabled;
    //
    FlowPane dofAddPane;
    Label dofAddLabel;
    ComboBox<String> dofAddPicker;
    //
    Label fpsCatLabel;
    //
    FlowPane unlockFPSPane;
    Label unlockFPSLabel;
    ToggleGroup unlockFPSChoice;
    RadioButton fpsLocked;
    RadioButton fpsUnlocked;
    //
    FlowPane fpsFixKeyPane;
    Label fpsFixKeyLabel;
    ComboBox<String> fpsFixKeyPicker;
    //
    FlowPane fpsLimitPane;
    Label fpsLimitLabel;
    TextField fpsLimitField;
    //
    FlowPane fpsThresholdPane;
    Label fpsThresholdLabel;
    TextField fpsThresholdField;
    //
    Label texFilterCatLabel;
    //
    FlowPane texOverridePane;
    Label texOverrideLabel;
    ComboBox<String> texOverridePicker;
    //
    
    //Instance Variables
    DSCfgMainUI ui;
    DSFConfiguration config;
    
    //Input checks
    String presentRes[] = {"0", "0"};
    public String fpsFixKey;
    
    public DSFGraphicsPane(DSCfgMainUI initUI){
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
        titleLabel = new Label(GRAPHICS.toUpperCase() + " " + SETTINGS.toUpperCase());
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
        //
        //MAIN GRAPHICS OPTIONS
        //
        //Render resolution
        renderResPane = new FlowPane();
        renderResPane.getStyleClass().add("settings_pane");
        renderResLabel = new Label(RENDER_RES_LABEL + "   ");
        renderResLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        renderResLabel.setTooltip(new Tooltip(RENDER_RES_TT));
        renderWidthLabel = new Label(WIDTH_HEIGHT[0] + ":");
        renderWidthField = new TextField("");
        renderWidthField.appendText("" + config.getRenderWidth());
        renderWidthField.getStyleClass().add("settings_text_field");
        renderHeightLabel = new Label("  " + WIDTH_HEIGHT[1] + ":");
        renderHeightField = new TextField("");
        renderHeightField.appendText("" + config.getRenderHeight());
        renderHeightField.getStyleClass().add("settings_text_field");
        setWindowsRenderRes = new Button(USE_WINDOWS_RES);
        renderResPane.getChildren().addAll(renderResLabel, renderWidthLabel,
                                renderWidthField, renderHeightLabel,
                                renderHeightField, setWindowsRenderRes);
        //
        //Present Resolution
        presentResPane = new FlowPane();
        presentResPane.getStyleClass().add("settings_pane");
        presentResLabel = new Label(PRESENT_RES_LABEL + "  ");
        presentResLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        presentResLabel.setTooltip(new Tooltip(PRESENT_RES_TT));
        presentResSpacer = new HBox();
        presentResSpacer.setMinWidth(3);
        presentWidthLabel = new Label(WIDTH_HEIGHT[0] + ":");
        presentWidthField = new TextField("");
        presentWidthField.appendText(config.getPresentWidth() + "");
        presentRes[0] = config.getPresentWidth() + "";
        presentWidthField.getStyleClass().add("settings_text_field");
        presentHeightLabel = new Label("  " + WIDTH_HEIGHT[1] + ":");
        presentHeightField = new TextField("");
        presentHeightField.appendText(config.getPresentHeight() + "");
        presentRes[1] = config.getPresentHeight() + "";
        presentHeightField.getStyleClass().add("settings_text_field");
        setWindowsPresentRes = new Button(USE_WINDOWS_RES);
        presentResSpacer2 = new HBox();
        presentResSpacer2.setMinWidth(5);
        presentResChoice = new ToggleGroup();
        usePresentRes = new RadioButton(USE_PRESENT_RES + "   ");
        usePresentRes.setToggleGroup(presentResChoice);
        dontUsePresentRes = new RadioButton(DONT_USE_PRES_RES);
        dontUsePresentRes.setToggleGroup(presentResChoice);
        //Check if presentRes is off
        if(config.getPresentWidth() == 0 && config.getPresentHeight() == 0){
            presentWidthField.setDisable(true);
            presentHeightField.setDisable(true);
            setWindowsPresentRes.setDisable(true);
            dontUsePresentRes.setSelected(true);
        }else{
            presentWidthField.setDisable(false);
            presentWidthField.setText("" + config.getPresentWidth());
            presentHeightField.setDisable(false);
            presentHeightField.setText("" + config.getPresentHeight());
            setWindowsPresentRes.setDisable(false);
            usePresentRes.setSelected(true);
            recheckTextInput(presentWidthField);
            recheckTextInput(presentHeightField);
        }
        presentResPane.getChildren().addAll(presentResLabel, presentResSpacer,
                presentWidthLabel, presentWidthField, presentHeightLabel,
                presentHeightField, setWindowsPresentRes, presentResSpacer2,
                usePresentRes, dontUsePresentRes);
        //
        //
        //
        //ANTIALIASING OPTIONS
        //
        //AA Quality
        aaQualityPane = new FlowPane();
        aaQualityPane.getStyleClass().add("settings_pane");
        aaQualityLabel = new Label(AA_QUALITY_LABEL + "  ");
        aaQualityLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        aaQualityLabel.setTooltip(new Tooltip(AA_QUALITY_TT));
        aaQualityPicker = new ComboBox(FXCollections.observableArrayList(AAQUALITIES));
        try{
                aaQualityPicker.setValue(AAQUALITIES[config.aaQuality.get()]);
        }catch(IndexOutOfBoundsException iobEx){
                ui.printConsole("WARNING: Unknown AA Quality value detected. Setting to " + AAQUALITIES[0] + " instead...");
                aaQualityPicker.setValue(AAQUALITIES[0]);
        }
        aaQualityPane.getChildren().addAll(aaQualityLabel, aaQualityPicker);
        //
        //AA Type
        aaTypePane = new FlowPane();
        aaTypePane.getStyleClass().add("settings_pane");
        aaTypeLabel = new Label(AA_TYPE_LABEL + "  ");
        aaTypeLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        aaTypeLabel.setTooltip(new Tooltip(AA_TYPE_TT));
        aaTypePicker = new ComboBox(FXCollections.observableArrayList(AATYPES));
        aaTypePicker.setValue(config.aaType.toString());
        if(config.aaQuality.get() == 0){
            aaTypePicker.setDisable(true);
        }
        aaTypePane.getChildren().addAll(aaTypeLabel, aaTypePicker);
        //
        //
        //
        //AMBIENT OCCLUSION OPTIONS
        //
        //SSAO Strength
        ssaoStrengthPane = new FlowPane();
        ssaoStrengthPane.getStyleClass().add("settings_pane");
        ssaoStrengthLabel = new Label(SSAO_STRENGTH_LABEL + "  ");
        ssaoStrengthLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        ssaoStrengthLabel.setTooltip(new Tooltip(SSAO_STRENGTH_TT));
        ssaoStrengthPicker = new ComboBox(FXCollections.observableArrayList(SSAOSTRENGTHS));
        try{
                ssaoStrengthPicker.setValue(SSAOSTRENGTHS[config.ssaoStrength.get()]);
        }catch(IndexOutOfBoundsException iobEx){
                ui.printConsole("WARNING: Unknown SSAO Strength value detected. Setting to " + SSAOSTRENGTHS[0] + " instead...");
                ssaoStrengthPicker.setValue(SSAOSTRENGTHS[0]);
        }
        ssaoStrengthPane.getChildren().addAll(ssaoStrengthLabel, ssaoStrengthPicker);
        //
        //SSAO Scale
        ssaoScalePane = new FlowPane();
        ssaoScalePane.getStyleClass().add("settings_pane");
        ssaoScaleLabel = new Label(SSAO_SCALE_LABEL + "  ");
        ssaoScaleLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        ssaoScaleLabel.setTooltip(new Tooltip(SSAO_SCALE_TT));
        ssaoScalePicker = new ComboBox(FXCollections.observableArrayList(SSAOSCALES));
        ssaoScalePicker.setValue(SSAOSCALES[config.ssaoScale.get() - 1]);
        try{
                ssaoScalePicker.setValue(SSAOSCALES[config.ssaoScale.get() - 1]);
        }catch(IndexOutOfBoundsException iobEx){
                ui.printConsole("WARNING: Unknown SSAO Scale value detected. Setting to " + SSAOSCALES[1] + " instead...");
                ssaoScalePicker.setValue(SSAOSCALES[1]);
        }
        if(config.ssaoStrength.get() == 0){
            ssaoScalePicker.setDisable(true);
        }
        ssaoScalePane.getChildren().addAll(ssaoScaleLabel, ssaoScalePicker);
        //
        //SSAO Type
        ssaoTypePane = new FlowPane();
        ssaoTypePane.getStyleClass().add("settings_pane");
        ssaoTypeLabel = new Label(SSAO_TYPE_LABEL + "  ");
        ssaoTypeLabel.setTooltip(new Tooltip(SSAO_TYPE_TT));
        ssaoTypeLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        ssaoTypePicker = new ComboBox(FXCollections.observableArrayList(SSAOTYPES));
        ssaoTypePicker.setValue(config.ssaoType.toString());
        if(config.ssaoStrength.get() == 0){
            ssaoTypePicker.setDisable(true);
        }
        ssaoTypePane.getChildren().addAll(ssaoTypeLabel, ssaoTypePicker);
        //
        //
        //
        //DEPTH OF FIELD OPTIONS
        //
        //DOF Override Resolution
        dofOverridePane = new FlowPane();
        dofOverridePane.getStyleClass().add("settings_pane");
        dofOverrideLabel = new Label(DOF_OVERRIDE_LABEL + "  ");
        dofOverrideLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        dofOverrideLabel.setTooltip(new Tooltip(DOF_OVERRIDE_TT));
        dofOverridePicker = new ComboBox(FXCollections.observableArrayList(DOFOVERRIDERESOLUTIONS));
        for(int i = 0; i < DOF_OVERRIDE_OPTIONS.length; i++){
            if(config.getDOFOverride() == DOF_OVERRIDE_OPTIONS[i]){
                dofOverridePicker.setValue(DOFOVERRIDERESOLUTIONS[i]);
            }
        }
        dofOverridePane.getChildren().addAll(dofOverrideLabel, dofOverridePicker);
        //
        //DOF Scaling
        dofScalingPane = new FlowPane();
        dofScalingPane.getStyleClass().add("settings_pane");
        dofScalingLabel = new Label(DOF_SCALING_LABEL + "  ");
        dofScalingLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        dofScalingLabel.setTooltip(new Tooltip(DOF_SCALING_OR_TT));
        dofScalingChoice = new ToggleGroup();
        dofScalingEnabled = new RadioButton(ENABLE_DISABLE[0] + "   ");
        dofScalingEnabled.setToggleGroup(dofScalingChoice);
        dofScalingDisabled = new RadioButton(ENABLE_DISABLE[1]);
        dofScalingDisabled.setToggleGroup(dofScalingChoice);
        if(config.disableDofScaling.get() == 0){
            dofScalingEnabled.setSelected(true);
        }else{
            dofScalingDisabled.setSelected(true);
        }
        dofScalingPane.getChildren().addAll(dofScalingLabel, dofScalingEnabled,
                                            dofScalingDisabled);
        //
        //DOF Additional Blur
        dofAddPane = new FlowPane();
        dofAddPane.getStyleClass().add("settings_pane");
        dofAddLabel = new Label(DOF_ADD_BLUR_LABEL + "  ");
        dofAddLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        dofAddLabel.setTooltip(new Tooltip(DOF_ADD_BLUR_TT));
        dofAddPicker = new ComboBox(FXCollections.observableArrayList(DOF_ADDITIONAL_BLUR));
        for(int i = 0; i < DOF_ADDITIONAL_BLUR_OPTIONS.length; i++){
            if(config.dofBlurAmount.toString().equals(DOF_ADDITIONAL_BLUR_OPTIONS[i])){
                dofAddPicker.setValue(DOF_ADDITIONAL_BLUR[i]);
            }
        }
        dofAddPane.getChildren().addAll(dofAddLabel, dofAddPicker);
        if(config.disableDOF){
            dofScalingEnabled.setDisable(true);
            dofScalingDisabled.setDisable(true);
            dofAddPicker.setDisable(true);
            dofOverridePicker.setValue(DOFOVERRIDERESOLUTIONS[5]);
            setWindowsPresentRes.setDisable(true);
            presentWidthField.setDisable(true);
            presentHeightField.setDisable(true);
            usePresentRes.setDisable(true);
            dontUsePresentRes.setDisable(true);
        }
        //
        //
        //
        //FRAMERATE OPTIONS
        //
        //Unlock Framerate
        unlockFPSPane = new FlowPane();
        unlockFPSPane.getStyleClass().add("settings_pane");
        unlockFPSLabel = new Label(UNLOCK_FPS_LABEL + "  ");
        unlockFPSLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        unlockFPSLabel.setTooltip(new Tooltip(UNLOCK_FPS_TT));
        unlockFPSChoice = new ToggleGroup();
        fpsLocked = new RadioButton(LOCK_UNLOCK[0] + "   ");
        fpsLocked.setToggleGroup(unlockFPSChoice);
        fpsUnlocked = new RadioButton(LOCK_UNLOCK[1]);
        fpsUnlocked.setToggleGroup(unlockFPSChoice);
        if(config.unlockFPS.get() == 0){
            fpsLocked.setSelected(true);
        }else{
            fpsUnlocked.setSelected(true);
        }
        unlockFPSPane.getChildren().addAll(unlockFPSLabel, fpsLocked,
                                            fpsUnlocked);
        //
        //Bonfire FPSFix Keybind
        fpsFixKeyPane = new FlowPane();
        fpsFixKeyPane.getStyleClass().add("settings_pane");
        fpsFixKeyLabel = new Label(FPS_FIX_KEY_LABEL + "  ");
        fpsFixKeyLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        fpsFixKeyLabel.setTooltip(new Tooltip(FPS_FIX_TT));
        
        fpsFixKeyPicker = new ComboBox(FPS_FIX_KEYS_ARRAY_LIST);
        fpsFixKeyPicker.setTooltip(new Tooltip(FPS_FIX_TT));
        fpsFixKeyPane.getChildren().addAll(fpsFixKeyLabel, fpsFixKeyPicker);
        //
        fpsFixKey = getFPSFixKey();
        if(fpsFixKey != null){
            try{
                fpsFixKeyPicker.setValue(FPS_FIX_KEYS[FPS_FIX_KEYS_HEX_ARRAY_LIST.indexOf("0x" + fpsFixKey)]);
            }catch(IndexOutOfBoundsException iobEx){
                // ui.printConsole("Unknown Bonfire FPS Fix keybind value detected.");
                fpsFixKeyPicker.setValue("0x" + fpsFixKey);
            }
        }else{
            fpsFixKeyPicker.setValue(FPS_FIX_KEYS[4]);
            fpsFixKeyPicker.setDisable(true);
        }
        //
        //FPS Limit
        fpsLimitPane = new FlowPane();
        fpsLimitPane.getStyleClass().add("settings_pane");
        fpsLimitLabel = new Label(FPS_LIMIT_LABEL + "         ");
        fpsLimitLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        fpsLimitLabel.setTooltip(new Tooltip(FPS_LIMIT_TT));
        fpsLimitField = new TextField("" + config.FPSlimit);
        fpsLimitField.getStyleClass().add("settings_small_text_field");
        fpsLimitPane.getChildren().addAll(fpsLimitLabel, fpsLimitField);
        //
        if(config.unlockFPS.get() == 0){
            fpsLimitField.setDisable(true);
        }
        //
        //FPS Threshold (for automatic disabling of AA)
        fpsThresholdPane = new FlowPane();
        fpsThresholdPane.getStyleClass().add("settings_pane");
        fpsThresholdLabel = new Label(FPS_THRESHOLD_LABEL + " ");
        fpsThresholdLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        fpsThresholdLabel.setTooltip(new Tooltip(FPS_THRESHOLD_TT));
        fpsThresholdField = new TextField("" + config.FPSthreshold);
        fpsThresholdField.getStyleClass().add("settings_small_text_field");
        fpsThresholdPane.getChildren().addAll(fpsThresholdLabel, fpsThresholdField);
        //
        //
        //
        //TEXTURE FILTERING OPTIONS
        //
        //Texture Filtering Override
        texOverridePane = new FlowPane();
        texOverridePane.getStyleClass().add("settings_pane");
        texOverrideLabel = new Label(TEX_FILTERING_OVERRIDE_LABEL + "  ");
        texOverrideLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        texOverrideLabel.setTooltip(new Tooltip(TEX_FILT_OR_TT));
        texOverridePicker = new ComboBox(FXCollections.observableArrayList(FILTERINGOVERRIDES));
        for(int i = 0; i < FILTERING_OVERRIDE_OPTIONS.length; i++){
            if(config.filteringOverride.get() == i){
                texOverridePicker.setValue(FILTERINGOVERRIDES[i]);
            }
        }
        texOverridePane.getChildren().addAll(texOverrideLabel, texOverridePicker);
        
        
        
        primaryVBox.getChildren().addAll(titleBar, restoreDefaultsBar, spacerHBox,
                                renderResPane, presentResPane, aaQualityPane,
                                aaTypePane, ssaoStrengthPane, ssaoScalePane,
                                ssaoTypePane, dofOverridePane, dofScalingPane,
                                dofAddPane, fpsFixKeyPane, unlockFPSPane, fpsLimitPane,
                                fpsThresholdPane, texOverridePane,
                                bottomSpacerHBox);
        
        if(config.disableDOF){
            dofScalingEnabled.setDisable(true);
            dofScalingDisabled.setDisable(true);
            dofAddPicker.setDisable(true);
            presentWidthField.setDisable(true);
            presentHeightField.setDisable(true);
            setWindowsPresentRes.setDisable(true);
            usePresentRes.setDisable(true);
            dontUsePresentRes.setDisable(true);
            dofScalingDisabled.setSelected(true);
            dofAddPicker.setValue(dofAddPicker.getItems().get(0));
            if(usePresentRes.isSelected()){
                presentRes[0] = presentWidthField.getText();
                presentRes[1] = presentHeightField.getText();
            }
            presentWidthField.setText("0");
            presentHeightField.setText("0");
        }
        
        recheckTextInput(presentWidthField);
        recheckTextInput(presentHeightField);
        recheckTextInput(renderWidthField);
        recheckTextInput(renderHeightField);
        
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
               config.restoreDefaultGraphicsOptions(); 
               ui.refreshUI();
           }
        });
        
        renderWidthField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) ||
                                (NumberUtils.isParsable(newText) && Integer.parseInt(newText) < 1)){
                        renderWidthField.pseudoClassStateChanged(INVALID_INPUT, true);
                        renderWidthField.setTooltip(new Tooltip(POSITIVE_INTEGER));
                    }else if(Integer.parseInt(newText) >= 1280){
                        /*if(NumberUtils.isParsable(presentWidthField.getText()) && (Integer.parseInt(newText) == Integer.parseInt(presentWidthField.getText()))){
                            renderWidthField.pseudoClassStateChanged(INVALID_INPUT, true);
                            renderWidthField.setTooltip(new Tooltip(SAME_RESOLUTIONS));
                        }else{*/
                            renderWidthField.pseudoClassStateChanged(INVALID_INPUT, false);
                            renderWidthField.setTooltip(new Tooltip(""));
                            config.setRenderWidth(Integer.parseInt(newText));
                            if(config.disableDOF){
                                config.setPresentWidth(Integer.parseInt(newText));
                            }
                        //}
                    //If input is a positive integer that is less than 1280, present width comes into play
                    }else if(NumberUtils.isParsable(presentWidthField.getText()) && Integer.parseInt(presentWidthField.getText()) >= 1280){
                            renderWidthField.pseudoClassStateChanged(INVALID_INPUT, false);
                            renderWidthField.setTooltip(new Tooltip(""));
                            config.setRenderWidth(Integer.parseInt(newText));
                    }else{
                            renderWidthField.pseudoClassStateChanged(INVALID_INPUT, true);
                            renderWidthField.setTooltip(new Tooltip(PRES_WIDTH_TOO_LOW));
                    }
                    recheckTextInput(presentWidthField);
                }catch(NumberFormatException nFE){
                    config.setRenderWidth(1920);
                    ui.printConsole(INPUT_TOO_LARGE);
                    renderWidthField.setText("");
                    renderWidthField.appendText(config.getRenderWidth() + "");
                }
                
                }
            });
        
        renderHeightField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) ||
                                (NumberUtils.isParsable(newText) && Integer.parseInt(newText) < 1)){
                        renderHeightField.pseudoClassStateChanged(INVALID_INPUT, true);
                        renderHeightField.setTooltip(new Tooltip(POSITIVE_INTEGER));
                    }else if(Integer.parseInt(newText) >= 720){
                        /*if(NumberUtils.isParsable(presentHeightField.getText()) && (Integer.parseInt(newText) == Integer.parseInt(presentHeightField.getText()))){
                            renderHeightField.pseudoClassStateChanged(INVALID_INPUT, true);
                            renderHeightField.setTooltip(new Tooltip(SAME_RESOLUTIONS));
                        }else{*/
                            renderHeightField.pseudoClassStateChanged(INVALID_INPUT, false);
                            renderHeightField.setTooltip(new Tooltip(""));
                            config.setRenderHeight(Integer.parseInt(newText));
                            if(config.disableDOF){
                                config.setPresentHeight(Integer.parseInt(newText));
                                config.setDOFOverride(Integer.parseInt(newText));
                            }
                        //}
                    //If input is a positive integer that is less than 720, present height comes into play
                    }else if(NumberUtils.isParsable(presentHeightField.getText()) && Integer.parseInt(presentHeightField.getText()) >= 720){
                            renderHeightField.pseudoClassStateChanged(INVALID_INPUT, false);
                            renderHeightField.setTooltip(new Tooltip(""));
                            config.setRenderHeight(Integer.parseInt(newText));
                    }else{
                            renderHeightField.pseudoClassStateChanged(INVALID_INPUT, true);
                            renderHeightField.setTooltip(new Tooltip(PRES_HEIGHT_TOO_LOW));
                    }
                    recheckTextInput(presentHeightField);
                }catch(NumberFormatException nFE){
                    config.setRenderHeight(1080);
                    ui.printConsole(INPUT_TOO_LARGE);
                    renderHeightField.setText("");
                    renderHeightField.appendText(config.getRenderHeight() + "");
                }
                }
            });
        
        setWindowsRenderRes.setOnAction(e ->{
            renderWidthField.setText("");
            renderHeightField.setText("");
            renderWidthField.appendText((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() + "");
            renderHeightField.appendText((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() + "");
        });
        
        presentWidthField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) ||
                                (NumberUtils.isParsable(newText) && Integer.parseInt(newText) < 1)){
                        presentWidthField.pseudoClassStateChanged(INVALID_INPUT, true);
                        presentWidthField.setTooltip(new Tooltip(POSITIVE_INTEGER));
                    }else if(Integer.parseInt(newText) < 1280){
                        presentWidthField.pseudoClassStateChanged(INVALID_INPUT, true);
                        presentWidthField.setTooltip(new Tooltip(INPUT_GREATER_THAN + 1280));
                    }else if(Integer.parseInt(newText) >= 1280){
                        /*if(NumberUtils.isParsable(renderWidthField.getText()) && (Integer.parseInt(newText) == Integer.parseInt(renderWidthField.getText()))){
                            presentWidthField.pseudoClassStateChanged(INVALID_INPUT, true);
                            presentWidthField.setTooltip(new Tooltip(SAME_RESOLUTIONS));
                        }else{*/
                            presentWidthField.pseudoClassStateChanged(INVALID_INPUT, false);
                            presentWidthField.setTooltip(null);
                            config.setPresentWidth(Integer.parseInt(newText));
                        //}
                    }
                    recheckTextInput(renderWidthField);
                }catch(NumberFormatException nFE){
                    config.setPresentWidth(0);
                    ui.printConsole(INPUT_TOO_LARGE);
                    presentWidthField.setText("");
                    presentWidthField.appendText(config.getPresentWidth() + "");
                }
                }
            });
        
        presentHeightField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) ||
                                (NumberUtils.isParsable(newText) && Integer.parseInt(newText) < 1)){
                        presentHeightField.pseudoClassStateChanged(INVALID_INPUT, true);
                        presentHeightField.setTooltip(new Tooltip(POSITIVE_INTEGER));
                    }else if(Integer.parseInt(newText) < 720){
                        presentHeightField.pseudoClassStateChanged(INVALID_INPUT, true);
                        presentHeightField.setTooltip(new Tooltip(INPUT_GREATER_THAN + 720));
                    }else if(Integer.parseInt(newText) >= 720){
                        /*if(NumberUtils.isParsable(renderHeightField.getText()) && (Integer.parseInt(newText) == Integer.parseInt(renderHeightField.getText()))){
                            presentHeightField.pseudoClassStateChanged(INVALID_INPUT, true);
                            presentHeightField.setTooltip(new Tooltip(SAME_RESOLUTIONS));
                        }else{*/
                            presentHeightField.pseudoClassStateChanged(INVALID_INPUT, false);
                            presentHeightField.setTooltip(null);
                            config.setPresentHeight(Integer.parseInt(newText));
                        //}
                    }
                    recheckTextInput(renderHeightField);
                }catch(NumberFormatException nFE){
                    config.setPresentHeight(0);
                    ui.printConsole(INPUT_TOO_LARGE);
                    presentHeightField.setText("");
                    presentHeightField.appendText(config.getPresentHeight() + "");
                }
                }
            });
        
        setWindowsPresentRes.setOnAction(e ->{
            presentWidthField.setText("");
            presentHeightField.setText("");
            presentWidthField.appendText((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() + "");
            presentHeightField.appendText((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() + "");
        });
        
        usePresentRes.setOnAction(e -> {
            
            presentWidthField.setDisable(false);
            presentHeightField.setDisable(false);
            setWindowsPresentRes.setDisable(false);
            presentWidthField.setText(presentRes[0]);
            presentHeightField.setText(presentRes[1]);
            recheckTextInput(presentWidthField);
            recheckTextInput(presentHeightField);
            recheckTextInput(renderWidthField);
            recheckTextInput(renderHeightField);
        });
        
        dontUsePresentRes.setOnAction(e -> {
            presentWidthField.setDisable(true);
            presentHeightField.setDisable(true);
            setWindowsPresentRes.setDisable(true);
            config.setPresentWidth(0);
            config.setPresentHeight(0);
            presentRes[0] = presentWidthField.getText();
            presentRes[1] = presentHeightField.getText();
            presentWidthField.setText(config.getPresentWidth() + "");
            presentHeightField.setText(config.getPresentHeight() + "");
            recheckTextInput(renderWidthField);
            recheckTextInput(renderHeightField);
            presentWidthField.pseudoClassStateChanged(INVALID_INPUT, false);
            presentWidthField.setTooltip(null);
            presentHeightField.pseudoClassStateChanged(INVALID_INPUT, false);
            presentHeightField.setTooltip(null);
            
        });
        
        aaQualityPicker.setOnAction(e -> {
            if(aaQualityPicker.getValue().equals(AAQUALITIES[0])){
                config.aaQuality.set(0);
                aaTypePicker.setDisable(true);
            }else{
                aaTypePicker.setDisable(false);
                config.aaQuality.set(aaQualityPicker.getItems().indexOf(aaQualityPicker.getValue()));
            }
        });
        
        aaTypePicker.setOnAction(e -> {
            config.aaType.replace(0, config.aaType.length(), aaTypePicker.getValue());
        });
        
        ssaoStrengthPicker.setOnAction(e -> {
            if(ssaoStrengthPicker.getValue().equals(SSAOSTRENGTHS[0])){
                config.ssaoStrength.set(0);
                ssaoScalePicker.setDisable(true);
                ssaoTypePicker.setDisable(true);
            }else{
                ssaoScalePicker.setDisable(false);
                ssaoTypePicker.setDisable(false);
                config.ssaoStrength.set(ssaoStrengthPicker.getItems().indexOf(ssaoStrengthPicker.getValue()));
            }
        });
        
        ssaoScalePicker.setOnAction(e -> {
            config.ssaoScale.set(ssaoScalePicker.getItems().indexOf(ssaoScalePicker.getValue()) + 1);
        });
        
        ssaoTypePicker.setOnAction(e -> {
            config.ssaoType.replace(0, config.ssaoType.length(), ssaoTypePicker.getValue());
        });
        
        //DOF Override picker is a special case with its own method
        setDOFOverrideEventHandler();
        
        dofScalingEnabled.setOnAction(e -> {
            config.disableDofScaling.set(0);
        });
        
        dofScalingDisabled.setOnAction(e -> {
            config.disableDofScaling.set(1);
        });
        
        dofAddPicker.setOnAction(e -> {
            config.dofBlurAmount.replace(0, config.dofBlurAmount.length(), DOF_ADDITIONAL_BLUR_OPTIONS[dofAddPicker.getItems().indexOf(dofAddPicker.getValue())]);
        });
        
        fpsLocked.setOnAction(e -> {
            config.unlockFPS.set(0);
            fpsLimitField.setDisable(true);
            recheckTextInput(fpsLimitField);
        });
        
        fpsUnlocked.setOnAction(e -> {
            config.unlockFPS.set(1);
            fpsLimitField.setDisable(false);
            recheckTextInput(fpsLimitField);
        });
        
        fpsFixKeyPicker.setOnAction(e -> {
            String fpsFixKeyNew = FPS_FIX_KEYS_HEX[0];
            try{
                fpsFixKeyNew = FPS_FIX_KEYS_HEX[FPS_FIX_KEYS_ARRAY_LIST.indexOf(fpsFixKeyPicker.getValue())].substring(2);
            }catch(IndexOutOfBoundsException iobEx){
                fpsFixKeyNew = FPS_FIX_KEYS_HEX[0];
            }
            setFPSFixKey(fpsFixKeyNew);
            try{
                fpsFixKey = FPS_FIX_KEYS_HEX[FPS_FIX_KEYS_ARRAY_LIST.indexOf(fpsFixKeyPicker.getValue())].substring(2);
            }catch(IndexOutOfBoundsException iobEx){
                fpsFixKey = FPS_FIX_KEYS_HEX[0];
            }
        });
        
        fpsLimitField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) || Integer.parseInt(newText) < 1){
                        fpsLimitField.pseudoClassStateChanged(INVALID_INPUT, true);
                        fpsLimitField.setTooltip(new Tooltip(POSITIVE_INTEGER));
                    }else if(Integer.parseInt(newText) > 70){
                        fpsLimitField.pseudoClassStateChanged(INVALID_INPUT, true);
                        fpsLimitField.setTooltip(new Tooltip(INPUT_FPS_TOO_HIGH));
                    }else{
                        fpsLimitField.pseudoClassStateChanged(INVALID_INPUT, false);
                        fpsLimitField.setTooltip(new Tooltip(FPS_LIMIT_LABEL.substring(0, FPS_LIMIT_LABEL.length() - 2)));
                        config.FPSlimit.set(Integer.parseInt(newText));
                    }
                }catch(NumberFormatException nFE){
                    ui.printConsole(INPUT_TOO_LARGE);
                    fpsLimitField.setText("");
                }
            }
        });
        
        fpsThresholdField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) || Integer.parseInt(newText) < 1){
                        fpsThresholdField.pseudoClassStateChanged(INVALID_INPUT, true);
                        fpsThresholdField.setTooltip(new Tooltip(POSITIVE_INTEGER));
                    }else{
                        fpsThresholdField.pseudoClassStateChanged(INVALID_INPUT, false);
                        fpsThresholdField.setTooltip(new Tooltip(FPS_LIMIT_LABEL.substring(0, FPS_LIMIT_LABEL.length() - 2)));
                        config.FPSthreshold.set(Integer.parseInt(newText));
                    }
                }catch(NumberFormatException nFE){
                    ui.printConsole(INPUT_TOO_LARGE);
                    fpsThresholdField.setText("");
                }
            }
        });
        
        texOverridePicker.setOnAction(e -> {
            config.filteringOverride.set(texOverridePicker.getItems().indexOf(texOverridePicker.getValue()));
        });
    }
    
    private void setDOFOverrideEventHandler(){
        dofOverridePicker.setOnAction(e -> {
            if(dofOverridePicker.getItems().indexOf(dofOverridePicker.getValue()) == (dofOverridePicker.getItems().size() - 1)){
                //No DOF
                /*ContinueDialog cD = new ContinueDialog(300.0, 80.0, DIALOG_TITLE_NOT_RECOMMENDED,
                                                    DIALOG_MSG_TRY_ALTERNATE_NO_DOF,
                                                    DIALOG_BUTTON_TEXTS[2], DIALOG_BUTTON_TEXTS[3]);
                
                if(cD.show()){*/
                    config.disableDOF();
                    dofScalingEnabled.setDisable(true);
                    dofScalingDisabled.setDisable(true);
                    dofAddPicker.setDisable(true);
                    presentWidthField.setDisable(true);
                    presentHeightField.setDisable(true);
                    setWindowsPresentRes.setDisable(true);
                    usePresentRes.setDisable(true);
                    dontUsePresentRes.setDisable(true);
                    dofScalingDisabled.setSelected(true);
                    dofAddPicker.setValue(dofAddPicker.getItems().get(0));
                    if(usePresentRes.isSelected()){
                        presentRes[0] = presentWidthField.getText();
                        presentRes[1] = presentHeightField.getText();
                    }
                    presentWidthField.setText("0");
                    presentHeightField.setText("0");
                    recheckTextInput(presentWidthField);
                    recheckTextInput(presentHeightField);
                    recheckTextInput(renderWidthField);
                    recheckTextInput(renderHeightField);
                /*}else{
                    
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException ex) {
                            
                            }
                            for(int i = 0; i < DOF_OVERRIDE_OPTIONS.length; i++){
                                if(config.getDOFOverride() == DOF_OVERRIDE_OPTIONS[i]){
                                    dofOverridePicker.setValue(DOFOVERRIDERESOLUTIONS[i]);
                                }
                            }
                        }
                    });
                }*/
            }else{
                config.disableDOF = false;
                dofScalingEnabled.setDisable(false);
                dofScalingDisabled.setDisable(false);
                dofAddPicker.setDisable(false);
                if(usePresentRes.isDisabled()){
                    if(usePresentRes.isSelected()){
                        presentWidthField.setDisable(false);
                        presentHeightField.setDisable(false);
                        setWindowsPresentRes.setDisable(false);
                        presentWidthField.setText("");
                        presentWidthField.appendText(presentRes[0] + "");
                        presentHeightField.setText("");
                        presentHeightField.appendText(presentRes[1] + "");
                    }
                    usePresentRes.setDisable(false);
                    dontUsePresentRes.setDisable(false);
                    recheckTextInput(presentWidthField);
                    recheckTextInput(presentHeightField);
                    recheckTextInput(renderWidthField);
                    recheckTextInput(renderHeightField);
                }
                config.setDOFOverride(DOF_OVERRIDE_OPTIONS[dofOverridePicker.getItems().indexOf(dofOverridePicker.getValue())]);
            }
        });
    }
    
    private void recheckTextInput(TextField field){
        String newText = field.getText();
        if(field.equals(renderWidthField)){
            if(!NumberUtils.isParsable(newText) ||
                    (NumberUtils.isParsable(newText) && Integer.parseInt(newText) < 1)){
                renderWidthField.pseudoClassStateChanged(INVALID_INPUT, true);
                renderWidthField.setTooltip(new Tooltip(POSITIVE_INTEGER));
            }else if(Integer.parseInt(newText) >= 1280){
                /*if(NumberUtils.isParsable(presentWidthField.getText()) && (Integer.parseInt(newText) == Integer.parseInt(presentWidthField.getText()))){
                    renderWidthField.pseudoClassStateChanged(INVALID_INPUT, true);
                    renderWidthField.setTooltip(new Tooltip(SAME_RESOLUTIONS));
                }else{*/
                    renderWidthField.pseudoClassStateChanged(INVALID_INPUT, false);
                    renderWidthField.setTooltip(new Tooltip(""));
                    config.setRenderWidth(Integer.parseInt(newText));
                    if(config.disableDOF){
                        config.setPresentWidth(Integer.parseInt(newText));
                    }
                //}
            //If input is a positive integer that is less than 1280, present width comes into play
            }else if(NumberUtils.isParsable(presentWidthField.getText()) && Integer.parseInt(presentWidthField.getText()) >= 1280){
                renderWidthField.pseudoClassStateChanged(INVALID_INPUT, false);
                renderWidthField.setTooltip(new Tooltip(""));
                config.setRenderWidth(Integer.parseInt(newText));
            }else{
                renderWidthField.pseudoClassStateChanged(INVALID_INPUT, true);
                renderWidthField.setTooltip(new Tooltip(PRES_WIDTH_TOO_LOW));
            }
        }else if(field.equals(renderHeightField)){
            if(!NumberUtils.isParsable(newText) ||
                    (NumberUtils.isParsable(newText) && Integer.parseInt(newText) < 1)){
                renderHeightField.pseudoClassStateChanged(INVALID_INPUT, true);
                renderHeightField.setTooltip(new Tooltip(POSITIVE_INTEGER));
             }else if(Integer.parseInt(newText) >= 720){
                /*if(NumberUtils.isParsable(presentHeightField.getText()) && (Integer.parseInt(newText) == Integer.parseInt(presentHeightField.getText()))){
                    renderHeightField.pseudoClassStateChanged(INVALID_INPUT, true);
                    renderHeightField.setTooltip(new Tooltip(SAME_RESOLUTIONS));
                }else{*/
                    renderHeightField.pseudoClassStateChanged(INVALID_INPUT, false);
                    renderHeightField.setTooltip(new Tooltip(""));
                    config.setRenderHeight(Integer.parseInt(newText));
                    if(config.disableDOF){
                        config.setPresentHeight(Integer.parseInt(newText));
                        config.setDOFOverride(Integer.parseInt(newText));
                    }
                //}
            //If input is a positive integer that is less than 720, present height comes into play
            }else if(NumberUtils.isParsable(presentHeightField.getText()) && Integer.parseInt(presentHeightField.getText()) >= 720){
                renderHeightField.pseudoClassStateChanged(INVALID_INPUT, false);
                renderHeightField.setTooltip(new Tooltip(""));
                config.setRenderHeight(Integer.parseInt(newText));
           }else{
                renderHeightField.pseudoClassStateChanged(INVALID_INPUT, true);
                renderHeightField.setTooltip(new Tooltip(PRES_HEIGHT_TOO_LOW));
            }
        }else if(field.equals(presentWidthField) && !presentWidthField.isDisabled()){
            if(!NumberUtils.isParsable(newText) ||
                    (NumberUtils.isParsable(newText) && Integer.parseInt(newText) < 1)){
                presentWidthField.pseudoClassStateChanged(INVALID_INPUT, true);
                presentWidthField.setTooltip(new Tooltip(POSITIVE_INTEGER));
            }else if(Integer.parseInt(newText) < 1280){
                presentWidthField.pseudoClassStateChanged(INVALID_INPUT, true);
                presentWidthField.setTooltip(new Tooltip(INPUT_GREATER_THAN + 1280));
            }else if(Integer.parseInt(newText) >= 1280){
                /*if(NumberUtils.isParsable(renderWidthField.getText()) && (Integer.parseInt(newText) == Integer.parseInt(renderWidthField.getText()))){
                    presentWidthField.pseudoClassStateChanged(INVALID_INPUT, true);
                    presentWidthField.setTooltip(new Tooltip(SAME_RESOLUTIONS));
                }else{*/
                    presentWidthField.pseudoClassStateChanged(INVALID_INPUT, false);
                    presentWidthField.setTooltip(null);
                    config.setPresentWidth(Integer.parseInt(newText));
                //}
            }
        }else if(field.equals(presentWidthField) && presentWidthField.isDisabled()){
            presentWidthField.pseudoClassStateChanged(INVALID_INPUT, false);
            presentWidthField.setTooltip(null);
        }else if(field.equals(presentHeightField) && !presentHeightField.isDisabled()){
            if(!NumberUtils.isParsable(newText) ||
                    (NumberUtils.isParsable(newText) && Integer.parseInt(newText) < 1)){
                presentHeightField.pseudoClassStateChanged(INVALID_INPUT, true);
                presentHeightField.setTooltip(new Tooltip(POSITIVE_INTEGER));
            }else if(Integer.parseInt(newText) < 720){
                presentHeightField.pseudoClassStateChanged(INVALID_INPUT, true);
                presentHeightField.setTooltip(new Tooltip(INPUT_GREATER_THAN + 720));
            }else if(Integer.parseInt(newText) >= 720){
                /*if(NumberUtils.isParsable(renderHeightField.getText()) && (Integer.parseInt(newText) == Integer.parseInt(renderHeightField.getText()))){
                    presentHeightField.pseudoClassStateChanged(INVALID_INPUT, true);
                    presentHeightField.setTooltip(new Tooltip(SAME_RESOLUTIONS));
                }else{*/
                    presentHeightField.pseudoClassStateChanged(INVALID_INPUT, false);
                    presentHeightField.setTooltip(null);
                    config.setPresentHeight(Integer.parseInt(newText));
                //}
            }
        }else if(field.equals(presentHeightField) && presentHeightField.isDisabled()){
            presentHeightField.pseudoClassStateChanged(INVALID_INPUT, false);
            presentHeightField.setTooltip(null);
        }else if(field.equals(fpsLimitField) && !fpsLimitField.isDisabled()){
            if(!NumberUtils.isParsable(newText) || Integer.parseInt(newText) < 1){
                fpsLimitField.pseudoClassStateChanged(INVALID_INPUT, true);
                fpsLimitField.setTooltip(new Tooltip(POSITIVE_INTEGER));
            }else if(Integer.parseInt(newText) > 70){
                fpsLimitField.pseudoClassStateChanged(INVALID_INPUT, true);
                fpsLimitField.setTooltip(new Tooltip(INPUT_FPS_TOO_HIGH));
            }else{
                fpsLimitField.pseudoClassStateChanged(INVALID_INPUT, false);
                fpsLimitField.setTooltip(new Tooltip(FPS_LIMIT_LABEL.substring(0, FPS_LIMIT_LABEL.length() - 2)));
                config.FPSlimit.set(Integer.parseInt(newText));
            }
        }else if(field.equals(fpsLimitField) && fpsLimitField.isDisabled()){
            fpsLimitField.pseudoClassStateChanged(INVALID_INPUT, false);
            fpsLimitField.setTooltip(new Tooltip(""));
        }
    }
    
    public boolean hasInvalidInputs(){
        ArrayList<TextField> fields = new ArrayList();
        
        fields.add(fpsLimitField);
        fields.add(fpsThresholdField);
        fields.add(renderWidthField);
        fields.add(renderHeightField);
        fields.add(presentWidthField);
        fields.add(presentHeightField);
        
        for(TextField field : fields){
            if(field.getPseudoClassStates().toString().contains("invalid")){
                return true;
            }
        }
        
        return false;
    }
    
    private void recheckTextInputUnsafe(TextField field){
        String text = field.getText();
        field.setText("");
        field.appendText(text);
    }
    
    private String getFPSFixKey(){
        
        File fpsFixCfg = new File(ui.getDataFolder() + "\\" + FPS_FIX_FILES[1]);
        
        if(fpsFixCfg.exists()){
            try {
                Scanner fpsFixKeyScanner = new Scanner(fpsFixCfg);
                
                while(fpsFixKeyScanner.hasNextLine()){
                    String line = fpsFixKeyScanner.nextLine();
                    if(line.startsWith("Key=")){
                        fpsFixKeyScanner.close();
                        return line.substring(line.indexOf("Key=") + 4);
                    }
                }
            } catch (FileNotFoundException ex) {
                //Logger.getLogger(DSFGraphicsPane.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }else{
            return null;
        }
        
        return null;
    }
    
    public void setFPSFixKey(String newFPSFixKey){
        try {
            String fpsFixCfg = readTextFile(ui.getDataFolder() + "\\" + FPS_FIX_FILES[1]);
            
            ui.printConsole(WRITING_FILE[0] + FPS_FIX_FILES[1] + "...");
            //The file to be written
            File writeFile = new File(ui.getDataFolder() + "\\" + FPS_FIX_FILES[1]);
            if(writeFile.exists()){
                //If file exists, try to delete it
                if(!writeFile.delete()){
                    //If file cannot be deleted, throw OIOException
                    throw new IIOException("Could not delete pre-existing file: " +
                        FPS_FIX_FILES[1]);
                }
            }

            //Format each linebreak to be displayed correctly in a text file
            String formattedText = fpsFixCfg.replaceAll("\n", String.format("%n"));
            //Initialize BufferedWriter to write string to file
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(writeFile));
            //Write the file
            Scanner scanner = new Scanner(formattedText);
            int i = 0;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.startsWith("Key=")){
                    fileWriter.write("Key=" + newFPSFixKey);
                    fileWriter.newLine();
                    i++;
                }else if(line.length() > 1){
                    fileWriter.write(line);
                    fileWriter.newLine();
                    i++;
                }else if(i == 2 || i == 4){
                    fileWriter.newLine();
                    i++;
                }
            }
            fileWriter.close();
            scanner.close();
            
            ui.printConsole(WRITING_FILE[1]);
        } catch (IOException ex) {
            ui.printConsole(FILES_EDITED_ERR[0] + FPS_FIX_FILES[1]);
            fpsFixKeyPicker.setDisable(true);
        }
    }
}
