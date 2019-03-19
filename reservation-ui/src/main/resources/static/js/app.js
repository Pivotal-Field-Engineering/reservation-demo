angular.module('reservation-system', ['ngRoute']).config(function ($routeProvider) {

    $routeProvider.when('/', {
    	templateUrl : 'viewreservation.html',
    	controller: 'viewreservation'
    }).when('/savereservation', {
		templateUrl : 'savereservation.html',
		controller : 'savereservation'
	}).when('/viewreservation', {
		templateUrl : 'viewreservation.html',
		controller : 'viewreservation'
	}).otherwise('/');

})
.controller('viewreservation', function ($scope, $http) {

    $http.get('reservations').success(function (data) {
        $scope.res = data;
    });

})
.controller('savereservation', ['$scope', '$http', function($scope, $http) {
    $scope.submit = function() {
    	var config = {
                headers: {
                    "Content-Type": "application/json"
                }
            }    	
    	var data = {
    	        name: "Hello World",
    	        status: "confirmed"
    	            }
    	
    	$http.post('http://localhost:8080/reservations',data,config);
    };
  }]);