Bonfire Input Fix (FPSFix+) for Dark Souls: Prepare to Die Edition
Author: Sean Pesce
(Credit to Nullby7e for the original FPSFix)




INSTALLATION:
To install the fix, download one of the two builds, extract the DLL and configuration file, and copy them into
your Dark Souls directory; the default game directory is:

C:\Program Files (x86)\Steam\steamapps\common\Dark Souls Prepare to Die Edition\DATA

To load additional library wrappers through FPSFix+, enter the name of the chained DLL in the "DllChain=" entry
in FIPSFix.ini. This fix is only compatible with the latest Steamworks version of Dark Souls.

NOTE: To chain a d3d9.dll wrapper, you must use the d3d9 build of FPSFix+, and to chain a dinput8.dll wrapper,
you must use the dinput8 build. If you're already using a wrapper for that library (such as DSFix for dinput8.dll
and PvP Watchdog for d3d9.dll), you can rename FPSFix+ and load it through the config file of the other wrapper DLL.




BACKGROUND:
This is a recreation of Nullby7e's Bonfire FPSFix, which was a solution to the bonfire input bug in Dark Souls.
Basically, if a player used the "Reverse hollowing" option at a bonfire with the framerate unlocked, there was
a significant chance that their character could get stuck when attempting to leave the bonfire (the bonfire
menu would disappear, but the player character would remain sitting at the bonfire, with no way to get up).
When this happened, the only way to remedy the issue was to restart the game. Luckily, the original FPSFix
implemented a re-bindable hotkey that the player could press to escape the bonfire if they encountered this
annoying bug.




IMPROVEMENTS:
FPSFix+ has a few improvements over the original FPSFix:

	-Automation: Removes the need for the hotkey, as FPSFix+ automatically detects and fixes the glitch when
	 it occurs. If players want to know when it happens, they can set BeepOnDetection=1 in the config
	 file (FPSFix.ini) to hear a beep every time the fix is automatically applied.

	-DLL Chaining: The original FPSFix was a wrapper for d3d9.dll, but couldn't chain additional d3d9.dll
	 wrappers. FPSFix+ has two different builds, which are wrappers for d3d9.dll and dinput8.dll, and each
	 can chain other wrappers for its respective library.

	-File size: This isn't really important, but FPSFix+ is less than one tenth of the size of the original
	 FPSFix (~80KB vs ~1300KB).


CREDITS:
	-Youri "NullBy7e" de Mooij (GitHub: https://github.com/nullby7e) for finding the pointer needed to fix
	 the bug when he made the original Bonfire FPSFix.

	-Lin "mavenlin" Min (GitHub: https://github.com/mavenlin) for his DLL Wrapper Generator, which I forked
	 a while back to modify and use for my own projects.



CONTACT:
If you have any questions/comments/concerns/suggestions, you can contact me on social media:
	-GitHub: https://github.com/SeanPesce
	-Reddit: https://reddit.com/u/SeanPesce/
	-Twitter: https://twitter.com/SeanPesce
	-YouTube: https://youtube.com/channel/UCgsMpXiR3PawqKM7MWLJGzQ
	-Discord: @SeanP#5604






