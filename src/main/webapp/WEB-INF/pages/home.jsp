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
   <span class="alert alert-info">Dist&acirc;ncia entre cidades americanas</span>
  </div>
  <br/>

  <form class="form-horizontal" action="calcular" method="post" >

   <div class="form-group">
    <label for="sel1">Origem::</label>
    <select id="idCidadeOrigem" name="idCidadeOrigem" class="form-control">
	  <c:forEach var="zip1" items="${zips}">
	     <option value="<c:out value="${zip1.id}" />"<c:if test="${zip1.city=='MIAMI' && zip1.state=='FL' }">selected</c:if> >
	      <c:out value="${zip1.city}" /> - <c:out value="${zip1.state}" />
	     </option>
	  </c:forEach>
    </select>
   </div>

   <div class="form-group">
    <label for="sel1">Destino:</label>
     <select name="idCidadeDestino" class="form-control">
	  <c:forEach var="zip2" items="${zips}">
	     <option value="<c:out value="${zip2.id}" />"<c:if test="${zip2.city=='ORLANDO' && zip2.state=='FL' }">selected</c:if> >
	      <c:out value="${zip2.city}" /> - <c:out value="${zip2.state}" />
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