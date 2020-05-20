package com.zopsmart.orderrepository.config;

import com.zopsmart.orderrepository.entity.*;
import com.zopsmart.orderrepository.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private LineItemRepository lineItemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ReturnRequestRepository returnRequestRepository;

    Logger logger = LoggerFactory.getLogger(SetupDataLoader.class);
    // API

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create categories
        createCategoryIfNotFound("Baby Products");
        createCategoryIfNotFound("Fruits");
        createCategoryIfNotFound("Vegetable");
        createCategoryIfNotFound("Oil");

        logger.info("categories save successfully");

        // == create product
        createProductIfNotFound("no", "no", "yes", "yes",
                "normal", "Apple", "Fruits");
        createProductIfNotFound("no", "no", "yes", "yes",
                "normal", "Banana", "Fruits");
        createProductIfNotFound("no", "no", "yes", "yes",
                "normal", "Onion", "Vegetable");
        createProductIfNotFound("no", "no", "yes", "yes",
                "normal", "Potato", "Vegetable");
        logger.info("product save successfully");

        // == create LineItem
        createLineItemIfNotFound(productRepository.findByDescription("Apple"), 29, "fresh", 120.0, "nothing",
                "/c/d/e", "no", 0, 0, 0, 0);
        createLineItemIfNotFound(productRepository.findByDescription("Banana"), 29, "fresh", 50.0, "nothing",
                "/c/d/e", "no", 0, 0, 0, 0);
        createLineItemIfNotFound(productRepository.findByDescription("Onion"), 29, "fresh", 30.0, "nothing",
                "/c/d/e", "no", 0, 0, 0, 0);
        createLineItemIfNotFound(productRepository.findByDescription("Potato"), 29, "fresh", 25.0, "nothing",
                "/c/d/e", "no", 0, 0, 0, 0);
        logger.info("LineItem save successfully");

//        // == create Order
//        createOrderIfNotFound("1.0","success","POS",565.0,
//                new ArrayList<LineItem>(Arrays.asList(lineItemRepository.findByProductId(productRepository.findByDescription("Apple")))),52L,212.0,20.0,
//                555.0,14.0,852.0,12.0,5.0,0.0,0.0,5.0,"apple","no",
//                "no",0.0,"no","yes","yes","no",2);
//        createOrderIfNotFound("1.0","success","POS",565.0,
//                new ArrayList<LineItem>(Arrays.asList(lineItemRepository.findByProductId(productRepository.findByDescription("Onion")))),42L,212.0,20.0,
//                555.0,14.0,852.0,12.0,5.0,0.0,0.0,5.0,"onion","no",
//                "no",0.0,"no","yes","yes","no",2);

        logger.info("orders save successfully");

        // == create product

        logger.info("Created admin and roles in first application set up");

        alreadySetup = true;
    }

    @Transactional
    private final Category createCategoryIfNotFound(final String categoryName) {
        Category category = categoryRepository.findByCategoryName(categoryName);
        if (category == null) {
            category = new Category();
            category.setCategoryName(categoryName);
        }
        categoryRepository.save(category);
        return category;
    }

    @Transactional
    private final Product createProductIfNotFound(final String ageRestricted, final String alcoholFlag,
                                                  final String availableOnClickList, final String belowMinimumAdvertisedPrice,
                                                  final String customerFacingSize, final String description, final String category) {
        Product product = productRepository.findByDescription(description);
        Category category1 = categoryRepository.findByCategoryName(category);
        if (product == null) {
            product = new Product();
            product.setAgeRestricted(ageRestricted);
            product.setAlcoholFlag(alcoholFlag);
            product.setDescription(description);
            product.setAvailableOnClickList(availableOnClickList);
            product.setBelowMinimumAdvertisedPrice(belowMinimumAdvertisedPrice);
            product.setCustomerFacingSize(customerFacingSize);
            product.setCategories(new ArrayList<Category>(Arrays.asList(category1)));
        }
        productRepository.save(product);
        logger.info(product.getCategories().toString());
        return product;
    }

    @Transactional
    private final LineItem createLineItemIfNotFound(final Product product, final Integer quantity, final String description,
                                                    final Double unitPrice, final String specialInstruction,
                                                    final String imageLocation, final String isRefundable,
                                                    final Integer quantityRefunded, final Integer quantityRefundable,
                                                    final Integer quantityCompleteRefunds, final Integer quantityPendingRefunds) {
        LineItem lineItem = lineItemRepository.findByProductId(product);
        if (lineItem == null) {
            lineItem = new LineItem();
            lineItem.setProductId(product);
            lineItem.setQuantity(quantity);
            lineItem.setDescription(description);
            lineItem.setUnitPrice(unitPrice);
            lineItem.setSpecialInstruction(specialInstruction);
            lineItem.setImageLocation(imageLocation);
            lineItem.setIsRefundable(isRefundable);
            lineItem.setQuantityRefunded(quantityRefunded);
            lineItem.setQuantityRefundable(quantityRefundable);
            lineItem.setQuantityCompleteRefunds(quantityCompleteRefunds);
            lineItem.setQuantityPendingRefunds(quantityPendingRefunds);
        }
        lineItemRepository.save(lineItem);
        return lineItem;
    }

    @Transactional
    private Order createOrderIfNotFound(final String version, final String status,
                                        final String purchaseType, final Double grandTotal, final List<LineItem> items,
                                        final Long customerId, final Double lineSubTotal,
                                        final Double serviceCharge, final Double subTotal, final Double taxTotal,
                                        final Double total, final Double discountTotal,
                                        final Double discountPercent, final Double productAmountToBeRefunded,
                                        final Double taxAmountToBeRefunded, final Double discount,
                                        final String banner, final String hasPendingRefund,
                                        final String hasRefundableProduct, final Double totalRefund,
                                        final String modifiable, final String isInstacartOrder,
                                        final String substitutionAllowedForAllItems, final String cancelable,
                                        final Integer itemsCount) {
        Order order = orderRepository.findByBanner(banner);
        if (order == null) {
            order = new Order();
            order.setVersion(version);
            order.setStatus(status);
            order.setPurchaseType(purchaseType);
            order.setGrandTotal(grandTotal);
            order.setItems(items);
            order.setCustomerId(customerId);
            order.setLineSubTotal(lineSubTotal);
            order.setServiceCharge(serviceCharge);
            order.setSubTotal(subTotal);
            order.setTaxTotal(taxTotal);
            order.setTotal(total);
            order.setDiscountTotal(discountTotal);
            order.setDiscountPercent(discountPercent);
            order.setProductAmountToBeRefunded(productAmountToBeRefunded);
            order.setTaxAmountToBeRefunded(taxAmountToBeRefunded);
            order.setDiscount(discount);
            order.setBanner(banner);
            order.setHasPendingRefund(hasPendingRefund);
            order.setHasRefundableProduct(hasRefundableProduct);
            order.setTotalRefund(totalRefund);
            order.setModifiable(modifiable);
            order.setIsInstacartOrder(isInstacartOrder);
            order.setSubstitutionAllowedForAllItems(substitutionAllowedForAllItems);
            order.setCancelable(cancelable);
            order.setItemsCount(itemsCount);
        }
        orderRepository.save(order);
        return order;
    }
}
