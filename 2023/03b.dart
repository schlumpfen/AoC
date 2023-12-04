import 'dart:io' show File, Platform, stdout; 

void main() async {
  try {
    // Pfad zur Datei
    // Die ersten beiden Zeichen der DART-Datei sind die Inputdatei.
    var filePath = Platform.script.pathSegments.last[0]+Platform.script.pathSegments.last[1]+'.txt';
    
    var gesamt1 =0;
    var gesamt2 =0;
    
    
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
      if(strZahl.length>0){
        if(istNachbarSybol(strZahl, schematic, i, j-1)){
          // i,j müsste feld danach sein wo keine Ziffer steht.
          gesamt1 += int.parse(strZahl);
        }
      }
    }
	  print("Teil 1: "+gesamt1.toString());

     // Zeile für Zeile
    for (i = 0; i < schematic.length; i++) {
      for (j = 0; j < schematic[i].length; j++) {
        if(schematic[i][j]=='*'){
          gesamt2 += erstelleProdukt(schematic,i,j);
        }
      }
    }
    print("Teil 2: "+gesamt2.toString());


  } catch (e) {
    print('Fehler beim Lesen der Datei: $e');
  }
  
}
int erstelleProdukt(List<List<String>> schematic, int i, int j)
{
  // Teste Bereich um * 
  // abc
  // d*e
  // fgh
  // testen ob Bereich geht (* am Rand)
  // 2 Treffen in abc, d, e, fgh sonst eh egal
  // bei a,f nach links und rechts schauen
  // Bis Ende
  // b,c,e,g,h nur nach rechts
  // d nur nach links 
  
  // i = Zeile Start bei 0
  //  print(i.toString() + " " + j.toString());
  int counter =0;
  var top ='';
  var middle='';
  var bottom='';

  // links
  if(isDigit(schematic[i][j-1])){
    counter++;
  }
  // rechts
  if(isDigit(schematic[i][j+1])){
    counter++;
  }
  if(counter==1){
    print ("Links und rechts");
    return 2;
  }
  // oben = unten
  // .1.->1 --> geht nicht
  // ...->0,
  // ..1->1 --> nach rechts
  // .11->1 --> nach rechts
  // 1..->1 --> nach links
  // 11.->1 --> nach links 
  // 111->1 --> ferig

  if(isDigit(schematic[i-1][j-1]) && !isDigit(schematic[i-1][j]) && isDigit(schematic[i-1][j+1])){
    // 1.1
    counter+=2;
    print("Beide oben");
    return 2;
  } else {
    
  } 

  // oben = unten
  // ...->0, ..1->1, .1.->1, .11->1, 1..->1, 11.->1, 111->1, 1.1->2
  if(isDigit(schematic[i+1][j-1]) && !isDigit(schematic[i+1][j]) && isDigit(schematic[i+1][j+1])){
    // 1.1
    counter+=2;
    print("Beide unten");
    return 2;
  } else {
    
  } 

  if(counter ==4)
    print(counter.toString()+" "+i.toString()+ " "+j.toString());
  /*
  for(int z=-1;z<2;z++)
  {
    for(int s=-1;s<2;s++)
    {
      if(schematic[i+z][j+s]!='*'){ 
        if(isDigit(schematic[i+z][j+s])){
          top += "1";
        }
        stdout.write(schematic[i+z][j+s]);
      }
    }
    print('');
  }
*/





  
  
  /*
  if(i>0 && j>1) {
    if(isDigit(schematic[i-1][j-1])||isDigit(schematic[i-1][j])||isDigit(schematic[i-1][j+1]))
    {
      return 1;
    }
  }
  */
  return 0;
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

