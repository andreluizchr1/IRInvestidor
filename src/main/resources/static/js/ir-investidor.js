$(function() {
	$('#cnpj').mask('00.000.000/0000-00', {
		reverse : true
	});
	
	$(".list-group-item").hover(mouseEnter, mouseLeave);
});

function mouseEnter() {
	$(this).addClass("active");
}

function mouseLeave() {
	$(this).removeClass("active");
}