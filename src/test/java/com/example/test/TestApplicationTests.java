package com.example.test;

import com.example.test.controller.ShoppingController;
import com.example.test.dummy.Dummy;
import com.example.test.repository.CustomerRepository;
import com.example.test.repository.DetailsShoppingListRepository;
import com.example.test.repository.ProductRepository;
import com.example.test.repository.ShoppingListRepository;
import com.example.test.service.ShoppingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ShoppingController.class)
@WithMockUser(username = "testUser")
class TestApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestEntityManager testEntityManager;
    @MockBean
    private ShoppingService shoppingService;

    @MockBean
    private  ShoppingListRepository shoppingListRepository;

    @MockBean
    private DetailsShoppingListRepository detailsShoppingListRepository;
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private CustomerRepository customerRepository;
    @Autowired
    private WebApplicationContext controller;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(controller)
                .apply(springSecurity())
                .build();
    }

    @MockBean
    @SuppressWarnings("unused")
    private JwtDecoder jwtDecoder;

    @Test
    void getSuccessfulResponse() throws Exception {

        given(shoppingService.getList(1)).willReturn(Dummy.detailsShoppingListDTO());
    mockMvc.perform(get("/api/v1/shopping/customer/1/lists")
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("shoppingLists").exists());

    }

    @Test
    void getNotFundClient() throws Exception {

        given(shoppingService.getList(1)).willReturn(Dummy.detailsShoppingListDTO());
        mockMvc.perform(get("/api/v1/shopping/customer/2/lists")
                        .contentType("application/json"))
                .andExpect(status().isNotFound());

    }

    @Test
    void getListById() throws Exception {
        given(shoppingService.addList(any())).willReturn(Dummy.listDetailsShoppingList());
        mockMvc.perform(post("/api/v1/shopping")
                       .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Dummy.shoppingListDTO())))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json"));
    }

    @Test
    void updateList() throws Exception {
        given(shoppingService.updateShoppingList(Dummy.detailsShoppingListDTO(),1)).willReturn(Dummy.detailsShoppingListDTO());
        mockMvc.perform(put("/api/v1/shopping/customers/lists/1")
                      .contentType("application/json")
                       .content(objectMapper.writeValueAsString(Dummy.detailsShoppingListDTO())))
              .andExpect(status().isOk());
    }

    @Test
    void deleteList() throws Exception {
        given(shoppingService.deleteList(1)).willReturn(1);
        mockMvc.perform(delete("/api/v1/shopping/lists/1")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

}
