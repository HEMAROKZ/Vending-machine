package com.VendingMachine.VendingMachine01.controller;

import com.VendingMachine.VendingMachine01.dto.CustomerInputDTO;
import com.VendingMachine.VendingMachine01.dto.InventoryDTO;
import com.VendingMachine.VendingMachine01.dto.VendingMachineOutputDTO;
import com.VendingMachine.VendingMachine01.model.Inventry;
import com.VendingMachine.VendingMachine01.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Tag(name = "CUSTOMER PROCESS")
public class ProductController {

    private InventoryService inventoryService;

    private static Logger log = LoggerFactory.getLogger(ProductController.class);

    public ProductController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping("/home")
    public ModelAndView showWelcomePage() {
        ModelAndView model=new ModelAndView();
        model.setViewName("home");
        return model;
    }
////////////////////////////////-----------------------get by id
    @GetMapping("/product/{id}")
    @Operation(summary = "CUSTOMER PROCESS--Get Inventry item by id")
    public InventoryDTO getProductById(@PathVariable int id) {
        return inventoryService.getProductById(id);
    }

    /////////////////////


    @GetMapping("/Inventoryproduct/{id}")
    @Operation(summary = "CUSTOMER PROCESS--Get Inventry item by id")
    public Inventry getInventryProductById(@PathVariable int id) {
        return inventoryService.getInventryProductById(id);
    }


    //////////////////////////////////////////------------------get all inventry item


    @GetMapping("/getAllInventory")
    @Operation(summary = "CUSTOMER PROCESS--Get LIST OF ALL Inventry item")
    public ModelAndView getListOfAllInventory() {
        List<InventoryDTO> list= inventoryService.getListOfAllInventory();
        ModelAndView model=new ModelAndView();
        model.addObject("list",list);
        model.setViewName("getEmployee");
        return model;
    }

    /////////////////////////////////////---------------purchase product


    @RequestMapping(value = "purchaseproduct", method = RequestMethod.GET)
    public ModelAndView purchaseProduct() {

        ModelAndView model=new ModelAndView();
        List<InventoryDTO> list= inventoryService.getListOfAllInventory();
        model.addObject("list",list);

        model.setViewName("purchaseProduct");
        return model;

    }

    @RequestMapping(value = "purchaseproductpage", method = RequestMethod.GET)
    public ModelAndView purchaseProductpage() {

        ModelAndView model=new ModelAndView();
        model.setViewName("purchaseProductDetail");
        return model;

    }

    @RequestMapping(value = "purchase-Inventryitem", method = RequestMethod.POST)
    public ModelAndView purchaseUserProduct(@RequestParam(value = "productId", required = true) int productId,
                                   @RequestParam(value = "price", required = true) int price) {
        CustomerInputDTO customerInputDTO = new CustomerInputDTO.CustomerInputBuilder().price(price).productId(productId).build();

        VendingMachineOutputDTO respvariable = inventoryService.purchaseProduct(customerInputDTO);
        ModelAndView model=new ModelAndView();
        model.addObject("list",respvariable);

            model.setViewName("greeting");

            return model;

    }
//
//
//    @PutMapping("/product")
//    @Operation(summary = "CUSTOMER PROCESS--purchase Inventry item")
//    public VendingMachineOutputDTO ProductPurchase(@RequestBody CustomerInputDTO customerInputDTO) {
//        log.info("product id in purchase controller == {} ",customerInputDTO.getProductId());
//        log.info("product price in purchase controller == {} ",customerInputDTO.getPrice());
//
//        return   inventoryService.purchaseProduct(customerInputDTO );
//    }
///////////////////////////




}
