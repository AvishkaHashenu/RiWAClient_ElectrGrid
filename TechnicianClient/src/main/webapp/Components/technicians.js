$(document).ready(function() {
    if ($('#alertSuccess').text().trim() == "") {
        $('#alertSuccess').hide();
    }

    $('#alertError').hide();
})

// SAVE
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
	$.ajax(
	{
		url : "TechniciansAPI",
		type : type,
		data : $("#formTechnician").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			onItemSaveComplete(response.responseText, status);
		}
	});
});

// UPDATE
//to identify the update button we didn't use an id we used a class
$(document).on("click", ".btnUpdate", function(event) 
{ 
    $("#hidItemIDSave").val($(this).data("itemid"));
    $("#name").val((decodeURI($(this).closest("tr").find('td:eq(1)').text())));
	$("#address").val((decodeURI($(this).closest("tr").find('td:eq(2)').text())));
	$("#email").val((decodeURI($(this).closest("tr").find('td:eq(3)').text())));
	$("#phone").val($(this).closest("tr").find('td:eq(4)').text());
	$("#type").val($(this).closest("tr").find('td:eq(5)').text());
	$("#salary").val($(this).closest("tr").find('td:eq(6)').text());
	$("#hourlywage").val($(this).closest("tr").find('td:eq(7)').text());
});


//DELETE
$(document).on("click", ".btnRemove", function(event)
{
	$.ajax(
	{
		url : "TechniciansAPI",
		type : "DELETE",
		data : "TechnicianID=" + $(this).data("itemid"),
		dataType : "text",
		complete : function(response, status)
		{
			onItemDeleteComplete(response.responseText, status);
		}
	});
});


function onItemSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} 
		else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error")
	{
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	} 
	$("#hidItemIDSave").val("");
	$("#formTechnician")[0].reset();
}


function onItemDeleteComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} 
		else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} 
	else if (status == "error")
	{
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} 
	else
	{
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}


// CLIENT-MODEL================================================================ 

function validateItemForm() { 
// CODE
if ($("#name").val().trim() == "")
{
return "Insert name";
}

if ($("#username").val().trim() == "")
{
return "Insert User Name";
}

if ($("#address").val().trim() == "")
{
return "Insert address";
}

if ($("#email").val().trim() == "")
{
return "Insert email";
}

if ($("#phone").val().trim() == "")
{
return "Insert phone number";
}

if ($("#type").val().trim() == "")
{
return "Insert type";
}

if ($("#salary").val().trim() == "")
{
return "salary";
}

if ($("#hourlywage").val().trim() == "")
{
return "Insert hourlywage";
}
    
    
     
    return true; 
} 
 