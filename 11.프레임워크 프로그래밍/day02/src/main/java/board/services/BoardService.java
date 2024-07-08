package board.services;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements InitializingBean, DisposableBean {
    // 이미 정해저 있는 필수적으로 사용해야하는 메서드쓰기위해 추상메서드를 쓴다? yes or no
    // 내가 만든 클래스만 된다. 여기서부터는 다시 이해해야한다.
    // 내가 만든것보다 외부에서 가져온 클래스가 더 많을거다.


    @Override
    public void destroy() throws Exception {
        System.out.println("destroy()!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet()!");
    }

    public void write() {
        System.out.println("글쓰기!");
    }
}
