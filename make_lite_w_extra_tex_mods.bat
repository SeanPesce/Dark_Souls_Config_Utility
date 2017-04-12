@echo off
REM Author: Sean Pesce

SET /p dscfgutil_version= < "%~dp0src/dscfgutil/zFiles/version"

del /f /q "%~dp0src/dscfgutil/zFiles/patches/DARKSOULS_Latest.exe" 2> nul
del /f /q "%~dp0src/dscfgutil/zFiles/patches/DARKSOULS_Beta.exe" 2> nul
del /f /q "%~dp0src/dscfgutil/zFiles/patches/DARKSOULS_Debug.exe" 2> nul

echo Task: Build ^(Lite with extra texture mods^)

echo Compiling Java...
mkdir "%~dp0build\src" 2> nul
javac -encoding "UTF-8" -d "%~dp0build\src" -classpath "C:\Program Files\Java\jdk1.8.0_121";"%~dp0src\apache-commons-io-2.4.jar";"%~dp0src\commons-lang3-3.4.jar" "%~dp0src/dscfgutil/"*.java "%~dp0src/dscfgutil/view/"*.java "%~dp0src/dscfgutil/FileIO/"*.java "%~dp0src/dscfgutil/dialog/"*.java "%~dp0src/dscfgutil/configs/"*.java

echo Copying resource files...
robocopy "%~dp0src\dscfgutil\zFiles" "%~dp0build\src\dscfgutil\zFiles" /s /e > nul
robocopy "%~dp0src\dscfgutil\style" "%~dp0build\src\dscfgutil\style" /s /e > nul
robocopy "%~dp0src\dscfgutil\package" "%~dp0build\src\dscfgutil\package" /s /e > nul
mkdir "%~dp0build\lib" 2> nul
copy /y "%~dp0src\*.jar" "%~dp0build\lib\*jar" > nul

echo Creating .jar package...
javapackager -createjar -nocss2bin -appclass dscfgutil.DSCfgUtil -classpath "lib\apache-commons-io-2.4.jar";"lib\commons-lang3-3.4.jar" -outdir "%~dp0build" -outfile DSCfgUtil -srcdir "%~dp0build\src"

del /f /s /q "%~dp0build\src\dscfgutil\configs" 2> nul > nul
rmdir "%~dp0build\src\dscfgutil\configs" 2> nul > nul
del /f /s /q "%~dp0build\src\dscfgutil\dialog" 2> nul > nul
rmdir "%~dp0build\src\dscfgutil\dialog" 2> nul > nul
del /f /s /q "%~dp0build\src\dscfgutil\FileIO" 2> nul > nul
rmdir "%~dp0build\src\dscfgutil\FileIO" 2> nul > nul
del /f /s /q "%~dp0build\src\dscfgutil\view" 2> nul > nul
del /f /q "%~dp0build\src\dscfgutil\DSCfgUtil.class" 2> nul > nul
del /f /q "%~dp0build\src\dscfgutil\DSCfgUtilConstants.class" 2> nul > nul
rmdir "%~dp0build\src\dscfgutil\view" 2> nul > nul

mkdir "%~dp0dist" 2> nul

echo Creating native .exe package...
javapackager -deploy -native image -outdir dist -outfile DSCfgUtil -srcdir "%~dp0\build" -appclass dscfgutil.DSCfgUtil -name "DSCfgUtil"  -title "Dark Souls Config Utility" -vendor "SeanP Software" -description "AIO configuration utility for Dark Souls Prepare to Die Edition" -Bruntime= -BappVersion="%dscfgutil_version%" -Bicon="src\dscfgutil\zFiles\images\DSCfgUtil.ico"

REM Create the Readme:
echo Dark Souls Configuration Utility v%dscfgutil_version% ^(Lite Build with add-on texture mod pack^) - Readme> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%LX.txt
echo:>> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%LX.txt
echo This is a Lite build of the Dark Souls Config Utility, which has a smaller file size than the standalone build, but requires Java to operate. Java can be downloaded here: https://java.com/en/download/>> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%LX.txt
echo:>> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%LX.txt
echo This package also contains the add-on texture mod pack.>> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%LX.txt
echo:>> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%LX.txt
echo For more info, visit https://github.com/SeanPesce/Dark_Souls_Config_Utility>> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%LX.txt
echo -Sean P>> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%LX.txt

echo Creating installer...
copy /y "%~dp0DSCfgUtil.iss" "%~dp0dist\bundles\DSCfgUtil.iss"
iscc "%~dp0dist\bundles\DSCfgUtil.iss"
del /f "%~dp0dist\bundles\DSCfgUtil.iss" 2> nul
del /f "%~dp0dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%LX.txt" 2> nul

mkdir "%~dp0Release" 2> nul
robocopy "%~dp0dist\bundles\DSCfgUtil" "%~dp0Release\DSCfgUtil-v%dscfgutil_version%LX_Portable" /s /e > nul
copy /y "%~dp0dist\bundles\Installer\DSCfgUtil-%dscfgutil_version%_setup.exe" "%~dp0Release\DSCfgUtil-v%dscfgutil_version%LX_Setup.exe" > nul


IF NOT "%1"=="-c" (
	pause
)


