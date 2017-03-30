/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil.view;

import static dscfgutil.DSCfgUtilConstants.ADDITIONAL_TEX_MODS_FOLDER;
import static dscfgutil.DSCfgUtilConstants.ALL_AURAS_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.ANOR_LONDO_DISTANCE_LABEL;
import static dscfgutil.DSCfgUtilConstants.ANOR_LONDO_DISTANT_LANDSCAPE_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.ANOR_LONDO_HD_DISTANCE_TEX_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.ARROW_BUTTON;
import static dscfgutil.DSCfgUtilConstants.ARROW_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.ARROW_MOD_LABEL;
import static dscfgutil.DSCfgUtilConstants.AURAS_MOD_LABEL;
import static dscfgutil.DSCfgUtilConstants.BANDAI_SPLASH_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.BANDAI_SPLASH_MOD_LABEL;
import static dscfgutil.DSCfgUtilConstants.BLACK_SPLASH_BUTTON;
import static dscfgutil.DSCfgUtilConstants.BLACK_SPLASH_BUTTON_TT;
import static dscfgutil.DSCfgUtilConstants.BLACK_SPLASH_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.BUTTONS_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.BUTTON_ICON_MODS_LABEL;
import static dscfgutil.DSCfgUtilConstants.COLORBLIND_HEALTH_BAR_BUTTON;
import static dscfgutil.DSCfgUtilConstants.COLORBLIND_HEALTH_BAR_REVAMPED_XHAIR_BUTTON;
import static dscfgutil.DSCfgUtilConstants.DEFAULT_HEALTH_BAR_REVAMPED_XHAIR_BUTTON;
import static dscfgutil.DSCfgUtilConstants.FACE_MODS_LABEL;
import static dscfgutil.DSCfgUtilConstants.FACE_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.FACE_REVAMP_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.FILES_DIR;
import static dscfgutil.DSCfgUtilConstants.FONTS_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.FONT_MODS_LABEL;
import static dscfgutil.DSCfgUtilConstants.HD_ANOR_LONDO_DISTANCE_TEX_BUTTON;
import static dscfgutil.DSCfgUtilConstants.HD_FONT_BUTTON;
import static dscfgutil.DSCfgUtilConstants.HD_MESSAGES_BUTTON;
import static dscfgutil.DSCfgUtilConstants.HD_MESSAGES_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.HD_PAINTING_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.HD_PAINTING_TEX_BUTTON;
import static dscfgutil.DSCfgUtilConstants.HD_PAINTING_TEX_BUTTON_TT;
import static dscfgutil.DSCfgUtilConstants.HD_SIGNS_BUTTON;
import static dscfgutil.DSCfgUtilConstants.HD_SIGNS_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.HEALTH_BAR_MODS_LABEL;
import static dscfgutil.DSCfgUtilConstants.HEALTH_BAR_MODS_LABEL_TT;
import static dscfgutil.DSCfgUtilConstants.HEALTH_BAR_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.HIGH_VIS_HEALTH_BAR_BUTTON;
import static dscfgutil.DSCfgUtilConstants.HIGH_VIS_HEALTH_BAR_REVAMPED_XHAIR_BUTTON;
import static dscfgutil.DSCfgUtilConstants.HIRES_FONTS_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.KBM_BUTTONS_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.KBM_ICONS_BUTTON;
import static dscfgutil.DSCfgUtilConstants.KBM_ICONS_BUTTON_TT;
import static dscfgutil.DSCfgUtilConstants.MESSAGES_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.NO_AURAS_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.PAINTING_LABEL;
import static dscfgutil.DSCfgUtilConstants.PAINTING_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.PS3_BUTTONS_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.PS3_ICONS_BUTTON;
import static dscfgutil.DSCfgUtilConstants.PS4_BUTTONS_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.PS4_ICONS_BUTTON;
import static dscfgutil.DSCfgUtilConstants.QUIVER_BUTTON;
import static dscfgutil.DSCfgUtilConstants.QUIVER_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.REMOVE_AURAS_BUTTON;
import static dscfgutil.DSCfgUtilConstants.REVAMPED_ARROWS_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.REVAMPED_FACES_BUTTON;
import static dscfgutil.DSCfgUtilConstants.REVAMPED_QUIVER_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.REVAMPED_STAT_ICON_BUTTON;
import static dscfgutil.DSCfgUtilConstants.REVAMPED_STAT_ICON_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.REVAMPED_XHAIR_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.SIGNS_MODS_LABEL;
import static dscfgutil.DSCfgUtilConstants.SIGNS_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.STAT_ICON_MODS_LABEL;
import static dscfgutil.DSCfgUtilConstants.STAT_ICON_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.TEXTURE_MODS;
import static dscfgutil.DSCfgUtilConstants.TEXTURE_MODS_FOLDER;
import static dscfgutil.DSCfgUtilConstants.TEX_MOD_DISCLAIMER;
import static dscfgutil.DSCfgUtilConstants.THIEF_MASK_FIX_BUTTON;
import static dscfgutil.DSCfgUtilConstants.THIEF_MASK_FIX_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.THIEF_MASK_MODS_LABEL;
import static dscfgutil.DSCfgUtilConstants.THIEF_MASK_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.TREE_LOD_FIX_BUTTON;
import static dscfgutil.DSCfgUtilConstants.TREE_LOD_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.TREE_LOD_TEXTURE_MODS_TT;
import static dscfgutil.DSCfgUtilConstants.TREE_MOD_FILES;
import static dscfgutil.DSCfgUtilConstants.TREE_TEXTURE_MODS_LABEL;
import static dscfgutil.DSCfgUtilConstants.UHD_FONT_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UHD_FONT_BUTTON_TT;
import static dscfgutil.DSCfgUtilConstants.UHD_PAINTING_TEX_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UHD_PAINTING_TEX_BUTTON_TT;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_ANOR_LONDO_DISTANCE_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_ARROW_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_AURA_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_BUTTON_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_FACE_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_FONT_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_HEALTH_BAR_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_HEALTH_BAR_MOD_BUTTON_TT;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_PAINTING_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_SIGNS_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_SPLASH_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_STAT_ICON_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_THIEF_MASK_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.UNINSTALL_TREES_MOD_BUTTON;
import static dscfgutil.DSCfgUtilConstants.VISIBLE_HEALTH_BAR_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.XB1_BUTTONS_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.XB1_ICONS_BUTTON;
import static dscfgutil.DSCfgUtilConstants.XB360_BUTTONS_MOD_FOLDER;
import static dscfgutil.DSCfgUtilConstants.XB360_ICONS_BUTTON;
import dscfgutil.configs.DSFConfiguration;
import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
public class DSFTextureModPane extends ScrollPane{
    
