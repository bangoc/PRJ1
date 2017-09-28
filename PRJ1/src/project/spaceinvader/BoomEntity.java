package project.spaceinvader;

public class BoomEntity extends Entity {
        private Game game;
        private boolean used = false;
        private double moveSpeed = 100;

        public BoomEntity(Game game, String sprite, int x, int y) {
                super(sprite, x, y);
                this.game = game;
                dy = moveSpeed;
        }

        public void move(long delta) {
                super.move(delta);
                if (y > 650) {
                        game.removeEntity(this);
                }
        }

        public void collidedWith(Entity other) {
                if (used) {
                        return;
                }
                if (other instanceof ShipEntity) {
                        game.gameOver();
                        game.gameRunning = false;
                        used = true;
                }
        }
}
