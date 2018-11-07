/**
 * funções relacionado aos eventos de usuários
 */
const url = 'http://localhost:4567'
	
function addUser(){
	let data = {
		email:  $('#email').val(),
		password: $('#password').val()
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