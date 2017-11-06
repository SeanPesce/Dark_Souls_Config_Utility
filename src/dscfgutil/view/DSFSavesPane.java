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
import static dscfgutil.DSCfgUtilConstants.INPUT_GREATER_THAN_EQ;
import static dscfgutil.DSCfgUtilConstants.INPUT_TOO_LARGE;
import static dscfgutil.DSCfgUtilConstants.INVALID_INPUT;
import static dscfgutil.DSCfgUtilConstants.MAX_BACKUPS_LABEL;
import static dscfgutil.DSCfgUtilConstants.RESTORE_DEFAULTS;
import static dscfgutil.DSCfgUtilConstants.SAVE_BACKUP;
import static dscfgutil.DSCfgUtilConstants.SAVE_BACKUPS_INTERVAL_LABEL;
import static dscfgutil.DSCfgUtilConstants.SAVE_BACKUPS_LABEL;
import static dscfgutil.DSCfgUtilConstants.SAVE_INTERVAL_TT;
import static dscfgutil.DSCfgUtilConstants.SETTINGS;
import dscfgutil.configs.DSFConfiguration;
import dscfgutil.dialog.ContinueDialog;
import java.util.ArrayList;
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
import javafx.scene.control.ScrollBar;
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
class DSFSavesPane extends ScrollPane {
    
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
    
    //Settings components
    //
    FlowPane saveBackupsPane;
    Label saveBackupsLabel;
    ComboBox<String> saveBackupsPicker;
    //
    FlowPane saveIntervalPane;
    Label saveIntervalLabel;
    TextField saveIntervalField;
    //
    FlowPane maxSavesPane;
    Label maxSavesLabel;
    TextField maxSavesField;
    //
    
    //Instance Variables
    DSCfgMainUI ui;
    DSFConfiguration config;
    int tabIndex = 3;
    
    public DSFSavesPane(DSCfgMainUI initUI){
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
        titleLabel = new Label(SAVE_BACKUP.toUpperCase() + " " + SETTINGS.toUpperCase());
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
        //Toggle Save Backups
        saveBackupsPane = new FlowPane();
        saveBackupsPane.getStyleClass().add("settings_pane");
        saveBackupsLabel = new Label(SAVE_BACKUPS_LABEL + "  ");
        saveBackupsLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        saveBackupsPicker = new ComboBox<String>(FXCollections.observableArrayList(DISABLE_ENABLE));
        if(config.enableBackups.get() == 0){
            saveBackupsPicker.setValue(saveBackupsPicker.getItems().get(0));
        }else{
            saveBackupsPicker.setValue(saveBackupsPicker.getItems().get(1));
        }
        saveBackupsPane.getChildren().addAll(saveBackupsLabel, saveBackupsPicker);
        //
        //Save Backup Interval
        saveIntervalPane = new FlowPane();
        saveIntervalPane.getStyleClass().add("settings_pane");
        saveIntervalLabel = new Label(SAVE_BACKUPS_INTERVAL_LABEL + " ");
        saveIntervalLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        saveIntervalLabel.setTooltip(new Tooltip(SAVE_INTERVAL_TT));
        saveIntervalField = new TextField("" + config.backupInterval.get());
        saveIntervalField.getStyleClass().add("settings_text_field");
        saveIntervalPane.getChildren().addAll(saveIntervalLabel, saveIntervalField);
        //
        //Max Save Backups
        maxSavesPane = new FlowPane();
        maxSavesPane.getStyleClass().add("settings_pane");
        maxSavesLabel = new Label(MAX_BACKUPS_LABEL + " ");
        maxSavesLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        maxSavesField = new TextField("" + config.maxBackups.get());
        maxSavesField.getStyleClass().add("settings_text_field");
        maxSavesPane.getChildren().addAll(maxSavesLabel, maxSavesField);
        
        if(config.enableBackups.get() == 0){
           saveIntervalField.setDisable(true);
           maxSavesField.setDisable(true);
        }
        
        primaryVBox.getChildren().addAll(titleBar, restoreDefaultsBar, spacerHBox,
                                        saveBackupsPane, saveIntervalPane, maxSavesPane,
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
               config.restoreDefaultSaveOptions(); 
               ui.refreshUI();
           }
        });
        
        saveBackupsPicker.setOnAction(e -> {
            if(saveBackupsPicker.getValue().equals(DISABLE_ENABLE[0])){
                saveIntervalField.setDisable(true);
                maxSavesField.setDisable(true);
                config.enableBackups.set(0);
            }else{
                saveIntervalField.setDisable(false);
                maxSavesField.setDisable(false);
                config.enableBackups.set(1);
            }
        });
        
        saveIntervalField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) || Integer.parseInt(newText) < 600){
                        saveIntervalField.pseudoClassStateChanged(INVALID_INPUT, true);
                        saveIntervalField.setTooltip(new Tooltip(INPUT_GREATER_THAN_EQ + "600"));
                    }else{
                        saveIntervalField.pseudoClassStateChanged(INVALID_INPUT, false);
                        saveIntervalField.setTooltip(new Tooltip(""));
                        config.backupInterval.set(Integer.parseInt(newText));
                    }
                }catch(NumberFormatException nFE){
                    ui.printConsole(INPUT_TOO_LARGE);
                    saveIntervalField.setText("");
                }
            }
        });
        
        maxSavesField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                                               String oldText, String newText) {
                try{
                    if(!NumberUtils.isParsable(newText) || Integer.parseInt(newText) < 1){
                        maxSavesField.pseudoClassStateChanged(INVALID_INPUT, true);
                        maxSavesField.setTooltip(new Tooltip(INPUT_GREATER_THAN_EQ + "1"));
                    }else{
                        maxSavesField.pseudoClassStateChanged(INVALID_INPUT, false);
                        maxSavesField.setTooltip(new Tooltip(""));
                        config.maxBackups.set(Integer.parseInt(newText));
                    }
                }catch(NumberFormatException nFE){
                    ui.printConsole(INPUT_TOO_LARGE);
                    maxSavesField.setText("");
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
        ArrayList<TextField> fields = new ArrayList<TextField>();
        
        fields.add(saveIntervalField);
        fields.add(maxSavesField);
        
        for(TextField field : fields){
            if(field.getPseudoClassStates().toString().contains("invalid")){
                return true;
            }
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
