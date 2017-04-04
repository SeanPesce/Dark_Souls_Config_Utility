@echo off
REM Author: Sean Pesce

SET /p dscfgutil_version= < "%~dp0src/dscfgutil/zFiles/version"

IF "%1"=="clean" (
	echo Task: Clean
	IF "%2"=="-v" (
		echo Removing /build/ and /dist/ directories...
		del /f /s /q "%~dp0build"
		rmdir "%~dp0build" /s /q
		del /f /s /q "%~dp0dist"
		rmdir "%~dp0dist" /s /q
		del /f /s /q "%~dp0Release"
		rmdir "%~dp0Release" /s /q
		goto :done
	) ELSE (
		echo Removing /build/ and /dist/ directories...
		del /f /s /q "%~dp0build" 2> nul > nul
		rmdir "%~dp0build" /s /q 2> nul > nul
		del /f /s /q "%~dp0dist" 2> nul > nul
		rmdir "%~dp0dist" /s /q 2> nul > nul
		del /f /s /q "%~dp0Release" 2> nul > nul
		rmdir "%~dp0Release" /s /q 2> nul > nul
		goto :done
	)
) ELSE (
	echo Task: Build ^(Standard version^)

	REM Remove old build files:
	del /f /s /q "%~dp0build" 2> nul > nul
	rmdir "%~dp0build" /s /q 2> nul > nul
	del /f /s /q "%~dp0dist" 2> nul > nul
	rmdir "%~dp0dist" /s /q 2> nul > nul
	
	echo Compiling Java...
	REM Compile the .java files:
	mkdir "%~dp0build\src" 2> nul
	javac -encoding "UTF-8" -d "%~dp0build\src" -classpath "C:\Program Files\Java\jdk1.8.0_121";"%~dp0src\apache-commons-io-2.4.jar";"%~dp0src\commons-lang3-3.4.jar" "%~dp0src/dscfgutil/"*.java "%~dp0src/dscfgutil/view/"*.java "%~dp0src/dscfgutil/FileIO/"*.java "%~dp0src/dscfgutil/dialog/"*.java "%~dp0src/dscfgutil/configs/"*.java

	echo Copying resource files...
	REM Copy resource files (src/dscfgutil/style/* , src/dscfgutil/package/* , and src/dscfgutil/zFiles/*, apache lib files)
	robocopy "%~dp0src\dscfgutil\zFiles" "%~dp0build\src\dscfgutil\zFiles" /s /e > nul
	robocopy "%~dp0src\dscfgutil\style" "%~dp0build\src\dscfgutil\style" /s /e > nul
	robocopy "%~dp0src\dscfgutil\package" "%~dp0build\src\dscfgutil\package" /s /e > nul
	del /f /s /q "%~dp0build\src\dscfgutil\zFiles\Tex_Mods\add" 2> nul
	rmdir "%~dp0build\src\dscfgutil\zFiles\Tex_Mods\add" /s /q
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
	javapackager -deploy -native image -outdir dist -outfile DSCfgUtil -srcdir "%~dp0\build" -appclass dscfgutil.DSCfgUtil -name "DSCfgUtil"  -title "Dark Souls Config Utility" -vendor "SeanP Software" -description "AIO configuration utility for Dark Souls Prepare to Die Edition" -BappVersion="%dscfgutil_version%" -Bicon="src\dscfgutil\zFiles\images\DSCfgUtil.ico"

	REM Create the Readme:
	echo Dark Souls Configuration Utility v%dscfgutil_version% ^(Standalone Build^) - Readme> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%.txt
	echo:>> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%.txt
	echo This is a standalone build of the Dark Souls Config Utility, which has a larger file size than the Lite build, but can run independently on any Windows machine ^(no Java install required^).>> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%.txt
	echo:>> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%.txt
	echo For more info and/or the add-on texture mod pack, visit https://github.com/SeanPesce/Dark_Souls_Config_Utility>> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%.txt
	echo -Sean P>> dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%.txt
	
	echo Creating installer...
	copy /y "%~dp0DSCfgUtil.iss" "%~dp0dist\bundles\DSCfgUtil.iss"  2> nul > nul
	iscc "%~dp0dist\bundles\DSCfgUtil.iss"
	del /f "%~dp0dist\bundles\DSCfgUtil.iss" 2> nul
	del /f "%~dp0dist\bundles\DSCfgUtil\Readme_DSCfgUtil-v%dscfgutil_version%.txt" 2> nul
	
	mkdir "%~dp0Release" 2> nul
	robocopy "%~dp0dist\bundles\DSCfgUtil" "%~dp0Release\DSCfgUtil-v%dscfgutil_version%_Portable" /s /e > nul
	copy /y "%~dp0dist\bundles\Installer\DSCfgUtil-%dscfgutil_version%_setup.exe" "%~dp0Release\DSCfgUtil-v%dscfgutil_version%_Setup.exe" > nul
	
	goto :done
)

:done
echo Done.
IF NOT "%1"=="-c" (
	pause
)


