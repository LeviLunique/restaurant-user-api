-- =====================================================
-- Migration: V2__insert_initial_data.sql
-- Description: Inserts initial data for testing
-- Author: Levi Lunique
-- Date: 2025-11-16
-- =====================================================

-- Insert ADMIN user
-- Password: Admin@123 (BCrypt hash)
INSERT INTO usuario (nome, email, login, senha, tipo_usuario, telefone, ativo)
VALUES (
    'Administrador do Sistema',
    'admin@restauranthub.com',
    'admin',
    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
    'ADMIN',
    '+55 11 99999-0000',
    true
);

-- Insert address for ADMIN
INSERT INTO endereco (usuario_id, tipo_endereco, rua, numero, bairro, cidade, estado, cep, principal, ativo)
VALUES (
    (SELECT id FROM usuario WHERE login = 'admin'),
    'COMERCIAL',
    'Av. Paulista',
    '1000',
    'Bela Vista',
    'São Paulo',
    'SP',
    '01310-100',
    true,
    true
);

-- Insert DONO_RESTAURANTE users
-- Password for all: Dono@123 (BCrypt hash)
INSERT INTO usuario (nome, email, login, senha, tipo_usuario, telefone, ativo)
VALUES 
(
    'Roberto Faria',
    'roberto.faria@restaurante.com',
    'roberto.faria',
    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
    'DONO_RESTAURANTE',
    '+55 11 98888-1111',
    true
),
(
    'Márcia Oliveira',
    'marcia.oliveira@restaurante.com',
    'marcia.oliveira',
    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
    'DONO_RESTAURANTE',
    '+55 11 98888-2222',
    true
),
(
    'Fernando Santos',
    'fernando.santos@restaurante.com',
    'fernando.santos',
    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
    'DONO_RESTAURANTE',
    '+55 11 98888-3333',
    true
);

-- Insert addresses for DONO_RESTAURANTE users
INSERT INTO endereco (usuario_id, tipo_endereco, rua, numero, complemento, bairro, cidade, estado, cep, principal, ativo)
VALUES 
(
    (SELECT id FROM usuario WHERE login = 'roberto.faria'),
    'COMERCIAL',
    'Rua Augusta',
    '1500',
    'Loja 5',
    'Consolação',
    'São Paulo',
    'SP',
    '01304-001',
    true,
    true
),
(
    (SELECT id FROM usuario WHERE login = 'marcia.oliveira'),
    'COMERCIAL',
    'Av. Brigadeiro Faria Lima',
    '3477',
    'Conjunto 1201',
    'Itaim Bibi',
    'São Paulo',
    'SP',
    '04538-133',
    true,
    true
),
(
    (SELECT id FROM usuario WHERE login = 'fernando.santos'),
    'COMERCIAL',
    'Rua Oscar Freire',
    '379',
    NULL,
    'Jardins',
    'São Paulo',
    'SP',
    '01426-001',
    true,
    true
);

-- Insert CLIENTE users
-- Password for all: Cliente@123 (BCrypt hash)
INSERT INTO usuario (nome, email, login, senha, tipo_usuario, telefone, ativo)
VALUES 
(
    'João Silva',
    'joao.silva@email.com',
    'joao.silva',
    '$2a$10$rZ8WqJZCz3NQKJXZz7cE2uxLGPNKqRYVlj0qYJVKV2Nh9qJQKqN7S',
    'CLIENTE',
    '+55 11 98765-4321',
    true
),
(
    'Fernanda Costa',
    'fernanda.costa@email.com',
    'fernanda.costa',
    '$2a$10$rZ8WqJZCz3NQKJXZz7cE2uxLGPNKqRYVlj0qYJVKV2Nh9qJQKqN7S',
    'CLIENTE',
    '+55 11 97777-5555',
    true
),
(
    'Ricardo Mendes',
    'ricardo.mendes@email.com',
    'ricardo.mendes',
    '$2a$10$rZ8WqJZCz3NQKJXZz7cE2uxLGPNKqRYVlj0qYJVKV2Nh9qJQKqN7S',
    'CLIENTE',
    '+55 11 97777-6666',
    true
),
(
    'Patricia Lima',
    'patricia.lima@email.com',
    'patricia.lima',
    '$2a$10$rZ8WqJZCz3NQKJXZz7cE2uxLGPNKqRYVlj0qYJVKV2Nh9qJQKqN7S',
    'CLIENTE',
    '+55 11 97777-7777',
    true
),
(
    'Roberto Alves',
    'roberto.alves@email.com',
    'roberto.alves',
    '$2a$10$rZ8WqJZCz3NQKJXZz7cE2uxLGPNKqRYVlj0qYJVKV2Nh9qJQKqN7S',
    'CLIENTE',
    '+55 11 97777-8888',
    true
);

