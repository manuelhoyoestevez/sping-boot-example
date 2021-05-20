DROP TABLE IF EXISTS prices;

CREATE TABLE prices (
  id INT AUTO_INCREMENT PRIMARY KEY,
  product_id INT NOT NULL,
  brand_id INT NOT NULL,
  priority INT NOT NULL,
  start_date TIMESTAMP WITH TIME ZONE NOT NULL,
  end_date TIMESTAMP WITH TIME ZONE NOT NULL,
  amount INT NOT NULL,
  currency CHAR(3) NOT NULL
);

INSERT INTO prices (brand_id, start_date, end_date, id, product_id, priority, amount, currency) VALUES
(1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 3550, 'EUR'),
(1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 2545, 'EUR'),
(1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 3050, 'EUR'),
(1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 3895, 'EUR');
