/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.view;

import static dscfgutil.DSCfgUtilConstants.APPLY_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_BUTTON_TEXTS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_MSG_RESTORE_SETTINGS;
import static dscfgutil.DSCfgUtilConstants.DIALOG_TITLE_RESET;
import static dscfgutil.DSCfgUtilConstants.DISABLE_ENABLE;
import static dscfgutil.DSCfgUtilConstants.FORCE_WINDOW_MODE_LABEL;
import static dscfgutil.DSCfgUtilConstants.FULLSCREEN_HZ_TT;
import static dscfgutil.DSCfgUtilConstants.INPUT_GREATER_THAN_EQ;
import static dscfgutil.DSCfgUtilConstants.INPUT_TOO_LARGE;
import static dscfgutil.DSCfgUtilConstants.INVALID_INPUT;
import static dscfgutil.DSCfgUtilConstants.REFRESH_RATE_LABEL;
import static dscfgutil.DSCfgUtilConstants.RESTORE_DEFAULTS;
import static dscfgutil.DSCfgUtilConstants.SETTINGS;
import static dscfgutil.DSCfgUtilConstants.UNSAFE_OPS;
import static dscfgutil.DSCfgUtilConstants.UNSAFE_TT;
import static dscfgutil.DSCfgUtilConstants.VSYNC_LABEL;
import static dscfgutil.DSCfgUtilConstants.VSYNC_TT;
import static dscfgutil.DSCfgUtilConstants.WINDOW_MODES;
import dscfgutil.configs.DSFConfiguration;
import dscfgutil.dialog.ContinueDialog;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
class DSFUnsafeSettingsPane extends ScrollPane {
    
    //Main UI Components
    GridPane primaryPane;
    ScrollBar scrollBar = null;
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
    FlowPane windowModePane;
    Label windowModeLabel;
    ToggleGroup windowModeChoice;
    RadioButton neitherWindowMode;
    RadioButton forceWindowed;
    RadioButton forceFullscreen;
    //
    FlowPane vsyncPane;
    Label vsyncLabel;
    ComboBox<String> vsyncPicker;
    //
    FlowPane refreshRatePane;
    Label refreshRateLabel;
    TextField refreshRateField;
    //
    
    //Instance Variables
    DSCfgMainUI ui;
    DSFConfiguration config;
    int tabIndex = 6;
    
