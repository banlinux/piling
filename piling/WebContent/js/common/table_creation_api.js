

var tableAPI = 
{
    ////////////////////////////////////////////////////////////////////////////
    //  <tr></tr>
    ////////////////////////////////////////////////////////////////////////////
    addTableRow:function (srcTable, row_id)
    {
        var srcRow = null ;
    
        if (srcTable != null)
        {
            srcRow = document.createElement ('tr') ; 
            srcRow.setAttribute ('id', row_id) ;        // set the id of the row to the actual value
    
            srcTable.appendChild (srcRow) ;
        }
        else
        {
            alert("Error while creating table. Cause: Container row is null!");
        }
    
        return (srcRow) ;
    },

    ////////////////////////////////////////////////////////////////////////////
    //  <td></td>
    ////////////////////////////////////////////////////////////////////////////
    addTableCell:function (srcRow, cell_id, align, width, height)
    {
        var srcCell = null ;
    
        if (srcRow != null)
        {
            srcCell = document.createElement ('td') ;

            srcCell.setAttribute ('align', align) ;
            srcCell.setAttribute ('width', width) ;
            srcCell.setAttribute ('height', height) ;
            srcCell.setAttribute ('id', cell_id) ;
            srcCell.setAttribute ('name', cell_id) ; 

            srcRow.appendChild (srcCell) ;
         }
        else
        {
            alert("Error while creating Cell!");
        }

        return (srcCell) ;
    },

    ////////////////////////////////////////////////////////////////////////////
    //  <td><a></a></td>
    ////////////////////////////////////////////////////////////////////////////
    addLinkCell:function (srcRow, cell_id, align, width, height, linkURL)
    {
        var srcCell = null ;
        var link = null ;

        if (srcRow != null)
        {
            srcCell = document.createElement ('td') ;

            srcCell.setAttribute ('align', align) ;
            srcCell.setAttribute ('width', width) ;
            srcCell.setAttribute ('height', height) ;

            srcRow.appendChild (srcCell) ;

            link = document.createElement ('a') ;
            link.setAttribute ('id', cell_id) ;
            link.href = linkURL ;

            srcCell.appendChild (link) ;
         }
        else
        {
            alert("Error while creating Cell!");
        }

        return (link) ;
    },

    ////////////////////////////////////////////////////////////////////////////
    //  <input>
    ////////////////////////////////////////////////////////////////////////////
    addTextBox:function (srcCell, id, name, type, value, class_name)
    {
        var text_box = null ;

        if (srcCell != null)
        {
            if (document.all)
            {
                text_box = document.createElement ('<input name="' + name + '">') ;
            }
            else
            {
                text_box = document.createElement ('input') ;
                text_box.setAttribute ('name', name) ;
            }

            text_box.setAttribute ('type', type) ;
            text_box.setAttribute ('id', id) ;
            text_box.value = value ;
            text_box.className = class_name ;

            srcCell.appendChild (text_box) ;
        } 
        else
        {
            alert("Error while creating Text Box!");
        }

        return (text_box) ;
    },

    ////////////////////////////////////////////////////////////////////////////
    //  <label></label>
    ////////////////////////////////////////////////////////////////////////////
    addLabel:function (srcCell, id, text, forElementName)
    {
        switch (arguments.length)
        {
            case 3:
                return (tableAPI.addLabel2 (srcCell, id, text)) ;
                break ;
            case 4:
                return (tableAPI.addLabel1 (srcCell, id, text, forElementName)) ;
                break ;
        }

        return (null) ;
    },

    addLabel1:function (srcCell, id, text, forElementName)
    {
        var label = null ;

        if(srcCell != null)
        {
            label = document.createElement ('label') ;
            label.setAttribute ('id', id) ;
            label.setAttribute('class', 'labeltext');
            label.htmlFor = forElementName ;
            label.appendChild (document.createTextNode (text)) ;
        
            srcCell.appendChild (label) ;
        }
        else
        {
            alert("Error while creating Label!");
        }

        return (label) ;
    },

    addLabel2:function (srcCell, id, text)
    {
        var label = null ;
    
        if(srcCell != null)
        {
            label = document.createElement ('label') ;
            label.setAttribute ('id', id) ;
            label.setAttribute('class', 'labeltext');
            label.appendChild (document.createTextNode (text)) ;
        
            srcCell.appendChild (label) ;
        }
        else
        {
            alert("Error while creating Label!");
        }

        return (label) ;
    },

    ////////////////////////////////////////////////////////////////////////////
    //  <span></span>
    ////////////////////////////////////////////////////////////////////////////
    addSpan:function (srcCell, id, text)
    {
        var label = null ;

        if(srcCell != null)
        {
            label = document.createElement ('span') ;
            label.setAttribute ('id', id) ;
            label.appendChild (document.createTextNode (text)) ;

            srcCell.appendChild (label) ;
        }
        else
        {
            alert("Error while creating Span!");
        }

        return (label) ;
    },

    ////////////////////////////////////////////////////////////////////////////
    //  <input type='checkbox'></input>
    ////////////////////////////////////////////////////////////////////////////
    addCheckBox:function (srcCell, id, name, status)
    {
        var check_box = null ;

        if (srcCell != null)
        {
            if (document.all)
            {
                check_box = document.createElement ('<input name="' + name + '">') ;
            }
            else
            {
                check_box = document.createElement ('input') ;
                check_box.setAttribute ('name', name) ;
            }

            check_box.setAttribute ('type', 'checkbox') ;
            check_box.setAttribute ('id', id) ;
            check_box.checked = status ;

            srcCell.appendChild (check_box) ;
        }
        else
        {
            alert("Error while creating Text Box!");
        }

        return (check_box) ;
    },
    addCheckBoxSelectAll:function (srcCell, id, name, status,attribute)///MILAN DUTTA ;Select All check Box
    {
        var check_box = null ;

        if (srcCell != null)
        {
            if (document.all)
            {
                check_box = document.createElement ('<input name="' + name + '">') ;
            }
            else
            {
                check_box = document.createElement ('input') ;
                check_box.setAttribute ('name', name) ;
            }

            check_box.setAttribute ('type', 'checkbox') ;
            check_box.setAttribute ('id', id) ;
            check_box.checked = status ;
            check_box.setAttribute('onclick',attribute);
            srcCell.appendChild (check_box) ;
        }
        else
        {
            alert("Error while creating Text Box!");
        }

        return (check_box) ;
    },
    addCheckBoxWithFunction:function (srcCell, id, name, status,attribute)
    {
        var check_box = null ;

        if (srcCell != null)
        {
            if (document.all)
            {
                check_box = document.createElement ('<input name="' + name + '">') ;
            }
            else
            {
                check_box = document.createElement ('input') ;
                check_box.setAttribute ('name', name) ;
            }

            check_box.setAttribute ('type', 'checkbox') ;
            check_box.setAttribute ('id', id) ;
            check_box.checked = status ;
            check_box.setAttribute('onclick',attribute);

            srcCell.appendChild (check_box) ;
        }
        else
        {
            alert("Error while creating Text Box!");
        }

        return (check_box) ;
    },
    ////////////////////////////////////////////////////////////////////////////
    //  <img></img>
    ////////////////////////////////////////////////////////////////////////////
    addImage:function (srcCell, id, name, width, height, image_path)
    {
        var img = null ;

        if(srcCell != null)
        {
            var img = document.createElement ('img') ;

            img.setAttribute ('src', image_path) ;
            img.setAttribute ('width', width) ;
            img.setAttribute ('height', height) ;
            img.setAttribute ('id', id) ;
            img.setAttribute ('name', name) ;
            img.setAttribute ('border', '0') ;
            img.setAttribute('onclick', "showCalendarControl (document.forms[0].exp_period_from2)");
            srcCell.appendChild (img) ;
        }
        else
        {
            alert("Error while creating image!");
        }

        return (img) ;
    },
    ////////////////////////////////////////////////////////////////////////////
    //Date Picker By Milan Dutta											 //	
    ////////////////////////////////////////////////////////////////////////////
    addDatePicker:function (srcCell, id, name, width, height, image_path,position,cell)
    {
        var img = null ;

        if(srcCell != null)
        {
            var img = document.createElement ('img') ;

            img.setAttribute ('src', image_path) ;
            img.setAttribute ('width', width) ;
            img.setAttribute ('height', height) ;
            img.setAttribute ('id', id) ;
            img.setAttribute ('name', name) ;
            img.setAttribute ('border', '0') ;
            img.setAttribute('onclick', "showCalendarControl (document.forms[0]."+cell+position+")");
            srcCell.appendChild (img) ;
        }
        else
        {
            alert("Error while creating image!");
        }

        return (img) ;
    },
    addDatePickerTo:function (srcCell, id, name, width, height, image_path,position)
    {
        var img = null ;

        if(srcCell != null)
        {
            var img = document.createElement ('img') ;

            img.setAttribute ('src', image_path) ;
            img.setAttribute ('width', width) ;
            img.setAttribute ('height', height) ;
            img.setAttribute ('id', id) ;
            img.setAttribute ('name', name) ;
            img.setAttribute ('border', '0') ;
            img.setAttribute('onclick', "showCalendarControl (document.forms[0].exp_period_to"+position+")");
            srcCell.appendChild (img) ;
        }
        else
        {
            alert("Error while creating image!");
        }

        return (img) ;
    },    
    ////////////////////////////////////////////////////////////////////////////
    //  <input type='radio'></input>
    ////////////////////////////////////////////////////////////////////////////
    addRadio:function (srcCell, id, name, value)
    {
        var radio = null ;

        if (srcCell != null)
        {
            if (document.all)
            {
                radio = document.createElement ('<input name="' + name + '">') ;
            }
            else
            {
                radio = document.createElement ('input') ;
                radio.setAttribute ('name', name) ;
            }

            radio.setAttribute ('type', 'radio') ;
            radio.setAttribute ('id', id) ;
            radio.value = value ;

            srcCell.appendChild (radio) ;
        } 
        else
        {
            alert("Error while creating Radio!");
        }

        return (radio) ;
    },
    
////////////////////////////////////////////////////////////////////////////
    //  <input type='button'></input>
    ////////////////////////////////////////////////////////////////////////////
    addButton:function (srcCell, id, name, value)
    {
        var button = null ;

        if (srcCell != null)
        {
            if (document.all)
            {
            	button = document.createElement ('<input name="' + name + '">') ;
            }
            else
            {
            	button = document.createElement ('input') ;
            	button.setAttribute ('name', name) ;
            }

            button.setAttribute ('type', 'button') ;
            button.setAttribute ('id', id) ;
            button.value = value ;

            srcCell.appendChild (button) ;
        } 
        else
        {
            alert("Error while creating Button!");
        }

        return (button) ;
    },

    ////////////////////////////////////////////////////////////////////////////
    //  <embed></embed>
    ////////////////////////////////////////////////////////////////////////////
    embedObject:function (srcCell, id, name, width, height, srcPath)
    {
        var obj = null ;

        if(srcCell != null)
        {
            var img = document.createElement ('embed') ;

            obj.setAttribute ('src', srcPath) ;
            obj.setAttribute ('width', width) ;
            obj.setAttribute ('height', height) ;
            obj.setAttribute ('id', id) ;
            obj.setAttribute ('name', name) ;

            srcCell.appendChild (obj) ;
        }
        else
        {
            alert("Error while creating image!");
        }

        return (obj) ;
    },

    ////////////////////////////////////////////////////////////////////////////
    //  Set The Class of an Element
    ////////////////////////////////////////////////////////////////////////////
    setClass:function (id, className)
    {
        if(id != null)
        {
            document.getElementById (id).className = className ;
        }
        else
        {
            alert("Error while creating image!");
        }
    },

    ////////////////////////////////////////////////////////////////////////////
    //  Remove A Row Of A Table
    ////////////////////////////////////////////////////////////////////////////
    removeRow:function (srcTable, row_id)
    {
        var table = document.getElementById (srcTable) ;

        if (table != null)
        {
            table.removeChild (document.getElementById (srcTable)) ;
        }
    },

    ////////////////////////////////////////////////////////////////////////////
    //  Remove All Rows Of A Table
    ////////////////////////////////////////////////////////////////////////////
    removeAllRows:function (table_id)
    {
        var table = document.getElementById (table_id) ;

        if (table != null)
        {
            while (table.childNodes.length != 0)
                table.removeChild (table.firstChild) ;
        }
    }
} ;


