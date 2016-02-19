var jsAppControllers = angular.module('jsApp.controllers', []);

jsAppControllers.controller('CompanyController', [
    '$scope', '$routeParams', '$location', 'CompanyDetailService', function CompanyController($scope, $routeParams, $location, CompanyDetailService) {
        companyId = $routeParams.id;
        $scope.newOwners = [];

        if (!companyId) {
            $scope.company = new CompanyDetailService();
        } else {
            $scope.company = CompanyDetailService.get({
                id : companyId
            });
        }

        $scope.addOwner = function() {
            $scope.newOwners.push('');
        }

        $scope.validate = function() {
            var isValid = $scope.company.name != "";
            isValid = isValid && $scope.company.address != "";
            isValid = isValid && $scope.company.city != "";
            isValid = isValid && $scope.company.country != "";
            isValid = isValid && $scope.company.beneficialOwners && $scope.company.beneficialOwners.length > 0;
            return isValid;
        };

        $scope.save = function() {
            angular.forEach($scope.newOwners, function(value) {
                value = value.trim();
                if (value.length > 0) {
                    if (!$scope.company.beneficialOwners) {
                        $scope.company.beneficialOwners = [];
                    }
                    $scope.company.beneficialOwners.push(value);
                }
            });

            var ownersArr = [];
            angular.forEach($scope.company.beneficialOwners, function(value) {
                value = value.trim();
                if (value.length > 0) {
                    ownersArr.push(value);
                }
            });
            $scope.company.beneficialOwners = ownersArr;

            if ($scope.validate()) {
                $scope.company.$save(function() {
                    $location.path("/list");
                });
            } else {
                alert("Invalid input.")
            }
        };
    }
]);

jsAppControllers.controller('CompanyListController', [
    '$scope', '$location', 'CompanyListService',
    function CompanyListController($scope, $location, CompanyListService) {
        $scope.companies = CompanyListService.query();

        $scope.getCompanyDetails = function(id) {
            $location.path('edit/' + id);
        };
    }
]);


