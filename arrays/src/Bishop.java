public class Bishop extends ChessPiece {
    @Override
    public boolean canMove(Coordinates to) {
        return Math.abs(to.x - this.position.x) == Math.abs(to.y - this.position.y);
    }
}