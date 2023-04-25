package com.example.test.repository;

import com.example.test.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingList,Integer> {

    @Query(value = "Select *  from lista_compras t where t.id_cliente =?1",nativeQuery = true)
    List<ShoppingList> findShoppingListByCustomerId(Integer customerId);

    @Query(value = "delete from lista_compras t where idLista =?1",nativeQuery = true)
    void deleteShoppingListByShoppingListId(Integer shoppingListId);

    List<ShoppingList> findByName(String name);
}
