1) select min(customer_id) as ctid from Customers group by first_name order by ctid;


Insert into Customers values (7, 'john', 'Doe',32,'USA');
Insert into Customers values (8, 'john', 'Doe',32,'USA');
Insert into Customers values (9, 'john', 'Doe',32,'USA');
Insert into Customers values (10, 'john', 'Doe',32,'USA');


2) select c.* from Customers c where c.customer_id not in (
    select min(customer_id) as ctid from Customers
    group by first_name order by ctid desc
) order by c.customer_id desc;

3)
-- Duplicate records
select customer_id, first_name, last_name, age, country, rm from (
                                                                     select *,
                                                                            row_number() over (partition by first_name order by customer_id ) as rm
                                                                     from Customers
                                                                     order by customer_id) x
where x.rm > 1;
6) select * from users u where u.ctid not in (
    select min(ctid) as ctid from customers
    group by user_name order by ctid
);

7)
