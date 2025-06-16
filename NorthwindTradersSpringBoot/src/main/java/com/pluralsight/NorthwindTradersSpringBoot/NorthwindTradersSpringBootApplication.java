package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.data.ProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.data.SimpleProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

	private static Console console = new Console();

	public static void main(String[] args) {
		ApplicationContext appContext =	SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);



		while (true) {
			System.out.println();
			System.out.println();

			String[] menuOptions = {
					"List Products",
					"Add Product",
					"exit"
			};

			int userChoice = console.promptForOption(menuOptions);
			switch (userChoice) {
				case 1:
				//	listProducts();
					ProductDAO productDAO = appContext.getBean(ProductDAO.class);
					List<Product> products = productDAO.getAll();
					for(Product p : products){
						System.out.println(p);
					}
					break;
				case 2:
				//	addProduct();
					break;
				case 3:
					System.exit(0);
			}


			console.promptForString("Please press <ENTER> to continue...", true);
		}


	}

}
