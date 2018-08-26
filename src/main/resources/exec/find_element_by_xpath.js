function find(xpath){
  var evaluator = new XPathEvaluator(); 
  var result = evaluator.evaluate(xpath, document.documentElement, null,XPathResult.ORDERED_NODE_ITERATOR_TYPE, null);
  var xnodes = [];
  var xres;
  while (xres = result.iterateNext()) {
    xnodes.push(xres);
  }
  return xnodes[0];
}
return find(arguments[0]);