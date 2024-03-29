import 'dart:ffi';
import 'dart:io' show File, Platform; 
import 'dart:convert' show LineSplitter; 

void main() async {
  try {
    // Pfad zur Datei
    // Die ersten beiden Zeichen der DART-Datei sind die Inputdatei.
    var filePath = Platform.script.pathSegments.last[0]+Platform.script.pathSegments.last[1]+'.txt';
    
    var gesamt1 =0;
//  var gesamt2 =0;
    
    
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
    int i=0;
    int j=0;
    // Zeile für Zeile
    for (i = 0; i < schematic.length; i++) {
      // Spalte für Spalte
      String strZahl = '';
      for (j = 0; j < schematic[i].length; j++) {
          // wenn Ziffer dann merken!
          if(isDigit(schematic[i][j])){
            strZahl += schematic[i][j];
          } else {
            // Wurde schon eine Zahl gefunden?
            if(strZahl.length>0){
              // Sofort zählen wenn kein Punkt danach
              if(schematic[i][j]!='.'){
                gesamt1 += int.parse(strZahl);
              } else {
                // Sonst umfeld checken
                if(istNachbarSybol(strZahl, schematic, i, j)){
                  // i,j müsste feld danach sein wo keine Ziffer steht.
                  gesamt1 += int.parse(strZahl);
                }
              }
              // Dann nächste Zahl finden
              strZahl ='';
            }
          }
      }
      // Ist strZahl noch gefüllt?
      if (strZahl.length>0 && istNachbarSybol(strZahl, schematic, i, j-1)) {
        gesamt1 += int.parse(strZahl);
      }
    }
	  print("Teil 1: "+gesamt1.toString());

  } catch (e) {
    print('Fehler beim Lesen der Datei: $e');
  }
}


bool istNachbarSybol(String Zahl, List<List<String>> schematic, int i, int j)
{
  // **Zahl am Zeilenende?** // 
  /* Block testen 1,4
        links = j - länge(Zahl) - 1
    i-1 .....
    i   .111.
    i+1 .....
        rechts j 
  */

  int oben  = i - 1;
  oben  = oben < 0 ? 0 : oben;

  int unten = i + 1;
  unten  = unten > (schematic.length-1) ? (schematic.length - 1) : unten;
  
  int links = j - Zahl.length -1;
  links = links < 0 ? 0 : links;

  int rechts = j;
  

  for(int ii=oben;ii<=unten;ii++){
    for(int jj=links;jj<=rechts;jj++){
      if(schematic[ii][jj]!='.' && !isDigit(schematic[ii][jj])){
        // treffer
        return true;
      }
    }  
  }
  return false;
}

// irgendwie in include umbauen
bool isDigit(String character) {
  return '0'.compareTo(character) <= 0 && character.compareTo('9') <= 0;
}

