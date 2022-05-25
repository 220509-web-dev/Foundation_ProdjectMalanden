SET search_path TO chinook;

2.1
select * from "Employee" e ;

select * from "Employee" e where "LastName" = 'King';

select * from "Employee" e where "FirstName" = 'Andrew' and "ReportsTo" = null;

2.2
select * from "Album" a order by "AlbumId"  desc;

select "FirstName" from "Customer" order by "FirstName" asc;

2.3
insert into "Genre" ("GenreId", "Name") values (26, N'weird');
insert into "Genre" ("GenreId", "Name") values (27, N'Bluegrass');

INSERT INTO "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email") 
VALUES (9, N'Akuma', N'Landen', N'Helpdesk', '1990/4/3', '2022/5/09', N'15542 Cascade ave', N'Los Angeles', N'California', N'USA', N'90210', N'+1 (555) 778-4462', N'+1 (555) 778-4463', N'Akumab@hotmail.com');

INSERT INTO "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email") 
VALUES (10, N'Andre', N'Firestone', N'Helpdesk', '2000/6/15', '2022/5/09', N'18452 Bigbear st', N'Chicago', N'Illinois', N'USA', N'62629', N'+1 (888) 888-4572', N'+1 (888) 888-4574', N'Mrhelpful@hotmail.com');

INSERT INTO "Customer" ("CustomerId", "FirstName", "LastName", "Address", "City", "Country", "PostalCode", "Email", "SupportRepId")
VALUES (60, N'Dio', N'Bond', N'15800 Indian st.', N'Detroit', N'Michigan', N'48228', N'tastymayo@gmail.com', 4);

INSERT INTO "Customer" ("CustomerId", "FirstName", "LastName", "Address", "City", "Country", "PostalCode", "Email", "SupportRepId")
VALUES (61, N'Timmy', N'Car', N'1487 Sheldon', N'Canton', N'Michigan', N'48239', N'kittycat@yahoo.com', 3);

2.4
update "Customer" set "LastName" = 'walter', "FirstName" = 'Robert' where "LastName" = 'Mitchell'and "FirstName" = 'Aaron' ; 

Update "Artist" set "Name" = 'CCR' where "Name" = 'Creedence Clearwater Revival';

2.5
select * from "Invoice" i where "BillingAddress" like 'T%';

2.6
select * from "Invoice" i where "Total" between 15 and 50;

select * from "Employee" e where "HireDate"  between '2003/06/01' and '2004/03/01';

2.7
delete from "InvoiceLine" where "InvoiceId" in (select "InvoiceId" from "Invoice" i where "CustomerId" = 32 );
delete from "Invoice" where "CustomerId" = 32; 
delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'walter';

3.1
select timeofday(); 

select *, length("Name") as Length from "MediaType" where "MediaTypeId" = 2 ;

3.2
select avg("Total") from "Invoice" i ;

select max("UnitPrice") from "Track" t ;

4.1
select "FirstName", "InvoiceId" from "Customer" inner join "Invoice"  on "SupportRepId" = "InvoiceId" order by "FirstName" asc ;

4.2
ALTER TABLE "Customer" rename "CustomerId" to "Customer_Id";

select  "Customer_Id", "FirstName", "LastName", "InvoiceId", "Total" from "Customer"  join "Invoice" on  "Customer_Id"  = "InvoiceId" ;


4.3
ALTER TABLE "Artist"  rename "ArtistId" to "Artist_Id";

select "Name", "Title" from "Artist"  right join "Album"  on "Artist_Id" = "AlbumId"; 

4.4
select * from "Album" a cross join "Artist" a2 order by "Name" asc;

4.5

select * from "Employee" e1 join "Employee" e2 on e1."ReportsTo"  =  e2."ReportsTo" ; 




	






