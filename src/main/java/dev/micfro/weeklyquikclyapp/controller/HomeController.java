package dev.micfro.weeklyquikclyapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// TODO
//list of things to do
// create a security login page to difference roles of users (admin, customer, employee, guest)

// do tasks from the lessons
// implement elements from the previous projects and implement

// Bootstrap from udemy Dr Yu
// travis media - pulsing words


// Registration form for and
// create 5 objects of each type in database:
// employee
// customer
// product
// item (item is a product, product has items)
// order
// meal

// Show pages:
// bill as a result of order (order has invoice) - to generate it a pdf
// list of all orders
// details of an order
// list of orders of a customer

// list of customers
// details of a customer
// list of products of a customer
// list of meals of a customer

// list of employees
// details of an employee
// Measure effectiveness of an employee

// list of products
// details of a product
// list of meals of a product (you have these products at home, in shopping list what can you cook


// list of items
// details of an item

// list of items of a product
// list of meals
// details of a meal

// list of meals
// details of a meal
// list of products of a meal


// Add to the project:
// Spring Security
// Spring Data JPA
// Spring Data REST
// Spring HATEOAS
// Spring REST
// Spring MVC



    @Controller
    public class HomeController {

        @GetMapping("/")
        public String home(Model model) {
            return "index";
        }

        @GetMapping("/Bootstrap-dashboard")
        public String dashboard(Model model) {
            return "Bootstrap-dashboard";
        }
}
