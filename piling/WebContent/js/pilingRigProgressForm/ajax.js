function getHTTPObject ()
{
    var http_req = null ;

    if (window.XMLHttpRequest)
    {
        http_req = new XMLHttpRequest () ;
    }
    else if (window.ActiveXObject)
    {
        try
        {
            http_req = new ActiveXObject ("Msxml2.XMLHTTP") ;
        }
        catch (e)
        {
            try
            {
                http_req = new ActiveXObject ("Microsoft.XMLHTTP") ;
            }
            catch (e) { }
        }
    }

    if (http_req == null)
    {
        alert ("Hi, your browser is not worth it.") ;
    }

    return (http_req) ;
}
/**********************************************************************************************/
var idleIndex = 1;


var idleHourStart=1;
var idleMinuteStart=1;
var idleHourEnd=1;
var idleMinuteEnd=1;

function addIdleTime(){

	var http = getHTTPObject() ; 
	var srcTable = document.getElementById('pilingIdle_det') ;
	var rowId='id'+idleIndex;
	var srcRow = tableAPI.addTableRow (srcTable, rowId) ;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addLabel (srcCell, 'idleIndex'+idleIndex, 'Idle Time Start(HH:MM)'  )

	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addHour(srcCell, 'idleHourStart'+idleIndex, 'idleHourStart'+idleIndex,''); 
	idleHourStart++;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addMinute(srcCell, 'idleMinuteStart'+idleIndex, 'idleMinuteStart'+idleIndex,''); 
	idleMinuteStart++;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addLabel (srcCell, 'idleHourCell'+idleIndex, ''  );
	
	
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addLabel (srcCell, 'idleHourIndex'+idleIndex, 'Idle Time End(HH:MM)'  )
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addHour(srcCell, 'idleHourEnd'+idleIndex, 'idleHourEnd'+idleIndex,''); 
	idleHourEnd++;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addMinute(srcCell, 'idleMinuteEnd'+idleIndex, 'idleMinuteEnd'+idleIndex,''); 
	idleMinuteEnd++;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'right', null, null) ;
	var image = tableAPI.addImage(srcCell, rowId, rowId, "12", "12", "images/cross.gif") ;
	image.onclick = function () {removeRowIdle(srcTable, rowId) ;} ;
	    


	

	idleIndex++;

    
}

function setIdleTime(){
	if(idleIndex>1){
	for(var i=1;i<idleIndex;i++){
		
		var idleHourStart=document.getElementById("idleHourStart"+i).value;
		var idleMinuteStart=document.getElementById("idleMinuteStart"+i).value;
		var idleHourEnd=document.getElementById("idleHourEnd"+i).value;
		var idleMinuteEnd=document.getElementById("idleMinuteEnd"+i).value;

		updateIdleTime(idleHourStart,idleMinuteStart,idleHourEnd,idleMinuteEnd);
		}
	idleIndex=1;
	}
}
function updateIdleTime(idleHourStart,idleMinuteStart,idleHourEnd,idleMinuteEnd){
    var http = getHTTPObject () ;
    if (http != null)
    {
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpIdleTime (http) ; } ;
        http.open ("POST", "pilingRigProgressForm.htm?_target5=idleTime&idleHourStart="+idleHourStart+"&idleMinuteStart="+idleMinuteStart+"&idleHourEnd="+idleHourEnd+"&idleMinuteEnd="+idleMinuteEnd);
        http.send (null) ; 
    }
}
function handleHttpIdleTime (http_req)
{
	http_req.Close ;
}

function removeRowIdle (srcTable, row_id) 
{

    removeRow(srcTable, row_id) ;
    
}



/**********************************************************************************************/
var breakdownIndex = 1;


var breakdownHourStart=1;
var breakdownMinuteStart=1;
var breakdownHourEnd=1;
var breakdownMinuteEnd=1;


function addBreakdownTime(){

	var http = getHTTPObject() ; 
	var srcTable = document.getElementById('pilingBreakdown_det') ;
	var rowId='idB'+breakdownIndex;
	var srcRow = tableAPI.addTableRow (srcTable, rowId) ;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addLabel (srcCell, 'breakdownIndex'+breakdownIndex, 'Breakdown Time Start(HH:MM)'  )

	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addHour(srcCell, 'breakdownHourStart'+breakdownIndex, 'breakdownHourStart'+breakdownIndex,''); 
	breakdownHourStart++;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addMinute(srcCell, 'breakdownMinuteStart'+breakdownIndex, 'breakdownMinuteStart'+breakdownIndex,''); 
	breakdownMinuteStart++;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addLabel (srcCell, 'breakdownHourCell'+breakdownIndex, ''  );
	
	
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addLabel (srcCell, 'breakdownHourIndex'+breakdownIndex, 'Breakdown Time End(HH:MM)'  )
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addHour(srcCell, 'breakdownHourEnd'+breakdownIndex, 'breakdownHourEnd'+breakdownIndex,''); 
	breakdownHourEnd++;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addMinute(srcCell, 'breakdownMinuteEnd'+breakdownIndex, 'breakdownMinuteEnd'+breakdownIndex,''); 
	breakdownMinuteEnd++;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'right', null, null) ;
	var image = tableAPI.addImage(srcCell, rowId, rowId, "12", "12", "images/cross.gif") ;
	image.onclick = function () {removeRowBreakdown(srcTable, rowId) ;} ;
	    


	

	breakdownIndex++;

    
}

