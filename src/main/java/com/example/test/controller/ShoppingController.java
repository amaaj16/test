package com.example.test.controller;


import com.example.test.dto.DetailsShoppingListDTO;
import com.example.test.entity.DetailsShoppingList;
import com.example.test.service.ShoppingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shopping")
@AllArgsConstructor
public class ShoppingController {
    private final ShoppingService shoppingService;


    @PostMapping
    public ResponseEntity<List<DetailsShoppingList>> addList(@RequestBody DetailsShoppingListDTO listDto){
        List<DetailsShoppingList> result =shoppingService.addList(listDto);
        if(result.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
       return ResponseEntity.ok(result);
    }

    @GetMapping("/customer/{idCustomer}/lists")
    public ResponseEntity<DetailsShoppingListDTO> getListById(@PathVariable int idCustomer){
        DetailsShoppingListDTO list =shoppingService.getList(idCustomer);
        if(list == null){
            return ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok(list);
    }

    @PutMapping("/customers/lists/{idList}")
    public ResponseEntity<DetailsShoppingListDTO> updateList(@RequestBody DetailsShoppingListDTO listDto,@PathVariable int idList){
       DetailsShoppingListDTO result = shoppingService.updateShoppingList(listDto,idList);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok(result);
    }

    @DeleteMapping("/lists/{idList}")
    public ResponseEntity<?> deleteList(@PathVariable int idList){
        int result =shoppingService.deleteList(idList);
        if(result == 0){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }
}
