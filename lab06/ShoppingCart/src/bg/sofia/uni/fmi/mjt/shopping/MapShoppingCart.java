package bg.sofia.uni.fmi.mjt.shopping;

import bg.sofia.uni.fmi.mjt.shopping.item.Item;

import java.util.*;

public class MapShoppingCart implements ShoppingCart {

    private Map<Item, Integer> items = new HashMap<>();

    @Override
    public Collection<Item> getUniqueItems() {
        return items.keySet();
    }

    @Override
    public void addItem(Item item) {
        if (item != null) {
            Integer occurrences = items.get(item);
            if (occurrences == null) {
                occurrences = 0;
            }
            items.put(item, ++occurrences);
        }
    }

    @Override
    public void removeItem(Item item) throws ItemNotFoundException {
        if (!items.containsKey(item)) {
            throw new ItemNotFoundException();
        }
        Integer occurrences = items.get(item);
        items.put(item, occurrences--);
    }

    @Override
    public double getTotal() {
        int total = 0;
        for (Map.Entry<Item, Integer> e : items.entrySet()) {
            total += e.getKey().getPrice();
        }
        return total;
    }

    @Override
    public Collection<Item> getSortedItems() {
        List<Item> itemsList = new ArrayList<>(items.keySet());
        itemsList.sort(Comparator.comparingDouble(Item::getPrice));
        return itemsList;
    }
}
