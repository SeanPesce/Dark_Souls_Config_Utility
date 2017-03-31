# Dark Souls Configuration Utility  
**for Dark Souls: Prepare to Die Edition on PC**  
Author: Sean Pesce  
  
## Background  
This is an old project that I created a few years ago with the intent to become more familiar with JavaFX and UI design. I wasn't planning on releasing it, but I found that I was repeatedly reinstalling it for myself and my friends every time we installed Dark Souls on a new computer. The file size is **way** larger than it needs to be (mostly due to the self-contained JRE), but this is far outweighed by the program's usefulness if you're a hardcore Dark Souls fan (bandwidth isn't an issue for most people these days anyway).  
  
## Disclaimer  
First of all, there exist several other programs with the same functionality (more or less) as this one (most are smaller by orders of magnitude, but are also less feature-complete). Additionally, the code is poorly laid out and generally a bit of a mess, because (as I said before) **this project was a learning experience** first and foremost. I understand that there are far better languages for a program with this scope, but efficiency and optimization were not my priorities. I might update it a bit more to finish a few things, but I probably won't be doing any code refactoring or implementing any major changes.
  
## Overview  
The Dark Souls Configuration Utility is a launcher, mod manager, and configuration tool for [Dark Souls: Prepare to Die Edition](http://store.steampowered.com/app/211420/) on PC. Dark Souls is awesome, but it's probably one of the worst PC ports of all time. Luckily, the game has a very dedicated fanbase, and the community came together to create various fixes and updates to make it more playable. Unfortunately it can be a bit of a hassle to install and configure most of these fixes, and many people can't be bothered with doing so (nor do they want to play a game as broken as this one). The Dark Souls Configuration Utility aims to mitigate this issue by providing an easy-to-use, all-in-one resource for installing and configuring the most essential community fixes/mods.  
  
## Features  
*@TODO*  
  
## Compiling  
If you want to build the project yourself (rather than downloading a [pre-compiled version](https://github.com/SeanPesce/Dark_Souls_Config_Utility/releases)), simply download the project and run `make.bat`. However, the script will only work if you meet the following criteria:  

* [Install the JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  
* Add the JDK install directory to your %PATH% environment variable (See below for instructions)  
* Install [Inno Setup](http://www.jrsoftware.org/isdl.php)   
* Add the Inno Setup install directory to your %PATH% (See below)  
* If your JDK is installed somewhere other than `C:\Program Files\Java\jdk1.8.0_121`, you'll need to edit line 33 of `make.bat` (and/or line 8 of `make_with_additional_tex_mods.bat`) with your JDK directory (Maybe I'll update this script to be more universal at some point so this won't be necessary).  
  
## Special Thanks  
This project wouldn't exist if it weren't for these guys:  

* **Peter "Durante" Thoman** ([Website](http://blog.metaclassofnil.com/), [Twitter](https://twitter.com/Durante_PT), [GitHub](https://github.com/PeterTh)) for creating [DSFix](http://www.nexusmods.com/darksouls/mods/19/?), undeniably the most essential fix for Dark Souls on PC.  
* **Alessandro "eur0pa" De Micheli** ([Website](https://alessandro.pw/), [Twitter](https://twitter.com/eur0pa_), [GitHub](https://github.com/eur0pa)) for creating [Dark Souls PvP Watchdog](http://www.nexusmods.com/darksouls/mods/849/), the closest thing to anti-cheat that's available for Dark Souls: Prepare to Die Edition.  
* **Nicholas "lebbers" Petska** for creating the [original Dark Souls MouseFix](http://pages.cs.wisc.edu/~petska/) to fix the awful mouse controls for players who don't own a controller.  
* **Jellybaby34** on [Reddit](https://www.reddit.com/user/Jellybaby34) for [updating Dark Souls Mouse Fix](https://www.reddit.com/r/darksouls/comments/3ay9aj/dsmfix_update_for_new_steamworks_patch/) to work with the latest version of Dark Souls.
* **Youri "NullBy7e" de Mooij** ([GitHub](https://github.com/NullBy7e)) for creating the [fix](http://www.nexusmods.com/darksouls/mods/862/) for the (relatively unknown) bonfire input glitch.
* **[BANDAI NAMCO](https://www.bandainamcoent.com/)** and (more importantly) **[From Software, Inc](http://www.fromsoftware.jp/pc_en/)** for publishing/developing Dark Souls and taking the risk by [porting it to PC](http://www.pcgamer.com/dark-souls-pc-petition-at-nearly-70000-signatures-namco-listening/) even though they had no experience in doing such ports (Note: This was before the series was hugely popular like it is today, so there was no guarantee that this move was a good business decision).  
  
  
## Other Contributors  

* **David Stellini** from [StackOverflow](http://stackoverflow.com/users/656963/david), for finding some Windows registry-related Java code that I used. He's not the original author of the code (I'm not sure who is), but he posted it in [this thread](http://stackoverflow.com/questions/62289/read-write-to-windows-registry-using-java) which is where I came across it.  

*@TODO:* List of authors and links for the supported texture mods  


  