    //Main UI Components
    GridPane primaryPane;
    ColumnConstraints spacerColumn;
    ColumnConstraints primaryColumn;
    VBox primaryVBox;
    HBox titleBar;
    Label titleLabel;
    HBox restoreDefaultsBar;
    Label disclaimerLabel;
    public Button applySettingsButton;
    Button restoreDefaultsButton;
    HBox spacerHBox;
    HBox bottomSpacerHBox;
    //
    //Settings components
    //
    FlowPane buttonIconsPane;
    Label buttonIconsLabel;
    Button uninstallButtonIconsModButton;
    Button xb360Button;
    Button xb1Button;
    Button ps3Button;
    Button ps4Button;
    Button kbmButton;
    //
    FlowPane fontPane;
    Label fontLabel;
    Button uninstallFontModButton;
    Button hdFontsButton;
    Button uhdFontsButton;
    //
    VBox healthBarVBox;
    FlowPane healthBarLabelPane;
    Label healthBarLabel;
    FlowPane healthBarPane1;
    Button uninstallHealthBarModButton;
    Button highVisHealthBarButton;
    Button colorBlindHealthBarButton;
    FlowPane healthBarPane2;
    Button newXHairButton;
    Button newXHairHighVisHealthBarButton;
    Button newXHairColorBlindHealthBarButton;
    //
    FlowPane statIconPane;
    Label statIconLabel;
    Button uninstallStatIconModButton;
    Button revampedStatIconButton;
    //
    FlowPane thiefMaskPane;
    Label thiefMaskLabel;
    Button uninstallThiefMaskModButton;
    Button thiefMaskFixButton;
    //
    FlowPane treeLODPane;
    Label treeLODLabel;
    Button uninstallTreeLODModButton;
    Button treeLODFixButton;
    //
    FlowPane signsPane;
    Label signsLabel;
    Button uninstallSignsModButton;
    Button hdMessagesButton;
    Button hdSignsButton;
    //
    FlowPane facePane;
    Label faceLabel;
    Button uninstallFaceModButton;
    Button revampedFacesButton;
    //
    FlowPane anorLondoDistancePane;
    Label anorLondoDistanceLabel;
    Button uninstallAnorLondoDistanceModButton;
    Button hdAnorLondoDistanceButton;
    //
    FlowPane paintingPane;
    Label paintingLabel;
    Button uninstallPaintingModButton;
    Button hdPaintingButton;
    Button uhdPaintingButton;
    //
    FlowPane arrowPane;
    Label arrowLabel;
    Button uninstallArrowModButton;
    Button arrowButton;
    Button quiverButton;
    //
    FlowPane splashPane;
    Label splashLabel;
    Button uninstallSplashModButton;
    Button blackSplashButton;
    //
    FlowPane auraPane;
    Label auraLabel;
    Button uninstallAuraModButton;
    Button noAuraButton;
    //
    
