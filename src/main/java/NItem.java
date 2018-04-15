import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by MrDis at 15/04/2018
 */
public class NItem {

    public String name;
    public ArrayList<String> description;
    public Material type = Material.STONE;
    public int amount = 1;
    public ItemMeta data;
    public boolean color = true;
    public boolean loreColor = true;

    public static NItem create(ItemStack itemStack)
    {
        return new NItem(itemStack);
    }
    public static NItem create(Material material)
    {
        return new NItem(material);
    }
    public NItem(ItemStack itemStack)
    {
        data = itemStack.getItemMeta();
        type = itemStack.getType();
        amount = itemStack.getAmount();
    }
    public NItem(Material type)
    {
        this.type = type;
    }
    public NItem(Material type, int amount)
    {
        this.type = type;
        this.amount = amount;
    }
    public NItem setAmount(int amount) {
        this.amount = amount;
        return this;
    }
    public NItem setName(String name) {
        this.name = name;
        return this;
    }
    public NItem setDescription(List<String> list) {
        this.description = new ArrayList<String>(list);
        return this;
    }
    public NItem setMeta(ItemMeta meta) {
        this.data = meta;
        return this;
    }
    public NItem setNameColor(boolean shouldUseColorName) {
        this.color = shouldUseColorName;
        return this;
    }
    public NItem setLoreColor(boolean shouldUseColorLore) {
        this.loreColor = shouldUseColorLore;
        return this;
    }
    public ItemStack make() {
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();

        if (this.data != null)
            meta = this.data;

        if (name != null)
            meta.setDisplayName((this.color ? parse(this.name) : this.name));
        if (description != null)
            meta.setLore((this.loreColor ? parse(this.description) : this.description));

        return item;
    }

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
