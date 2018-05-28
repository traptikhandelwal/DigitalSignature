


var app=angular.module("histApp",['angularModalService']);


app.controller('histController', ["$http","$scope", function ($http,$scope,chartService,ModalService) 
                                  {

	   console.log("inside the function");
	   
	   
		  var histogram=function()
		  {

			  	var histArray=[];
			  setInterval(function () 
					  {
				  

	              $http({
	                  mode:'cors',
	                  method:'GET',
	                  url: '/VRAN/getHistogramData',
	                  headers: { 'Content-Type':'application/json' },
	                  cache: false,
	                  }).success(function(data) 
	                { 
	                	  /*var x= data.prachPreambleCountCell1;
	                	  histArray.push(x);
	                	  console.log("new value: "+x);
	                	  */
	                	  
	                	  console.log("data from backend: "+data);
	                	  histChart.series[0].setData(processHistogram(data,10),true);
	                	  
	                      
	                } ).error(function(data) 
	          {
	            
	          });
	            
	             
	             // console.log("new data: "+histArray);
					 
			  },1000); 
		  }
	   
		  
		  function processHistogram(data, step) {
		      var histo = {},
		          x,
		          i,
		          arr = [];

		      // Group down
		      for (i = 0; i < data.length; i++) {
		          x = Math.floor(data[i]/ step) * step;
		          if (!histo[x]) {
		              histo[x] = 0;
		          }
		          histo[x]++;
		      }

		      // Make the histo group into an array
		      for (x in histo) {
		          if (histo.hasOwnProperty((x))) {
		              arr.push([parseFloat(x), histo[x]]);
		          }
		      }

		      // Finally, sort the array
		      arr.sort(function (a, b) {
		          return a[0] - b[0];
		      });

		      console.log("array for histogram: "+arr);
		      return arr;
		  }
	   histChart=Highcharts.chart("div0", {
		    chart: {
		        zoomType:'x',
		    	type: 'column',
		        animation: Highcharts.svg,
		       
		    },
		    title: {
		        text: ''
		    },
		    xAxis: {
		        gridLineWidth: 1,
		        tickInterval: 100,
		        maxPadding :1.5,
             max:1000
		    }, credits: {
		      enabled: false
		    },
		    yAxis: [
		            {
		            	 max: 50,
		            	 tickInterval: 10,
		        title: {
		            text: 'Frequency'
		        		}
		    }],
		    series: [{
		        name: '',
		        id:'histData',
		        showInLegend: false,  
		        type: 'column',
		        data: histogram(),
		        pointPadding: 0,
		        groupPadding: 0,
		        pointPlacement: 'between'
		    }]
		});
	   
	  

   	 
   var chart=Highcharts.chart("div1",{
			 chart: {
				
			        type: 'scatter',
			        zoomType: 'xy',
			        events: {
			            load: function () 
			            {  maxSamples = 60,
	                         count = 0;
			            	setInterval(function ()
			            			{
				                        $http({
				                            mode:'cors',
				                            method:'GET',
				                            url: '/VRAN/getWidgetData',
				                            headers: { 'Content-Type':'application/json' },
				                            cache: false,
				                            }).success(function(data) 
					                      { 
		                      
					                            console.log(data);
					                           // $scope.myData=data;
					                                  var x= data.totalPrbDlMax;
					                                  console.log(x);
					                                  
					                             
					                                   chart.series[0].addPoint([x] , true
					   	                                        , (++count >= maxSamples));
		                                  } ).error(function(data) 
		                            {
	                                  
	                                });
	                                  
	                                      }, 1000);
	                         }
			        }

			    },
			    
		        title: {
		            text: '',
		            style: {
		                display: 'none'
		            }
		        },
		       

			    xAxis: {
			        title: {
			           
			            text: 'x-axis'
			        },
			       
			    },
			    yAxis: {
			        title: {
			            text: 'TotalPrbDlMin'
			        }
			    },
			    legend: {
		            enabled: false
		        },
		        
			    credits: {
			      enabled: false
			    },
			   
			    plotOptions: {
			        scatter: {
			            marker: {
			                radius:4,
			                states: {
			                    hover: {
			                        enabled: true,
			                        lineColor: 'rgb(100,100,100)'
			                    }
			                }
			            },
			            states: {
			                hover: {
			                    marker: {
			                        enabled: false
			                    }
			                }
			            },
			            tooltip: {
			                headerFormat: '<b>{series.name}</b><br>',
			                pointFormat: '{point.x} sec, {point.y} PrachPreambleCountCell2'
			            }
			        }
			    },
			    series: [{
			        name: 'coordinate value',
			        color: 'rgba(223, 83, 83, .5)',
			        data:[]
			      }]
			});
   

   
   var scatterChart=Highcharts.chart("div2", {
	        chart: {
	            zoomType: 'x',
	            type: 'spline',
	            animation: Highcharts.svg, // don't animate in old IE
	            marginRight: 10,
	            events: {
	                load: function () 
	                {
	                	 maxSamples = 60,
                         count = 0;
	                	setInterval(function () 
   		              {
   	                        $http({
   	                            mode:'cors',
   	                            method:'GET',
   	                            url: '/VRAN/getWidgetData',
   	                            headers: { 'Content-Type':'application/json' },
   	                            cache: false,
   	                            }).success(function(data) { 
   	                      
   	                            console.log(data);
   	                           // $scope.myData=data;
   	                         var x = (new Date()).getTime(), // current time
                             y =data.totalPrbDlMin;
   	                                //  var x= data.prachPreambleCountCell1;
   	                                  console.log(y);
   	                                  
   	                            //data1.push(x);
   	                            //console.log("data1 is"+data1);  
   	                  
   	                                 // var series = this.series[0];
   	                                    
   	                                   scatterChart.series[0].addPoint([x,y] , true
   	                                        , (++count >= maxSamples));
   	                                  } ).error(function(data) {
   	                                  // called asynchronously if an error occurs
   	                                  // or server returns response with an error status.
   	                                });
   	                                  
                                     }, 1000);
                        }
	            }
	        },
	        
	        title: {
	            text: '',
	            style: {
	                display: 'none'
	            }
	        },
	       
	        xAxis: {
	            type: 'datetime',
	          
	        },
	        yAxis: {
	            title: {
	                text: 'TotalPrbDlMax',
	                min: 0
	            
	            },
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        legend: {
	            enabled: false
	        },
	        
	        plotOptions: {
	            line: {
	                marker: {
	                    enabled:true,
	                    radius:3
	                }
	            }
	        },
		    credits: {
		      enabled: false
		    },
		    
		    tooltip: {
	            formatter: function () {
	                return '<b>' + this.series.name + '</b><br/>' +
	                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
	                    Highcharts.numberFormat(this.y, 2);
	            }
	        },

	        series: [{
	            type: 'line',
	            name: 'Latency',
	            data: (function () {
	                // generate an array of random data
	                var d = [],
	                    time = (new Date()).getTime(),
	                    i;
	                
	                
	     		              
	     	                        $http({
	     	                            mode:'cors',
	     	                            method:'GET',
	     	                            url: '/VRAN/getWidgetData',
	     	                            headers: { 'Content-Type':'application/json' },
	     	                            cache: false,
	     	                            }).success(function(data) 
	     	                            		{ 
	     	                            	console.log("api called");
	     	                            	d.push({
	     	       	                        x: time,
	     	       	                        y: 100
	     	       	                    });
	     	                            	
	     	                            		});
	                

	               
	                return d;
	            }()),
	        }]
	    });
  	
                 }]);





/////////////////////////END OF CONTROLLER/////////////////////////         	            
  
