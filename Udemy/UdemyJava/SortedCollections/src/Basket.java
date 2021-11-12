import java.util.*;


// summary:
// three types of maps in java: HashMap, LinkedHashMap, TreeMap
// hashmap is the most efficient one to store data and retrieve data, but it doesn't guarantee any ordering
// linkedhashmap is like hashmap, but guarantees the iteration of entries in which they were added
// treemap maintains the keys in order (keys must implement Comparable): much more expensive to write, but it is always sorted (useful for storing a dictionary, for example - word : definition)

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }

        return 0;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }

        return s + "Total cost " + totalCost;
    }



}