////////////////////////////////////////////////////////////////////////////////
// DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function addTableRow (srcTable, row_id)
{
    var srcRow = null ;
    
    if (srcTable != null)
    {
        srcRow = document.createElement ('tr') ; 
        srcRow.setAttribute ('id', row_id) ;        // set the id of the row to the actual value
    
        srcTable.appendChild (srcRow) ;
    }
    else
    {
        alert("Error while creating table. Cause: Container row is null!");
    }
    
    return (srcRow) ;
}

////////////////////////////////////////////////////////////////////////////////
// DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function addTableCell (srcRow, cell_id, align, width, height)
{
    var srcCell = null ;
    
    if (srcRow != null)
    {
        srcCell = document.createElement ('td') ;
        
        srcCell.setAttribute ('align', align) ;
        srcCell.setAttribute ('width', width) ;
        srcCell.setAttribute ('height', height) ;
        srcCell.setAttribute ('id', cell_id) ; 
        srcCell.setAttribute ('name', cell_id) ;
        srcRow.appendChild (srcCell) ;
     }
    else
    {
        alert("Error while creating Cell!");
    }
    
    return (srcCell) ;
}

////////////////////////////////////////////////////////////////////////////////
// DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function addLinkCell (srcRow, cell_id, align, width, height, linkURL)
{
    var srcCell = null ;
    var link = null ;
    
    if (srcRow != null)
    {
        srcCell = document.createElement ('td') ;
        
        srcCell.setAttribute ('align', align) ;
        srcCell.setAttribute ('width', width) ;
        srcCell.setAttribute ('height', height) ;
    
        srcRow.appendChild (srcCell) ;
        
        link = document.createElement ('a') ;
        link.setAttribute ('id', cell_id) ;
        link.href = linkURL ;
        
        srcCell.appendChild (link) ;
     }
    else
    {
        alert("Error while creating Cell!");
    }
    
    return (link) ;
}

