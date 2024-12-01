def calculate_combined_solution(file_path):
# Listen für die beiden Spalten
    column_1 = []
    column_2 = []
    
    # Datei einlesen und Werte verarbeiten
    with open(file_path, 'r') as file:
        for line in file:
            values = line.strip().split()
            # Zahlen als Integer speichern
            num1, num2 = int(values[0]), int(values[1])
            column_1.append(num1)
            column_2.append(num2)
    
    column_1.sort()
    column_2.sort()

    # Teil 1: Berechnung der absoluten Differenzen
    summed_differences = 0
    for num1, num2 in zip(column_1, column_2):
        summed_differences += abs(num1 - num2)
    
    # Teil 2: Häufigkeiten in Spalte 2
    summed_products = 0
    for num1 in column_1:
        count_in_column2 = column_2.count(num1)
        summed_products += num1 * count_in_column2
    
    # Ergebnisse ausgeben
    print(f"Ergebnis Teil 1: {summed_differences}")
    print(f"Ergebnis Teil 2: {summed_products}")

# Hauptprogramm
if __name__ == "__main__":
    file_name = "01.txt"
    calculate_combined_solution(file_name)
