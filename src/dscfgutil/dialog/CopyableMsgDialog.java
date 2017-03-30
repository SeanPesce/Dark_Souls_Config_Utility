/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.dialog;

import static dscfgutil.DSCfgUtilConstants.COPY_MESSAGE;
import static dscfgutil.DSCfgUtilConstants.COPY_MSG_TOOLTIP;
import static dscfgutil.DSCfgUtilConstants.CSS_DIRECTORY;
import static dscfgutil.DSCfgUtilConstants.IMAGE_DIRECTORY;
import static dscfgutil.DSCfgUtilConstants.PROGRAM_ICON;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.NONE;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sean Pesce
 */
public class CopyableMsgDialog {
    
    Alert alert;
    Stage stage;
    DialogPane dPane;
    ColumnConstraints layoutColumn;
    GridPane layoutGridPane;
    VBox layoutVBox;
    HBox labelHBox;
    TextArea messageLabel;
    ColumnConstraints buttonsColumn;
    GridPane buttonsGrid;
    HBox buttonsPane;
    ArrayList<Button> buttons;
    CheckBox copyMsg;
    Clipboard clipboard;
    HBox copySpacer;
    
    public CopyableMsgDialog(double newW, double newH, String newTitle, String newMessage,
                          String btTxt){
        initialize(newW, newH, newTitle, newMessage,
                    "file:" + IMAGE_DIRECTORY + "\\" + PROGRAM_ICON);
        
        initializeButtons(new String[]{btTxt});
        buttonsPane.getChildren().add(0, copyMsg);
        buttonsPane.getChildren().add(1, copySpacer);
        
        initializeCancelButton(buttons.get(0));
    }
    
    
    private void initialize(double x, double y, String initDialogTitle,
                            String initMessage, String initWindowIconPath){
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
        
        messageLabel = new TextArea(initMessage);
        messageLabel.setWrapText(true);
        messageLabel.setMaxWidth(x - 20.0);
        messageLabel.setEditable(false);
        labelHBox = new HBox();
        labelHBox.getChildren().add(messageLabel);
        layoutVBox.getChildren().add(labelHBox);
        layoutGridPane.add(layoutVBox, 0, 0);
        
        dPane.setContent(layoutGridPane);
        
        //Message copying tools
        copyMsg = new CheckBox(COPY_MESSAGE);
        copyMsg.setTooltip(new Tooltip(COPY_MSG_TOOLTIP));
        copyMsg.setAllowIndeterminate(false);
        copyMsg.getStyleClass().add("translate_y_neg_4");
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        copySpacer = new HBox();
        copySpacer.setMinWidth(20.0);
        
        //Event handlers
        stage.widthProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldWidth, Number newWidth) {
                    messageLabel.setMinWidth(newWidth.doubleValue() - 60);
                    messageLabel.setMaxWidth(newWidth.doubleValue() - 55);
                    buttonsPane.setMinWidth(messageLabel.getMinWidth() - 10);
                    buttonsPane.setMaxWidth(messageLabel.getMaxWidth() - 10);
                }
            });
        
        stage.heightProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldHeight, Number newHeight) {
                    messageLabel.setMinHeight(newHeight.doubleValue() - 120);
                    messageLabel.setMaxHeight(newHeight.doubleValue() - 115);
                    
                }
            });
        
        copyMsg.setOnAction(e -> {
            if(copyMsg.isSelected()){
                clipboard.setContents(new StringSelection(messageLabel.getText()), null);
            }
        });
        
        messageLabel.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                messageLabel.setScrollTop(Integer.MAX_VALUE);
                if(copyMsg.isSelected()){
                    clipboard.setContents(new StringSelection(messageLabel.getText()), null);
                }
            }
            });
        messageLabel.appendText("");
        
        stage.setOnCloseRequest(e -> {
            close();
        });
    }
    
    private void initializeButtons(String[] btTexts){
        buttonsPane = new HBox();
        buttons = new ArrayList<>();
        buttonsColumn = new ColumnConstraints();
        buttonsColumn.setPercentWidth(100.0);
        buttonsColumn.setFillWidth(true);
        buttonsColumn.setHalignment(HPos.LEFT);
        buttonsGrid = new GridPane();
        buttonsGrid.getColumnConstraints().add(buttonsColumn);
        buttonsPane.getStyleClass().add("dialog_buttons_pane_centered");
        
        for(int i = 0; i < btTexts.length; i++){
            buttons.add(new Button());
            buttons.get(i).setText(btTexts[i]);
            buttonsPane.getChildren().add(buttons.get(i));
        }
        
        buttonsGrid.add(buttonsPane, 0, 0);
        layoutVBox.getChildren().add(buttonsGrid);
    }
    
    private void initializeCancelButton(Button cancelBT){
        cancelBT.setOnAction(e -> {
            close();
        });
    }
    
    public void show(){
        alert.showAndWait();
    }
    
    public void setMessage(String newMessage){
        messageLabel.setText(newMessage);
        messageLabel.appendText("");
        
    }
    
    public Stage getStage(){
        return stage;
    }
    
    public Alert getAlert(){
        return alert;
    }
    
    public DialogPane getDPane(){
        return dPane;
    }
    
    public TextArea getTextArea(){
        return messageLabel;
    }
    
    public void close(){
        stage.close();
        alert.close();
    }
}

