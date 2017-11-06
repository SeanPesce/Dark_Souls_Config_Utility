/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.dialog;

import static dscfgutil.DSCfgUtilConstants.CSS_DIRECTORY;
import static dscfgutil.DSCfgUtilConstants.DIALOG_NO_CHOICES;
import static dscfgutil.DSCfgUtilConstants.IMAGE_DIRECTORY;
import static dscfgutil.DSCfgUtilConstants.PROGRAM_ICON;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.NONE;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 *
 * @author Sean Pesce
 */
public class ChoiceDialog {
    
	public static final int VERTICAL_CHOICES = 0;
	public static final int HORIZONTAL_CHOICES = 1;
	
    Alert alert;
    Stage stage;
    DialogPane dPane;
    ColumnConstraints layoutColumn;
    GridPane layoutGridPane;
    VBox layoutVBox;
    HBox labelHBox;
    Label messageLabel;
    Pane choicePane = null;
    ToggleGroup choiceGroup;
    public ArrayList<RadioButton> choices;
    ColumnConstraints buttonsColumn;
    GridPane buttonsGrid;
    public HBox buttonsPane;
    public ArrayList<Button> buttons;
    
    int choice = -1;
    
    
    
    public ChoiceDialog(double newW, double newH, String newTitle, String newMessage,
                          String[] newChoices, String continueTxt, String cancelTxt,
                          int choicesLayout){
        initialize(newW, newH, newTitle, newMessage, newChoices,
                    "file:" + IMAGE_DIRECTORY + "\\" + PROGRAM_ICON);
        
        initializeChoices(newChoices, choicesLayout);
        
        initializeButtons(new String[]{continueTxt, cancelTxt});
        
        initializeOKButton(buttons.get(0));
        initializeCancelButton(buttons.get(1));
        
    }
    
    public int show(){
        alert.showAndWait();
        
        return choice;
    }
    
    private void initialize(double x, double y, String initDialogTitle, String initMessage,
    		 				String[] initChoices, String initWindowIconPath){
        alert = new Alert(NONE);
        alert.setResizable(false);
        stage = (Stage)alert.getDialogPane().getScene().getWindow();
        stage.getScene().getStylesheets().add(getClass().getResource(
                                               CSS_DIRECTORY).toExternalForm());
        
        stage.getIcons().add(new Image(initWindowIconPath));
        stage.setTitle(initDialogTitle);
        dPane = alert.getDialogPane();
        dPane.setMinWidth(x);
        dPane.setMinHeight(y);
        
        layoutGridPane = new GridPane();
        layoutColumn = new ColumnConstraints();
        layoutColumn.setPercentWidth(100.0);
        layoutColumn.setFillWidth(true);
        layoutGridPane.getColumnConstraints().add(layoutColumn);
        
        layoutVBox = new VBox();
        layoutVBox.setSpacing(10.0);
        
        messageLabel = new Label(initMessage);
        messageLabel.setWrapText(true);
        messageLabel.setMaxWidth(x - 20.0);
        labelHBox = new HBox();
        labelHBox.getChildren().add(messageLabel);
        layoutVBox.getChildren().add(labelHBox);
        layoutGridPane.add(layoutVBox, 0, 0);
        
        dPane.setContent(layoutGridPane);
        
        stage.setOnCloseRequest(e -> {
            choice = -1;
            close();
        });
    }
    
    private void initializeChoices(String[] newChoices, int newLayout){
    	if(newLayout == HORIZONTAL_CHOICES){
    		choicePane = new FlowPane();
    		((FlowPane)choicePane).setHgap(10.0);
    	}
    	else{
    		choicePane = new VBox();
    		((VBox)choicePane).setSpacing(5.0);
    	}
    	choicePane.setStyle("-fx-translate-y: 10;");
    	
    	choiceGroup = new ToggleGroup();
    	choices = new ArrayList<RadioButton>();
    	
    	for(String c : newChoices){
    		RadioButton rb = new RadioButton(c);
    		rb.setToggleGroup(choiceGroup);
    		choices.add(rb);
    		if(choices.size() == 1)
    			rb.setSelected(true);
    	}
    	
    	if(choices.size() > 0)
    		choice = 0;
    	else
    		choicePane.getChildren().add(new Label(DIALOG_NO_CHOICES));
    	
    	for(int i = 0; i < choices.size(); i++){
    		RadioButton rb = choices.get(i);
    		final int index = i;
    		rb.selectedProperty().addListener(new ChangeListener<Boolean>() {
    		    @Override
    		    public void changed(ObservableValue<? extends Boolean> obs, Boolean prevSelectionState, Boolean isSelected) {
    		        if (isSelected) { 
    		            choice = index;
    		        }
    		    }
    		});
    		
    		choicePane.getChildren().add(rb);
    	}
    	
    	layoutVBox.getChildren().add(choicePane);
    }
    
    private void initializeButtons(String[] btTexts){
        buttonsPane = new HBox();
        buttons = new ArrayList<>();
        buttonsColumn = new ColumnConstraints();
        buttonsColumn.setPercentWidth(100.0);
        buttonsColumn.setFillWidth(true);
        buttonsColumn.setHalignment(HPos.RIGHT);
        buttonsGrid = new GridPane();
        buttonsGrid.getColumnConstraints().add(buttonsColumn);
        buttonsPane.getStyleClass().add("dialog_buttons_pane");
        buttonsPane.setSpacing(5.0);
        
        for(int i = 0; i < btTexts.length; i++){
            buttons.add(new Button());
            buttons.get(i).setText(btTexts[i]);
            buttonsPane.getChildren().add(buttons.get(i));
            if(i == 0 && choice < 0)
            	buttons.get(i).setDisable(true);
        }
        
        buttonsGrid.add(buttonsPane, 0, 0);
        layoutVBox.getChildren().add(buttonsGrid);
    }
    
    private void initializeCancelButton(Button cancelBT){
        cancelBT.setOnAction(e -> {
            choice = -1;
            close();
        });
    }
    
    private void initializeOKButton(Button okBT){
        okBT.setOnAction(e -> {
            close();
        });
    }
    
    private void close(){
        stage.close();
        alert.close();
    }
}

