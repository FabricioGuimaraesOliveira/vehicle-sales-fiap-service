CREATE TABLE VEHICLE (
                         VEHICLE_ID int8 NOT NULL,                -- ID do veículo (UUID)
                         MAKE VARCHAR(255) NOT NULL,               -- Marca do veículo
                         MODEL VARCHAR(255) NOT NULL,              -- Modelo do veículo
                         COLOR VARCHAR(50),                        -- Cor do veículo
                         MILEAGE INT,                              -- Quilometragem do veículo
                         PRICE DECIMAL(15, 2) NOT NULL,            -- Preço do veículo
                         STATUS VARCHAR(50) NOT NULL,              -- Status do veículo (ex: AVAILABLE, SOLD)
                         DATA_FABRICACAO TIMESTAMP WITH TIME ZONE NOT NULL,  -- Data de fabricação do veículo (OffsetDateTime)
                         CREATED_AT TIMESTAMP WITH TIME ZONE NOT NULL,       -- Data de criação do registro (OffsetDateTime)
                         UPDATED_AT TIMESTAMP WITH TIME ZONE,                -- Data de última atualização do registro (OffsetDateTime)
                         CONSTRAINT VEHICLE_PK PRIMARY KEY (VEHICLE_ID)      -- Chave primária
);


CREATE TABLE clientes(
                         cpf varchar(13) not null,
                         nome varchar(255) not null,
                         email varchar(255) not null,
                         datacadastro timestamp with time zone,
                         constraint clientes_pk primary key (cpf)
);

CREATE SEQUENCE VEICULO_SEQUENCE;
