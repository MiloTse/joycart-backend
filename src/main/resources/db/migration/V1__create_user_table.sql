CREATE TABLE jc_user (
                          id       SERIAL PRIMARY KEY,
                          username VARCHAR(50)  NOT NULL,
                          password VARCHAR(100) NOT NULL,
                          email    VARCHAR(100) NOT NULL,
                          phone    VARCHAR(20)  NOT NULL
);

INSERT INTO jc_user(username, password, email, phone)
VALUES ('demo_user', 'demo_pass', 'demo@joycart.com', '13900001111');