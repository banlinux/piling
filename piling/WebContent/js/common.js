/**
 * 
 */

function getHTTPObject() {
    var http_req = null ;
    
    if (window.XMLHttpRequest) {
        http_req = new XMLHttpRequest() ;
    }
    else if (window.ActiveXObject) {
        try {
            http_req = new ActiveXObject("Msxml2.XMLHTTP") ;
        }
        catch (e) {
            try {
                http_req = new ActiveXObject("Microsoft.XMLHTTP") ;
            }
            catch (e) {}
        }
    }
    if (http_req == null) {
        alert("Hi, your browser is not worth it.") ;
    }
    
    return (http_req) ;
}