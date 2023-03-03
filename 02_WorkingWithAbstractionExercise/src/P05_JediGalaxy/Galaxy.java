package P05_JediGalaxy;

public class Galaxy {
    private int[][] galaxyMatrix;
    public int rowLength;
    public int columLenght;

    public Galaxy(int[][] galaxyMatrix) {
        this.galaxyMatrix = galaxyMatrix;
        this.rowLength = this.galaxyMatrix.length;
        this.columLenght = this.galaxyMatrix[1].length;
        fillGalaxyMatrix();
    }

    private void fillGalaxyMatrix() {
        int value = 0;
        for (int i = 0; i < this.rowLength; i++) {
            for (int j = 0; j < this.columLenght; j++) {
                this.galaxyMatrix[i][j] = value++;
            }
        }
    }

    public void moveEvil(Coordinates coordinates) {
        while (evilCanMove(coordinates.row, coordinates.col)) {
            if (coordinateIsInside(coordinates.row, coordinates.col)) {
                this.galaxyMatrix[coordinates.row][coordinates.col] = 0;
            }
            coordinates.row--;
            coordinates.col--;
        }
    }

    private boolean evilCanMove(int row, int col) {
        return row >= 0 && col >= 0;
    }

    private boolean coordinateIsInside(int row, int col) {
        return row >= 0 && row < this.rowLength && col >= 0 && col < this.columLenght;
    }

    public long moveJediAndCollectStars(Coordinates coordinates) {
        long sum = 0;
        while (jediCanMove(coordinates.row, coordinates.col)) {
            if (coordinateIsInside(coordinates.row, coordinates.col)) {
                sum += this.galaxyMatrix[coordinates.row][coordinates.col];
            }
            coordinates.col++;
            coordinates.row--;
        }
        return sum;
    }

    private boolean jediCanMove(int row, int col) {
        return row >= 0 && col < this.columLenght;
    }
}
