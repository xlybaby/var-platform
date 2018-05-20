function findElementByUserClickPosition(parent, x, y, curdeep, stopdeep) {
	curdeep++;
	if ( stopdeep > 0 && curdeep >= stopdeep )
		return parent;
	var children = parent.childNodes;
	for(var i=0; i<children.length; i++) {
		var child = children[i];
		if (!child.getBoundingClientRect)
			continue;
		var rect = child.getBoundingClientRect();
		var left = rect['x'];
		var top;
		var width = rect['width'];
		var height = rect['height'];
		var offsetTop = child.offsetTop;
		if (width < 0 || height < 0)
			continue;
  		if (child.style.display=="none" || child.style.visible=="hidden")
  			continue;
		if ( (left+width) < x)
			continue;
    	var absy = 0;
    	var current = child;
    	while(current) {
        	absy += current.offsetTop;
        	current = current.offsetParent;
    	}
    	if ( (absy+height) < y ) {
    		continue;
    	}
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
return startFindElementByUserClickPosition(arguments[0],arguments[1],arguments[2],arguments[3]);