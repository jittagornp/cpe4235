select *
from employees
where first_name like '%K%';


select *
from employees
where lower(first_name) like '%st%' or lower(last_name) like '%st%';