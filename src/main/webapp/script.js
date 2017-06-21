var app = angular.module("app",[]);

app.controller("mycontroller",function($scope,$http){
    
    $scope.submit=function(){
        var title=$scope.title;
        var price=$scope.price;
        console.log(title);
        $http({
            url:"http://localhost:8084/BookStoreSpringMvcHibSecurity/books?title="+title+"&"+"price="+price+"",
            method:"GET"
        });
    };
});