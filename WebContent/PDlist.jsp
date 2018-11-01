<%@ page import="java.util.*, java.sql.*,DAO.*"  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html lang="zh-Hans-TW">
	<head>
		<title>SampleShop for Learning Coding</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="left-sidebar">
		    <div id="page-wrapper">

			    <!-- Header -->
				    <div id="header-wrapper">
					    <div id="header" class="container">

						    <!-- Logo -->
							    <h1 id="logo"><a href="index.jsp">SAMPLE SHOP</a></h1>

						    <!-- Nav -->
							    <nav id="nav">
								    <ul>
									    <li>
										    <a href="#">新品上市</a>
										    <ul>
											    <li><a href="PDlist.jsp">每周新品</a></li>
											    <li><a href="PDlist.jsp">夏季新品</a></li>
										    </ul>
									    </li>
									    <li><a href="PDlist.jsp">暢銷排行</a></li>
									    <li class="break"><a href="PDlist.jsp">全館商品</a></li>
									    <li><a href="PDlist.hsp">精選活動</a></li>
								    </ul>
							    </nav>

					    </div>
				    </div>

			    <!-- Main -->
				    <div class="wrapper">
					    <div class="container" id="main">
						    <div class="row">
							    <div class="3u 12u(narrower)">

								    <!-- Sidebar -->
									    <section id="sidebar">
									    
									    <% String User_ID_Session = String.valueOf(session.getAttribute("User_ID"));
									    	if ((User_ID_Session == "")||(User_ID_Session == null)){ %>
									    	<form action="login" method="post">
                                                <section>
											        <header>
												        <h3>會員登入</h3>
											        </header>
											        <p><input type="text" id="TB_User_Acc" name="TB_User_Acc" placeholder="帳號ID"></p>
											        <p><input type="password" id="TB_User_Pwd" name="TB_User_Pwd" placeholder="密碼 Password"></p>
											        <ul class="actions">
												        <li>
                                                        	<input type="submit" ID="BT_Login" Value="　登入　" >
                                                        	
                                                        </li>
											        </ul>
										        </section>
										    </form>
										    <form action="regedit.jsp">
										    	<input type="submit" ID="BT_toRegist" Value="加入會員">
										    </form>
										  	<%}else{ %>
										    <form action="logout">
                                                <section>
											        <header>
												        <h3>歡迎回來</h3>
											        </header>

											        <p>會員狀態：</p>
                                                    <p>
                                                    	<a href="shopcart.jsp">目前購物車有 ( <%out.println(cartDAO.countcart(String.valueOf(session.getAttribute("User_ID"))));%>) 件商品</a>
                                                    </p>
											        <p><input type="submit" ID="BT_Logout" Value="登出"></p>
										        </section>
										    </form>  
										    <%} %>  
                                            <section>
											    <a href="#" class="image featured"><img src="images/caroupic02.jpg" alt=""/></a>
										    </section>
									    </section>

							    </div>
                                <!-- Content -->
                                <div class="9u 12u(narrower)">
                                        <article id="content">
                                                <header>
									                <h2>新品上市</h2>
										            <p>全館買越多送越多</p>
									            </header>
									            <div class="row">
									            	<div class="3u 12u(narrower) important(narrower)">
									            	廠牌：
									            	<%
									            	String brand = request.getParameter("brand");
									            	String type = request.getParameter("type");
									            	if (brand == null){brand="";}
									            	if (type == null){type="";}
									            	
									            	
									            	String sql = "select DISTINCT PD_Brand from [Products]";
									            	ResultSet rs = databaseDAO.getResult(sql);
									            	out.print("<select id='Brand' name='Brand' size='1'>");
									            	out.print("<option value=''>全部</option>");
									            	while (rs.next()){
									            		if (brand.equals(rs.getString("PD_Brand"))){
									            			out.print("<option value='"+ rs.getString("PD_Brand") +"' selected>"+ rs.getString("PD_Brand") +"</option> ");
									            		}else{
									            			out.print("<option value='"+ rs.getString("PD_Brand") +"'>"+ rs.getString("PD_Brand") +"</option> ");
									            		}
									            		
									            	}
									            	out.print("</select>");
									            	%>
									            	</div>
									            	
									            	<div class="3u 12u(narrower) important(narrower)">
									            	類別：
									            	<% sql = "select DISTINCT PD_Type from [Products]";
									            	 rs = databaseDAO.getResult(sql);
									            	out.print("<select id='Type' name='Type' size='1'>");
									            	out.print("<option value=''>全部</option>");
									            	while (rs.next()){
									            		if (type.equals(rs.getString("PD_Type"))){
									            			out.print("<option value='"+ rs.getString("PD_Type") +"' selected>"+ rs.getString("PD_Type") +"</option> ");
									            		}else{
									            			out.print("<option value='"+ rs.getString("PD_Type") +"'>"+ rs.getString("PD_Type") +"</option> ");
									            		}
									            		
									            	}
									            	out.print("</select>");
									            	%>
									            	</div>
									            	
									            	<div class="3u 12u(narrower) important(narrower)">
									            	</div>
									            	<div class="3u 12u(narrower) important(narrower)">
									            	</div>
									            </div>
									            <div class="row">
											            <%
											            
											         		sql= "select * from [Products] where PD_Brand LIKE \'%"+ brand +"%\'and PD_Type LIKE \'%"+ type +"%\'";
											            	rs = databaseDAO.getResult(sql);
											            	while(rs.next()){
											            		out.print("<div class='col-sm-3'><a href='PD.jsp?pid="+ rs.getString("PD_ID") +"'><img src='images/"+ rs.getString("PD_Photo") +"' style='height:208px;width:160px;''></a > <br> "+ rs.getString("PD_Brand") +" "+ rs.getString("PD_Type") +" <br>"+ rs.getString("PD_Name") +" <br> NT: &nbsp;"+ rs.getString("PD_Price") +" </div>\n");
											            	}
											            %>
									            </div>
                                        </article>
                                    </div>
							</div>
						</div>
                    </div>
		    </div>

			    <!-- Footer -->
				    <div id="footer-wrapper">
					<div id="footer" class="container">
						<header class="major">
							<h2>歡迎訂閱我們</h2>
							<p>訂閱可以享受每月優惠及熱門促銷資訊</p>
						</header>
						<div class="row">
							<section class="6u 12u(narrower)">
								
									<div class="row 50%">
										<div class="6u 12u(mobile)">
											<input name="name" placeholder="姓名 Name" type="text" />
										</div>
										<div class="6u 12u(mobile)">
											<input name="email" placeholder="信箱 Email" type="text" />
										</div>
									</div>
									<div class="row 50%">
										<div class="12u">
											<textarea name="message" placeholder="想對我們說 Message"></textarea>
										</div>
									</div>
									<div class="row 50%">
										<div class="12u">
											<ul class="actions">
												<li><input type="submit" ID="BT_Subscribe" Value="訂閱"></li>
											</ul>
										</div>
									</div>
								
							</section>
							<section class="6u 12u(narrower)">
								<div class="row 0%">
									<ul class="divided icons 12u 12u(mobile)">
                                        <li class="icon fa-facebook"><a href="#"><span class="extra">facebook.com/</span>untitled</a></li>
										<li class="icon fa-instagram"><a href="#"><span class="extra">instagram.com/</span>untitled</a></li>
									</ul>
								</div>
							</section>
						</div>
					</div>
					<div id="copyright" class="container">
						<ul class="menu">
							<li>&copy; Untitled. All rights reserved.</li>
						</ul>
					</div>
				</div>

        <script type="text/javascript">
	        window.onload = function(){
	        	$(function(){
	        		$("select").change(function(){
	        			var brand = document.getElementById("Brand").value;
	        			var type = document.getElementById("Type").value;
	        			document.location = "PDlist.jsp?brand="+brand+"&type="+type;
	        		})
	        	})
	        }
        </script>
		<!-- Scripts -->

			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>