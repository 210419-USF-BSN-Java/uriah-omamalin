document.getElementById('login-btn').addEventListener("click", requestLogin);
function requestLogin(){
	let user = document.getElementById("username").value;
	let pass = document.getElementById("password").value;
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/project1/static/login.html";
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let auth = xhr.getResponseHeader("Authorization");
			sessionStorage.setItem("token", auth);
			let userToken = auth.split(":");
			switch(Number(userToken[1])) {
			case 1:
				window.location.href="http://localhost:8080/project1/static/employee-home.html";
				break;
			case 2:
				window.location.href="http://localhost:8080/project1/static/manager-home.html";
				break;
			}
		} 
		else if (xhr.readyState == 4){                            
			document.getElementById("message").innerHTML='incorrect credentials!';
		}
	}
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `username=${user}&password=${pass}`;
	xhr.send(requestBody);
}