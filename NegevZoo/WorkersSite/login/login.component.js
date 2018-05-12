﻿app.controller('loginCtrl', ['$cookies', '$scope', '$state', 'usersService', 'utilitiesService', 
    function ($cookies, $scope, $state, usersService, utilitiesService) {

        var sessionCookie = $cookies.get('session-id');

        if (sessionCookie != null && sessionCookie != undefined) {
            $state.go('mainMenu');
        }

        $scope.login = function (username, password) {
            $scope.loginQuery = usersService.login(username, password).then(
                function (response) {
                        $state.go('mainMenu');
                },
                function () {
                    utilitiesService.utilities.alert("שם משתמש או סיסמא שגויים");
                });
        }
}]);