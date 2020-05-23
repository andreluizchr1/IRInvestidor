-- Tipo de Ações
INSERT INTO public.tipo_acao(id, nome) VALUES(1, 'Ações Preferenciais (PN)');
INSERT INTO public.tipo_acao(id, nome) VALUES(2, 'Ações Ordinárias (ON)');
INSERT INTO public.tipo_acao(id, nome) VALUES(3, 'Ações Units');

-- Cliente
INSERT INTO public.cliente(id, cpf, nome) VALUES(1, '910.835.672-68', 'ANDRE LUIZ CHAVES RODRIGUES');

-- Corretora
INSERT INTO public.corretora(id, cnpj, nome) VALUES(1, '13.434.335/0001-60', 'Investimentos CCTVM S.A');

-- Empresas
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(1, '61.532.644/0001-15', NULL, '2020-05-09 17:10:05.619', NULL, 'ITAUSA INVESTIMENTOS ITAU S.A.');
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(2, '33.000.167/0001-01', NULL, '2020-05-09 17:11:00.780', NULL, 'PETROLEO BRASILEIRO S A PETROBRAS');
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(3, '33.611.500/0001-19', NULL, '2020-05-09 17:13:28.432', NULL, 'GERDAU S.A.');
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(4, '33.014.556/0001-96', NULL, '2020-05-09 17:14:24.386', NULL, 'LOJAS AMERICANAS SA');
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(5, '33.256.439/0001-39', NULL, '2020-05-09 17:14:51.080', NULL, 'ULTRAPAR PARTICIPACOES S.A.');
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(6, '33.592.510/0001-54', NULL, '2020-05-09 17:15:13.214', NULL, 'VALE S.A.');
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(7, '42.150.391/0001-70', NULL, '2020-05-09 17:15:47.786', NULL, ' BRASKEM S.A.');
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(8, '06.164.253/0001-87', NULL, '2020-05-09 17:16:19.215', NULL, 'GOL LINHAS AEREAS INTELIGENTES S.A.');
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(9, '33.041.260/0652-90', NULL, '2020-05-09 17:17:10.109', NULL, ' VIA VAREJO S/A');
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(10, '01.545.826/0001-07', NULL, '2020-05-09 17:17:45.913', NULL, 'GAFISA S.A.');
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(11, '08.065.557/0001-12', NULL, '2020-05-09 17:18:20.814', NULL, ' TECNISA S.A');
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(13, '60.894.730/0001-05', NULL, '2020-05-09 17:19:16.000', NULL, 'USINAS SID DE MINAS GERAIS S.A.-USIMINAS');
INSERT INTO public.empresa
(id, cnpj, data_atualizacao, data_cadastro, imagem, nome)
VALUES(14, '02.558.115/0001-21', NULL, '2020-05-09 17:19:41.190', NULL, 'TIM PARTICIPACOES S.A.');

