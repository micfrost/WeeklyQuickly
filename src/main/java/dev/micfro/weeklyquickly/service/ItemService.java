package dev.micfro.weeklyquickly.service;

import dev.micfro.weeklyquickly.model.Item;
import dev.micfro.weeklyquickly.model.Product;
import dev.micfro.weeklyquickly.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;


    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;

    }



    // CRUD

    // CREATE
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public Item createItem(Product product) {
        Item item = new Item(product);
        return itemRepository.save(item);
    }

    public Item createItems(Product product, Long quantity) {
        Item item = new Item(product, quantity);
        return itemRepository.save(item);
    }


    // READ

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item findItemByNameOfProduct(String name) {
        for (Item item : itemRepository.findAll()) {
            if (item.getProduct().getName().equals(name)) {
                return item;
            }
        }
            return null;
    }

    // UPDATE

    // DELETE


}
