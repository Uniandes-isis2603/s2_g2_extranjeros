(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
       
        // Internal modules dependencies       
        'citiesModule',
        'arrendatarioModule',
        'tarjetaModule',
        'eventoModule',
        'facturaModule',
        'servicioModule',
        'viviendasModule'
        'cuentaBancariaModule'
        

    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);

