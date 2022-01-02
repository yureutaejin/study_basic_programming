create table Sample_buffer_effects (ID int, value1 int, value2 int);

select * from Sample_buffer_effects;

set global key_buffer_size=0; set global key_buffer_size=DEFAULT;