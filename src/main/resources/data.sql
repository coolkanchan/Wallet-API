INSERT INTO customers (id, email, name, password)
VALUES 
(1, 'coolkanchan.shaw@gmail.com', 'Kanchan Shaw', 'kan123'),
(2, 'devid@gmail.com', 'Devid Shaw', 'dev123'),
(3, 'coolyuji@gmail.com', 'Yuji Kom', 'yuji123');
INSERT INTO wallets (id, balance, currency, customer_id, name)
VALUES 
(1001, 1000, 'USDOLLAR_$', 1, 'Wallet1'),
(1002, 2000, 'USDOLLAR_$', 2, 'Wallet2'),
(1003, 3000, 'USDOLLAR_$', 3, 'Wallet2');
 