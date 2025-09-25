CREATE TABLE IF NOT EXISTS contato (
    id_contato BIGSERIAL PRIMARY KEY,
    func_id BIGINT NOT NULL,
    email_inst VARCHAR(100) NOT NULL UNIQUE,
    email_alt VARCHAR(100),
    telefone VARCHAR(20),
    whatsapp VARCHAR(20),
    linkedin VARCHAR(255),
    lattes VARCHAR(255),

    CONSTRAINT fk_funcionario
        FOREIGN KEY (func_id) REFERENCES funcionario(id_func)
);