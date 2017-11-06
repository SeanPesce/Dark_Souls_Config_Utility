@echo off
REM Made by Sean Pesce

SET /p dscfgutil_version= < "%~dp0src/dscfgutil/zFiles/version"

echo Task: Bundle and Compress portable release builds

cd Release\Extra_TexMod_Pack

REM Create the Readme:
echo Extra Texture Mods Pack - Readme> Readme_Extra_TexMod_Pack.txt
echo:>> Readme_Extra_TexMod_Pack.txt
echo To install this texture mod pack: >> Readme_Extra_TexMod_Pack.txt
echo  -Launch the Dark Souls Config Utility.>> Readme_Extra_TexMod_Pack.txt
echo  -Switch to the "Texture Mods" tab.>> Readme_Extra_TexMod_Pack.txt
echo  -Click the "Add new mod(s)" button. A prompt should be displayed.>> Readme_Extra_TexMod_Pack.txt
echo  -In the prompt, select "Texture mod pack" and press "Ok".>> Readme_Extra_TexMod_Pack.txt
echo  -Navigate to the folder containing this Readme file, and click "Select folder".>> Readme_Extra_TexMod_Pack.txt
echo  -Another prompt will be displayed. Press "Ok" again.>> Readme_Extra_TexMod_Pack.txt
echo  -That's it; the texture mod pack will begin installing.>> Readme_Extra_TexMod_Pack.txt
echo:>> Readme_Extra_TexMod_Pack.txt
echo For more info, visit https://github.com/SeanPesce/Dark_Souls_Config_Utility>> Readme_Extra_TexMod_Pack.txt
echo -Sean P>> Readme_Extra_TexMod_Pack.txt

REM Create the .zip archive:
jar -cMf Extra_TexMod_Pack.zip .\*
cd ..
copy /y "Extra_TexMod_Pack\Extra_TexMod_Pack.zip" "Extra_TexMod_Pack.zip" > nul
del /f /s /q "Extra_TexMod_Pack" 2> nul > nul
rmdir "Extra_TexMod_Pack" /s /q 2> nul > nul

cd DSCfgUtil-v%dscfgutil_version%L_Portable

REM Create the Readme:
echo Dark Souls Configuration Utility v%dscfgutil_version% ^(Portable Lite Build^) - Readme> Readme_DSCfgUtil-v%dscfgutil_version%L-P.txt
echo:>> Readme_DSCfgUtil-v%dscfgutil_version%L-P.txt
echo This is a Lite build of the Dark Souls Config Utility, which has a smaller file size than the standalone build, but requires Java to operate. Java can be downloaded here: https://java.com/en/download/>> Readme_DSCfgUtil-v%dscfgutil_version%L-P.txt
echo:>> Readme_DSCfgUtil-v%dscfgutil_version%L-P.txt
echo For more info and/or the add-on texture mod pack, visit https://github.com/SeanPesce/Dark_Souls_Config_Utility>> Readme_DSCfgUtil-v%dscfgutil_version%L-P.txt
echo -Sean P>> Readme_DSCfgUtil-v%dscfgutil_version%L-P.txt

REM Create the .zip archive:
jar -cMf DSCfgUtil-v%dscfgutil_version%L_Portable.zip .\*
cd ..
copy /y "DSCfgUtil-v%dscfgutil_version%L_Portable\DSCfgUtil-v%dscfgutil_version%L_Portable.zip" "DSCfgUtil-v%dscfgutil_version%L_Portable.zip" > nul
del /f /s /q "DSCfgUtil-v%dscfgutil_version%L_Portable" 2> nul > nul
rmdir "DSCfgUtil-v%dscfgutil_version%L_Portable" /s /q 2> nul > nul


cd DSCfgUtil-v%dscfgutil_version%LX_Portable

REM Create the Readme:
echo Dark Souls Configuration Utility v%dscfgutil_version% ^(Portable Lite Build with add-on texture mod pack^) - Readme> Readme_DSCfgUtil-v%dscfgutil_version%LX-P.txt
echo:>> Readme_DSCfgUtil-v%dscfgutil_version%LX-P.txt
echo This is a Lite build of the Dark Souls Config Utility, which has a smaller file size than the standalone build, but requires Java to operate. Java can be downloaded here: https://java.com/en/download/>> Readme_DSCfgUtil-v%dscfgutil_version%LX-P.txt
echo:>> Readme_DSCfgUtil-v%dscfgutil_version%LX-P.txt
echo This package also contains the add-on texture mod pack.>> Readme_DSCfgUtil-v%dscfgutil_version%LX-P.txt
echo:>> Readme_DSCfgUtil-v%dscfgutil_version%LX-P.txt
echo For more info, visit https://github.com/SeanPesce/Dark_Souls_Config_Utility>> Readme_DSCfgUtil-v%dscfgutil_version%LX-P.txt
echo -Sean P>> Readme_DSCfgUtil-v%dscfgutil_version%LX-P.txt

