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
-- Name: AnimeList; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "AnimeList" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';


ALTER DATABASE "AnimeList" OWNER TO postgres;

\connect "AnimeList"

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


--
-- Name: CompterAnime(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public."CompterAnime"() RETURNS bigint
    LANGUAGE sql
    AS $$

select count(id) as nombreAnime from anime

$$;


ALTER FUNCTION public."CompterAnime"() OWNER TO postgres;

--
-- Name: compteranime(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.compteranime() RETURNS bigint
    LANGUAGE sql
    AS $$

select count(id) as nombreAnime from anime

$$;


ALTER FUNCTION public.compteranime() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: anime; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.anime (
    id integer NOT NULL,
    nom text,
    nbepisode text,
    diffusion text
);


ALTER TABLE public.anime OWNER TO postgres;

--
-- Name: anime_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.anime_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.anime_id_seq OWNER TO postgres;

--
-- Name: anime_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.anime_id_seq OWNED BY public.anime.id;


--
-- Name: studio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.studio (
    nom_studio text,
    producteurs text,
    id_anime integer,
    id integer NOT NULL
);


ALTER TABLE public.studio OWNER TO postgres;

--
-- Name: studio_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.studio_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.studio_id_seq OWNER TO postgres;

--
-- Name: studio_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.studio_id_seq OWNED BY public.studio.id;


--
-- Name: anime id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.anime ALTER COLUMN id SET DEFAULT nextval('public.anime_id_seq'::regclass);


--
-- Name: studio id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.studio ALTER COLUMN id SET DEFAULT nextval('public.studio_id_seq'::regclass);


--
-- Data for Name: anime; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.anime VALUES (1, 'Made in Abyss', '13', 'Ete 2017');


--
-- Data for Name: studio; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.studio VALUES ('Kinema Citrus', 'Sentai Filmworks', 1, 1);


--
-- Name: anime_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.anime_id_seq', 1, true);


--
-- Name: studio_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.studio_id_seq', 1, true);


--
-- Name: anime id_anime; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.anime
    ADD CONSTRAINT id_anime PRIMARY KEY (id);


--
-- Name: studio id_studio; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.studio
    ADD CONSTRAINT id_studio PRIMARY KEY (id);


--
-- Name: fki_StudioToAnime; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_StudioToAnime" ON public.studio USING btree (id_anime);


--
-- Name: studio StudioToAnime; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.studio
    ADD CONSTRAINT "StudioToAnime" FOREIGN KEY (id_anime) REFERENCES public.anime(id);


--
-- PostgreSQL database dump complete
--

