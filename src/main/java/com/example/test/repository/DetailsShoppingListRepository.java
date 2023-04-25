package com.example.test.repository;

import com.example.test.entity.DetailsShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DetailsShoppingListRepository extends JpaRepository<DetailsShoppingList, Integer> {
    @Query(value = "Select *  from lista_compra_detalle t where id_lista_compra =?1",nativeQuery = true)
    public List<DetailsShoppingList> findByShoppingList(int shoppingListId);

    @Query(value = "delete from lista_compra_detalle t where id_lista_compra =?1",nativeQuery = true)
    public void deleteByShoppingList(int shoppingListId);

    @Query(value = "Select 1 *  from lista_compra_detalle t where product_id_producto =?1 limit 1",nativeQuery = true)
    public Optional<DetailsShoppingList> findByProductId(int productId);
}
