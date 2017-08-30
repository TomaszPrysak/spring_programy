package pl.pitek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pitek.model.CarModel;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Long> {
	
	List<CarModel> findByBrand(String brand);
	
	List<CarModel> findByPrice(Double price);
	
	List<CarModel> findByName(String name);
	
	List<CarModel> findByBrandAndPrice(String brand, Double price);
	
	List<CarModel> findFirstByBrand(String brand);
	
	
	List<CarModel> findFirst3ByBrand(String barnd);
	
	// select * from cars where brand = b1 or brand = b2;
	List<CarModel> findAllByBrandOrBrand(String brand1, String brand2);
	
	List<CarModel> findByNameStartingWith(String pattern);
	
	// 1,4
	List<CarModel> findAllByNameLike(String pattern);
	// 2.
	List<CarModel> findAllByNameContaining(String pattern);
	// 3.
	List<CarModel> findAllByNameEndingWith(String pattern);
	// 5.
	List<CarModel> findAllByNameContainingAndNameStartingWith(String pattern1, String pattern2);
	
	List<CarModel> findAllByBrandAndPriceLessThanEqual(String brand, Double price);
	
	List<CarModel> findAllByBrandLikeAndPriceBetween(String pattern, Double low, Double high);
	
	List<CarModel> findAllByBrandOrderByNameDesc(String brand);
	
	List<CarModel> findAllByPriceNotNullOrderByPriceDesc();
	
	List<CarModel> findAllByOrderByPriceDesc();
	
}
