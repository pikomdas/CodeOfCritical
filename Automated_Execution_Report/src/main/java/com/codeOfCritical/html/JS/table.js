/**
 Expand Header
 */
$(document).ready(function () {
	//Fixing jQuery Click Events for the iPad
	var ua = navigator.userAgent,
		event = (ua.match(/iPad/i)) ? "touchstart" : "click";

	if ($('.table>tbody>tr').length > 0) {
		$('.table .header').on(event, function () {

			// Showing position names only not Deviations
			console.log("showing Position");
			$(this).toggleClass("active", "").nextUntil('.header').not('.Deviation').css('display', function (i, v) {
				return this.style.display === 'table-row' ? 'none' : 'table-row';
			});

			/**
			 Hide all <tr> after clicking on .header.active
			 */

		});

	} else {
		alert("No Deviation is found");
	}
})

/**
 Expand Deviation
 */
$(document).ready(function () {
	//Fixing jQuery Click Events for the iPad
	var ua = navigator.userAgent,
		event = (ua.match(/iPad/i)) ? "touchstart" : "click";

	$('.table .Entity').on(event, function () {
		console.log("showing deviations")
		$(this).next().toggleClass("active", "").nextUntil('.Entity').css('display', function (i, v) {
			return this.style.display === 'table-row' ? 'none' : 'table-row';
		});
	})
})

/**
 Appending count
 */
$(document).ready(function () {

	// Adding count of positions
	$('.table .header').each(function () {
		var n = $(this).nextUntil('.header').not('.Deviation').not('.gallery').length;
		$(this).children('td').append(" <p class=\"count\">Position Count: " + n + "</p>");
	});

	// Adding count of Deviations
	$('.table .Entity').each(function () {
		var n = $(this).nextUntil('.Entity').not('.gallery').length - 1;
		$(this).children(':first-child').append(" <p class=\"count\">Deviation Count: " + n + "</p>");
	});

})

/* full header collpase */
/*$(document).ready(function() {
	//Fixing jQuery Click Events for the iPad
	var ua = navigator.userAgent,
		event = (ua.match(/iPad/i)) ? "touchstart" : "click";
	$('.table .header.active').on(event, function() {

		console.log("in 3rd");
		//$(this).removeClass('active');
		$(this).nextUntil('.header').css('display', 'none');
	})

})*/