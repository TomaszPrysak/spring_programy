package pl.pitek;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.pitek.model.CarModel;
import pl.pitek.repository.CarRepository;

@SpringBootApplication
public class SpringDzien2MvcDataBaseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringDzien2MvcDataBaseApplication.class, args);
		
		List<CarModel> cars = new ArrayList<>();
		
		cars.add(new CarModel("A6", "Audi", 200000.0));
		cars.add(new CarModel("Auris", "Toyota", 120000.0));
		cars.add(new CarModel("Panda", "Fiat", 30000.0));
		cars.add(new CarModel("Tipo", "Fiat", 25000.0));
		cars.add(new CarModel("Uno", "Fiat", 40000.0));
		cars.add(new CarModel("Kadet", "Opel", 120000.0));
		cars.add(new CarModel("Corsa", "Opel", 30000.0));
		cars.add(new CarModel("Astra", "Opel", 40000.0));
		cars.add(new CarModel("Insignia", "Opel", 70000.0));
		
		CarRepository cr = ctx.getBean(CarRepository.class);
		
		// zapis do bazy danych
		cars.forEach(cr::save);
		
//		CarModel selectedCar = cr.findOne(1L);
//		cr.delete(selectedCar);
		
		cr.findAll().forEach(System.out::println);
		cr.count();
		
		List<CarModel> list1 = cr.findByBrand("Fiat");
		System.out.println(list1);
		
		List<CarModel> list2 = cr.findByName("Tipo");
		System.out.println(list2);
		
		List<CarModel> list3 = cr.findByPrice(20000.0);
		System.out.println(list3);
		
		List<CarModel> list4 = cr.findByBrandAndPrice("Toyota", 120000.0);
		System.out.println(list4);
		
		List<CarModel> list5 = cr.findFirstByBrand("Fiat");
		System.out.println(list5);
		
		List<CarModel> list6 = cr.findFirst3ByBrand("Opel");
		System.out.println(list6);
		
		List<CarModel> list7 = cr.findAllByBrandOrBrand("Toyota", "Audi");
		System.out.println(list7);
		
		List<CarModel> list8 = cr.findByNameStartingWith("A");
		System.out.println(list8);
		
		List<CarModel> list9 = cr.findAllByNameLike("I%");
		System.out.println(list9);
		
		List<CarModel> list10 = cr.findAllByNameContaining("st");
		System.out.println(list10);
		
		List<CarModel> list11 = cr.findAllByNameEndingWith("a");
		list11.forEach(System.out::println);
		
		List<CarModel> list12 = cr.findAllByNameLike("A%A");
		list12.forEach(System.out::println);
		
		List<CarModel> list13 = cr.findAllByNameContainingAndNameStartingWith("st", "A");
		list13.forEach(System.out::println);
		
		List<CarModel> list14 = cr.findAllByBrandAndPriceLessThanEqual("Opel", 50000.0);
		list14.forEach(System.out::println);
		
		List<CarModel> list15 = cr.findAllByBrandLikeAndPriceBetween("%ia%", 30000.0, 100000.0);
		list15.forEach(System.out::println);
		
		List<CarModel> list16 = cr.findAllByBrandOrderByNameDesc("Opel");
		list16.forEach(System.out::println);
		
		List<CarModel> list17 = cr.findAllByPriceNotNullOrderByPriceDesc();
		list17.forEach(System.out::println);
		
		List<CarModel> list18 = cr.findAllByOrderByPriceDesc();
		list18.forEach(System.out::println);
		
		ctx.close();
		
	}
}
