<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="kr">
<head>
	<%@ include file="/include/header.jspf" %>
</head>
<body>
	<nav class="navbar navbar-fixed-top header">
	  <h4>HSI Innovators' Society</h4>
	</nav>
	<div class="navbar navbar-default" id="subnav">
	  <div class="col-md-12">
	    <div class="navbar-header">
	      <c:if test="${not empty sessionScope.user}">
	      <ul class="nav dropdown-menu">
	        <li><a href="/users/${sessionScope.user.sec_id}"><i class="glyphicon glyphicon-user" style="color:#1111dd;"></i> Profile</a></li>
	        <li class="nav-divider"></li>
	        <li><a href="#"><i class="glyphicon glyphicon-cog" style="color:#dd1111;"></i> Settings</a></li>
	      </ul>
	      </c:if>
	    </div>
	    <div class="collapse navbar-collapse" id="navbar-collapse2">
	      <ul class="nav navbar-nav navbar-right">
	        <li class="active"><a href="/">Notices</a></li>
	        <li><a href="/qna" role="button">QnA</a></li>
	        <li><a href="/rank" role="button">Rank</a></li>
	      </ul>
	    </div>
	  </div>
	</div>


<div class="container" id="main">
   <div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
      <div class="panel panel-default content-main">
          <form name="question" method="post" action="/notice/create">
              <div class="form-group">
                  <label for="title">제목</label>
                  <input type="text" class="form-control" id="title" name="title" placeholder="제목"/>
              </div>
              <div class="form-group">
                  <label for="contents">내용</label>
                  <textarea name="content" id="content" rows="5" class="form-control"></textarea>
              </div>
              <button type="submit" class="btn btn-success clearfix pull-right">질문하기</button>
              <div class="clearfix" />
          </form>
        </div>
    </div>
</div>

<%@ include file="/include/footer.jspf" %>
</body>
</html>
