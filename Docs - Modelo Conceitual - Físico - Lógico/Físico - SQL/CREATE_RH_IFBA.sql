DROP DATABASE IF EXISTS RH_IFBA;
CREATE DATABASE RH_IFBA CHARACTER SET = 'utf8' COLLATE = 'utf8_general_ci';
USE RH_IFBA;

CREATE TABLE Funcionario_DIREH (
    CPF_Funcionario CHAR(11) PRIMARY KEY,
    Nome VARCHAR(120) NOT NULL,
    Login VARCHAR(12) NOT NULL,
    Senha VARCHAR(12) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Telefone_Fixo CHAR(10),
    Telefone_Movel CHAR(11) NOT NULL,
    Cargo VARCHAR(100) NOT NULL,
    Horario_Entrada TIME NOT NULL,
    Horario_Saida TIME NOT NULL
);

CREATE TABLE Servidor (
    CPF_Servidor CHAR(11) PRIMARY KEY,
    Nome VARCHAR(120) NOT NULL,
    Login_Servidor VARCHAR(12) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Status ENUM('Ativo','Inativo'),
    Cargo VARCHAR(100) NOT NULL,
    Senha_Servidor VARCHAR(12) NOT NULL,
    Arquivo_CPF TEXT NOT NULL,
    Arquivo_RG TEXT NOT NULL,
    Descricao_Cargo VARCHAR(100) NOT NULL,
    Ultimo_Acesso DATE NOT NULL
);

CREATE TABLE Funcao (
    ID_Funcao TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100) NOT NULL
);

CREATE TABLE Local_Origem (
    ID_Origem INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(120) NOT NULL,
    Tipo ENUM('Interno','Externo'),
    Descricao TEXT
);

CREATE TABLE Tipo (
    ID_Numero TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(60) NOT NULL
);

CREATE TABLE Documento (
    Tamanho VARCHAR(9) NOT NULL,
    Nome VARCHAR(100) NOT NULL,
    Data_Criacao DATETIME NOT NULL,
    Descricao TEXT,
    Data_Documento DATE NOT NULL,
    ID_Doc BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    ID_Numero TINYINT UNSIGNED NOT NULL,
    ID_Origem INT UNSIGNED NOT NULL,
    FOREIGN KEY (ID_Numero) REFERENCES Tipo (ID_Numero),
    FOREIGN KEY (ID_Origem) REFERENCES Local_Origem (ID_Origem)
);


CREATE TABLE Administra (
    CPF_Funcionario CHAR(11),
    ID_Doc BIGINT UNSIGNED,
    data_atualizacao DATETIME,
    PRIMARY KEY (CPF_Funcionario, ID_Doc),
    FOREIGN KEY (CPF_Funcionario) REFERENCES Funcionario_DIREH (CPF_Funcionario),
    FOREIGN KEY (ID_Doc) REFERENCES Documento (ID_Doc)
);

 
CREATE TABLE Servidor_Funcao_Documento (
    CPF_Servidor CHAR(11),
    ID_Funcao TINYINT UNSIGNED,
    ID_Doc BIGINT UNSIGNED,	
    PRIMARY KEY (CPF_Servidor, ID_Doc),
    FOREIGN KEY (CPF_Servidor) REFERENCES Servidor (CPF_Servidor),
    FOREIGN KEY (ID_Doc) REFERENCES Documento (ID_Doc),
    FOREIGN KEY (ID_Funcao) REFERENCES Funcao (ID_Funcao)
);

