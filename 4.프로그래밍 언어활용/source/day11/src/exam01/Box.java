package exam01;
//T는 Fruit의 하위클래스로 현을 한정했다.
public class Box<T extends Fruit & Eatable> {
    private T item;

//상위클래스가 Fruit임을 알 수 있다

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public String toString() {
        // T == Fruit
        // item.get()
        return item.get();
    }
}

// 컴파일 시점에는 자료형이 명확하게 결정되어 있어야 컴파일 가능
// <T> : 형식상 오류이다. 컴파일 시점에서 오류 이것을 해결하기 위해서 지네릭 타입은 모두 제거된다.
//