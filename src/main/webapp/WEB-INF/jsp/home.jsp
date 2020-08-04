<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
 <head>
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
 <br/>
 <div class="jumbotron">
  <div class="container">

  <div class="row">
   <img src="${pageContext.request.contextPath}/resources/distancia.png" alt="logo" width="100"/>
   <span class="alert alert-info">Dist&acirc;ncia entre cidades brasileiras</span>
  </div>
  <br/>

  <form class="form-horizontal" action="calcular" method="post" >

   <div class="form-group">
    <label for="sel1">Origem::</label>
    <select id="idCidadeOrigem" name="idCidadeOrigem" class="form-control">
	  <c:forEach var="municipio1" items="${municipios}">
	     <option value="<c:out value="${municipio1.id}" />"<c:if test="${municipio1.nome=='São Paulo' && municipio1.uf=='SP' }">selected</c:if> >
	      <c:out value="${municipio1.nome}" /> - <c:out value="${municipio1.uf}" />
	     </option>
	  </c:forEach>
    </select>
   </div>

   <div class="form-group">
    <label for="sel1">Destino:</label>
     <select name="idCidadeDestino" class="form-control">
	  <c:forEach var="municipio2" items="${municipios}">
	     <option value="<c:out value="${municipio2.id}" />"<c:if test="${municipio2.nome=='Santa Isabel' && municipio2.uf=='SP' }">selected</c:if> >
	      <c:out value="${municipio2.nome}" /> - <c:out value="${municipio2.uf}" />
	     </option>
	  </c:forEach>
     </select>
    </div>

   <div class="form-group">
    <input class="btn btn-primary btn-lg" type="submit" value="calcular..." />
    </div>

  </form>

  </div>
 </div>

 <br/><br/>
 </body>
</html>
