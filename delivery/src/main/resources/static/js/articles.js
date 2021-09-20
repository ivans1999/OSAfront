function getArticles(){
	readArticles();
	var article = [];
	
	$(document).on("click",'tr',function(event){
		highlightRow(this);
		$('#dataTable').on('click','tr', function(event){ 
			article.length = 0;
			var selectedRow = $(this);
			var td = selectedRow.children('td');
			for (var i = 0; i < td.length; ++i) {
				article.push(td.eq(i).text());
				
			}
		}); 
		console.log(article);
	});
	
	$(document).on("click", '#add', function(event){
		readSellers();
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		addArticle();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		addArticleToSelect();
		readSellers2();
		$('#updateModalScrollable').modal('show');
	});

	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		addArticleToSelect2();
		$('#deletePromptModal').modal('show');
	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		deleteArticle();
		$('#deletePromptModal').modal('hide');
	});
}
var articlesArray = [];
function readArticles() {
	$.ajax({
		url : "http://localhost:8080/delivery/articles/all" 
	}).then(
			function(data, status, request) {
				console.log(data);
				articlesArray = data;
				console.log('this is articles array '+articlesArray);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].id)
					newRow = 
					"<tr>" 
						+ "<td class=\"articleName\">" + data[i].articleName + "</td>"
						+ "<td class=\"articleDescription\">" + data[i].articleDescription + "</td>"
						+ "<td class=\"articleMark\">" + data[i].articleMark + "</td>"
						+ "<td class=\"path\">" + data[i].path + "</td>" 
						+ "<td class=\"usersDTO\">" + data[i].usersDTO.firstname + "</td>" +
					"</tr>"
					$("#dataTableBody").append(newRow);
				}
			});
}

function readSellers(){
	$.ajax({
		url : "http://localhost:8080/delivery/users/all"
	}).then(
		function(data) {
			$("#prodavacSelect").empty();
			$.each(data, function (i, item) {
			    $('#prodavacSelect').append($('<option>', { 
			        value: item.id,
			        text : item.firstname
			    }));
			});	
		}
	);
}

function readSellers2(){
	$.ajax({
		url : "http://localhost:8080/delivery/users/all"
	}).then(
		function(data) {
			$("#prodavacIzmeniSelect").empty();
			$.each(data, function (i, item) {
			    $('#prodavacIzmeniSelect').append($('<option>', { 
			        value: item.id,
			        text : item.firstname
			    }));
			});	
		}
	);
}

function addArticle(){
	var nazivInput = $('#nazivInput');
	var opisInput = $('#opisInput');
	var ocenaInput = $('#ocenaInput');
	var putanjaInput = $('#putanjaInput');
	var prodavacSelect = $('#prodavacSelect');
	
	var articleName = nazivInput.val();
	var articleDescription = opisInput.val();
	var articleMark = ocenaInput.val();
	var path = putanjaInput.val();
	var usersDTO = prodavacSelect.val();
	
	console.log('articleName: ' + articleName);
	console.log('articleDescription: ' + articleDescription);
	console.log('articleMark: ' + articleMark);
	console.log('path: ' + path);
	console.log('usersDTO: ' + usersDTO);
	
	if(articleName == "" || articleDescription == "" || articleMark == "" || path == "" || usersDTO == ""){
		alert('Niste uneli potrebne podatke')
		return;
		$('#addModalScrollable').modal('hide');
	}
	
	
	var params = {
			'articleName' : articleName,
			'articleDescription' : articleDescription,
			'articleMark' : articleMark,
			'path' : path,
			'usersDTO' : {
				'id' : usersDTO
			}
	}
	
	
	$.ajax({
		url : 'http://localhost:8080/delivery/articles/add',
		type:'POST',
		data: JSON.stringify(params),
		contentType:'application/json; charset=utf-8',
		dataType:'json',
		success:function(data){
			console.log('...')
			alert('Dodat je novi artikal')
			readArticles();
			nazivInput.val("");
			opisInput.val("");
			ocenaInput.val("");
			putanjaInput.val("");
			prodavacSelect.val("");
		}
	})
	console.log('slanje poruke');
	event.preventDefault();
	return false;
}

