

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

function getbook_bykeyword(){
	var td = document.getElementsByClassName("search")[0];
	var type = td.value;
	console.log(td);
	location = "book_filter?name=getbook_bykeyword&value=" + type;
}


function change_page(j){
	var td = document.getElementsByClassName("page_btn")[j-1];
	
	console.log(td);
	var page = td.innerText;
	
	location = "book_filter?name=getbook_bypage&value=" + page;
}