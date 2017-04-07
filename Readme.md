# Dark Souls Configuration Utility  
**for Dark Souls: Prepare to Die Edition on PC**  
Author: Sean Pesce  
  
For source code, updates, and other information about this project, check out the [public repository on GitHub](https://github.com/SeanPesce/Dark_Souls_Config_Utility).  
  
## Background  
This is an old project that I created a few years ago with the intent to become more familiar with JavaFX and UI design. I wasn't planning on releasing it, but I found that I was repeatedly reinstalling it for myself and my friends every time we installed Dark Souls on a new computer. Yes, the file size is **way** larger than it needs to be (mostly due to the self-contained JRE), but this is far outweighed by the program's usefulness if you're a hardcore Dark Souls fan (bandwidth isn't an issue for most people these days anyway).  
  
## Disclaimer  
The code's a bit of a mess, because (as I said before) **this project was a learning experience** first and foremost. I understand that there are far better languages for a program with this scope, but efficiency and optimization were not my priorities. I might update it a bit more to finish a few things, but I probably won't be doing any code refactoring or implementing any major changes.
  
## Overview  
The Dark Souls Configuration Utility is a launcher, mod manager, and configuration tool for [Dark Souls: Prepare to Die Edition](http://store.steampowered.com/app/211420/) on PC. Dark Souls is awesome, but it's probably one of the worst PC ports of all time. Luckily, the game has a very dedicated fanbase, and the community came together to create various fixes and updates to make it more playable. Unfortunately it can be a bit of a hassle to install and configure most of these fixes, and many people can't be bothered with doing so (nor do they want to play a game as broken as this one). The Dark Souls Configuration Utility aims to mitigate this issue by providing an easy-to-use, all-in-one resource for installing and configuring the most essential community fixes/mods.  
  
## Usage and Features  
To run the Dark Souls Configuration Utility, open DSCfgUtil.exe in the main program directory (or search for "Dark Souls Config Utility" in the start menu if you used an installer). For in-depth usage and feature descriptions, see the documentation in the /docs/ folder. A video demo of the program can also be found [here](https://www.youtube.com/watch?v=OiVRokZtZAo).  
*@TODO: Add documentation in /docs/ with in-depth descriptions of usage/features.*  
  
## Compiling  
If you want to build the project yourself (rather than downloading a [pre-compiled version](https://github.com/SeanPesce/Dark_Souls_Config_Utility/releases)), simply download the project and run `make_all.bat`. However, the script will only work if you meet the following criteria:  

* [Install the JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  
* Add the JDK install directory to your %PATH% environment variable (See below for instructions)  
* Install [Inno Setup](http://www.jrsoftware.org/isdl.php)   
* Add the Inno Setup install directory to your %PATH% (See below)  
* If your JDK is installed somewhere other than `C:\Program Files\Java\jdk1.8.0_121`, you'll need to edit line 39 of `make.bat`, line 10 of `make_with_additional_tex_mods.bat`, line 39 of `make_lite.bat`, and line 10 of `make_lite_w_extra_tex_mods.bat` with your JDK directory (Maybe I'll update this script to be more universal at some point so this won't be necessary).  

After compiling the project with the batch script, the 8 different package variations (and the extra texture mods pack) will be available in the /Release/ folder.  
* **Portable** packages come in a .zip and don't require installation. They can be run from anywhere on your computer, a flash drive, etc.  
* **Setup** packages will run an installer to install the program onto your computer (adding a Start Menu entry and an Uninstall entry in the Control Panel).  
* **Lite** packages (marked with an "**L**") come **without** a self-contained Java Runtime Environment (JRE), which means that the file size is significantly smaller than the normal standalone packages. However, **you must have a JRE installed on your computer for Lite packages to function**. You can download the latest JRE [here](https://java.com/en/download/).  
* Packages marked with an "**X**" come with **additional texture mods pre-installed**. If you downloaded a package without the extra texture mods, you can download the **[extra texture mod pack](https://github.com/SeanPesce/Dark_Souls_Config_Utility/releases)** as a separate file and merge it with your program folder to install them.  
  
## Special Thanks  
This project wouldn't exist if it weren't for these guys:  

* **Peter "Durante" Thoman** ([Website](http://blog.metaclassofnil.com/), [Twitter](https://twitter.com/Durante_PT), [GitHub](https://github.com/PeterTh)) for creating [DSFix](http://www.nexusmods.com/darksouls/mods/19/), undeniably the most essential fix for Dark Souls on PC.  
* **Alessandro "eur0pa" De Micheli** ([Website](https://alessandro.pw/), [Twitter](https://twitter.com/eur0pa_), [GitHub](https://github.com/eur0pa)) for creating [Dark Souls PvP Watchdog](http://www.nexusmods.com/darksouls/mods/849/), the closest thing to anti-cheat that's available for Dark Souls: Prepare to Die Edition.  
* **Lane "Wulf2k" Hatland** ([Website](http://wulf2k.ca/), [GitHub](https://github.com/Wulf2k), [Reddit](https://www.reddit.com/user/Wulf2k/)) for creating the [Dark Souls Connectivity Mod](http://wulf2k.ca/PC/DaS/DSCM.html) to remedy the horrific wait times and general difficulties players would otherwise experience when attempting to engage in online play. Wulf2k also has some other extremely interesting work related to modding/reverse engineering Dark Souls; I highly recommend checking out his website.  
* **Nicholas "lebbers" Petska** for creating the [original Dark Souls MouseFix](http://pages.cs.wisc.edu/~petska/) to fix the awful mouse controls for players who don't own a controller.  
* **Jellybaby34** on [Reddit](https://www.reddit.com/user/Jellybaby34) for [updating Dark Souls Mouse Fix](https://www.reddit.com/r/darksouls/comments/3ay9aj/dsmfix_update_for_new_steamworks_patch/) to work with the latest version of Dark Souls.
* **Youri "NullBy7e" de Mooij** ([GitHub](https://github.com/NullBy7e)) for creating the [fix](http://www.nexusmods.com/darksouls/mods/862/) for the (relatively unknown) bonfire input glitch.
* **[BANDAI NAMCO](https://www.bandainamcoent.com/)** and (more importantly) **[From Software, Inc](http://www.fromsoftware.jp/pc_en/)** for publishing/developing Dark Souls and taking the risk by [porting it to PC](http://www.pcgamer.com/dark-souls-pc-petition-at-nearly-70000-signatures-namco-listening/) even though they had no experience in doing such ports (Note: This was before the series was hugely popular like it is today, so there was no guarantee that this move was a good business decision).  
  
  
## Other Contributors  

* **David Stellini** from [StackOverflow](http://stackoverflow.com/users/656963/david), for finding some Windows registry-related Java code that I used. He's not the original author of the code (I'm not sure who is), but he posted it in [this thread](http://stackoverflow.com/questions/62289/read-write-to-windows-registry-using-java), which is where I came across it.  

Last but not least, the creators of the texture mods included with this program:  

* [Improved aiming crosshairs](http://www.nexusmods.com/darksouls/mods/643/)*  
* [Highly Visibility Health Bars](http://www.nexusmods.com/darksouls/mods/40/)*  
* [Combination of the previous two mods](http://www.nexusmods.com/darksouls/mods/892/)*  
* [High Resolution Fonts](http://www.nexusmods.com/darksouls/mods/22)  
* [HD Player Messages](http://www.nexusmods.com/darksouls/mods/389/)  
* [HD Summon Signs](http://www.nexusmods.com/darksouls/mods/394/)  
* [Keyboard & Mouse Button icons](http://www.nexusmods.com/darksouls/mods/840/)*  
* [DualShock 3 (PS3) Button Icons](http://www.nexusmods.com/darksouls/mods/135/)  
* [DualShock 4 (PS4) Button Icons](http://www.nexusmods.com/darksouls/mods/690/)  
* [Xbox 360 Button Icons (HD)](http://www.nexusmods.com/darksouls/mods/171/)  
* [Xbox One Button Icons](http://www.nexusmods.com/darksouls/mods/1061/)*  
* [Thief Mask Texture Fix](http://www.nexusmods.com/darksouls/mods/355/)  
* [Tree LoD Texture Fix](http://www.nexusmods.com/darksouls/mods/67/)  
  * [Andre's Cranial Ember (Improved face textures)](http://www.nexusmods.com/darksouls/mods/23/)  
  * [HD Anor Londo distance textures](http://www.nexusmods.com/darksouls/mods/132/)  
  * [Black background for BANDAI NAMCO splash screen](http://www.nexusmods.com/darksouls/mods/175/)  
  * [HD Painting of Ariamis](http://www.nexusmods.com/darksouls/mods/148/)  
  * [Removed Player Auras](http://www.nexusmods.com/darksouls/mods/62/)  
  * [Revamped Status Icons](http://www.nexusmods.com/darksouls/mods/8/)  
  * [Revamped Arrows & Quiver](http://www.nexusmods.com/darksouls/mods/197/)  
  
*<sub><sup>Texture mods that I worked on to complete, fix, or improve in some way (Note: My edits aren't on the Nexus versions of these mods)</sup></sub>  
• <sub><sup>"Essential" texture mods (included in all program bundles)</sup></sub>  
◦ <sub><sup>Extra texture mods (included in program bundles with the **X** label)</sup></sub>  


  
