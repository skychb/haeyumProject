<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="kr">
<head>
	<%@ include file="/include/header.jspf" %>
</head>
<script>
var chiho = '${post}';
console.log(chiho);
</script>
<body>
	<nav class="navbar navbar-fixed-top header">
	  <h4>HSI Innovators' Society</h4>
	</nav>
	<div class="navbar navbar-default" id="subnav">
	  <div class="col-md-12">

	    <div class="collapse navbar-collapse" id="navbar-collapse2">
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="/notice">Notices</a></li>
	        <li class="active"><a href="/qna/${user.par_teamNum}" role="button">QnA</a></li>
	        <li><a href="/rank" role="button">Rank</a></li>
	      </ul>
	    </div>
	  </div>
	</div>

<div class="container" id="main">
	<div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
		<div class="panel panel-default qna-list">
			<ul class="list">
				<c:forEach items="${post}" var="each">
				<li>
					<div class="wrap">
						<div class="main">
							<strong class="subject">
								<a href="/qna/${sessionScope.user.par_teamNum}/${each.id_post}">${each.title}</a>
							</strong>
							<div class="auth-info">
								<i class="icon-add-comment"></i>
								<span class="time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${each.date}" /></span>
								<a href="#" class="author">${each.writer}</a>
							</div>
							<div class="reply" title="댓글">
								<i class="icon-reply"></i>
								<%-- <span class="point">${each.countOfComment}</span> --%>
							</div>
						</div>
					</div>
				</li>
				</c:forEach>
			</ul>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6 text-center">
					<ul class="pagination center-block" style="display:inline-block;">
						<li><a href="#">«</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">»</a></li>
					</ul>
				</div>
				<div class="col-md-3 qna-write">
					<a href="/qna/${sessionScope.user.par_teamNum}/new" class="btn btn-primary pull-right" role="button">질문하기</a>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/include/footer.jspf" %>
</body>
</html>
