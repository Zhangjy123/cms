<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Panelo - Free Admin Template</title>
<link rel="stylesheet" type="text/css" href="${base}/css/style.css" />
<!-- <link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'> -->
	<!-- jQuery file -->
	<script src="${base}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${base}/js/jquery.hoveraccordion.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example2').hoverAccordion({
				activateitem : '1',
				speed : 'fast'
			});

			$("#123").toggle(function() {
				$("#tab1").slideDown();
			}, function() {
				$("#tab1").slideUp();
			});
		});
	</script>
</head>
<body>
	<div id="panelwrap">
	<jsp:include page="../top.jsp"></jsp:include>
	<!-- 
		<div class="header">
			<div class="title">
				<a href="#">Panelo Admin</a>
			</div>
			<div class="header_right">
				Welcome Admin, <a href="#" class="settings">Settings</a> <a href="#"
					class="logout">Logout</a>
			</div>
		</div>
		<div class="submenu">
			<ul></ul>
		<!-- 
			<ul>
				<li><a href="#" class="selected">settings</a></li>
				<li><a href="#">users</a></li>
				<li><a href="#">categories</a></li>
				<li><a href="#">edit section</a></li>
				<li><a href="#">templates</a></li>
			</ul>
			 
		</div>
		-->
		<div class="center_content">
			<div id="right_wrap">

				<div id="right_content">
					<h2>
						Tables section
						<sapn> <a id="123" href="javascript:void(0);">[筛选]</a></sapn>
					</h2>
					<div id="tab1" class="tabcontent" style="display: none;">
						<h3>Tab one title</h3>
						<div class="form">

							<div class="form_row">
								<label>Name:</label> <input type="text" class="form_input"
									name="" />
							</div>

							<div class="form_row">
								<label>Email:</label> <input type="text" class="form_input"
									name="" />
							</div>

							<div class="form_row">
								<label>Subject:</label> <select class="form_select" name="">
									<option>Select one</option>
								</select>
							</div>

							<div class="form_row">
								<label>Message:</label>
								<textarea class="form_textarea" name=""></textarea>
							</div>
							<div class="form_row">
								<input type="submit" class="form_submit" value="Submit" />
							</div>
							<div class="clear"></div>
						</div>
					</div>

					<table id="rounded-corner">
						<thead>
							<tr>
								<th></th>
								<th>Product</th>
								<th>Details</th>
								<th>Price</th>
								<th>Date</th>
								<th>Category</th>
								<th>User</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="12">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit, sed do eiusmod tempor incididunt ut.</td>
							</tr>
						</tfoot>
						<tbody>
							<tr class="odd">
								<td><input type="checkbox" name="" /></td>
								<td>Box Software</td>
								<td>Lorem ipsum dolor sit amet consectetur</td>
								<td>45$</td>
								<td>10/04/2011</td>
								<td>web design</td>
								<td>Alex</td>
								<!--
	            <td><a href="#"><img src="images/edit.png" alt="" title="" border="0" /></a></td>
	            <td><a href="#"><img src="images/trash.gif" alt="" title="" border="0" /></a></td>
	            -->
								<td><a href="#" class="button green">Edit selected</a></td>
								<td><a href="#" class="button red">Delete selected</a></td>
							</tr>
							<tr class="even">
								<td><input type="checkbox" name="" /></td>
								<td>Trial Software</td>
								<td>Lorem ipsum dolor sit amet consectetur</td>
								<td>155$</td>
								<td>12/04/2011</td>
								<td>web design</td>
								<td>Carrina</td>
								<!--
	            <td><a href="#"><img src="images/edit.png" alt="" title="" border="0" /></a></td>
	            <td><a href="#"><img src="images/trash.gif" alt="" title="" border="0" /></a></td>
	            -->
								<td><a href="#" class="button green">Edit selected</a></td>
								<td><a href="#" class="button red">Delete selected</a></td>
							</tr>
							<tr class="odd">
								<td><input type="checkbox" name="" /></td>
								<td>Hosting Pack</td>
								<td>Lorem ipsum dolor sit amet consectetur</td>
								<td>45$</td>
								<td>10/04/2011</td>
								<td>web design</td>
								<td>Alex</td>
								<!--
	            <td><a href="#"><img src="images/edit.png" alt="" title="" border="0" /></a></td>
	            <td><a href="#"><img src="images/trash.gif" alt="" title="" border="0" /></a></td>
	            -->
								<td><a href="#" class="button green">Edit selected</a></td>
								<td><a href="#" class="button red">Delete selected</a></td>
								<tr class="even">
									<td><input type="checkbox" name="" /></td>
									<td>Duo Software</td>
									<td>Lorem ipsum dolor sit amet consectetur</td>
									<td>745$</td>
									<td>10/04/2011</td>
									<td>web design</td>
									<td>Alex</td>
									<!--
	            <td><a href="#"><img src="images/edit.png" alt="" title="" border="0" /></a></td>
	            <td><a href="#"><img src="images/trash.gif" alt="" title="" border="0" /></a></td>
	            -->
									<td><a href="#" class="button green">Edit selected</a></td>
									<td><a href="#" class="button red">Delete selected</a></td>
									<tr class="odd">
										<td><input type="checkbox" name="" /></td>
										<td>Alavasti Software</td>
										<td>Lorem ipsum dolor sit amet consectetur</td>
										<td>45$</td>
										<td>10/04/2011</td>
										<td>web design</td>
										<td>John</td>
										<!--
	            <td><a href="#"><img src="images/edit.png" alt="" title="" border="0" /></a></td>
	            <td><a href="#"><img src="images/trash.gif" alt="" title="" border="0" /></a></td>
	            -->
										<td><a href="#" class="button green">Edit selected</a></td>
										<td><a href="#" class="button red">Delete selected</a></td>
										<tr class="even">
											<td><input type="checkbox" name="" /></td>
											<td>Box Software</td>
											<td>Lorem ipsum dolor sit amet consectetur</td>
											<td>45$</td>
											<td>10/04/2011</td>
											<td>web design</td>
											<td>Doe</td>
											<!--
	            <td><a href="#"><img src="images/edit.png" alt="" title="" border="0" /></a></td>
	            <td><a href="#"><img src="images/trash.gif" alt="" title="" border="0" /></a></td>
	            -->
											<td><a href="#" class="button green">Edit selected</a></td>
											<td><a href="#" class="button red">Delete selected</a></td>
										</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- end of right content-->
			<jsp:include page="../menu.jsp"></jsp:include>
			
			
		</div>
		<!--end of center_content-->

		<div class="footer">
			Panelo - Free Admin Collect from <a href="http://www.mycodes.net/"
				title="ç½ç«æ¨¡æ¿" target="_blank">ç½ç«æ¨¡æ¿</a>
		</div>

	</div>


</body>
</html>