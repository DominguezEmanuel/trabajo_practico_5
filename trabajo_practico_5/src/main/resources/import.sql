insert into carreras(codigo_carrera , nombre , cantidad_anos , estado) values (1 , 'Contador Público' , 5 , 1);
insert into carreras(codigo_carrera , nombre , cantidad_anos , estado) values (2 , 'Administración de Empresas' , 4 , 1);
insert into carreras(codigo_carrera , nombre , cantidad_anos , estado) values (3 , 'Licenciado en Economía Política' , 4 , 1);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (1 , '45753951' , 'Juan' , 'Salas' , 'juan1890@gmail.com' , '388415789' , '2000-12-22' , 'Mariano Moreno' , 1);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (2 , '35751452' , 'Martin' , 'Perez' , 'martin1221@gmail.com' , '3885081562' , '1985-05-22' , 'Alto Comedero' , 3);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (3 , '37852145' , 'Marta' , 'Cruz' , 'm4rt4@gmail.com' , '388963258' , '1900-03-05' , 'Palpalá' , 2);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (4 , '46789511' , 'Maria' , 'Cañizares' , 'm4r1cruz@gmail.com' , '388123654' , '2004-11-15' , 'Gorriti' , 3);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (5 , '26780585' , 'Dario' , 'Pineda' , 'dariopin69@gmail.com' , '388754125' , '1979-04-20' , 'Alto La Viña' , 1);
insert into alumnos(lu , dni_alumno , nombre , apellido , email , telefono , fecha_nacimiento , domicilio , codigo_carrera) values (6 , '40058753' , 'Jose' , 'Rodriguez' , 'jorodriguez25@gmail.com' , '388159753' , '1999-12-25' , 'Los Perales' , 2);
insert into docentes(legajo , nombre , apellido , email , telefono) values (1 , 'Gonzalo' , 'Cruz' , 'gonzacrz2024@gmail.com' , '388456159');
insert into docentes(legajo , nombre , apellido , email , telefono) values (2 , 'Ernesto' , 'Vega' , 'vega1234@gmail.com' , '388936548');
insert into docentes(legajo , nombre , apellido , email , telefono) values (3 , 'Omar' , 'Ramos' , 'ramosomar2000@gmail.com' , '388746921');
insert into docentes(legajo , nombre , apellido , email , telefono) values (4 , 'Cristian' , 'Corrales' , 'cris2022@gmail.com' , '388462812');
insert into materias(codigo_materia , nombre , curso , cantidad_horas , modalidad , legajo_docente , codigo_carrera) values (1 , 'Introducción a la Economía' , 'Primero' , 45 , 'Mixta' , 3 , 1);
insert into materias(codigo_materia , nombre , curso , cantidad_horas , modalidad , legajo_docente , codigo_carrera) values (2 , 'Introducción a la Matemática' , 'Segundo' , 60 , 'Presencial' , 1 , 2);
insert into materias(codigo_materia , nombre , curso , cantidad_horas , modalidad , legajo_docente , codigo_carrera) values (3 , 'Historia de la Economía' , 'Segundo' , 40 , 'Virtual' , 4 , 1);
insert into materias(codigo_materia , nombre , curso , cantidad_horas , modalidad , legajo_docente , codigo_carrera) values (4 , 'Practica Profesional dentro de la Economía' , 'Quinto' , 45 , 'Presencial' , 2 , 3);

