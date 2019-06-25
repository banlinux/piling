<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../menu/commonHead.jsp"></jsp:include>
<script type="text/javascript" src="js/pilingRigProgressForm/pilingRigProgress.js"></script>
<script type="text/javascript" src="js/pilingRigProgressForm/ajax.js"></script>
<script language="javascript" src="js/common/table_creation_api.js"></script>

<title>Piling Rig Progress Report</title>
<script type="text/javascript">
function autofill(){
	 var tType="CONTRACT";

	 $( "#contract_no" ).autocomplete({	    	
	        source: '${pageContext. request. contextPath}/pilingRigProgressForm/pilingRigProgressFormAjax.htm?senderType='+tType,
	        minLength: 3,
	        select: function(e, ui) {
	        	getContractDetails(ui.item.value);
	        	
  	  }
    });
}
function autofillRig(){
	 var tType=document.getElementById("contract_no").value;
	 $( "#rig_no" ).autocomplete({	    	
	        source: '${pageContext. request. contextPath}/pilingRigProgressForm/pilingRigProgressFormRig.htm?senderType='+tType,
	        minLength: 3,
	        select: function(e, ui) {
	        	getRigDetails(ui.item.value);
	        	
   }
	    });
}
function autofillPile(){
	 var tType=document.getElementById("contract_no").value;
	 $( "#pileNo").autocomplete({	    	
	        source: '${pageContext. request. contextPath}/pilingRigProgressForm/pilingRigProgressFormPile.htm?senderType='+tType,
	        minLength: 3,
	        select: function(e, ui) {
	        	getPileDetails(ui.item.value);
	        	
    }
	    });
}
</script>
<style type="text/css">
<!--
.style6 {
	color: #666666
}

.style7 {
	color: #FF0000
}

.style8 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
}

.style9 {
	font-size: 12px
}
</style>
</head>
<body>
<div style="height: 100px"><jsp:include page="../menu${sessUserID}.jsp" ></jsp:include></div> 
<div align="center"><h2>Piling Rig Progress Report</h2></div>
<spring:form commandName="pilingRigReportBean">
<div class="mainDiv">
 <fieldset class="dottedborder">
 <legend class="fieldsetheader"> Piling Rig Progress Report</legend>
 <table>
 	<tr>
 		<td class="labeltext">Select Contract</td>
 		<td><spring:input id="contract_no" path="contract_no" onkeyup="autofill();"   size="30"/>
 			<spring:errors path="contract_no" cssClass="error"></spring:errors>
  		</td>
 		<td><spring:input path="contractName" size="80"/> </td>
 		<td></td>
 	</tr>
 </table>
 <table>	
 	<tr>
 		<td class="labeltext">Site Code</td>
 		<td><spring:input path="site_no" /></td>
	</tr>
	<tr>
 		<td class="labeltext">Rig</td>
 		<td><spring:input path="rig_no" onkeyup="autofillRig();"   size="40"/>
 			<spring:errors path="rig_no" cssClass="error"></spring:errors>
  		</td>
 		<td><spring:input path="rig_name" size="60"/> </td>
 	</tr>
  </table>
  <table> 
 
 	<tr>
 		<td class="labeltext">Pile</td>
 		<td><spring:input path="pileNo" onkeyup="autofillPile();"   size="40"/>
 			<spring:errors path="pileNo" cssClass="error"></spring:errors>
		</td>


 		<td  align="left" class="labeltext">Start Date </td>
 		<td align="left"><spring:input path="startDate" readonly="true" tabindex="-1"/><A
					HREF='javascript:showCalendarControl (document.forms[0].startDate)'>
						<IMG src="js/calendar/calendar1.gif" border=0 align=middle>
						</A>  
		</td>
	</tr>	
	<tr>
	 		<td  align="left" class="labeltext">End Date </td>
 		<td align="left"><spring:input path="endDate" readonly="true" tabindex="-1"/><A
					HREF='javascript:showCalendarControl (document.forms[0].endDate)'>
						<IMG src="js/calendar/calendar1.gif" border=0 align=middle>
						</A>  
		</td>
	</tr>
</table>
</fieldset>
</div>
<div>
		<table align="center">
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr >
				<td >
					<input type="submit" class="button1" name="_save" value="Submit">					
					<input type="reset" class="button1" name="Reset" value="Reset">
				</td>
			</tr>
		</table>	
</div>

   <table id="result"></table>
 <div id="pager"></div>

 </spring:form>

</body>
</html>

