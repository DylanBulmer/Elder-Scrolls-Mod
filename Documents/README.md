# Elder Scrolls Mod

Ideal custom map dimentions:
* Actual size of Tamriel (according to the Areana manual) is aprox. 4,000km wide and 3,000km tall with an area of 12 million square kilometers.
* Conversion to meters (1 block in Minecraft is about 1 meter): 
    * 4,000km * 1,000m = 4,000,000m wide
    * 3,000km * 1,000m = 3,000,000m wide
	
    * This makes the area of the map about 120,000,000,000,000 meters (120 trillion meters)
        * Keep in mind this does include ocean space, the contain
        * I'm not sure if it is realistic to build the map to these dimentions, we might need to shrink it a bit.
* I found this on reddit:
    > Personally, judging by Tamriel's climate zones, I'd put it somewhere between that USA size and the Africa size. 
    > Skyrim, High Rock, and Morrowind likely stretch into the Arctic Circle given that an Aurora is visible as far south as Whiterun, 
    > and the southern parts of the continent likely stretch into the Tropics given their wet, rainforested environment. 
    > This also would place Elsweyr's desert within the subtropics, the same place that the other major deserts on Earth 
    > (Sahara, Kalahari, Outback, U.S. Southwest) exist within.
	
There are two folders:

* `./GIMP Saves`
* `./texures`

The `GIMP Saves` has all of the saves for the textures using GIMP 2.0
The `texures` folder has the exported textures for the items and blocks

The code for the Project is at https://github.com/DylanBulmer/Elder-Scrolls-Mod

If you wish to use git to easily add the textures or any new code into the project, do the following:

* Download the Github Desktop at https://desktop.github.com/
* Go to `file > Clone Repository > URL` and paste this: https://github.com/DylanBulmer/Elder-Scrolls-Mod.git
* Choose where you want the repository to be and then click `Clone`.

If you wish to program, the entire project is written in Java. I suggest to use the IntelliJ IDEA Community IDE to program in.

* Install and open IntelliJ
* Click `Import Project`
* Go to the repository folder (should be a folder called "Elder-Scrolls-Mod") and double click the `build.gradle`

* Once the project is open, go to `View > Tool Windows > Gradle`, open the `Tasks > forgegradle` folder and double click `setupDecompWorkspace`
* Once done, on the Gradle window, click the refresh button.

* When finished, go to `Run > Edit Configurations` and do the following with BOTH `Minecraft Client` and `Minecraft Server`:
* Set `Use classpath of module: ` to `Elder-Scrolls-Mod_main`.
* Set `JRE` to 1.8 if not done already.


If you need more instruction, we can talk in a discord channel.