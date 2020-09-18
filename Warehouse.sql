
DROP DATABASE  IF EXISTS `warehouse_directory`;
CREATE DATABASE  IF NOT EXISTS `warehouse_directory`;
USE `warehouse_directory`;


-- creating tables ------------------------------------------------------------------------------


CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `weight` int DEFAULT NULL,
  `area` varchar(1) DEFAULT NULL,
  `bookstand` int(4) DEFAULT NULL,
  `shelf` int(4) DEFAULT NULL,
  `availability` int(11) NOT NULL,
  `belongs_to_cumstoms_warehouse` boolean DEFAULT NULL,
  `is_damaged` boolean DEFAULT NULL,
  `is_teritorialy_restricted` boolean DEFAULT NULL,
  `manufacturer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;	


CREATE TABLE `manufacturer` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(128) NOT NULL,
	`short_name` varchar(10) NOT NULL,
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;	


CREATE TABLE `customer` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(128) NOT NULL,
	`tax_number` varchar(128) NOT NULL,
	`address` varchar(128) NOT NULL,
	`city` varchar(30) NOT NULL,
	`postal_code` varchar(10) NOT NULL,
	`email` varchar(40) NULL,
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;


CREATE TABLE `employee` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`first_name` varchar(30) NOT NULL,
	`last_name` varchar(40) NOT NULL,
	`personal_identity_number` int(5) NOT NULL,
	`address` varchar(128) NOT NULL,
	`city` varchar(30) NOT NULL,
	`postal_code` varchar(10) NOT NULL,
	`email` varchar(40) NULL,
	`position_id` int(11) NOT NULL,
    `branch_id` int(11) NOT NULL,
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;


CREATE TABLE `branch` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(128) NOT NULL,
	`short_name` varchar(10) NOT NULL,
	`address` varchar(128) NOT NULL,
	`city` varchar(30) NOT NULL,
	`postal_code` varchar(10) NOT NULL,
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;	


CREATE TABLE `position` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(128) NOT NULL,
	`short_name` varchar(20) NOT NULL,
	`has_billing_option` boolean DEFAULT NULL,
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;
		
		
CREATE TABLE `sales_invoice` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`date_of_issue` datetime(0) DEFAULT NULL,
	`employee_id`  int(11) NOT NULL,
	`shipping_order_id`  int(11) NOT NULL,
	`customer_id`  int(11) NOT NULL,
	`transfer_id`  int(11) NOT NULL,
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;		


CREATE TABLE `sales_order` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`quantity` varchar(128) NOT NULL,
	`sales_invoice_id` int(11),
	`item_id` int(11) NOT NULL,
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;


CREATE TABLE `transport_company` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(128) NOT NULL,
	`short_name` varchar(10) NOT NULL,
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;


CREATE TABLE `shipping_order` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`date_of_issue` datetime(0) DEFAULT NULL,
	`transport_company_id` int(11) NOT NULL,
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;


CREATE TABLE `transfer` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`is_payed` boolean DEFAULT NULL,
	`date_of_issue` datetime(0) DEFAULT NULL,
	`amount` float(11) NOT NULL,
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;


CREATE TABLE `purchase_invoice` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`date_of_issue` datetime(0) DEFAULT NULL,
	`employee_id` int(11) NOT NULL,
	`customer_id` int(11) NOT NULL,
	`transfer_id` int(11) NOT NULL,
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;		


CREATE TABLE `purchase_order` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`quantity` int(11) NOT NULL,
	`purchase_invoice_id` int(11),
	`item_id` int(11) NOT NULL,
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin2;

				
				-- creating foreign keys -----------------------------------------

ALTER TABLE `item`
ADD FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`);


ALTER TABLE `employee`
ADD FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
ADD FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`);


ALTER TABLE `sales_invoice`
ADD FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
ADD FOREIGN KEY (`shipping_order_id`) REFERENCES `shipping_order` (`id`),
ADD FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
ADD FOREIGN KEY (`transfer_id`) REFERENCES `transfer` (`id`);
				

ALTER TABLE `sales_order`
ADD FOREIGN KEY (`sales_invoice_id`) REFERENCES `sales_invoice` (`id`),
ADD FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);				


ALTER TABLE `shipping_order`
ADD FOREIGN KEY (`transport_company_id`) REFERENCES `transport_company` (`id`);	
				

ALTER TABLE `purchase_invoice`
ADD FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
ADD FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
ADD FOREIGN KEY (`transfer_id`) REFERENCES `transfer` (`id`);


ALTER TABLE `purchase_order`
ADD FOREIGN KEY (`purchase_invoice_id`) REFERENCES `purchase_invoice` (`id`),
ADD FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);
				
                -- add some data for testing ------------------------------
INSERT INTO `transport_company` VALUES 
			(1,"DeHaeL","DHL");
          
INSERT INTO `shipping_order` VALUES 
			(1,"2020-06-25 10:00:00",1),
			(2,"2020-06-25 13:00:00",1),
            (3,"2020-07-21 12:00:00",1),
            (4,"2020-07-21 11:00:00",1);
INSERT INTO `manufacturer` VALUES 
			(1, "Xerox", "XRX"); 
            
INSERT INTO `item` VALUES 
			(1, "toner", 120, "A", 2, 1, 13, 0, 0, 0, 1);
            
INSERT INTO `branch` VALUES 
			(1, "Wrocław - Office", "Wro-O", "Prosta 1/2", "Wrocław", "53-226");
            
INSERT INTO `position` VALUES 
			(1, "Senior Tradesman", "Tradesman", 1);
            
INSERT INTO `employee` VALUES 
			(1, "John", "Doe", 111, "Krzywa 2/1", "Wrocław", "53-266", "doe.john@our-company.pl", 1, 1);

INSERT INTO `customer` VALUES 
			(1, "Dobre Tonery", 123456, "Kręta 5", "Poznań", "60-103", "kontakt@dobre-tonery.pl");

INSERT INTO `transfer` VALUES 
			(1, false, null, 1099),
            (2, true, "2020-06-27", 9011),
            (3, true, "2020-08-22", 222),
            (4, true, "2020-08-23", 121),
            (5, true, "2020-08-24", 2000);

INSERT INTO `purchase_invoice` VALUES 
			(1, "2020-06-26 11:05:00", 1, 1, 1);

INSERT INTO `purchase_order` VALUES 
			(1, 5, 1, 1);

INSERT INTO `sales_invoice` VALUES 
			(1, "2020-06-26 11:05:00", 1, 1, 1, 2);

INSERT INTO `sales_order` VALUES 
			(1, 7, 1, 1),
            (2, 17, null, 1),
            (3, 27, null, 1);
		

