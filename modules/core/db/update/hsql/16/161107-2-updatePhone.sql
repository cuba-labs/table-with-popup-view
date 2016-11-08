update DEMO_PHONE set CODE = '' where CODE is null ;
alter table DEMO_PHONE alter column CODE set not null ;
update DEMO_PHONE set NUMBER_ = '' where NUMBER_ is null ;
alter table DEMO_PHONE alter column NUMBER_ set not null ;
