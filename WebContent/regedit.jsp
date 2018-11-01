<%@ page import="java.util.*, java.sql.*,DAO.*,model.*,discountStrategy.*,shoppingCartCommand.* " language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html lang="zh-Hans-TW">
	<head>
		<title>SampleShop for Learning Coding</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" /> 
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="no-sidebar">
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
									<li><a href="PDlist.jsp">精選活動</a></li>
								</ul>
							</nav>
					</div>
                </div>

			<!-- Main -->
				<div class="wrapper">
					<div class="container" id="main">
						<!-- Content -->
						
                            <div class="row">
                                <section class="3u 12u(narrower)"></section>
                                <section class="6u 12u(narrower)">
                               	<form action="register">
                               		<p>帳號<input type="text" name="TB_User_Acc" id="TB_User_Acc" placeholder="請輸入帳號" required></p>
                               		<p>密碼<input type="password" name="TB_User_Pwd" id="TB_User_Pwd" placeholder="請輸入密碼" required></p>
                               		<p>重複密碼<input type="password" name="TB_User_rePwd" id="TB_User_rePwd" placeholder="請再次輸入密碼" required></p>
                               		<p>姓名<input type="text" name="TB_User_Name" id="TB_User_Name" placeholder="請輸入姓名" required></p>
                               		<p>電子信箱<input type="email" name="TB_User_Email" id="TB_User_Email" placeholder="請輸入電子信箱" required></p>
                               		<p>地址<input type="text" name="TB_User_Address" id="TB_User_Address" placeholder="請輸入地址" required></p>
                               		<br>
                               		<input type="submit" value="註冊">
                               	</form>
                
                                </section>
                                <section class="3u 12u(narrower)"></section>
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

		</div>
        <script type="text/javascript">
	        function UpdateQuantity(sid,id){
	        	var qid = '#'+id;
	        	var selected = $(qid).val();
	        	document.location = "changeCPQ?Shop_ID="+sid+"&P_Quantity="+selected;
	        }
	        
        </script>
  
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
            <script src="assets/js/scripts.js"></script>
            <script src="assets/js/bootstrap.min.js"></script>
	</body>
</html>