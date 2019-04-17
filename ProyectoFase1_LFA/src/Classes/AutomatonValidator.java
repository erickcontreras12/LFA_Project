package Classes; 

import java.util.HashMap;
import java.util.ArrayList;

public class AutomatonValidator{
HashMap<String, Integer> actions = new HashMap();
HashMap<String, Integer> simple_tokens = new HashMap();
HashMap<String, Integer> complex_tokens = new HashMap();
ArrayList<String> final_states = new ArrayList();

public AutomatonValidator(){
getActions();
getSimpleTokens();
getComplexTokens();
getFinalStates();
}

private void getActions(){
actions.put("ARRAY",24);
actions.put("PROCEDURE",26);
actions.put("VAR",22);
actions.put("RECORD",23);
actions.put("FOR",31);
actions.put("DO",34);
actions.put("FUNCTION",27);
actions.put("CASE",37);
actions.put("CONST",20);
actions.put("DOWNTO",39);
actions.put("OF",25);
actions.put("BREAK",38);
actions.put("ELSE",30);
actions.put("THEN",29);
actions.put("WHILE",33);
actions.put("END",36);
actions.put("TO",32);
actions.put("INCLUDE",19);
actions.put("TYPE",21);
actions.put("IF",28);
actions.put("PROGRAM",18);
actions.put("EXIT",35);
}

private void getSimpleTokens(){
simple_tokens.put("..",50);
simple_tokens.put("<=",9);
simple_tokens.put("<>",5);
simple_tokens.put("(*",40);
simple_tokens.put(":=",53);
simple_tokens.put("[",48);
simple_tokens.put("]",49);
simple_tokens.put("OR",12);
simple_tokens.put("MOD",15);
simple_tokens.put("(",46);
simple_tokens.put(")",47);
simple_tokens.put("*",13);
simple_tokens.put("+",10);
simple_tokens.put(",",52);
simple_tokens.put("-",11);
simple_tokens.put(".",43);
simple_tokens.put("DIV",16);
simple_tokens.put("NOT",17);
simple_tokens.put("AND",14);
simple_tokens.put(":",51);
simple_tokens.put(";",42);
simple_tokens.put("{",44);
simple_tokens.put("<",6);
simple_tokens.put("=",4);
simple_tokens.put("}",45);
simple_tokens.put(">",7);
simple_tokens.put(">=",8);
simple_tokens.put("*)",41);
}

private void getComplexTokens(){
complex_tokens.put("'\"'CHARSET'\"'|'''CHARSET'''",2);
complex_tokens.put("LETRA(LETRA|DIGITO)*",3);
complex_tokens.put("DIGITODIGITO*",1);
}

private void getFinalStates(){
final_states.add("q1");
final_states.add("q3");
final_states.add("q4");
final_states.add("q5");
final_states.add("q7");
final_states.add("q12");
final_states.add("q13");
final_states.add("q14");
final_states.add("q15");
}

public String validateEntries(String text){
String result ="";
String actual;
actual = "q0";
int index = 0;
String actual_chain = "";
while(index < text.length()){
char character = text.charAt(index);
int char_value = Integer.valueOf(character);

if (char_value == 32 || char_value == 9 || char_value == 10) {
if (!actual_chain.isEmpty()) {
if (actions.containsKey(actual_chain)) {
result += actual_chain + " = " + actions.get(actual_chain) + "\n";
} else if (simple_tokens.containsKey(actual_chain)) {
result += actual_chain + " = " + simple_tokens.get(actual_chain) + "\n";
} else {
if(final_states.contains(actual)){
char aux = actual_chain.charAt(0);
int aux_char_value = Integer.valueOf(aux);
if( aux == '"'){
result += actual_chain + " = " + 2 + "\n";
}
else if( aux == 'A' || aux == 'Z' || aux == 'B' || aux == 'C' || aux == 'D' || aux == 'E' || 
aux == 'F' || aux == 'G' || aux == 'H' || aux == 'I' || aux == 'J' || aux == 'K' || 
aux == 'L' || aux == 'M' || aux == 'N' || aux == 'O' || aux == 'P' || aux == 'Q' || 
aux == 'R' || aux == 'S' || aux == 'T' || aux == 'U' || aux == 'V' || aux == 'W' || 
aux == 'X' || aux == 'Y' || aux == 'a' || aux == 'z' || aux == 'b' || aux == 'c' || 
aux == 'd' || aux == 'e' || aux == 'f' || aux == 'g' || aux == 'h' || aux == 'i' || 
aux == 'j' || aux == 'k' || aux == 'l' || aux == 'm' || aux == 'n' || aux == 'o' || 
aux == 'p' || aux == 'q' || aux == 'r' || aux == 's' || aux == 't' || aux == 'u' || 
aux == 'v' || aux == 'w' || aux == 'x' || aux == 'y' || aux == '_'){
result += actual_chain + " = " + 3 + "\n";
}
else if( aux == '0' || aux == '9' || aux == '1' || aux == '2' || aux == '3' || aux == '4' || 
aux == '5' || aux == '6' || aux == '7' || aux == '8'){
result += actual_chain + " = " + 1 + "\n";
}
else{
result += actual_chain + " = " + 2 + "\n";
}
}else{
result += actual_chain + " = E\n";
}
}
actual_chain = "";
}
actual = "q0";
}else{
switch(actual){
case "q0":
if(character == '0' || character == '9' || character == '1' || character == '2' || character == '3' || character == '4' || 
character == '5' || character == '6' || character == '7' || character == '8'){
actual = "q1";
}
else if(character == '"'){
actual = "q2";
}
else if(character == '\''){
actual = "q3";
}
else if(character == '='){
actual = "q3";
}
else if(character == '<'){
actual = "q4";
}
else if(character == '>'){
actual = "q5";
}
else if(character == '+'){
actual = "q3";
}
else if(character == '-'){
actual = "q3";
}
else if(character == 'O'){
actual = "q6";
}
else if(character == '*'){
actual = "q7";
}
else if(character == 'A'){
actual = "q8";
}
else if(character == 'M'){
actual = "q9";
}
else if(character == 'D'){
actual = "q10";
}
else if(character == 'N'){
actual = "q11";
}
else if(character == '('){
actual = "q12";
}
else if(character == ';'){
actual = "q3";
}
else if(character == '.'){
actual = "q13";
}
else if(character == '{'){
actual = "q3";
}
else if(character == '}'){
actual = "q3";
}
else if(character == ')'){
actual = "q3";
}
else if(character == '['){
actual = "q3";
}
else if(character == ']'){
actual = "q3";
}
else if(character == ':'){
actual = "q14";
}
else if(character == ','){
actual = "q3";
}
else if(character == 'A' || character == 'Z' || character == 'B' || character == 'C' || character == 'D' || character == 'E' || 
character == 'F' || character == 'G' || character == 'H' || character == 'I' || character == 'J' || character == 'K' || 
character == 'L' || character == 'M' || character == 'N' || character == 'O' || character == 'P' || character == 'Q' || 
character == 'R' || character == 'S' || character == 'T' || character == 'U' || character == 'V' || character == 'W' || 
character == 'X' || character == 'Y' || character == 'a' || character == 'z' || character == 'b' || character == 'c' || 
character == 'd' || character == 'e' || character == 'f' || character == 'g' || character == 'h' || character == 'i' || 
character == 'j' || character == 'k' || character == 'l' || character == 'm' || character == 'n' || character == 'o' || 
character == 'p' || character == 'q' || character == 'r' || character == 's' || character == 't' || character == 'u' || 
character == 'v' || character == 'w' || character == 'x' || character == 'y' || character == '_'){
actual = "q15";
}
else{
actual = "q";}
break;
case "q1":
if(character == '0' || character == '9' || character == '1' || character == '2' || character == '3' || character == '4' || 
character == '5' || character == '6' || character == '7' || character == '8'){
actual = "q1";
}
else{
actual = "q";}
break;
case "q2":
if(char_value >= 32 && char_value <= 254){
actual = "q16";
}
else{
actual = "q";}
break;
case "q3":
break;
case "q4":
if(character == '>'){
actual = "q3";
}
else if(character == '='){
actual = "q3";
}
else{
actual = "q";}
break;
case "q5":
if(character == '='){
actual = "q3";
}
else{
actual = "q";}
break;
case "q6":
if(character == 'R'){
actual = "q3";
}
else{
actual = "q";}
break;
case "q7":
if(character == ')'){
actual = "q3";
}
else{
actual = "q";}
break;
case "q8":
if(character == 'N'){
actual = "q17";
}
else{
actual = "q";}
break;
case "q9":
if(character == 'O'){
actual = "q18";
}
else{
actual = "q";}
break;
case "q10":
if(character == 'I'){
actual = "q19";
}
else{
actual = "q";}
break;
case "q11":
if(character == 'O'){
actual = "q20";
}
else{
actual = "q";}
break;
case "q12":
if(character == '*'){
actual = "q3";
}
else{
actual = "q";}
break;
case "q13":
if(character == '.'){
actual = "q3";
}
else{
actual = "q";}
break;
case "q14":
if(character == '='){
actual = "q3";
}
else{
actual = "q";}
break;
case "q15":
if(character == 'A' || character == 'Z' || character == 'B' || character == 'C' || character == 'D' || character == 'E' || 
character == 'F' || character == 'G' || character == 'H' || character == 'I' || character == 'J' || character == 'K' || 
character == 'L' || character == 'M' || character == 'N' || character == 'O' || character == 'P' || character == 'Q' || 
character == 'R' || character == 'S' || character == 'T' || character == 'U' || character == 'V' || character == 'W' || 
character == 'X' || character == 'Y' || character == 'a' || character == 'z' || character == 'b' || character == 'c' || 
character == 'd' || character == 'e' || character == 'f' || character == 'g' || character == 'h' || character == 'i' || 
character == 'j' || character == 'k' || character == 'l' || character == 'm' || character == 'n' || character == 'o' || 
character == 'p' || character == 'q' || character == 'r' || character == 's' || character == 't' || character == 'u' || 
character == 'v' || character == 'w' || character == 'x' || character == 'y' || character == '_'){
actual = "q15";
}
else if(character == '0' || character == '9' || character == '1' || character == '2' || character == '3' || character == '4' || 
character == '5' || character == '6' || character == '7' || character == '8'){
actual = "q15";
}
else{
actual = "q";}
break;
case "q16":
if(character == '"'){
actual = "q21";
}
else{
actual = "q";}
break;
case "q17":
if(character == 'D'){
actual = "q3";
}
else{
actual = "q";}
break;
case "q18":
if(character == 'D'){
actual = "q3";
}
else{
actual = "q";}
break;
case "q19":
if(character == 'V'){
actual = "q3";
}
else{
actual = "q";}
break;
case "q20":
if(character == 'T'){
actual = "q3";
}
else{
actual = "q";}
break;
case "q21":
if(character == '\''){
actual = "q22";
}
else{
actual = "q";}
break;
case "q22":
if(char_value >= 32 && char_value <= 254){
actual = "q3";
}
else{
actual = "q";}
break;
default:
actual = "q";
}
actual_chain += character;
}
index++;
}
return result;
}
}