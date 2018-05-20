CREATE DATABASE gelaria
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

CREATE TABLE usuario
(
  id integer NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),
  login character varying(255),
  senha character varying(225),
  CONSTRAINT id_usr PRIMARY KEY (id)
);

CREATE TABLE imagem
(
  id integer NOT NULL DEFAULT nextval('imagem_id_seq'::regclass),
  url character varying(255),
  leganda character varying(255),
  uploader integer,
  CONSTRAINT img_pk PRIMARY KEY (id),
  CONSTRAINT usr_fk FOREIGN KEY (id)
      REFERENCES public.usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);