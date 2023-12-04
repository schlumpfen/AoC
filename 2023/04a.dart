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
        gesamt1 += checkline1(line);
      // gesamt2 += checkline2(line);
    }
	  
    print("Teil 1: "+gesamt1.toString());
    // print("Teil 2: "+gesamt2.toString());
  } catch (e) {
    print('Fehler: $e');
  }
  
}

int checkline1(String line) {
  // 
  List<String> grupperer = line.split(': ');   
  List<String> gruppen = grupperer[1].split(' | '); 

  List<int> vorne = splitAndConvert(gruppen[0]);
  vorne.sort();

  List<int> hinten = splitAndConvert(gruppen[1]);
  hinten.sort();

  double i=0.5;
  for (int vorneteil in vorne) {
    for(int hintenteil in hinten){
      if(vorneteil == hintenteil){
        i *= 2;
      }
    }
  }
  return i.toInt();
}

List<int> splitAndConvert(String numbers) {
  List<String> numberList = numbers.trim().split(" ");
  numberList.removeWhere((element) => element.isEmpty);
  return numberList.map((e) => int.parse(e)).toList();
}

// irgendwie in include umbauen
bool isDigit(String character) {
  return '0'.compareTo(character) <= 0 && character.compareTo('9') <= 0;
}