    public DSFUnsafeSettingsPane(DSCfgMainUI initUI){
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
        titleLabel = new Label(UNSAFE_OPS.toUpperCase() + " " + SETTINGS.toUpperCase());
        titleLabel.getStyleClass().addAll("settings_title", "red_text");
        titleLabel.setTooltip(new Tooltip(UNSAFE_TT));
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
        //Force Window Modes
        windowModePane = new FlowPane();
        windowModePane.getStyleClass().add("settings_pane");
        windowModeLabel = new Label(FORCE_WINDOW_MODE_LABEL + "  ");
        windowModeLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        windowModeChoice = new ToggleGroup();
        neitherWindowMode = new RadioButton(WINDOW_MODES[0] + "   ");
        neitherWindowMode.setToggleGroup(windowModeChoice);
        forceWindowed = new RadioButton(WINDOW_MODES[1]);
        forceWindowed.setToggleGroup(windowModeChoice);
        forceFullscreen = new RadioButton(WINDOW_MODES[2]);
        forceFullscreen.setToggleGroup(windowModeChoice);
        if(config.forceWindowed.get() == 0 && config.forceFullscreen.get() == 0){
            neitherWindowMode.setSelected(true);
        }else if (config.forceWindowed.get() == 1){
            forceWindowed.setSelected(true);
            config.forceFullscreen.set(0);
        }else{
            forceFullscreen.setSelected(true);
        }
        windowModePane.getChildren().addAll(windowModeLabel, neitherWindowMode,
                                            forceWindowed, forceFullscreen);
        //
        //Toggle Vsync
        vsyncPane = new FlowPane();
        vsyncPane.getStyleClass().add("settings_pane");
        vsyncLabel = new Label(VSYNC_LABEL + "  ");
        vsyncLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        vsyncLabel.setTooltip(new Tooltip(VSYNC_TT));
        vsyncPicker = new ComboBox<String>(FXCollections.observableArrayList(DISABLE_ENABLE));
        if(config.enableVsync.get() == 0){
            vsyncPicker.setValue(vsyncPicker.getItems().get(0));
        }else{
            vsyncPicker.setValue(vsyncPicker.getItems().get(1));
        }
        vsyncPane.getChildren().addAll(vsyncLabel, vsyncPicker);
        //
        //Fullscreen Refresh Rate
        refreshRatePane = new FlowPane();
        refreshRatePane.getStyleClass().add("settings_pane");
        refreshRateLabel = new Label(REFRESH_RATE_LABEL + " ");
        refreshRateLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        refreshRateLabel.setTooltip(new Tooltip(FULLSCREEN_HZ_TT));
        refreshRateField = new TextField("" + config.fullscreenHz.get());
        refreshRateField.getStyleClass().add("settings_text_field");
        refreshRatePane.getChildren().addAll(refreshRateLabel, refreshRateField);
        //
        
        primaryVBox.getChildren().addAll(titleBar, restoreDefaultsBar, spacerHBox,
                                        windowModePane, vsyncPane, refreshRatePane,
                                        bottomSpacerHBox);
        initializeEventHandlers();
        
        this.setContent(primaryPane);
        
        ui.scrollbarWidth = getScrollbarWidth();
    	ui.updateStatusBarShadow();
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
               config.restoreDefaultUnsafeOptions(); 
               ui.refreshUI();
           }
        });
        
        neitherWindowMode.setOnAction(e -> {
           config.forceFullscreen.set(0);
           config.forceWindowed.set(0);
        });
        
        forceFullscreen.setOnAction(e -> {
           config.forceFullscreen.set(1);
           config.forceWindowed.set(0);
        });
        
        forceWindowed.setOnAction(e -> {
           config.forceFullscreen.set(0);
           config.forceWindowed.set(1);
        });
        
        vsyncPicker.setOnAction(e -> {
            if(vsyncPicker.getValue().equals(DISABLE_ENABLE[0])){
                config.enableVsync.set(0);
            }else{
                config.enableVsync.set(1);
            }
        });
        
        refreshRateField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) || Integer.parseInt(newText) < 1){
                        refreshRateField.pseudoClassStateChanged(INVALID_INPUT, true);
                        refreshRateField.setTooltip(new Tooltip(INPUT_GREATER_THAN_EQ + "1"));
                    }else{
                        refreshRateField.pseudoClassStateChanged(INVALID_INPUT, false);
                        refreshRateField.setTooltip(new Tooltip(""));
                        config.fullscreenHz.set(Integer.parseInt(newText));
                    }
                }catch(NumberFormatException nFE){
                    ui.printConsole(INPUT_TOO_LARGE);
                    refreshRateField.setText("");
                }
            }
        });
        
        // Check for ScrollBar being added to the pane
        this.getChildren().addListener( new ListChangeListener<Node>() {
    		@Override
    		public void onChanged(javafx.collections.ListChangeListener.Change<? extends Node> newNodes) {
    			// With help from: https://stackoverflow.com/questions/24810197/how-to-know-if-a-scroll-bar-is-visible-on-a-javafx-tableview
    			if(scrollBar == null){
    				for(Node node : newNodes.getList()){
    					if (node instanceof ScrollBar) {
    		                if (((ScrollBar)node).getOrientation().equals(Orientation.VERTICAL)) {
    		                	scrollBar = (ScrollBar)node;
    		                	scrollBar.setStyle("-fx-border-color: #bfbfbf; -fx-border-thickness: 1;");
    		                	
    		                	scrollBar.visibleProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
    		                		if(ui.getCurrentTab() == tabIndex){
    		                			ui.scrollbarWidth = getScrollbarWidth();
        		                		ui.updateStatusBarShadow();
    		                		}
    		                		
    		                	});
    		                	
    		                	if(ui.getCurrentTab() == tabIndex){
		                			ui.scrollbarWidth = getScrollbarWidth();
    		                		ui.updateStatusBarShadow();
		                		}
    		                }
    		            }
    				}
    			}
    		}
        });
    }
    
    public boolean hasInvalidInputs(){
        
        if(refreshRateField.getPseudoClassStates().toString().contains("invalid")){
            return true;
        }
        
        return false;
    }
    
    public double getScrollbarWidth() {
    	if(this.scrollBar == null || !this.scrollBar.isVisible())
    		return 0.0;
    	else
    		return this.scrollBar.getWidth() - 4.0;
    }
}
