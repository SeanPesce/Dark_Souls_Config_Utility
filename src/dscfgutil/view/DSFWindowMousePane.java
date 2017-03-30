/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.view;

import static dscfgutil.DSCfgUtilConstants.APPLY_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.BORDERLESS_FS_LABEL;
import static dscfgutil.DSCfgUtilConstants.BORDERLESS_FS_TT;
import static dscfgutil.DSCfgUtilConstants.CAPTURECURSOR;
import static dscfgutil.DSCfgUtilConstants.CAPTURE_CURSOR_LABEL;
import static dscfgutil.DSCfgUtilConstants.CAPTURE_CURSOR_TT;
import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_RESTORE_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_RESET;
import static dscfgutil.DSCfgUtilConstants.DISABLE_CURSOR_LABEL;
import static dscfgutil.DSCfgUtilConstants.DISABLE_CURSOR_TT;
import static dscfgutil.DSCfgUtilConstants.DISABLE_ENABLE;
import static dscfgutil.DSCfgUtilConstants.ENABLE_DISABLE;
import static dscfgutil.DSCfgUtilConstants.RESTORE_DEFAULTS;
import static dscfgutil.DSCfgUtilConstants.SETTINGS;
import static dscfgutil.DSCfgUtilConstants.WINDOW_MOUSE;
import dscfgutil.configs.DSFConfiguration;
import dscfgutil.dialog.ContinueDialog;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Sean Pesce
 */
class DSFWindowMousePane extends ScrollPane {
    
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
    FlowPane borderlessFullscreenPane;
    Label borderlessFullscreenLabel;
    ComboBox<String> borderlessFullscreenPicker;
    //
    FlowPane disableCursorPane;
    Label disableCursorLabel;
    ComboBox<String> disableCursorPicker;
    //
    FlowPane captureCursorPane;
    Label captureCursorLabel;
    ComboBox<String> captureCursorPicker;
    //
    
    //Instance Variables
    DSCfgMainUI ui;
    DSFConfiguration config;
    
    public DSFWindowMousePane(DSCfgMainUI initUI){
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
        titleLabel = new Label(WINDOW_MOUSE.toUpperCase() + " " + SETTINGS.toUpperCase());
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
        //Borderless Fullscreen
        borderlessFullscreenPane = new FlowPane();
        borderlessFullscreenPane.getStyleClass().add("settings_pane");
        borderlessFullscreenLabel = new Label(BORDERLESS_FS_LABEL + "  ");
        borderlessFullscreenLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        borderlessFullscreenLabel.setTooltip(new Tooltip(BORDERLESS_FS_TT));
        borderlessFullscreenPicker = new ComboBox(FXCollections.observableArrayList(DISABLE_ENABLE));
        if(config.borderlessFullscreen.get() == 0){
            borderlessFullscreenPicker.setValue(borderlessFullscreenPicker.getItems().get(0));
        }else{
            borderlessFullscreenPicker.setValue(borderlessFullscreenPicker.getItems().get(1));
        }
        borderlessFullscreenPane.getChildren().addAll(borderlessFullscreenLabel,
                                                    borderlessFullscreenPicker);
        //
        //Disable Mouse Cursor
        disableCursorPane = new FlowPane();
        disableCursorPane.getStyleClass().add("settings_pane");
        disableCursorLabel = new Label(DISABLE_CURSOR_LABEL + "  ");
        disableCursorLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        disableCursorLabel.setTooltip(new Tooltip(DISABLE_CURSOR_TT));
        disableCursorPicker = new ComboBox(FXCollections.observableArrayList(ENABLE_DISABLE));
        if(config.disableCursor.get() == 0){
            disableCursorPicker.setValue(disableCursorPicker.getItems().get(0));
        }else{
            disableCursorPicker.setValue(disableCursorPicker.getItems().get(1));
        }
        disableCursorPane.getChildren().addAll(disableCursorLabel,
                                                    disableCursorPicker);
        //
        //Capture Mouse Cursor
        captureCursorPane = new FlowPane();
        captureCursorPane.getStyleClass().add("settings_pane");
        captureCursorLabel = new Label(CAPTURE_CURSOR_LABEL + "  ");
        captureCursorLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        captureCursorLabel.setTooltip(new Tooltip(CAPTURE_CURSOR_TT));
        captureCursorPicker = new ComboBox(FXCollections.observableArrayList(CAPTURECURSOR));
        if(config.captureCursor.get() == 0){
            captureCursorPicker.setValue(captureCursorPicker.getItems().get(0));
        }else{
            captureCursorPicker.setValue(captureCursorPicker.getItems().get(1));
        }
        captureCursorPane.getChildren().addAll(captureCursorLabel,
                                                    captureCursorPicker);
        
        
        primaryVBox.getChildren().addAll(titleBar, restoreDefaultsBar, spacerHBox,
                                        borderlessFullscreenPane, disableCursorPane,
                                        captureCursorPane, bottomSpacerHBox);
        
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
               config.restoreDefaultWMOptions(); 
               ui.refreshUI();
           }
        });
        
        borderlessFullscreenPicker.setOnAction(e -> {
            config.borderlessFullscreen.set(borderlessFullscreenPicker.getSelectionModel().getSelectedIndex());
        });
        
        disableCursorPicker.setOnAction(e -> {
            config.disableCursor.set(disableCursorPicker.getSelectionModel().getSelectedIndex());
        });
        
        captureCursorPicker.setOnAction(e -> {
            config.captureCursor.set(captureCursorPicker.getSelectionModel().getSelectedIndex());
        });
    }
}
