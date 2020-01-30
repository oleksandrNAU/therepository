-- Database: BibliotecaH2

-- DROP DATABASE "BibliotecaH2";

--CREATE DATABASE "BibliotecaH2"
 --   WITH 
  --  OWNER = postgres
 --   ENCODING = 'UTF8'
--    LC_COLLATE = 'Spanish_Spain.1252'
 --   LC_CTYPE = 'Spanish_Spain.1252'
--    TABLESPACE = pg_default
--    CONNECTION LIMIT = -1;
--	CREATE TABLE autores 
--	(     cod VARCHAR(5) PRIMARY KEY,     nombre VARCHAR(60) ); 
	--CREATE TABLE libros (
	--	id INTEGER PRIMARY KEY, 
	--	titulo VARCHAR(60),     codautor VARCHAR(5) REFERENCES autores(cod) );
	--	INSERT INTO autores VALUES ('WSHAK',  'William Shakespeare'),     ('FROJA',  'Fernando de Rojas'); INSERT INTO libros VALUES (1, 'Macbeth', 'WSHAK'),     
	--	(2, 'La Celestina (Tragicomedia de Calisto y Melibea)', 'FROJA');
		SELECT * FROM autores, libros  WHERE autores.cod = libros.codautor;