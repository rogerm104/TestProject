//looping through array
var accountNumberArr = ['134567', '134567', '134567', '134567'];
console.log("The account number is " + accountNumberArr);
accountNumberArr.forEach(arryLoopFn);

function arryLoopFn(item, index) {
  //console.log("item is " + item + " and index is " + index)
}

//looping through object
var accountNumbers = {
  'Roger': '134567',
  'Rosario': '134567',
  'Mendes': '134567',
  'someThing': '134567',
};

console.log("The account objec is  " + accountNumbers)
for (var key in accountNumbers) {
  //console.log("the value of key " + key +" is "+ accountNumbers[key] + "|");
}

//looping through complex object
var accountNumbersEvil = {
  'Roger': {
    'Roger1': '134567',
    'Rosario1': '134567',
    'Mendes1': '134567',
    'someThing1': '134567',
  },
  'Rosario': {
    'Roger2': '134567',
    'Rosario2': '134567',
    'Mendes2': '134567',
    'someThing2': '134567',
  },
  'Mendes': '134567',

};

for (var keyEvilObj in accountNumbersEvil) {
  console.log(" Evil obj key is  " + keyEvilObj + " and Value is " + accountNumbersEvil[keyEvilObj]);
  if (typeof accountNumbersEvil[keyEvilObj] === 'object') {
    for (var keyEvilObjchild in accountNumbersEvil[keyEvilObj]) {
      console.log(" Evil obj child key is  " + keyEvilObjchild + " and child Value is " + accountNumbersEvil[keyEvilObj][keyEvilObjchild]);
    }

  }
}



//String methods in javascript
var str= " This is world and its beautiful in this age";
//Starts with index 0
console.log(str.length);
console.log(" Index of 'is' is "+str.indexOf('is'));
console.log(" Index of 'is' is "+str.indexOf(' is '));
console.log(" Index of 'is' but start at 4 is "+str.indexOf('is',4));
console.log(" Index of 'is' is "+str.indexOf('z'));
console.log(" Last Index of 'is ' is "+str.lastIndexOf('is'));
//search can take regular experission
console.log(" search for 'is ' is "+str.search('beautiful'));

//slice substring substr
//slice(start, end) (end not included)
//substring(start, end) (end not included does not accept negitive indexes)
//substr(start, length)
console.log(" slice 1 to 10 =>"+str.slice(1,14));
console.log(" substring 1 to 10 =>"+str.substring(1,14));
console.log(" substr 1 to 10 =>"+str.substr(1,13));

console.log(" slice 14 =>["+str.slice(14)+"]");
console.log(" substring 14 =>["+str.substring(14)+"]");
console.log(" substr 14 =>["+str.substr(14)+"]");

//replace /i/g 
console.log(" replace 'is' with  '_is_' "+str.replace('is','_is_'));
console.log(" replace 'is' with  '_is_' "+str.replace('IS','_is_'));
console.log(" replace 'is' with  '_is_' "+str.replace(/IS/i,'_is_'));//case insenstive
console.log(" replace 'is' with  '_is_' "+str.replace(/is/g,'_is_'));//reaplce all

//toUpperCase toLowerCase trim() concat

console.log(" Converting all to toUpperCase  "+str.toUpperCase());
console.log(" Converting all to toLoerCase  "+str.toLowerCase());
console.log("Length of string before trim "+str.length);
console.log("Trimming the  String "+str.trim());
console.log("Length of string before trim "+str.trim().length);
console.log("Conact with Roger "+str.concat(" Roger"));

// charAt() charCodeAt() split()
console.log("Char at 2 "+str.charAt(2));
console.log("char code at 2 "+str.charCodeAt(2));

//str.split(" ").forEach(printAll);

function printAll(index,item){
console.log("The index is "+item +" and item is "+ index);
};