<!-- 
Auf dem ersten Bild kann man ... sehen
In the first picture, one can see...
Aus dem ersten bild kann ich sehe ein frau.Die frau scheint eine polizistin.Auf dem linken bild kann mann sehe eine Polizeistation.

Auf dem linken Bild kann man drei Schüler sehen, die eine Schuluniform tragen
In the left-hand picture, one can see three pupils who are wearing school uniform
Auf dem zweiten Foto kann man einer Karte sehen.

Auf dem zweiten Foto kann man ... sehen
In the second photo, one can see...

Ich sehe
I see
Ich sehe keine Polizei in die Polizeistation.

es gibt
there is/are
Es gibt keine Benzin  in die Tankstelle.

Auf der linken/rechten Seite kann man ... sehen
On the left/right-hand side, one can see...
Auf der rechten Seit kann man eine Tankstalle sehen.

Im Vordergrund gibt es/sehe ich
In the foreground, there is/I see
In dem Vordergrund,es scheint ein Pferd un der Hintergrund sie scheint eine Katze.
Es scheint dass Sie muste in in das Haus fur ewig stehen. 

Im Hintergrund gibt es/sieht man
In the background, there is/one sees

Die Leute sehen lustig/ernst/gelangweilt/frustriert aus
The people look funny/serious/bored/frustrated

Die Leute auf dem ersten Bild/Foto tragen
The people in the first picture/ photo are wearing

Meiner Meinung nach ist das draußen/drinnen/auf einem Campingplatz/in der Natur/im Park/auf der Straße/in einem Straßencafé/zu Hause
In my opinion, it is outside/inside/on a campsite/in the wild/in a park/on the streets/in a street-café/at home

Meiner Meinung nach ist am wichtigsten, dass
The most important thing in my opinion is, that

Das eine Bild zeigt nur eine Person, auf dem anderen Bild sind mehrere Personen
The first picture shows only one person, but in the other picture, there are more people

Beide Bilder zeigen (Leute, die Sport treiben)
Both pictures show (people who do sport)

sowohl ... als auch ...
Both ... and ...

sowohl auf dem ersten als auch auf dem zweiten Foto kann man
In both the first and second photos, one can

allgemein
general

Es sieht ... aus
It looks like

Ich ziehe das erste Bild vor zweite
I prefer the 1st picture to the 2nd

Ich würde lieber
I would prefer

********************************************
ich bin überzeugt, dass
I am convinced that

ich gäbe zu, dass
I admit that
Ich gäbe zu, dass ich habe, dass Hausaufgabe nicht gemacht.
ich habe den Eindruck, dass
I have the impression that

ich bezweifle, dass
I doubt that

meiner Ansicht nach
in my opinion

man bekommt oft den Eindruck, dass
people often have the impression that
 
 Ich kaufe einem Pullover fur meinen Vater.Ich schenke dem Pullover zu meimen Vater.
 N		V		D		   a		A           Ich schenke Sie ihm
das ist der Grund warum
that’s the reason why

das beweist, dass
that proves that

es handelt sich um
it’s a question of / it’s about

es ist fraglich, ob
it’s questionable whether

es steht fest, dass
one thing’s for sure, and that is

es stimmt nicht, dass
it’s not true that

ganz im Gegenteil!
quite the contrary!

einerseits
on the one hand

andererseits
on the other hand
Einerseits sie mochte arbeite, anderseits komme sie spate.

alles in allem
all in all
Sie sind alles in allem fur die buro.

auf keinen Fall
on no account

heutzutage
these days

im Vergleich zu
compared with
Im Vergleich zu gestern es ist heiss

in der Tat
in fact
In der Tat, was du gesagt hast stimmt.

selbstverständlich
obviously
Selbstverstandlich ich gehe nach Hause.

vor allem
above all

***************************************************************************
Was kannst du auf den Bildern/Fotos sehen?
What can you see in the pictures/photos?

Kannst du die Bilder/Fotos beschreiben?
Can you describe the pictures/photos?

Wie sehen die Personen aus?
How do the people look?

Was tragen sie?
What do they wear?

Wo findet das statt?
Where does this take place?

Wo ist das?
Where is it?

Was ist deiner Meinung(opinion) nach am wichtigsten?
What is the most important thing, in your opinion?

Wie unterscheiden sich die beiden Bilder?
How do the pictures differ?

Wie unterscheiden sie sich?
How do they differ?

Was haben die Bilder/Fotos gemeinsam?
What do the pictures/photos have in common?

Was sagen die Bilder über die Personen aus?
What do the pictures say about the people?

