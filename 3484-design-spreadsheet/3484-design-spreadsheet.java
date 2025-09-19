class Spreadsheet {
    private int[][] grid; // rows x 26
    
    // Constructor
    public Spreadsheet(int rows) {
        grid = new int[rows][26]; // initialized with 0
    }
    
    // Convert cell string (like "B10") -> [row, col]
    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A'; // column index
        int row = Integer.parseInt(cell.substring(1)) - 1; // 1-indexed -> 0-indexed
        return new int[]{row, col};
    }
    
    // Set cell value
    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }
    
    // Reset cell
    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }
    
    // Helper: get value from either a cell reference or a number
    private int getOperandValue(String operand) {
        if (Character.isLetter(operand.charAt(0))) { 
            int[] pos = parseCell(operand);
            return grid[pos[0]][pos[1]];
        } else {
            return Integer.parseInt(operand);
        }
    }
    
    // Get value from formula "=X+Y"
    public int getValue(String formula) {
        String expr = formula.substring(1); // remove '='
        String[] parts = expr.split("\\+");
        
        int val1 = getOperandValue(parts[0]);
        int val2 = getOperandValue(parts[1]);
        
        return val1 + val2;
    }
}
