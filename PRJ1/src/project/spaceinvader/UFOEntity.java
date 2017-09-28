package project.spaceinvader;

public class UFOEntity extends Entity {
        private double movespeed = 100;
        private Game game;

        public UFOEntity(Game game, String ref, int x, int y) {
                super(ref, x, y);
                this.game = game;
                dx = -movespeed;
        }

        public void move(long delta) {
                if ((dx < 0) && (x < 10)) {
                        game.updateLogic();
                }
                if ((dx > 0) && (x > 750)) {
                        game.updateLogic();
                }
                super.move(delta);
        }

        public void doLogic() {
                dx = -dx;
                y += 15;
                if (y > 570) {
                        game.gameRunning = false;
                }
        }

        public void collidedWith(Entity other) {
        }
}
