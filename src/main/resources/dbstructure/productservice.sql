--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4 (Ubuntu 12.4-1.pgdg18.04+1)
-- Dumped by pg_dump version 12.4 (Ubuntu 12.4-1.pgdg18.04+1)

-- Started on 2020-10-03 15:10:32 +0530

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16386)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id integer NOT NULL,
    name character varying(100),
    unit_per_carton integer,
    carton_price double precision
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 2929 (class 0 OID 16386)
-- Dependencies: 202
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, name, unit_per_carton, carton_price) FROM stdin;
1	Penguin-ears	20	175
2	Horseshoe	5	825
\.


--
-- TOC entry 2802 (class 2606 OID 16390)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


-- Completed on 2020-10-03 15:10:32 +0530

--
-- PostgreSQL database dump complete
--

