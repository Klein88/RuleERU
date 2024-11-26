package zjc.edu.util;

public class SpinnerStateManager {
    private static SpinnerStateManager instance;
    private int lastSelectedPosition_to = 0;
    private int lastSelectedPosition_from = 0;

    private SpinnerStateManager() {
        // 私有构造函数，防止外部实例化
    }

    public static SpinnerStateManager getInstance() {
        if (instance == null) {
            instance = new SpinnerStateManager();
        }
        return instance;
    }

    public int getLastSelectedPosition_to() {
        return lastSelectedPosition_to;
    }

    public void setLastSelectedPosition_to(int lastSelectedPosition_to) {
        this.lastSelectedPosition_to = lastSelectedPosition_to;
    }

    public int getLastSelectedPosition_from() {
        return lastSelectedPosition_from;
    }

    public void setLastSelectedPosition_from(int lastSelectedPosition_from) {
        this.lastSelectedPosition_from = lastSelectedPosition_from;
    }
}
