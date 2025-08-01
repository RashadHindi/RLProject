PGDMP                  
    |            postgres    17.0    17.0 *    4           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            5           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            6           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            7           1262    5    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1256';
    DROP DATABASE postgres;
                     postgres    false            8           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                        postgres    false    4919            9           0    0    DATABASE postgres    ACL     �   GRANT CONNECT ON DATABASE postgres TO rashad;
GRANT CONNECT ON DATABASE postgres TO lr;
GRANT CONNECT ON DATABASE postgres TO rashadlina;
                        postgres    false    4919            :           0    0    SCHEMA public    ACL     r   GRANT ALL ON SCHEMA public TO rashad;
GRANT ALL ON SCHEMA public TO lr;
GRANT ALL ON SCHEMA public TO rashadlina;
                        pg_database_owner    false    5            t           1247    16490    gender_enum    TYPE     E   CREATE TYPE public.gender_enum AS ENUM (
    'Female',
    'Male'
);
    DROP TYPE public.gender_enum;
       public            
   rashadlina    false            Y           1247    16418    gender_type    TYPE     E   CREATE TYPE public.gender_type AS ENUM (
    'Female',
    'Male'
);
    DROP TYPE public.gender_type;
       public            
   rashadlina    false            V           1247    16403 	   user_role    TYPE     F   CREATE TYPE public.user_role AS ENUM (
    'Admin',
    'Employee'
);
    DROP TYPE public.user_role;
       public            
   rashadlina    false            �            1259    16495    order_id_seq    SEQUENCE     u   CREATE SEQUENCE public.order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.order_id_seq;
       public            
   rashadlina    false            �            1259    16442    Order    TABLE       CREATE TABLE public."Order" (
    order_id integer DEFAULT nextval('public.order_id_seq'::regclass) NOT NULL,
    customer_id integer NOT NULL,
    employee_id integer NOT NULL,
    created_date date DEFAULT CURRENT_DATE,
    total_price numeric(10,2) NOT NULL
);
    DROP TABLE public."Order";
       public         heap r    
   rashadlina    false    225            �            1259    16437    customer    TABLE     �  CREATE TABLE public.customer (
    customer_id integer NOT NULL,
    phone integer NOT NULL,
    email character varying(100) NOT NULL,
    country character varying(25) NOT NULL,
    city character varying(25) NOT NULL,
    street character varying(25) NOT NULL,
    firstname character varying(25) NOT NULL,
    middlename character varying(25) NOT NULL,
    lastname character varying(25) NOT NULL,
    gender public.gender_enum
);
    DROP TABLE public.customer;
       public         heap r    
   rashadlina    false    884            �            1259    16423    employee    TABLE     x  CREATE TABLE public.employee (
    employee_id integer NOT NULL,
    first_name character varying(100) NOT NULL,
    middle_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    gender public.gender_type NOT NULL,
    salary numeric(10,2) NOT NULL,
    birth_date date NOT NULL,
    hired_date date DEFAULT CURRENT_DATE NOT NULL,
    email character varying(250) NOT NULL,
    phone integer NOT NULL,
    country character varying(25) NOT NULL,
    city character varying(25) NOT NULL,
    street character varying(25) NOT NULL,
    zip_code character varying(10) NOT NULL,
    user_id integer
);
    DROP TABLE public.employee;
       public         heap r    
   rashadlina    false    857            �            1259    16458    item    TABLE     �   CREATE TABLE public.item (
    item_id integer NOT NULL,
    item_name character varying(50) NOT NULL,
    price numeric(20,2) NOT NULL,
    model character varying(50) NOT NULL,
    stock_quantity integer NOT NULL
);
    DROP TABLE public.item;
       public         heap r    
   rashadlina    false            �            1259    16463    order_details    TABLE     V  CREATE TABLE public.order_details (
    order_details_id integer DEFAULT nextval('public.order_id_seq'::regclass) NOT NULL,
    order_id integer NOT NULL,
    item_id integer NOT NULL,
    price numeric(20,2) NOT NULL,
    quantity integer NOT NULL,
    total_price numeric(20,2) GENERATED ALWAYS AS (((quantity)::numeric * price)) STORED
);
 !   DROP TABLE public.order_details;
       public         heap r    
   rashadlina    false    225            �            1259    16479    supplier    TABLE     �  CREATE TABLE public.supplier (
    supplier_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    phone integer NOT NULL,
    email character varying(100) NOT NULL,
    country character varying(25) NOT NULL,
    city character varying(25) NOT NULL,
    street character varying(25) NOT NULL,
    zip_code character varying(100) NOT NULL
);
    DROP TABLE public.supplier;
       public         heap r    
   rashadlina    false            �            1259    16484    supplier_and_item    TABLE     j   CREATE TABLE public.supplier_and_item (
    item_id integer NOT NULL,
    supplier_id integer NOT NULL
);
 %   DROP TABLE public.supplier_and_item;
       public         heap r    
   rashadlina    false            �            1259    16412    users    TABLE     �   CREATE TABLE public.users (
    user_id integer NOT NULL,
    user_name character varying(25) NOT NULL,
    password character varying(35) NOT NULL,
    role public.user_role NOT NULL
);
    DROP TABLE public.users;
       public         heap r    
   rashadlina    false    854            ,          0    16442    Order 
   TABLE DATA           `   COPY public."Order" (order_id, customer_id, employee_id, created_date, total_price) FROM stdin;
    public            
   rashadlina    false    220   6       +          0    16437    customer 
   TABLE DATA           }   COPY public.customer (customer_id, phone, email, country, city, street, firstname, middlename, lastname, gender) FROM stdin;
    public            
   rashadlina    false    219   \6       *          0    16423    employee 
   TABLE DATA           �   COPY public.employee (employee_id, first_name, middle_name, last_name, gender, salary, birth_date, hired_date, email, phone, country, city, street, zip_code, user_id) FROM stdin;
    public            
   rashadlina    false    218   %7       -          0    16458    item 
   TABLE DATA           P   COPY public.item (item_id, item_name, price, model, stock_quantity) FROM stdin;
    public            
   rashadlina    false    221   �8       .          0    16463    order_details 
   TABLE DATA           ]   COPY public.order_details (order_details_id, order_id, item_id, price, quantity) FROM stdin;
    public            
   rashadlina    false    222   o9       /          0    16479    supplier 
   TABLE DATA           u   COPY public.supplier (supplier_id, first_name, last_name, phone, email, country, city, street, zip_code) FROM stdin;
    public            
   rashadlina    false    223   �9       0          0    16484    supplier_and_item 
   TABLE DATA           A   COPY public.supplier_and_item (item_id, supplier_id) FROM stdin;
    public            
   rashadlina    false    224   �:       )          0    16412    users 
   TABLE DATA           C   COPY public.users (user_id, user_name, password, role) FROM stdin;
    public            
   rashadlina    false    217   *;       ;           0    0    order_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.order_id_seq', 1, false);
          public            
   rashadlina    false    225            �           2606    16447    Order Order_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Order"
    ADD CONSTRAINT "Order_pkey" PRIMARY KEY (order_id);
 >   ALTER TABLE ONLY public."Order" DROP CONSTRAINT "Order_pkey";
       public              
   rashadlina    false    220            �           2606    16441    customer customer_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public              
   rashadlina    false    219            �           2606    16429    employee employee_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (employee_id);
 @   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_pkey;
       public              
   rashadlina    false    218            �           2606    16431    employee employee_user_id_key 
   CONSTRAINT     [   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_user_id_key UNIQUE (user_id);
 G   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_user_id_key;
       public              
   rashadlina    false    218            �           2606    16462    item item_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (item_id);
 8   ALTER TABLE ONLY public.item DROP CONSTRAINT item_pkey;
       public              
   rashadlina    false    221            �           2606    16468     order_details order_details_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.order_details
    ADD CONSTRAINT order_details_pkey PRIMARY KEY (order_details_id);
 J   ALTER TABLE ONLY public.order_details DROP CONSTRAINT order_details_pkey;
       public              
   rashadlina    false    222            �           2606    16488 (   supplier_and_item supplier_and_item_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.supplier_and_item
    ADD CONSTRAINT supplier_and_item_pkey PRIMARY KEY (item_id, supplier_id);
 R   ALTER TABLE ONLY public.supplier_and_item DROP CONSTRAINT supplier_and_item_pkey;
       public              
   rashadlina    false    224    224            �           2606    16483    supplier supplier_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT supplier_pkey PRIMARY KEY (supplier_id);
 @   ALTER TABLE ONLY public.supplier DROP CONSTRAINT supplier_pkey;
       public              
   rashadlina    false    223            �           2606    16416    users user_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);
 9   ALTER TABLE ONLY public.users DROP CONSTRAINT user_pkey;
       public              
   rashadlina    false    217            �           2606    16448    Order Order_customer_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Order"
    ADD CONSTRAINT "Order_customer_id_fkey" FOREIGN KEY (customer_id) REFERENCES public.customer(customer_id);
 J   ALTER TABLE ONLY public."Order" DROP CONSTRAINT "Order_customer_id_fkey";
       public            
   rashadlina    false    219    220    4744            �           2606    16453    Order Order_employee_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Order"
    ADD CONSTRAINT "Order_employee_id_fkey" FOREIGN KEY (employee_id) REFERENCES public.employee(employee_id);
 J   ALTER TABLE ONLY public."Order" DROP CONSTRAINT "Order_employee_id_fkey";
       public            
   rashadlina    false    218    220    4740            �           2606    16432    employee employee_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id) ON DELETE CASCADE;
 H   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_user_id_fkey;
       public            
   rashadlina    false    4738    218    217            �           2606    16474 (   order_details order_details_item_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_details
    ADD CONSTRAINT order_details_item_id_fkey FOREIGN KEY (item_id) REFERENCES public.item(item_id);
 R   ALTER TABLE ONLY public.order_details DROP CONSTRAINT order_details_item_id_fkey;
       public            
   rashadlina    false    4748    221    222            �           2606    16469 )   order_details order_details_order_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_details
    ADD CONSTRAINT order_details_order_id_fkey FOREIGN KEY (order_id) REFERENCES public."Order"(order_id);
 S   ALTER TABLE ONLY public.order_details DROP CONSTRAINT order_details_order_id_fkey;
       public            
   rashadlina    false    222    220    4746            ,   F   x�U̻� �v���	�d�9�I��-�����b(�5EB ު�;>w�T��ﱴ�ǥ�sa�zrJ?��/��!      +   �   x���;�0�����8�\�/�&N..i���-1���68;�y���8Y~��v��$���/R�:ie���N��݇Zlp��8݅^�;a88gs���-Rΐ�ą�lp�h��:D��cLWa��TJ������Pr9�8����E_b����4&���v�1������2br[x��ؒp\      *   �  x���Mo�0���q@Y�%��KQ�(�k�K)�qɯ����d�i�ȉ^>yHj���q�́a�O>��q�5bS�Z9�rԕ�}H��a����\t���!yH������HZ��s~Q>����y� ��]�rla*�-�u����[d�P7FY�AL� CA^$합�Y���%}O2��q��y�x��b�l,�
�<�X�9��!�]_���xϽ���������2K�B�og��[��Q*���Bl���x�����e�PI6�ɧ�>�!�����-6��5���I��rVj%hI[Ф��)���V�Ty�fKɉ�qM���q�9���)}�X�9�V��q��G�	^e�xݔs})�]ep[?_?7�@Zj�M��]YLT�vJ�??�S      -   �   x�UN��0<�~E��YjK�jԫ$z��(�f��/������N�F��#�f�	�
f2��A]�07�JW.c�]������-�v�/1K��#J�V��K��IPn�+N�L^]�����vyK��ܲ����~"�1�      .   ?   x�%ʹ�@��,栏'��_�9��x��ňQ��b�p{s�j$��7��E�:���(      /   (  x�e��n� E�ǿ8rذ�c;U��uy1�&ӂ����>��JՅ�"��-�8p9#ȶS�s�F����1�1&�#`t��l󔬝`��Jל�2��S�Y(%�O��'8;s��ZWm'���X2	�Ⲧq�|���&�|9kG$�F��u�y�Y���m���b�;���#����t�}���-�j�i��	�PJ��+~!Q~G:${��}�<ď+kV��њ��TTv.�@�-5���/���~�&Ӳ�e
����C#��RȒ^����h��&���Z��a�� є�      0   $   x�3�4�2�4bc.SN.3NS.C ��c���� D�       )   �   x�M��� D��c*L!��C�~DKIE� L�חT�a9�'�=_��x�� ���(�R8�J��^�g���畱�Q�!y��I][ځ�����"G�B�Yg�v���s��|���č2�n��x��AJ��� ���X���.4Vֿ��os�1�Zl�DXg���E�:�Wp     