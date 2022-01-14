public class ColumnTitle {
    private static void printString(int columnNumber)
    {
        StringBuilder columnName = new StringBuilder();
        while (columnNumber > 0) {
            int rem = columnNumber % 26;
            if (rem == 0) {
                columnName.append("Z");
                columnNumber = (columnNumber / 26) - 1;
            }
            else 
            {
                columnName.append((char)((rem - 1) + 'A'));
                columnNumber = columnNumber / 26;
            }
        }
        System.out.println(columnName.reverse());
    }
    public static void main(String[] args)
    {
        printString(26);
        printString(41);
        printString(52);
        printString(70);
        printString(576);
        printString(802);
        printString(905);
    }
}