package bg.sofia.uni.fmi.mjt.shopping;

import bg.sofia.uni.fmi.mjt.shopping.item.Item;

import java.util.*;

public class ListShoppingCart implements ShoppingCart {

    private List<Item> list = new ArrayList<>();

    @Override
    public Collection<Item> getUniqueItems() {
        return new HashSet<>(list);
    }

    @Override
    public void addItem(Item item) {
        list.add(item);
    }

    @Override
    public void removeItem(Item item) throws ItemNotFoundException {
        if (!list.contains(item)) {
            throw new ItemNotFoundException();
        }
        for (Item i : list) {
            if (i.equals(item)) {
                list.remove(i);
            }
        }
    }

    @Override
    public double getTotal() {
        double total = 0;
        for (Item item : list) {
            total =+ item.getPrice();
        }
        return total;
    }

    private HashMap<Item,Integer> Map() {
        HashMap<Item, Integer> temp = new HashMap<>();
        for (Item item : list) {
            if (!temp.containsKey(item))
                temp.put(item, 1);
            else
                temp.put(item, temp.get(item) + 1);
        }
        return temp;
    }

    @Override
    public Set<Item> getSortedItems() {
        HashMap<Item, Integer> temp = Map();
        TreeMap<Item, Integer> itemsMap = new TreeMap<>((o1, o2) -> temp.get(o2).compareTo(temp.get(o1)));
        itemsMap.putAll(temp);
        return itemsMap.keySet();
    }
}
