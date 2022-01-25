create table boulder_sessions (id bigint not null auto_increment, date date, notes longtext, type char(1), attempts integer, spotters varchar(255), climb_id bigint, primary key (id)) engine=InnoDB;
create table boulders (id bigint not null auto_increment, area varchar(255), name varchar(255), sector varchar(255), status char(1), grade_id bigint, primary key (id)) engine=InnoDB;
create table grades (dtype varchar(31) not null, id bigint not null auto_increment, prefix varchar(255), suffix varchar(255), primary key (id)) engine=InnoDB;
create table pitches (id bigint not null auto_increment, date date, notes longtext, type char(1), partner varchar(255), climb_id bigint, primary key (id)) engine=InnoDB;
create table routes (id bigint not null auto_increment, area varchar(255), name varchar(255), sector varchar(255), status char(1), length integer, grade_id bigint, primary key (id)) engine=InnoDB;
alter table boulder_sessions add constraint FKsaln39f033pash7q7b7uy5276 foreign key (climb_id) references boulders (id);
alter table boulders add constraint FK29ee05ll605cwsnw1q4ve3lf7 foreign key (grade_id) references grades (id);
alter table pitches add constraint FKkf6w7pmhkck319380yw65lm15 foreign key (climb_id) references routes (id);
alter table routes add constraint FKjs2tpbqmrlss37vlgwslegady foreign key (grade_id) references grades (id);
