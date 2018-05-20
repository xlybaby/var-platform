function getInternalClickPosition(event, obj) {
	//alert(event.pageX + "," + event.pageY);
	var x = event.pageX;
	var y = event.pageY;
	$.ajax({
        type: "POST",
        url: "template/locateone",
        data: JSON.stringify({"locateX": x, "locateY": y}),
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function(data){
                    console.log(data);
                 }
    });
}

function findElementByUserClickPosition(parent, x, y, curdeep, stopdeep) {
	curdeep++;

	if ( stopdeep > 0 && curdeep >= stopdeep )
		return parent;

	var children = parent.childNodes;
	for(var i=0; i<children.length; i++) {
		var child = children[i];
		//STEP 0. has getBoundingClientRect
		if (!child.getBoundingClientRect)
			continue;

		var rect = child.getBoundingClientRect();
		var left = rect['x'];
		var top;
		//var y = rect['y'];
		var width = rect['width'];
		var height = rect['height'];
		//var offsetLeft = child.offsetLeft;
		var offsetTop = child.offsetTop;
		
		//STEP 1. width and height are both not zero, greater than zero
		if (width < 0 || height < 0)
			continue;
		
		//STEP 2. is visible?
  		if (child.style.display=="none" || child.style.visible=="hidden")
  			continue;

		//STEP 3. x+width cover element's position?
		if ( (left+width) < x)
			continue;

		//STEP 4. y+height cover element's position?
    	var absy = 0;
    	var current = child;
    	while(current) {
        	absy += current.offsetTop;
        	current = current.offsetParent;
    	}
    	if ( (absy+height) < y ) {
    		continue;
    	}

		//STEP 5. is leaf node(whick contains no elements' node)
		var hasEleChild=false;
		var allChild = child.childNodes;
		for(var j=0;j<allChild.length;j++) {
			if (allChild[j].nodeType==1){
				hasEleChild=true;
				break;
			}
		}
		if (hasEleChild)
			return findElementByUserClickPosition(child, x, y, curdeep, stopdeep);
		else
			return child;
	}

	return parent;
}

function startFindElementByUserClickPosition(x, y, curdeep, stopdeep) {
	var ebody = document.getElementsByTagName("body");
	var target;
	if ( ebody && ebody.length > 0 )
		target = findElementByUserClickPosition(ebody[0], x, y, 0, -1);

	return target;
}

startFindElementByUserClickPosition(800, 650, 0, -1);