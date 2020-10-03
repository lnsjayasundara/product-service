package com.assignment.productservice.product.calculator;

import com.assignment.productservice.ProductServiceApplication;
import com.assignment.productservice.data.product.Product;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest(classes = ProductServiceApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PriceCalculatorTest {

    private PriceCalculator priceCalculatorUnderTest;
    private List<Object[][]> testDateLits;

    @BeforeAll
    public void setUp() {
        priceCalculatorUnderTest = new PriceCalculator();
        testDateLits = new ArrayList<Object[][]>();
        final Product product = new Product();
        product.setName("name");
        product.setId(1L);
        product.setUnitPerCarton(20);
        product.setCartonPrice(175.0);
        Integer unitCount = 6;
        Integer cartonCount = 2;

        Object[][] data = new Object[2][3];
        data[0] = new Object[]{product, unitCount, cartonCount};
        data[1] = new Object[]{418.25, 6, 2};
        testDateLits.add(data);


        final Product product1 = new Product();
        product1.setName("name");
        product1.setId(2L);
        product1.setUnitPerCarton(5);
        product1.setCartonPrice(825.0);
        Integer unitCount1 = 2;
        Integer cartonCount1 = 2;

        Object[][] data1  = new Object[2][3];
        data1[0] = new Object[]{product1, unitCount1, cartonCount1};
        data1[1] = new Object[]{2079.00, 2, 2};
        testDateLits.add(data1);
    }

    @Test
    public void testCalculatePrice() {

       for ( Object[][] testData: testDateLits) {
           final Double result = priceCalculatorUnderTest.calculatePrice( (Product)testData[0][0], (Integer) testData[0][1], (Integer) testData[0][2]);
            Assertions.assertEquals((Double) testData[1][0], result);
        }

    }

    @Test
    public void testCalUnitCount() {
        final Product product = new Product();
        product.setName("name");
        product.setId(0L);
        product.setUnitPerCarton(20);
        product.setCartonPrice(0.0);

        Integer expected = 6;
        Integer unitCount = 26;
        Integer cartonCount = 0;

        final Integer result = priceCalculatorUnderTest.calUnitCount(product, unitCount);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalCartonCount() {
        final Product product = new Product();
        product.setName("name");
        product.setId(0L);
        product.setUnitPerCarton(20);
        product.setCartonPrice(0.0);

        Integer expected = 2;
        Integer unitCount = 26;
        Integer cartonCount = 1;

        final Integer result = priceCalculatorUnderTest.calCartonCount(product, unitCount, cartonCount);

        Assertions.assertEquals(expected, result);

    }
}