Was für ...?
What type of ...?

Wie verschieden sind ...?
How different are ...?

*****************************************************
Kannst du die Frage wiederholen bitte?
Could you repeat the question please?

Nochmal bitte?
Again please?

Wie bitte?
Pardon?

Was bedeutet ...?
What does ... mean?

Ich verstehe die Frage nicht!
I don't understand the question!

Kannst du mir das Wort ... erklären?
Could you explain the word ... to me?

eigentlich
actually

na ja...
(oh) well...

vielleicht...
maybe...

Na ja, vielleicht schon, aber...
Well, perhaps, but...

Lässt du mich mal überlegen...
Let me think...

Ja klar, aber...
Yes, of course, but...

Ja, genau...
Yes, exactly...

Das mag wohl sein, aber...
That may well be the case, but...
 -->
 
 II. Dependent (subordinate) clauses begin with a subordinating conjunction (or equivalent). There are a great many such conjunctions, some of the more common ones being:

 als (when) 	 auch wenn (even if) 	 bevor (before) 	 bis (until) 
 damit (so that) 	 dass (that) 	 ehe (before) 	 nachdem (after) 
 ob (whether) 	 obwohl (although) 	 seitdem (since) 	 während (while) 
 weil (because) 	 wenn (if, when) 

A list of subordinating conjunctions also needs to include all of the interrogative words and phrases when they are used to state indirect questions.

 Ich weiß nicht, wann der Zug abfährt.  I don't know when the train leaves.
 Es ist nicht klar, wem das Buch gehört.  It isn't clear to whom the book belongs.

When a subordinating conjunction occupies the first position, a dependent clause results. Keep in mind that, as the name implies, such a clause is not a whole sentence; an independent, or main clause must also be present. The primary feature of a dependent clause is that the finite verb is no longer in the second position, but moves to the end, following even the verb complement (if there is one). If that complement is a separable prefix, the two elements are written as one word. I.e. "er schläft ein" [he falls asleep] becomes "weil er einschläft" [because he falls asleep].

Some other examples:

...dass er sein Kind zur Schule fährt  ...that he drives his child to school
...bevor du nach Hause kommst  ...before you come home
...nachdem ich so viel zugenommen habe  ...after I gained so much weight
...während das Semester in Deutschland beginnt  ...while the semester is starting in Germany 
...ob wir ihm alles sagen sollen  ...if we should tell him everything
...obwohl du ihn erst heute kennen gelernt hast  ...although you never met him until today

 
	
 	Dear Visitors, we would like you to feel comfortable with us. Therefore we have put some rules in place that apply to the entirity of the Schloss Straße (shopping) Center and to which we strictly adhere.
 
In English, in order to state a desire for someone else to do something, we make the other person the object of the verb "to want" (or some equivalent) and attach an infinitive construction: "I want you to clean up your room." German, in contrast, requires that the other person be the subject of a dependent clause that begins with "dass" and is the object of "wollen":
 
	
 	We want you to live safely. Your police.
 

Ich will, dass du dein Zimmer aufräumst.
I want you to clean up your room.

Sie möchte, dass er nach Hause anruft.
She would like him to call home.

Wollen Sie, dass ich Ihnen helfe?
Do you want me to help you?

Wir wollen, dass sie kocht.
We want her to cook.

Sie will, dass ich die ganze Arbeit mache.
She wants me to do all the work.

A note on word order: a dependent clause can precede, follow or be inserted into the main clause. When it precedes, it normally occupies the first position, necessitating an inverted order in the independent clause (i.e. with the subject is located in the third position).

Following:
Es ist schön, dass er sein Kind zur Schule fährt
It's nice that he drives his child to school

Mach deine Arbeit fertig, bevor du nach Hause kommst.
Finish your work before you come home

Preceding:
Nachdem ich so viel zugenommen habe, muss ich vernünftiger essen.
After I've gained so much weight, I'll have to eat more reasonably.

Auch wenn ich es wollte, könnte ich die Rechnung nicht bezahlen.
Even if I wanted to, I couldn't pay the bill.

Während das Semester in Deutschland beginnt, liegt er noch am Strand.
While the semester is starting in Germany, he's still lying on the beach

Obwohl du ihn erst heute kennen gelernt hast, scheinst du alles über ihn zu wissen.
Although you never met him until today, you seem to know all about him.

Within:
Die Idee, dass ich plötzlich für alles verantwortlich sein sollte, war mir neu.
The idea that I was suddenly supposed to be responsible for everything was new to me.
 