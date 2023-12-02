import 'dart:io' show File; 
import 'dart:convert' show LineSplitter; 

void main() async {
  try {
    // Pfad zur Datei
    var filePath = '1.txt';
    int gesamt1 = 0;
    // Die Datei zeilenweise einlesen
    var lines = await File(filePath).readAsString().then((content) => LineSplitter.split(content).toList());

    // Ausgabe der Zeilen
    for (var line in lines) {
	    gesamt1 += mergeDigits1(line);
    }
	  print("Teil 1: "+gesamt1.toString());
  } catch (e) {
    print('Fehler beim Lesen der Datei: $e');
  }
  
}


int mergeDigits1(String line) {
  int firstDigit = -1;
  int lastDigit = -1;


  // Suche die erste Ziffer von links
  for (int i = 0; i < line.length; i++) {
    if (isDigit(line[i])) {
      firstDigit = int.parse(line[i]);
      break;
    }
  }

  // Suche die Ziffer von rechts
  for (int i = line.length - 1; i >= 0; i--) {
    if (isDigit(line[i])) {
      lastDigit = int.parse(line[i]);
      break;
    }
  }

  // Kombiniere die Ziffern zu einer Zahl
  if (firstDigit != -1 && lastDigit != -1) {
    return int.parse('$firstDigit$lastDigit');
  } else {
    // Falls keine Ziffern gefunden wurden, gib -1 zurück oder handle es auf andere Weise
    return -1;
  }
}

bool isDigit(String character) {
  return '0'.compareTo(character) <= 0 && character.compareTo('9') <= 0;
}
