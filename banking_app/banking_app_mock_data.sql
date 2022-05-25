set search_path to banking_app;


-- Create a new banking_app user
insert into app_users (first_name, last_name, email, username, pswd)
values
 ('Landen', 'Black', 'lblack@hotmail.com', 'landenblack', 'bestlanden'),
 ('Mike', 'Brass', 'bigbrass@hotmail.com', 'bigbrass', 'biggerbrass'),
 ('Katie', 'Black', 'ktblack@gmail.com', 'kateblack', 'password123');

-- Create some bank accounts
insert into bank_accounts (user_account_number) 
values (13);

-- Create some credit card accounts
insert into credit_card_accounts (user_credit_card_numbers)
values ();

-- Create mortgage accounts
insert into mortgage_accounts (user_mortgage_account_number)
values (13);
