var list;
var form;
$(function() {
	list = $('#list');
	form = $('#form');
	$.ajaxSetup({
		contentType : "application/json"
	});
	refreshContactsList();
});
function showConfirmDialog(message, callback) {
	$("#dialogMessageText").html(message);
	$(function() {
		$("#dialog-message").dialog({
			modal : true,
			buttons : {
				"Delete Contact" : function() {
					$(this).dialog("close");
					callback();
				},
				Cancel : function() {
					$(this).dialog("close");
				}
			}
		});
	});
}
function showDialog(message, callback) {
	$("#dialogMessageText").html(message);
	$(function() {
		$("#dialog-message").dialog({
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
					callback();
				}
			}
		});
	});
}
function showDialogBlockDialog(message) {
	$("#dialogMessageTextLoading").html(message);
	$(function() {
		$("#dialog-loading").dialog({
			modal : true
		});
	});
}
function hideDialogBlockDialog() {
	$("#dialog-loading").dialog("close");

}
function previewFile(event) {
	var profileImage = document.getElementById('profileImage');
	profileImage.src = URL.createObjectURL(event.target.files[0]);
};
function cancelSave() {
	list.show();
	form.hide();
}
function refreshContactsList() {
	list.show();
	form.hide();
	showDialogBlockDialog("Loading Data from Server");
	$.getJSON("services/contact").done(function(data) {
		drawSearchResults(data);
	});

}

function loadDataToForm(varUrl) {
	list.hide();
	form.show();
	showDialogBlockDialog("Loading Data from Server");
	if (varUrl == 0) {
		document.getElementById('name').value = "";
		document.getElementById('company').value = "";
		document.getElementById('profileImage').src = "img/testProfile.jpg";
		document.getElementById('email').value = "";
		document.getElementById('birthdate').value = "";
		document.getElementById('personalPhoneNumber').value = "";
		document.getElementById('workPhoneNumber').value = "";
		document.getElementById('street').value = "";
		document.getElementById('unit').value = "";
		document.getElementById('city').value = "";
		document.getElementById('state').value = "";
		document.getElementById('zip').value = "";
		$("#save").attr("onclick", "saveContact(0)");
		hideDialogBlockDialog();
	} else {
		var pathArray = varUrl.split('/');
		var varUrl = pathArray[4] + '/' + pathArray[5] + '/' + pathArray[6];
		console.log(varUrl);

		$
				.getJSON(varUrl)
				.done(
						function(data) {
							document.getElementById('name').value = data.name;
							document.getElementById('company').value = data.company;
							document.getElementById('profileImage').src = data.profileImage;
							document.getElementById('email').value = data.email;
							document.getElementById('birthdate').value = data.birthdate;
							document.getElementById('personalPhoneNumber').value = data.personalPhoneNumber;
							document.getElementById('workPhoneNumber').value = data.workPhoneNumber;
							document.getElementById('street').value = data.address.street;
							document.getElementById('unit').value = data.address.unit;
							document.getElementById('city').value = data.address.city;
							document.getElementById('state').value = data.address.state;
							document.getElementById('zip').value = data.address.zip;
							$("#save").attr("onclick", "saveContact('" + data.link[2].href + "')");
							hideDialogBlockDialog();
						});
	}
}
function drawSearchResults(data) {
	console.log(data);
	var contactTableBody = $("#contactTableBody");
	contactTableBody.empty();
	for ( var item in data) {
		var contact = data[item];
		var tr = $("<tr>");
		var tdImage = $("<td>");
		var div = $("<div>");
		$("<button>").html("X").attr("onclick",
				"deleteContact('" + contact.link[0].href + "')").appendTo(div);
		$("<button>").html(contact.name).attr("onclick",
				"loadDataToForm('" + contact.link[1].href + "')").appendTo(div);
		div.appendTo(tdImage);
		$('<img class="listPreview">').attr("src", contact.profileImage)
				.appendTo(tdImage);
		tdImage.appendTo(tr);
		var tdPersonal = $("<td>");
		var textPersonal = "-Email: " + contact.email + "\n";
		textPersonal += "-Phone Number: " + contact.personalPhoneNumber + "\n";
		textPersonal += "-Company: " + contact.company;
		$('<textarea readonly="true">').html(textPersonal).appendTo(tdPersonal);
		tdPersonal.appendTo(tr);
		var tdAddress = $("<td>");
		var textAddress = contact.address.street + " " + contact.address.unit
				+ "\n";
		textAddress += contact.address.city + " " + contact.address.state
				+ ", " + contact.address.zip;
		$('<textarea readonly="true">').html(textAddress).appendTo(tdAddress);
		tdAddress.appendTo(tr);
		tr.appendTo(contactTableBody);
		console.log(contact);
	}
	hideDialogBlockDialog();
}

function deleteContact(varUrl) {
	var pathArray = varUrl.split('/');
	var varUrl = pathArray[4] + '/' + pathArray[5] + '/' + pathArray[6];
	console.log(varUrl);
	showConfirmDialog("Are you sure?", function() {
		showDialogBlockDialog("Deleting");
		$.ajax({
			url : varUrl,
			method : 'DELETE',
			type : 'DELETE',
			success : function(result) {
				console.log(result);
				hideDialogBlockDialog();
				showDialog("Contact Deleted", function() {
					refreshContactsList();
				});
			},
			error : function(request, msg, error) {
				console.log(error);
			}
		});
	});
}

function getBase64Image(img) {
	var canvas = document.createElement("canvas");
	canvas.width = img.width;
	canvas.height = img.height;
	var ctx = canvas.getContext("2d");
	ctx.drawImage(img, 0, 0, img.width, img.height);
	var dataURL = canvas.toDataURL("image/png");
	return dataURL.replace(/^data:image\/(png|jpg);base64,/, "");
}
function loadFormIntoContact() {
	var base64 = getBase64Image(document.getElementById("profileImage"));
	var contact = {
		"name" : document.getElementById('name').value,
		"company" : document.getElementById('company').value,
		"profileImage" : base64,
		"email" : document.getElementById('email').value,
		"birthdate" : document.getElementById('birthdate').value,
		"personalPhoneNumber" : document.getElementById('personalPhoneNumber').value,
		"workPhoneNumber" : document.getElementById('workPhoneNumber').value,
		"address" : {
			"street" : document.getElementById('street').value,
			"unit" : document.getElementById('unit').value,
			"city" : document.getElementById('city').value,
			"state" : document.getElementById('state').value,
			"zip" : document.getElementById('zip').value
		}
	}
	return contact;
}
function saveContact(varUrl) {
	showDialogBlockDialog("Saving");
	if (varUrl == 0) {

		$.post("services/contact", JSON.stringify(loadFormIntoContact()),
				"json").done(function(data) {
			hideDialogBlockDialog();
			showDialog("Contact Saved", function() {
				refreshContactsList();
			});

		});
	} else {
		var pathArray = varUrl.split('/');
		var varUrl = pathArray[4] + '/' + pathArray[5] + '/' + pathArray[6];
		$.ajax({
			url : varUrl,
			method : "PUT",
			type : "PUT",
			data : JSON.stringify(loadFormIntoContact()),
			success : function(result) {
				console.log(result);
				hideDialogBlockDialog();
				showDialog("Contact Saved", function() {
					refreshContactsList();
				});
			},
			error : function(request, msg, error) {
				console.log(error);
			}
		});
	}
}