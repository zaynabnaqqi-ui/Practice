class Date {
    private int month;
    private int day;
    private int year;

    public Date(int d, int m ,int y) {
        month = m;
        day = d;
        year = y;
    }
    public void setMonth(int m) { month = m; }
    public void setDay(int d) { day = d; }
    public void setYear(int y) { year = y; }

    public int getMonth() { return month; }
    public int getDay() { return day; }
    public int getYear() { return year; }

    public void displayDate() {
        System.out.println(day + "/" + month + "/" + year);
    }
}
public class DateDisplay {
    public static void main(String[] args) {
        Date date = new Date(6, 12, 2006);
        date.displayDate();
    }
}
