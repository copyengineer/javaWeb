

function changeType(j){
	var t_id = "a" + j;
    var td = document.getElementById(t_id);
	var type = td.innerText;
	var json_str = null;
	var list = $('div.first_word a');//获取书本首字母下所有的a标签
	
	for(var i=0;i<list.length;i++){
		if(list[i].getAttribute("class") == "active2"){
			var firstword = list[i].innerText;
			json_str = {
				"getBookByFirstWord":firstword,
				"getBookByType":j
			};
		}
	}
	var str = JSON.stringify(json_str);
	location = "book_filter?filter_list=" + str;
	
}

function change_firstword(k){
	console.log(k);
	location = "book_filter?name=getBookByFirstWord&value=" + k;
}
