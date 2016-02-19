var jsAppServices = angular.module('jsApp.services', ['ngResource']);

jsAppServices.factory('CompanyListService', function ($resource) {
    return $resource('rest/companies/');
});

jsAppServices.factory('CompanyDetailService', ['$resource', function ($resource) {
    return $resource('rest/companies/:id', {id: '@id'})
}]);
