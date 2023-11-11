DROP DATABASE IF EXISTS CirurgiaConecta;
CREATE DATABASE CirurgiaConecta;
USE CirurgiaConecta;


CREATE TABLE Pacientes (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255),
    RG VARCHAR(20),
    DataNasc DATE,
    Convenio VARCHAR(20),
    NumeroConv INT (20),
    Telefone VARCHAR(20),
    Email VARCHAR(255),
    Cidade VARCHAR (50),
    CEP VARCHAR(20)
);


CREATE TABLE Atendentes (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255),
    NomeUsuario VARCHAR(50),
    Senha VARCHAR(255)
);


CREATE TABLE Medicos (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255),
    NomeUsuario VARCHAR(50),
    Senha VARCHAR(255)
);


CREATE TABLE EtapasCirurgia (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Descricao VARCHAR(50),
    IDPaciente INT,
    IDMédico INT,
    DataHoraEtapa DATETIME, 
    FOREIGN KEY (IDPaciente) REFERENCES Pacientes(ID),
    FOREIGN KEY (IDMédico) REFERENCES Medicos(ID)
);


CREATE TABLE ProgressoCirurgia (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    IDEtapaCirurgia INT,
    DataHoraConclusao DATETIME, 
    Observacoes VARCHAR(50),
    IDPaciente INT,
    IDMédico INT,
    DataHoraEtapa DATETIME,
    FOREIGN KEY (IDEtapaCirurgia) REFERENCES EtapasCirurgia(ID),
    FOREIGN KEY (IDPaciente) REFERENCES Pacientes(ID),
    FOREIGN KEY (IDMédico) REFERENCES Medicos(ID)
);

INSERT INTO Atendentes (Nome, NomeUsuario, Senha)
VALUES ('Maria Silva', 'Maria_Silva', '123');

INSERT INTO Atendentes (Nome, NomeUsuario, Senha)
VALUES ('João Santos', 'Joao_Santos', '123');

INSERT INTO Atendentes (Nome, NomeUsuario, Senha)
VALUES ('Ana Lima', 'Ana_Lima', '123');

INSERT INTO Atendentes (Nome, NomeUsuario, Senha)
VALUES ('Pedro Costa', 'Pedro_Costa', '123');

INSERT INTO Medicos (Nome, NomeUsuario, Senha)
VALUES ('Carla Pereira Santos', 'Carla_Santos', '123');

INSERT INTO Medicos (Nome, NomeUsuario, Senha)
VALUES ('Pedro Gonçalves Ribeiro', 'Pedro_Ribeiro', '123');

INSERT INTO Medicos (Nome, NomeUsuario, Senha)
VALUES ('Manuel Carlos Solberg', 'Manuel_Solberg', '123');

INSERT INTO Medicos (Nome, NomeUsuario, Senha)
VALUES ('Laura Menezes Campestrini', 'Laura_Campestrini', '123');


INSERT INTO EtapasCirurgia (Descricao, DataHoraEtapas, IDPaciente, IDMédico)
VALUES ('Aguardando liberação do Quarto de Cirurgia', NOW(), 1, 1);

INSERT INTO EtapasCirurgia (Descricao, DataHoraEtapas, IDPaciente, IDMédico)
VALUES ('Preparação Pré-Operatória', NOW(), 1, 1);

INSERT INTO EtapasCirurgia (Descricao, DataHoraEtapas, IDPaciente, IDMédico)
VALUES ('Cirurgia Principal', NOW(), 1, 1);

INSERT INTO EtapasCirurgia (Descricao, DataHoraEtapas, IDPaciente, IDMédico)
VALUES ('Recuperação Pós-Operatória', NOW(), 1, 1);


INSERT INTO EtapasCirurgia (Descricao, DataHoraEtapas, IDPaciente, IDMédico)
VALUES ('Acompanhamento Pós-Cirúrgico', NOW(), 1, 1);

INSERT INTO EtapasCirurgia (Descricao, DataHoraEtapas, IDPaciente, IDMédico)
VALUES ('Aguardando Liberação', NOW(), 1, 1);