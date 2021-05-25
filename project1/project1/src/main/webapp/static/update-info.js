document.getElementById('submit').addEventListener("click", updateInfo);

function updateInfo() {
	document.getElementById('message').innerHTML = "clicky";
	let first = document.getElementById("first").value;
	let last = document.getElementById("last").value;
    let email = document.getElementById("email").value;
	let token = sessionStorage.getItem("token");
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/project1/update";
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
            document.getElementById('message').innerHTML = "success";
		} 
		else if (xhr.readyState == 4){
			document.getElementById('message').innerHTML = "failure";
		}
	}
		
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	let requestBody = `first=${first}&last=${last}&email=${email}`;
	xhr.send(requestBody);
}