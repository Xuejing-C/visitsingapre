// get parameter value from url
function getParameter(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    // location.search = "?xxx=xxx&xxx=xxx"
    var r = location.search.substr(1).match(reg);
    if (r!=null) return (r[2]);
    return null;
}