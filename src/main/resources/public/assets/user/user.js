/**
 * funções relacionado aos eventos de usuários
 */
const url = 'http://localhost:4567'
	
function addUser(){
	let data = {
		email:  $('#user_email').val(),
		cpf: $('#user_cpf').val()
	}
	console.log(data)
	$.post(
		url + '/api/user', 
		data,
		function(result, status){
			console.log(result)
			if(result){
				if(result == 'success'){
					$("#closeModal").click()
					alert('Cadastro realizado com sucesso!')
				} else {
					alert('Não foi possivel cadastrar!')
				}
			} else {
				alert('Error de cadastro!!')
			}
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
			console.log(result)
			if(result){
				if(result == 'success'){
					document.location = 'chat.html'
				} else {
					alert('Usuário ou Senha inválidos!')
				}
			} else {
				alert('Error de login')
			}
		}
	)	
	
}