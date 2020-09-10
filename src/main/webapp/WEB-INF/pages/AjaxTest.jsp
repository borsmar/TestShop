<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AjaxTest</title>
    <link href="${pageContext.request.contextPath}/resources/css/my.css" rel="stylesheet">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/mdb-favicon.ico" type="image/x-icon">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mdb.min.css">
    <!-- Your custom styles (optional) -->

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/getCategories.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/getItemsByCategory.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/deleteItem.js"></script>

    <script type="text/javascript">
    $(document).ready(getItemsByCategory(1));
    </script>




    <script type="text/javascript">
        function doAjax() {

            var inputText = $("#input_str").val();

            $.ajax({
                url : 'categories/'+inputText,
                type: 'GET',
                dataType: 'json',
                contentType: 'application/json',
                mimeType: 'application/json',
                success: function (data) {

                    var result = '"'+data.id+'", '+data.name+' received by ajax request';

                    $("#result_text").text(result);

                    alert('success!');


                }
            });
        }
    </script>

    <meta name="_csrf" content="${_csrf.token}"/>


</head>
<body>



<h3>Enter text:</h3>
<input id="input_str" type="text">
<input type="button" value="Get information" onclick="doAjax()">
<p id="result_text"></p>

<select id="cat" onchange="getItemsByCategory(this.value)" >
</select>

<div id="tableContainer" class="mt-5"></div>




</body>



</html>
