package de.ait_tr.g_36_shop.service;

import de.ait_tr.g_36_shop.domain.dto.CustomerDto;
import de.ait_tr.g_36_shop.domain.entity.Customer;
import de.ait_tr.g_36_shop.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto save(CustomerDto customer) {
        return null;
    }

    @Override
    public List<CustomerDto> getAllActiveCustomers() {
        return null;
    }

    @Override
    public CustomerDto getById(Long id) {
        return null;
    }

    @Override
    public CustomerDto update(CustomerDto customer) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void restoreById(Long id) {

    }

    @Override
    public long getActiveCustomersNumber() {
        return 0;
    }

    @Override
    public BigDecimal getTotalCostOfCustomersProducts(Long customerId) {
        return null;
    }

    @Override
    public BigDecimal getAverageCostOfCustomersProducts(Long customerId) {
        return null;
    }

    @Override
    public void addProductToCustomersCart(Long customerId, Long productId) {

    }

    @Override
    public void removeProductFromCustomersCart(Long customerId, Long productId) {

    }

    @Override
    public void clearCustomersCart(Long customerId) {

    }
}