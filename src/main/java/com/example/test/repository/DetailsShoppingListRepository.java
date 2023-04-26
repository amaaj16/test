package com.example.test.repository;

import com.example.test.entity.DetailsShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailsShoppingListRepository extends JpaRepository<DetailsShoppingList, Integer> {
    @Query(value = "Select *  from lista_compra_detalle t where t.id_lista_compra =?1",nativeQuery = true)
    List<DetailsShoppingList> findByShoppingList(int shoppingListId);

    @Modifying
    @Query(value = "delete from lista_compra_detalle where id_lista_compra =?1",nativeQuery = true)
    void deleteByShoppingList(int shoppingListId);

}
