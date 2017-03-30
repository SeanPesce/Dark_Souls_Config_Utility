/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.view;

import static dscfgutil.DSCfgUtilConstants.ABOUT_DSPW_LABEL;
import static dscfgutil.DSCfgUtilConstants.APPLY_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.BAN_LABEL;
import static dscfgutil.DSCfgUtilConstants.BLOCK_ARENA_FREEZE_LABEL;
import static dscfgutil.DSCfgUtilConstants.BLOCK_ARENA_FREEZE_TT;
import static dscfgutil.DSCfgUtilConstants.BLOCK_FREEZE_CHOICES;
import static dscfgutil.DSCfgUtilConstants.BORDERLESS_FS_LABEL;
import static dscfgutil.DSCfgUtilConstants.BORDERLESS_FS_TT;
import static dscfgutil.DSCfgUtilConstants.CANT_CHAIN_DLL_WITH_DEFAULT;
import static dscfgutil.DSCfgUtilConstants.CANT_CHAIN_DLL_WITH_DSF;
import static dscfgutil.DSCfgUtilConstants.CANT_CHAIN_DLL_WITH_DSM;
import static dscfgutil.DSCfgUtilConstants.CANT_CHAIN_DLL_WITH_SELF;
import static dscfgutil.DSCfgUtilConstants.CANT_CHAIN_DSPW_WITH_DSPW;
import static dscfgutil.DSCfgUtilConstants.CAPTURECURSOR;
import static dscfgutil.DSCfgUtilConstants.CAPTURE_CURSOR_LABEL;
import static dscfgutil.DSCfgUtilConstants.CAPTURE_CURSOR_TT;
import static dscfgutil.DSCfgUtilConstants.CHEATER_NOTIF_LABEL;
import static dscfgutil.DSCfgUtilConstants.CHEATER_NOTIF_TT;
import static dscfgutil.DSCfgUtilConstants.DATE_LABEL;
import static dscfgutil.DSCfgUtilConstants.DATE_TT;
import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_RESTORE_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_DLL;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_RESET;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_WRONG_FOLDER;
import static dscfgutil.DSCfgUtilConstants.DISABLE_CURSOR_LABEL;
import static dscfgutil.DSCfgUtilConstants.DISABLE_CURSOR_TT;
import static dscfgutil.DSCfgUtilConstants.DISABLE_ENABLE;
import static dscfgutil.DSCfgUtilConstants.DLL_CHAIN_LABEL;
import static dscfgutil.DSCfgUtilConstants.DLL_CHAIN_TOOLTIP;
import static dscfgutil.DSCfgUtilConstants.DLL_EXT_FILTER;
import static dscfgutil.DSCfgUtilConstants.DLL_MUST_BE_IN_DATA;
import static dscfgutil.DSCfgUtilConstants.DSF_FILES;
import static dscfgutil.DSCfgUtilConstants.DSM_CHAIN_BT;
import static dscfgutil.DSCfgUtilConstants.DSM_FILES;
import static dscfgutil.DSCfgUtilConstants.DSPW_DLL_CHAIN_TT;
import static dscfgutil.DSCfgUtilConstants.DSPW_FILES;
import static dscfgutil.DSCfgUtilConstants.DSPW_KEYBIND_HEX;
import static dscfgutil.DSCfgUtilConstants.DSPW_KEYBIND_NAMES;
import static dscfgutil.DSCfgUtilConstants.DSPW_SHORT;
import static dscfgutil.DSCfgUtilConstants.DSPW_TEXT_ALIGNMENT_OPTIONS;
import static dscfgutil.DSCfgUtilConstants.DS_DEFAULT_DLLS;
import static dscfgutil.DSCfgUtilConstants.ENABLE_DISABLE;
import static dscfgutil.DSCfgUtilConstants.FONT_SIZE_FIELD_TT;
import static dscfgutil.DSCfgUtilConstants.FONT_SIZE_LABEL;
import static dscfgutil.DSCfgUtilConstants.FONT_SIZE_TT;
import static dscfgutil.DSCfgUtilConstants.IGNORE_LABEL;
import static dscfgutil.DSCfgUtilConstants.INCREASE_NODES_LABEL;
import static dscfgutil.DSCfgUtilConstants.INCREASE_NODES_TT;
import static dscfgutil.DSCfgUtilConstants.INPUT_TOO_LARGE;
import static dscfgutil.DSCfgUtilConstants.INVALID_DLL;
import static dscfgutil.DSCfgUtilConstants.INVALID_INPUT;
import static dscfgutil.DSCfgUtilConstants.INVASION_NOTIF_LABEL;
import static dscfgutil.DSCfgUtilConstants.INVASION_NOTIF_TT;
import static dscfgutil.DSCfgUtilConstants.KEYBINDS_LABEL;
import static dscfgutil.DSCfgUtilConstants.NODE_COUNT_LABEL;
import static dscfgutil.DSCfgUtilConstants.NODE_COUNT_TT;
import static dscfgutil.DSCfgUtilConstants.NONE;
import static dscfgutil.DSCfgUtilConstants.NO_CHAIN_BT;
import static dscfgutil.DSCfgUtilConstants.ON_OFF;
import static dscfgutil.DSCfgUtilConstants.OVERLAY_LABEL;
import static dscfgutil.DSCfgUtilConstants.OVERLAY_TT;
import static dscfgutil.DSCfgUtilConstants.RESTORE_DEFAULTS;
import static dscfgutil.DSCfgUtilConstants.SETTINGS;
import static dscfgutil.DSCfgUtilConstants.TEXT_ALIGNMENT_LABEL;
import static dscfgutil.DSCfgUtilConstants.TEXT_ALIGNMENT_TT;
import static dscfgutil.DSCfgUtilConstants.TIME_LABEL;
import static dscfgutil.DSCfgUtilConstants.TIME_TT;
import static dscfgutil.DSCfgUtilConstants.TOGGLE_OVERLAY_LABEL;
import static dscfgutil.DSCfgUtilConstants.TRUE_FALSE;
import static dscfgutil.DSCfgUtilConstants.UPDATE_LABEL;
import static dscfgutil.DSCfgUtilConstants.UPDATE_TT;
import static dscfgutil.DSCfgUtilConstants.VERSION_LABEL;
import static dscfgutil.DSCfgUtilConstants.VERSION_TT;
import static dscfgutil.DSCfgUtilConstants.WINDOW_MOUSE;
import dscfgutil.configs.DSFConfiguration;
import dscfgutil.configs.DSPWConfiguration;
import dscfgutil.dialog.AlertDialog;
import dscfgutil.dialog.ContinueDialog;
import java.io.File;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author Sean Pesce
 */