REM Create the .zip archive:
jar -cMf DSCfgUtil-v%dscfgutil_version%LX_Portable.zip .\*
cd ..
copy /y "DSCfgUtil-v%dscfgutil_version%LX_Portable\DSCfgUtil-v%dscfgutil_version%LX_Portable.zip" "DSCfgUtil-v%dscfgutil_version%LX_Portable.zip" > nul
del /f /s /q "DSCfgUtil-v%dscfgutil_version%LX_Portable" 2> nul > nul
rmdir "DSCfgUtil-v%dscfgutil_version%LX_Portable" /s /q 2> nul > nul


cd DSCfgUtil-v%dscfgutil_version%_Portable

REM Create the Readme:
echo Dark Souls Configuration Utility v%dscfgutil_version% ^(Portable Standalone Build^) - Readme> Readme_DSCfgUtil-v%dscfgutil_version%-P.txt
echo:>> Readme_DSCfgUtil-v%dscfgutil_version%-P.txt
echo This is a standalone build of the Dark Souls Config Utility, which has a larger file size than the Lite build, but can run independently on any Windows machine ^(no Java install required^).>> Readme_DSCfgUtil-v%dscfgutil_version%-P.txt
echo:>> Readme_DSCfgUtil-v%dscfgutil_version%-P.txt
echo For more info and/or the add-on texture mod pack, visit https://github.com/SeanPesce/Dark_Souls_Config_Utility>> Readme_DSCfgUtil-v%dscfgutil_version%-P.txt
echo -Sean P>> Readme_DSCfgUtil-v%dscfgutil_version%-P.txt

REM Create the .zip archive:
jar -cMf DSCfgUtil-v%dscfgutil_version%_Portable.zip .\*
cd ..
copy /y "DSCfgUtil-v%dscfgutil_version%_Portable\DSCfgUtil-v%dscfgutil_version%_Portable.zip" "DSCfgUtil-v%dscfgutil_version%_Portable.zip" > nul
del /f /s /q "DSCfgUtil-v%dscfgutil_version%_Portable" 2> nul > nul
rmdir "DSCfgUtil-v%dscfgutil_version%_Portable" /s /q 2> nul > nul


cd DSCfgUtil-v%dscfgutil_version%X_Portable

REM Create the Readme:
echo Dark Souls Configuration Utility v%dscfgutil_version% ^(Portable Standalone Build with add-on texture mod pack^) - Readme> Readme_DSCfgUtil-v%dscfgutil_version%X-P.txt
echo:>> Readme_DSCfgUtil-v%dscfgutil_version%X-P.txt
echo This is a standalone build of the Dark Souls Config Utility, which has a larger file size than the Lite build, but can run independently on any Windows machine ^(no Java install required^).>> Readme_DSCfgUtil-v%dscfgutil_version%X-P.txt
echo:>> Readme_DSCfgUtil-v%dscfgutil_version%X-P.txt
echo This package also contains the add-on texture mod pack.>> Readme_DSCfgUtil-v%dscfgutil_version%X-P.txt
echo:>> Readme_DSCfgUtil-v%dscfgutil_version%X-P.txt
echo For more info, visit https://github.com/SeanPesce/Dark_Souls_Config_Utility>> Readme_DSCfgUtil-v%dscfgutil_version%X-P.txt
echo -Sean P>> Readme_DSCfgUtil-v%dscfgutil_version%X-P.txt

REM Create the .zip archive:
jar -cMf DSCfgUtil-v%dscfgutil_version%X_Portable.zip .\*
cd ..
copy /y "DSCfgUtil-v%dscfgutil_version%X_Portable\DSCfgUtil-v%dscfgutil_version%X_Portable.zip" "DSCfgUtil-v%dscfgutil_version%X_Portable.zip" > nul
del /f /s /q "DSCfgUtil-v%dscfgutil_version%X_Portable" 2> nul > nul
rmdir "DSCfgUtil-v%dscfgutil_version%X_Portable" /s /q 2> nul > nul

IF NOT "%1"=="-c" (
	pause
)