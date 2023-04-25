package com.example.test.controller;


import com.example.test.dto.DetailsShoppingListDTO;
import com.example.test.entity.DetailsShoppingList;
import com.example.test.service.ShoppingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping")
@AllArgsConstructor
public class ShoppingController {
    private final ShoppingService shoppingService;


    @PostMapping
    public ResponseEntity addList(@RequestBody DetailsShoppingListDTO listDto){
        List<DetailsShoppingList> result =shoppingService.addList(listDto);
        if(result.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
       return ResponseEntity.ok(result);
    }

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<List<DetailsShoppingListDTO>> getListById(@PathVariable int idCustomer){
        List<DetailsShoppingListDTO> list =shoppingService.getList(idCustomer);
        if(list == null){
            return ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok(list);
    }

    @PutMapping
    public ResponseEntity updateList(@RequestBody DetailsShoppingListDTO listDto){
        shoppingService.updateShoppingList(listDto);
       return ResponseEntity.ok().build();
    }

    @DeleteMapping("/list/{idList}")
    public ResponseEntity deleteList(@PathVariable int idList){
        shoppingService.deleteList(idList);
        return ResponseEntity.ok().build();
    }
}
