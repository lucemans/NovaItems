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
The ```make()``` function simply fabricates the ```ItemStack```.

#### Creating an item from another item

```java
ItemStack itemstack = new ItemStack(Material.STONE);

NItem.create(itemstack).make();
```

If you want to modify an item that you already have in the form of an ```ItemStack``` you can easily do this, just put the ```ItemStack``` in the ```create``` method and its data will be imported.

##### Item Properties
To set any of the following properties is fairly simple and self-explainatory.
###### Display Name
```java
NItem.create(Material.GOLD_AXE).setName("&c&lBleeding &6&lAxe").make();
```
The Item Display Name by default supports color codes, to disable this see [setNameColor()](#### Coloring).
##### Amount
```java
NItem.create(Material.GOLD_AXE).setName("&c&lBleeding &6&lAxe").make();
```
##### Description / Lore
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
The item's description/lore by default supports color codes, to disable this see [setLoreColor()](#### Coloring).
##### Enchantments
```java
NItem.create(Material.GOLD_AXE).setEnchantment(Enchantment.DURABILITY, 8).make();
```
To add enchantments to your Item you can use the ```setEnchantment(Enchantment, Level)``` method. As the name suggests it will add the specified enchantment with this level to the item. The system supports unsafe enchantments, this means items can have insane high or low levels, such as 5, 10, -10 or any other ```Integer```.
#### Coloring
Coloring things

## Compilation

Build with `mvn clean install`. Do note that you will need the spigot jars in this repo to be installed on your
local repository.

## License

This project is licensed under the [MIT License](LICENSE).
