$(function() {
	$('#cnpj').mask('00.000.000/0000-00', {
		reverse : true
	});
	
	$(".list-group-item").hover(mouseEnter, mouseLeave);
	
	captalizarCodigoAcao();
});

function mouseEnter() {
	$(this).addClass("active");
}

function mouseLeave() {
	$(this).removeClass("active");
}

function captalizarCodigoAcao(){
	$("#codigoAcao").on("input", function(){
		setTimeout(() => {
			$('#codigoAcao').val($(this).val().toUpperCase());
		}, 400);
	});
}