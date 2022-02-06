var allModal = document.getElementsByClassName("modal");
var x;
for (x = 0; x < allModal.length; x++) {

	// Get the image and insert it inside the modal - use its "alt" text as a caption
	var currentModal = document.getElementsByClassName("modal")[x];
	var img = document.getElementsByClassName("myImg")[x];
	var modalImg = document.getElementsByClassName("modal-content")[x];
	modalImg.src = img.src;

	img.onclick = function() {
		currentModal.style.display = "block";
		//modalImg.src = img.src;

	}

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[x];

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		currentModal.style.display = "none";
	}
}

function reply_click(clicked_id) {
	var modal = document.getElementById(clicked_id);
	console.log(modal.id + " hiii");
	modal.style.display = "block";
}