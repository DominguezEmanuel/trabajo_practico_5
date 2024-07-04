insert into carreras(codigo_carrera , nombre , cantidad_anos , estado) values (1 , 'Contador Público' , 5 , 1);
insert into carreras(codigo_carrera , nombre , cantidad_anos , estado) values (2 , 'Administración de Empresas' , 4 , 1);
insert into carreras(codigo_carrera , nombre , cantidad_anos , estado) values (3 , 'Licenciado en Economía Política' , 4 , 1);
insert into carreras(codigo_carrera , nombre , cantidad_anos , estado) values (4 , 'Lic. Administración' , 5 , 1);
insert into carreras(codigo_carrera , nombre , cantidad_anos , estado) values (5 , 'Lic. Ec. Política' , 5 , 1);
insert into carreras(codigo_carrera , nombre , cantidad_anos , estado) values (6 , 'Lic. Administración' , 5 , 1);
insert into carreras(codigo_carrera , nombre , cantidad_anos , estado) values (7 , 'Doc. en Políticas Públicas' , 6 , 1);

insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (1 , '45753951' , 'Juan' , 'Salas' , 'juan1890@gmail.com' , '388415789' , '2000-12-22' , 'Mariano Moreno' , 1);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (2, '32456789', 'María', 'González', 'maria.gonzalez@example.com', '388512345', '1998-07-15', 'Avenida Siempre Viva 742', 1);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (3, '76543210', 'Luis', 'Martínez', 'luis.martinez@example.com', '388678945', '1999-11-30', 'Calle Falsa 123', 2);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (4, '23456789', 'Ana', 'Pérez', 'ana.perez@example.com', '388123456', '1997-03-22', 'Boulevard de los Sueños 456', 2);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (5, '12243210', 'Ignacio', 'Martínez', 'ignacio.martinez@example.com', '388643945', '2000-11-30', 'Calle Real 123', 1);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (6, '34256789', 'Daniel', 'Pérez', 'Dani.perez@example.com', '388125856', '1997-08-23', 'Brandsen 805', 2);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (7 , '45126388' , 'Galo' , 'Mamani' , 'Galo23@gmail.com' , '3884893766' , '2000-05-22' , 'Cochabamba 957' , 3);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (8, '32098390', 'Emanuel', 'Herrera', 'manuherre@example.com', '3885908776', '1990-07-26', 'Belgrano  26611', 3);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (9, '45897165', 'Mateo', 'Heredia', 'Mat.h@example.com', '3882739287', '1999-10-28', 'Calle Perico 12', 4);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (10, '45762833', 'Maximiliano', 'Tejerina', 'Maxitej234@example.com', '3880287365', '1997-10-22', 'El Rosedal 116', 4);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (11, '27498897', 'Priscila', 'Lamas', 'prilove@example.com', '388643985', '2000-11-14', 'El naranjero 21', 5);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (12, '26798578', 'Eduardo', 'Guari', 'Eduguari123@example.com', '388125725', '1997-08-05', 'Vicuñas 456', 4);

insert into docentes(legajo , apellido , email , nombre , telefono) values (1 , 'Perez Ibarra' , 'perezjm@gmail.com' , 'Marcelo' , '3885648798');
INSERT INTO docentes(legajo, apellido, email, nombre, telefono) VALUES (2, 'Gonzalez', 'gonzalez.maria@example.com', 'Maria', '3885678945');
INSERT INTO docentes(legajo, apellido, email, nombre, telefono) VALUES (3, 'Rodriguez', 'rodriguez.juan@example.com', 'Juan', '3885987321');
INSERT INTO docentes(legajo, apellido, email, nombre, telefono) VALUES (4, 'Fernandez', 'fernandez.luisa@example.com', 'Luisa', '3885123456');
INSERT INTO docentes(legajo, apellido, email, nombre, telefono) VALUES (5, 'Lopez', 'lopez.pablo@example.com', 'Pablo', '3885789123');
INSERT INTO docentes(legajo, apellido, email, nombre, telefono) VALUES (6, 'Martinez', 'martinez.carla@example.com', 'Carla', '3885367890');

INSERT INTO materias(cantidad_horas, codigo_carrera, codigo_materia, legajo_docente, curso, modalidad, nombre) VALUES ('50', 3, 1, 2, 'Segundo', 'Virtual', 'Contabilidad Financiera');
INSERT INTO materias(cantidad_horas, codigo_carrera, codigo_materia, legajo_docente, curso, modalidad, nombre) VALUES ('40', 1, 2, 1, 'Primero', 'Presencial', 'Microeconomía');
INSERT INTO materias(cantidad_horas, codigo_carrera, codigo_materia, legajo_docente, curso, modalidad, nombre) VALUES ('60', 2, 3, 3, 'Tercero', 'Virtual', 'Macroeconomía');
INSERT INTO materias(cantidad_horas, codigo_carrera, codigo_materia, legajo_docente, curso, modalidad, nombre) VALUES ('45', 4, 4, 4, 'Cuarto', 'Presencial', 'Econometría');
INSERT INTO materias(cantidad_horas, codigo_carrera, codigo_materia, legajo_docente, curso, modalidad, nombre) VALUES ('35', 5, 5, 5, 'Primero', 'Virtual', 'Finanzas Corporativas');
INSERT INTO materias(cantidad_horas, codigo_carrera, codigo_materia, legajo_docente, curso, modalidad, nombre) VALUES ('55', 1, 6, 6, 'Segundo', 'Presencial', 'Marketing');

