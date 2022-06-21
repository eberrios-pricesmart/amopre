/*Usuario Default*/
INSERT INTO departamento(id, nombre) VALUES (1,'Lima');
INSERT INTO ciudad(id, departamento_id, nombre) VALUES (1,1,'Lima');

INSERT INTO persona (id, nombre, apellido, dni, fecha_nacimiento, celular, email, ciudad_id) VALUES (1, 'Rebeca', 'Huarancca', '74581236', NOW(),'987654321', 'test123@gmail.com', 1);
INSERT INTO persona (id, nombre, apellido, dni, fecha_nacimiento, celular, email, ciudad_id) VALUES (2, 'Robeto', 'Mosquera', '78945612', NOW(),'987654321', 'test123@gmail.com', 1);

INSERT INTO authorities (id, authority) VALUES (1,'ROLE_ADMIN');
INSERT INTO authorities (id, authority) VALUES (2,'ROLE_USER');

INSERT INTO users (username, password, enabled,authority_id, person_id) VALUES ('admin','$2a$10$VG4gsYRVaQxVHhlG52iHGu38TjDjw8r1o3BPPxnbRV41Fr3Q7nQ7m',1,1,1);
INSERT INTO users (username, password, enabled,authority_id, person_id) VALUES ('andres','$2a$10$sZerUj5QAvj2H24hSPMgOuC9tVD/3c0XfP4MxfmVmC/tlIYMKwgeS',1,2,2);

/* Carrousel tables */
INSERT INTO carrousel (id, title, description, button_name, usuario_id) VALUES (1, 'best collection','new arrivals','compra aquí',1);
INSERT INTO carrousel (id, title, description, button_name, usuario_id) VALUES (2, 'best price & offer', 'new season','buy now',1);


INSERT INTO mnt_blog (id, title, content, author, button_name, image, usuario_id) VALUES (1, '¿Sabías que tienes más ofertas si pagas con tarjeta?', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet aspernatur repudiandae nostrum dolorem molestias odio. Sit fugit adipisci omnis quia itaque ratione iusto sapiente reiciendis, numquam officiis aliquid ipsam fuga.', 'Rebeca Huarancca', 'Leer más' ,'blog_1.jpg',1);
INSERT INTO mnt_blog (id, title, content, author, button_name, image, usuario_id) VALUES (2, 'Tips para comprar más y pagar menos', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet aspernatur repudiandae nostrum dolorem molestias odio. Sit fugit adipisci omnis quia itaque ratione iusto sapiente reiciendis, numquam officiis aliquid ipsam fuga.', 'Alonso Rodriguez', 'Leer más' ,'blog_2.jpg',1);
INSERT INTO mnt_blog (id, title, content, author, button_name, image, usuario_id) VALUES (3, 'Compra feliz gracias a las tarjetas CMR', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet aspernatur repudiandae nostrum dolorem molestias odio. Sit fugit adipisci omnis quia itaque ratione iusto sapiente reiciendis, numquam officiis aliquid ipsam fuga.', 'Jhon Carter', 'Leer más' ,'blog_3.jpg',1);



