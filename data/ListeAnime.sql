--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: ListeAnime; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "ListeAnime" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';


ALTER DATABASE "ListeAnime" OWNER TO postgres;

\connect "ListeAnime"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: Anime; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Anime" (
    "idAnime" integer NOT NULL,
    "Titre" text,
    "Studio" text,
    "NbEpisode" text,
    "Diffusion" text
);


ALTER TABLE public."Anime" OWNER TO postgres;

--
-- Data for Name: Anime; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Anime" VALUES (1, 'Made in abyss', 'Kinema Citrus', '13', 'Ete 2017');
INSERT INTO public."Anime" VALUES (2, 'A Silent Voice', 'Kyoto Animation', '1
', 'Automne 2016');
INSERT INTO public."Anime" VALUES (3, 'Your Name', 'CoMix Wave Film', '1
', 'Ete 2016');
INSERT INTO public."Anime" VALUES (4, 'Hyouka', 'Kyoto Animation', '22', 'Printemps 2012');


--
-- Name: Anime Anime_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Anime"
    ADD CONSTRAINT "Anime_pkey" PRIMARY KEY ("idAnime");


--
-- PostgreSQL database dump complete
--

