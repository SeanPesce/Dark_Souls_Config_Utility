;Author: Sean Pesce
;This file will be executed next to the application bundle image
;I.e. current directory will contain folder DSCfgUtil with application files
#define VerFile FileOpen("DSCfgUtil\app\src\dscfgutil\zFiles\version")
#define AppVer FileRead(VerFile)
#expr FileClose(VerFile)
#undef VerFile
[Setup]
AppId=dscfgutil
AppName=Dark Souls Configuration Utility
AppVersion=0.94
AppVerName=Dark Souls Config Utility v{#AppVer}
AppPublisher=Sean Pesce
AppComments=AIO Configuration Utility for Dark Souls: Prepare to Die Edition
AppCopyright=Copyright (C) 2017
AppPublisherURL=https://twitter.com/SeanPesce
AppSupportURL=https://reddit.com/u/SeanPesce
AppUpdatesURL=https://github.com/SeanPesce
DefaultDirName={pf}\SeanP Software\Dark Souls Config Utility
DisableStartupPrompt=Yes
DisableDirPage=No
DisableProgramGroupPage=Yes
DisableReadyPage=Yes
DisableFinishedPage=No
DisableWelcomePage=Yes
DefaultGroupName=SeanP Software
;Optional License:
;LicenseFile=
;WinXP or above:
MinVersion=0,5.1 
OutputBaseFilename=DSCfgUtil-{#AppVer}_setup
Compression=lzma
SolidCompression=yes
PrivilegesRequired=lowest
SetupIconFile=DSCfgUtil\app\src\dscfgutil\zFiles\images\DSCfgUtil.ico
UninstallDisplayIcon={app}\DSCfgUtil.exe
UninstallDisplayName=Dark Souls Config Utility
WizardImageStretch=No
WizardSmallImageFile=DSCfgUtil\app\src\dscfgutil\zFiles\images\DSCfgUtil-setup-icon.bmp
;WizardImageBackColor=
;WizardImageFile=
ArchitecturesInstallIn64BitMode=x64
VersionInfoVersion={#AppVer}.0.0
OutputDir=Installer
;BackColor=$2A446D
;BackColor2=clBlack



[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Files]
Source: "DSCfgUtil\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\Dark Souls Config Utility"; Filename: "{app}\DSCfgUtil.exe"; IconFilename: "{app}\DSCfgUtil.ico"; Check: returnTrue()
;Name: "{commondesktop}\DSCfgUtil"; Filename: "{app}\DSCfgUtil.exe";  IconFilename: "{app}\DSCfgUtil.ico"; Check: returnFalse()


[Run]
Filename: "{app}\DSCfgUtil.exe"; Parameters: "-Xappcds:generatecache"; Check: returnFalse()
Filename: "{app}\DSCfgUtil.exe"; Description: "{cm:LaunchProgram,DSCfgUtil}"; Flags: nowait postinstall skipifsilent; Check: returnTrue()
Filename: "{app}\DSCfgUtil.exe"; Parameters: "-install -svcName ""DSCfgUtil"" -svcDesc ""DSCfgUtil"" -mainExe ""DSCfgUtil.exe""  "; Check: returnFalse()

[UninstallRun]
Filename: "{app}\DSCfgUtil.exe "; Parameters: "-uninstall -svcName DSCfgUtil -stopOnUninstall"; Check: returnFalse()

[Tasks]
;Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; (creates desktop icon or start menu icon?)

[CustomMessages]
AppName=DSCfgUtil
LaunchProgram=Start DSCfgUtil after finishing installation

[Code]
function returnTrue(): Boolean;
begin
  Result := True;
end;

function returnFalse(): Boolean;
begin
  Result := False;
end;

function InitializeSetup(): Boolean;
begin
// Possible future improvements:
//   if version less or same => just launch app
//   if upgrade => check if same app is running and wait for it to exit
//   Add pack200/unpack200 support? 
  Result := True;
end;  