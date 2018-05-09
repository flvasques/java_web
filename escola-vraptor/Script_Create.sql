CREATE TABLE aluno
(
  matricula integer NOT NULL DEFAULT nextval('aluno_matricula_seq'::regclass),
  nome character varying(255),
  CONSTRAINT id PRIMARY KEY (matricula)
);

REATE TABLE empresa
(
  cnpj character varying(14) NOT NULL,
  nome character varying(255),
  CONSTRAINT id_emp PRIMARY KEY (cnpj)
);

CREATE TABLE estagio
(
  id_aluno integer,
  id_empresa character varying,
  inicio date,
  fim date,
  CONSTRAINT id_al FOREIGN KEY (id_aluno)
      REFERENCES public.aluno (matricula) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT id_empr FOREIGN KEY (id_empresa)
      REFERENCES public.empresa (cnpj) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);