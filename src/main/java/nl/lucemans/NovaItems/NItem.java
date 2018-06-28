package nl.lucemans.NovaItems;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Created by MrDis at 15/04/2018
 */
public class NItem {

    public String name;
    public ArrayList<String> description;
    public Material type = Material.STONE;
    public int amount = 1;
    public short durability = 0;
    public ItemMeta data;
    public HashMap<Enchantment, Integer> enchants = new HashMap<Enchantment, Integer>();
    public ArrayList<ItemFlag> flags = new ArrayList<ItemFlag>();
    public boolean color = true;
    public boolean loreColor = true;
    public ItemStack originItem = null;

    public static NItem create(ItemStack itemStack) { return new NItem(itemStack); }

    public static NItem create(Material material) { return new NItem(material); }

    public NItem(ItemStack itemStack) { originItem = itemStack; data = itemStack.getItemMeta(); type = itemStack.getType(); amount = itemStack.getAmount(); enchants = new HashMap<Enchantment, Integer> (itemStack.getEnchantments()); flags = new ArrayList<ItemFlag>(itemStack.getItemMeta().getItemFlags()); durability = itemStack.getDurability(); }

    public NItem(Material type) { this.type = type; }

    public NItem(Material type, int amount) { this.type = type; this.amount = amount; }

    public NItem(NItem item) {
        this(item.make());
    }

    // Item Properties
    public NItem setName(String name) { this.name = name; return this; }
    public NItem setAmount(int amount) { this.amount = amount; return this; }
    public NItem setDescription(List<String> list) { this.description = new ArrayList<String>(list); return this; }
    public NItem setDescription(String... list) { this.description = new ArrayList<String>(Arrays.asList(list)); return this; }
    public NItem setMeta(ItemMeta meta) { this.data = meta; return this; }
    public NItem setEnchantment(Enchantment enchantment, Integer level) { this.enchants.put(enchantment, level); return this; }
    public NItem setItemFlag(ItemFlag... flag) { this.flags.addAll(new ArrayList<ItemFlag>(Arrays.asList(flag))); return this; }
    public NItem setDurability(Short durability) { this.durability = durability; return this;}
    public NItem setColor(NBlockColor c) { this.durability = (short) c.getValue(); return this; }
    public NItem setLine(Integer line, String str) { if (this.description == null) {this.description = new ArrayList<String>();} this.description.set(line, str); return this; }

    public NItem removeName() { this.name = null; return this; }
    public NItem removeDescription() { this.description = null; return this; }
    public NItem removeMeta() { this.data = null; return this; }
    public NItem removeAllEnchantments() { this.enchants = new HashMap<Enchantment, Integer>(); return this; }
    public NItem removeEnchantment(Enchantment enchantment) { this.enchants.remove(enchantment); return this; }
    public NItem removeAllItemFlags() { this.flags = new ArrayList<ItemFlag>(); return this; }
    public NItem removeItemFlag(ItemFlag flag) { this.flags.remove(flag); return this; }

    // Color Properties
    public NItem setNameColor(boolean shouldUseColorName) {
        this.color = shouldUseColorName;
        return this;
    }
    public NItem setLoreColor(boolean shouldUseColorLore) {
        this.loreColor = shouldUseColorLore;
        return this;
    }

    // Item Fabrication
    public ItemStack make() {
        ItemStack item = null;
        if (originItem == null)
            item = new ItemStack(type, amount);
        else
            item = originItem;
        ItemMeta meta = item.getItemMeta();

        // Overwrite meta
        if (this.data != null)
            meta = this.data;

        // Set Properties
        if (name != null)
            meta.setDisplayName((this.color ? parse(this.name) : this.name));
        if (description != null)
            meta.setLore((this.loreColor ? parse(this.description) : this.description));

        // Remove all flags
        for (ItemFlag flag : meta.getItemFlags())
            meta.removeItemFlags(flag);
        // Set all flags
        for (ItemFlag flag : flags)
            meta.addItemFlags(flag);

        // Overwrite the item meta
        item.setItemMeta(meta);

        // Clear all the enchantments
        for (Enchantment ench : item.getEnchantments().keySet())
            item.removeEnchantment(ench);

        // Add our new unsafe enchantments
        item.addUnsafeEnchantments(enchants);

        item.setDurability(durability);

        return item;
    }

    // Color Parsing
    private String parse(String str) {
        return str.replaceAll("&([0-9A-Fa-fk-orK-OR])", "§$1");
    }
    private List<String> parse(List<String> str)
    {
        List<String> res = new ArrayList<String>();
        for (String _str : str)
            res.add(parse(_str));
        return res;
    }
}
