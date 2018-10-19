<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:100,300,400,900,700,500,300,100);
*{
  margin: 0;
  box-sizing: border-box;

}
body{
  background: #E0E0E0;
  font-family: 'Roboto', sans-serif;
  background-image: url('');
  background-repeat: repeat-y;
  background-size: 100%;
}
::selection {background: #f31544; color: #FFF;}
::moz-selection {background: #f31544; color: #FFF;}
h1{
  font-size: 1.5em;
  color: #222;
}
h2{font-size: .9em;}
h3{
  font-size: 1.2em;
  font-weight: 300;
  line-height: 2em;
}
p{
  font-size: .7em;
  color: #666;
  line-height: 1.2em;
}

#invoiceholder{
  width:100%;
  hieght: 100%;
  padding-top: 50px;
}
#headerimage{
  z-index:-1;
  position:relative;
  top: -50px;
  height: 350px;
 /* background-image: url('http://michaeltruong.ca/images/invoicebg.jpg');*/

  -webkit-box-shadow:inset 0 2px 4px rgba(0,0,0,.15), inset 0 -2px 4px rgba(0,0,0,.15);
	-moz-box-shadow:inset 0 2px 4px rgba(0,0,0,.15), inset 0 -2px 4px rgba(0,0,0,.15);
	box-shadow:inset 0 2px 4px rgba(0,0,0,.15), inset 0 -2px 4px rgba(0,0,0,.15);
  overflow:hidden;
  background-attachment: fixed;
  background-size: 1920px 80%;
  background-position: 50% -90%;
}
#invoice{
  position: relative;
  top: -290px;
  margin: 0 auto;
  width: 700px;
  background: #FFF;
}

[id*='invoice-']{ /* Targets all id with 'col-' */
  border-bottom: 1px solid #EEE;
  padding: 30px;
}

#invoice-top{min-height: 120px;}
#invoice-mid{min-height: 120px;}
#invoice-bot{ min-height: 250px;}
.clientlogo{
  float: left;
	height: 60px;
	width: 60px;
	/*background: url(http://michaeltruong.ca/images/client.jpg) no-repeat;*/
	background-size: 60px 60px;
  border-radius: 50px;
}
.info{
  display: block;
  float:left;
  margin-left: 20px;
}
.title{
  float: right;
}
.title p{text-align: right;}
#project{margin-left: 52%;}
.invtable{
  width: 100%;
  border-collapse: collapse;
}
td{
  padding: 5px 0 5px 15px;
  border: 1px solid #EEE
}
.tabletitle{
  padding: 5px;
  background: #EEE;
}
.service{border: 1px solid #EEE;}
.item{width: 50%;}
.itemtext{font-size: .9em;}

#legalcopy{
  margin-top: 30px;
}
form{
  float:right;
  margin-top: 30px;
  text-align: right;
}


.effect2
{
  position: relative;
}
.effect2:before, .effect2:after
{
  z-index: -1;
  position: absolute;
  content: "";
  bottom: 15px;
  left: 10px;
  width: 50%;
  top: 80%;
  max-width:300px;
  background: #777;
  -webkit-box-shadow: 0 15px 10px #777;
  -moz-box-shadow: 0 15px 10px #777;
  box-shadow: 0 15px 10px #777;
  -webkit-transform: rotate(-3deg);
  -moz-transform: rotate(-3deg);
  -o-transform: rotate(-3deg);
  -ms-transform: rotate(-3deg);
  transform: rotate(-3deg);
}
.effect2:after
{
  -webkit-transform: rotate(3deg);
  -moz-transform: rotate(3deg);
  -o-transform: rotate(3deg);
  -ms-transform: rotate(3deg);
  transform: rotate(3deg);
  right: 10px;
  left: auto;
}



.legal{
  width:70%;
}


</style>
</head>
<body>
<jsp:include page="base.jsp" />
<div id="invoiceholder">

  <div id="headerimage"></div>
  <div id="invoice" class="effect2">
    
    <div id="invoice-top">
      <div class="info">
        <h2>Getwin Electro Pnematic Coorporation</h2>
        <p> getwin@gmail.com </br>
            82226-66300
        </p>
      </div><!--End Info-->
      <div class="title">
      <c:forEach items="${allinv}" var="inv">
        <h1>Invoice # ${inv.getInvid()}</h1>
        <p>Issued: ${inv.getDog()}</br>
        </p>
      </c:forEach>
      </div><!--End Title-->
    </div><!--End InvoiceTop-->


    
    <div id="invoice-mid">
      

      <div class="info">
      <c:forEach items="${allusr}" var="user">
        <h2>${user.getName()}</h2>
        <p>${user.getEmail()}</br>
           ${user.getPhno()}</br>
      </p>
      </c:forEach>
      </div>

      <div id="project">
        <h2>Invoice Description</h2>
        <c:forEach items="${allusr}" var="user">
        <p>This invoice is issued by Getwin Electro Pneumatic corporation to ${user.getName()} and ${user.getName()} is entitled to the same.</p>
        </c:forEach>
      </div>   

    </div><!--End Invoice Mid-->
    
    <div id="invoice-bot">
      
      <div id="table">
        <table class="invtable">
          <tr class="tabletitle">
            <td class="item"><h2>Product Id</h2></td>
            <td class="Hours"><h2>Quantity</h2></td>
            <td class="subtotal"><h2>Sub-total</h2></td>
          </tr>
          <c:forEach items="${allinvent}" var="invent">
          <tr class="service">
            <td class="tableitem"><p class="itemtext">${invent.getPid()}</p></td>
            <td class="tableitem"><p class="itemtext">${invent.getQinentry()}</p></td>
            <td class="tableitem"><p class="itemtext">${invent.getPrice()} Rs.</p></td>
          </tr>
          </c:forEach>
            
          <tr class="tabletitle">
            <td></td>
            <td class="Rate"><h2>Total</h2></td>
            <c:forEach items="${allinv}" var="inv">
            <td class="payment"><h2>${inv.getAmount()}</h2></td>
            </c:forEach>
          </tr>
          
        </table>
      </div><!--End Table-->
      
    </div><!--End InvoiceBot-->
  </div><!--End Invoice-->
</div>
<h3>Congrats! Your order has been placed!</h3>
</body>
</html>