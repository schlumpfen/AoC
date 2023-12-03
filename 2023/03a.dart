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
    
    /*
    // Die Datei zeilenweise einlesen
    var lines = await File(filePath).readAsString().then((content) => LineSplitter.split(content).toList());
    */
    
    // Textdatei komplett lesen
    List<String> lines = File(filePath).readAsLinesSync();

    // 2-dimensionales Array erstellen und füllen
    List<List<String>> schematic = [];

    for (String line in lines) {
      List<String> row = line.split('');
      schematic.add(row);
    }
    // Zeile für Zeile
    for (int i = 0; i < schematic.length; i++) {
      // Spalte für Spalte
      var strZahl = '';
      for (int j = 0; j < schematic[i].length; j++) {
          // wenn Ziffer dann merken!
          if(isDigit(schematic[i][j])){
            strZahl += schematic[i][j];
          } else {
            // Wurde schon eine Zahl gefunden?
            if(strZahl.length>0){
              // Hier Nachbarn prüfen

              // Dann nächste Zahl finden
              strZahl ='';
            }
          }
      }
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

