<h1 align="center">
	<img
		alt="KeyboardListenerAPI"
		src="https://i.imgur.com/WCpEePB.png">
</h1>
<h3 align="center">
  KeyboardListenerAPI
</h3>
KeyboardListenerAPI is designed to simplify the listening method of the original key. Through a short registration 
statement, developers can easily listen what key the player presses. However, due to the limitations of the server, 
KBLAPI can only listen a few specific keys through the events associated with Bukkit keys.

**This plugin currently only acts as an API interface. Unless other plugins require this plugin as a dependency, the plugin itself will not perform any operations**

#### Useful links
* **Release Page** - release page for the plugin.
  * [**SpigotMC**](https://www.spigotmc.org/resources/keyboardlistenerapi.121733/) 
  * [**MineBBS**](https://www.minebbs.com/resources/keyboardlistenerapi.10168/)
* **Downloads** - Download the latest version.
  * [**SpigotMC**](https://www.spigotmc.org/resources/keyboardlistenerapi.121733/history) 
  * [**MineBBS**](https://www.minebbs.com/resources/keyboardlistenerapi.10168/download)

### 📥 How to install KeyboardListenerAPI to your server?
KeyboardListenerAPI runs on **Spigot/Paper 1.13+** servers and requires **Java 11** or above.
* **First**: download the plugin jar
* **Next**: put the jar into the server plugin folder
* **Finally**: start your server
* **Done!**

To find more information, please go to [**Useful links**](#useful-links).

### 📄 API Usage
#### Import API to your project
Maven (pom.xml)
```xml
<dependencies>
    <dependency>
        <groupId>io.github.hexsook</groupId>
        <artifactId>kblapi-api</artifactId>
        <version>1.2</version>
    </dependency>
</dependencies>
```

Gradle [Kotlin DSL] (build.gradle.kts)
```kotlin
implementation("io.github.hexsook:kblapi-api:1.2")
```

Gradle [Groovy DSL] (build.gradle)
```groovy
implementation 'io.github.hexsook:kblapi-api:1.2'
```

#### Usage
To register a key listener, you need to add following code to your plugin main class:
```java
package your_package;

import io.github.hexsook.kblapi.api.Key;
import io.github.hexsook.kblapi.api.KeyboardListener;
import io.github.hexsook.kblapi.api.KeyboardListenerAPI;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class YourPluginMain extends JavaPlugin {
    @Override
    public void onEnable() {
        KeyboardListenerAPI api = KeyboardListenerAPI.get();
        api.addKeyListener(this, Key.Q, new KeyboardListener() {
            @Override
            public void pressed(Player player) {
                player.sendMessage("You pressed Q");
            }
        });
    }
}
```
Supported keys:
**Q, F, SHIFT, SHIFT+Q, SHIFT+F**

## License
KeyboardListenerAPI is free & open source. It is released under the terms of the GNU GPLv3 license.
Please see [`LICENSE.txt`](LICENSE.txt) for more information. 



