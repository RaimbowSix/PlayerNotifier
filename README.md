# Mod for The Hypixel Pit to Monitor when an enemy joins the lobby

## Features

On join of a lobby or when an enemy joins your lobby will send a message in chat telling that the enemy is here.
When the enemy leaves the lobby you will also receive a chat message.

"§1[§bPlayerNotifier§1] §4§lEnemy §4\"" + name + "\" §ahas §ajoined §4the lobby!"
"§1[§bPlayerNotifier§1] §4§lEnemy §4\"" + name + "\" §ahas §aleft §4the lobby!"

![image](https://github.com/user-attachments/assets/290e6eba-5290-4de2-811f-930b5513100e)
![image](https://github.com/user-attachments/assets/a1fe836a-6297-4a2f-9963-405445e7e140)

## Usage

Create a watchlist.txt file in .minecraft/config and put the mod in .minecraft/mods

To compile it yourself change project SDK to java 8 and language level to 8.
![image](https://github.com/user-attachments/assets/9682b0e0-17b8-4614-9c76-ec850d8bd23a)

Then type ./gradlew build in your IDE's terminal the output will be in PlayerNotifier\build\libs

To add / remove enemies type a new line in watchlist.txt with the name of the enemy

example : 
If I want to add raimbowsix, Jeb and Notch in my list I will type raimbowsix on the first line Jeb on the second line and Notch on the third line

![image](https://github.com/user-attachments/assets/109f459b-6131-4a00-8852-f8cbf9c61816)


If you want to remove just delete the usernames from the text file.

I will later add a way to modify it while in game.
