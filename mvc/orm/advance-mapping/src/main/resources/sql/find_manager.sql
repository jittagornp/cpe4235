select em1.employee_id mng_id,
       em1.first_name || ' ' || em1.last_name as mng_name,
       em2.*
from Employees em1

inner join Employees em2
on(em1.manager_id = em2.employee_id)

where em1.employee_id = 101