function addArticleToSelect(){
	$.ajax({
		url : "http://localhost:8080/delivery/articles/all"
	}).then(
		function(data) {
			$("#artikalEditSelect").empty();
			$.each(data, function (i, item) {
			    $('#artikalEditSelect').append($('<option>', { 
			        value: item.id,
			        text : item.articleName
			    }));
			});	
		}
	);
}

function addArticleToSelect2(){
	$.ajax({
		url : "http://localhost:8080/delivery/articles/all"
	}).then(
		function(data) {
			$("#artikalDeleteSelect").empty();
			$.each(data, function (i, item) {
			    $('#artikalDeleteSelect').append($('<option>', { 
			        value: item.id,
			        text : item.articleName
			    }));
			});	
		}
	);
}

//EDIT :

	$(document).on("click", '#fillOutArticleFieldsEdit', function(event) {
		var id = document.getElementById("artikalEditSelect").value;
		if(!id) {
			alert("Morate izabrati artikal da biste izvrsili izmenu");
		}
		var chosenArticleData = articlesArray.filter(article => article.id == id);
		console.log(chosenArticleData[0].articleName);
		$('#nazivIzmeniInput').val(chosenArticleData[0].articleName);
		$('#opisIzmeniInput').val(chosenArticleData[0].articleDescription);
		$('#ocenaIzmeniInput').val(chosenArticleData[0].articleMark);
		$('#putanjaIzmeniInput').val(chosenArticleData[0].path);
		event.preventDefault();
	});

	$(document).on("click",'#doUpdate', function(event){
		if(!document.getElementById("artikalEditSelect").value){
			alert('Izaberite artikla za izmenu');
			return;
		}
	
	var nazivIzmeniInput = $('#nazivIzmeniInput');
	var opisIzmeniInput = $('#opisIzmeniInput');
	var ocenaIzmeniInput = $('#ocenaIzmeniInput');
	var putanjaIzmeniInput = $('#putanjaIzmeniInput');
	var izaberiArtikal = $('#artikalEditSelect');
	var usersDTO = $('#prodavacIzmeniSelect');
	
	var articleName = nazivIzmeniInput.val();
	var articleDescription = opisIzmeniInput.val();
	var articleMark = ocenaIzmeniInput.val();
	var path = putanjaIzmeniInput.val();
	var izabranArtikal = izaberiArtikal.val();
	var usersDTO = usersDTO.val();
	
	console.log('articleName: ' + articleName);
	console.log('articleDescription: ' + articleDescription);
	console.log('articleMark: ' + articleMark);
	console.log('path: ' + path);
	console.log('usersDTO: ' + usersDTO);
	
	var params = {
			'id' : izabranArtikal,
			'articleName' : articleName,
			'articleDescription' : articleDescription,
			'articleMark' : articleMark,
			'path' : path,
			'usersDTO': {
					'id' : usersDTO
				}
	}
	
	$.ajax({
		url:"http://localhost:8080/delivery/articles/" + izabranArtikal,
		type:"PUT",
		data: JSON.stringify(params),
		contentType:"application/json; charset=utf-8",
		dataType:"json",
		success:function(data){
			console.log(data);
			readArticles();
			nazivIzmeniInput.val("");
			opisIzmeniInput.val("");
			ocenaIzmeniInput.val("");
			putanjaIzmeniInput.val("");
			$('#updateModalScrollable').modal('hide');
		}
	});
});

function deleteArticle(){
	var izaberiArtikal = $('#artikalDeleteSelect');
	var izabranArtikal = izaberiArtikal.val();
	$.ajax({
    	url: "http://localhost:8080/delivery/articles/" + izabranArtikal,
    	type: "DELETE",
    	success: function(){
    		alert('Izbrisali ste artikal!');
    		readArticles();
        }
	});
}