public class DSPWPane extends ScrollPane{
    
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
    FlowPane versionBannerPane;
    Label versionBannerLabel;
    ToggleGroup versionBannerChoice;
    RadioButton versionBannerOn;
    RadioButton versionBannerOff;
    //
    FlowPane overlayPane;
    Label overlayLabel;
    ToggleGroup overlayChoice;
    RadioButton overlayOn;
    RadioButton overlayOff;
    //
    FlowPane textAlignmentPane;
    Label textAlignmentLabel;
    ToggleGroup textAlignmentChoice;
    RadioButton textAlignmentLeft;
    RadioButton textAlignmentCenter;
    RadioButton textAlignmentRight;
    //
    FlowPane invasionNotifPane;
    Label invasionNotifLabel;
    ToggleGroup invasionNotifChoice;
    RadioButton invasionNotifOn;
    RadioButton invasionNotifOff;
    //
    FlowPane cheaterNotifPane;
    Label cheaterNotifLabel;
    ToggleGroup cheaterNotifChoice;
    RadioButton cheaterNotifOn;
    RadioButton cheaterNotifOff;
    //
    FlowPane blockArenaFreezePane;
    Label blockArenaFreezeLabel;
    ToggleGroup blockArenaFreezeChoice;
    RadioButton blockArenaFreezeOn;
    RadioButton blockArenaFreezeOff;
    //
    FlowPane nodeCountPane;
    Label nodeCountLabel;
    ToggleGroup nodeCountChoice;
    RadioButton nodeCountOn;
    RadioButton nodeCountOff;
    //
    FlowPane increaseNodesPane;
    Label increaseNodesLabel;
    ToggleGroup increaseNodesChoice;
    RadioButton increaseNodesOn;
    RadioButton increaseNodesOff;
    //
    FlowPane fontSizePane;
    Label fontSizeLabel;
    TextField fontSizeField;
    //
    FlowPane datePane;
    Label dateLabel;
    ToggleGroup dateChoice;
    RadioButton dateOn;
    RadioButton dateOff;
    //
    FlowPane timePane;
    Label timeLabel;
    ToggleGroup timeChoice;
    RadioButton timeOn;
    RadioButton timeOff;
    //
    FlowPane updatePane;
    Label updateLabel;
    ToggleGroup updateChoice;
    RadioButton updateOn;
    RadioButton updateOff;
    //
    FlowPane dllChainPane;
    Label dllChainLabel;
    TextField dllChainField;
    Button dllChainButton;
    Button noChainButton;
    //
    FlowPane keybindsPane;
    Label keybindsLabel;
    //
    FlowPane banPane;
    Label banLabel;
    ComboBox<String> banPicker;
    //
    FlowPane ignorePane;
    Label ignoreLabel;
    ComboBox<String> ignorePicker;
    //
    FlowPane toggleOverlayPane;
    Label toggleOverlayLabel;
    ComboBox<String> toggleOverlayPicker;
    //
    FlowPane aboutPane;
    Label aboutLabel;
    ComboBox<String> aboutPicker;
    //
    
