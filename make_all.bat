@echo off
REM Made by Sean P

SET /p dscfgutil_version= < "%~dp0src/dscfgutil/zFiles/version"
set MAKE_ALL_START_TIME=%TIME%

echo Task: Build (all versions)
del /f /s /q "%~dp0Release" 2> nul > nul
rmdir "%~dp0Release" /s /q 2> nul > nul
call make.bat -c
call make_w_extra_tex_mods.bat -c
call make_lite.bat -c
call make_lite_w_extra_tex_mods.bat -c
echo Creating Extra Texture Mods Pack...
robocopy "%~dp0src\dscfgutil\zFiles\Tex_Mods\add" "%~dp0Release\Extra_TexMod_Pack\app\src\dscfgutil\zFiles\Tex_Mods\add" /s /e > nul
call make_portable_bundles.bat -c
echo:
echo Task complete.
echo Start time: %MAKE_ALL_START_TIME%
echo End time:   %TIME%
IF NOT "%1"=="-c" (
	pause
)