    //Instance Variables
    DSCfgMainUI ui;
    DSFConfiguration config;
    
     public DSFTextureModPane(DSCfgMainUI initUI){
        ui = initUI;
        config = ui.getConfig();
        initialize();
    }
    
    //Build the pane
    public void initialize(){
        
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
        titleLabel = new Label(TEXTURE_MODS.toUpperCase());
        titleLabel.getStyleClass().add("settings_title");
        titleBar = new HBox();
        titleBar.setAlignment(Pos.CENTER);
        titleBar.getChildren().add(titleLabel);
        restoreDefaultsBar = new HBox();
        restoreDefaultsBar.setAlignment(Pos.CENTER);
        restoreDefaultsBar.setSpacing(5.0);
        disclaimerLabel = new Label(TEX_MOD_DISCLAIMER);
        restoreDefaultsBar.getChildren().add(disclaimerLabel);
        //applySettingsButton = new Button(APPLY_SETTINGS);
        //restoreDefaultsButton = new Button(RESTORE_DEFAULTS);
        //applySettingsButton.getStyleClass().add("translate_y_4");
        //restoreDefaultsButton.getStyleClass().add("translate_y_4");
        //restoreDefaultsBar.getChildren().addAll(applySettingsButton, restoreDefaultsButton);
        spacerHBox = new HBox();
        spacerHBox.setMinHeight(10.0);
        bottomSpacerHBox = new HBox();
        bottomSpacerHBox.setMinHeight(10.0);
        
        //Settings Panes
        buttonIconsPane = new FlowPane();
        buttonIconsPane.getStyleClass().add("settings_pane");
        buttonIconsLabel = new Label(BUTTON_ICON_MODS_LABEL + "  ");
        buttonIconsLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        uninstallButtonIconsModButton = new Button(UNINSTALL_BUTTON_MOD_BUTTON);
        xb360Button = new Button(XB360_ICONS_BUTTON);
        xb1Button = new Button(XB1_ICONS_BUTTON);
        ps3Button = new Button(PS3_ICONS_BUTTON);
        ps4Button = new Button(PS4_ICONS_BUTTON);
        kbmButton = new Button(KBM_ICONS_BUTTON);
        kbmButton.setTooltip(new Tooltip(KBM_ICONS_BUTTON_TT));
        buttonIconsPane.getChildren().addAll(buttonIconsLabel, uninstallButtonIconsModButton,
                xb360Button, xb1Button, ps3Button, ps4Button, kbmButton);
        //
        fontPane = new FlowPane();
        fontPane.getStyleClass().add("settings_pane");
        fontLabel = new Label(FONT_MODS_LABEL + "  ");
        fontLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        uninstallFontModButton = new Button(UNINSTALL_FONT_MOD_BUTTON);
        hdFontsButton = new Button(HD_FONT_BUTTON);
        uhdFontsButton = new Button(UHD_FONT_BUTTON);
        uhdFontsButton.setTooltip(new Tooltip(UHD_FONT_BUTTON_TT));
        fontPane.getChildren().addAll(fontLabel, uninstallFontModButton,
                                    hdFontsButton, uhdFontsButton);
        //
        healthBarVBox = new VBox();
        healthBarVBox.getStyleClass().add("spacing_2");
        healthBarLabelPane = new FlowPane();
        healthBarLabelPane.getStyleClass().add("settings_pane");
        healthBarLabel = new Label(HEALTH_BAR_MODS_LABEL + "  ");
        healthBarLabel.setTooltip(new Tooltip(HEALTH_BAR_MODS_LABEL_TT));
        healthBarLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        healthBarLabelPane.getChildren().add(healthBarLabel);
        healthBarPane1 = new FlowPane();
        healthBarPane1.getStyleClass().add("settings_pane");
        uninstallHealthBarModButton = new Button(UNINSTALL_HEALTH_BAR_MOD_BUTTON);
        uninstallHealthBarModButton.setTooltip(new Tooltip(UNINSTALL_HEALTH_BAR_MOD_BUTTON_TT));
        highVisHealthBarButton = new Button(HIGH_VIS_HEALTH_BAR_BUTTON);
        colorBlindHealthBarButton = new Button(COLORBLIND_HEALTH_BAR_BUTTON);
        healthBarPane1.getChildren().addAll(uninstallHealthBarModButton,
                                    highVisHealthBarButton, colorBlindHealthBarButton);
        healthBarPane2 = new FlowPane();
        healthBarPane2.getStyleClass().add("settings_pane");
        newXHairButton = new Button(DEFAULT_HEALTH_BAR_REVAMPED_XHAIR_BUTTON);
        newXHairHighVisHealthBarButton = new Button(HIGH_VIS_HEALTH_BAR_REVAMPED_XHAIR_BUTTON);
        newXHairColorBlindHealthBarButton = new Button(COLORBLIND_HEALTH_BAR_REVAMPED_XHAIR_BUTTON);
        healthBarPane2.getChildren().addAll(newXHairButton, newXHairHighVisHealthBarButton,
                                            newXHairColorBlindHealthBarButton);
        healthBarVBox.getChildren().addAll(healthBarLabelPane, healthBarPane1,
                                                healthBarPane2);
        //
        statIconPane = new FlowPane();
        statIconPane.getStyleClass().add("settings_pane");
        statIconLabel = new Label(STAT_ICON_MODS_LABEL + "  ");
        statIconLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        uninstallStatIconModButton = new Button(UNINSTALL_STAT_ICON_MOD_BUTTON);
        revampedStatIconButton = new Button(REVAMPED_STAT_ICON_BUTTON);
        statIconPane.getChildren().addAll(statIconLabel, uninstallStatIconModButton,
                                    revampedStatIconButton);
        //
        thiefMaskPane = new FlowPane();
        thiefMaskPane.getStyleClass().add("settings_pane");
        thiefMaskLabel = new Label(THIEF_MASK_MODS_LABEL + "  ");
        thiefMaskLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        uninstallThiefMaskModButton = new Button(UNINSTALL_THIEF_MASK_MOD_BUTTON);
        thiefMaskFixButton = new Button(THIEF_MASK_FIX_BUTTON);
        thiefMaskPane.getChildren().addAll(thiefMaskLabel, uninstallThiefMaskModButton,
                                    thiefMaskFixButton);
        //
        treeLODPane = new FlowPane();
        treeLODPane.getStyleClass().add("settings_pane");
        treeLODLabel = new Label(TREE_TEXTURE_MODS_LABEL + "  ");
        treeLODLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        uninstallTreeLODModButton = new Button(UNINSTALL_TREES_MOD_BUTTON);
        treeLODFixButton = new Button(TREE_LOD_FIX_BUTTON);
        treeLODFixButton.setTooltip(new Tooltip(TREE_LOD_TEXTURE_MODS_TT));
        treeLODPane.getChildren().addAll(treeLODLabel, uninstallTreeLODModButton,
                                    treeLODFixButton);
        //
        signsPane = new FlowPane();
        signsPane.getStyleClass().add("settings_pane");
        signsLabel = new Label(SIGNS_MODS_LABEL + "  ");
        signsLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        uninstallSignsModButton = new Button(UNINSTALL_SIGNS_MOD_BUTTON);
        hdMessagesButton = new Button(HD_MESSAGES_BUTTON);
        hdSignsButton = new Button(HD_SIGNS_BUTTON);
        signsPane.getChildren().addAll(signsLabel, uninstallSignsModButton,
                                    hdMessagesButton, hdSignsButton);
        //
        facePane = new FlowPane();
        facePane.getStyleClass().add("settings_pane");
        faceLabel = new Label(FACE_MODS_LABEL + "  ");
        faceLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        uninstallFaceModButton = new Button(UNINSTALL_FACE_MOD_BUTTON);
        revampedFacesButton = new Button(REVAMPED_FACES_BUTTON);
        facePane.getChildren().addAll(faceLabel, uninstallFaceModButton,
                                    revampedFacesButton);
        //
        anorLondoDistancePane = new FlowPane();
        anorLondoDistancePane.getStyleClass().add("settings_pane");
        anorLondoDistanceLabel = new Label(ANOR_LONDO_DISTANCE_LABEL + "  ");
        anorLondoDistanceLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        uninstallAnorLondoDistanceModButton = new Button(UNINSTALL_ANOR_LONDO_DISTANCE_MOD_BUTTON);
        hdAnorLondoDistanceButton = new Button(HD_ANOR_LONDO_DISTANCE_TEX_BUTTON);
        anorLondoDistancePane.getChildren().addAll(anorLondoDistanceLabel,
                                    uninstallAnorLondoDistanceModButton,
                                    hdAnorLondoDistanceButton);
        //
        paintingPane = new FlowPane();
        paintingPane.getStyleClass().add("settings_pane");
        paintingLabel = new Label(PAINTING_LABEL + "  ");
        paintingLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        uninstallPaintingModButton = new Button(UNINSTALL_PAINTING_MOD_BUTTON);
        hdPaintingButton = new Button(HD_PAINTING_TEX_BUTTON);
        hdPaintingButton.setTooltip(new Tooltip(HD_PAINTING_TEX_BUTTON_TT));
        uhdPaintingButton = new Button(UHD_PAINTING_TEX_BUTTON);
        uhdPaintingButton.setTooltip(new Tooltip(UHD_PAINTING_TEX_BUTTON_TT));
        paintingPane.getChildren().addAll(paintingLabel, uninstallPaintingModButton,
                                    hdPaintingButton, uhdPaintingButton);
        //
        arrowPane = new FlowPane();
        arrowPane.getStyleClass().add("settings_pane");
        arrowLabel = new Label(ARROW_MOD_LABEL + "  ");
        arrowLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        uninstallArrowModButton = new Button(UNINSTALL_ARROW_MOD_BUTTON);
        arrowButton = new Button(ARROW_BUTTON);
        quiverButton = new Button(QUIVER_BUTTON);
        arrowPane.getChildren().addAll(arrowLabel, uninstallArrowModButton,
                                    arrowButton, quiverButton);
        //
        splashPane = new FlowPane();
        splashPane.getStyleClass().add("settings_pane");
        splashLabel = new Label(BANDAI_SPLASH_MOD_LABEL + "  ");
        splashLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        uninstallSplashModButton = new Button(UNINSTALL_SPLASH_MOD_BUTTON);
        blackSplashButton = new Button(BLACK_SPLASH_BUTTON);
        blackSplashButton.setTooltip(new Tooltip(BLACK_SPLASH_BUTTON_TT));
        splashPane.getChildren().addAll(splashLabel, uninstallSplashModButton,
                                    blackSplashButton);
        //
        auraPane = new FlowPane();
        auraPane.getStyleClass().add("settings_pane");
        auraLabel = new Label(AURAS_MOD_LABEL + "  ");
        auraLabel.getStyleClass().addAll("bold_text", "font_12_pt");
        uninstallAuraModButton = new Button(UNINSTALL_AURA_MOD_BUTTON);
        noAuraButton = new Button(REMOVE_AURAS_BUTTON);
        auraPane.getChildren().addAll(auraLabel, uninstallAuraModButton,
                                    noAuraButton);
        //
        
        primaryVBox.getChildren().addAll(titleBar, restoreDefaultsBar, spacerHBox,
                                        buttonIconsPane, fontPane, healthBarVBox);
        
        if(new File(FILES_DIR + TEXTURE_MODS_FOLDER + ADDITIONAL_TEX_MODS_FOLDER).exists()){
            primaryVBox.getChildren().addAll(statIconPane, thiefMaskPane, treeLODPane,
                                        signsPane, facePane, anorLondoDistancePane,
                                        paintingPane, arrowPane, auraPane, splashPane);
        }else{
            primaryVBox.getChildren().addAll(thiefMaskPane, treeLODPane,
                                        signsPane);
        }
        
        primaryVBox.getChildren().add(bottomSpacerHBox);
        initializeEventHandlers();
        
        this.setContent(primaryPane);
    }
    
