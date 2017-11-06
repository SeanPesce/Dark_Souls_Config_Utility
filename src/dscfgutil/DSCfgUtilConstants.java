/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dscfgutil;

import static dscfgutil.configs.DsTextureMod.DSFIX_TEXTURES_FOLDER;

import dscfgutil.configs.DsTextureMod;
import dscfgutil.view.DSCfgMainUI;
import javafx.css.PseudoClass;

/**
 *
 * @author Sean Pesce
 */
public class DSCfgUtilConstants {
    
	public static DSCfgMainUI MAIN_UI;
	
    //Titles, Authors, and Versions
    public static String PROGRAM_AUTHOR = "Sean Pesce";
    public static String PROGRAM_SHORT = "DSCfgUtil";
    public static String PROGRAM = "DSConfigUtil";
    public static String PROGRAM_LONG = "Dark Souls Configuration Utility";
    public static String PROGRAM_SHORTEST = "DSCU";
    public static String PROGRAM_VERSION = "x.xx";
    public static String DS = "Dark Souls";
    public static String DS_PTD = "Dark Souls: Prepare to Die Edition";
    public static String DS_AUTHOR = "From Software";
    public static String DS_AUTHOR_WEBSITE[] = {"http://www.fromsoftware.jp/pc/",
                                                "http://www.preparetodie.com/"};
    public static String DS_VERSION = "1.0.2.0";
    public static final int DS_VER_ENUM_LATEST = 0; // @TODO: Implement a real enumerator
    public static final int DS_VER_ENUM_BETA = 1;
    public static final int DS_VER_ENUM_DEBUG = 2;
    public static final int DS_VER_ENUM_UNKNOWN = 3;
    public static String[] DS_VERSIONS = { "Latest", "Beta", "Debug", "Unknown" };
    public static final long[] DS_SIZES = { 17616896, 17607240, 17630720, 0 }; // File sizes of the different versions of the Dark Souls executable
    public static final int MOD_ENUM_INSTALLED = 0; // @TODO: Implement a real enumerator
    public static final int MOD_ENUM_NOT_INSTALLED = 1;
    public static final int MOD_ENUM_PART_INSTALLED = 2;
    public static final String MOD_INFO_FILE = "\\MOD_INFO.txt";
    public static final String MOD_TITLE_KEY = "Title=";
    public static final String MOD_VERSION_KEY = "Version=";
    public static final String MOD_AUTHOR_KEY = "Author=";
    public static final String MOD_SUMMARY_KEY = "Summary=";
    public static final String MOD_DESCRIPTION_KEY = "Description=";
    public static final String MOD_WEBSITE_KEY = "Website=";
    public static final String MOD_README_KEY = "Readme=";
    public static final String MOD_CATEGORY_KEY = "Category=";
    public static final String MOD_INSTALL_SUBDIR_KEY = "InstallFolder=";
    public static final String MOD_EXCLUDE_FILE_KEY = "ExcludeFile=";
    public static final String MOD_NEXUS_ID_KEY = "NexusID=";
    public static final String UNKNOWN_MOD_TITLE = "Unknown Mod";
    public static String[] MOD_STATUS = {"Installed", "Not installed",
    														"Partially installed"};
    public static String DSF = "DSFix";
    public static String DSF_AUTHOR = "Durante";
    public static String DSF_AUTHOR_WEBSITE = "http://blog.metaclassofnil.com/";
    public static String DSF_VERSION = "2.4";
    public static String DSM = "DSMFix";
    public static String DSMOUSE = "MouseFix";
    public static String DSM_LEGACY_AUTHOR = "yrooref@tznvy.pbz";
    public static String DSM_LEGACY_AUTHOR_WEBSITE = "http://pages.cs.wisc.edu/~petska/";
    public static String DSM_LEGACY_VERSION = "09-Steamworks";
    public static String DSM_AUTHOR = "Methanhydrat";
    public static String DSM_AUTHOR_WEBSITE = "https://methanhydrat.wordpress.com/";
    public static String DSM_VERSION = "1.4 Beta";
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
    //public static String FPS_FIX = "FPS Fix";
    //public static String FPS_FIX_LONG = "Bonfire FPS Fix";
    //public static String FPS_FIX_AUTHOR = "NullBy7e";
    public static String FPS_FIX = "FPS Fix+";
    public static String FPS_FIX_LONG = "Bonfire FPS Fix+";
    public static String FPS_FIX_AUTHOR = "Sean Pesce";
    
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
        "dsfix\\tex_dump\\", DSFIX_TEXTURES_FOLDER + "\\3f28b833.png"};
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
    public static String DSM_FOLDER = "\\DarkSoulsMouseFix-v1.4.1-Beta";
    public static String DSM_FILES[] = {"DarkSoulsMouseFix.dll", "DarkSoulsMouseFix.ini",
                                            "DarkSoulsMouseFixGUI.exe" /*,
											// Unnecessary files:
                                            "DarkSoulsMouseFixReadme.md",
                                            "DarkSoulsMouseFixReadme.pdf"*/};
    public static String DSM_HELP_URL = "https://methanhydrat.wordpress.com/2017/03/02/dark-souls-mouse-fix/";
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
    public static String FPS_FIX_FOLDER = "\\FPSFix-Plus-d3d9_v2017-09-01";
    public static String FPS_FIX_FILES[] = {"FPSFix.dll", "FPSFix.ini"};
    //
        //Texture Mod Files/Directories
    public static String DSF_TEX_OVERRIDE_FOLDER = "\\dsfix\\tex_override";
    public static String TEXTURE_MODS_FOLDER = "\\Tex_Mods";
    //
        //DSCfgUtil Files/Directories
    public static String FILES_DIR = "src\\dscfgutil\\zFiles";
    public static final String TEMP_README_FILE = FILES_DIR + "\\Readme_tmp.txt";
    public static final String CONFIG_FILE = FILES_DIR + "\\config.ini";
    public static final String LOG_FILE = FILES_DIR + "\\" + PROGRAM_SHORT + ".log";
    public static String[] TEX_MOD_STORAGE_DIR_DEFAULTS = { FILES_DIR + TEXTURE_MODS_FOLDER };
    public static String TEMPLATES_DIR = FILES_DIR + "\\templates";
    public static String IMAGE_DIRECTORY = FILES_DIR + "\\images";
    public static String PATCHES_FOLDER = "\\patches";
    public static String PATCHES_DIRECTORY = FILES_DIR + PATCHES_FOLDER;
    public static String BSPATCH = "bspatch.exe";
    public static String BSPATCH_AUTHOR = "Colin Percival";
    public static String BSPATCH_AUTHOR_EMAIL = "cperciva@freebsd.org";
    public static String EXE_BACKUP[] = { "DARKSOULS_Latest.exe", "DARKSOULS_Beta.exe", "DARKSOULS_Debug.exe" };
    public static String PATCH_TO_LATEST[] = { "", "ds_patch_steambeta_to_latest", "ds_patch_debug_to_latest" };
    public static String PATCH_FROM_LATEST[] = { "", "ds_patch_latest_to_steambeta", "ds_patch_latest_to_debug" };
    public static String PROGRAM_ICON = "DSCU Icon.png";
    public static String CONSOLE_POPOUT_ICON = "Popout.png";
    public static String CSS_DIRECTORY = "/dscfgutil/style/Style.css";
    public static String INI_EXT_FILTER[] = {"ini Files (*.ini)", "*.ini"};
    public static String DLL_EXT_FILTER[] = {"dll Files (*.dll)", "*.dll"};
    public static String ZIP_EXT_FILTER[] = {"zip Archives (*.zip)", "*.zip"};
    public static String DSCU_CHECK_UPDATES_URL = "https://github.com/SeanPesce/Dark_Souls_Config_Utility/releases";
    public static String DSCU_HELP_URL = "https://github.com/SeanPesce/Dark_Souls_Config_Utility/blob/master/Readme.md";
    public static String GET_DS_URL = "https://store.steampowered.com/app/211420/";
    public static String GET_MODS_URL = "https://www.nexusmods.com/darksouls/";
    
    
    //Menus & Interface Strings/Constants
    public static PseudoClass INVALID_INPUT = PseudoClass.getPseudoClass("invalid_input");
    
    public static String ERROR = "Error";
    public static String SUCCESS = "Success";
    public static String FAIL = "Failed";
    public static String INSTALL = "Install";
    public static String UNINSTALL = "Uninstall";
    public static String NEW = "New";
    public static String OPEN = "Open";
    public static String CONFIGURE = "Configure";
    public static String DETAILS = "Details";
    public static String DELETE = "Delete";
    public static String PERMANENTLY = "Permanently";
    public static String PRINT = "Print";
    public static String WRITE = "Write";
    public static String AUTHOR = "Author";
    public static String VERSION = "Version";
    public static String README = "Readme";
    public static String OVERVIEW = "Overview";
    public static String DESCRIPTION = "Description";
    public static String WEBSITE = "Website";
    public static String NEXUS = "Nexus";
    public static String PAGE = "Page";
    public static String UNKNOWN = "Unknown";
    public static String UNCATEGORIZED = "Uncategorized";
    public static String TEXTURE_MOD = "Texture Mod";
    public static String PACK = "Pack";
    public static String UNSAFE_OPERATION = "Unsafe operation";
    public static String PROCESSING = "Processing data";
    
    public static String PRINT_INFO = PRINT + " info";
    
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
            public static String OPEN_PROGRAM_DIR = "Open program folder";
            // public static String OPEN_PROGRAM_DIR_TOOLTIP = "Opens the " + PROGRAM + " directory in Windows File Explorer";
            public static String EXIT_PROGRAM = "Exit";
        //Dark Souls Menu
            public static String LAUNCH = "Launch";
            public static String CONFIGURE_DS = "Change in-game settings";
            public static String OPEN_DATA_FOLDER = "Open DATA folder";
            public static String DS_VERSION_MENU = "Game version...";
                public static String CHECK_DS_VERSION = "Recheck version";
                public static String CHANGE_DS_VERSION = "Switch version...";
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
        //public static String TEXTURE_MODS = "Texture Mods";
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
        public static String LANGUAGES[] = {"No override", "English", "French/Français",
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
        public static final int DSPW_DEFAULT_KEYBINDS[] = { 112, 116, 120, 121 };
        public static String TRUE_FALSE[] = {"true", "false"};
        public static String BLOCK_FREEZE_CHOICES[] = {"Block", "Don't block"};
        //
        //FPSFix key strings/data
        public static final int FPS_FIX_DEFAULT_KEY = 100;
        //General Settings panes strings
        public static String APPLY_SETTINGS = "Apply settings";
        public static String APPLY_KEYBINDS = "Apply keybinds";
        public static String RESTORE_DEFAULTS = "Restore defaults";
        public static String SET_KEYBIND = "Change keybind";
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
        public static String DOF_OVERRIDE_DISABLE_DOF = "Disable DOF";
        public static String DOF_SCALING_LABEL = "DOF Scaling: ";
        public static String DOF_ADD_BLUR_LABEL = "DOF Additional Blur: ";
        public static String DOF_NO_ADD_BLUR_LABEL = "Off (No additional blur)";
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
        public static String DOF_DISABLE_TT = "Disable Depth of Field completely\n(for sharpest possible image)";
        public static String DOF_ENABLE_TT = "Unselect to enable Depth of Field";
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
        public static String TEX_MOD_DISCLAIMER = "Note: Texture mods will only work " +
                                    "if 'Texture Override' is enabled in the DSFix " +
                                    "texture settings.";
        public static String LOAD_TEX_MOD = "Add new mod(s)";
        public static String LOAD_TEX_MOD_TT = "Load new texure mod(s) into this program for easy installing";
        public static String DELETE_TEX_MOD_TT = "Permanently remove this mod entry from the program and delete the files from disk";
        public static String LOAD_TEX_MOD_DIALOG_TITLE = "Load new texture mod(s)";
        public static String LOAD_TEX_MOD_DIALOG_MESSAGE = "Loading a texture mod into this program adds a permanent entry for the mod, allowing you to install and uninstall the mod more easily in the future.";
        public static String LOAD_TEX_MOD_DIALOG_CHOICES[] = { "Single texture mod", "Texture mod pack" };
        public static String LOAD_TEX_MOD_DIALOG_CHOICES_TT[] = { "Load a texture mod from one directory that contains texture replacement files (PNG/DDS)",
        															"Load multiple texture mods from a directory that contains one or more sub-folders,\neach of which contains texture replacement files (PNG/DDS)" };
        public static String LOAD_TEX_MOD_DIALOG_ZIP = "Load from .zip file";
        public static String DELETE_TEX_MOD_SRC_DIALOG = "Delete source files (Not recommended)";
        public static String DELETE_TEX_MOD_SRC_DIALOG_TT = "Select to permanently delete the folder that the mod was installed from.";
        public static String DELETE_TEX_MOD_SRC_DIALOG_ZIP = "Delete source archive (Not recommended)";
        public static String DELETE_TEX_MOD_SRC_DIALOG_ZIP_TT = "Select to permanently delete the .zip archive that the mod was installed from.";
        public static String DELETE_TEX_PACK_SRC_DIALOG_TT = "Select to permanently delete the folder that the mods were installed from.";
        public static String DELETE_TEX_PACK_SRC_DIALOG_ZIP_TT = "Select to permanently delete the .zip archive that the mods were installed from.";
        public static String LOAD_TEX_MOD_DIALOG_ZIP_TT = "Select this to load texture mod(s) from a .zip file instead of a normal folder";
        public static String LOAD_TXM_DIAG_INVALID_TITLE = "Invalid " + TEXTURE_MOD.toLowerCase() + " directory";
        public static String[] LOAD_TXM_DIAG_INVALID_MSGS = { "Unable to load new texture mod because the chosen directory is not a valid source. Reason: ",
        														"Read access denied, or the folder does not exist.",
        														"The specified file is not a directory.",
        														UNSAFE_OPERATION + ": Can't use drive root as source directory.",
        														"No valid texture files in base directory. Valid filetypes are PNG and DDS.",
        														UNSAFE_OPERATION + ": Too many files in source directory tree. Maximum allowed file count is " + DsTextureMod.MAX_ALLOWED_FILES + ".",
        														"Source folder can't be the " + PROGRAM + " directory or one of its subfolders.",
        														"Source folder can't be a mod storage directory or a subfolder of one.",
        														"Source folder has the same name as an existing texture mod folder."};
        public static String LOAD_TEX_MOD_CHECK_DIR_SUCCESS_MESSAGE = "Verified valid texture mod directory";
        public static String LOAD_TEX_MOD_SUCCESS_MESSAGE = "Texture mod was loaded without issue";
        public static String COPY_DIAG_CONFIRM_TITLE = "Copy files?";
        public static String LOAD_TXM_DIAG_CONFIRM_MSG[] = { "All files from source folder will be copied to the " + PROGRAM + " texture mod storage directory, and a new entry"
        														+ " will appear in the Texture Mods tab.\n\nSource folder:\t\t", "\nNumber of files:\t",
        														"\n\nCopy files?" };
        public static String LOAD_TXM_START = "Attempting to load new texture mod. Copying files...";
        public static String LOAD_TXM_CANCEL = "Cancelled. No new texture mods loaded.";
        public static String LOAD_TXM_DEL_OLD_EXTRACT = "Found leftover files from previous archive extraction. Deleting...";
        public static String LOAD_TXM_EXTRACT_START = "Unzipping ";
        public static String LOAD_TXM_EXTRACT_FAIL = "Failed to unzip file ";
        public static String LOAD_TXM_EXTRACT_DONE = "Files were extracted from ";
        public static String LOAD_TXM_REMOVE_PARTIAL = "Encountered errors. Attempting to remove newly copied files...";
        public static String LOAD_TXM_REMOVE_PARTIAL_DONE = "New mod was not loaded because errors were encountered.";
        public static String LOAD_TXM_REMOVE_PARTIAL_SUCCESS = LOAD_TXM_REMOVE_PARTIAL_DONE + " No changes were made.";
        public static String LOAD_TXM_REMOVE_PARTIAL_FAIL = LOAD_TXM_REMOVE_PARTIAL_DONE + " Leftover files from the unsuccessful load might still be present in the storage directory";
        public static String LOAD_TEX_PACK_CONFIRM_DIAG_TITLE = "Load texture mod pack?";
        public static String LOAD_TEX_PACK_CONFIRM_DIAG_MSG[] = { "For each texture mod folder, all files will be copied to the " + PROGRAM + " texture mod storage directory, and a new entry"
																	+ " will appear in the Texture Mods tab.\n\nSource folder:\t\t", "\nTexture mod folders:\t", "\nIgnored folders:\t", "\nIgnored files:\t",
																	"\n\nCopy files?" };
        public static String LOAD_TEX_PACK_NO_MODS_DIAG_TITLE = "No mods in source directory";
        public static String LOAD_TEX_PACK_NO_MODS_DIAG_MSG = "Source directory must contain at least one texture mod folder.";
        public static String[] LOAD_TEX_PACK_START = { "Attempting to load new texture mod pack (Contains ", " texture mods)" };
        public static String[] LOAD_TEX_PACK_DONE = { " out of ", " texture mods were loaded." };
        public static String LOAD_TEX_PACK_DONE_TITLE = " mods loaded";
        public static String TEX_MOD_CONFIGURE_TT = "Double-click to configure this texture mod";
        public static String OPEN_README = OPEN + " " + README + " " + FILE.toLowerCase();
        public static String NO_README_AVAILABLE = "No " + README + " found for this mod; a basic " + README + " file will be automatically generated.";
        public static String NEXUS_HOME = OPEN + " " + DS + " " + NEXUS + " homepage (no " + NEXUS + " page supplied)";
        public static String REMOVE_PART_INSTALL = "Remove partial " + INSTALL.toLowerCase();
        public static String EDIT_TEX_MOD_DIALOG_TITLE = "Configure texture mod";
        public static String DELETE_TEX_MOD_DIALOG_TITLE = "Delete texture mod?";
        public static String DELETE_TEX_MOD_DIALOG_MSG = "Are you sure you want to delete this mod? Doing so will permanently remove the mod entry from this program"
        										+ " and delete the files from the hard drive. You will have to re-acquire the mod before it can be installed again.";
        public static String DELETE_TEX_MOD_AND_UNINSTALL = "Uninstall mod from game directory";
        public static String DELETE_TEX_MOD_AND_UNINSTALL_TT = "One or more files from this mod are present in the " + DS + " game\n"
        													+ "directory. If selected, this option will remove the files from the game\n"
        													+ "folder before deleting the mod from this program.";
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
    public static String GAME_VERSION = "Game Version";
    public static String FOLDER = "folder";
    public static String NONE = "none";
    public static String DS_VERSION_DESC = "Signifies the version of " + DS + " installed on this machine.\n"
                                        + "Supported versions are \"" + DS_VERSIONS[0] + "\", \"" + DS_VERSIONS[1]
                                        + "\", or \"" + DS_VERSIONS[2] + "\".";
    public static String DS_VERSION_WARN_DESC = "Warning: The Beta and Debug versions of " + DS
                                                + " will\nNOT work if mods are installed!";
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
    public static String DS_VERSION_CHECKING = "Checking game version...";
    public static String DS_VERSION_SWITCHING = "Switching " + DS_EXE + " to build: ";
    public static String DS_VERSION_CREATING_BACKUP = "Creating game backup: ";
    public static String DS_VERSION_PATCHING[] = { "Creating patched file ", " using source file " };
    public static String DS_VERSION_REMOVING_INVALID_BACKUP = "Removing corrupt game backup: ";
    public static String DS_VERSION_DETECTED[] = { "Detected latest supported build.", "Detected Steamworks beta build.", "Detected Debug build.", "Unknown game version" };
    public static String DS_VERSION_DETECTED_UNKNOWN = ": " + DS_EXE + " exists, but the build version could not be determined.";
    public static String DS_VERSION_DETECTED_MISSING = ": " + DS_EXE + " is missing!";
    public static String INSTALLING = "Installing ";
    public static String INSTALLING_DSF = "Installing " + DSF + "...";
    public static String INSTALLING_DSM = "Installing " + DSM + "...";
    public static String INSTALLING_DSPW = "Installing " + DSPW_SHORT + "...";
    public static String COPYING = "Copying file: ";
    public static String CREATING_INI = "Creating new " + DS_INI + " with disabled AA...";
    public static String INSTALLED_SUCCESS = " installed without issue.";
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
    public static String PERM_DELETING = "Permanently deleting ";
    public static String UNINSTALLING = "Uninstalling ";
    public static String UNINSTALLING_DSF = "Uninstalling " + DSF + "...";
    public static String UNINSTALLING_DSM = "Uninstalling " + DSM + "...";
    public static String UNINSTALLING_DSPW = "Uninstalling " + DSPW_SHORT + "...";
    public static String DSF_FILE_NOT_FOUND = "File not found: ";
    public static String FILE_DELETED = "File deleted: ";
    public static String UNINSTALLED_SUCCESS = " was successfully uninstalled.";
    public static String DELETED_SUCCESS = " files were successfully deleted.";
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
    
    
    // Startup strings:
    	// Config key values:
    public static String LOG_FILE_KEY = "WriteLogToFile=";
    public static String SHOW_CONSOLE_KEY = "ShowConsole=";
    public static String WINDOW_WIDTH_KEY = "WindowWidth=";
    public static String WINDOW_HEIGHT_KEY = "WindowHeight=";
    public static String WINDOW_X_OFFSET_KEY = "WindowOffsetX=";
    public static String WINDOW_Y_OFFSET_KEY = "WindowOffsetY=";
    public static String CONSOLE_X_OFFSET_KEY = "ConsoleWindowOffsetX=";
    public static String CONSOLE_Y_OFFSET_KEY = "ConsoleWindowOffsetY=";
    public static String TEX_MOD_STORAGE_DIR_KEY = "TextureModStorageDir=";
    	//Messages:
    public static String CONFIG = "Config";
    public static String ENTRY = "Entry";
    public static String CONFIG_ENTRY_PREFIX = "[" + CONFIG + " " + ENTRY + "] ";
    public static String LOADING_PROGRAM_CONFIG = "Loading " + PROGRAM + " configuration file...";
    public static String LOADING_PROGRAM_CONFIG_FAIL = "Failed to read " + PROGRAM + " configuration file.";
    public static String WRITE_PROGRAM_CONFIG_FAIL = "Failed to write " + PROGRAM + " configuration file.";
    public static String CONFIG_TEX_MOD_DIR_OK = "Adding texture mod library";
    public static String CONFIG_TEX_MOD_DIR_FAIL = "Ignored invalid texture mod library entry";
    public static String CONFIG_LOG_FILE_ENABLE = "Console log file enabled.";
    public static String CONFIG_LOG_FILE_DISABLE = "Console log file disabled.";
    public static String CONFIG_WINDOW_WIDTH = "Main window width set to ";
    public static String CONFIG_WINDOW_HEIGHT = "Main window height set to ";
    public static String CONFIG_WINDOW_X_OFFSET = "Main window X offset set to ";
    public static String CONFIG_WINDOW_Y_OFFSET = "Main window Y offset set to ";
    public static String[] CONFIG_SHOW_CONSOLE = { "Console bar and console window hidden.", "Console bar enabled and console window hidden.", "Console bar hidden and console window enabled." };
    public static String CONFIG_CONSOLE_X_OFFSET = "Console window X offset set to ";
    public static String CONFIG_CONSOLE_Y_OFFSET = "Console window Y offset set to ";
    public static String[] LOADING_TEX_MOD_DIR_COUNT = { "Loading texture mods from ", " director", "y", "ies" };
    
    
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
                                                  "Continue", "Close", "Done",
                                                  "Apply", "Discard"};
    public static String DIALOG_NO_CHOICES = "No available options to display.";
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
    public static String DIALOG_TITLE_SET_KEYBIND = "New keybind";
    public static String DIALOG_MSG_SET_KEYBIND = "Press any key to assign a new keybind.";
    
    //Error Messages:
    public static String UNKNOWN_VERSION = "Unable to determine program version number.";
    public static String UNSUPPORTED_DESKTOP = "Error: Unsupported desktop.";
    public static String FAILED_TO_OVERWRITE = "Error: Failed to overwrite ";
    public static String FAILED_TO_PATCH = "Error: Failed to create patched version of ";
    public static String FAILED_TO_OPEN_URL = "Error - Failed to open the following URL: ";
    public static String SAME_VERSION = "That version of " + DS + " is already installed.";
    public static String CANT_PATCH = "Error: Can't patch; ";
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
    public static String CONFIG_TOO_MANY_LOADED = "WARNING: Some settings may have been loaded more than once.";
    public static String CONFIG_PARTIALLY_LOADED = "Config only partially loaded. "
                                                + "Settings may be corrupt. " +
                                                "Restoring default settings...";
    public static String CONFIG_SETTING_NOT_LOADED = " was not loaded correctly. Setting to default value...";
    public static String FAILED_OPEN_FOLDER_ERR = "Failed to open folder";
    public static String FAILED_FILE_COPY_ERR = "File failed to copy: ";
    public static String FAILED_FILE_DELETE_ERR = "Failed to delete file: ";
    public static String FAILED_FOLDER_DELETE_ERR = "Failed to delete folder: ";
    public static String FAILED_FILE_PATCH_ERR = "Failed to create patched file: ";
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
    public static String WARNING_DSPW_CORRUPT = "WARNING: " + DSPW_SHORT + " installation may have been"
                                                + " corrupted. Re-installation recommended.";
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
    public static String SHA1_ERROR = "ERROR calculating SHA-1 hash. ";
    public static String SHA1_FNF_ERROR = SHA1_ERROR + DSF_FILE_NOT_FOUND;
    public static String SHA1_IOE_ERROR = SHA1_ERROR + " Failed to open filestream for file: ";
    public static String INVALID_HASH_ALGORITHM = "ERROR: Invalid hash algorithm specified ";
    public static String MOD_FOLDER_NOT_FOUND = "Specified mod folder does not exist.";
    public static String MOD_FOLDER_NOT_DIR = "Specified mod folder must be a directory.";
    public static String README_NOT_FOUND = "ERROR: Failed to locate specified Readme file ";
    public static String README_NOT_EXIST = "No Readme found; this basic Readme file was automatically generated.";
    public static String README_NOT_OPENED_ERR = "ERROR: Unable to open Readme file: ";
    public static String INFO_NOT_WRITTEN_ERR = "ERROR: Unable to write " + MOD_INFO_FILE.substring(1) + " for mod: ";
    public static String MOD_WEBSITE_NOT_EXIST = "ERROR: No website info was provided for this mod.";
    public static String WEBSITE_CANT_ACCESS = "ERROR: Unable to open website: ";
    public static String INSTALL_ERRORS = "Errors encountered while attempting to install ";
    public static String UNINSTALL_ERRORS = "Errors were encountered while attempting to uninstall ";
    public static String DELETE_ERRORS = "Errors were encountered while attempting to delete ";
    public static String FAIL_CLEAR_README_TMP_ERR = "ERROR: Unable to write Readme temp file. Leftover data may still be present.";
    public static String FAIL_CLEAR_LOG_ERR = "ERROR: Unable to clear log file. Data from last session may still be present.";
    public static String DUPLICATE_MOD_WARN = "WARNING: Duplicate mods detected ";
    public static String WAIT_VERIFY_FOLDER = "Verifying folder, please wait";
}
