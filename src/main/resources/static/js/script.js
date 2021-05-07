const showModalDeletar = function(id){
	$('#id_deletar').val(id)	
	$('#deleteModal').modal('show')
}

const deletar = function(nome){
	let id = $('#id_deletar').val()
	if (id != 0)
		window.location.href = '/' + nome + '/delete/' + id
}

