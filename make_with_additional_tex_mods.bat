@echo off
REM Author: Sean Pesce

mkdir "%~dp0build\src" 2> nul
javac -encoding "UTF-8" -d "%~dp0build\src" -classpath "C:\Program Files\Java\jdk1.8.0_121";"%~dp0src\apache-commons-io-2.4.jar";"%~dp0src\commons-lang3-3.4.jar" "%~dp0src/dscfgutil/"*.java "%~dp0src/dscfgutil/view/"*.java "%~dp0src/dscfgutil/FileIO/"*.java "%~dp0src/dscfgutil/dialog/"*.java "%~dp0src/dscfgutil/configs/"*.java

REM Copy resource files (src/dscfgutil/style/* , src/dscfgutil/package/* , and src/dscfgutil/zFiles/*, apache lib files)
robocopy "%~dp0src\dscfgutil\zFiles" "%~dp0build\src\dscfgutil\zFiles" /s /e > nul
robocopy "%~dp0src\dscfgutil\style" "%~dp0build\src\dscfgutil\style" /s /e > nul
robocopy "%~dp0src\dscfgutil\package" "%~dp0build\src\dscfgutil\package" /s /e > nul
mkdir "%~dp0build\lib" 2> nul
copy /y "%~dp0src\*.jar" "%~dp0build\lib\*jar" > nul

javapackager -createjar -nocss2bin -appclass dscfgutil.DSCfgUtil -classpath "lib\apache-commons-io-2.4.jar";"lib\commons-lang3-3.4.jar" -outdir "%~dp0build" -outfile DSCfgUtil -srcdir "%~dp0build\src"

mkdir "%~dp0dist" 2> nul

javapackager -deploy -native image -outdir dist -outfile DSCfgUtil -srcdir "%~dp0\build" -appclass dscfgutil.DSCfgUtil -name "DSCfgUtil"  -title "Dark Souls Config Utility" -vendor "SeanP Software" -description "AIO configuration utility for Dark Souls Prepare to Die Edition" -BappVersion="0.94" -Bicon="src\dscfgutil\zFiles\images\DSCfgUtil.ico"

copy /y "%~dp0DSCfgUtil.iss" "%~dp0dist\bundles\DSCfgUtil.iss"
iscc "%~dp0dist\bundles\DSCfgUtil.iss"
del /f "%~dp0dist\bundles\DSCfgUtil.iss" 2> nul


pause



