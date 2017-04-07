/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;

/**
 *
 * @author Sean Pesce
 */
public class DSCfgUtilConstants {
    
    //Titles, Authors, and Versions
    public static String AUTHOR = "Sean Pesce";
    public static String PROGRAM_SHORT = "DSCfgUtil";
    public static String PROGRAM = "DSConfigUtil";
    public static String PROGRAM_LONG = "Dark Souls Configuration Utility";
    public static String PROGRAM_VERSION = "x.xx";
    public static String DS = "Dark Souls";
    public static String DS_PTD = "Dark Souls: Prepare to Die Edition";
    public static String DS_AUTHOR = "From Software";
    public static String DS_AUTHOR_WEBSITE[] = {"http://www.fromsoftware.jp/pc/",
                                                "http://www.preparetodie.com/"};
    public static String DS_VERSION = "1.0.2.0";
    public static String DSF = "DSFix";
    public static String DSF_AUTHOR = "Durante";
    public static String DSF_AUTHOR_WEBSITE = "http://blog.metaclassofnil.com/";
    public static String DSF_VERSION = "2.4";
    public static String DSM = "DSMFix";
    public static String DSMOUSE = "DSMouseFix";
    public static String DSM_LEGACY_AUTHOR = "yrooref@tznvy.pbz";
    public static String DSM_LEGACY_AUTHOR_WEBSITE = "http://pages.cs.wisc.edu/~petska/";
    public static String DSM_LEGACY_VERSION = "09-Steamworks";
    public static String DSM_AUTHOR = "Methanhydrat";
    public static String DSM_AUTHOR_WEBSITE = "http://community.pcgamingwiki.com/index.php?app=core&module=search&do=user_activity&search_app=downloads&mid=3019";
    public static String DSM_VERSION = "1.3";
    public static String DSPW = "Dark Souls PvP Watchdog";
    public static String DSPW_SHORT = "PvP Watchdog";
    public static String DSPW_ABBREV = "DSPW";
    public static String DSPW_VERSION = "1.17.2";
    public static String DSPW_AUTHOR = "eur0pa";
    public static String DSPW_AUTHOR_WEBSITE = "https://paypal.me/eur0pa";
    public static String DSCM = "Dark Souls Connectivity Mod";
    public static String DSCM_SHORT = "Connectivity Mod";
    public static String DSCM_ABBREV = "DSCM";
    public static String DSCM_VERSION = "2016-05-31-21";
    public static String DSCM_AUTHOR = "Wulf2k";
    public static String DSCM_AUTHOR_WEBSITE = "http://wulf2k.ca/";
    public static String FPS_FIX = "FPS Fix";
    public static String FPS_FIX_LONG = "Bonfire FPS Fix";
    public static String FPS_FIX_AUTHOR = "NullBy7e";
    
    //FILES AND DIRECTORIES
    //
        //Dark Souls Files/Directories
    public static String DS_REGISTRY_KEY[] = {"SOFTWARE\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Steam App 211420",
                                              "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Steam App 211420",
                                              "SOFTWARE\\Wow6432Node\\namco bandai games\\dark souls",
                                              "SOFTWARE\\namco bandai games\\dark souls"};
    public static String DS_INSTALL_REG_VALUE_NAME[] = {"InstallLocation", "install_path", "InstallPath"};
    public static String DS_FOLDER = "\\Dark Souls Prepare to Die Edition";
    public static String DEFAULT_STEAM_DIR[] = {
        "\\Program Files\\Steam",
        "\\Program Files (x86)\\Steam"};
    public static String DEFAULT_STEAM_SUBDIR = "\\SteamApps\\common" + DS_FOLDER;
    public static String DATA_FOLDER = "\\DATA";
    public static String DS_EXE = "DARKSOULS.exe";
    public static String DS_DEFAULT_DLLS[] = {"fmod_event.dll", "fmodex.dll", "steam_api.dll"};
    public static String APPDATA = "AppData";
    public static String APPDATA_INI = "AppData\\Local\\NBGI\\DarkSouls\\DarkSouls.ini";
    public static String DS_INI = "DarkSouls.ini";
    public static String AA_SETTING = "Antialiasing";
    public static String LAUNCH_DS = "steam://rungameid/211420";
    public static String STEAM_INSTALL_REG_KEYS[] = {"SOFTWARE\\Wow6432Node\\Valve\\Steam", "SOFTWARE\\Valve\\Steam"};
    public static String STEAM_CFG_FILE = "\\config\\config.vdf";
    public static String STEAM_CFG_ENTRY = "BaseInstallFolder";
    //public static String DEFAULT_FILES = ""; //No files are overwritten
    //
        //DSFix Files/Directories
    public static String DSF_FOLDER = "\\DSFix 2.4-19-2-4";
    public static String DSF_FILES[] = {"DINPUT8.dll", "DSfix.ini", "DSfixKeys.ini",
        "README.txt", "VERSIONS.txt", "dsfix\\FXAA.fx", "dsfix\\FXAA.h",
        "dsfix\\GAUSS.fx", "dsfix\\HBAO.fx", "dsfix\\HUD.fx", "dsfix\\SCAO.fx",
        "dsfix\\SMAA.fx", "dsfix\\SMAA.h", "dsfix\\VSSAO.fx", "dsfix\\VSSAO2.fx",
        "dsfix\\tex_dump\\", "dsfix\\tex_override\\3f28b833.png"};
    public static String DSF_VERIFICATION = "# You can configure DSfix by editing this file"; //The first line of DSfix.ini, for verifying that an .ini file is a real DSFix ini file and not just some random .ini
    public static String DSF_KEYBINDS_VERIFICATION = "## DSfix Keybindings";
    public static String DSF_HELP_URL = "http://blog.metaclassofnil.com/?p=684";
    //
        //DSMFix Files/Directories (Older version)
    public static String DSM_LEGACY_FOLDER = "\\dsmfix09-steamworks";
    public static String DSM_LEGACY_FILES[] = {"dsmfix.dll", "dsmfix.ini",
                                        "dsmfixgui.exe", "README.txt"};
    //
        //Dark Souls Mouse Fix Files/Directories (Newer, separate mouse fix mod)
    public static String DSM_FOLDER = "\\DarkSoulsMouseFix_v1.3";
    public static String DSM_FILES[] = {"DarkSoulsMouseFix.dll", "DarkSoulsMouseFix.ini",
                                            "DarkSoulsMouseFixGUI.exe",
                                            "DarkSoulsMouseFixReadme.md",
                                            "DarkSoulsMouseFixReadme.pdf"};
    public static String DSM_HELP_URL = "https://www.reddit.com/r/pcgaming/comments/5x6ec9/darksoulsmousefix_v10_beta_released_raw_mouse/";
    //
        //DS PvP Watchdog Files/Directories
    public static String DSPW_FOLDER = "\\DSPW Steam 1.17.2";
    public static String DSPW_FILES[] = {"CHANGELOG.txt", "d3d9.dll", "DSPW_README.txt",
                                        "DSPWSteam.ini", "msvcp120.dll", "msvcr120.dll",
                                        "VERSION"};
    public static String DSPW_HELP_URL = "https://bitbucket.org/infausto/dark-souls-pvp-watchdog";
    //
        //Dark Souls Connectivity Mod Files/Directories
    public static String DSCM_FOLDER = "\\DSCM-2016-05-31-21";
    public static String DSCM_FILES[] = {"DSCM_README.txt", "DSCM.exe"};
    //
        //Bonfire FPS Fix Files/Directories
    public static String FPS_FIX_FOLDER = "\\FPSFix.v1.2-beta";
    public static String FPS_FIX_FILES[] = {"FPSFix.dll", "FPSFix.ini"};
    //
        //Texture Mod Files/Directories
    public static String DSF_TEX_OVERRIDE_FOLDER = "\\dsfix\\tex_override";
    public static String TEXTURE_MODS_FOLDER = "\\Tex_Mods";
    public static String ADDITIONAL_TEX_MODS_FOLDER = "\\add";
    public static String HIRES_FONTS_MOD_FOLDER[] = {"\\HiRes Font Mod v2 PNG\\1024x - Sharp",
                                                    "\\HiRes Font Mod v2 PNG\\2048x - Sharper"};
    public static String XB360_BUTTONS_MOD_FOLDER = "\\Xbox360 HD Interface Icons";
    public static String XB1_BUTTONS_MOD_FOLDER = "\\XboxOne Interface Icons";
    public static String PS3_BUTTONS_MOD_FOLDER = "\\PS3 Interface Icons";
    public static String PS4_BUTTONS_MOD_FOLDER = "\\PS4 Interface Icons";
    public static String KBM_BUTTONS_MOD_FOLDER = "\\KBM Interface Icons";
    public static String VISIBLE_HEALTH_BAR_MOD_FOLDER[] = {"\\Highly Visible Health Bars-40--3",
                                                        "\\Highly Visible Health Bars (colorblind version)-40-"};
    public static String REVAMPED_XHAIR_MOD_FOLDER[] = {"\\BetterAimSight-643-",
                        "\\BetterAimSight(HiVisHP)", "\\BetterAimSight(ColorBlindHP)"};
    public static String REVAMPED_STAT_ICON_MOD_FOLDER = "\\add\\Revamped Stat Buff Icons-8-1-0";
    public static String THIEF_MASK_FIX_MOD_FOLDER = "\\ThiefMaskFix(No Triangles)-355-1";
    public static String TREE_LOD_MOD_FOLDER = "\\Tree LOD Texture Fix";
    public static String HD_MESSAGES_MOD_FOLDER = "\\HD Player Messages-389-1-1";
    public static String HD_SIGNS_MOD_FOLDER = "\\HD Summon Signs-394-1-1";
    public static String FACE_REVAMP_MOD_FOLDER = "\\add\\AndresHeadpack4_0-23-4-0";
    public static String ANOR_LONDO_HD_DISTANCE_TEX_MOD_FOLDER = "\\add\\AnorLondoHQDistanceTextures-132-1-0";
    public static String HD_PAINTING_MOD_FOLDER[] = {"\\add\\HQ Painting-148-1-0\\2048x2048",
                                                     "\\add\\HQ Painting-148-1-0\\4096x4096"};
    public static String REVAMPED_ARROWS_MOD_FOLDER = "\\add\\RevampedArrows-197-1-0";
    public static String REVAMPED_QUIVER_MOD_FOLDER = "\\add\\RevampedQuiver-197-";
    public static String BLACK_SPLASH_MOD_FOLDER = "\\add\\BlackBamcoScreen-175-1-1";
    public static String NO_AURAS_MOD_FOLDER = "\\add\\NoAuras";
    public static String FONTS_MOD_FILES[] = {"db8a58fa.png", "f9d8db89.png"};
    public static String BUTTONS_MOD_FILES[] = {"40fbc4ad.png", "43a2b23a.png"};
    public static String HEALTH_BAR_MOD_FILES[] = {"e3e2582d.png"};
    public static String STAT_ICON_MOD_FILES[] = {"6b0e84c1.png"};
    public static String THIEF_MASK_MOD_FILES[] = {"260c069f.png"};
    public static String TREE_MOD_FILES[] = {"0ca7009e.dds", "7bf5653b.dds", "30fef25a.dds",
                                    "65bff455.dds", "407561a6.dds", "ae451971.dds", 
                                    "72fc5850.dds", "8106835c.dds", "b902fe0a.dds"};
    public static String MESSAGES_MOD_FILES[] = {"d130f1d6.dds", "ed5ea154.dds"};
    public static String SIGNS_MOD_FILES[] = {"36e28b90.dds", "290d87fd.dds",
                                "3271fdc4.dds", "10445a76.dds"};
    public static String FACE_MOD_FILES[] = {"0cea740e.png", "2eb33072.png",
            "2f8ddd4a.png", "3af0e742.png", "6c39543c.png", "7b13d313.png",
            "5673a0a0.png", "14446733.png", "a2a628ff.png", "a4aa30db.png",
            "b56f11c0.png", "c27c7e10.png", "cac54c6c.png", "d7ddd679.png",
            "e2111698.png", "ed2520d3.png", "ee17d079.png", "f0adfbfc.png",
            "fe049911.png"};
    public static String ANOR_LONDO_DISTANT_LANDSCAPE_MOD_FILES[] = {"76b0b5b8.dds",
                                                                    "6552a860.dds"};
    public static String PAINTING_MOD_FILES[] = {"330906ff.dds"};
    public static String ARROW_MOD_FILES[] = {"245d08aa.dds", "c5783bd7.dds", "fac97094.dds"};
    public static String QUIVER_MOD_FILES[] = {"1ab832ab.dds"};
    public static String BANDAI_SPLASH_MOD_FILES[] = {"2fba57c1.png"};
    public static String ALL_AURAS_MOD_FILES[] = {"3bca98e4.png", "8accc4ef.png",
                                            "0755aa88.png", "c467d9f5.png", "e087970c.png"};
    //
        //DSCfgUtil Files/Directories
    public static String FILES_DIR = "src\\dscfgutil\\zFiles";
    public static String TEMPLATES_DIR = FILES_DIR + "\\templates";
    public static String IMAGE_DIRECTORY = FILES_DIR + "\\images";
    public static String PROGRAM_ICON = "DSCU Icon.png";
    public static String CONSOLE_POPOUT_ICON = "Popout.png";
    public static String CSS_DIRECTORY = "/dscfgutil/style/Style.css";
    public static String INI_EXT_FILTER[] = {"ini Files (*.ini)", "*.ini"};
    public static String DLL_EXT_FILTER[] = {"dll Files (*.dll)", "*.dll"};
    public static String DSCU_CHECK_UPDATES_URL = "https://github.com/SeanPesce/Dark_Souls_Config_Utility/releases";
    public static String DSCU_HELP_URL = "https://github.com/SeanPesce/Dark_Souls_Config_Utility/blob/master/Readme.md";
    public static String GET_DS_URL = "http://store.steampowered.com/app/211420/";
    public static String GET_MODS_URL = "http://www.nexusmods.com/darksouls/";
    
    
    //Menus & Interface Strings/Constants
    public static PseudoClass INVALID_INPUT = PseudoClass.getPseudoClass("invalid_input");
    
