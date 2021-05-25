let token = sessionStorage.getItem("token");
let content = document.getElementById("reimbs");
document.getElementById("pending").addEventListener("click", sortPending);
document.getElementById("resolved").addEventListener("click", sortResolved);
document.getElementById("all").addEventListener("click", sortAll);

if (!token) {
	window.location.href  = "http://localhost:8080/project1/static/login.html";
} else {
	let tokenArr = token.split(":");
	if (tokenArr.length == 2) {
		let baseUrl = "http://localhost:8080/project1/api/reimbs/all";
		sendGet(baseUrl);
	} else {
		window.location.href  = "http://localhost:8080/project1/static/login.html";
	}
}

function sortPending() {
	document.getElementById("button-div").innerHTML = 
	`
	<label>enter reimbursement id:</label>
	<input type="number" id="id" class="form-control"><br>
	<button id='approve' class='btn btn-success'>approve</button>
	<button id='deny' class='btn btn-success'>deny</button>
	`
	document.getElementById("approve").addEventListener("click", approve);
	document.getElementById("deny").addEventListener("click", deny);
	
	function approve() {
			let xhr = new XMLHttpRequest();
			let id = document.getElementById("id").value;
			console.log(id);
			xhr.open("POST", "http://localhost:8080/project1/api/reimbs/" + id);
			xhr.onreadystatechange = function(){
				if(this.readyState===4 && this.status===200){
            		document.getElementById('message').innerHTML = "success";
					setTimeout(() => {  document.getElementById('message').innerHTML = ""; }, 2000);
				} 
				else if (xhr.readyState == 4){
					document.getElementById('message').innerHTML = "failure";
					setTimeout(() => {  document.getElementById('message').innerHTML = ""; }, 2000);
				}
			}
		
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	let requestBody = `id=${id}&status=2`;
	xhr.send(requestBody);
	}
	
	function deny() {
			let xhr = new XMLHttpRequest();
			let id = document.getElementById("id").value;
			console.log(id);
			xhr.open("POST", "http://localhost:8080/project1/api/reimbs/" + id);
			xhr.onreadystatechange = function(){
				if(this.readyState===4 && this.status===200){
            		document.getElementById('message').innerHTML = "success";
					setTimeout(() => {  document.getElementById('message').innerHTML = ""; }, 2000);
				} 
				else if (xhr.readyState == 4){
					document.getElementById('message').innerHTML = "failure";
					setTimeout(() => {  document.getElementById('message').innerHTML = ""; }, 2000);
				}
			}
		
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	let requestBody = `id=${id}&status=3`;
	xhr.send(requestBody);
	}
	
	content.innerHTML = `<tr>
					<th>id</th>
					<th>amount</th>
					<th style="width:800px">description</th>
					<th>type</th>
					<th>submitted</th>
					</tr>`;
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "http://localhost:8080/project1/api/reimbs/pending");
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			let reimbList = xhr.getResponseHeader("allPendingReimb");
			let jsonList = JSON.parse(reimbList);
			console.log(jsonList);
			for (i = 0; i < jsonList.length; i++) {
				let request = "<td>" + jsonList[i].reimbId +
							  "</td><td>" + formatMoney(jsonList[i].reimbAmount) +
							  "</td><td>";
				if (jsonList[i].reimbDescription == null) {
					request += "-</td><td>";
				} else {
				request += jsonList[i].reimbDescription +
							  "</td><td>";
				}
				switch(jsonList[i].reimbTypeId) {
					case 1: request += "lodging"; break;
					case 2: request += "travel"; break;
					case 3: request += "food"; break;
					case 4: request += "other"; break;
				}
				request += "</td><td>" + new Date(jsonList[i].reimbSubmitted).toLocaleDateString() + "</td>";
				content.insertAdjacentHTML('beforeend', request);
			}
			console.log(jsonList);
		} else if (this.readyState===4){
			window.location.href="http://localhost:8080/project1/static/login.html";
		}
	}
	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function sortResolved() {
	document.getElementById("button-div").innerHTML = 
	`
	`
	content.innerHTML = `<tr>
					<th>id</th>
					<th>amount</th>
					<th style="width:800px">description</th>
					<th>type</th>
					<th>status</th>
					<th>submitted</th>
					<th>resolved</th>
					<th>resolver id</th>
					</tr>`;
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "http://localhost:8080/project1/api/reimbs/resolved");
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			let reimbList = xhr.getResponseHeader("allResolvedReimb");
			let jsonList = JSON.parse(reimbList);
			console.log(jsonList);
			for (i = 0; i < jsonList.length; i++) {
				let request = "<td>" + jsonList[i].reimbId +
							  "</td><td>" + formatMoney(jsonList[i].reimbAmount) +
							  "</td><td>";
				if (jsonList[i].reimbDescription == null) {
					request += "-</td><td>";
				} else {
				request += jsonList[i].reimbDescription +
							  "</td><td>";
				}
				switch(jsonList[i].reimbTypeId) {
					case 1: request += "lodging"; break;
					case 2: request += "travel"; break;
					case 3: request += "food"; break;
					case 4: request += "other"; break;
				}
				request += "</td><td>";
				switch(jsonList[i].reimbStatusId) {
					case 1: request += "pending"; break;
					case 2: request += "approved"; break;
					case 3: request += "denied"; break;
				}
				request += "</td><td>" + new Date(jsonList[i].reimbSubmitted).toLocaleDateString();
				request += "</td><td>" + new Date(jsonList[i].reimbResolved).toLocaleDateString();
				request += "</td><td>" + jsonList[i].reimbResolver;
				content.insertAdjacentHTML('beforeend', request);
			}
			console.log(jsonList);
		} else if (this.readyState===4){
			window.location.href="http://localhost:8080/project1/static/login.html";
		}
	}
	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function sortAll() {
	document.getElementById("button-div").innerHTML = 
	`
	`
	content.innerHTML = `<tr>
					<th>id</th>
					<th>amount</th>
					<th style="width:800px">description</th>
					<th>type</th>
					<th>status</th>
					</tr>`;
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "http://localhost:8080/project1/api/reimbs/all");
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			let reimbList = xhr.getResponseHeader("allReimb");
			let jsonList = JSON.parse(reimbList);
			console.log(jsonList);
			for (i = 0; i < jsonList.length; i++) {
				let request = "<td>" + jsonList[i].reimbId +
							  "</td><td>" + formatMoney(jsonList[i].reimbAmount) +
							  "</td><td>";
				if (jsonList[i].reimbDescription == null) {
					request += "-</td><td>";
				} else {
				request += jsonList[i].reimbDescription +
							  "</td><td>";
				}
				switch(jsonList[i].reimbTypeId) {
					case 1: request += "lodging"; break;
					case 2: request += "travel"; break;
					case 3: request += "food"; break;
					case 4: request += "other"; break;
				}
				request += "</td><td>";
				switch(jsonList[i].reimbStatusId) {
					case 1: request += "pending"; break;
					case 2: request += "approved"; break;
					case 3: request += "denied"; break;
				}
				request += "</td>";
				content.insertAdjacentHTML('beforeend', request);
			}
			console.log(jsonList);
		} else if (this.readyState===4){
			window.location.href="http://localhost:8080/project1/static/login.html";
		}
	}
	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function sendGet(url) {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			let reimbList = xhr.getResponseHeader("allReimb");
			let jsonList = JSON.parse(reimbList);
			console.log(jsonList);
			for (i = 0; i < jsonList.length; i++) {
				let request = "<td>" + jsonList[i].reimbId +
							  "</td><td>" + formatMoney(jsonList[i].reimbAmount) +
							  "</td><td>";
				if (jsonList[i].reimbDescription == null) {
					request += "-</td><td>";
				} else {
				request += jsonList[i].reimbDescription +
							  "</td><td>";
				}
				switch(jsonList[i].reimbTypeId) {
					case 1: request += "lodging"; break;
					case 2: request += "travel"; break;
					case 3: request += "food"; break;
					case 4: request += "other"; break;
				}
				request += "</td><td>";
				switch(jsonList[i].reimbStatusId) {
					case 1: request += "pending"; break;
					case 2: request += "approved"; break;
					case 3: request += "denied"; break;
				}
				request += "</td>";
				content.insertAdjacentHTML('beforeend', request);
			}
			console.log(jsonList);
		} else if (this.readyState===4){
			window.location.href="http://localhost:8080/project1/static/login.html";
		}
	}
	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}

function formatMoney(number) {
  return number.toLocaleString('en-US', { style: 'currency', currency: 'USD' });
}