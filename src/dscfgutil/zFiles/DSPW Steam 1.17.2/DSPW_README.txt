Dark Souls PVP Watchdog
=======================

## you can also download the tool from [nexusmods](http://www.nexusmods.com/darksouls/mods/849)


## about

good evening, and thanks for choosing the Dark Souls PVP Watchdog 2014 xX420BlazeiTNoScopeSSJ7Xx as your multiplayer wingman.

read these notes thorougly please, as most of your questions will find an answer therein.

if you found this tool or the previous version useful and you want to show your appreciation, please [buy me a beer](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=UEDN2FEMUKK4C&lc=US&item_name=Dark%20Souls%20PVP%20Watchdog&item_number=DSPW&currency_code=EUR&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHosted), [donate me games](https://steamcommunity.com/id/eur0pa) or send me postcards from your country.


## well, what is it?

this tool might be helpful to identify cheaters in Dark Souls PVP, but there are a few caveats which you must consider before using this software:

 1. right now it can't ban cheaters permanently, but you can still kick them out
 2. not every form of cheating can be detected or prevented
 3. it can't help you git gud

 * it will detect anomalies and blatant forms of cheating, allowing you to remove the offender: soul level and stats coherence; amount of hp related to current equip and/or stats; spells (restricted spells, covenant-only spells, amount of casts) and equipment (un-obtainable, restricted or equipped in the wrong slots).
 * it will silently (as in you won't even notice it did that, thus more to the "useless" argument - it's just transparent to you) prevent: being cursed (6 different ways); your items from being destroyed via durability hacks (4 ways); being infected with parasite egg (5 ways); being sent home, turned human or frozen in-place (last one optional); and your covenant from being reset.
 * it will prevent people from becoming invisible (they will show up as 'hacked equip' and DSPW will let you kick them out) — it won't prevent the invisibility bug due to de-synchronization and lag from happening though
 * it will silently (as above) prevent your game from crashing when someone tries to trigger the "namecrash bug" while invading your world (or you invading theirs) in 6 different injection points, patching out long standing bugs the devs never bothered to fix
 * it will allow you to increase your node pool to its limit (32 instead of 20), and show how many clients you're actually connected to
 * it will play a sound when invading or getting invaded, useful if the game is out of focus
 * it will also prevent dangerous effects from being applied to you during pvp, will give you the chance to expand your multiplayer node db and will also fix the infamous namecrash bug.

## how to use it (w/o sweetfx)

 1. get the package from the download page
 2. extract everything into your Dark Souls DATA\ folder, generally C:\Program Files (x86)\Steam\SteamApps\common\Dark Souls Prepare to Die Edition\DATA
 3. edit dspwsteam.ini to your likings - see the lines starting with # for a detailed description for every entry
 4. play dark souls

## how to use it (w/ sweetfx) — thanks to [lotherus](http://forums.nexusmods.com/index.php?/topic/2453529-dark-souls-pvp-watchdog/page-2#entry21663599)
 1. get the package from the download page
 2. extract everything in a temporary directory
 3. rename the newly extracted d3d9.dll to d3d9_wd.dll
 4. open your sweetfx_settings.txt file and replace this line
     // external_d3d9_wrapper = none
     with
     // external_d3d9_wrapper = d3d9_wd.dll
    (yes, do keep the inline comments ' // ')
 5. move everything into the DATA folder
 6. play dark souls


#### example in-game overlay output

    (cheater, red color)
     !1 player1 @ 98ms SL120   [F1] to kick    [F5] to ignore   SL [Real 110-115]
     ^^ ^         ^    ^       ^               ^                ^ anomaly detected and details (if available)
     || |         |    |       +---------------+ commands (if available)
     || |         |    + player soul level
     || |         + player latency (if available)
     || + player name
     |+ player id
     + cheating detected

    (ignored player or player that's being blocked and is currently leaving the session, green color)
     @2 player2 @ 62ms SL110
     ^ ignored / whitelisted / leaving

    (common player, white)
     #3 player3 @ 85ms SL115
     ^ no anomalies detected


## what it can do

 * it will detect anomalies and blatant forms of cheating, allowing you to remove the offender: soul level and stats coherence; amount of hp related to current equip and/or stats; spells (restricted spells, covenant-only spells, amount of casts) and equipment (un-obtainable, restricted or equipped in the wrong slots).
 * it will silently (as in you won't even notice it did that, thus more to the "useless" argument - it's just transparent to you) prevent: being cursed (6 different ways); your items from being destroyed via durability hacks (4 ways); being infected with parasite egg (5 ways); being sent home, turned human or frozen in-place (last one optional); and your covenant from being reset.
 * it will prevent people from becoming invisible (they will show up as 'hacked equip' and DSPW will let you kick them out) — it won't prevent the invisibility bug due to de-synchronization and lag from happening though
 * it will silently (as above) prevent your game from crashing when someone tries to trigger the "namecrash bug" while invading your world (or you invading theirs) in 6 different injection points, patching out long standing bugs the devs never bothered to fix
 * it will allow you to increase your node pool to its limit (32 instead of 20), and show how many clients you're actually connected to
 * it will play a sound when invading or getting invaded, useful if the game is out of focus
 * it will also prevent dangerous effects from being applied to you during pvp, will give you the chance to expand your multiplayer node db and will also fix the infamous namecrash bug.


## what it cannot do

~~won't write that one here again. fool me once, you crafty bastards.~~

don't expect this tool to detect things that are not being sent over the wire to begin with.


## known issues

* **double rendering for the overlay text**: ensure that both the game and dsfix.ini use the same resolution


found some? issue tracker is [here](https://bitbucket.org/infausto/dark-souls-pvp-watchdog/issues), have a blast.


## appendix

### keyboard shorctuts reference

[**F1**] ..... banish all detected cheaters
[**F5**] ..... ignore all detected cheaters
[**F9**] ..... toggle the in-game overlay
[**F10**] .... show the about window


### changelog and latest fixes

** see CHANGELOG.txt i don't want to make a mess down here mhkay **


### package contents

*heh, package*

d3d9.dll ....................... the dark souls pvp watchdog dll

dspwsteam.ini .................. the options file

changelog.txt .................. change history for the tool

readme.txt ..................... the text document you're currently looking at


### resources

MetaCap: http://www.nexusmods.com/darksouls2/mods/278/

DSFix: https://github.com/PeterTh/dsfix

D3D9 Proxy-DLL: http://www.mikoweb.eu/index.php?node=28


### thanks to

every tester for the early builds dating january and february 2014, i haven't forgotten you (yet): martynoob, Querns, illusorywall, Frostitutes, wrecksan, Peeve Peeverson, Ekos89, LordoFreeman, riffautae, hostolis, PENETRON_THE_MIGHTY

[MoonDoggie42](http://reddit.com/u/colinsenner) for his precious help with the new codebase. also metacap. go fucking thank him because he's awesome.

[Gibbed](http://gib.me), who openly shared his research, a critical help

Durante for [dsfix](http://blog.metaclassofnil.com/?tag=dsfix). so much to learn from his code

[Vylandia](http://www.reddit.com/user/vylandia) for dsVfix and so much help regarding dangerous effects

JellyBaby34 aka the Cancer of DkS, because it's basically thanks to one of the most despised personalities if you can actually avoid curses and shit

[Querns](http://twitch.tv/Querns): dedicated streamer, passionate dks pvper. his extensive tests and suggestions were quintessential

[martynoob](http://reddit.com/u/notasinglenamegiven): townshit salt factory. lots of suggestions, testing and legit skill. rekt/10 would fight again.

[4chan's /dsg/](https://boards.4chan.org/vg/catalog#s=/dsg/): resident wizards and diehard (tryhard?) dks1 community. show them some love for once.
