/**
 * funções relacionado aos eventos de usuários
 */
const url = 'http://localhost:4567'
	
function addUser(){
	let data = {
		email:  $('#email').val(),
		cpf: $('#cpf').val()
	}
	$.post(
		url + '/api/user', 
		data,
		function(result, status){
			//if(result === ''){
			//	
			//} else {
				
			//}
			alert(result)
		}
	)
}

function login(){
	
	let data = {
		email: $('#email').val(),
		cpf: $('#cpf').val()
	}
	
	$.post(
		url + '/api/user/login', 
		data,
		function(result, status){
			if(result === 'success'){
				document.location = 'chat.html'
			} else {
				alert('Usuário ou Senha inválidos!')
			}
			
		}
)	
	
}