-- Byte&Bolt: esquema MVP (versión 2026-10-11)
-- Fuente de verdad: este archivo.

CREATE DATABASE IF NOT EXISTS byteandbolt;
USE byteandbolt;

CREATE TABLE `users` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `email` varchar(255),
  `password` varchar(255),
  `createdAt` timestamp
);

CREATE TABLE `worker` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `email` varchar(255),
  `password` varchar(255),
  `createdAt` timestamp
);

CREATE TABLE `application` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `user_id` integer NOT NULL,
  `title` varchar(255),
  `description` text,
  `status` varchar(255),
  `stack` varchar(255),
  `img` varchar(255),
  `contact` varchar(255)
);

CREATE TABLE `quotation` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `application_id` integer NOT NULL,
  `worker_id` integer NOT NULL,
  `totalAmount` integer
);

CREATE TABLE `payment` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `quotation_id` integer NOT NULL UNIQUE,
  `status` varchar(255),
  `frozenAmount` integer
);

CREATE TABLE `survey` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `application_id` integer NOT NULL UNIQUE,
  `rating` integer,
  `description` text
);

ALTER TABLE `application` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `quotation` ADD FOREIGN KEY (`application_id`) REFERENCES `application` (`id`);

ALTER TABLE `quotation` ADD FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`);

ALTER TABLE `payment` ADD FOREIGN KEY (`quotation_id`) REFERENCES `quotation` (`id`);

ALTER TABLE `survey` ADD FOREIGN KEY (`application_id`) REFERENCES `application` (`id`);