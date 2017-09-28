package project.spaceinvader;

public class ShotEntity extends Entity {
        private double moveSpeed = -300;
        private Game game;
        private boolean used = false;
        private HighScore highScore;

        public ShotEntity(Game game, String sprite, int x, int y) {
                super(sprite, x, y);
                this.game = game;
                dy = moveSpeed;
        }

        public void move(long delta) {
                super.move(delta);
                if (y < -50) {
                        game.removeEntity(this);
                }
        }

        public void collidedWith(Entity other) {
                if (used) {
                        return;
                }
                if (other instanceof UFOEntity) {
                        game.removeEntity(this);
                        game.removeEntity(other);
                        game.notifyUFOKilled();
                        game.score++;
                        highScore.Write(game.score);
                        used = true;
                }
        }
}
