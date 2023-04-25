package com.example.test.service.impl;

import com.example.test.dto.DetailsShoppingListDTO;
import com.example.test.entity.Customer;
import com.example.test.entity.DetailsShoppingList;
import com.example.test.entity.Product;
import com.example.test.entity.ShoppingList;
import com.example.test.mapper.DetailsShoppingListMapper;
import com.example.test.mapper.ShoppingListMapper;
import com.example.test.repository.CustomerRepository;
import com.example.test.repository.DetailsShoppingListRepository;
import com.example.test.repository.ProductRepository;
import com.example.test.repository.ShoppingListRepository;
import com.example.test.service.ShoppingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final ShoppingListRepository shoppingListRepository;

    private final DetailsShoppingListRepository detailsShoppingListRepository;

    public ShoppingServiceImpl(ProductRepository productRepository, CustomerRepository customerRepository, ShoppingListRepository shoppingListRepository, DetailsShoppingListRepository detailsShoppingListRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.shoppingListRepository = shoppingListRepository;
        this.detailsShoppingListRepository = detailsShoppingListRepository;
    }

    @Override
    public List<DetailsShoppingList> addList(DetailsShoppingListDTO shoppingListDTO) {
        ShoppingListMapper mapper = new ShoppingListMapper();
        DetailsShoppingListMapper detailsMapper = new DetailsShoppingListMapper();
        return shoppingListDTO.getList().stream().map(item -> {
            customerRepository.findById(item.getCustomerId()).orElse(customerRepository.save(new Customer(item.getCustomerId(), "test", (byte) 1)));
            item.getItems().stream().map(subItem -> {
                return productRepository.findById(subItem.getProductId()).orElse(productRepository.save(new Product(subItem.getProductId(), "testProduct", "producto", (byte) 1)));
            });
            return item;
        }).map(item -> {
            ShoppingList itemSaved = shoppingListRepository.save(mapper.toEntity(item));
            return item.getItems().stream().map(subItem -> {
                return detailsMapper.toEntity(itemSaved.getIdList(), subItem);
            }).map(subItem -> detailsShoppingListRepository.save(subItem)).collect(Collectors.toList()).get(0);

        }).collect(Collectors.toList());


    }

    @Override
    public List<DetailsShoppingListDTO> getList(int idCustomer) {
        DetailsShoppingListMapper detailsMapper = new DetailsShoppingListMapper();

        List<ShoppingList> shoppingList = shoppingListRepository.findShoppingListByCustomerId(idCustomer);
        if (shoppingList.isEmpty()) {
            return null;
        }
        return shoppingList.stream().map(item -> {
            List<DetailsShoppingList> allDetails = detailsShoppingListRepository.findByShoppingList(shoppingList.get(0).getIdList());
            return detailsMapper.toDTO(shoppingList.get(0), allDetails);
        }).collect(Collectors.toList());

    }

    @Override
    public DetailsShoppingListDTO updateShoppingList(DetailsShoppingListDTO shoppingListDTO) {
        ShoppingListMapper mapper = new ShoppingListMapper();
        DetailsShoppingListMapper detailsMapper = new DetailsShoppingListMapper();
        shoppingListDTO.getList().stream().map(shoppingList->{
            List<ShoppingList> result= shoppingListRepository.findByName(shoppingList.getNameList());
            return shoppingList;
        });
        return shoppingListDTO;

    }

    @Override
    public int deleteList(int ShoppingListId) {
        try{
            detailsShoppingListRepository.deleteByShoppingList(ShoppingListId);
            shoppingListRepository.deleteShoppingListByShoppingListId(ShoppingListId);
        }
        catch (Exception e){
            return 0;
        }

        return 1;
    }
}
