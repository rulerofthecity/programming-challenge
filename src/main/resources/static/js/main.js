/**
 * 
 */

var onLoadData=	function onLoadData(){
		$.ajax({
	        type: "GET",
	        contentType: "application/json",
	        url: "/getAllBookingDetails",
	        cache: false,
	        timeout: 600000,
	        success: function (data) {
	        	
	        	var len = data.length;
	        	var txt = "";
	        	if(len > 0){
	        		
//	        		$("#bookings").innerHTML = "";
	                document.getElementById("bookings").innerHTML = ""; 

	        		txt += "<table>";
	        		txt += "<th>					<td>Driver name</td>					<td>Customer name</td>			<td>Status</td>				</th>";
	        		
	        		for(var i =0; i<len; i++){
	        			txt += "<tr><td>" + data[i].driverName + "</td><td>" + data[i].customerName + "</td><td>" + data[i].status + "</td></tr>";
	        		}
	        		txt += "</table>";
	        	}
	        	
	        	if(txt != ""){
	        		$("#bookings").append(txt);
	        	}
	            console.log("SUCCESS : ", data);
	        },
	        error: function (e) {
	            var json = "<h4>Ajax Response for booking details</h4><pre>"
	                + e.responseText + "</pre>";
	            $('#error').html(json);

	            console.log("ERROR : ", e);

	        }
	    });
	}

$(document).ready(function () {

	onLoadData();
	
    $("#bookingForm").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var loc = {"latitude" : $("#latitude").val() ,
    		"longitude": $("#longitude").val()}
    var booking = {"customerName": $("#name").val(),
    		"location": loc
    };
    

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/bookCab",
        data: JSON.stringify(booking),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html("Booking done successfully!");
            
            if(data === true){
            	onLoadData();
            }
            
            console.log("SUCCESS : ", data);

        },
        error: function (e) {
            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html("Booking Failed :-(");

            console.log("ERROR : ", e);

        }
    });

}