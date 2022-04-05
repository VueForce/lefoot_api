-- tables
-- Table: ROLES
CREATE TABLE ROLES (
    id_roles int  NOT NULL,
    type text  NOT NULL,
    CONSTRAINT ROLES_ak_id_role UNIQUE (id_roles) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT ROLES_pk PRIMARY KEY (id_roles)
);

CREATE INDEX ROLES_idx_id_role on ROLES (id_roles ASC);

-- Table: STATUS
CREATE TABLE STATUS (
    id_status int  NOT NULL,
    type text  NOT NULL,
    CONSTRAINT STATUS_ak_id_status UNIQUE (id_status) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT STATUS_pk PRIMARY KEY (id_status)
);

CREATE INDEX STATUS_idx_id_status on STATUS (id_status ASC);

-- Table: USUARIOS
CREATE TABLE USUARIOS (
    id_usuario int  NOT NULL,
    fname varchar(60)  NOT NULL,
    lname varchar(60)  NOT NULL,
    email varchar(100)  NOT NULL,
    username varchar(60)  NOT NULL,
    password varchar(120)  NOT NULL,
    id_status int  NOT NULL,
    id_role int  NOT NULL,
    CONSTRAINT USUARIOS_ak_id_usuario UNIQUE (id_usuario) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT USUARIOS_pk PRIMARY KEY (id_usuario)
);

CREATE INDEX USUARIOS_idx_id_usuario on USUARIOS (id_usuario ASC);

