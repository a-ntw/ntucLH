/**
	$('table.#deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('deleteModal #delRef').attr('href',href);
		$('#deleteModal').modal();
	});
	
});
dated: 210209
 */	
$(document).ready(function () {
	$('.table .delBtn').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		

		
		$('#deleteModal #delRef').attr('href',href);
		$('#deleteModal').modal();
		
	});
	
	});