    //Instance Variables
    DSCfgMainUI ui;
    DSPWConfiguration config;
    ObservableList<String> keybindsHex = FXCollections.observableArrayList(DSPW_KEYBIND_HEX);
    ObservableList<String> keybinds = FXCollections.observableArrayList(DSPW_KEYBIND_NAMES);
    
    public DSPWPane(DSCfgMainUI initUI){
        ui = initUI;
        config = ui.getDSPWConfig();
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
        titleLabel = new Label(DSPW_SHORT.toUpperCase() + " " + SETTINGS.toUpperCase());
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
        //Version Banner
        versionBannerPane = new FlowPane();
        versionBannerPane.getStyleClass().add("settings_pane");
        versionBannerLabel = new Label(VERSION_LABEL);
        versionBannerLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        versionBannerLabel.setTooltip(new Tooltip(VERSION_TT));
        versionBannerChoice = new ToggleGroup();
        versionBannerOn = new RadioButton(ON_OFF[0] + "   ");
        versionBannerOn.setToggleGroup(versionBannerChoice);
        versionBannerOff = new RadioButton(ON_OFF[1]);
        versionBannerOff.setToggleGroup(versionBannerChoice);
        if(config.ShowVersionBanner.toString().equals(TRUE_FALSE[0])){
            versionBannerOn.setSelected(true);
        }else{
            versionBannerOff.setSelected(true);
        }
        versionBannerPane.getChildren().addAll(versionBannerLabel, versionBannerOn,
                                            versionBannerOff);
        //
        //Toggle Overlay
        overlayPane = new FlowPane();
        overlayPane.getStyleClass().add("settings_pane");
        overlayLabel = new Label(OVERLAY_LABEL);
        overlayLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        overlayLabel.setTooltip(new Tooltip(OVERLAY_TT));
        overlayChoice = new ToggleGroup();
        overlayOn = new RadioButton(ON_OFF[0] + "   ");
        overlayOn.setToggleGroup(overlayChoice);
        overlayOff = new RadioButton(ON_OFF[1]);
        overlayOff.setToggleGroup(overlayChoice);
        if(config.ShowOverlay.toString().equals(TRUE_FALSE[0])){
            overlayOn.setSelected(true);
        }else{
            overlayOff.setSelected(true);
        }
        overlayPane.getChildren().addAll(overlayLabel, overlayOn,
                                            overlayOff);
        //
        //Text Alignment
        textAlignmentPane = new FlowPane();
        textAlignmentPane.getStyleClass().add("settings_pane");
        textAlignmentLabel = new Label(TEXT_ALIGNMENT_LABEL);
        textAlignmentLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        textAlignmentLabel.setTooltip(new Tooltip(TEXT_ALIGNMENT_TT));
        textAlignmentChoice = new ToggleGroup();
        textAlignmentLeft = new RadioButton(DSPW_TEXT_ALIGNMENT_OPTIONS[0] + "   ");
        textAlignmentLeft.setToggleGroup(textAlignmentChoice);
        textAlignmentCenter = new RadioButton(DSPW_TEXT_ALIGNMENT_OPTIONS[1]);
        textAlignmentCenter.setToggleGroup(textAlignmentChoice);
        textAlignmentRight = new RadioButton(DSPW_TEXT_ALIGNMENT_OPTIONS[2]);
        textAlignmentRight.setToggleGroup(textAlignmentChoice);
        if(config.TextAlignment.toString().equals(DSPW_TEXT_ALIGNMENT_OPTIONS[0])){
            textAlignmentLeft.setSelected(true);
        }else if(config.TextAlignment.toString().equals(DSPW_TEXT_ALIGNMENT_OPTIONS[1])){
            textAlignmentCenter.setSelected(true);
        }else{
            textAlignmentRight.setSelected(true);
        }
        textAlignmentPane.getChildren().addAll(textAlignmentLabel, textAlignmentLeft,
                                            textAlignmentCenter, textAlignmentRight);
        //
        //Invasion Notification Sound
        invasionNotifPane = new FlowPane();
        invasionNotifPane.getStyleClass().add("settings_pane");
        invasionNotifLabel = new Label(INVASION_NOTIF_LABEL);
        invasionNotifLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        invasionNotifLabel.setTooltip(new Tooltip(INVASION_NOTIF_TT));
        invasionNotifChoice = new ToggleGroup();
        invasionNotifOn = new RadioButton(ON_OFF[0] + "   ");
        invasionNotifOn.setToggleGroup(invasionNotifChoice);
        invasionNotifOff = new RadioButton(ON_OFF[1]);
        invasionNotifOff.setToggleGroup(invasionNotifChoice);
        if(config.InvasionSoundNotification.toString().equals(TRUE_FALSE[0])){
            invasionNotifOn.setSelected(true);
        }else{
            invasionNotifOff.setSelected(true);
        }
        invasionNotifPane.getChildren().addAll(invasionNotifLabel, invasionNotifOn,
                                            invasionNotifOff);
        //
        //Cheater Notification Sound
        cheaterNotifPane = new FlowPane();
        cheaterNotifPane.getStyleClass().add("settings_pane");
        cheaterNotifLabel = new Label(CHEATER_NOTIF_LABEL);
        cheaterNotifLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        cheaterNotifLabel.setTooltip(new Tooltip(CHEATER_NOTIF_TT));
        cheaterNotifChoice = new ToggleGroup();
        cheaterNotifOn = new RadioButton(ON_OFF[0] + "   ");
        cheaterNotifOn.setToggleGroup(cheaterNotifChoice);
        cheaterNotifOff = new RadioButton(ON_OFF[1]);
        cheaterNotifOff.setToggleGroup(cheaterNotifChoice);
        if(config.CheaterSoundNotification.toString().equals(TRUE_FALSE[0])){
            cheaterNotifOn.setSelected(true);
        }else{
            cheaterNotifOff.setSelected(true);
        }
        cheaterNotifPane.getChildren().addAll(cheaterNotifLabel, cheaterNotifOn,
                                            cheaterNotifOff);
        //
        //Block Arena Freeze
        blockArenaFreezePane = new FlowPane();
        blockArenaFreezePane.getStyleClass().add("settings_pane");
        blockArenaFreezeLabel = new Label(BLOCK_ARENA_FREEZE_LABEL);
        blockArenaFreezeLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        blockArenaFreezeLabel.setTooltip(new Tooltip(BLOCK_ARENA_FREEZE_TT));
        blockArenaFreezeChoice = new ToggleGroup();
        blockArenaFreezeOn = new RadioButton(BLOCK_FREEZE_CHOICES[0] + "   ");
        blockArenaFreezeOn.setToggleGroup(blockArenaFreezeChoice);
        blockArenaFreezeOff = new RadioButton(BLOCK_FREEZE_CHOICES[1]);
        blockArenaFreezeOff.setToggleGroup(blockArenaFreezeChoice);
        if(config.BlockArenaFreeze.toString().equals(TRUE_FALSE[0])){
            blockArenaFreezeOn.setSelected(true);
        }else{
            blockArenaFreezeOff.setSelected(true);
        }
        blockArenaFreezePane.getChildren().addAll(blockArenaFreezeLabel, blockArenaFreezeOn,
                                            blockArenaFreezeOff);
        //
        //Show Node Count
        nodeCountPane = new FlowPane();
        nodeCountPane.getStyleClass().add("settings_pane");
        nodeCountLabel = new Label(NODE_COUNT_LABEL);
        nodeCountLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        nodeCountLabel.setTooltip(new Tooltip(NODE_COUNT_TT));
        nodeCountChoice = new ToggleGroup();
        nodeCountOn = new RadioButton(ON_OFF[0] + "   ");
        nodeCountOn.setToggleGroup(nodeCountChoice);
        nodeCountOff = new RadioButton(ON_OFF[1]);
        nodeCountOff.setToggleGroup(nodeCountChoice);
        if(config.ShowNodeDbCount.toString().equals(TRUE_FALSE[0])){
            nodeCountOn.setSelected(true);
        }else{
            nodeCountOff.setSelected(true);
        }
        nodeCountPane.getChildren().addAll(nodeCountLabel, nodeCountOn,
                                            nodeCountOff);
        //
        //Increase Node Limit
        increaseNodesPane = new FlowPane();
        increaseNodesPane.getStyleClass().add("settings_pane");
        increaseNodesLabel = new Label(INCREASE_NODES_LABEL);
        increaseNodesLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        increaseNodesLabel.setTooltip(new Tooltip(INCREASE_NODES_TT));
        increaseNodesChoice = new ToggleGroup();
        increaseNodesOn = new RadioButton(ON_OFF[0] + "   ");
        increaseNodesOn.setToggleGroup(increaseNodesChoice);
        increaseNodesOff = new RadioButton(ON_OFF[1]);
        increaseNodesOff.setToggleGroup(increaseNodesChoice);
        if(config.IncreaseNodeDbLimit.toString().equals(TRUE_FALSE[0])){
            increaseNodesOn.setSelected(true);
        }else{
            increaseNodesOff.setSelected(true);
        }
        increaseNodesPane.getChildren().addAll(increaseNodesLabel, increaseNodesOn,
                                            increaseNodesOff);
        //
        //Font Size
        fontSizePane = new FlowPane();
        fontSizePane.getStyleClass().add("settings_pane");
        fontSizeLabel = new Label(FONT_SIZE_LABEL + " ");
        fontSizeLabel.setTooltip(new Tooltip(FONT_SIZE_TT));
        fontSizeLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        fontSizeField = new TextField("" + config.FontSize.toString());
        fontSizeField.getStyleClass().add("settings_text_field");
        fontSizeField.setTooltip(new Tooltip(FONT_SIZE_FIELD_TT));
        fontSizePane.getChildren().addAll(fontSizeLabel, fontSizeField);
        //
        //Toggle Date
        datePane = new FlowPane();
        datePane.getStyleClass().add("settings_pane");
        dateLabel = new Label(DATE_LABEL);
        dateLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        dateLabel.setTooltip(new Tooltip(DATE_TT));
        dateChoice = new ToggleGroup();
        dateOn = new RadioButton(ON_OFF[0] + "   ");
        dateOn.setToggleGroup(dateChoice);
        dateOff = new RadioButton(ON_OFF[1]);
        dateOff.setToggleGroup(dateChoice);
        if(config.DisplayDate.toString().equals(TRUE_FALSE[0])){
            dateOn.setSelected(true);
        }else{
            dateOff.setSelected(true);
        }
        datePane.getChildren().addAll(dateLabel, dateOn,
                                            dateOff);
        //
        //Toggle Time
        timePane = new FlowPane();
        timePane.getStyleClass().add("settings_pane");
        timeLabel = new Label(TIME_LABEL);
        timeLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        timeLabel.setTooltip(new Tooltip(TIME_TT));
        timeChoice = new ToggleGroup();
        timeOn = new RadioButton(ON_OFF[0] + "   ");
        timeOn.setToggleGroup(timeChoice);
        timeOff = new RadioButton(ON_OFF[1]);
        timeOff.setToggleGroup(timeChoice);
        if(config.DisplayClock.toString().equals(TRUE_FALSE[0])){
            timeOn.setSelected(true);
        }else{
            timeOff.setSelected(true);
        }
        timePane.getChildren().addAll(timeLabel, timeOn,
                                            timeOff);
        //
        //Check for Updates
        updatePane = new FlowPane();
        updatePane.getStyleClass().add("settings_pane");
        updateLabel = new Label(UPDATE_LABEL);
        updateLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        updateLabel.setTooltip(new Tooltip(UPDATE_TT));
        updateChoice = new ToggleGroup();
        updateOn = new RadioButton(ON_OFF[0] + "   ");
        updateOn.setToggleGroup(updateChoice);
        updateOff = new RadioButton(ON_OFF[1]);
        updateOff.setToggleGroup(updateChoice);
        if(config.CheckForUpdates.toString().equals(TRUE_FALSE[0])){
            updateOn.setSelected(true);
        }else{
            updateOff.setSelected(true);
        }
        updatePane.getChildren().addAll(updateLabel, updateOn,
                                            updateOff);
        //
        //DLL Chaining
        dllChainPane = new FlowPane();
        dllChainPane.getStyleClass().add("settings_pane");
        dllChainLabel = new Label(DLL_CHAIN_LABEL + " ");
        dllChainLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        dllChainLabel.setTooltip(new Tooltip(DSPW_DLL_CHAIN_TT));
        dllChainField = new TextField();
        dllChainField.setEditable(false);
        dllChainButton = new Button("...");
        dllChainButton.setTooltip(new Tooltip(DLL_CHAIN_TOOLTIP));
        noChainButton = new Button(NO_CHAIN_BT);
        if(config.d3d9dllWrapper.toString().equals(NONE)){
            noChainButton.setDisable(true);
            dllChainField.setStyle("-fx-text-fill: gray;");
        }else{
            noChainButton.setDisable(false);
        }
        dllChainField.setText(config.d3d9dllWrapper.toString());
        dllChainPane.getChildren().addAll(dllChainLabel, dllChainField,
                                          dllChainButton, noChainButton);
        //
        //
        //
        //////////////////////////////////
        ///////////Key Bindings///////////
        //////////////////////////////////
        //
        //
        //Keybinds Parent Label
        keybindsPane = new FlowPane();
        keybindsPane.getStyleClass().add("settings_pane");
        keybindsLabel = new Label(KEYBINDS_LABEL);
        keybindsLabel.getStyleClass().addAll("bold_text", "font_14_pt");
        keybindsPane.getChildren().add(keybindsLabel);
        //
        //Ban Phantom
        banPane = new FlowPane();
        banPane.getStyleClass().add("settings_pane");
        banLabel = new Label(BAN_LABEL + "  ");
        banLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        banPicker = new ComboBox(keybinds);
        banPicker.setValue(keybinds.get(keybindsHex.indexOf(config.key_BanPhantom.toString())));
        banPane.getChildren().addAll(banLabel, banPicker);
        //
        //Ignore Phantom
        ignorePane = new FlowPane();
        ignorePane.getStyleClass().add("settings_pane");
        ignoreLabel = new Label(IGNORE_LABEL + "  ");
        ignoreLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        ignorePicker = new ComboBox(keybinds);
        ignorePicker.setValue(keybinds.get(keybindsHex.indexOf(config.key_IgnorePhantom.toString())));
        ignorePane.getChildren().addAll(ignoreLabel, ignorePicker);
        //
        //Toggle Overlay
        toggleOverlayPane = new FlowPane();
        toggleOverlayPane.getStyleClass().add("settings_pane");
        toggleOverlayLabel = new Label(TOGGLE_OVERLAY_LABEL + "  ");
        toggleOverlayLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        toggleOverlayPicker = new ComboBox(keybinds);
        toggleOverlayPicker.setValue(keybinds.get(keybindsHex.indexOf(config.key_HideOverlay.toString())));
        toggleOverlayPane.getChildren().addAll(toggleOverlayLabel, toggleOverlayPicker);
        //
        //About Dark Souls PvP Watchdog
        aboutPane = new FlowPane();
        aboutPane.getStyleClass().add("settings_pane");
        aboutLabel = new Label(ABOUT_DSPW_LABEL + "  ");
        aboutLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        aboutPicker = new ComboBox(keybinds);
        aboutPicker.setValue(keybinds.get(keybindsHex.indexOf(config.key_AboutDSPW.toString())));
        aboutPane.getChildren().addAll(aboutLabel, aboutPicker);
        
        primaryVBox.getChildren().addAll(titleBar, restoreDefaultsBar, spacerHBox,
                                        versionBannerPane, overlayPane, textAlignmentPane,
                                        invasionNotifPane, cheaterNotifPane,
                                        blockArenaFreezePane, nodeCountPane,
                                        increaseNodesPane, fontSizePane, datePane,
                                        timePane, updatePane, dllChainPane,
                                        keybindsPane, banPane, ignorePane,
                                        toggleOverlayPane, aboutPane,
                                        bottomSpacerHBox);
        
        initializeEventHandlers();
        
        this.setContent(primaryPane);
    }
    
