/**
 * 
 */
var pictModal = document.getElementById('pictModal')
pictModal.addEventListener('show.bs.modal', function (event) {
  // Button that triggered the modal
  var button = event.relatedTarget;
  // Extract info from data-bs-* attributes
  var custName = button.getAttribute('data-bs-custName');
  var custId = button.getAttribute('data-bs-custId');
  var pictId = button.getAttribute('data-bs-pictId');
  
  var imgDiv = document.getElementById("modalPictSrc");
  while (imgDiv.hasChildNodes()) {imgDiv.removeChild(imgDiv.firstChild);}
  var elemImg = document.createElement('img')
  if (pictId!='0') {
    elemImg.setAttribute('src', '/pictGet/' + pictId);
    elemImg.setAttribute('width', '400');
    imgDiv.appendChild(elemImg);
    document.getElementById('modalPictRmv').removeAttribute('hidden');
    document.getElementById('uploadPictBtn').innerHTML='Replace with new picture';
    document.getElementById('id').value = pictId;
    document.getElementById('entityId').value = custId;
  }
  else {
    document.getElementById('modalPictRmv').setAttribute('hidden', 'true');
    document.getElementById('uploadPictBtn').innerHTML='Upload a picture';
    document.getElementById('id').value = "0";
    document.getElementById('entityId').value = custId;
  }
  document.getElementById('modalCustName').innerHTML = custName;
  document.getElementById('execResult').innerHTML = '';
})

pictModal.addEventListener('hide.bs.modal', function (event) {
			document.getElementById('thumbnail').setAttribute('src', '');
  $("#uploadPictForm")[0].reset();
})




//https://o7planning.org/11813/spring-boot-file-upload-with-jquery-ajax
$(document).ready(function() {
	// Submit form to upload new picture
	$("#uploadBtn").click(function(event) {
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			ajaxSubmitForm();
		});
	// Button to delete existing picture
	$("#deleteBtn").click(function(event) {
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			ajaxDelePict();
		});
	});

function ajaxSubmitForm() {
	// Get form
	var form = $('#uploadPictForm')[0];
	var formData = new FormData(form);
	var custId = document.getElementById('entityId').value;
	$("#uploadBtn").prop("disabled", true);

	// DO POST
	$.ajax({
		type : "POST",
		enctype : "multipart/form-data",
		url : "/custSavePictJs",
		data : formData,
		// prevent jQuery from automatically transforming the data into a query string
        processData: false,
        contentType: false,
        cache: false,
        timeout: 1000000,
        success: function(formData, textStatus, jqXHR) {
		    document.getElementById('execResult').innerHTML='New picture uploaded successfully.';
			document.getElementById('uploadPictBtn').innerHTML='Replace with new picture';
			console.log("SUCCESS : ", formData);
			$("#uploadBtn").prop("disabled", false);
			$("#uploadPictForm")[0].reset();
		    document.getElementById('modalPictRmv').removeAttribute('hidden');
	        document.getElementById('id').value = formData;
	        document.getElementById('entityId').value = custId;
            $("#modalPictSrc").html("<img src='/pictGet/"+ formData + "' width='400'>");
			if (document.getElementById("custThumb"+custId)!=null) {
	            $("#custThumb"+custId).html("<img src='/pictGet/"+ formData + "' width='50'>");
    	        document.getElementById("custThumb"+custId).setAttribute("data-bs-pictid", formData);
			}
			if (document.getElementById("pinCustThumb"+custId)!=null) {
	            $("#pinCustThumb"+custId).html("<img src='/pictGet/"+ formData + "' width='50'>");
    	        document.getElementById("pinCustThumb"+custId).setAttribute("data-bs-pictid", formData);
			}
			document.getElementById('thumbnail').removeAttribute('src');
		},
		error : function(jqXHR, textStatus, errorThrown) {
		    document.getElementById('execResult').innerHTML=jqXHR.responseText;
            console.log("ERROR : ", jqXHR.responseText);
            $("#uploadBtn").prop("disabled", false);
		}
	});
}

function ajaxDelePict() {
    if (confirm('Proceed to delete this picture?')) {
		var custId = document.getElementById('entityId').value;
		$("#modalPictRmv").prop("hidden", true);
	
		// DO GET
		$.ajax({
			type : "GET",
			url : "/custRmvPictJs/" + custId,
	        success: function(formData, textStatus, jqXHR) {
			    document.getElementById('execResult').innerHTML='Picture deleted successfully.';
			    document.getElementById('uploadPictBtn').innerHTML='Upload a picture';
		        document.getElementById('id').value = "0";
				
				console.log("SUCCESS : ", formData);
				//document.getElementById('modalPictRmv').setAttribute('hidden', 'true');
				var elemTmp = document.getElementById('modalPictSrc');
	            elemTmp.removeChild(elemTmp.childNodes[0]);
				if (document.getElementById("custThumb"+custId)!=null) {
		            $("#custThumb"+custId).html("<span class='fa fa-id-card-o'></span>");
	    	        document.getElementById("custThumb"+custId).setAttribute("data-bs-pictid", "0");
				}
				if (document.getElementById("pinCustThumb"+custId)!=null) {
		            $("#pinCustThumb"+custId).html("<span class='fa fa-id-card-o'></span>");
	    	        document.getElementById("pinCustThumb"+custId).setAttribute("data-bs-pictid", "0");
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				document.getElementById('modalPictRmv').setAttribute('hidden', 'false');
			    document.getElementById('execResult').innerHTML=jqXHR.responseText;
	            console.log("ERROR : ", jqXHR.responseText);
			}
		});

	}
}
