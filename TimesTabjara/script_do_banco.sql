CREATE DATABASE times
CREATE TABLE times
(
    id serial,
    nome character varying(255),
    PRIMARY KEY (id)
)

CREATE TABLE jogador
(
    id serial,
    nome character varying(255),
    id_time integer,
    PRIMARY KEY (id),
    CONSTRAINT id_time FOREIGN KEY (id_time)
        REFERENCES public.times (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)


