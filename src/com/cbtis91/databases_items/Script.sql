use servicios_escolares;

SELECT * FROM ficha f ;
describe ficha ;

select * from especialidad e ;
SELECT * from lengua l ;
SELECT * from discapacidad d ;
SELECT * from localidades l ;
SELECT * from numeroFicha nf ;
update numeroFicha set numero_ficha=99 where id_numero_ficha =1;
insert into lengua (nombre_lengua) values ('Ninguno');
SET @numFicha := (SELECT numero_ficha from numeroFicha nf)+1;
SELECT  @numFicha;
DELIMITER //
CREATE PROCEDURE saveFicha(IN nombres_ VARCHAR(200),IN apellido_paterno_ varchar(200), IN apellido_materno_ varchar(200),IN age_ int,
IN curp_ varchar(18),IN fk_id_localidad_ mediumint, IN address varchar(200),IN birth_place_ varchar(200),IN numero_telefono_ varchar(10),
IN correo_electronico_ text, IN op1_especialidad_ mediumint, IN op2_especialidad_ mediumint,IN fk_id_lengua_ mediumint, IN fk_id_discapacidad_ mediumint, 
IN kind_school_ varchar(200), OUT numeroFicha_ int)
BEGIN
	
	INSERT INTO ficha (numero_ficha, nombres, apellido_paterno, apellido_materno, curp, numero_telefono, correo_electronico, op1_especialidad, 
	op2_especialidad, fk_id_lengua, fk_id_discapacidad, kind_school, edad, fk_id_localidad, birth_place, direccion, date_created) values 
	((SELECT numero_ficha from numeroFicha nf),nombres_,apellido_paterno_,apellido_materno_, curp_ , numero_telefono_ , correo_electronico_ ,op1_especialidad_ ,
	op2_especialidad_ ,fk_id_lengua_ ,fk_id_discapacidad_ ,kind_school_,age_,fk_id_localidad_,birth_place_,address, curdate());
	
	set numeroFicha_ = (SELECT numero_ficha from numeroFicha nf);
	update numeroFicha nf set nf.numero_ficha =nf.numero_ficha +1 where id_numero_ficha =1;
END //
	
set @flag=true;
SELECT  @flag;

call saveFicha ('jose','castellanos','guzman',15,'ABV121',1,'Pescadores','Tehuantepec','9711533508','abc@gmail.com',1,2,4,4,'General',@numFicha);

INSERT INTO ficha (numero_ficha, nombres, apellido_paterno, apellido_materno, curp, numero_telefono, correo_electronico, op1_especialidad, 
	op2_especialidad, fk_id_lengua, fk_id_discapacidad, kind_school, edad, fk_id_localidad, birth_place, direccion) values 
	((SELECT numero_ficha from numeroFicha nf),'jose','castellanos','guzman','ABV121','9711533508','abc@gmail.com',1,2,4,4,'General',15,1,'Tehuantepec','Pescadores');

update numeroFicha nf set nf.numero_ficha =nf.numero_ficha +1 where id_numero_ficha =1;
SELECT numero_ficha from numeroFicha nf;

insert into localidades (nombre_localidad) values('CD. IXTEPEC'),('IXTALTEPEC'),('EL ESPINAL'),('H. CD. DE JUCHITÁN'),('LA VENTOSA'),('LA VENTA'),('UNIÓN HIDALGO'),('STO. DOMINGO INGENIO'),
('STGO IXTALTEPEC'),('SANTA MARÍA XADANI'),('CHIHUITÁN'),('LAOLLAGA'),('TLACOTEPEC'),('TEHUANTEPEC'),('COMITANCILLO'),('SANTA MARÍA GUIENAGATI'),('GUEVEA DE HUMBULT'),('LACHIVIZA'),('GUICHIXÚ');

DELETE from ficha where;

SELECT f.id_ficha, f.nombres , f.apellido_paterno ,f.apellido_materno ,f.curp ,f.numero_telefono ,f.correo_electronico ,f.op1_especialidad ,f.op2_especialidad ,l.nombre_lengua ,d.nombre_discapacidad, f.kind_school , f.edad , loc.nombre_localidad, f.birth_place , f.direccion ,d.nombre_discapacidad from ficha f  inner join discapacidad d inner join lengua l inner join localidades loc where f.fk_id_localidad = loc.id_localidad and f.fk_id_discapacidad = d.id_discapacidad and l.id_lengua = f.fk_id_lengua;
SELECT f.numero_ficha , f.nombres , f.apellido_paterno ,f.apellido_materno ,f.curp ,f.numero_telefono ,f.correo_electronico ,f.op1_especialidad ,f.op2_especialidad ,l.nombre_lengua ,d.nombre_discapacidad, f.kind_school , f.edad , loc.nombre_localidad, f.birth_place , f.direccion, f.date_created  from ficha f  inner join discapacidad d inner join lengua l inner join localidades loc where f.fk_id_localidad = loc.id_localidad and f.fk_id_discapacidad = d.id_discapacidad and l.id_lengua = f.fk_id_lengua ORDER BY f.id_ficha ;

update ficha set date_created = CURDATE() where id_ficha  = 31 ;
select CURDATE(); 