////////////////////////////////////////////////////////////////////////////////
// DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function addTextBox (srcCell, id, name, type, value, class_name)
{
    var text_box = null ;
    
    if (srcCell != null)
    {
        text_box = document.createElement ('input') ;
    
        text_box.setAttribute ('type', type) ;
        text_box.setAttribute ('name', name) ;
        text_box.setAttribute ('id', id) ;
        
        text_box.value = value ;
        text_box.className = class_name ;
    
        srcCell.appendChild (text_box) ;
    } 
    else
    {
        alert("Error while creating Text Box!");
    }
    
    return (text_box) ;
}

function addTextBoxString (srcCell, path,type, value, class_name)
{
    var text_box = null ;
    
    if (srcCell != null)
    {
        text_box = document.createElement ('input') ;
    
        text_box.setAttribute ('type', type) ;
        
        text_box.setAttribute ('path', path) ;
        
        text_box.value = value ;
        text_box.className = class_name ;
    
        srcCell.appendChild (text_box) ;
    } 
    else
    {
        alert("Error while creating Text Box!");
    }
    
    return (text_box) ;
}


////////////////////////////////////////////////////////////////////////////////
// DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function addLabel (srcCell, id, text)
{
    var label = null ;
    
    if(srcCell != null)
    {
        label = document.createElement ('label') ;
        label.setAttribute ('id', id) ;
        label.appendChild (document.createTextNode (text)) ;
        
        srcCell.appendChild (label) ;
    }
    else
    {
        alert("Error while creating Label!");
    }

    return (label) ;
}

