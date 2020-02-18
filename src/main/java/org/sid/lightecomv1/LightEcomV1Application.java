package org.sid.lightecomv1;

import net.bytebuddy.utility.RandomString;
import org.sid.lightecomv1.dao.CategoryRepository;
import org.sid.lightecomv1.dao.ProductRepository;
import org.sid.lightecomv1.entities.Category;
import org.sid.lightecomv1.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.spel.ast.NullLiteral;

import java.util.Random;

@SpringBootApplication
public class LightEcomV1Application implements CommandLineRunner {

    // Injection de dependence  => Spring Data
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(LightEcomV1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        categoryRepository.save(new Category(null, "Comptuers", null, null));
        categoryRepository.save(new Category(null, "Printers", null, null));
        categoryRepository.save(new Category(null, "Phones", null, null));

        Random rnd = new Random();
        categoryRepository.findAll().forEach(c->{
            for (int i=0; i<20; i++) {
                Product p = new Product();
                p.setName(RandomString.make(18));
                p.setCurrentPrice(1000+rnd.nextInt(10000));
                p.setAvailable(rnd.nextBoolean());
                p.setCategory(c);
                p.setSelected(rnd.nextBoolean());
                p.setDescription(RandomString.make(30));
                p.setPromotion(rnd.nextBoolean());
                p.setPhotoName(RandomString.make(15));
                productRepository.save(p);
            }

        });

    }
}
