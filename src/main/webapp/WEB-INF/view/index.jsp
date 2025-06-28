<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Registration Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/26b080bfd8.js"
	crossorigin="anonymous"></script>

</head>
<style>
body {
	font-family: cursive;
}

.header {
	float: right;
}

.box {
	border: 2px solid black;
}

</style>
<body>

	<div class="container ">
		<div class="mt-2">
			<div class="text-primary h2 text-center">Library Registration
				Form</div>
			<span class="header text-danger h6">*mandatory fields</span>
		</div>
		<div class="mt-5">
			<form action="./register" method="post" class="row"
				enctype="multipart/form-data">
				<div class="col-md-2"></div>
				<div class="col-md-4">
					<label>Library name*</label> <select class="form-control"
						onchange="getSubscription()" id="lib" name="lId">
						<option value="-1">--Select--</option>
						<c:forEach items="${lbList}" var="library">
							<option value="${library.libraryId}">${library.libraryName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-4">
					<label>Subscription Type*</label> <select class="form-control"
						id="sub" name="subId">
						<option>--Select--</option>
					</select>
				</div>
				<div class="col-md-2"></div>
				<div class="mt-5">
					<label class="h5">Applicant Details</label>
					<div class="box row p-2">
						<div class="col-md-4">
							<label>Name*</label> <input class="form-control" type="text"
								placeholder="Enter your name" name="name">
						</div>
						<div class="col-md-4">
							<label>Email*</label> <input class="form-control" type="text"
								placeholder="Enter E-mail" name="email">
						</div>
						<div class="col-md-4">
							<label>Mobile no*</label> <input class="form-control" type="text"
								placeholder="Enter mobile number" name="mobileNo">
						</div>
						<div class="col-md-4 mt-1 ">
							<label>Date Of Birth*</label> <input class="form-control"
								type="date" name="dob">
						</div>
						<div class="col-md-4 mt-1">
							<label>Gender*</label><br> <input type="radio" id="male"
								name="gender" value='m'>Male <input type="radio"
								id="female" name="gender" value='f'>Female
						</div>
						<div class="col-md-4 mt-1 ">
							<label>Upload Photo*</label> <input class="form-control"
								type="file" name="photoFile">
						</div>
						<div class="text-center">
							<button class="btn btn-primary" type="submit">Submit</button>
							<button class="btn btn-warning" type="reset">Reset</button>

						</div>

					</div>
				</div>
			</form>

			<div class="mt-4">
				<div class="h2 text-center text-primary">Registration Details</div>
				<table class="table table-bordered table-striped">
					<thead class="bg-info">
						<tr>
							<th>Sl No.</th>
							<th>Name</th>
							<th>Email</th>
							<th>Mobile no</th>
							<th>Image</th>
							<th>Library Name</th>
							<th>Subscription</th>
							<th>Action</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${regList}" var="reg" varStatus="counter">
							<tr>
								<td>${counter.count}</td>
								<td>${reg.applicantName}</td>
								<td>${reg.emailId}</td>
								<td>${reg.mobileNo}</td>
								<td>${reg.imagePath}</td>
								<td>${reg.libraryMaster.libraryName}</td>
								<td>${reg.subscriptionMaster.subscriptionType}</td>
								<td><a href="./delete?uId=${reg.registrationId}"
									class="btn btn-danger text-light" onclick="return onDelete()"><i
										class="fa-solid fa-user-xmark"></i></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>


			</div>
		</div>
	</div>
	<script type="text/javascript">
		function getSubscription() {

			let lbId = $("#lib").val();

			$.ajax({
				url : "./getSubscription",//here,./` is used to refer to the current directory, 
				//so the path continues from the previous endpoint without changing it.

				type : "post",
				data : "libId=" + lbId,
				success : function(response) {
					$("#sub").empty();
					$("#sub").append(response);
				},
				error : function(res) {
					console.log(res)
				}
			});
		}
		function onDelete(){
			return confirm("Do you really want to delete?");
		}
	</script>
</body>
</html>