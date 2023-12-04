import 'dart:io';

void main() {
    var filePath = Platform.script.pathSegments.last[0]+Platform.script.pathSegments.last[1]+'.txt';
    File(filePath).readAsString().then((String contents) {
    List<String> lines = contents.split('\n');

    Iterable<PartNumber> partNumbers = lines.map((line) => getPartNumbers(line, lines.indexOf(line))).expand((i) => i);
    Iterable<Symbol> symbols = lines.map((line) => getSymbols(line, lines.indexOf(line))).expand((i) => i);

    int result1 = partOne(partNumbers, symbols);
    print(result1);
    int result2 = partTwo(partNumbers, symbols);
    print(result2);
  });
}

int partOne(Iterable<PartNumber> partNumbers, Iterable<Symbol> symbols) {
  Iterable<PartNumber> validPartNumbers = getValidPartNumbers(partNumbers, symbols);

  return validPartNumbers.fold(0, (value, element) => value + element.number);
}

int partTwo(Iterable<PartNumber> partNumbers, Iterable<Symbol> symbols) {
  final Iterable<Symbol> gearSymbols = symbols.where((symbol) => symbol.symbol == '*');
  Iterable<int> gears = getGearValues(partNumbers, gearSymbols);

  return gears.reduce((value, element) => value + element);
}

class PartNumber {
  late int number;
  late int row;
  late int start;
  late int end;

  PartNumber(this.number, this.row, this.start, this.end);
}

class Symbol {
  late String symbol;
  late int row;
  late int start;
  late int end;

  Symbol(this.symbol, this.row, this.start, this.end);
}

Iterable<PartNumber> getPartNumbers(String line, int lineIndex) {
  RegExp exp = RegExp('\\d+');
  Iterable<RegExpMatch> matches = exp.allMatches(line).toList();

  return matches.map((match) => PartNumber(int.parse(match[0]!), lineIndex, match.start, match.end));
}

Iterable<Symbol> getSymbols(String line, int lineIndex) {
  RegExp exp = RegExp(r'((?!\d)(?!\.).)');
  Iterable<RegExpMatch> matches = exp.allMatches(line);

  return matches.map((match) => Symbol(match[0]!, lineIndex, match.start, match.end));
}

Iterable<PartNumber> getValidPartNumbers(Iterable<PartNumber> partNumbers, Iterable<Symbol> symbols) {
  return partNumbers.where((partNumber) => isPartNumberValid(partNumber, symbols));
}

bool isPartNumberValid(PartNumber partNumber, Iterable<Symbol> symbols) {
  return symbols.any((Symbol symbol) => isAdjacent(symbol, partNumber));
}

Iterable<int> getGearValues(Iterable<PartNumber> partNumbers, Iterable<Symbol> symbols) {
  return symbols.map((symbol) => getAdjacentParts(symbol, partNumbers)).where((parts) => parts.length == 2).map((parts) => parts.first.number * parts.last.number);
}

Iterable<PartNumber> getAdjacentParts(Symbol symbol, Iterable<PartNumber> partNumbers) {
  return partNumbers.where((partNumber) => isAdjacent(symbol, partNumber));
}

bool isAdjacent(Symbol symbol, PartNumber partNumber) {
  // same line
  if (symbol.row == partNumber.row) return symbol.start == partNumber.start - 1 || symbol.start == partNumber.end;

  // upper or lower line
  if (symbol.row == partNumber.row - 1 || symbol.row == partNumber.row + 1) return symbol.start >= partNumber.start - 1 && symbol.end <= partNumber.end + 1;

  return false;
}