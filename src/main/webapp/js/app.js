var jsApp = angular.module('jsApp', ['ui.bootstrap', 'ngRoute', 'jsApp.controllers', 'jsApp.services']).config(
    ['$routeProvider', '$locationProvider', '$httpProvider', function ($routeProvider, $locationProvider, $httpProvider) {

        $routeProvider.when('/create', {
            templateUrl: 'partials/create.html',
            controller: 'CompanyController'
        });

        $routeProvider.when('/edit/:id?', {
            templateUrl: 'partials/create.html',
            controller: 'CompanyController'
        });

        $routeProvider.when('/list', {
            templateUrl: 'partials/list.html',
            controller: 'CompanyListController'
        });

        $routeProvider.otherwise({redirectTo: '/list'});

        $locationProvider.hashPrefix('!');

    }]
)

jsApp.run(function ($rootScope, $http, $location) {
    $("body").show();
});
