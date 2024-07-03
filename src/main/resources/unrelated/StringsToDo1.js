/**
 * 
 */
function removeBlanks(message){
	var replacement = message.replace(/\s+/g, "");
	return replacement;
}
let testStringA = " asb adsa gggg f    gf ";

console.log(removeBlanks(testStringA));

function getDigits(string){
	var toNumber = ""
	for(var i = 0; i <= string.length; i++){
		if(!isNaN(string[i])){
			toNumber += string[i];
		}
	}
	if(toNumber.length == 0){
		return "No numbers were found in the provided string.";
	}
	var number = Number(toNumber);
	return number;
}

let toNumberTest = "oash1o4oodf7ywh459211j";
console.log(getDigits(toNumberTest));

function acronym(string){
	var toReturn = "";
	var splitted = string.split(' ');
	for(var i = 0; i < splitted.length; i++){
		toReturn += splitted[i][0].toUpperCase();
	}

	return toReturn;
}

let acro = "for the win";
console.log(acronym(acro));

function countNonSpaces(string){
	var counter = 0;
	for(var i = 0; i < string.length; i++){
		if(string[i] != ' '){
			counter++;
		}
	}
	return counter;
}

console.log(countNonSpaces(acro)) //9

function removeShorterStrings(arrayA, minLength){
	var sizeCounter = 0;
	var newArray = [];
	for(var i = 0; i < arrayA.length; i++){
		if(arrayA[i].length >= minLength){
			newArray.length = sizeCounter + 1;
			newArray[sizeCounter] = arrayA[i];
			sizeCounter++;
		}
	}

	return newArray;
}

console.log(removeShorterStrings(["Hello", "there", "how", "are", "you"], 4))