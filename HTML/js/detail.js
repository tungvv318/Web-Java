function setChange(optionChange){
	var quantity = document.getElementById('quantity');
	if (quantity.value==1){
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