CREATE TABLE gisa (
  std_no	INTEGER PRIMARY KEY,
  email		VARCHAR(4),
  kor		integer,
  eng		integer,
  math		integer,
  sci		integer,
  hist		integer,
  total		integer,
  mag_code	varchar(1),
  acc_code	varchar(1),
  loc_code	varchar(1)
);

insert into gisa values (990001, 'addx', 17, 29, 16, 49, 43, 154, 'C', 'A', 'C');

use gisa;
