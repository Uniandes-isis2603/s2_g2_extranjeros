/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("viviendasModule");
    mod.constant("viviendaContext", "api/viviendas");
    mod.controller('viviendaCtrl', ['$scope', '$http', 'viviendaContext',
        function ($scope, $http, viviendaContext) {
            $scope.data2={};
            //Consulto los servicios de la vivienda a facturar.
            $http.get("api/servicios").then(function (response) {
                $scope.data2= response.data;
            });
            $http.get(viviendaContext
                    ).then(function (response) {
                $scope.viviendasRecords = response.data;
            });
           $scope.filtro1="";
           $scope.filtro2="";
           $scope.filtro3="";
           $scope.filtro4="";
           $scope.cambiarFiltro1=function(){
               filtro1="1";
               $scope.filtroNuevo();
           };
           $scope.cambiarFiltro3=function(temp){
              console.log(temp);
              if(filtro3==="-")
                  filtro3=temp;
              else
                  filtro3=filtro3+";"+temp;
           };
           $scope.cambiarFiltro2=function(temp){
               filtro2=""+temp;
           };
           $scope.cambiarFiltro4=function(temp)
           {
               filtro4=""+temp;
           };
           $scope.filtroNuevo = function () {
                $http.get(viviendaContext+'?filter1:'+$scope.filtro1+',2:'+$scope.filtro2+',3:'+$scope.filtro3+',4:'+$scope.filtro4).then(function (response) {
                    $scope.viviendasRecords = response.data;
                });
            } 
        }
    ]);
}
)(window.angular);


