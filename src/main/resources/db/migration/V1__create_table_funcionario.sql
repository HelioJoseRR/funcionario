CREATE TABLE IF NOT EXISTS funcionario (
    id_func BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE,
    genero VARCHAR(20),
    pronomes VARCHAR(150),
    raca VARCHAR(20),
    estado_civil VARCHAR(20),
    dependentes_num INT,
    ativo BOOLEAN
);
