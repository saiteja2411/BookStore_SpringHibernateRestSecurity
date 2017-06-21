<%-- 
    Document   : index
    Created on : May 16, 2017, 2:48:27 PM
    Author     : Saiteja
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
        <script >
            var app = angular.module("app", []);

            app.controller("mycontroller", function ($scope, $http,$location) {

                $scope.submit = function () {
                    var title = $scope.title;
                    var price = $scope.price;
                    console.log(title);
                    $http({
                        url: "http://localhost:8084/BookStoreSpringMvcHibSecurity/books?title=" + title + "&" + "price=" + price + "",
                        method: "GET"
                    }).success(function(data){
                        console.log("succes " +data);
                        $scope.dataa=data;
                        //$location.path("WEB-INF/views/welcome.jsp");
                    });
                };
            });
        </script>
    </head>
    <body ng-app="app">
        <div ng-controller="mycontroller">
            <h1>WELCOME TO BOOK STORE</h1>
            <form action="books" method="get">
            <input type="text" ng-model="title" name="title" placeholder="Book title">
            <input type="text" ng-model="price" name="price" placeholder="Book price">
            <input type="submit" value="submit"/>
        </div>

    </body>
</html>