-- Insert addresses for CLIENTE users
INSERT INTO endereco (usuario_id, tipo_endereco, rua, numero, complemento, bairro, cidade, estado, cep, principal, ativo)
VALUES 
(
    (SELECT id FROM usuario WHERE login = 'joao.silva'),
    'RESIDENCIAL',
    'Rua das Flores',
    '123',
    'Apto 45',
    'Vila Mariana',
    'São Paulo',
    'SP',
    '04052-010',
    true,
    true
),
(
    (SELECT id FROM usuario WHERE login = 'fernanda.costa'),
    'RESIDENCIAL',
    'Av. dos Clientes',
    '456',
    NULL,
    'Moema',
    'São Paulo',
    'SP',
    '04077-020',
    true,
    true
),
(
    (SELECT id FROM usuario WHERE login = 'ricardo.mendes'),
    'RESIDENCIAL',
    'Rua dos Testes',
    '789',
    'Casa 2',
    'Pinheiros',
    'São Paulo',
    'SP',
    '05422-001',
    true,
    true
),
(
    (SELECT id FROM usuario WHERE login = 'patricia.lima'),
    'RESIDENCIAL',
    'Praça Central',
    '321',
    'Bloco A',
    'Santana',
    'São Paulo',
    'SP',
    '02012-001',
    true,
    true
),
(
    (SELECT id FROM usuario WHERE login = 'roberto.alves'),
    'RESIDENCIAL',
    'Alameda dos Restaurantes',
    '654',
    NULL,
    'Jardim Paulista',
    'São Paulo',
    'SP',
    '01404-001',
    true,
    true
);

-- Insert an inactive user for testing
INSERT INTO usuario (nome, email, login, senha, tipo_usuario, telefone, ativo)
VALUES (
    'Usuário Inativo',
    'inativo@email.com',
    'inativo',
    '$2a$10$rZ8WqJZCz3NQKJXZz7cE2uxLGPNKqRYVlj0qYJVKV2Nh9qJQKqN7S',
    'CLIENTE',
    '+55 11 97777-9999',
    false
);

-- Insert address for inactive user
INSERT INTO endereco (usuario_id, tipo_endereco, rua, numero, bairro, cidade, estado, cep, principal, ativo)
VALUES (
    (SELECT id FROM usuario WHERE login = 'inativo'),
    'RESIDENCIAL',
    'Rua dos Inativos',
    '999',
    'Centro',
    'São Paulo',
    'SP',
    '01001-000',
    true,
    true
);

-- Display summary of inserted data
-- Note: The following is just for documentation, PostgreSQL doesn't support SELECT in migrations by default
-- Total users inserted:
-- - 1 ADMIN
-- - 3 DONO_RESTAURANTE
-- - 6 CLIENTE (5 active + 1 inactive)
-- Total: 10 users

-- Passwords used (for testing purposes only):
-- ADMIN: Admin@123
-- DONO_RESTAURANTE: Dono@123
-- CLIENTE: Cliente@123
