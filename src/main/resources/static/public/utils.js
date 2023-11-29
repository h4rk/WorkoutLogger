function clear_inputs(classname){
	Array.from(document.getElementsByClassName(classname)).forEach(
    	function(element, index, array) {
        	element.value = '';
    	}
	);
}