function setChange(optionChange){
	var quantity = document.getElementById('quantity');
	if (quantity.value == 1){
		if(optionChange == 'reduce'){
			quantity.value = 1;
		}
		else if(optionChange == 'increase'){
			quantity.value++;
		}
	}
	else {
		if(optionChange == 'reduce'){
			quantity.value--;
		}
		else if(optionChange == 'increase'){
			quantity.value++;
		}
	}
}
function openAction(evt, actionName) {

  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace("active", "");
  }
  document.getElementById(actionName).style.display = "block";
  evt.currentTarget.className += " active";
}
