package com.xtest.gulimall.product;

import com.xtest.gulimall.product.entity.BrandEntity;
import com.xtest.gulimall.product.service.BrandService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setDescript("test Data");
        brandEntity.setName("Iphone");
        brandService.save(brandEntity);
    }


}
