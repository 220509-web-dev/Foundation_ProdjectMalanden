create schema banking_app;

set search_path to banking_app; 

create table app_users (
  id            int generated always as identity unique,
  first_name    varchar not null,
  last_name     varchar not null,
  email         varchar unique not null,
  username      varchar unique not null check (length(username) >= 5),
  pswd          varchar unique not null check (length(pswd) >= 8), 

  constraint app_users_pk
  primary key (id)
);

create table bank_accounts (
    bank_id int generated always as identity unique,
    user_account_number int unique not null,
    constraint account_number_fk
    foreign key (user_account_number)
    references app_users(id)
);

create table credit_card_accounts (
    credit_card_id int generated always as identity unique,
    user_credit_card_numbers int unique not null,
    constraint credit_card_numbers_fk
    foreign key(user_credit_card_numbers)
    references app_users(id)
);

create table mortgage_accounts (
    mortgage_id int generated always as identity unique,
    user_mortgage_account_number int unique not null,
    constraint mortgage_account_numbers_fk
    foreign key (user_mortgage_account_number)
    references app_users(id)
);


