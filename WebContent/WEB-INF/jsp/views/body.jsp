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
			<img id="output" src="<c:url value="/img/testProfile.jpg" />" />
			<div>
				<input type="file" accept="image/*" onchange="previewFile(event)">
			</div>
		</article>
		<label for="name">
			<spring:message code="contact.label.name.value" />
		</label>
		<input type="text" id="name" name="name" placeholder="<spring:message code="contact.label.name.value" />">
		<label for="company">
			<spring:message code="contact.label.company.value" />
		</label>
		<input type="text" id="company" name="company" placeholder="<spring:message code="contact.label.company.value" />">
		<label for="email">
			<spring:message code="contact.label.email.value" />
		</label>
		<input type="text" id="email" name="email" placeholder="<spring:message code="contact.label.email.value" />">
		<label for="birthdate">
			<spring:message code="contact.label.birthdate.value" />
		</label>
		<input type="text" id="birthdate" name="birthdate" placeholder="<spring:message code="contact.label.birthdate.value" />">
		<label for="phoneNumberPersonal">
			<spring:message code="contact.label.phoneNumberPersonal.value" />
		</label>
		<input type="text" id="phoneNumberPersonal" name="phoneNumberPersonal" placeholder="<spring:message code="contact.label.phoneNumberPersonal.value" />">
		<label for="phoneNumberWork">
			<spring:message code="contact.label.phoneNumberWork.value" />
		</label>
		<input type="text" id="phoneNumberWork" name="phoneNumberWork" placeholder="<spring:message code="contact.label.phoneNumberWork.value" />">
		<label for="street">
			<spring:message code="address.label.street.value" />
		</label>
		<input type="text" id="street" name="street" placeholder="<spring:message code="address.label.street.value" />">
		<label for="unit">
			<spring:message code="address.label.unit.value" />
		</label>
		<input type="text" id="unit" name="unit" placeholder="<spring:message code="address.label.unit.value" />">
		<label for="city">
			<spring:message code="address.label.city.value" />
		</label>
		<input type="text" id="city" name="city" placeholder="<spring:message code="address.label.city.value" />">
		<label for="state">
			<spring:message code="address.label.state.value" />
		</label>
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
		<label for="zip">
			<spring:message code="address.label.zip.value" />
		</label>
		<input type="text" id="zip" name="zip" placeholder="<spring:message code="address.label.zip.value" />">
		<input type="button" onclick="saveValues()" value="Submit">
		<input type="button" id="cancel" onclick="refreshContactsList()" value="Cancel">
	</form>
</section>
<section id="list">
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
			<tr>
				<td>
					<button>X</button>
					<button>Percy Soliz</button>
					<img class="listPreview" src="<c:url value="/img/testProfile.jpg" />" />
				</td>
				<td>
					<textarea>test</textarea>
				</td>
				<td>
					<textarea>test</textarea>
				</td>
			</tr>
			<tr>
				<td>
					<button>X</button>
					<button>Percy Soliz</button>
					<img class="listPreview" src="<c:url value="/img/testProfile.jpg" />" />
				</td>
				<td>
					<textarea>test</textarea>
				</td>
				<td>
					<textarea>test</textarea>
				</td>
			</tr>
		</tbody>
	</table>
</section>