    private void initializeEventHandlers(){
        
        applySettingsButton.setOnAction(e -> {
            ui.applyDSPWConfig();
        });
        
        restoreDefaultsButton.setOnAction(e -> {
            ContinueDialog cD = new ContinueDialog(300.0, 80.0, DIALOG_TITLE_RESET,
                                            DIALOG_MSG_RESTORE_SETTINGS,
                                            DIALOG_BUTTON_TEXTS[2],
                                            DIALOG_BUTTON_TEXTS[1]);
           if(cD.show()){
               config.restoreDefaults(); 
               ui.refreshUI();
           }
        });
        
        versionBannerOn.setOnAction(e -> {
            config.ShowVersionBanner.replace(0, config.ShowVersionBanner.length(), TRUE_FALSE[0]); 
        });
        
        versionBannerOff.setOnAction(e -> {
            config.ShowVersionBanner.replace(0, config.ShowVersionBanner.length(), TRUE_FALSE[1]); 
        });
        
        overlayOn.setOnAction(e -> {
            config.ShowOverlay.replace(0, config.ShowOverlay.length(), TRUE_FALSE[0]); 
        });
        
        overlayOff.setOnAction(e -> {
            config.ShowOverlay.replace(0, config.ShowOverlay.length(), TRUE_FALSE[1]); 
        });
        
        invasionNotifOn.setOnAction(e -> {
            config.InvasionSoundNotification.replace(0, config.InvasionSoundNotification.length(), TRUE_FALSE[0]); 
        });
        
        invasionNotifOff.setOnAction(e -> {
            config.InvasionSoundNotification.replace(0, config.InvasionSoundNotification.length(), TRUE_FALSE[1]); 
        });
        
        cheaterNotifOn.setOnAction(e -> {
            config.CheaterSoundNotification.replace(0, config.CheaterSoundNotification.length(), TRUE_FALSE[0]); 
        });
        
        cheaterNotifOff.setOnAction(e -> {
            config.CheaterSoundNotification.replace(0, config.CheaterSoundNotification.length(), TRUE_FALSE[1]); 
        });
        
        blockArenaFreezeOn.setOnAction(e -> {
            config.BlockArenaFreeze.replace(0, config.BlockArenaFreeze.length(), TRUE_FALSE[0]); 
        });
        
        blockArenaFreezeOff.setOnAction(e -> {
            config.BlockArenaFreeze.replace(0, config.BlockArenaFreeze.length(), TRUE_FALSE[1]); 
        });
        
        nodeCountOn.setOnAction(e -> {
            config.ShowNodeDbCount.replace(0, config.ShowNodeDbCount.length(), TRUE_FALSE[0]); 
        });
        
        nodeCountOff.setOnAction(e -> {
            config.ShowNodeDbCount.replace(0, config.ShowNodeDbCount.length(), TRUE_FALSE[1]); 
        });
        
        increaseNodesOn.setOnAction(e -> {
            config.IncreaseNodeDbLimit.replace(0, config.IncreaseNodeDbLimit.length(), TRUE_FALSE[0]); 
        });
        
        increaseNodesOff.setOnAction(e -> {
            config.IncreaseNodeDbLimit.replace(0, config.IncreaseNodeDbLimit.length(), TRUE_FALSE[1]); 
        });
        
        dateOn.setOnAction(e -> {
            config.DisplayDate.replace(0, config.DisplayDate.length(), TRUE_FALSE[0]); 
        });
        
        dateOff.setOnAction(e -> {
            config.DisplayDate.replace(0, config.DisplayDate.length(), TRUE_FALSE[1]); 
        });
        
        timeOn.setOnAction(e -> {
            config.DisplayClock.replace(0, config.DisplayClock.length(), TRUE_FALSE[0]); 
        });
        
        timeOff.setOnAction(e -> {
            config.DisplayClock.replace(0, config.DisplayClock.length(), TRUE_FALSE[1]); 
        });
        
        updateOn.setOnAction(e -> {
            config.CheckForUpdates.replace(0, config.CheckForUpdates.length(), TRUE_FALSE[0]); 
        });
        
        updateOff.setOnAction(e -> {
            config.CheckForUpdates.replace(0, config.CheckForUpdates.length(), TRUE_FALSE[1]); 
        });
        
        textAlignmentLeft.setOnAction(e -> {
            config.TextAlignment.replace(0, config.TextAlignment.length(), DSPW_TEXT_ALIGNMENT_OPTIONS[0]); 
        });
        
        textAlignmentCenter.setOnAction(e -> {
            config.TextAlignment.replace(0, config.TextAlignment.length(), DSPW_TEXT_ALIGNMENT_OPTIONS[1]); 
        });
        
        textAlignmentRight.setOnAction(e -> {
            config.TextAlignment.replace(0, config.TextAlignment.length(), DSPW_TEXT_ALIGNMENT_OPTIONS[2]); 
        });
        
        fontSizeField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) || Integer.parseInt(newText) > 72
                            || Integer.parseInt(newText) < 15){
                        fontSizeField.pseudoClassStateChanged(INVALID_INPUT, true);
                    }else{
                        fontSizeField.pseudoClassStateChanged(INVALID_INPUT, false);
                        config.FontSize.replace(0, config.FontSize.length(), "" + Integer.parseInt(newText));
                    }
                }catch(NumberFormatException nFE){
                    ui.printConsole(INPUT_TOO_LARGE);
                    fontSizeField.setText("");
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
                        AlertDialog aD = new AlertDialog(300.0, 80.0, INVALID_DLL,
                                                    CANT_CHAIN_DLL_WITH_DSM,
                                                        DIALOG_BUTTON_TEXTS[0]);
                    }else if(dll.getName().equals(DSF_FILES[0])){
                        AlertDialog aD = new AlertDialog(300.0, 80.0, INVALID_DLL,
                                                    CANT_CHAIN_DLL_WITH_DSF,
                                                        DIALOG_BUTTON_TEXTS[0]);
                    }else if(dll.getName().equals(DS_DEFAULT_DLLS[0]) ||
                            dll.getName().equals(DS_DEFAULT_DLLS[1]) ||
                            dll.getName().equals(DS_DEFAULT_DLLS[2])){
                        AlertDialog aD = new AlertDialog(300.0, 80.0, INVALID_DLL,
                                                    CANT_CHAIN_DLL_WITH_DEFAULT,
                                                        DIALOG_BUTTON_TEXTS[0]);
                    }else if(dll.getName().equals(DSPW_FILES[1]) ||
                            dll.getName().equals(DSPW_FILES[4]) ||
                            dll.getName().equals(DSPW_FILES[5])){
                        AlertDialog aD = new AlertDialog(300.0, 80.0, INVALID_DLL,
                                                    CANT_CHAIN_DSPW_WITH_DSPW,
                                                        DIALOG_BUTTON_TEXTS[0]);
                    }else{
                        config.d3d9dllWrapper.replace(0, config.d3d9dllWrapper.length(), dll.getName());
                        dllChainField.setText(dll.getName());
                        dllChainField.setStyle("-fx-text-fill: black;");
                        noChainButton.setDisable(false);
                    }
                }
            }
        });
        
        noChainButton.setOnAction(e -> {
            dllChainField.setText(NONE);
            noChainButton.setDisable(true);
            dllChainField.setStyle("-fx-text-fill: gray;");
            config.d3d9dllWrapper.replace(0, config.d3d9dllWrapper.length(), NONE);
        });
        
        banPicker.setOnAction(e -> {
            config.key_BanPhantom.replace(0, config.key_BanPhantom.length(),
                    keybindsHex.get(keybinds.indexOf(banPicker.getValue())));
        });
        
        ignorePicker.setOnAction(e -> {
            config.key_IgnorePhantom.replace(0, config.key_IgnorePhantom.length(),
                    keybindsHex.get(keybinds.indexOf(ignorePicker.getValue())));
        });
        
        toggleOverlayPicker.setOnAction(e -> {
            config.key_HideOverlay.replace(0, config.key_HideOverlay.length(),
                    keybindsHex.get(keybinds.indexOf(toggleOverlayPicker.getValue())));
        });
        
        aboutPicker.setOnAction(e -> {
            config.key_AboutDSPW.replace(0, config.key_AboutDSPW.length(),
                    keybindsHex.get(keybinds.indexOf(aboutPicker.getValue())));
        });
        
    }
    
    public boolean hasInvalidInputs(){
        
        if(fontSizeField.getPseudoClassStates().toString().contains("invalid")){
            return true;
        }
        
        return false;
    }
}