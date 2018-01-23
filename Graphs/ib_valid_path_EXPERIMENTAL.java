public class Solution {
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {

        ArrayList<Integer> circleIndexes = new ArrayList<Integer>();
        for (int i = 0; i < E.size(); i++) {
            circleIndexes.add(i);
        }

        ArrayList<ArrayList<Integer>> islands = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> island = new ArrayList<Integer>();
        Queue<Integer> qIsland = new LinkedList<Integer>();
        island.add(circleIndexes.get(0));
        qIsland.add(circleIndexes.get(0));
        circleIndexes.remove(0);


        while (circleIndexes.size() > 0) {

            while (!qIsland.isEmpty()) {
                int x = qIsland.remove();
                for (Integer y : circleIndexes) {
                    if (x != y && dist(E, F, x, y) <= 2*D) {
                        island.add(y);
                        qIsland.add(y);
                        circleIndexes.remove(y);
                    }
                }
            }

            islands.add(island);
            if (circleIndexes.size() > 0) {
                island = new ArrayList<Integer>();
                island.add(circleIndexes.get(0));
                qIsland.add(circleIndexes.get(0));
                circleIndexes.remove(0);
            }

        }

        for (ArrayList<Integer> is : islands) {
            boolean leftSide = false;
            boolean upperSide = false;
            boolean rightSide = false;
            boolean bottomSide = false;

            for (Integer index : is) {
                if (distX(E,F,index,0) <= D) {
                    leftSide = true;
                }

                if (distX(E,F,index,A) <= D) {
                    rightSide = true;
                }

                if (distY(E,F,index,0) <= D) {
                    bottomSide = true;
                }

                if (distY(E,F,index,B) <= D) {
                    upperSide = true;
                }
            }

            if ((leftSide && bottomSide) || (upperSide && bottomSide) || (upperSide && rightSide) || (leftSide && rightSide)) {
                return "NO";
            }
        }

        return "YES";
    }

    private int dist(ArrayList<Integer> E, ArrayList<Integer> F, int i, int j) {
        int xi = E.get(i);
        int yi = F.get(i);

        int xj = E.get(j);
        int yj = F.get(j);

        return (int)(Math.sqrt(Math.pow((xi-xj), 2) + Math.pow((yi-yj), 2)));
    }

    private int distX(ArrayList<Integer> E, ArrayList<Integer> F, int index, int x) {
        int xi = E.get(index);
        int yi = F.get(index);

        int xj = x;
        int yj = yi;

        return (int)(Math.sqrt(Math.pow((xi-xj), 2) + Math.pow((yi-yj), 2)));
    }

    private int distY(ArrayList<Integer> E, ArrayList<Integer> F, int index, int y) {
        int xi = E.get(index);
        int yi = F.get(index);

        int xj = xi;
        int yj = y;

        return (int)(Math.sqrt(Math.pow((xi-xj), 2) + Math.pow((yi-yj), 2)));
    }
}
