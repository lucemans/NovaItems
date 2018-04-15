# NovaItems
Easily use inline Item Creation System.

This project was made since their is no easy way to do proper Item creation within the Spigot / Bukkit APIs. It supports all Spigot and Bukkit versions and does not require NMS at all.

## Requirements
Java and Bukkit / Spigot. Most server versions in the [Spigot Repository](https://hub.spigotmc.org/nexus/) are supported.

### Something doesn't work
If you are a developing using NovaItems, post your code somehwere and I would happily look into it.

## How to use

### As a dependency

```xml
<dependencies>
    <dependency>
        <groupId>nl.lucemans</groupId>
        <artifactId>NovaItems</artifactId>
        <version>1.3-SNAPSHOT</version>
    </dependency>
    ...
</dependencies>

<repositories>
    <repository>
        <id>lucemans-repo</id>
        <url>https://repo.lucemans.nl/</url>
    </repository>
    ...
</repositories>
```

### In your plugin

#### Creating an item from scratch

```java
NItem.create(Material.GOLD_AXE).make();
```
The above code simply creates a new Instance of NItem of type GOLD_AXE.
The make() function simply fabricates the ItemStack.

##### Item Properties
To set any of the following properties is fairly simple
###### Display Name
```java
NItem.create(Material.GOLD_AXE).setName("&c&lBleeding &6&lAxe").make();
```
###### Description / Lore
```java
NItem.create(Material.GOLD_AXE).setLore("This is the first line", "&rThis is the &asecond &rline").make();
```
or if you prefer using a list
```java
ArrayList<String> lore = new ArrayList<String>();
lore.add("This is the first line");
lore.add("&rThis is the &asecond &rline");
NItem.create(Material.GOLD_AXE).setLore(lore).make();
```

## Compilation

Build with `mvn clean install`. Do note that you will need the spigot jars in this repo to be installed on your
local repository.

## License

This project is licensed under the [MIT License](LICENSE).
