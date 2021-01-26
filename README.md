mongodb-java-geospatial-springdata-casadocodigo
===============================================

MongoDB com Geospatial + Java com Spring Data  + Bootstrap
-----------------------------------------------------------

* Database.....: *test*
* Collection...: *municipios*

* Exemplo de documento

```
db.municipios.findOne()
{
    "_id" : 3500550.0,
    "nome" : "Águas de Santa Bárbara",
    "uf" : "SP",
    "estado" : "São Paulo",
    "loc" : {
        "x" : -49.2421,
        "y" : -22.8812
    },
    "capital" : "N"
}
```
--------------------------------------------

1. Restaure o banco do diretório DUMP
2. mvn spring-boot:run 
3. Acesse a URL:  http://localhost:8080/home


> ![Compre agora](https://github.com/boaglio/boaglio/blob/master/mongodb.png)
>
> :green_book: este repositório faz parte do livro *MongoDB*
>
> :face_with_head_bandage: [ajude o meu trabalho e compre uma cópia](https://www.casadocodigo.com.br/products/livro-mongodb)!
>
> custa menos que um :hamburger: lanche :fries:!
