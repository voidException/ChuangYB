var listcomment = angular.module('listcomment',[]);

listcomment.controller('ListCommentController', function($scope, $http){    
    $scope.listcomm = function(articleid){  	
        var datacomm = {       		
        	          "token":"992500110@qq.com",
        	           "iD":5,
        	           "articleiD":articleid,
        	           "page":1,
        	           "pageSize":6        	           
                      };
        $http.post('http://localhost:8080/startup/learn/article/commentsList', datacomm).success(function(data, status, headers, config) {
            // this callback will be called asynchronously
            // when the response is available        	
        	$scope.items=data.commentsVos;       	
        	console.log($scope.items);        	               	        	
          }).error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });
    }//listcomm()
    $scope.loadmoreclick=function(){
       	$scope.more="";//初始值为空
       	
    	//去localStorage里获取点击次数的值
    	//ajax加载数据，更新$scope.more的值，基于双向绑定，所以会更新视图。   	
    	 var datacomm = {       		
   	          "token":"992500110@qq.com",
   	           "iD":5,
   	           "articleiD":3,
   	           "page":1,
   	           "pageSize":10        	           
                 };
		 $http.post('http://localhost:8080/startup/learn/article/commentsList', datacomm).success(function(data, status, headers, config) {
		       // this callback will be called asynchronously
		       // when the response is available        	
		             $scope.more=data.commentsVos;       	
		             console.log($scope.more);        	               	        	
		     }).error(function(data, status, headers, config) {
		       // called asynchronously if an error occurs
		       // or server returns response with an error status.
		     });  	
        }
   
    
});



