        //File toolbar
        //File menu
        public static String FILE = "File";
            public static String LOAD = "Load...";
            public static String LOAD_DSF_CFG = DSF + " Config";
            public static String LOAD_DSF_KEYBINDS = DSF + " Keybinds";
            public static String SAVE_CONFIG = "Save config";
            public static String EXPORT_MENU = "Export...";
            public static String EXPORT_DSF_INI = DSF + " config as .ini";
            public static String EXPORT_DSF_KEYBINDS_INI = DSF + " keybinds as .ini";
            public static String EXPORT_DSF = DSF + " with config & keybinds";
            public static String EXPORT_CFG_TOOLTIP = "Export " + DSF + " with " +
                                                    "the current configuration";
            public static String EXIT_PROGRAM = "Exit";
        //Dark Souls Menu
            public static String LAUNCH = "Launch";
            public static String CONFIGURE_DS = "Change in-game settings";
            public static String OPEN_DATA_FOLDER = "Open DATA folder";
        //DSFix Menu
            public static String APPLY_CONFIG = "Apply current " + DSF + " config";
            public static String APPLY_DSF_KEYBINDS = "Apply current " + DSF + " keybinds";
            public static String INSTALL_DSF = "Install " + DSF;
            public static String REINSTALL_DSF = "Reinstall " + DSF;
            public static String UNINSTALL_DSF = "Uninstall " + DSF;
            public static String RECHECK_DSF = "Recheck for " + DSF + " install";
        //DSMfix Menu
            public static String INSTALL_DSM = "Install " + DSM;
            public static String REINSTALL_DSM = "Reinstall " + DSM;
            public static String UNINSTALL_DSM = "Uninstall " + DSM;
            public static String CONFIGURE_DSM = "Configure " + DSM;
            public static int DSM_DELAY = 5; // Time to wait for Dark Souls Mouse Fix configuration UI to open (in seconds)
        //DS PvP Watchdog Menu
            public static String APPLY_DSPW_CONFIG = "Apply current " + DSPW_ABBREV + " config";
            public static String INSTALL_DSPW = "Install " + DSPW_SHORT;
            public static String REINSTALL_DSPW = "Reinstall " + DSPW_SHORT;
            public static String UNINSTALL_DSPW = "Uninstall " + DSPW_SHORT;
            public static String RECHECK_DSPW = "Recheck for " + DSPW_ABBREV + " install";
        //Dark Souls Connectivity Mod Menu
            public static String LAUNCH_DSCM = "Launch " + DSCM_ABBREV + " only";
            public static String LAUNCH_DS_AND_CM = "Launch " + DSCM_ABBREV + " and " + DS;
            public static int DSCM_DELAY = 10; //Delay time between opening Dark Souls and launching Connectivity Mod; allows Dark Souls thread to be active before DSCM is opened
        //Options menu
        public static String DSCU_OPTIONS = "Options";
        public static String TOGGLE_CONSOLE[] = {"Show console", "Hide console"};
        //Help menu
        public static String HELP = "Help";
            public static String CHECK_DSCU_UPDATES = "Check for updates";
            public static String ABOUT = "About ";
            public static String ABOUT_DSCU = ABOUT + PROGRAM;
            public static String ABOUT_DSF = ABOUT + DSF;
            public static String ABOUT_DSM = ABOUT + DSMOUSE;
            public static String ABOUT_DSPW = ABOUT + DSPW_SHORT;
            public static String GET_DS = "Get " + DS;
            public static String GET_MODS = "Get DS mods";
        //
        //Tabs (Settings Categories)
        public static String GRAPHICS = "Graphics";
        public static String HUD = "HUD";
        public static String WINDOW_MOUSE = "Window & Mouse";
        public static String SAVE_BACKUP = "Save Game Backups";
        public static String TEXTURES = "Textures";
        public static String OTHER_OPS = "Other";
        public static String UNSAFE_OPS = "Unstable";
        public static String KEY_BINDINGS = DSF + " Key Bindings";
        public static String SETTINGS = "Settings";
        public static String TEXTURE_MODS = "Texture Mods";
        public static String TEX_MOD_TT = "Install/Uninstall Texture Mods";
        //
        //Console
        public static String CONSOLE = "Console";
        public static String CONSOLE_HOVER = "Console displays error messages" +
                                            " and other developer feedback";
        public static String CONSOLE_POPOUT_HOVER = "Display console in popout window";
    
    
    //Settings/Values
        //DSFix installed Status:
        public static String[] DSF_STATUS = {"Installed", "Not installed",
                                             "Unknown"};
        public static int TOTAL_SETTINGS = 40;
        //Default DSFix values:
        //
        //All integer-based settings, so everything except AA type, AO type,
        //  DoF additional blur, HUD scale, HUD opacities, screenshot directory,
        //  language override, dll chaining, D3D override, 
        public static int[] DEFAULT_INT_VALUES = {1920, 1080, 0, 0, 0, -2, 0, 1,
            -2, 540, 0, -2, 0, 60, 28, 0, 0, 1, -2, -2, -2, -2, 0, 0, 0, 0, 1500,
            10, 0, 0, 0, -2, -2, -2, -2, 0, 0, 0, 0, 60};
        public static String[] INT_VALUE_NAMES = {"renderWidth", "renderHeight",
            "presentWidth", "presentHeight", "aaQuality", null, "ssaoStrength",
            "ssaoScale", null, "dofOverrideResolution", "disableDofScaling", null, 
            "unlockFPS", "FPSlimit", "FPSthreshold", "filteringOverride",
            "enableHudMod", "enableMinimalHud", null, null, null, null,
            "borderlessFullscreen", "disableCursor", "captureCursor",
            "enableBackups", "backupInterval", "maxBackups", "enableTextureDumping",
            "enableTextureOverride", "skipIntro", null, null, null, null,
            "logLevel", "forceWindowed", "forceFullscreen", "enableVsync",
            "fullscreenHz"};
        //
        //All string-based settings, so: AA type, AO type, DoF additional blur,
        //  HUD scale, HUD opacities, screenshot directory, language override,
        //  dll chaining, and D3D override
        public static String[] DEFAULT_STRING_VALUES = {null, null, null, null,
            null, "SMAA", null, null, "VSSAO", null, null, "1", null, null, null,
            null, null, null, "0.75", "0.8f", "0.75f", "0.5f", null, null, null,
            null, null, null, null, null, null, ".", "none", "none", "-1", null,
            null, null, null, null};
        public static String[] STRING_VALUE_NAMES = {null, null, null, null, null,
            "aaType", null, null, "ssaoType", null, null, "dofBlurAmount", null,
            null, null, null, null, null, "hudScaleFactor", "hudTopLeftOpacity",
            "hudBottomLeftOpacity", "hudBottomRightOpacity", null, null, null,
            null, null, null, null, null, null, "screenshotDir", "overrideLanguage",
            "dinput8dllWrapper", "d3dAdapterOverride", null, null, null, null, null};
        //
        //Settings options
        public static String AAQUALITIES[] = {"Off", "Low", "Medium", "High", "Ultra"};
        public static String AATYPES[] = {"SMAA", "FXAA"};
        public static String SSAOSTRENGTHS[] = {"Off", "Low", "Medium", "High"};
        public static String SSAOSCALES[] = {"High quality", "Lower quality",
                                                              "Lowest quality"};
        public static String SSAOTYPES[] = {"VSSAO", "HBAO", "SCAO", "VSSAO2"};
        public static String DOFOVERRIDERESOLUTIONS[] = {"No Change (360)", "540",
                                          "810", "1080", "2160", "No DOF (Alternate Method)"};
        public static int DOF_OVERRIDE_OPTIONS[] = {0, 540, 810, 1080, 2160};
        public static String DOF_ADDITIONAL_BLUR[] = {"Off", "0", "1",
                                                        "2", "3", "4"};
        public static String DOF_ADDITIONAL_BLUR_OPTIONS[] = {"o", "0", "1",
                                                        "2", "3", "4"};
        public static String ENABLE_DISABLE[] = {"Enabled", "Disabled"};
        public static String DISABLE_ENABLE[] = {"Disabled", "Enabled"};
        public static String DISABLED = "Disabled";
        public static String LOCK_UNLOCK[] = {"Default (Locked)", "Unlock FPS"};
        public static String FILTERINGOVERRIDES[] = {"None", "Bilinear", "Full AF"};
        public static int FILTERING_OVERRIDE_OPTIONS[] = {0, 1, 2};
        public static String ON_OFF[] = {"On", "Off"};
        public static String CAPTURECURSOR[] = {"Don't capture", "Capture"};
        public static String SKIPINTRO[] = {"Don't skip", "Skip"};
        public static String LANGUAGES[] = {"No override", "English", "French/Française",
                        "Italian/Italiano", "German/Deutsche", "Spanish/Español",
                        "Korean/Hangug-eo/한국어", "Chinese/Zhōngwén/中文",
                        "Polish/Polski", "Russian/Rosyjski/русский"};
        public static String LANGUAGE_OPTIONS[] = {"none", "en-GB", "fr", "it", "de",
                                               "es", "ko", "zh-tw", "pl", "ru"};
        public static String ADAPTEROVERRIDE[] = {"No override", "Adapter N"};
        public static String ADAPTER_OPTIONS[] = {"-1", "N"};
        public static int LOGLEVEL[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        public static String WINDOW_MODES[] = {"Neither", "Windowed", "Fullscreen"};
        //
        //DSFix Keybind Strings
        public static String DSF_DEFAULT_ENABLED_BINDS[] = {"toggleCursorCapture",
                                "toggleCursorVisibility", "toggleBorderlessFullscreen",
                                "toggleHUD", "toggleHUDChanges", "toggle30FPSLimit"};
        public static String DSF_DEFAULT_KEY_VALUES[] = {"VK_F6", "VK_F7", "VK_F8",
                                "VK_RCONTROL", "VK_RSHIFT", "VK_BACK"};
        public static String DSF_KEY_ACTIONS[] = {"toggleCursorVisibility", "toggleCursorCapture",
            "toggleBorderlessFullscreen", "singleFrameFullCapture", "takeHudlessScreenshot", "toggleHUD",
            "toggleHUDChanges", "toggleAA", "toggleSMAA", "toggleVSSAO", "toggleDofGauss",
            "reloadAAEffect", "reloadSSAOEffect", "reloadGAUSSEffect", "reloadHUDVertices", 
            "toggle30FPSLimit", "togglePaused", "userTrigger"};
        public static String DSF_KEY_ACTION_NAMES[] = {"Toggle Cursor Visibility",
            "Toggle Cursor Capture", "Toggle Borderless Fullscreen", "Capture Full Frame",
            "Take Screenshot", "Toggle HUD", "Toggle HUD Mods", "Toggle AA",
            "Toggle SMAA", "Toggle VSSAO", "Toggle DOF Gauss", "Reload AA Effect",
            "Reload SSAO Effect", "Reload Gauss Effect", "Reload HUD Vertices",
            "Toggle Unlocked Framerate", "Pause/Unpause", "User Trigger (?)"};
        public static String DSF_KEYS[] = {"VK_LBUTTON", "VK_RBUTTON", "VK_CANCEL", "VK_MBUTTON", "VK_XBUTTON1", "VK_XBUTTON2", 
            "VK_BACK", "VK_TAB", "VK_CLEAR", "VK_RETURN", "VK_SHIFT", "VK_CONTROL", "VK_MENU", "VK_PAUSE", 
            "VK_CAPITAL", "VK_KANA", "VK_HANGUL", "VK_JUNJA", "VK_FINAL", "VK_HANJA", "VK_KANJI", 
            "VK_ESCAPE", "VK_CONVERT", "VK_NONCONVERT", "VK_ACCEPT", "VK_MODECHANGE", "VK_SPACE", 
            "VK_PRIOR", "VK_NEXT", "VK_END", "VK_HOME", "VK_LEFT", "VK_UP", "VK_RIGHT", "VK_DOWN", "VK_SELECT", 
            "VK_PRINT", "VK_EXECUTE", "VK_SNAPSHOT", "VK_INSERT", "VK_DELETE", "VK_HELP", 
            "VK_0", "VK_1", "VK_2", "VK_3", "VK_4", "VK_5", "VK_6", "VK_7", "VK_8", "VK_9", 
            "VK_A", "VK_B", "VK_C", "VK_D", "VK_E", "VK_F", "VK_G", "VK_H", "VK_I", "VK_J", "VK_K", "VK_L", 
            "VK_M", "VK_N", "VK_O", "VK_P", "VK_Q", "VK_R", "VK_S", "VK_T", "VK_U", "VK_V", "VK_W", "VK_X", "VK_Y", "VK_Z", 
            "VK_LWIN", "VK_RWIN", "VK_APPS", "VK_SLEEP", "VK_NUMPAD0", "VK_NUMPAD1", "VK_NUMPAD2", 
            "VK_NUMPAD3", "VK_NUMPAD4", "VK_NUMPAD5", "VK_NUMPAD6", "VK_NUMPAD7", "VK_NUMPAD8", 
            "VK_NUMPAD9", "VK_MULTIPLY", "VK_ADD", "VK_SEPARATOR", "VK_SUBTRACT", "VK_DECIMAL", 
            "VK_DIVIDE", "VK_F1", "VK_F2", "VK_F3", "VK_F4", "VK_F5", "VK_F6", "VK_F7", "VK_F8", "VK_F9", "VK_F10", 
            "K_F11", "VK_F12", "VK_F13", "VK_F14", "VK_F15", "VK_F16", "VK_F17", "VK_F18", "VK_F19", "VK_F20", 
            "VK_F21", "VK_F22", "VK_F23", "VK_F24", 
            "VK_NUMLOCK", "VK_SCROLL", "VK_LSHIFT", "VK_RSHIFT", "VK_LCONTROL", "VK_RCONTROL", "VK_LMENU", "VK_RMENU"};
        //
        //DS PvP Watchdog Strings
        public static String DEFAULT_DSPW_VALUES[] = {"true", "true", "left", "true",
            "true", "true", "true", "false", "15", "false", "true", "true", "none",
            "0x70", "0x74", "0x78", "0x79"};
        public static String DSPW_SETTING_NAMES[] = {"ShowVersionBanner", "ShowOverlay",
            "TextAlignment", "InvasionSoundNotification", "CheaterSoundNotification",
            "BlockArenaFreeze", "ShowNodeDbCount", "IncreaseNodeDbLimit", "FontSize",
            "DisplayDate", "DisplayClock", "CheckForUpdates", "d3d9dllWrapper",
            "key_BanPhantom", "key_IgnorePhantom", "key_HideOverlay", "key_AboutDSPW"};
        public static int NUMBER_OF_DSPW_SETTINGS = DSPW_SETTING_NAMES.length;
        public static String DSPW_TEXT_ALIGNMENT_OPTIONS[] = {"left", "center", "right"};
        public static String DSPW_KEYBIND_NAMES[] = {"VK_LBUTTON", "VK_RBUTTON",
            "VK_CANCEL", "VK_MBUTTON", "VK_XBUTTON1", "VK_XBUTTON2", "VK_BACK",
            "VK_TAB", "VK_CLEAR", "VK_RETURN", "VK_SHIFT", "VK_CONTROL",
            "VK_MENU", "VK_PAUSE", "VK_CAPITAL", "VK_KANA", "VK_HANGUEL", "VK_HANGUL",
            "VK_JUNJA", "VK_FINAL", "VK_HANJA", "VK_KANJI", "VK_ESCAPE",
            "VK_CONVERT", "VK_NONCONVERT", "VK_ACCEPT", "VK_MODECHANGE", "VK_SPACE",
            "VK_PRIOR", "VK_NEXT", "VK_END", "VK_HOME", "VK_LEFT", "VK_UP", "VK_RIGHT",
            "VK_DOWN", "VK_SELECT", "VK_PRINT", "VK_EXECUTE", "VK_SNAPSHOT", "VK_INSERT",
            "VK_DELETE", "VK_HELP", "VK_LWIN", "VK_RWIN", "VK_APPS", "VK_SLEEP", "VK_NUMPAD0",
            "VK_NUMPAD1", "VK_NUMPAD2", "VK_NUMPAD3", "VK_NUMPAD4", "VK_NUMPAD5", "VK_NUMPAD6",
            "VK_NUMPAD7", "VK_NUMPAD8", "VK_NUMPAD9", "VK_MULTIPLY", "VK_ADD", "VK_SEPARATOR",
            "VK_SUBTRACT", "VK_DECIMAL", "VK_DIVIDE", "VK_F1", "VK_F2", "VK_F3", "VK_F4",
            "VK_F5", "VK_F6", "VK_F7", "VK_F8", "VK_F9", "VK_F10", "VK_F11", "VK_F12",
            "VK_F13", "VK_F14", "VK_F15", "VK_F16", "VK_F17", "VK_F18", "VK_F19", "VK_F20",
            "VK_F21", "VK_F22", "VK_F23", "VK_F24", "VK_NUMLOCK", "VK_SCROLL", 
            "VK_LSHIFT", "VK_RSHIFT", "VK_LCONTROL", "VK_RCONTROL", "VK_LMENU", "VK_RMENU",
            "VK_BROWSER_BACK", "VK_BROWSER_FORWARD", "VK_BROWSER_REFRESH", "VK_BROWSER_STOP",
            "VK_BROWSER_SEARCH", "VK_BROWSER_FAVORITES", "VK_BROWSER_HOME", "VK_VOLUME_MUTE",
            "VK_VOLUME_DOWN", "VK_VOLUME_UP", "VK_MEDIA_NEXT_TRACK", "VK_MEDIA_PREV_TRACK",
            "VK_MEDIA_STOP", "VK_MEDIA_PLAY_PAUSE", "VK_LAUNCH_MAIL", "VK_LAUNCH_MEDIA_SELECT",
            "VK_LAUNCH_APP1", "VK_LAUNCH_APP2", "VK_OEM_1", "VK_OEM_PLUS", "VK_OEM_COMMA",
            "VK_OEM_MINUS", "VK_OEM_PERIOD", "VK_OEM_2", "VK_OEM_3", "VK_OEM_4",
            "VK_OEM_5", "VK_OEM_6", "VK_OEM_7", "VK_OEM_8", "VK_OEM_102",
            "VK_PROCESSKEY", "VK_PACKET", "VK_ATTN", "VK_CRSEL", "VK_EXSEL",
            "VK_EREOF", "VK_PLAY", "VK_ZOOM", "VK_NONAME", "VK_PA1", "VK_OEM_CLEAR"};
        public static String DSPW_KEYBIND_HEX[] = {"0x01", "0x02", "0x03", "0x04",
            "0x05", "0x06", "0x08", "0x09", "0x0C", "0x0D", "0x10", "0x11", "0x12",
            "0x13", "0x14", "0x15", "0x15", "0x15", "0x17", "0x18", "0x19", "0x19",
            "0x1B", "0x1C", "0x1D", "0x1E", "0x1F", "0x20", "0x21", "0x22", "0x23",
            "0x24", "0x25", "0x26", "0x27", "0x28", "0x29", "0x2A", "0x2B", "0x2C",
            "0x2D", "0x2E", "0x2F", "0x5B", "0x5C", "0x5D", "0x5F", "0x60", "0x61",
            "0x62", "0x63", "0x64", "0x65", "0x66", "0x67", "0x68", "0x69", "0x6A",
            "0x6B", "0x6C", "0x6D", "0x6E", "0x6F", "0x70", "0x71", "0x72", "0x73",
            "0x74", "0x75", "0x76", "0x77", "0x78", "0x79", "0x7A", "0x7B", "0x7C",
            "0x7D", "0x7E", "0x7F", "0x80", "0x81", "0x82", "0x83", "0x84", "0x85",
            "0x86", "0x87", "0x90", "0x91", "0xA0", "0xA1", "0xA2", "0xA3", "0xA4",
            "0xA5", "0xA6", "0xA7", "0xA8", "0xA9", "0xAA", "0xAB", "0xAC", "0xAD",
            "0xAE", "0xAF", "0xB0", "0xB1", "0xB2", "0xB3", "0xB4", "0xB5", "0xB6",
            "0xB7", "0xBA", "0xBB", "0xBC", "0xBD", "0xBE", "0xBF", "0xC0", "0xDB",
            "0xDC", "0xDD", "0xDE", "0xDF", "0xE2", "0xE5", "0xE7", "0xF6", "0xF7",
            "0xF8", "0xF9", "0xFA", "0xFB", "0xFC", "0xFD", "0xFE"};
        public static String TRUE_FALSE[] = {"true", "false"};
        public static String BLOCK_FREEZE_CHOICES[] = {"Block", "Don't block"};
        //
        //FPSFix key strings
        public static String FPS_FIX_KEYS[] = {"VK_NUMPAD0", "VK_NUMPAD1",
            "VK_NUMPAD2", "VK_NUMPAD3", "VK_NUMPAD4", "VK_NUMPAD5", "VK_NUMPAD6",
            "VK_NUMPAD7", "VK_NUMPAD8", "VK_NUMPAD9", "VK_MULTIPLY", "VK_ADD",
            "VK_SEPARATOR", "VK_SUBTRACT", "VK_DECIMAL", "VK_DIVIDE", "VK_F1", "VK_F2",
            "VK_F3", "VK_F4", "VK_F5", "VK_F6", "VK_F7", "VK_F8", "VK_F9", "VK_F10",
            "VK_F11", "VK_F12", "VK_F13", "VK_F14", "VK_F15", "VK_F16", "VK_F17",
            "VK_F18", "VK_F19", "VK_F20", "VK_F21", "VK_F22", "VK_F23", "VK_F24"};
        public static String FPS_FIX_KEYS_HEX[] = {"0x60", "0x61", "0x62", "0x63",
            "0x64", "0x65", "0x66", "0x67", "0x68", "0x69", "0x6A", "0x6B", "0x6C",
            "0x6D", "0x6E", "0x6F", "0x70", "0x71", "0x72", "0x73", "0x74", "0x75",
            "0x76", "0x77", "0x78", "0x79", "0x7A", "0x7B", "0x7C", "0x7D", "0x7E",
            "0x7F", "0x80", "0x81", "0x82", "0x83", "0x84", "0x85", "0x86", "0x87"};
        public static ObservableList<String> FPS_FIX_KEYS_ARRAY_LIST = FXCollections.observableArrayList(FPS_FIX_KEYS);
        public static ObservableList<String> FPS_FIX_KEYS_HEX_ARRAY_LIST = FXCollections.observableArrayList(FPS_FIX_KEYS_HEX);
        //
        //General Settings panes strings
        public static String APPLY_SETTINGS = "Apply settings";
        public static String APPLY_KEYBINDS = "Apply keybinds";
        public static String RESTORE_DEFAULTS = "Restore defaults";
        //
        //Graphics pane
        public static String RES_CAT_LABEL = "Resolution";
        public static String RENDER_RES_LABEL = "Rendering resolution: ";
        public static String WIDTH_HEIGHT[] = {"Width", "Height"};
        public static String USE_WINDOWS_RES = "Use Windows Resolution";
        public static String PRESENT_RES_LABEL = "Presented resolution: ";
        public static String USE_PRESENT_RES = "Different Res";
        public static String DONT_USE_PRES_RES = "Render Res";
        public static String AA_QUALITY_LABEL = "AA Quality: ";
        public static String AA_TYPE_LABEL = "AA Type: ";
        public static String SSAO_STRENGTH_LABEL = "SSAO Strength: ";
        public static String SSAO_SCALE_LABEL = "SSAO Scale: ";
        public static String SSAO_TYPE_LABEL = "SSAO Type: ";
        public static String DOF_OVERRIDE_LABEL = "DOF Override Res: ";
        public static String DOF_SCALING_LABEL = "DOF Scaling: ";
        public static String DOF_ADD_BLUR_LABEL = "DOF Additional Blur: ";
        public static String UNLOCK_FPS_LABEL = "Unlock framerate: ";
        public static String FPS_FIX_KEY_LABEL = "Bonfire FPS Fix Keybind: ";
        public static String FPS_LIMIT_LABEL = "FPS Limit: ";
        public static String FPS_THRESHOLD_LABEL = "FPS Threshold: ";
        public static String TEX_FILTERING_OVERRIDE_LABEL = "Filtering override: ";
            //Tooltips
        public static String RENDER_RES_TT = "Internal rendering resolution of the game.\n" +
                                            "(Higher values will decrease performance)";
        public static String PRESENT_RES_TT = "The displayed width/height - " +
                                            "Uses rendering resolution when disabled.\n" +
                                            "(Use this for downscaling)";
        public static String AA_QUALITY_TT = "Antialiasing toggle and quality settings\n" +
                                            "Off - best performance, worst image quality\n" +
                                            "Ultra - worst performance, best image quality";
        public static String AA_TYPE_TT = "AA types: \nSMAA - Slightly worse performance, " +
                                        "slightly better quality\nFXAA - Slightly better " +
                                        "performance, slightly worse quality";
        public static String SSAO_STRENGTH_TT = "Ambient Occlusion Strength - " +
                                        "All 3 settings have the same performance impact";
        public static String SSAO_SCALE_TT = "SSAO Scale: lower quality = lower performance impact";
        public static String SSAO_TYPE_TT = "SSAO Type: \nVSSAO = Volumetric SSAO (Default)\n" +
                                    "HBAO = Horizon-Based Ambient Occlusion\n" +
                                    "SCAO = VSSAO + HBAO\n" +
                                    "VSSAO2 = Volumetric SSAO with more samples (tweaked by Asmodean)\n\n" +
                                "VSSAO and  HBAO types have a slightly different effect and similar performance impact\n" +
                                "SCAO combines both, with a higher performance impact\n" +
                            "VSSAO2 is generally more accurate, but also drains more performance";
        public static String DOF_OVERRIDE_TT = "Depth of Field Resolution Override";
        public static String DOF_SCALING_OR_TT = "Depth of Field Scaling Override\n" +
                                                "(Disable for sharper image)";
        public static String DOF_ADD_BLUR_TT = "Depth of field additional blur\n" +
                "Allows you to use high DoF resolutions and still get the originally intended effect.\n" +
                                        "Suggested values:\n" +
                                        "Off at default DoF resolution\n" +
                                        "0 or 1 at 540 DoF resolution\n" +
                                        "1 or 2 above that\n" +
                                        "3 or 4 at 2160 DoF resolution";
        public static String UNLOCK_FPS_TT = "Toggle variable framerate\n" +
                                            "NOTE:\n" +
                        "-This requires in-memory modification of game code\n" +
                    "-There may be unintended side-effects in terms of gameplay\n" +
        "-In some  instances, collision detection may fail. Avoid sliding down ladders\n" +
                                "Use this at your own risk!";
        public static String FPS_FIX_TT = "When framerate is unlocked, there is a bug that may cause " +
                    "the player to get stuck at the bonfire. If this occurs, press this key to fix it.";
        public static String FPS_LIMIT_TT = "FPS Limit, only used with unlocked framerate\n" +
                                    "(Do not set this much higher than 60, it will lead to various issues with the engine)";
        public static String FPS_THRESHOLD_TT = "FPS threshold:\nDSfix will dynamically disable" +
                " AA if your framerate drops below this value and re-enable it once framerate" +
                " has normalized (with a bit of hysteresis thresholding)";
        public static String TEX_FILT_OR_TT = "Texture Filtering Override\n";
        //
        //HUD Options Pane
        public static String HUD_MODS_LABEL = "HUD Modifications: ";
        public static String MINIMAL_HUD_LABEL = "Minimal HUD: ";
        public static String HUD_SCALE_LABEL = "HUD Scale: ";
        public static String HUD_OPACITIES_LABEL = "--HUD Opacities--";
        public static String TOP_LEFT_HUD_OP_LABEL = "Top left: ";
        public static String BOTTOM_LEFT_HUD_OP_LABEL = "Bottom left: ";
        public static String BOTTOM_RIGHT_HUD_OP_LABEL = "Bottom right: ";
            //Tooltips
        public static String HUD_MODS_TT = "HUD modifications must be enabled " +
                                        "for anything in this tab to work.";
        public static String MIN_HUD_TT = "Removes the weapon icons from the HUD.\n" +
                                        "(You can see which weapons you have equipped from your character model)";
        public static String HUD_SCALE_TT = "Scales down HUD; Examples:\n" +
                                            "1.0 = Original scale\n" +
                                            "0.75 = 75% of the original size";
        public static String HUD_OPS_TT = "Set opacities for different elements of the HUD\n" +
                                          "1.0 = Fully opaque\n" +
                                          "0.0 = Fully transparent";
        public static String TOP_LEFT_HUD_TT = "Top left: Health bars, stamina bar, humanity counter, status indicators";
        public static String BOTTOM_LEFT_HUD_TT = "Bottom left: Item indicators & item counts";
        public static String BOTTOM_RIGHT_HUD_TT = "Bottom right: Soul count";
        //
        //Window & Mouse Options Pane
        public static String BORDERLESS_FS_LABEL = "Borderless fullscreen: ";
        public static String DISABLE_CURSOR_LABEL = "Mouse cursor: ";
        public static String CAPTURE_CURSOR_LABEL = "Capture cursor: ";
            //Tooltips
        public static String BORDERLESS_FS_TT = "Make sure to select windowed mode in the game settings for this to work!";
        public static String DISABLE_CURSOR_TT = "Enable/Disable cursor at startup";
        public static String CAPTURE_CURSOR_TT = "Toggle Cursor Capture (Don't allow it to leave the window)";
        //
        //Save Backups Pane
        public static String SAVE_BACKUPS_LABEL = "Save game backups: ";
        public static String SAVE_BACKUPS_INTERVAL_LABEL = "Backup interval: ";
        public static String MAX_BACKUPS_LABEL = "Max # of backups: ";
            //Tooltips
        public static String SAVE_INTERVAL_TT = "Save game backup interval in seconds\n(1500 = 25 minutes)";
        //
        //Texture Options Pane
        public static String TEXTURE_DUMPING_LABEL = "Texture dumping: ";
        public static String TEXTURE_OVERRIDE_LABEL = "Texture override: ";
            //Tooltips
        public static String TEX_DUMP_TT = "You only need this if you want to create your own override textures." +
                                        "\nTextures will be dumped to \"dsfix\\tex_override\\[hash].tga\"";
        public static String TEX_OVERRIDE_TT = "Textures in \"dsfix\\tex_override\\[hash].png\"" + 
                                        " will replace the corresponding originals.\n" +
                                    "This setting will cause a small slowdown during texture loading!";
        //
        //Other Settings Pane
        public static String SKIP_INTRO = "Skip Intro Logos: ";
        public static String SS_DIRECTORY = "Screenshot Directory: ";
        public static String SS_DIR_BT_TOOLTIP = "Browse for folder to save " +
                                                "screenshots";
        public static String USE_BASE_SS_DIR = "Use base directory";
        public static String USE_BASE_SS_DIR_TT = "Screenshots will be saved to " +
                                            "the folder where " + DSF + 
                                            " is installed";
        public static String LANGUAGE_LABEL = "Language Override: ";
        public static String DLL_CHAIN_LABEL = "DLL Chain: ";
        public static String DLL_CHAIN_TOOLTIP = "Browse for .dll file to chain";
        public static String DSM_CHAIN_BT = "DSMfix";
        public static String NO_CHAIN_BT = "Clear";
        public static String D3D_OVERRIDE_LABEL = "D3D Adapter Override: ";
        public static String LOG_LEVEL_LABEL = "Log Level: ";
            //Tooltips
        public static String SKIP_INTROS_TT = "Skip the intro logos\nThis should now be slightly more stable, but should still be " +
                                                "the first thing to disable in case you experience any problems";
        public static String LANGUAGE_TT = "Overrides the in-game language";
        public static String DLL_CHAIN_TT = "Dinput DLL Chaining\nIf you want to use another dinput8.dll wrapper together " +
                                            "with DSfix, rename it (e.g. \"dinputwrapper.dll\") and browse for the newly named DLL here";
        public static String D3D_OR_TT = "D3D Adapter Override\nThis setting is for multiple (non-SLI/crossfire) GPUs; "+
                                        "everyone else should leave it alone";
        public static String LOG_LEVEL_TT = "Log level - 0 to 11, higher numbers mean more logging (only enable for debugging)";
        //
        //Unsafe Settings Pane
        public static String FORCE_WINDOW_MODE_LABEL = "Force window mode: ";
        public static String VSYNC_LABEL = "Vsync: ";
        public static String REFRESH_RATE_LABEL = "Fullscreen refresh rate: ";
            //Tooltips
        public static String UNSAFE_TT = "The settings below are not yet ready to use!!";
        public static String VSYNC_TT = "Toggle Vsync";
        public static String FULLSCREEN_HZ_TT = "Adjusts the display refresh rate in fullscreen mode - this is NOT linked to FPS!";
        //
        //PvP Watchdog Pane
        public static String VERSION_LABEL = "Version banner: ";
        public static String OVERLAY_LABEL = "In-game overlay: ";
        public static String TEXT_ALIGNMENT_LABEL = "Text alignment: ";
        public static String INVASION_NOTIF_LABEL = "Invasion sound notification: ";
        public static String CHEATER_NOTIF_LABEL = "Cheater sound notification: ";
        public static String BLOCK_ARENA_FREEZE_LABEL = "Block arena freeze? ";
        public static String NODE_COUNT_LABEL = "Node count: ";
        public static String INCREASE_NODES_LABEL = "Increase node limit: ";
        public static String FONT_SIZE_LABEL = "Font size: ";
        public static String DATE_LABEL = "Display date: ";
        public static String TIME_LABEL = "Display time: ";
        public static String UPDATE_LABEL = "Check for updates: ";
        public static String DSPW_DLL_CHAIN_LABEL = "d3d9.dll Wrapper: ";
        public static String KEYBINDS_LABEL = "-- KEYBINDS --";
        public static String BAN_LABEL = "Ban phantom: ";
        public static String IGNORE_LABEL = "Ignore phantom: ";
        public static String TOGGLE_OVERLAY_LABEL = "Toggle overlay: ";
        public static String ABOUT_DSPW_LABEL = "About DSPW: ";
        //Texture Mods Pane
        public static String TEX_MOD_DISCLAIMER = "Texture mods will only work " +
                                    "if 'Texture Override' is enabled in the DSFix " +
                                    "texture settings.";
        public static String BUTTON_ICON_MODS_LABEL = "Button Icons: ";
        public static String FONT_MODS_LABEL = "Fonts: ";
        public static String HEALTH_BAR_MODS_LABEL = "Health Bars & Bow Crosshairs: ";
        public static String HEALTH_BAR_MODS_LABEL_TT = "Health bars and crosshairs " +
                                        "are contained in the same texture file.";
        public static String STAT_ICON_MODS_LABEL = "Status Icons: ";
        public static String THIEF_MASK_MODS_LABEL = "Thief Mask Texture: ";
        public static String TREE_TEXTURE_MODS_LABEL = "Tree Textures: ";
        public static String TREE_LOD_TEXTURE_MODS_TT = "Fixes a bug in which the " +
                                                "trees in some places " +
                                                "were using a low LOD texture.";
        public static String SIGNS_MODS_LABEL = "Player Messages & Summon Signs: ";
        public static String FACE_MODS_LABEL = "Character Face Textures: ";
        public static String ANOR_LONDO_DISTANCE_LABEL = "Anor Londo Distance Textures: ";
        public static String PAINTING_LABEL = "Ariamis Painting Texture: ";
        public static String ARROW_MOD_LABEL = "Arrows & Quiver: ";
        public static String BANDAI_SPLASH_MOD_LABEL = "Bandai Namco™ Splash Screen: ";
        public static String AURAS_MOD_LABEL = "Player Auras: ";
        public static String UNINSTALL_BUTTON_MOD_BUTTON = "Uninstall Button Icon Mods";
        public static String XB360_ICONS_BUTTON = "HD Xbox 360 Buttons";
        public static String XB1_ICONS_BUTTON = "Xbox One Buttons";
        public static String PS3_ICONS_BUTTON = "PS3 Buttons";
        public static String PS4_ICONS_BUTTON = "PS4 Buttons";
        public static String KBM_ICONS_BUTTON = "Keyboard + Mouse Buttons";
        public static String KBM_ICONS_BUTTON_TT = "KB+M icons will only be accurate " +
                                        "with the default control scheme.";
        public static String UNINSTALL_FONT_MOD_BUTTON = "Uninstall Font Mods";
        public static String HD_FONT_BUTTON = "HD Fonts";
        public static String UHD_FONT_BUTTON = "Ultra HD Fonts";
        public static String UHD_FONT_BUTTON_TT = "The author of this mod recommended " +
                                        "the HD fonts over the Ultra HD fonts.";
        public static String UNINSTALL_HEALTH_BAR_MOD_BUTTON = "Uninstall Health Bar/Crosshair Mods";
        public static String UNINSTALL_HEALTH_BAR_MOD_BUTTON_TT = "Default Health Bars/Default Crosshair";
        public static String HIGH_VIS_HEALTH_BAR_BUTTON = "High Contrast Health Bars/Default Crosshair";
        public static String COLORBLIND_HEALTH_BAR_BUTTON = "Color Blind Health Bars/Default Crosshair";
        public static String HIGH_VIS_HEALTH_BAR_REVAMPED_XHAIR_BUTTON = "High Contrast Health Bars/Revamped Crosshair";
        public static String COLORBLIND_HEALTH_BAR_REVAMPED_XHAIR_BUTTON = "Color Blind Health Bars/Revamped Crosshair";
        public static String DEFAULT_HEALTH_BAR_REVAMPED_XHAIR_BUTTON = "Default Health Bars/Revamped Crosshair";
        public static String UNINSTALL_STAT_ICON_MOD_BUTTON = "Uninstall Status Icon Mods";
        public static String REVAMPED_STAT_ICON_BUTTON = "Revamped Status Icons";
        public static String UNINSTALL_THIEF_MASK_MOD_BUTTON = "Uninstall Thief Mask Mods";
        public static String THIEF_MASK_FIX_BUTTON = "Thief Mask Texture Fix";
        public static String UNINSTALL_TREES_MOD_BUTTON = "Uninstall Tree Mods";
        public static String TREE_LOD_FIX_BUTTON = "Tree LOD Texture Fix";
        public static String UNINSTALL_SIGNS_MOD_BUTTON = "Uninstall Message & Summon Sign Mods";
        public static String HD_MESSAGES_BUTTON = "HD Player Messages";
        public static String HD_SIGNS_BUTTON = "HD Summon Signs";
        public static String UNINSTALL_FACE_MOD_BUTTON = "Uninstall Face Mods";
        public static String REVAMPED_FACES_BUTTON = "Revamped Facial Textures";
        public static String UNINSTALL_ANOR_LONDO_DISTANCE_MOD_BUTTON = "Uninstall Anor Londo Texture Mods";
        public static String HD_ANOR_LONDO_DISTANCE_TEX_BUTTON = "HD Anor Londo Distance Textures";
        public static String UNINSTALL_PAINTING_MOD_BUTTON = "Uninstall Painting Texture Mods";
        public static String HD_PAINTING_TEX_BUTTON = "HD Ariamis Painting";
        public static String HD_PAINTING_TEX_BUTTON_TT = "2048x2048";
        public static String UHD_PAINTING_TEX_BUTTON = "Ultra HD Ariamis Painting";
        public static String UHD_PAINTING_TEX_BUTTON_TT = "4096x4096";
        public static String UNINSTALL_ARROW_MOD_BUTTON = "Uninstall Arrow & Quiver Texture Mods";
        public static String ARROW_BUTTON = "Revamped Arrows";
        public static String QUIVER_BUTTON = "Revamped Quiver";
        public static String UNINSTALL_SPLASH_MOD_BUTTON = "Uninstall Splash Screen Mods";
        public static String BLACK_SPLASH_BUTTON = "Black Background Mod";
        public static String BLACK_SPLASH_BUTTON_TT = "Some players find the default " +
                                "white background irritating.";
        public static String UNINSTALL_AURA_MOD_BUTTON = "Uninstall Aura Mods";
        public static String REMOVE_AURAS_BUTTON = "Remove Player Auras";
        //
            //Tooltips
        public static String VERSION_TT = "Set this to false to hide the version"
            + " banner in the upper-left corner of the screen.\n" +
            "Note that this will also hide the clock and the node count";
        public static String OVERLAY_TT = "Set this to false to hide the in-game overlay entirely";
        public static String TEXT_ALIGNMENT_TT = "Choose where to draw text (left, center, right)";
        public static String INVASION_NOTIF_TT = "Plays the Windows Default Beep sound when invaded";
        public static String CHEATER_NOTIF_TT = "Plays the Windows Exclamation sound when playing with a cheater";
        public static String BLOCK_ARENA_FREEZE_TT = "Blocks the Battle of Stoicism arena freeze effect.\n" +
            "This effect can be abused to freeze people in place, \n" +
            "although blocking it will also prevent it from happening\n" +
            "in arena fights";
        public static String NODE_COUNT_TT = "Shows your client pool size.\n" +
            "This will show you how many clients are currently connected\n" +
            "to your multiplayer session. Useful if you need to decide\n" +
            "whether to restart the game to fix matchmaking or not.";
        public static String INCREASE_NODES_TT = "Game default is 20 clients per lobby; you can set\n" +
            "this option to 'true' to increase the limit to 32.\n" +
            "This may causes issues with multiplayer;\n" +
            "should you experience said issues, turn it off.";
        public static String FONT_SIZE_TT = "Vertical size of the in-game overlay font.\n" +
            "Default is 15; max value is 72";
        public static String FONT_SIZE_FIELD_TT = "Value must be an integer between 15 and 72";
        public static String DATE_TT = "Displays a small date stamp in the upper-left corner\n" +
            "of the screen";
        public static String TIME_TT = "Displays a small time stamp in the upper-left corner\n" +
            "of the screen";
        public static String UPDATE_TT = "Checks the remote version on https://bitbucket.org/infausto/dark-souls-pvp-watchdog/\n" +
            "and notifies if new version is available";
        public static String DSPW_DLL_CHAIN_TT = "Used to load another .dll after DSPW; enter the filename here.\n" +
            "WARNING: If the target dll doesn't export D3DCreate9,\n" +
            "this won't work and Dark Souls won't load";
        //
        
    //Language-Specific
    //Constants that I might want to change if I ever add language support (unlikely)
    public static String OPTIONS = "Options";
    public static String DIRECTORY = "directory";
    public static String STATUS = "Status";
    public static String FOLDER = "folder";
    public static String NONE = "none";
    public static String DSF_STATUS_DESC = "Signifies whether or not " + DSF +
                                           " is installed in the current directory."
                                           + "\nPossible statuses" +
                                           " include: " + DSF_STATUS[0] + ", " +
                                           DSF_STATUS[1] + ", or " +
                                           DSF_STATUS[2] + ".";
    public static String DSM_STATUS_DESC = "Signifies whether or not " + DSMOUSE +
                                           " is installed in the current directory."
                                           + "\nPossible statuses" +
                                           " include: " + DSF_STATUS[0] + ", " +
                                           DSF_STATUS[1] + ", or " +
                                           DSF_STATUS[2] + ".";
    public static String DSPW_STATUS_DESC = "Signifies whether or not " + DSPW_SHORT +
                                           " is installed in the current directory."
                                           + "\nPossible statuses" +
                                           " include: " + DSF_STATUS[0] + ", " +
                                           DSF_STATUS[1] + ", or " +
                                           DSF_STATUS[2] + ".";
    public static String CHOOSE_DIRECTORY = "Browse for " + DS + " " +
                                            DATA_FOLDER.substring(1) +" folder";
    public static String DIRECTORY_DESC = "The " + DIRECTORY + " that holds "
                                          + DS_EXE + " (Double click to open in File Explorer)";
    public static String NOT_FOUND = "Not found";
    public static String CHECKING_FOR_DS = "Checking for " + DS + " install...";
    public static String CHECKING_FOR_DSF = "Checking for " + DSF + " install...";
    public static String CHECKING_FOR_DSM = "Checking for " + DSM + " install...";
    public static String CHECKING_FOR_DSPW = "Checking for " + DSPW_SHORT + " install...";
    public static String FOUND_DS = "Found " + DS + " install in: ";
    public static String DSCUTIL_FILE_NOT_FOUND = " could not be found.";
    public static String DSF_FOUND = "Found " + DSF + " install.";
    public static String DSM_FOUND = "Found " + DSM + " install.";
    public static String DSPW_FOUND = "Found " + DSPW_SHORT + " install.";
    public static String DSF_NOT_FOUND = DSF + " is not installed in this " + DIRECTORY + ".";
    public static String DSM_NOT_FOUND = DSM + " is not installed in this " + DIRECTORY + ".";
    public static String DSPW_NOT_FOUND = DSPW_SHORT + " is not installed in this " + DIRECTORY + ".";
    public static String DSF_PARTIALLY_FOUND = "Some " + DSF + " files are missing or corrupted. Re-install it to fix.";
    public static String LOADING_USER_SETTINGS = "Loading settings from installed " + DSF + " configuration...";
    public static String LOADING_USER_KEYBINDS = "Loading keybinds from installed " + DSF + " configuration...";
    public static String LOADING_DSPW_SETTINGS = "Loading settings from installed " + DSPW_SHORT + " configuration...";
    public static String SETTINGS_LOADED = DSF + " settings loaded successfully.";
    public static String KEYBINDS_LOADED = DSF + " keybinds loaded successfully.";
    public static String DSPW_SETTINGS_LOADED = DSPW_SHORT + " settings loaded successfully.";
    public static String INSTALLING_DSF = "Installing " + DSF + "...";
    public static String INSTALLING_DSM = "Installing " + DSM + "...";
    public static String INSTALLING_DSPW = "Installing " + DSPW_SHORT + "...";
    public static String COPYING = "Copying file: ";
    public static String CREATING_INI = "Creating new " + DS_INI + " with disabled AA...";
    public static String DSF_INSTALLED_SUCCESS = DSF + " installed without issue.";
    public static String DSM_INSTALLED_SUCCESS = DSM + " installed without issue. Make " +
                                                "sure to chain " + DSM_FILES[0] + " in \"" +
                                                "Other Settings\" and apply changes";
    public static String DSPW_INSTALLED_SUCCESS = DSPW_SHORT + " installed without issue.";
    public static String TEX_MOD_INSTALLED_SUCCESS[] = {"Installed ", " texture mod."};
    public static String APPLY_DSPW_FPS_FIX = "IMPORTANT: " + DSPW_SHORT + " DLL Chain " +
                                        "has been set to " + FPS_FIX_FILES[0] + "; " +
                                        "remember to apply settings to ensure functionality.";
    public static String DSF_INSTALLED_ERRORS = DSF + " installation encountered errors.";
    public static String DSM_INSTALLED_ERRORS = DSM + " installation encountered errors.";
    public static String DSPW_INSTALLED_ERRORS = DSPW_SHORT + " installation encountered errors.";
    public static String UNINSTALLING_DSF = "Uninstalling " + DSF + "...";
    public static String UNINSTALLING_DSM = "Uninstalling " + DSM + "...";
    public static String UNINSTALLING_DSPW = "Uninstalling " + DSPW_SHORT + "...";
    public static String DSF_FILE_NOT_FOUND = "File not found: ";
    public static String FILE_DELETED = "File deleted: ";
    public static String DSF_UNINSTALLED_SUCCESS = DSF + " uninstalled without issue.";
    public static String DSM_UNINSTALLED_SUCCESS = DSM + " uninstalled without issue.";
    public static String DSPW_UNINSTALLED_SUCCESS = DSPW_SHORT + " uninstalled without issue.";
    public static String DSF_UNINSTALLED_ERRORS = "Encountered errors when attempting to uninstall " + DSF;
    public static String DSM_UNINSTALLED_ERRORS = "Encountered errors when attempting to uninstall " + DSM;
    public static String DSPW_UNINSTALLED_ERRORS = "Encountered errors when attempting to uninstall " + DSPW_SHORT;
    public static String RENAMING_FILE[] = {"Changing ", " to ", "..."};
    public static String WRITING_FILE[] = {"Attempting to write file ", "File written successfully."};
    public static String TURNING_OFF_AA = "Turning off in-game AA...";
    public static String TURNED_OFF_AA = "In-game AA was disabled.";
    public static String CHECKING_STEAM_LIBRARY = "Checking for custom Steam Library directory...";
    public static String CHECKING_FOR_DS_REG_ENTRIES = "Checking Registry for Dark Souls install...";
    public static String DSF_FILES_COPIED = DSF + " folder copied without issue.";
    public static String LAUNCHING_DS = "Launching " + DS + "...";
    public static String LAUNCHING_DSM = "Launching " + DSM_FILES[2] + "...";
    public static String LAUNCHING_DSCM = "Launching " + DSCM_FILES[1] + "...";
    public static String CHECK_FOR_DS_PROCESS = "Checking for " + DS_EXE + " process...";
    public static String FOUND_DS_PROCESS = "Found " + DS_EXE + " process.";
    public static String COULDNT_FIND_DS_PROCESS = DS_EXE + " is not running yet. ";
    public static String END_TRYING_DS_PROCESS = DS_EXE + " could not be found.";
    public static String COULDNT_CHECK_PROCESSES = "Error occurred when trying to check current process list. Defaulting to " +
                            DSCM_DELAY + " second wait timer.";
    public static String COULDNT_CHECK_PROCESS_DSM = "Error occurred when trying to check current process list. Defaulting to " +
                            DSM_DELAY + " second wait timer.";
    public static String WAITING[] = {"Waiting... ", " seconds remaining"};
    public static String RECHECKING[] = {"Rechecking... (", " tries remaining)"};
    public static String END_TRYING_DSM_PROCESS = "Mouse Fix UI is taking too long to load.";
    
    //Dialog Messages:
    public static String COPY_MESSAGE = "Auto-Copy";
    public static String COPY_MSG_TOOLTIP = "When checked, the window's content is " +
                                        "automatically copied whenever it changes (and when the " +
                                        "window is closed)";
    public static String DIALOG_TITLE_INSTALL_DSF = "Install " + DSF + "?";
    public static String DIALOG_MSG_INSTALL_DSF = DSF + " is not currently " +
                                    "installed. Install " + DSF + "?";
    public static String DIALOG_TITLE_RESET = "Restore defaults?";
    public static String DIALOG_MSG_REINSTALL = "Reinstalling " + DSF + " will revert all" +
                                    " settings to their default state. Continue?";
    public static String DIALOG_MSG_REINSTALL_DSPW = "Reinstalling " + DSPW_SHORT + " will revert all" +
                                    " settings to their default state. Continue?";
    public static String DIALOG_MSG_DSM_REINSTALL = "Reinstalling " + DSM + " will revert all" +
                                    " settings to their default state. Continue?";
    public static String DIALOG_TITLE_UNINSTALL = "Uninstall " + DSF + "?";
    public static String DIALOG_TITLE_UNINSTALL_DSPW = "Uninstall " + DSPW_SHORT + "?";
    public static String DIALOG_TITLE_DSM_UNINSTALL = "Uninstall " + DSM + "?";
    public static String DIALOG_MSG_UNINSTALL = "Are you sure you want to uninstall "
                                                + DSF + "?";
    public static String DIALOG_MSG_UNINSTALL_DSPW = "Are you sure you want to uninstall "
                                                + DSPW_SHORT + "?";
    public static String DIALOG_MSG_DSM_UNINSTALL = "Are you sure you want to uninstall "
                                                + DSM + "?";
    public static String DIALOG_BUTTON_TEXTS[] = {"OK", "Cancel", "Yes", "No",
                                                  "Continue", "Close"};
    public static String DIALOG_TITLE_INSTALL_ERR = "Installation error";
    public static String DIALOG_MSG_FILE_COPY_ERR = "Some files were not copied " +
                                            "during installation. " + DSF + " or " + DS +
                                            " game may not function correctly. " +
                                            "Clean broken installation? (Recommended)";
    public static String DIALOG_MSG_DSM_FILE_COPY_ERR = "Some files were not copied " +
                                            "during installation. " + DSM + " or " + DS +
                                            " game may not function correctly. " +
                                            "Clean broken installation? (Recommended)";
    public static String DIALOG_MSG_DSPW_FILE_COPY_ERR = "Some files were not copied " +
                                            "during installation. " + DSPW + " or " + DS +
                                            " game may not function correctly. " +
                                            "Clean broken installation? (Recommended)";
    public static String DIALOG_TITLE_PICK_DIR = "Browse for " + DATA_FOLDER.substring(1)
                                                + " folder...";
    public static String DIALOG_TITLE_NO_DS_EXE = "Warning: " + DS_EXE + " not found";
    public static String DIALOG_MSG_NO_DS_EXE = "Could not locate " + DS_EXE +
                                    " in the chosen directory. " + DSF + " will" +
                                    " have no effect on the " + DS + " game if" +
                                    " installed here.";
    public static String DIALOG_MSG_RESTORE_SETTINGS = "Restoring default " +
                                            "settings will erase all changes " +
                                            "made in this tab. Are you sure?";
    public static String DIALOG_TITLE_CFG_NOT_APPLIED = "Invalid inputs";
    public static String DIALOG_TITLE_EXPORT_INI = "Export .ini";
    public static String DIALOG_TITLE_IMPORT_INI = "Import .ini";
    public static String DIALOG_TITLE_EXPORT_DSF = "Export " + DSF;
    public static String DIALOG_TITLE_NOT_RECOMMENDED = "Not Recommended";
    public static String DIALOG_TITLE_APPLY_CHANGES = "Important: Apply changes";
    public static String DIALOG_MSG_APPLY_DSM_CHAIN = "DLL Chaining has been set " +
                                                    "for " + DSM_FILES[0] + ".\n\n" +
                                                    "It's important that you apply" +
                                                    " these changes if you want " +
                                                    DSM + " to function. " +
                                                    "(Simply click the '" + APPLY_SETTINGS + "' button)";
    public static String DIALOG_MSG_DSM_INST_FIX_CHAINING = "A " + DSMOUSE + " install was detected," +
                            " but DLL Chaining was not set to " + DSM_FILES[0] + ".";
    public static String DIALOG_MSG_APPLY_NO_DLL_CHAIN = DSM + " DLL Chaining has been " +
                            "disabled.\n\nIt's important that you apply these changes, " +
                            "otherwise " + DS + " or " + DSF + " may not function correctly. " + 
                            "(Simply click the '" + APPLY_SETTINGS + "' button)";
    public static String DIALOG_MSG_DSM_NOT_INST_FIX_CHAINING = "A " + DSMOUSE + " install was not detected," +
                            " but DLL Chaining was set to " + DSM_FILES[0] + ".";
    /*
    public static String DIALOG_MSG_TRY_ALTERNATE_NO_DOF = "The correct way to disable " + //Old unused message
                                                    "DOF is to set DOF Scaling to \"" +
                                                    "Disabled.\" This method is not " +
                                                    "recommended, but exists because " +
                                                    "the default method may not work " +
                                                    "for everyone. Are you sure you want " +
                                                    "to use this method?";
    */
    public static String DIALOG_MSG_TRY_ALTERNATE_NO_DOF = "Choosing \"No DOF\" " +
                                                "will disable Depth of Field " +
                                                "completely, but will also limit your ability " +
                                                "to customize some other graphics settings. To " +
                                                "disable the majority of DOF " +
                                                "while preserving all graphics options, " +
                                                "simply set DOF Scaling to \"Disabled\" " +
                                                "(A small amount of DOF will remain, but disabling DOF Scaling " +
                                                " also has a smaller impact on performance). " +
                                                "Do you still want to completely disable DOF?";
                                                
    public static String DIALOG_TITLE_SCREENSHOTS = "Choose screenshot folder";
    public static String DIALOG_TITLE_DLL = "Choose .dll";
    public static String DIALOG_TITLE_DISABLE_AA = "WARNING: Disable in-game AA";
    public static String DIALOG_MSG_DISABLE_AA = "Important: DSFix causes rendering issues " +
                                                   "if in-game AA is enabled. Turn off " +
                                                  "AA under \"PC Settings\" next time you " +
                                                  "launch " + DS + ".";
    public static String DIALOG_TITLE_OPEN_FOLDER_PROMPT = "Open folder?";
    public static String DIALOG_MSG_DELETE_ERRORS_PROMPT = "Errors occured when " +
                                            "attempting to uninstall. Would you " +
                                            "like to open the folder to manually " +
                                            "delete files?";
    
    //Error Messages:
    public static String UNKNOWN_VERSION = "Unable to determine program version number.";
    public static String UNSUPPORTED_DESKTOP = "Error: Unsupported desktop.";
    public static String FAILED_TO_OPEN_URL = "Error - Failed to open the following URL: ";
    public static String DS_INSTALL_NOT_FOUND = DS + " install " + DIRECTORY +
                                             " was not found. Specify location "
                                             + "via " + DIRECTORY + " browser.";
    public static String TRYING_DEFAULT_DIR_ERR = "Trying default install locations.";
    public static String CHECK_FOR_DS_NO_REG_ACC_ERR = "No registry access... ";
    public static String CHECK_FOR_DS_ITE_ERR = "InvocationTargetException during detection of " + DS + " install... ";
    public static String INVALID_FILETYPE_ERR = " is not a valid file of type: ";
    public static String INVALID_DSF_INI = " is not a valid " + DSF + " config file";
    public static String INVALID_DSF_KEYBINDS_INI = " is not a valid " + DSF + "keybinds file";
    public static String IO_EX_FILE_ERR = "IOException while reading ";
    public static String CONFIG_NOT_LOADED = "Config was not loaded.";
    public static String CONFIG_PARTIALLY_LOADED = "Config only partially loaded. "
                                                + "Settings may be corrupt. " +
                                                "Restoring default settings...";
    public static String FAILED_OPEN_FOLDER_ERR = "Failed to open folder.";
    public static String FAILED_FILE_COPY_ERR = "File failed to copy: ";
    public static String FAILED_FILE_DELETE_ERR = "Failed to delete file: ";
    public static String COULDNT_APPLY_CFG_ERR = "Config was not applied " +
                                            "because one or more settings inputs " +
                                            "are invalid.";
    public static String FILES_EDITED_ERR[] = {"Couldn't locate file: ",
                                        "\nDirectories and/or files required " +
                                        "by this program have been edited or " +
                                        "removed. Please redownload and/or " +
                                        "reinstall this program."};
    public static String FILE_WRITE_FAILED = "File write failed.";
    public static String SEE_CONSOLE = "See console log for details";
    public static String NOT_ALL_SETTINGS_APPLIED = "Not all settings could be applied. " +
                                            "File was not written.";
    public static String COULDNT_WRITE_FILE = "Could not write file. Settings were not " + 
                                            "saved.";
    public static String IOEX_FILE_WRITER = "IOException was encountered when " +
                                        "creating file writer.";
    public static String UNABLE_TO_OVERWRITE = "Unable to overwrite current DSfix.ini. " +
                                    "Make sure it is not being used by another program or process.";
    public static String UNABLE_TO_OVERWRITE_DSF_KB = "Unable to overwrite current DSfixKeys.ini. " +
                                    "Make sure it is not being used by another program or process.";
    public static String DIALOG_TITLE_WRONG_FOLDER = "Wrong folder";
    public static String DLL_MUST_BE_IN_DATA = "DLL file must be in the DATA folder " +
                                            "to be chained.";
    public static String INVALID_DLL = "Invalid DLL";
    public static String CANT_CHAIN_DLL_WITH_SELF = "Can't chain DLL with itself!";
    public static String CANT_CHAIN_DLL_WITH_DSM = "Can't chain " + DSPW_SHORT +
                                                " with " + DSM + "!";
    public static String CANT_CHAIN_DLL_WITH_DSF = "Can't chain " + DSPW_SHORT +
                                                " with " + DSF + "!";
    public static String CANT_CHAIN_DSPW_WITH_DSPW = "Can't chain " + DSPW_SHORT +
                                                " with itself!";
    public static String CANT_CHAIN_DLL_WITH_DEFAULT = "Can't chain " + DSF_FILES[0] +
                                                " with a " + DS + " game file!";
    public static String WINDOWS_XP_LANGUAGE_DISABLED = "Windows XP detected. " +
                                                "Language settings have been " +
                                                "disabled (Not supported on this OS)." +
                                                " If you aren't using Windows XP, " +
                                                "you may be running this program " +
                                                "in compatibility mode.";
    public static String FOUND_APPDATA = "Found " + APPDATA + " folder.";
    public static String UNABLE_TO_FIND_APPDATA = "Unable to find " + APPDATA +
                                        " folder. Disable AA through in-game PC settings.";
    public static String UNABLE_TO_FIND_DS_INI = "Unable to find DarkSouls.ini.";
    public static String UNABLE_TO_READ_DS_INI = "Unable to read DarkSouls.ini;" +
                                        " Disable AA through in-game PC settings.";
    public static String UNABLE_TO_READ_FILE =  "Unable to read file: ";
    public static String LAUNCH_DS_FAILED = "Unable to launch " + DS;
    public static String CONFIGURE_DSM_FAILED = "Unable to launch " + DSM_FILES[2] +
                                              "; could not configure " + DSM;
    public static String LAUNCH_DSCM_FAILED = "Unable to launch " + DSCM_FILES[1];
    public static String CANT_WRITE_DIR = "Unable to write to this directory.";
    public static String EXPORT_FAILED = "Export failed.";
    public static String COULDNT_EXPORT_INVALID_INPUT_ERR = "Config was not exported " +
                                            "because one or more settings inputs " +
                                            "are invalid.";
    public static String KEYBINDS_NOT_LOADED = "Keybinds were not loaded.";
    public static String DSPW_SETTINGS_LOAD_FAIL = DSPW_SHORT + " config file could " 
                            + "not be loaded. DSPW settings set to default values.";
    public static String DSPW_SETTINGS_LOAD_PARTIAL_FAIL = "Not all " + DSPW_SHORT +
                            " settings were loaded successfully. Using default " +
                            "values for remaining settings.";
    public static String DSPW_SETTINGS_APPLY_FAIL = " " + DSPW_SHORT + " settings could not be applied; " +
                            "configuration was not saved.";
    
    
    //Input checks:
    public static String POSITIVE_INTEGER = "Value must be a positive integer.";
    public static String SAME_RESOLUTIONS = "Render resolution should not equal " +
                                        "present resolution.";
    public static String PRES_WIDTH_TOO_LOW = "Render width can only be below " +
                            "1280 if presented width is greater than or equal to 1280";
    public static String PRES_HEIGHT_TOO_LOW = "Render height can only be below " +
                            "720 if presented height is greater than or equal to 720";
    public static String INPUT_GREATER_THAN = "Value must be a number greater than ";
    public static String INPUT_GREATER_THAN_EQ = "Value must be a number greater than or equal to ";
    public static String INPUT_TOO_LARGE = "Input is much too large; not parsable";
    public static String INPUT_FPS_TOO_HIGH = "Values significantly higher than 60 will "
                                             + "cause problems with the engine.";
    public static String LANGUAGE_WINDOWS_XP = "This setting doesn't work in Windows XP";
    public static String INVALID_DOUBLE_0_1 = "Value must be a number between 0 and 1";
    public static String SLEEP_INTERRUPTED = "Thread was disrupted while sleeping";
    
    
}
