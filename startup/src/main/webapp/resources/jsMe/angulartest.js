var bookLibraryApp = angular.module('bookLibraryApp',[]);

bookLibraryApp.controller('BookLibraryController', function($scope, $http){    
    $scope.addBook = function(){
    	
        var newBook = {       		
        	          "articleiD":1,
        	          "token":"992500110@qq.com",
        	           "iD":5
                      };
        $http.post('http://localhost:8080/startup/learn/article', newBook).success(function(data, status, headers, config) {
            // this callback will be called asynchronously
            // when the response is available
        	console.log(data);
          }).error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });
    }
});