function setBreakdownTime(){

	if(breakdownIndex>1){
	for(var i=1;i<breakdownIndex;i++){
		
		var breakdownHourStart=document.getElementById("breakdownHourStart"+i).value;
		var breakdownMinuteStart=document.getElementById("breakdownMinuteStart"+i).value;
		var breakdownHourEnd=document.getElementById("breakdownHourEnd"+i).value;
		var breakdownMinuteEnd=document.getElementById("breakdownMinuteEnd"+i).value;

		updateBreakdownTime(breakdownHourStart,breakdownMinuteStart,breakdownHourEnd,breakdownMinuteEnd);
		}
	breakdownIndex=1;
	}
}
function updateBreakdownTime(breakdownHourStart,breakdownMinuteStart,breakdownHourEnd,breakdownMinuteEnd){
    var http = getHTTPObject () ;
    if (http != null)
    {
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpBreakdownTime (http) ; } ;
        http.open ("POST", "pilingRigProgressForm.htm?_target6=breakdownTime&breakdownHourStart="+breakdownHourStart+"&breakdownMinuteStart="+breakdownMinuteStart+"&breakdownHourEnd="+breakdownHourEnd+"&breakdownMinuteEnd="+breakdownMinuteEnd);
        http.send (null) ; 
    }

}
function handleHttpBreakdownTime (http_req)
{
	http_req.Close ;
}

function removeRowBreakdown (srcTable, row_id) 
{

    removeRow(srcTable, row_id) ;
    
}







/**********************************************************************************************/
var movementIndex = 1;


var movementHourStart=1;
var movementMinuteStart=1;
var movementHourEnd=1;
var movementMinuteEnd=1;


function addMovementTime(){

	var http = getHTTPObject() ; 
	var srcTable = document.getElementById('pilingMovement_det') ;
	var rowId='idM'+movementIndex;
	var srcRow = tableAPI.addTableRow (srcTable, rowId) ;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addLabel (srcCell, 'movementIndex'+movementIndex, 'Movement Time Start(HH:MM)'  )

	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addHour(srcCell, 'movementHourStart'+movementIndex, 'movementHourStart'+movementIndex,''); 
	movementHourStart++;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addMinute(srcCell, 'movementMinuteStart'+movementIndex, 'movementMinuteStart'+movementIndex,''); 
	movementMinuteStart++;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addLabel (srcCell, 'movementHourCell'+movementIndex, ''  );
	
	
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addLabel (srcCell, 'movementHourIndex'+movementIndex, 'Movement Time End(HH:MM)'  )
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addHour(srcCell, 'movementHourEnd'+movementIndex, 'movementHourEnd'+movementIndex,''); 
	movementHourEnd++;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'left', null, null) ;
	addMinute(srcCell, 'movementMinuteEnd'+movementIndex, 'movementMinuteEnd'+movementIndex,''); 
	movementMinuteEnd++;
	
	var srcCell = tableAPI.addTableCell(srcRow, null, 'right', null, null) ;
	var image = tableAPI.addImage(srcCell, rowId, rowId, "12", "12", "images/cross.gif") ;
	image.onclick = function () {removeRowMovement(srcTable, rowId) ;} ;
	    


	

	movementIndex++;

    
}

function setMovementTime(){

	if(movementIndex>1){
		
	for(var i=1;i<movementIndex;i++){
		
		var movementHourStart=document.getElementById("movementHourStart"+i).value;
		var movementMinuteStart=document.getElementById("movementMinuteStart"+i).value;
		var movementHourEnd=document.getElementById("movementHourEnd"+i).value;
		var movementMinuteEnd=document.getElementById("movementMinuteEnd"+i).value;

		updateMovementTime(movementHourStart,movementMinuteStart,movementHourEnd,movementMinuteEnd);
		}

	movementIndex=1;
	}
}
function updateMovementTime(movementHourStart,movementMinuteStart,movementHourEnd,movementMinuteEnd){
    var http = getHTTPObject () ;

    if (http != null)
    {
        var random = Math.random () ;
        http.onreadystatechange = function () { handleHttpMovementTime (http) ; } ;
        http.open ("POST", "pilingRigProgressForm.htm?_target7=mvementTime&movementHourStart="+movementHourStart+"&movementMinuteStart="+movementMinuteStart+"&movementHourEnd="+movementHourEnd+"&movementMinuteEnd="+movementMinuteEnd);
        http.send (null) ; 
    }

}
function handleHttpMovementTime (http_req)
{
	http_req.Close ;
}

function removeRowMovement (srcTable, row_id) 
{

    removeRow(srcTable, row_id) ;
    
}



