# What is this?

This fix makes Dark Souls use raw mouse input without any additional smoothing or acceleration. It offers flexible keybindings, automatic cursor support for the UI, improved targeting and an easy configuration using a GUI.

# Overview

## Description

> **Important:** This is a beta version. Although it underwent some thorough testing before the first public release, there might still be some issues that need to be addressed. If you encounter any problems see the *Contact And Support* section on how to get in touch with me

Although there already is a [mouse fix](http://pages.cs.wisc.edu/~petska/) for Dark Souls, which did a great job in helping many people (including me) to play the game with mouse and keyboard over the years, it is not an optimal solution. Because it emulates a controller, there are still some issues with sensitivity, apparent negative acceleration and overall sluggish movement. Using the cursor in the UI is also a hassle, because it has to be manually enabled and disabled via keybindings.

Instead of emulating a controller, this fix injects raw mouse input directly into the game's camera functions, thereby avoiding any additional transformations. It also provides an auto cursor feature which automatically manages the visibility and capture settings of the cursor depending on the current situation.

## Features

* True raw mouse input without controller emulation
* No additional smoothing or acceleration
* Flexible options such as individual horizontal and vertical sensitivities for camera movement and bow aiming
* Allows any action to be bound to any mouse button, the mouse wheel or keyboard key
* UI Auto Cursor mode that enables and disables the cursor whether a menu is open or not
* Improved target switching
* Includes a GUI for easy configuration
* Experimental Steam Controller support
* Compatible with DSFix

# Instructions

## Supported Versions

This fix only works with the latest, fully patched Steam version.

> **Important:** The fix relies on the layout of the executable. Older versions or ones that otherwise have been tempered with probably won't work. This also means that if the game were to be patched -- which is very unlikely at this point -- it might break the fix and require it to be updated.

## Install

The fix does not make any permanent changes to the system, the game or the configuration of the game and can easily be removed (see below).

1. Install Durante's [DSFix](http://blog.metaclassofnil.com/?tag=dsfix) if you haven't already
2. Extract the contents of the `DarkSoulsMouseFix.zip` to the same folder. For example: `"C:\Program Files (x86)\Steam\steamapps\common\Dark Souls Prepare to Die Edition\DATA"`
3. Look for the `dinput8dllWrapper` line in `DSFix.ini` and set it to `dinput8dllWrapper DarkSoulsMouseFix.dll`. No additional configuration of DSFix is necessary
4. Start `DarkSoulsMouseFixGUI.exe` to set mouse setting and keybindings as desired. Don't forget to press the save button!
5. Start the game normally, for example directly through Steam. If you want to change the settings while in the game, see the *Configuration* section below on how to do that

A few additional notes on the installation:

* If you currently have DSMFix installed, it is not necessary to remove it. Just replace the `dinput8dllWrapper dsmfix.dll` entry in `DSFix.ini` with `dinput8dllWrapper DarkSoulsMouseFix.dll`
* It is not necessary to unplug the controller if you have one. You can even enable the controller on-the-fly by using the *Input Mode Toggle* binding (see *Configuration*). Contrary to previous versions it is no longer necessary to change the vibration settings
* The GUI requires the Microsoft .NET Framework 4.6.1, which should already be installed on most systems. If you are having problems starting the GUI, you can download the required version [here](https://www.microsoft.com/en-us/download/details.aspx?id=49981)
* I would recommend increasing the FPS limit to 60 in DSFix for the complete *smooth experience*. Keep in mind that there are some problems with unlocking the FPS though. You can find more information about that on PC Gaming Wiki [here](http://pcgamingwiki.com/wiki/Dark_Souls:_Prepare_to_Die_Edition#High_frame_rate)

## Uninstall

1. Set the `dinput8dllWrapper` setting in `DSFix.ini` to `none` and delete the files of the fix

# Configuration

Although the configuration using the GUI should be easy and straight-forward, there are some things to note:

* You can change settings while in the game by using the *Reload Config* binding, which is per default set to the `'-'` key on the numpad. Just change the settings in the GUI as necessary, press save and then use the binding to reload the config ingame. You may also want to enable *borderlessFullscreen* in DSFix for easier switching between the GUI and the game
* It is not necessary to bind a standard action when you are happy with the ingame setting
* It is not necessary to unbind a key or button in the ingame settings to use it with the fix
* With the exception of modifiers, every key binding in the config override the corresponding ingame bindings (but won't unbind them)
* The modifiers currently have some shortcomings (see below)
* The GUI also provides tooltips with additional information about a setting

## Auto Cursor Mode

The Auto Cursor mode automatically manages the state of the cursor behavior depending on the current situation:

* It captures and hides the cursor when ingame and not in a menu
* It releases and shows the cursor when in the main menu, in a system menu or when the window goes into background, e.g. when using alt-tab
* It overrides all cursor settings in DSFix
* There currently are a few minor issues with the Auto Cursor (see *Known Issues* below)

## Modifier Bindings

Modifiers change the behavior of a binding when they are down. The current implementation is preliminary and has some shortcomings:

* Modifiers are currently only available for movement as well as left and right attack. The implementation will be overhauled in the future to allow all actions to be bound with a modifier
* Any key or mouse button can be set as a modifier
* While a mouse wheel direction can be set as a modifier, it will not work properly, because rolling the mouse wheel cannot be *hold down*
* A key or button used as a modifier will not be blocked in the game to make it also usable as a modifier with the ingame keybindings. This also means that it may be necessary to unbind some ingame keybindings to make everything work properly

## Movement Bindings

The keybindings to move the character differ on a technical level from those you can bind ingame. They should fix the problem of sometimes not being able roll when running diagonally and not moving the camera at the same time, which existed in the game since launch. Some people also reported that the new bindings fix the problem of sometimes moving without input after exiting lock-on mode. They might also improve other things with the controls. However, further testing is needed before I can say that those problems are indeed gone and that there are no unwanted side-effects. If you try them out I would appreciate the feedback.

## Input Mode

The input mode specifies the behavior of the fix:

* Mouse: Enables raw mouse camera and keyboard standard action bindings, deactivates controller input and vibrations
* Gamepad: Standard controller behavior, disables raw mouse camera and keyboard standard action bindings
* Steam Controller (experimental): Standard controller behavior with the exception that the raw mouse camera is enabled and the right analog stick is disabled

Note that:

* The Auto Cursor setting is independent of the input mode. For example, it is possible to play with a controller and only use the mouse for menu navigation if you want to
* The input mode can be toggled with the *Input Mode Toggle* binding, which is per default set to the `'*'` key on the numpad. The toggle order is the following: Mouse -> Gamepad -> Steam Controller -> Mouse -> ...

# Additional Information

## What You Should Know

Since the fix consists of an executable DLL-File, I could have put any harmful shenanigans in there. You just have to trust me that the file is clean.

If you don't -- and why should you -- feel free to use a meta online virus scanner like VirusTotal to verify the file. Be aware however, that because the fix uses "hacking techniques" such as injection and hooking, it could trigger anti-virus software without being harmful.

## Known Issues

The Auto Cursor currently incorrectly detects the pop-up when reading a message as a menu, although the cursor cannot be used for anything. This results in an activation of the cursor and a deactivation of the camera movement if the corresponding option was set in the config. This should not be a big issue because message pop-ups disappear when you move slightly away from them. This will be fixed in a future release, but in the meantime you can just deactivate the Auto Cursor if it bothers you.

Apparently the dialog that pops up when summoning a co-op partner can currently not be controlled with the mouse cursor.

If you are experiencing keys *getting stuck* in certain situations, try to unbind the keys in the ingame settings and use the keybindings in the GUI of the mouse fix instead. Please contact me if that does not help to resolve the issue.
 
I'm also aware of an issue with borderless fullscreen, which sometimes causes the cursor not correctly being captured again after switching out of the game. At the moment I cannot tell what the cause is, because I cannot reliably reproduce it and when the mouse is captured correctly, everything works as intended as long you don't switch out of the game again. Any feedback would be appreciated.

## Acknowledgments

I would like to thank Kaibz for his extensive testing, detailed feedback and valuable suggestions during the development of the alpha versions of the fix. Without him, creating the fix would have taken even longer than it already did.

Additionally, I would also like to give a shout-out to the author of the original DSMFix for Dark Souls, which allowed me to enjoy several playthroughs of the game over the years.

Finally, I would like to thank Durante, author of DSFix, who made the game playable in the first place. Without his work, everything I've done would not be worth much.

## Contact And Support

If you want to find out about other fixes that I've done, want to contact me because you have a question, want to provide feedback, suggestions, bug reports or you want to know how to support the development of fixes like this, you can find more information at my [website](https://methanhydrat.wordpress.com/).

## Version History

### Beta 1.3:
* Added preliminary modifier bindings that turn left and right attacks into heavy attacks (see *Configuration* for details)
* Made all modifier bindings non-blocking so they can also be used as a modifier in the ingame settings where applicable (see *Configuration* for details)
* Added proper *Input Mode* setting to the config that allows easy switching between mouse and controller input (see *Configuration* for details)
* Added experimental Steam Controller support (see *Configuration* for details)
* Replaced *Toggle Mouse Fix* binding with *Toggle Input Mode*
* Fixed bug that prevented the number keys from getting bound correctly
* Fixed bug in the GUI that prevented an action from getting unbound correctly when there was a default binding for it

### Beta 1.2:
* Added option to bind movement to the config. These differ on a technical level from those in the ingame settings (see *Configuration* for details)
* Disabled hardware acceleration for the GUI to avoid conflicts with post-processing injectors such as ReShade or SweetFX
* It is now possible to resize the GUI in vertical direction to use it with low-resolution displays
* The GUI now groups options by category

### Beta 1.1.2 - Hotfix:
* The mouse wheel can now correctly be bound again to any standard action

### Beta 1.1.1 - Hotfix:
* Reverts changes regarding the mouse wheel in the previous update, which introduced a bug that caused buttons and keys to not be usable as a hold

### Beta 1.1:
* It is no longer possible to accidentally flip the camera and invert the input by looking too far up or too far down
* The camera no longer suddenly jumps when exiting lock-on/focus mode
* ~~The mouse wheel can now correctly be bound to any standard action~~

### Beta 1.0:
* Initial public release