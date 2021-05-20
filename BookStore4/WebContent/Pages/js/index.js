

function changeType(j){
	var t_id = "a" + j;
    var td = document.getElementById(t_id);
	var type = td.innerText;
	location = "book_filter?name=getBookByType&value=" + type + "&j=" +j;
	
}

function change_firstword(k){
	console.log(k);
	location = "book_filter?name=getBookByFirstWord&value=" + k;
}
