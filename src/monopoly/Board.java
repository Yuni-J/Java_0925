package monopoly;


public class Board {

    private static final int COLS = 112; // Adjust based on your needs

    public static void main(String[] args) {
        createBoard();
    }

    public static void createBoard() {
        // Top border
        System.out.print("┌");
        for (int i = 1; i < COLS; i++) {
            if (i % 14 == 0) {
                System.out.print("┬");
            } else {
                System.out.print("─");
            }
        }
        System.out.println("┐");

        // Row 1
        System.out.println("│           │    스위스  		│   네덜란드 	 │          │     독일    │   포루투갈  │    스페인   │         │");
        System.out.println("│ 사회복지기금	│   (43만원) 	│   (48만원)  │   §찬스§  │   (52만원)  │   (56만원) │   (60만원) │ ★우주여행★│");

        // Rows 2 to 7
        for (int j = 0; j < 2; j++) {
            System.out.print("│");
            for (int i = 1; i < COLS; i++) {
                if (i % 14 == 0) {
                    System.out.print("│");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("│");
        }

        // Middle border
        System.out.print("├");
        for (int i = 1; i < COLS; i++) {
            if (i == 14 || i == 98) {
                System.out.print("┼");
            } else if (i % 14 == 0) {
                System.out.print("┴");
            } else {
                System.out.print("─");
            }
        }
        System.out.println("┤");

        // Row 2
        System.out.print("│    캐나다   │");
        printSpaces(16, 98);
        System.out.println("│     영국    │");
        System.out.print("│   (40만원)  │");
        printSpaces(16, 98);
        System.out.println("│   (64만원)  │");

        // Continue with similar structure for other rows...

        // Final row (Row 8)
        System.out.println("│  ☆무인도☆ │  인도네시아 │     대만    │   싱가포르  │             │    베트남   │    필리핀   │    ←시작   │");
        System.out.println("│             │   (20만원)  │   (18만원)  │   (15만원)  │   §찬스§  │   (12만원)  │   (10만원)  │             │");

        // Bottom border
        System.out.print("└");
        for (int i = 1; i < COLS; i++) {
            if (i % 14 == 0) {
                System.out.print("┴");
            } else {
                System.out.print("─");
            }
        }
        System.out.println("┘");
    }

    private static void printSpaces(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(" ");
        }
    }
}

