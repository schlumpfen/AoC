import 'dart:io' show File, Platform; 
import 'dart:convert' show LineSplitter; 

void main() async {
  try {
    // Pfad zur Datei
    // Die ersten beiden Zeichen der DART-Datei sind die Inputdatei.
    var filePath = Platform.script.pathSegments.last[0]+Platform.script.pathSegments.last[1]+'.txt';
    
    var gesamt1 =0;
    var gesamt2 =0;
    int i = 0;
    // Die Datei zeilenweise einlesen
    var lines = await File(filePath)
        .readAsString()
        .then((content) => LineSplitter.split(content).toList());

    // Ausgabe der Zeilen
    for (String line in lines) {
	    i++;
      if (await checkline1(line)) {
        gesamt1 += i;
      }
      gesamt2 += checkline2(line);
    }
	  print("Teil 1: "+gesamt1.toString());
    print("Teil 2: "+gesamt2.toString());
  } catch (e) {
    print('Fehler: $e');
  }
  
}

Future<bool> checkline1(String line) async {

  int reddarf = 12, greendarf = 13, bluedarf = 14;
  int red = 0, green = 0, blue = 0;
  
  List<String> grupperer = line.split(':');   

  List<String> gruppen = grupperer[1].split(';');  

  for (String gruppe in gruppen) {
    
    List<String> einzelheiten = gruppe.trim().split(', ');
    red = 0; 
    green = 0;
    blue = 0;
    for (String einzelheit in einzelheiten) {
    
      List<String> teile = einzelheit.split(' ');
      int menge = int.parse(teile[0]);
      String farbe = teile[1];
      if (farbe == 'red') {
        red = menge;
      } else if (farbe == 'green') {
        green = menge;
      } else if (farbe == 'blue') {
        blue = menge;
      }
    }
    if (red > reddarf || green > greendarf || blue > bluedarf) {return false;}
  }
  return true;
}

int checkline2(String line) {
  int redmax = 0, greenmax = 0, bluemax = 0;
  int red = 0, green = 0, blue = 0;
  
  // Game bis : weg
  List<String> grupperer = line.split(':');   

  // hinteren Teil verarbeiten
  List<String> gruppen = grupperer[1].split(';');  

  // Teile zwischen ; verarbeiten
  for (String gruppe in gruppen) {
    
    List<String> einzelheiten = gruppe.trim().split(', ');
    red = 0; 
    green = 0;
    blue = 0;
    for (String einzelheit in einzelheiten) {
      List<String> teile = einzelheit.split(' ');
      int menge = int.parse(teile[0]);
      String farbe = teile[1];
      if (farbe == 'red') {
        red = menge;
      } else if (farbe == 'green') {
        green = menge;
      } else if (farbe == 'blue') {
        blue = menge;
      }
    }
    if(red > redmax) redmax=red;
    if(green > greenmax) greenmax=green;
    if(blue > bluemax) bluemax=blue;
  }
  return redmax*greenmax*bluemax;
}

// irgendwie in include umbauen
bool isDigit(String character) {
  return '0'.compareTo(character) <= 0 && character.compareTo('9') <= 0;
}
