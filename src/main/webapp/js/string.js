String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};
String.prototype.isEmpty = function(){
	return this.trim()=="";
};