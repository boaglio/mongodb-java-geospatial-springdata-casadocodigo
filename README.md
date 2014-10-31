mongodb-java-geospatial-springdata-casadocodigo
====================================

MongoDB com Geospatial + Java com Spring Data  + Bootstrap
--------------------------------------------

* Database.....: *test*
* Collection...: *zipcodes*

* Exemplo de documento

```
db.zipcodes.findOne()
 
{
    "_id" : ObjectId("544edc295e0a44b1d3da5d2a"),
    "city" : "AARON",
    "state" : "KY",
    "loc" : {
        "x" : 85.19911399999999,
        "y" : 36.812827
    }
}
```
--------------------------------------------

1. Restaure o banco do diretório DUMP
2. Execute o script sobe-tomcat
3. Acesse a URL:  http://localhost:8080/
