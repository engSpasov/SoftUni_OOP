package P06_GreedyTimes;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    private LinkedHashMap<String, Long> bag;
    private LinkedHashMap<String, Long> goldMap;
    private LinkedHashMap<String, Long> gemMap;
    private LinkedHashMap<String, Long> cashMap;

    private long capacity;

    public Bag(long capacity) {
        this.bag = new LinkedHashMap<>();
        this.bag.put("Gold", 0L);
        this.bag.put("Gem", 0L);
        this.bag.put("Cash", 0L);
        this.goldMap = new LinkedHashMap<>();
        this.goldMap.put("Gold", 0L);
        this.gemMap = new LinkedHashMap<>();
        this.cashMap = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public boolean hasEnoughFreeCapacity(long itemQuantity) {
        long usedCapacity = 0;
        for (Map.Entry<String, Long> entry : bag.entrySet()) {
            usedCapacity = entry.getValue();
        }
        return usedCapacity + itemQuantity <= this.capacity;
    }

    public long getGoldQuantity() {
        long quantity = 0;
        for (Map.Entry<String, Long> entry : goldMap.entrySet()) {
            quantity = entry.getValue();
        }
        return quantity;
    }

    public long getGemQuantity() {
        long quantity = 0;
        for (Map.Entry<String, Long> entry : gemMap.entrySet()) {
            quantity = entry.getValue();
        }
        return quantity;
    }

    public long getCash() {
        long quantity = 0;
        for (Map.Entry<String, Long> entry : cashMap.entrySet()) {
            quantity = entry.getValue();
        }
        return quantity;
    }


    public boolean canPut(String itemType, long itemQuantity) {
        switch (itemType) {
            case "Gem":
                if (getGemQuantity() + itemQuantity > getGoldQuantity()){
                    return false;
                }
                break;
            case "Cash":
                if (getCash() + itemQuantity > getGemQuantity() || getCash()+itemQuantity > getGoldQuantity()) {
                    return false;
                }
                break;
        }
        return true;
    }

    public void putItem(String itemType, String item, long itemQuantity) {
        switch (itemType) {
            case "Gold":
                this.goldMap.put(itemType, this.goldMap.get(itemType) + itemQuantity);
                this.bag.put(itemType, this.bag.get(itemType) + itemQuantity);
                break;
            case "Gem":
                if (!this.gemMap.containsKey(item)) {
                    this.gemMap.put(item, 0L);
                }
                this.gemMap.put(item, this.gemMap.get(item) + itemQuantity);
                this.bag.put(itemType, this.bag.get(itemType) + itemQuantity);
                break;
            case "Cash":
                if (!this.cashMap.containsKey(item)) {
                    this.cashMap.put(item, 0L);
                }
                this.cashMap.put(item, this.cashMap.get(item) + itemQuantity);
                this.bag.put(itemType, this.bag.get(itemType) + itemQuantity);
                break;
        }
    }

    public void printBag() {
        for (Map.Entry<String, Long> bagEntry : this.bag.entrySet()) {
            if (bagEntry.getValue() != 0) {
                System.out.printf("<%s> $%s%n", bagEntry.getKey(), bagEntry.getValue());
                if (bagEntry.getKey().equals("Gold")) {
                    System.out.printf("##Gold - %d%n", this.goldMap.get("Gold"));
                } else if (bagEntry.getKey().equals("Gem")) {
                    this.gemMap.entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                            .forEach(entry -> System.out.printf("##%s - %d%n", entry.getKey(), entry.getValue()));
                } else if (bagEntry.getKey().equals("Cash")) {
                    this.cashMap.entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                            .forEach(entry -> System.out.printf("##%s - %d%n", entry.getKey(), entry.getValue()));
                }
            }
        }
    }
}
