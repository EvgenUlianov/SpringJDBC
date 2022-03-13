select distinct
    product_name
from public.CUSTOMERS cus
         inner join ORDERS ord on cus.id = ord.customer_id
where lower(cus.name) = 'alexey';