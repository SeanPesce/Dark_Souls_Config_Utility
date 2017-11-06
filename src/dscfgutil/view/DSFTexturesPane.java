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
import static dscfgutil.DSCfgUtilConstants.RESTORE_DEFAULTS;
import static dscfgutil.DSCfgUtilConstants.SETTINGS;
import static dscfgutil.DSCfgUtilConstants.TEXTURES;
import static dscfgutil.DSCfgUtilConstants.TEXTURE_DUMPING_LABEL;
import static dscfgutil.DSCfgUtilConstants.TEXTURE_OVERRIDE_LABEL;
import static dscfgutil.DSCfgUtilConstants.TEX_DUMP_TT;
import static dscfgutil.DSCfgUtilConstants.TEX_OVERRIDE_TT;
import dscfgutil.configs.DSFConfiguration;
import dscfgutil.dialog.ContinueDialog;
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
class DSFTexturesPane extends ScrollPane {
    
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
    FlowPane textureDumpPane;
    Label textureDumpLabel;
    ComboBox<String> textureDumpPicker;
    //
    FlowPane textureOverridePane;
    Label textureOverrideLabel;
    ComboBox<String> textureOverridePicker;
    
    //Instance Variables
    DSCfgMainUI ui;
    DSFConfiguration config;
    int tabIndex = 4;
    
    public DSFTexturesPane(DSCfgMainUI initUI){
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
        titleLabel = new Label(TEXTURES.toUpperCase().substring(0, TEXTURES.length() - 1) + " " + SETTINGS.toUpperCase());
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
        //Toggle Texture Dumping
        textureDumpPane = new FlowPane();
        textureDumpPane.getStyleClass().add("settings_pane");
        textureDumpLabel = new Label(TEXTURE_DUMPING_LABEL + "  ");
        textureDumpLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        textureDumpLabel.setTooltip(new Tooltip(TEX_DUMP_TT));
        textureDumpPicker = new ComboBox<String>(FXCollections.observableArrayList(DISABLE_ENABLE));
        if(config.enableTextureDumping.get() == 0){
            textureDumpPicker.setValue(textureDumpPicker.getItems().get(0));
        }else{
            textureDumpPicker.setValue(textureDumpPicker.getItems().get(1));
        }
        textureDumpPane.getChildren().addAll(textureDumpLabel, textureDumpPicker);
        //
        //Toggle Texture Override
        textureOverridePane = new FlowPane();
        textureOverridePane.getStyleClass().add("settings_pane");
        textureOverrideLabel = new Label(TEXTURE_OVERRIDE_LABEL + "  ");
        textureOverrideLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        textureOverrideLabel.setTooltip(new Tooltip(TEX_OVERRIDE_TT));
        textureOverridePicker = new ComboBox<String>(FXCollections.observableArrayList(DISABLE_ENABLE));
        if(config.enableTextureOverride.get() == 0){
            textureOverridePicker.setValue(textureOverridePicker.getItems().get(0));
        }else{
            textureOverridePicker.setValue(textureOverridePicker.getItems().get(1));
        }
        textureOverridePane.getChildren().addAll(textureOverrideLabel, textureOverridePicker);
        
        
        primaryVBox.getChildren().addAll(titleBar, restoreDefaultsBar, spacerHBox,
                                        textureDumpPane, textureOverridePane,
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
               config.restoreDefaultTextureOptions(); 
               ui.refreshUI();
           }
        });
        
        textureDumpPicker.setOnAction(e -> {
            if(textureDumpPicker.getValue().equals(DISABLE_ENABLE[0])){
                config.enableTextureDumping.set(0);
            }else{
                config.enableTextureDumping.set(1);
            }
        });
        
        textureOverridePicker.setOnAction(e -> {
            if(textureOverridePicker.getValue().equals(DISABLE_ENABLE[0])){
                config.enableTextureOverride.set(0);
            }else{
                config.enableTextureOverride.set(1);
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
    
    public double getScrollbarWidth() {
    	if(this.scrollBar == null || !this.scrollBar.isVisible())
    		return 0.0;
    	else
    		return this.scrollBar.getWidth() - 4.0;
    }
}
