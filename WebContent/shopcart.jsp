<%@ page  import="java.util.*, java.sql.*,DAO.*,model.*,discountStrategy.*,shoppingCartCommand.* " language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
                                	
                                	<table style="border-top:3px #FFD382 solid;border-bottom:3px #FFD382 solid;" >
                                		<thead>
                                			<tr>
                                				<th>選擇</th>
	                                			<th>商品名稱</th>
	                                			<th>單價</th>
	                                			<th>數量</th>
	                                			<th>小計</th>
                                			</tr>
                                		</thead>
									<% 
										ArrayList<cart> cartlists = cartDAO.getCartByUser_ID(Integer.parseInt(String.valueOf(session.getAttribute("User_ID")))); 
										int index = 0;
										
										for (cart cartlist : cartlists){
											index++;
											String qid = String.valueOf(index);
											out.print("<tr align='center' valign='middle'><td>"
											+"<a href='deletecart?Shop_ID="+cartlist.getShop_ID()+" '><input type='button' value='刪除'></a> "
											+"</td><td>"
											+ productsDAO.getPD_Infor(String.valueOf(cartlist.getPD_ID()), "PD_Name") 
											+"</td><td>"
											+ productsDAO.getPD_Infor(String.valueOf(cartlist.getPD_ID()), "PD_Price") 
											+"</td><td><select id='"+index+"' name='"+index+"' size='1' onchange='UpdateQuantity("+cartlist.getShop_ID()+","+qid+")'>"+
											cartDAO.getSelectCase(cartlist.getPD_ID(),cartlist.getShop_Quantity())
											+"</td><td>"
											+ cartDAO.getSumPrice(cartlist)
											+"</td></tr>");
										}
									%>
									</table>
                                    <table class="style1">
                                        
                                        <tr>
                                            <td style="text-align: right">
                                            	總計：<%out.print(""+cartDAO.getTotalPrice(cartlists)+""); %>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="text-align: right">
                                            	折扣後：<% determine n = new determine(Integer.parseInt(String.valueOf(session.getAttribute("User_ID"))));
                                            			int discountP = n.getAfterDiscountPrice();
                                            			out.println(discountP);
                                            			%>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="text-align: right">
                                            	<a href="useRestores"><input type="button" ID="restoreID" Value="回上一步" ></a>
                                            	&nbsp;&nbsp;&nbsp;
                                            	<a href="PDlist.jsp"><input type="submit" ID="BT_shoplist_toBuy" Value="繼續購物" ></a>
                                            	&nbsp;&nbsp;&nbsp;
                                            	<a href="Orderlist.jsp"><input type="submit" ID="BT_shoplist_toPay" Value="完成訂單" ></a>
                                            	&nbsp;&nbsp;&nbsp;
                                            	
                                            </td>
                                        </tr>
                                    </table>
                
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
	        
	        <%--document.getElementById("#restoreID").addEventListener(‘onclick’, function(){
	        	<%restore.useRestore();%>
	        	location.replace(shopcart.jsp);
	        }, false);--%>
	        <%--
	        document.onkeydown = function(e) {
	            var keyCode = e.keyCode || e.which || e.charCode;
	            var ctrlKey = e.ctrlKey || e.metaKey;
	            if(ctrlKey && keyCode == 90) {
	            	restore.useRestore();
	            }
	            e.preventDefault();
	            return false;
	        }--%>
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