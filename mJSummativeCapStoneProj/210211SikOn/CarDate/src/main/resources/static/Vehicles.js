/**
 * 
 */
var pictModal = document.getElementById('pictModal')
pictModal.addEventListener('hide.bs.modal', function(event) {
	// upon modal close, reset vehPicts so that the modal does not reappear.
	window.location = "/vehPicts/0";
})



//https://o7planning.org/11813/spring-boot-file-upload-with-jquery-ajax
$(document).ready(function() {
	// when Vehicles.html page is loaded, if there is a vehicle for which pictures are to be viewed, 
	// this method will create a click on a button to cause the modal to show.
	if (document.getElementById('modalPictsVehId').innerHTML != '0') {
		$('#modalClick').trigger('click');
	}

	// Submit form to upload new picture
	$("#addBtn").click(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxSubmitAdd();
	});


	// Button to delete existing picture
	$(".deleBtn").click(function(event) {
		var button = event.target;
		var pictId = button.getAttribute("id");
		var vehId = document.getElementById('modalPictsVehId').innerHTML
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		if (confirm('Proceed to delete Picture [' + pictId + '] from Vehicle [' + vehId + ' ]?')) {
			// DO GET
			$.ajax({
				type: "GET",
				url: "/vehRmvPictJs/" + pictId,
				success: function(formData, textStatus, jqXHR) {
					document.getElementById('execResult').innerHTML = 'Picture deleted successfully.';
					document.getElementById('divPict' + pictId).parentElement.remove();
					console.log("SUCCESS : ", formData);
					var elemSpanIcon = document.createElement('span');
					var elemSpanIconP = document.createElement('span');
					elemSpanIcon.setAttribute('class', 'fa fa-picture-o');
					elemSpanIconP.setAttribute('class', 'fa fa-picture-o');
					
					var strId = 'vehThumb' + vehId + '_' + pictId;
					var elemThumb = document.getElementById(strId);
					if (elemThumb != null) {
						elemThumb.removeChild(elemThumb.childNodes[0]);
						var elemSpan = document.createElement('span');
						strId = 'vehThumb' + vehId;
						elemSpan.setAttribute('id', strId);
						var elemSpanIcon = document.createElement('span');
						elemSpanIcon.setAttribute('class', 'fa fa-picture-o');
						elemSpan.appendChild(elemSpanIcon);
						elemThumb.appendChild(elemSpan);
						strId = 'vehThumb' + vehId
						elemThumb.setAttribute('id', strId);
					}
					strId = 'pinVehThumb' + vehId + '_' + pictId;
					elemThumb = document.getElementById(strId);
					if (elemThumb != null) {
						elemThumb.removeChild(elemThumb.childNodes[0]);
						var elemSpanP = document.createElement('span');
						strId = 'pinVehThumb' + vehId;
						elemSpanP.setAttribute('id', strId);
						var elemSpanIconP = document.createElement('span');
						elemSpanIconP.setAttribute('class', 'fa fa-picture-o');
						elemSpanP.appendChild(elemSpanIconP);
						elemThumb.appendChild(elemSpanP);
						strId = 'pinVehThumb' + vehId
						elemThumb.setAttribute('id', strId);
					}
				},
				error: function(jqXHR, textStatus, errorThrown) {
					document.getElementById('execResult').innerHTML = jqXHR.responseText;
					console.log("ERROR : ", jqXHR.responseText);
				}
			});

		}
	});
	


	// Button to replace existing picture
	$(".replBtn").click(function(event) {
		var button = event.target;
		var pictId = button.getAttribute("id");
		var vehId = document.getElementById('modalPictsVehId').innerHTML
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		if (confirm('Proceed to replace Picture [' + pictId + '] with the new picture for Vehicle [' + vehId + ']?')) {
			document.getElementById('id').value = pictId;  // inject picture id into the form
			var form = $('#uploadPictForm')[0];
			var formData = new FormData(form);

			// DO POST
			$.ajax({
				type: "POST",
				enctype: "multipart/form-data",
				url: "/vehReplPictJs",
				data: formData,
				// prevent jQuery from automatically transforming the data into a query string
				processData: false,
				contentType: false,
				cache: false,
				timeout: 1000000,
				success: function(formData, textStatus, jqXHR) {
					document.getElementById('execResult').innerHTML = 'New Picture uploaded successfully and replaced old picture.';
					console.log("SUCCESS : ", formData);
					var newPictId = pictId;
					$("#uploadPictForm")[0].reset();
					document.getElementById('thumbnail').removeAttribute('src');
					document.getElementById('entityId').value = vehId;

					// the new picture has the same pictId.  The following thus does not actually change anything.
					// but it does cause the browser to reload the picture, which is necessary as it is a different picture
					// with the same old pictId.
					var imgDivP = document.getElementById('divPict' + pictId);
					var elemTmp = imgDivP.children[0];
					elemTmp.setAttribute('src', '/pictGet/' + newPictId);

					// the thumbnails on the list screen has to updated too.
					var strId = 'vehThumb' + vehId + '_' + pictId;
					var elemThumb = document.getElementById(strId);
					if (elemThumb != null) {
						elemThumb.children[0].setAttribute('src', '/pictGet/' + pictId);
					}
					strId = 'pinVehThumb' + vehId + '_' + pictId;
					elemThumb = document.getElementById(strId);
					if (elemThumb != null) {
						elemThumb.children[0].setAttribute('src', '/pictGet/' + pictId);
					}
				},
				error: function(jqXHR, textStatus, errorThrown) {
					document.getElementById('execResult').innerHTML = jqXHR.responseText;
					console.log("ERROR : ", jqXHR.responseText);
				}
			});
		}
	});




	// Button to replace profile picture
	$(".profBtn").click(function(event) {
		var button = event.target;
		var pictId = button.getAttribute("id");
		var vehId = document.getElementById('modalPictsVehId').innerHTML
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		if (confirm('Proceed to set Picture [' + pictId + '] as the profile picture for Vehicle [' + vehId + ']?')) {
			// DO GET
			$.ajax({
				type: "GET",
				url: "/vehProfPictJs/" + pictId,
				// prevent jQuery from automatically transforming the data into a query string
				processData: false,
				contentType: false,
				cache: false,
				timeout: 1000000,
				success: function(formData, textStatus, jqXHR) {
					document.getElementById('execResult').innerHTML = 'Profile Picture changed.';
					console.log("SUCCESS : ", formData);
					var oldProfPictId = formData;

					var imgDivP = document.getElementById('divPict' + oldProfPictId);
					if (imgDivP != null) {
	                    // unhide the set-profile button of the last profile picture.
						imgDivP.children[2].removeAttribute('hidden');
					}
                    // hide the set-profile button of the new profile picture.
					document.getElementById('divPict' + pictId).children[2].setAttribute('hidden', 'true');
					// change the profile picture thumbnail on the list screen
					var strId = 'vehThumb' + vehId;
					if (oldProfPictId!="0") {
						strId = strId + '_' + oldProfPictId;
					}
					var elemThumb = document.getElementById(strId);
					if (elemThumb != null) {
						strId = 'vehThumb' + vehId + '_' + pictId;
						elemThumb.setAttribute('id', strId);
						elemThumb.removeChild(elemThumb.firstChild); // remove the first (only child) which may be a icon class or an image
						var elemImg = document.createElement('img');
						elemImg.setAttribute('src', '/pictGet/' + pictId);
						elemImg.setAttribute('width', '50');
						elemThumb.appendChild(elemImg);
					}
					strId = 'pinVehThumb' + vehId;
					if (oldProfPictId!="0") {
						strId = strId + '_' + oldProfPictId;
					}
					var elemThumb = document.getElementById(strId);
					if (elemThumb != null) {
						strId = 'pinVehThumb' + vehId + '_' + pictId;
						elemThumb.setAttribute('id', strId);
						elemThumb.removeChild(elemThumb.firstChild); // remove the first (only child) which may be a icon class or an image
						var elemImgT = document.createElement('img');
						elemImgT.setAttribute('src', '/pictGet/' + pictId);
						elemImgT.setAttribute('width', '50');
						elemThumb.appendChild(elemImgT);
					}
					
				},
				error: function(jqXHR, textStatus, errorThrown) {
					document.getElementById('execResult').innerHTML = jqXHR.responseText;
					console.log("ERROR : ", jqXHR.responseText);
				}
			});
		}
	});




	function ajaxSubmitAdd() {
		// add a picture
		var form = $('#uploadPictForm')[0];
		var formData = new FormData(form);
		var vehId = document.getElementById('entityId').value;

		// DO POST
		$.ajax({
			type: "POST",
			enctype: "multipart/form-data",
			url: "/vehAddPictJs",
			data: formData,
			// prevent jQuery from automatically transforming the data into a query string
			processData: false,
			contentType: false,
			cache: false,
			timeout: 1000000,
			success: function(formData, textStatus, jqXHR) {
				document.getElementById('execResult').innerHTML = 'New picture uploaded successfully.';
				console.log("SUCCESS : ", formData);
				var pictId = formData;
				$("#addBtn").prop("disabled", false);
				$("#uploadPictForm")[0].reset();
				document.getElementById('entityId').value = vehId;

				var imgDivP = document.createElement('div');
				imgDivP.setAttribute('id', 'divPict' + pictId);

				var elemImg = document.createElement('img');
				elemImg.setAttribute('src', '/pictGet/' + pictId);
				elemImg.setAttribute('width', '400');
				imgDivP.appendChild(elemImg);

				var elemBr = document.createElement('br');
				imgDivP.appendChild(elemBr);

//              These buttons, created after the document model is loaded, failed to be associated with the
//              methods defined for similar buttons in the other div.  As such, they will not be created here.
//              upon page reload, all buttons will be created properly.  
//				var elemBtn1 = document.createElement('button');
//				elemBtn1.setAttribute('type', 'Submit');
//				elemBtn1.setAttribute('class', 'profBtn');
//				elemBtn1.setAttribute('id', pictId);
//				elemBtn1.innerText = 'Set profile picture';
//				imgDivP.appendChild(elemBtn1);
//
//				var elemBtn2 = document.createElement('button');
//				elemBtn2.setAttribute('type', 'Submit');
//				elemBtn2.setAttribute('class', 'deleBtn');
//				elemBtn2.setAttribute('id', pictId);
//				var elemSpan = document.createElement('span');
//				elemSpan.setAttribute('class', 'fa fa-trash-o');
//				elemBtn2.appendChild(elemSpan);
//				imgDivP.appendChild(elemBtn2);
//
//				var elemBtn3 = document.createElement('button');
//				elemBtn3.setAttribute('type', 'Submit');
//				elemBtn3.setAttribute('class', 'replBtn');
//				elemBtn3.setAttribute('id', pictId);
//				elemBtn3.innerText = 'Replace';
//				imgDivP.appendChild(elemBtn3);

				var elemHr = document.createElement('hr');
				imgDivP.appendChild(elemHr);

				var imgDiv = document.createElement('div');
				imgDiv.appendChild(imgDivP);

				document.getElementById('modalPictSrc').appendChild(imgDiv);

				$("#uploadPictForm")[0].reset();
				document.getElementById('entityId').value = vehId;
				document.getElementById('thumbnail').removeAttribute('src');

			},
			error: function(jqXHR, textStatus, errorThrown) {
				document.getElementById('execResult').innerHTML = jqXHR.responseText;
				console.log("ERROR : ", jqXHR.responseText);
			}
		});
	}



});