////////////////////////////////////////////////////////////////////////////////
// DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function addSpan (srcCell, id, text)
{
    var label = null ;
    
    if(srcCell != null)
    {
        label = document.createElement ('span') ;
        label.setAttribute ('id', id) ;
        label.appendChild (document.createTextNode (text)) ;
        
        srcCell.appendChild (label) ;
    }
    else
    {
        alert("Error while creating Span!");
    }

    return (label) ;
}

////////////////////////////////////////////////////////////////////////////////
// DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function addCheckBox (srcCell, id, name, status)
{
    var check_box = null ;
    
    if (srcCell != null)
    {
        check_box = document.createElement ('input') ;
        
        check_box.setAttribute ('type', 'checkbox') ;
        check_box.setAttribute ('name', name) ;
        check_box.setAttribute ('id', id) ;
        check_box.checked = status ;
    
        srcCell.appendChild (check_box) ;
    }
    else
    {
        alert("Error while creating Text Box!");
    }
    
    return (check_box) ;
}

////////////////////////////////////////////////////////////////////////////////
// DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function addImage (srcCell, id, name, width, height, image_path)
{
    var img = null ;
    
    if(srcCell != null)
    {
        var img = document.createElement ('img') ;
        
        img.setAttribute ('src', image_path) ;
        img.setAttribute ('width', width) ;
        img.setAttribute ('height', height) ;
        img.setAttribute ('id', id) ;
        img.setAttribute ('name', name) ;
        img.setAttribute ('border', '0') ;

        srcCell.appendChild (img) ;
    }
    else
    {
        alert("Error while creating image!");
    }
    
    return (img) ;
}

