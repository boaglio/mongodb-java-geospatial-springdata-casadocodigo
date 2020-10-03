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
