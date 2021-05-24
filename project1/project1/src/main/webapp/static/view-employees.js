let token = sessionStorage.getItem("token");
let content = document.getElementById("emps");

if (!token) {
	window.location.href  = "http://localhost:8080/project1/static/login.html";
} else {
	let tokenArr = token.split(":");
	if (tokenArr.length == 2) {
		let baseUrl = "http://localhost:8080/project1/api/emps/all";
		sendGet(baseUrl);
	} else {
		window.location.href  = "http://localhost:8080/project1/static/login.html";
	}
}

function sendGet(url) {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			let empList = xhr.getResponseHeader("allEmp");
			let jsonList = JSON.parse(empList);
			console.log(jsonList);
			for (i = 0; i < jsonList.length; i++) {
				let request = "<td>" + jsonList[i].usersId +
							  "</td><td>" + jsonList[i].firstName +
							  "</td><td>" + jsonList[i].lastName +
							  "</td><td>" + jsonList[i].email + "</td>";
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
