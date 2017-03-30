@echo off
REM Author: Sean Pesce
echo:
echo Make sure to run "Clean and Build" in NetBeans before running this script.
echo NOTE: If NetBeans fails to build, try restarting it (and manually deleting the /dist/ directory)
TIMEOUT 3 > nul
robocopy "%~dp0src\dscfgutil\zFiles"  "%~dp0dist\bundles\DSCfgUtil\app\src\dscfgutil\zFiles" /s /e
mkdir "%~dp0dist\bundles\DSCfgUtil\app\lib" 2> nul
copy /y "%~dp0src\apache-commons-io-2.4.jar" "%~dp0dist\bundles\DSCfgUtil\app\lib\apache-commons-io-2.4.jar"
copy /y "%~dp0src\commons-lang3-3.4.jar" "%~dp0dist\bundles\DSCfgUtil\app\lib\commons-lang3-3.4.jar"
del /f "%~dp0dist\bundles\DSCfgUtil.jar" 2> nul
del /f "%~dp0dist\bundles\DSCfgUtil.html" 2> nul
del /f "%~dp0dist\bundles\DSCfgUtil.jnlp" 2> nul
del /f "%~dp0dist\bundles\DSCfgUtil-1.0.exe" 2> nul
del /f "%~dp0dist\bundles\DSCfgUtil-1.0.msi" 2> nul
mkdir "%~dp0dist\bundles\Extras\app\src\dscfgutil\zFiles\Tex_Mods" 2> nul
robocopy "%~dp0dist\bundles\DSCfgUtil\app\src\dscfgutil\zFiles\Tex_Mods\add" "%~dp0dist\bundles\Extras\app\src\dscfgutil\zFiles\Tex_Mods\add" > nul
del /f /s /q "%~dp0dist\bundles\DSCfgUtil\app\src\dscfgutil\zFiles\Tex_Mods\add" 2> nul
rmdir "%~dp0dist\bundles\DSCfgUtil\app\src\dscfgutil\zFiles\Tex_Mods\add" /s /q
copy /y "%~dp0DSCfgUtil.iss" "%~dp0dist\bundles\DSCfgUtil.iss"
cd "%~dp0dist\bundles\"
iscc "%~dp0dist\bundles\DSCfgUtil.iss"
del /f "%~dp0dist\bundles\DSCfgUtil.iss" 2> nul
del /f /s /q "%~dp0dist\bundles\Installer" 2> nul
rmdir "%~dp0dist\bundles\Installer" /s /q
rename "%~dp0dist\bundles\Output" Installer
echo:
echo Portable app: %~dp0dist\bundles\
echo Installer:    %~dp0dist\bundles\Installer
echo Additional texture mods:    %~dp0dist\bundles\Extras
pause