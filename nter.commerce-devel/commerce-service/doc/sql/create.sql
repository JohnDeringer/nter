create database COMMERCE_DB;
use COMMERCE_DB;

CREATE TABLE `COMMERCE_CONFIG` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADMIN_FEE` decimal(5,3) DEFAULT NULL,
  `REFERRER_FEE` decimal(5,3) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `PAYMENT_CONFIG` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ACTION_URL` varchar(255) DEFAULT NULL,
  `ACTIVE` bit(1) DEFAULT NULL,
  `API_VERSION` varchar(25) DEFAULT NULL,
  `BUTTON_URL` varchar(255) DEFAULT NULL,
  `CONFIGURATION_NAME` varchar(50) DEFAULT NULL,
  `NOTIFY_URL` varchar(255) DEFAULT NULL,
  `SELLER_ID` varchar(255) DEFAULT NULL,
  `SELLER_PASSWORD` varchar(50) DEFAULT NULL,
  `API_USER` varchar(255) DEFAULT NULL,
  `API_PASSWORD` varchar(255) DEFAULT NULL,
  `API_SIGNATURE` varchar(255) DEFAULT NULL,
  `SELLER_EMAIL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CONFIGURATION_NAME` (`CONFIGURATION_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `PAYMENT_TRANSACTION` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADMIN_FEE` decimal(20,10) DEFAULT NULL,
  `COURSE_PROVIDER_ID` varchar(255) DEFAULT NULL,
  `CURRENCY_TYPE` varchar(255) DEFAULT NULL,
  `HANDLING` decimal(20,10) DEFAULT NULL,
  `ITEM_NAME` varchar(255) DEFAULT NULL,
  `ITEM_NUMBER` varchar(255) DEFAULT NULL,
  `NOTIFY_VERSION` decimal(20,10) DEFAULT NULL,
  `NTER_ID` varchar(255) DEFAULT NULL,
  `PAYER_EMAIL` varchar(255) DEFAULT NULL,
  `PAYER_ID` varchar(255) DEFAULT NULL,
  `PAYER_STATUS` varchar(255) DEFAULT NULL,
  `PAYMENT_DATE` date DEFAULT NULL,
  `PAYMENT_FEE` decimal(20,10) DEFAULT NULL,
  `PAYMENT_GROSS` decimal(20,10) DEFAULT NULL,
  `PAYMENT_PROCESSOR` varchar(255) DEFAULT NULL,
  `PAYMENT_STATUS` varchar(255) DEFAULT NULL,
  `PAYMENT_TYPE` varchar(255) DEFAULT NULL,
  `PROTECTION_ELIGIBILITY` varchar(255) DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `RECEIVER_EMAIL` varchar(255) DEFAULT NULL,
  `RECEIVER_ID` varchar(255) DEFAULT NULL,
  `REFERRER_FEE` decimal(20,10) DEFAULT NULL,
  `SHIPPING` decimal(20,10) DEFAULT NULL,
  `STUDENT_ID` varchar(255) DEFAULT NULL,
  `SYS_DATE` date DEFAULT NULL,
  `SALES_TAX` decimal(20,10) DEFAULT NULL,
  `TEST_IPN` varchar(255) DEFAULT NULL,
  `TRANSACTION_ID` varchar(255) DEFAULT NULL,
  `TRANSACTION_SUBJECT` varchar(255) DEFAULT NULL,
  `TRANSACTION_TYPE` varchar(255) DEFAULT NULL,
  `VALIDATION_STATUS` varchar(255) DEFAULT NULL,
  `VERIFY_SIGN` varchar(255) DEFAULT NULL,
  `TRANSACTION_PARENT_ID` varchar(255) DEFAULT NULL,
  `REASON_CODE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8