////////////////////////////////////////////////////////////////////////////////
// DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function addRadio (srcCell, id, name, value)
{
    var radio = null ;
    
    if (srcCell != null)
    {
        if (document.all)
        {
            radio = document.createElement ('<input name="' + name + '">') ;
        }
        else
        {
            radio = document.createElement ('input') ;
            radio.setAttribute ('name', name) ;
        }
    
        radio.setAttribute ('type', 'radio') ;
        radio.setAttribute ('id', id) ;
        radio.value = value ;
    
        srcCell.appendChild (radio) ;
    } 
    else
    {
        alert("Error while creating Radio!");
    }
    
    return (radio) ;
}

////////////////////////////////////////////////////////////////////////////////
//DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function addButton (srcCell, id, name, value,functionName)
{
 var button = null ;
 
 if (srcCell != null)
 {
     if (document.all)
     {
    	 button = document.createElement ('<input name="' + name + '">') ;
     }
     else
     {
    	 button = document.createElement ('input') ;
    	 button.setAttribute ('name', name) ;
     }
 
     button.setAttribute ('type', 'button') ;
     button.setAttribute ('id', id) ;
     button.value = value ;
     if(functionName!=null){
    	 
    	 button.setAttribute("onclick", functionName);
     }
 
     srcCell.appendChild (button) ;
 } 
 else
 {
     alert("Error while creating button!");
 }
 
 return (button) ;
}

function addSelect (srcCell, id, name,functionName)
{
 var select = null ;
 
 if (srcCell != null)
 {
     if (document.all)
     {
    	 select = document.createElement ('<select name="' + name + '">') ;
     }
     else
     {
    	 select = document.createElement ('select') ;
     }
    	 select.setAttribute('class', 'dropdown_200');
    	 option0 = document.createElement("option");
   	  	  option0.text="---------Select---------";
   	  	  option0.value="disabled";    	 
   	  	  option0.setAttribute('disabled',true);
    	  option = document.createElement("option");
    	  option.text="Regular";
    	  option.value="regular";
    	  option1 = document.createElement("option");
    	  option1.text="Correspondance";
    	  option1.value="correspondence";
    	  try {
    		  select.add(option0, null); 
    		  select.add(option, null); //Standard 
    		  select.add(option1,null);
    	    }catch(error) {
    	    	select.add(option0, null); 
    	    	select.add(option); // IE only
    	    	select.add(option1);
    	    }
    //	 select.setAttribute ('name', name) ;
     
 
   //  button.setAttribute ('type', 'button') ;
     select.setAttribute ('id', id) ;
 //    select.setAttribute('option', value)
   //  button.value = value ;
     if(functionName!=null){
    	 
    	 select.setAttribute("onchange", functionName);
     }
 
     srcCell.appendChild (select) ;
 } 
 else
 {
     alert("Error while creating select!");
 }
 
 return (select) ;
}

////////////////////////////////////////////////////////////////////////////////
// DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function embedObject (srcCell, id, name, width, height, srcPath)
{
    var obj = null ;
    
    if(srcCell != null)
    {
        var img = document.createElement ('embed') ;
        
        obj.setAttribute ('src', srcPath) ;
        obj.setAttribute ('width', width) ;
        obj.setAttribute ('height', height) ;
        obj.setAttribute ('id', id) ;
        obj.setAttribute ('name', name) ;

        srcCell.appendChild (obj) ;
    }
    else
    {
        alert("Error while creating image!");
    }
    
    return (obj) ;
}

