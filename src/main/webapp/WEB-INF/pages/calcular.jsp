<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*" %>

<html>
 <head>
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
 <div class="jumbotron">
  <div class="container">

   <div class="row">
    <img src="${pageContext.request.contextPath}/resources/distancia.png" alt="logo" width="100"/>
     <span class="alert alert-info">Dist&acirc;ncia entre cidades americanas</span>
   </div>

  <br/><br/>

   <div class="row">

    <div class="col-md-5">
     <span class="label label-info">Cidade origem</span>
     <iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
      src="https://maps.google.com/maps?q=<c:out value="${longitudeOrigem}" />,-<c:out value="${latitudeOrigem}" />&amp;ie=UTF8&amp;ll=<c:out value="${longitudeOrigem}" />,-<c:out value="${latitudeOrigem}" />&amp;spn=0.485245,0.87204&amp;t=m&amp;z=11&amp;output=embed"></iframe>
     <br/><br/>
     <a class="alert alert-info" href="http://maps.google.com/?q=<c:out value="${longitudeOrigem}" />,-<c:out value="${latitudeOrigem}" />" target="_BLANK">
      <c:out value="${cidadeOrigem}" />
     </a>
    </div>

    <div class="col-md-5">
     <span class="label label-info">Cidade destino</span>
     <iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
      src="https://maps.google.com/maps?q=<c:out value="${longitudeDestino}" />,-<c:out value="${latitudeDestino}" />&amp;ie=UTF8&amp;ll=<c:out value="${longitudeDestino}" />,-<c:out value="${latitudeDestino}" />&amp;spn=0.485245,0.87204&amp;t=m&amp;z=11&amp;output=embed"></iframe>
     <br/><br/>
     <a class="alert alert-info" href="http://maps.google.com/?q=<c:out value="${longitudeDestino}" />,-<c:out value="${latitudeDestino}" />" target="_BLANK">
      <c:out value="${cidadeDestino}" />
     </a>
    </div>

   </div>
   <br/><br/>
   <div class="row">

    <input class="alert alert-warning" value="Dist&acirc;ncia: <fmt:formatNumber type="number" maxFractionDigits="3" value="${distancia}"/> Km" />

    <form action="home">
     <input class="btn btn-primary btn-lg" type="submit" value="voltar" />
    </form>


   </div>

  </div>
 </div>
</body>
</html>