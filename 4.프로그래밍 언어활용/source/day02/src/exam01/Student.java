    package exam01;

    public class Student {
        int id; // 학번
        String name; // 이름
        String subject; // 과목

        public Student() {
            id = 1000;
            name = "dldlfma";
            subject = "JAVA";
        }

        public Student(int _id, String _name, String _subject) { // 기본생성자 default 생성자
            id = _id;
            name = _name;
            subject = _subject;


                        // 기능적으로 제한되어있다.
                        //객체가 생성된 이후 실행 코드 가 여기에 정의됨.
                        // 실행시점 id,name,subject에 공간을 할당 받은 상태
                        // 반환값을 넣으면 주소값을 반환할 수 없기때문에 정의할 수 없음
                        //인스턴스 변수의 초기화작업을 주로 수행한다.
            //id = 1000;
            //name = "naname";
            //subject = "JAVA";
            //System.out.println("객체 생성 이후 실행");

        }

        void study() {
            System.out.printf("학번:%d, %s가 %s를 공부한다.%n",id, name, subject);
        }
    }







