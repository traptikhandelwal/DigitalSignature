
var app=angular.module("myApp", ['ngRoute']);




app.controller('myController', function($scope, myFactory) {
$scope.fullName = function() {
       alert("hi");
    };

    $scope.year = 2018;
	$scope.make = "TATA";
	$scope.model = "Hexa";
	$scope.mileage = 8800;

    $scope.phone = 1234567890;
	$scope.email = "abc@gmail.com";

	$scope.firstName = "abc";
	$scope.lastName = "xyz";
	$scope.city = "Gurgaon";
	$scope.state = "Haryana";
	$scope.pincode = "122009";

	$scope.setNameusingFactory = function(){
		myFactory.setName($scope.firstName);
	};
});
app.factory("myFactory", function(){

	var obj = {};
	obj.name = '';
	obj.setName = function(firstName){
//	alert('factory');
	obj.name = firstName; 
};
	return obj;
});

 
app.controller("myCtrl",function($scope){

	
	$scope.items=[
	{
	"id":"1",
	"ServiceHeader":"Service Description",
	"price":"225",
	"Services":"Change Engine Oil,Replace oil filter,Replace air filter,Replace fuel filter,Replace cabin filter,Replace spark plugs,Tune the Engine",
	"url":"../images/pic1.jpg"
	},{
	"id":"2",
	"ServiceHeader":"Service Description",
	"price":"175",
	"Services":"Replace oil filter,Replace air filter,Replace fuel filter,Replace cabin filter,Replace spark plugs,Tune the Engine",
	"url":"../images/pic2.jpg"
	},{
	"id":"3",
	"ServiceHeader":"Service Description",
	"price":"100",
	"Services":"Replace air filter,Replace fuel filter,Replace cabin filter,Replace spark plugs,Tune the Engine",
	"url":"../images/pic3.jpg"

	}
	];
	console.log($scope.items);
	window.onload=function  () {
		window.localStorage.clear();
	}
$scope.addToCart=function(item){
	console.log(item);
//var arr=[];
//$scope.buttonSelected=true;



var itemsList={
	"id":item.id,
	"ServiceHeader":item.ServiceHeader,
	"price":item.price,
	"Services":item.Services,
	"url":item.url
}
//$scope.cartItemsArray=[];
$scope.itemsLength="";
if(window.localStorage.getItem('itemsList') === null){

var addITem = [];
    addITem.push(itemsList);
    window.localStorage.setItem('itemsList', JSON.stringify(addITem));
	$scope.cartItemsArray=addITem;
	//console.log(cartArr);
	//console.log($scope.cartItemsArray);
	$scope.itemsLength=addITem.length;

}else{
	var addITem = JSON.parse(window.localStorage.getItem('itemsList'));
	/*for(var i=0;addITem.length>i;i++){
		console.log("id"+addITem[i].id);

	}*/
	var cartItems=window.localStorage.getItem('itemsList');
	console.log(addITem);
	console.log(item);
	for(var i=0;i<addITem.length;i++){
		if(addITem[i].id===item.id){
			//$scope.buttonSelected=true;
		}
		
	}
	

    addITem.push(itemsList);
    window.localStorage.setItem('itemsList', JSON.stringify(addITem));
$scope.cartItemsArray=addITem;
console.log("cartItemsArray"+$scope.cartItemsArray);
$scope.itemsLength=addITem.length;
}
console.log($scope.cartItemsArray);
 }


$scope.deleteItem=function(item,index){
//var addITem = JSON.parse(window.localStorage.getItem('itemsList'));
console.log("deletedItem"+item);
$scope.cartItemsArray.splice(index,1);
window.localStorage.setItem('itemsList', JSON.stringify($scope.cartItemsArray));


}

 $scope.remoteItem=function(item){
 		var fetchItem = JSON.parse(window.localStorage.getItem('itemsList'));
 		console.log("existing item"+fetchItem);

 }
});
app.config(function($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl : 'smart.html'
	
    })
     .when('/smart', {
        templateUrl : 'smart.html'
	
    })
     .when('/smart1', {
        templateUrl : 'smart1.html'
	
    })
     .when('/smart2', {
        templateUrl : 'smart2.html'
	
    })
     .when('/smart3', {
        templateUrl : 'smart3.html'
	
    })
     .when('/manual', {
        templateUrl : 'manual.html'
	
    })
     .when('/detailsManual', {
        templateUrl : 'detailsManual.html'
	
    })
     .when('/vehicleInfo', {
        templateUrl : 'vehicleInfo.html'
	
    })

	.when('/services', {
        templateUrl : 'services.html'
		})
	.when('/servicesrecommended', {
        templateUrl : 'servicesrecommended.html'
		})

    .when('/cart', {
        templateUrl : 'cart.html'
		})
    
});

