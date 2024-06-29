/**
 * 
 */

let refreshTID = 0;
const blankSymbol = "[ - - - ]"
function handleCellClicked(id){
	const clickedCell = document.getElementById(`cell-${id}`)
	const user = document.getElementById('userId').innerText;
	if(clickedCell.textContent!=blankSymbol) return;
	if(document.getElementById('turn').innerText != user) return;
	const url = window.location.pathname.split("/");
	const moveData = {gameId : url[5], userId : user, cell : id}
	 fetch('/api/move', {method: 'POST',
	 headers: {'Content-Type': 'application/json'},
	 body: JSON.stringify(moveData),
	 }).then(response => response.json()).then(payload => {
		if(payload[0] == 0){
			exit();
		} else if(payload[0] == 1){
			if(payload[1] == 1)
				clickedCell.textContent = 'X';
			else if(payload[1] == 2){
				clickedCell.textContent = 'O';
			}
		}
		forceRefresh();
		
	 })
}

function refreshBoard(){
	const url = window.location.pathname.split("/");
	const stateData = url[5];
	 fetch(`/api/get/${stateData}`, {method: 'GET', headers: {'Content-Type': 'application/json', 'stateRequest' : stateData}}).then(response => response.json()).then(payload => {
		console.log(payload)
		payload.forEach((item, i) => {
			let str = blankSymbol;
			if(item == 1){
				str = 'X';
			} else if(item == 2){
				str = 'O';
			}
			document.getElementById(`cell-${i}`).innerText = str;
		});
		
	 });
	 clearTimeout(refreshTID)
	 refreshTID = setTimeout(refreshBoard, 5000)
}

refreshBoard();

function exit(){
	const url = window.location.pathname.split("/");
	fetch(`/api/${url[5]}/exit`);
}

function forceRefresh(){
	const url = window.location.pathname.split("/");
	fetch(`/api/${url[5]}/refresh`);
}