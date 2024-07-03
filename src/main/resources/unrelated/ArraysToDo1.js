function pushFront(arrayA, newVal){
	for(var i = arrayA.length; i >= 0; i--){
		if(i == 0){
			arrayA[0] = newVal;
		}else{
			arrayA[i] = arrayA[i - 1]
		}
		
	}
	return arrayA;
}

console.log(pushFront([1,2], 7))

let arrayInstance = [1,2,3,4,5]
function popFront(arrayA){
	if(arrayA.length == 0) return "Array has no values to pop.";
	var item = arrayA[0]
	for(var i = 0; i < arrayA.length; i++){
		arrayA[i] = arrayA[i + 1];
	}
	arrayA.length--;
	return item;
}

console.log(popFront(arrayInstance))
console.log(arrayInstance)

function insertAt(arrayA, index, newVal){
	for(var i = arrayA.length; i >= index; i--){
		if(i == index){
			arrayA[index] = newVal;
		}else{
			arrayA[i] = arrayA[i - 1]
		}
		
	}
	return arrayA;
}

console.log(insertAt(arrayInstance, 2,5))