alter table caja
	add tdv_id integer  not null;

comment on column caja.tdv_id is 'Punto de emision para esta caja';

-- auto-generated definition
create table ttpdvuser
(
    tpdvus_id serial  not null
        constraint ttpdvuser_pk
            primary key,
    tdv_id    integer not null,
    us_id     integer not null
);

comment on column ttpdvuser.tpdvus_id is 'Clave primaria de la tabla
';

comment on column ttpdvuser.tdv_id is 'Punto de emision para este usuario
';

comment on column ttpdvuser.us_id is 'Codigo del usuario';

alter table ttpdvuser
    owner to postgres;

create unique index ttpdvuser_tpdvus_id_uindex
    on ttpdvuser (tpdvus_id);




-- auto-generated definition
create table ttpdv
(
    tdv_id            serial     not null
        constraint ttpdv_pk
            primary key,
    tdv_num           varchar(3) not null,
    tdv_fechacreacion timestamp  not null
);

comment on column ttpdv.tdv_id is 'Clave primaria de la tabla';

comment on column ttpdv.tdv_num is 'Numero de punto de emision';

alter table ttpdv
    owner to postgres;

create unique index ttpdv_tdv_id_uindex
    on ttpdv (tdv_id);


---INSERTS
INSERT INTO public.ctes (ctes_id, ctes_clave, ctes_valor) VALUES (19, 'PATH_SYS', 'C:\dev\smartfactproject');

alter table facturas
    add tdv_id int default 1 not null;

comment on column facturas.tdv_id is 'punto de emision de la factura
';


alter table movtransacc
    add tdv_id int default 1 not null;

comment on column movtransacc.tdv_id is 'Caja a la que hace referencia';


