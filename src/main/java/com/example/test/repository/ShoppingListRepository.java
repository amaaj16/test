package com.example.test.repository;

import com.example.test.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingList,Integer> {

    @Query(value = "Select *  from lista_compras t where t.id_cliente =?1",nativeQuery = true)
    List<ShoppingList> findShoppingListByCustomerId(Integer customerId);

    @Modifying
    @Query("delete from ShoppingList where idList=:idList")
    void deleteShoppingListByShoppingListId( @Param("idList") Integer idList);

    List<ShoppingList> findShoppingListByIdList(Integer idList);
}
