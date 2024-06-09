package Practice;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate() {}

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDay(int day) {
        if(month == 2) {
            if(day < 1 || day >28) {
                System.out.println("오류입니다.");
            } else {
                this.day = day;
            }
        }
    }

    public void setMonth(int month) {
        if(month >13 || month < 1) {
            System.out.println("오류입니다.");
        } else {
            this.month = month;
        }
    }

    public void setYear(int year) {
        if(year<0 || year > 2024) {
            System.out.println("오류입니다.");
        } else {
            this.year = year;
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isValid() {
        if (month ==2 && day < 1 || day >28 ) {
                System.out.println("유효하지 않은 날짜입니다.");
            } else {
                System.out.println("유효한 날짜입니다.");}
        return true;
    }

}
