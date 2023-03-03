package P06;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    private final LinkedHashMap<String, LinkedHashMap<String, Long>> bag;
    private final long capacity;

    public Bag(long capacity) {
        this.bag = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public boolean hasCapacity(long quantityToAdd) {
        long newQuantity = this.bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + quantityToAdd;
        return this.capacity >= newQuantity;
    }

    public boolean canPutNewItem(String itemType, long itemQuantity) {
        switch (itemType) {
            case "Gem":
                if (!this.bag.containsKey(itemType)) {
                    if (this.bag.containsKey("Gold")) {
                        if (itemQuantity > getTotalQuantityOfItem("Gold")) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (getTotalQuantityOfItem(itemType) + itemQuantity > getTotalQuantityOfItem("Gold")) {
                    return false;
                }
                break;

            case "Cash":
                if (!this.bag.containsKey(itemType)) {
                    if (this.bag.containsKey("Gem")) {
                        if (itemQuantity > getTotalQuantityOfItem("Gold")) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (getTotalQuantityOfItem(itemType) + itemQuantity > getTotalQuantityOfItem("Gem")) {
                    return false;
                }
                break;
        }
        return true;
    }

    private long getTotalQuantityOfItem(String itemType) {
        return this.bag.get(itemType).values().stream().mapToLong(e -> e).sum();
    }

    public void print() {
        for (Map.Entry<String, LinkedHashMap<String, Long>> entry : this.bag.entrySet()) {
            Long sumValues = getTotalQuantityOfItem(entry.getKey());

            System.out.printf("<%s> $%s%n", entry.getKey(), sumValues);

            entry.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }

    public void putItem(String item, String itemType, long itemQuantity) {
        initialiseItemInBag(item,itemType);

        this.bag.get(itemType).put(item, this.bag.get(itemType).get(item) + itemQuantity);
    }

    private void initialiseItemInBag(String item, String itemType){
        if (!this.bag.containsKey(itemType)) {
            this.bag.put((itemType), new LinkedHashMap<>());
        }
        if (!this.bag.get(itemType).containsKey(item)) {
            this.bag.get(itemType).put(item, 0L);
        }
    }
}
