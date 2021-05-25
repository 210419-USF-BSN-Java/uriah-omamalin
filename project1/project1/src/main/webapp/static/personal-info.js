let token = sessionStorage.getItem("token");

if (!token) {
	window.location.href  = "http://localhost:8080/project1/static/login.html";
} else {
	let tokenArr = token.split(":");
	if (tokenArr.length == 2) {
		let baseUrl = "http://localhost:8080/project1/api/emps/";
		sendGet(baseUrl += tokenArr[0]);
	} else {
		window.location.href  = "http://localhost:8080/project1/static/login.html";
	}
}

function sendGet(url) {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			let emp = xhr.getResponseHeader("empById");
			let json = JSON.parse(emp);
			let content = document.getElementById("emp");
			console.log(json);
			content.innerHTML += "name: " + json.fullName + "<br>";
			content.innerHTML += "email: " + json.email;
		} else if (this.readyState===4){
			window.location.href="http://localhost:8080/project1/static/login.html";
		}
	}
	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}
