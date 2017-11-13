var list;
var form;
$(function() {
	list = $('#list');
	form = $('#form');
	refreshContactsList();
});
function saveValues() {

}
function previewFile(event) {
	var output = document.getElementById('output');
	output.src = URL.createObjectURL(event.target.files[0]);
};
function loadForm(id) {
	list.hide();
	form.show();
	if (id == 0) {

	} else {

	}
}
function refreshContactsList() {
	list.show();
	form.hide();
	$.getJSON("services/contact").done(function(data) {
		drawSearchResults(data);
	});

}
function drawSearchResults(data) {
	console.log(data);
	var contactTableBody = $("#contactTableBody");
	contactTableBody.empty();
	for ( var item in data) {
		var contact = data[item];
		var tr = $("<tr>");
		var tdImage = $("<td>");
		$("<button>").html("X").appendTo(tdImage);
		$("<button>").html(contact.name).appendTo(tdImage);
		$('<img class="listPreview">').attr("src",
				"viewContactPicture.html?contactId=" + contact.contactId)
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
function createProfile() {
	var base64 = getBase64Image(document.getElementById("output"));
	var profile = {
		"name" : document.getElementById('name').value,
		"description" : document.getElementById('description').value,
		"profilePicture" : base64,
		"email" : document.getElementById('email').value,
		"password" : document.getElementById('password').value,
		"mobilePhoneNumber" : document.getElementById('mobilePhoneNumber').value,
		"latitude" : document.getElementById('latitude').value,
		"longitude" : document.getElementById('longitude').value,
		"skills" : document.getElementById('skills').value
	}
	console.log(profile);
	const xhr = new XMLHttpRequest();
	xhr
			.open("POST",
					"http://18.220.231.8:8080/QuipaServer/services/profileservice/profile");
	xhr.setRequestHeader("Accept", "application/json");
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onload = function() {
		try {
			if (this.status === 200) {
				var data = JSON.parse(this.response);
				document.querySelector('#Navigator').pushPage('profile.html', {
					data : {
						title : 'Profile Created'
					}
				});
				document.getElementById('profilePictureCreated').value = data['profilePicture'];
				document.getElementById('profileId').value = data['profileId'];
			} else {
				console.log(this.status + " " + this.statusText);
			}
		} catch (e) {
			console.log(e.message);
		}
	};

	xhr.onerror = function() {
		console.log(this.status + " " + this.statusText);
	};
	xhr.send(JSON.stringify(profile));
}