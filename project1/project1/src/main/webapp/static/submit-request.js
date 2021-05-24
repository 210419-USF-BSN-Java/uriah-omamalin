document.getElementById('submit').addEventListener("click", submitReimb);

function submitReimb() {
	document.getElementById('message').innerHTML = "clicky";
	let amount = document.getElementById("amount").value;
	let type = document.getElementById("type").value;
    let description = document.getElementById("description").value;
	let token = sessionStorage.getItem("token");
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/project1/submit";
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
	let requestBody = `amount=${amount}&type=${type}&description=${description}`;
	xhr.send(requestBody);
}