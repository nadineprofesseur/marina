--
-- Name: bateau; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.bateau (
    id integer NOT NULL,
    nom text,
    noeud integer,
    flotte integer
);


--
-- Name: bateau_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.bateau_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: bateau_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.bateau_id_seq OWNED BY public.bateau.id;


--
-- Name: flotte; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.flotte (
    id integer NOT NULL,
    nom text
);


--
-- Name: flotte_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.flotte_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: flotte_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.flotte_id_seq OWNED BY public.flotte.id;


--
-- Name: bateau id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.bateau ALTER COLUMN id SET DEFAULT nextval('public.bateau_id_seq'::regclass);


--
-- Name: flotte id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.flotte ALTER COLUMN id SET DEFAULT nextval('public.flotte_id_seq'::regclass);


--
-- Data for Name: bateau; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.bateau VALUES (1, 'Carnaval', 5, 2);
INSERT INTO public.bateau VALUES (2, 'Crevette rose', 2, 1);
INSERT INTO public.bateau VALUES (3, 'CrunchySeafood', 2, 1);
INSERT INTO public.bateau VALUES (4, 'Chasse-Galerie', 10, 2);
INSERT INTO public.bateau VALUES (5, 'Pirate bleu', 7, 3);
INSERT INTO public.bateau VALUES (6, 'Le gentil ', 1, 3);
INSERT INTO public.bateau VALUES (8, 'faux', 25, 1);
INSERT INTO public.bateau VALUES (9, 'faux', 25, 1);
INSERT INTO public.bateau VALUES (10, 'test', 5, 0);
INSERT INTO public.bateau VALUES (11, 'voile', 1, 2);
INSERT INTO public.bateau VALUES (12, 'voile arc-en-ciel', 5, 2);


--
-- Data for Name: flotte; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.flotte VALUES (1, 'Crevettiers roses');
INSERT INTO public.flotte VALUES (2, 'Les voiles magiques');
INSERT INTO public.flotte VALUES (3, 'Drakars noirs');


--
-- Name: bateau_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.bateau_id_seq', 12, true);


--
-- Name: flotte_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.flotte_id_seq', 3, true);


--
-- Name: bateau bateau_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.bateau
    ADD CONSTRAINT bateau_pkey PRIMARY KEY (id);


--
-- Name: flotte flotte_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.flotte
    ADD CONSTRAINT flotte_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

