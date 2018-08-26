function getPathTo(element) {
    if (element.id!=='')
        return '[@id="'+element.id+'"]';
    if (element.tagName.toLowerCase()=="body")
        return "/html/"+element.tagName;

    var ix= 0;
    var siblings= element.parentNode.childNodes;
    for (var i= 0; i<siblings.length; i++) {
        var sibling= siblings[i];
        if (sibling===element)
            return getPathTo(element.parentNode)+'/'+element.tagName+'['+(ix+1)+']';
        if (sibling.nodeType===1 && sibling.tagName===element.tagName)
            ix++;
    }
}
function findElementsXPath(element) {
	if (element.nodeType !== 1)
		return null;
	var tag = element.tagName;
	console.log(tag);
	if (tag.toLowerCase() == "body") 
		return "/html/body";
	var path = getPathTo(element);
	if (path)
		path = path.toLowerCase();
	if ( path.indexOf("/html/") == 0 )
		return path;
	else
		return "//*"+path;
}
return findElementsXPath(arguments[0]);