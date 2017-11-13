<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="form" class="formContainer" style="display: none">
	<form>
		<article id="imageContainer">
			<h1>
				<spring:message code="contact.label.title.value" />
			</h1>
			<img crossOrigin="Anonymous" id="profileImage" src="<c:url value="/img/testProfile.jpg" />" />
			<div>
				<input type="file" accept="image/*" onchange="previewFile(event)">
			</div>
		</article>
		<input type="text" id="name" name="name" placeholder="<spring:message code="contact.label.name.value" />">
		<input type="text" id="company" name="company" placeholder="<spring:message code="contact.label.company.value" />">
		<input type="text" id="email" name="email" placeholder="<spring:message code="contact.label.email.value" />">
		<input type="text" id="birthdate" name="birthdate" placeholder="<spring:message code="contact.label.birthdate.value" />">
		<input type="text" id="personalPhoneNumber" name="personalPhoneNumber" placeholder="<spring:message code="contact.label.phoneNumberPersonal.value" />">
		<input type="text" id="workPhoneNumber" name="workPhoneNumber" placeholder="<spring:message code="contact.label.phoneNumberWork.value" />">
		<input type="text" id="street" name="street" placeholder="<spring:message code="address.label.street.value" />">
		<input type="text" id="unit" name="unit" placeholder="<spring:message code="address.label.unit.value" />">
		<input type="text" id="city" name="city" placeholder="<spring:message code="address.label.city.value" />">
		<select id="state" name="state">
			<option value="AL">Alabama</option>
			<option value="AK">Alaska</option>
			<option value="AZ">Arizona</option>
			<option value="AR">Arkansas</option>
			<option value="CA">California</option>
			<option value="CO">Colorado</option>
			<option value="CT">Connecticut</option>
			<option value="DE">Delaware</option>
			<option value="DC">District Of Columbia</option>
			<option value="FL">Florida</option>
			<option value="GA">Georgia</option>
			<option value="HI">Hawaii</option>
			<option value="ID">Idaho</option>
			<option value="IL">Illinois</option>
			<option value="IN">Indiana</option>
			<option value="IA">Iowa</option>
			<option value="KS">Kansas</option>
			<option value="KY">Kentucky</option>
			<option value="LA">Louisiana</option>
			<option value="ME">Maine</option>
			<option value="MD">Maryland</option>
			<option value="MA">Massachusetts</option>
			<option value="MI">Michigan</option>
			<option value="MN">Minnesota</option>
			<option value="MS">Mississippi</option>
			<option value="MO">Missouri</option>
			<option value="MT">Montana</option>
			<option value="NE">Nebraska</option>
			<option value="NV">Nevada</option>
			<option value="NH">New Hampshire</option>
			<option value="NJ">New Jersey</option>
			<option value="NM">New Mexico</option>
			<option value="NY">New York</option>
			<option value="NC">North Carolina</option>
			<option value="ND">North Dakota</option>
			<option value="OH">Ohio</option>
			<option value="OK">Oklahoma</option>
			<option value="OR">Oregon</option>
			<option value="PA">Pennsylvania</option>
			<option value="RI">Rhode Island</option>
			<option value="SC">South Carolina</option>
			<option value="SD">South Dakota</option>
			<option value="TN">Tennessee</option>
			<option value="TX">Texas</option>
			<option value="UT">Utah</option>
			<option value="VT">Vermont</option>
			<option value="VA">Virginia</option>
			<option value="WA">Washington</option>
			<option value="WV">West Virginia</option>
			<option value="WI">Wisconsin</option>
			<option value="WY">Wyoming</option>
		</select>
		<input type="text" id="zip" name="zip" placeholder="<spring:message code="address.label.zip.value" />">
		<input type="button" id="save" onclick="saveContact(0)" value="Submit">
		<input type="button" id="cancel" onclick="cancelSave()" value="Cancel">
	</form>
</section>
<section id="list">
	<div>
		<input type="radio" name="type" value="contact" checked>
		All
		<input type="radio" name="type" value="contact/address/city/">
		City
		<input type="radio" name="type" value="contact/address/state/">
		State
		<input type="radio" name="type" value="contact/phoneNumber/">
		Phone Number
		<input type="radio" name="type" value="contact/email/">
		Email
		<button onclick="refreshContactsList()">Search</button>
	</div>
	<input type="text" id="textSearch">
	<table id="contactTable">
		<thead>
			<tr>
				<th>
					<spring:message code="contact.label.name.value" />
				</th>
				<th>
					<spring:message code="contact.label.group.personal" />
				</th>
				<th>
					<spring:message code="contact.label.group.address" />
				</th>
			</tr>
		</thead>
		<tbody id="contactTableBody">
		</tbody>
	</table>
</section>
<div id="dialog-message" title="Message From Server" style="display: none">
	<p id="dialogMessageText"></p>
</div>
<div id="dialog-loading" title="Message From Server" style="display: none">
	<p id="dialogMessageTextLoading"></p>
</div>