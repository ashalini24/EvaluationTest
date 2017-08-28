var app = angular.module("myApp", [ 'ngResource' ]);
app.controller("invoiceController", function($scope, $http) {

var urlBase = "";
$scope.toggle=true;
$scope.selection = [];
$scope.statuses=['ACTIVE','COMPLETED'];
$scope.priorities=['HIGH','LOW','MEDIUM'];
$http.defaults.headers.post["Content-Type"] = "application/json";

 //add a new task

    $scope.addInvoice = function addTask() {

        if($scope.taskName=="" || $scope.taskDesc=="" || $scope.taskPriority == "" || $scope.taskStatus == ""){

            alert("Insufficient Data! Please provide values for task name, description, priortiy and status");

        }

        else{

            $http.post(urlBase + '/tasks', {

                invoiceName: $scope.name,
                invoiceEmail: $scope.email,
                invoiceDueDate: $scope.duedate

            }).

            success(function(data, status, headers) {
                alert("Task added");
                var newTaskUri = headers()["location"];
                console.log("Might be good to GET " + newTaskUri + " and append the task.");
                findAllTasks();

            });

        }

    };
}



