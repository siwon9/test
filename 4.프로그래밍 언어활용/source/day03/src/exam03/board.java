package exam03;

public class board {

    private board instance = new board();

    private static board() {
        public board getInstance() {
            return instance;
        }
    }
}
