CREATE TABLE public.bateau (
    id integer NOT NULL,
    nom text,
    noeud integer,
    flotte integer
);


--
-- TOC entry 217 (class 1259 OID 32991)
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
-- TOC entry 3335 (class 0 OID 0)
-- Dependencies: 217
-- Name: bateau_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.bateau_id_seq OWNED BY public.bateau.id;


--
-- TOC entry 215 (class 1259 OID 24792)
-- Name: flotte; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.flotte (
    id integer NOT NULL,
    nom text
);


--
-- TOC entry 214 (class 1259 OID 24791)
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
-- TOC entry 3336 (class 0 OID 0)
-- Dependencies: 214
-- Name: flotte_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.flotte_id_seq OWNED BY public.flotte.id;


--
-- TOC entry 3179 (class 2604 OID 32992)
-- Name: bateau id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.bateau ALTER COLUMN id SET DEFAULT nextval('public.bateau_id_seq'::regclass);


--
-- TOC entry 3178 (class 2604 OID 24795)
-- Name: flotte id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.flotte ALTER COLUMN id SET DEFAULT nextval('public.flotte_id_seq'::regclass);


--
-- TOC entry 3328 (class 0 OID 32988)
-- Dependencies: 216
-- Data for Name: bateau; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.bateau VALUES (1, 'Carnaval', 5, 2);
INSERT INTO public.bateau VALUES (2, 'Crevette rose', 2, 1);
INSERT INTO public.bateau VALUES (3, 'CrunchySeafood', 2, 1);
INSERT INTO public.bateau VALUES (4, 'Chasse-Galerie', 10, 2);
INSERT INTO public.bateau VALUES (5, 'Pirate bleu', 7, 3);
INSERT INTO public.bateau VALUES (6, 'Le gentil ', 1, 3);


--
-- TOC entry 3327 (class 0 OID 24792)
-- Dependencies: 215
-- Data for Name: flotte; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.flotte VALUES (1, 'Crevettiers roses');
INSERT INTO public.flotte VALUES (2, 'Les voiles magiques');
INSERT INTO public.flotte VALUES (3, 'Drakars noirs');


--
-- TOC entry 3337 (class 0 OID 0)
-- Dependencies: 217
-- Name: bateau_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.bateau_id_seq', 6, true);


--
-- TOC entry 3338 (class 0 OID 0)
-- Dependencies: 214
-- Name: flotte_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.flotte_id_seq', 3, true);


--
-- TOC entry 3183 (class 2606 OID 32999)
-- Name: bateau bateau_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.bateau
    ADD CONSTRAINT bateau_pkey PRIMARY KEY (id);


--
-- TOC entry 3181 (class 2606 OID 24799)
-- Name: flotte flotte_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.flotte
    ADD CONSTRAINT flotte_pkey PRIMARY KEY (id);


-- Completed on 2023-09-27 14:41:07

--
-- PostgreSQL database dump complete
--

