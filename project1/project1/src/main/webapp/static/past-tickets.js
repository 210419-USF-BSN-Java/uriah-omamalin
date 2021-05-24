let token = sessionStorage.getItem("token");

if (!token) {
	window.location.href  = "http://localhost:8080/project1/static/login.html";
} else {
	let tokenArr = token.split(":");
	if (tokenArr.length == 2) {
		let baseUrl = "http://localhost:8080/project1/api/reimbs/author/";
		sendGet(baseUrl += tokenArr[0]);
	} else {
		window.location.href  = "http://localhost:8080/project1/static/login.html";
	}
}

function formatMoney(number) {
  return number.toLocaleString('en-US', { style: 'currency', currency: 'USD' });
}

function sendGet(url) {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			let reimbList = xhr.getResponseHeader("authorList");
			let jsonList = JSON.parse(reimbList);
			let content = document.getElementById("reimbs");
			console.log(jsonList);
			for (i = 0; i < jsonList.length; i++) {
				console.log(formatMoney(jsonList[i].reimbAmount));
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
