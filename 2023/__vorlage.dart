import 'dart:io' show File, Platform; 
import 'dart:convert' show LineSplitter; 

void main() async {
  try {
    // Pfad zur Datei
    // Die ersten beiden Zeichen der DART-Datei sind die Inputdatei.
    var filePath = Platform.script.pathSegments.last[0]+Platform.script.pathSegments.last[1]+'.txt';
    /*
    var gesamt1 =0;
    var gesamt2 =0;
    */
    
    // Die Datei zeilenweise einlesen
    var lines = await File(filePath).readAsString().then((content) => LineSplitter.split(content).toList());

    // Ausgabe der Zeilen
    for (var line in lines) {
	    print(line);
    }
	  // print("Teil 1: "+gesamt1.toString());
  } catch (e) {
    print('Fehler beim Lesen der Datei: $e');
  }
  
}



// irgendwie in include umbauen
bool isDigit(String character) {
  return '0'.compareTo(character) <= 0 && character.compareTo('9') <= 0;
}
