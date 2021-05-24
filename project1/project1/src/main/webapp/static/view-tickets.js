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
	content.innerHTML = `<tr>
					<th>id</th>
					<th>amount</th>
					<th style="width:800px">description</th>
					<th>type</th>
					<th>status</th>
					<th>submitted</th>
					<th>resolved</th>
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
				request += "</td><td>" + new Date(jsonList[i].reimbResolved).toLocaleDateString() + "</td>";
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
