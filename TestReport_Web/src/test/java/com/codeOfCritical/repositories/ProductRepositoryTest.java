package com.codeOfCritical.repositories;

import com.codeOfCritical.configuration.RepositoryConfiguration;
import com.codeOfCritical.domain.Deviations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ProductRepositoryTest {

    private WebReport productRepository;

    @Autowired
    public void setProductRepository(WebReport productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    public void testSaveProduct() {
        //setup product
        Deviations deviation = new Deviations();
        deviation.setScenarioName("Spring Framework Partha");
        deviation.setActulValue(18.95);
        deviation.setExpectedValue(22.22);
        deviation.setScreenShots(List.of("A", "B"));
        deviation.setFieldName("Price");

        /*//save product, verify has ID value after save
        assertNull(deviation.getScenarioCount()); //null before save
        productRepository.save(deviation);
//        assertNotNull(deviation.getId()); //not null after save
        //fetch from DB
        Deviation fetchedProduct = productRepository.findById(deviation.getScenarioCount()).orElse(null);

        //should not be null
        assertNotNull(deviation.getScenarioCount());

        //should equal
        assertEquals(deviation.getScenarioCount(), fetchedProduct.getId());
        assertEquals(deviation.getScenarioName(), fetchedProduct.getDescription());

        //update description and save
        fetchedProduct.setDescription("New Description");
        productRepository.save(fetchedProduct);

        //get from DB, should be updated
        Product fetchedUpdatedProduct = productRepository.findById(fetchedProduct.getId()).orElse(null);
        assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());

        //verify count of products in DB
        long productCount = productRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<Deviations> products = productRepository.findAll();

        int count = 0;

        for (Deviation p : Deviations) {
            count++;
        }

        assertEquals(count, 1);*/
    }
}