////////////////////////////////////////////////////////////////////////////////
// DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function removeRow (srcTable, row_id)
{

    var table = document.getElementById ('pilingIdle_det') ;
    srcTable.removeChild (document.getElementById (row_id)) ;
 /*   if (table != null)
    {

        table.removeChild (document.getElementById (row_id)) ;
    }*/
}
function removeRowBreakdown(srcTable, row_id)
{

    var table = document.getElementById ('pilingBreakdown_det') ;

    if (table != null)
    {

        table.removeChild (document.getElementById (row_id)) ;
    }
}
function removeRowMovement(srcTable, row_id)
{

    var table = document.getElementById ('pilingMovement_det') ;
    srcTable.removeChild (document.getElementById (row_id)) ;
/*    if (table != null)
    {

        table.removeChild (document.getElementById (row_id)) ;
    }*/
}
////////////////////////////////////////////////////////////////////////////////
// DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function removeAllRows (table_id)
{
	
    var table = document.getElementById (table_id) ;
    if (table != null)
    {
        while (table.childNodes.length != 0)
            table.removeChild (table.firstChild) ;
    }
}
////////////////////////////////////////////////////////////////////////////////
//DEPRICATED FUNCTION. DO NOT USE                                            //
////////////////////////////////////////////////////////////////////////////////
function addCheckBoxSelectAll(srcCell, id, name, status,attribute)///MILAN DUTTA ;Select All check Box
{
    var check_box = null ;

    if (srcCell != null)
    {
        if (document.all)
        {
            check_box = document.createElement ('<input name="' + name + '">') ;
        }
        else
        {
            check_box = document.createElement ('input') ;
            check_box.setAttribute ('name', name) ;
        }

        check_box.setAttribute ('type', 'checkbox') ;
        check_box.setAttribute ('id', id) ;
        check_box.checked = status ;
        check_box.setAttribute('onclick',attribute);
        srcCell.appendChild (check_box) ;
    }
    else
    {
        alert("Error while creating Text Box!");
    }

    return (check_box) ;
}
////////////////////////////////////////////////////////////////////////////////
//DEPRICATED FUNCTION. DO NOT USE                                            //Milan Dutta
////////////////////////////////////////////////////////////////////////////////
function addCheckBoxWithFunction (srcCell, id, name, status,attribute)
{
    var check_box = null ;

    if (srcCell != null)
    {
        if (document.all)
        {
            check_box = document.createElement ('<input name="' + name + '">') ;
        }
        else
        {
            check_box = document.createElement ('input') ;
            check_box.setAttribute ('name', name) ;
        }

        check_box.setAttribute ('type', 'checkbox') ;
        check_box.setAttribute ('id', id) ;
        check_box.checked = status ;
        check_box.setAttribute('onclick',attribute);

        srcCell.appendChild (check_box) ;
    }
    else
    {
        alert("Error while creating Text Box!");
    }

    return (check_box) ;
}


/////////////////////////////////////// piling  Milan 
function addHour(srcCell, id, name,functionName){
	 var select = null ;
	 
	 if (srcCell != null)
	 {
	     if (document.all)
	     {
	    	 select = document.createElement ('<select name="' + name + '">') ;
	     }
	     else
	     {
	    	 select = document.createElement ('select') ;
	     }
	    	 select.setAttribute('class', 'dropdown_200');
	    	    	    var i;
	    	    for (i = 0; i <=23; i++) {
	    	    	 option = document.createElement("option");
	    	    	  option.text=i;
	    	    	  option.value=i;
	    	    	  select.add(option);
	    	    }
  	    	  select.setAttribute ('id', id) ;
	    

	     if(functionName!=null){
	    	 
	    	 select.setAttribute("onchange", functionName);
	     }
	 
	     srcCell.appendChild (select) ;
	 } 
	 else
	 {
	     alert("Error while creating select!");
	 }
	 
	 return (select) ;
}
function addMinute(srcCell, id, name,functionName){
	 var select = null ;
	 
	 if (srcCell != null)
	 {
	     if (document.all)
	     {
	    	 select = document.createElement ('<select name="' + name + '">') ;
	     }
	     else
	     {
	    	 select = document.createElement ('select') ;
	     }
	    	 select.setAttribute('class', 'dropdown_200');
	    	    	    var i;
	    	    for (i = 0; i <=59; i++) {
	    	    	 option = document.createElement("option");
	    	    	  option.text=i;
	    	    	  option.value=i;
	    	    	  select.add(option);
	    	    }
 	    	  select.setAttribute ('id', id) ;
	    

	     if(functionName!=null){
	    	 
	    	 select.setAttribute("onchange", functionName);
	     }
	 
	     srcCell.appendChild (select) ;
	 } 
	 else
	 {
	     alert("Error while creating select!");
	 }
	 
	 return (select) ;
}