    public void initializeEventHandlers(){
        
        uninstallButtonIconsModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(BUTTONS_MOD_FILES);
        });
        
        xb360Button.setOnAction(e -> {
            ui.fileController.installTextureMod(XB360_BUTTONS_MOD_FOLDER, BUTTONS_MOD_FILES, xb360Button.getText());
        });
        
        xb1Button.setOnAction(e -> {
            ui.fileController.installTextureMod(XB1_BUTTONS_MOD_FOLDER, BUTTONS_MOD_FILES, xb1Button.getText());
        });
        
        ps3Button.setOnAction(e -> {
            ui.fileController.installTextureMod(PS3_BUTTONS_MOD_FOLDER, BUTTONS_MOD_FILES, ps3Button.getText());
        });
        
        ps4Button.setOnAction(e -> {
            ui.fileController.installTextureMod(PS4_BUTTONS_MOD_FOLDER, BUTTONS_MOD_FILES, ps4Button.getText());
        });
        
        kbmButton.setOnAction(e -> {
            ui.fileController.installTextureMod(KBM_BUTTONS_MOD_FOLDER, BUTTONS_MOD_FILES, kbmButton.getText());
        });
        
        uninstallFontModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(FONTS_MOD_FILES);
        });
        
        hdFontsButton.setOnAction(e -> {
            ui.fileController.installTextureMod(HIRES_FONTS_MOD_FOLDER[0], FONTS_MOD_FILES, hdFontsButton.getText());
        });
        
        uhdFontsButton.setOnAction(e -> {
            ui.fileController.installTextureMod(HIRES_FONTS_MOD_FOLDER[1], FONTS_MOD_FILES, uhdFontsButton.getText());
        });
        
        uninstallHealthBarModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(HEALTH_BAR_MOD_FILES);
        });
        
        highVisHealthBarButton.setOnAction(e -> {
            ui.fileController.installTextureMod(VISIBLE_HEALTH_BAR_MOD_FOLDER[0], HEALTH_BAR_MOD_FILES, highVisHealthBarButton.getText());
        });
        
        colorBlindHealthBarButton.setOnAction(e -> {
            ui.fileController.installTextureMod(VISIBLE_HEALTH_BAR_MOD_FOLDER[1], HEALTH_BAR_MOD_FILES, colorBlindHealthBarButton.getText());
        });
        
        newXHairButton.setOnAction(e -> {
            ui.fileController.installTextureMod(REVAMPED_XHAIR_MOD_FOLDER[0], HEALTH_BAR_MOD_FILES, newXHairButton.getText());
        });
        
        newXHairHighVisHealthBarButton.setOnAction(e -> {
            ui.fileController.installTextureMod(REVAMPED_XHAIR_MOD_FOLDER[1], HEALTH_BAR_MOD_FILES, newXHairHighVisHealthBarButton.getText());
        });
        
        newXHairColorBlindHealthBarButton.setOnAction(e -> {
            ui.fileController.installTextureMod(REVAMPED_XHAIR_MOD_FOLDER[2], HEALTH_BAR_MOD_FILES, newXHairColorBlindHealthBarButton.getText());
        });
        
        uninstallStatIconModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(STAT_ICON_MOD_FILES);
        });
        
        revampedStatIconButton.setOnAction(e -> {
            ui.fileController.installTextureMod(REVAMPED_STAT_ICON_MOD_FOLDER, STAT_ICON_MOD_FILES, revampedStatIconButton.getText());
        });
        
        uninstallThiefMaskModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(THIEF_MASK_MOD_FILES);
        });
        
        thiefMaskFixButton.setOnAction(e -> {
            ui.fileController.installTextureMod(THIEF_MASK_FIX_MOD_FOLDER, THIEF_MASK_MOD_FILES, thiefMaskFixButton.getText());
        });
        
        uninstallTreeLODModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(TREE_MOD_FILES);
        });
        
        treeLODFixButton.setOnAction(e -> {
            ui.fileController.installTextureMod(TREE_LOD_MOD_FOLDER, TREE_MOD_FILES, treeLODFixButton.getText());
        });
        
        uninstallSignsModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(MESSAGES_MOD_FILES);
            ui.fileController.uninstallTextureMod(SIGNS_MOD_FILES);
        });
        
        hdMessagesButton.setOnAction(e -> {
            ui.fileController.installTextureMod(HD_MESSAGES_MOD_FOLDER, MESSAGES_MOD_FILES, hdMessagesButton.getText());
        });
        
        hdSignsButton.setOnAction(e -> {
            ui.fileController.installTextureMod(HD_SIGNS_MOD_FOLDER, SIGNS_MOD_FILES, hdSignsButton.getText());
        });
        
        uninstallFaceModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(FACE_MOD_FILES);
        });
        
        revampedFacesButton.setOnAction(e -> {
            ui.fileController.installTextureMod(FACE_REVAMP_MOD_FOLDER, FACE_MOD_FILES, revampedFacesButton.getText());
        });
        
        uninstallAnorLondoDistanceModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(ANOR_LONDO_DISTANT_LANDSCAPE_MOD_FILES);
        });
        
        hdAnorLondoDistanceButton.setOnAction(e -> {
            ui.fileController.installTextureMod(ANOR_LONDO_HD_DISTANCE_TEX_MOD_FOLDER,
                    ANOR_LONDO_DISTANT_LANDSCAPE_MOD_FILES, hdAnorLondoDistanceButton.getText());
        });
        
        uninstallPaintingModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(PAINTING_MOD_FILES);
        });
        
        hdPaintingButton.setOnAction(e -> {
            ui.fileController.installTextureMod(HD_PAINTING_MOD_FOLDER[0], PAINTING_MOD_FILES, hdPaintingButton.getText());
        });
        
        uhdPaintingButton.setOnAction(e -> {
            ui.fileController.installTextureMod(HD_PAINTING_MOD_FOLDER[1], PAINTING_MOD_FILES, uhdPaintingButton.getText());
        });
        
        uninstallArrowModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(ARROW_MOD_FILES);
            ui.fileController.uninstallTextureMod(QUIVER_MOD_FILES);
        });
        
        arrowButton.setOnAction(e -> {
            ui.fileController.installTextureMod(REVAMPED_ARROWS_MOD_FOLDER, ARROW_MOD_FILES, arrowButton.getText());
        });
        
        quiverButton.setOnAction(e -> {
            ui.fileController.installTextureMod(REVAMPED_QUIVER_MOD_FOLDER, QUIVER_MOD_FILES, quiverButton.getText());
        });
        
        uninstallSplashModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(BANDAI_SPLASH_MOD_FILES);
        });
        
        blackSplashButton.setOnAction(e -> {
            ui.fileController.installTextureMod(BLACK_SPLASH_MOD_FOLDER, BANDAI_SPLASH_MOD_FILES, blackSplashButton.getText());
        });
        
        uninstallAuraModButton.setOnAction(e -> {
            ui.fileController.uninstallTextureMod(ALL_AURAS_MOD_FILES);
        });
        
        noAuraButton.setOnAction(e -> {
            ui.fileController.installTextureMod(NO_AURAS_MOD_FOLDER, ALL_AURAS_MOD_FILES, noAuraButton.getText());
        });
    }
}
